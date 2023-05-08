package es.caib.evidenciesib.back.controller.user;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.fundaciobit.apisib.apifirmasimple.v1.ApiFirmaEnServidorSimple;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleCommonInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFile;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFileInfoSignature;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignDocumentRequest;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignatureResult;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignedFileInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleStatus;
import org.fundaciobit.apisib.apifirmasimple.v1.jersey.ApiFirmaEnServidorSimpleJersey;
import org.fundaciobit.apisib.core.exceptions.AbstractApisIBException;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.userinformation.UserInfo;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.webdb.EvidenciaController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.back.security.LoginInfo;
import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = EvidenciaUserController.CONTEXT_WEB)
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
public class EvidenciaUserController extends EvidenciaController {

    public static final String CONTEXT_WEB = "/user/evidencia";

    @Override
    public String getTileForm() {
        return "evidenciaFormUser";
    }

    @Override
    public String getTileList() {
        return "evidenciaListUser";
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "EvidenciaUser_FilterForm";
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        return Where.AND(USUARIPERSONA.equal(request.getRemoteUser()), USUARIAPLICACIO.isNull());
    }

    @Override
    public EvidenciaFilterForm getEvidenciaFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EvidenciaFilterForm evidenciaFilterForm = super.getEvidenciaFilterForm(pagina, mav, request);

        if (evidenciaFilterForm.isNou()) {
            Set<Field<?>> hidden = new HashSet<Field<?>>(Arrays.asList(EvidenciaFields.ALL_EVIDENCIA_FIELDS));

            hidden.remove(NOM);
            hidden.remove(DATAINICI);
            hidden.remove(DATAFI);
            hidden.remove(ESTATCODI);
            hidden.remove(FITXERSIGNATID);

            evidenciaFilterForm.setHiddenFields(hidden);

            evidenciaFilterForm.setDeleteSelectedButtonVisible(false);
            evidenciaFilterForm.setVisibleMultipleSelection(false);
            evidenciaFilterForm.setEditButtonVisible(false);
            evidenciaFilterForm.setViewButtonVisible(true);
            //evidenciaFilterForm.addAdditionalButtonForEachItem(new AdditionalButton("", text, link, type));

        }

        return evidenciaFilterForm;
    }

    @Override
    public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EvidenciaForm evidenciaForm = super.getEvidenciaForm(_jpa, __isView, request, mav);

        if (evidenciaForm.isNou()) {
            EvidenciaJPA evi = evidenciaForm.getEvidencia();

            evi.setNom(I18NUtils.tradueix("evidencia.evidencia") + "_" + System.currentTimeMillis());

            // XYZ ZZZ Falten Dades de UserInformation
            {
                UserInfo user = LoginInfo.getInstance().getUserInfo();

                evi.setPersonaEmail(user.getEmail());
                evi.setPersonaLlinatge1(user.getSurname1());
                evi.setPersonaLlinatge2(user.getSurname2());
                evi.setPersonaMobil(user.getPhoneNumber());
                evi.setPersonaNif(user.getAdministrationID());
                evi.setPersonaNom(user.getName());

                evidenciaForm.addReadOnlyField(PERSONAEMAIL);
                evidenciaForm.addReadOnlyField(PERSONALLINATGE1);
                evidenciaForm.addReadOnlyField(PERSONALLINATGE2);
                evidenciaForm.addReadOnlyField(PERSONAMOBIL);
                evidenciaForm.addReadOnlyField(PERSONANIF);
                evidenciaForm.addReadOnlyField(PERSONANOM);
            }

            evi.setDataInici(new Timestamp(System.currentTimeMillis()));
            evi.setUsuariPersona(request.getRemoteUser());
            evi.setUsuariAplicacio(null);
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES);
            evi.setLoginType(Constants.EVIDENCIA_TIPUS_LOGIN_SERVIDOR);
            evi.setLoginId(request.getRemoteUser());

            evidenciaForm.addHiddenField(FITXERADAPTATID);
            evidenciaForm.addHiddenField(FITXERSIGNATID);
            evidenciaForm.addHiddenField(DATAINICI);
            evidenciaForm.addHiddenField(DATAFI);
            evidenciaForm.addHiddenField(USUARIAPLICACIO);
            evidenciaForm.addHiddenField(USUARIPERSONA);

            evidenciaForm.addHiddenField(ESTATCODI);
            evidenciaForm.addHiddenField(ESTATERROR);
            evidenciaForm.addHiddenField(ESTATEXCEPCIO);

            evidenciaForm.addHiddenField(LOGINDATA);
            evidenciaForm.addHiddenField(LOGINTYPE);
            evidenciaForm.addHiddenField(LOGINID);

            evidenciaForm.setAttachedAdditionalJspCode(true);

        } else if (__isView) {

            evidenciaForm.addHiddenField(FITXERADAPTATID);
            evidenciaForm.addHiddenField(USUARIAPLICACIO);

            EvidenciaJPA evi = evidenciaForm.getEvidencia();

            if (evi.getEstatCodi() == Constants.EVIDENCIA_ESTAT_CODI_ERROR) {
                evidenciaForm.addHiddenField(FITXERSIGNATID);
            } else {
                evidenciaForm.addHiddenField(ESTATERROR);
                evidenciaForm.addHiddenField(ESTATEXCEPCIO);
            }

            if (evi.getLoginData() == null) {
                evidenciaForm.addHiddenField(LOGINDATA);
            }

            if (evi.getPersonaMobil() == null) {
                evidenciaForm.addHiddenField(PERSONAMOBIL);
            }

        }

        return evidenciaForm;
    }

    @Override
    public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        // TODO XYZ ZZZ Traduir
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_ERROR), "ERROR"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES), "EN_PROCES"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT), "SIGNAT"));

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForLoginType(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        // TODO XYZ ZZZ Traduir
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_DESCONEGUT), "DESCONEGUT"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_CLAVE), "CLAVE"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_SERVIDOR), "USUARI_CONTRASENYA"));

        return __tmp;
    }

    @Override
    public EvidenciaJPA create(HttpServletRequest request, EvidenciaJPA evidencia)
            throws I18NException, I18NValidationException {

        EvidenciaJPA evi = super.create(request, evidencia);

        try {

            FirmaSimpleSignatureResult fullResults = internalSignDocument(evi);

            System.err.println("  RESULT: OK");
            printSignatureInfo(fullResults);

            FirmaSimpleFile fsf = fullResults.getSignedFile();

            byte[] data = fsf.getData();

            Fitxer fitxer = fitxerEjb.create(fsf.getNom(), fsf.getMime(), data.length, "");
            FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

            evi.setFitxerSignatID(fitxer.getFitxerID());

            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT);

            // TODO XYZ ZZZ
            HtmlUtils.saveMessageSuccess(request, "Generada Correctament l'evidència !!!");

        } catch (I18NException th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = I18NUtils.getMessage(th);
            evi.setEstatError(msg);
            if (evi.getEstatExcepcio() == null) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    log.error(msg, th);
                } else {
                    log.error(msg, cause);
                    evi.setEstatExcepcio(ExceptionUtils.getStackTrace(cause));
                }
            }

            HtmlUtils.saveMessageError(request, msg);

        } catch (Throwable th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = "Error no controllat signant document: " + th.getMessage();
            evi.setEstatError(msg);
            if (th.getCause() != null) {
                evi.setEstatExcepcio(ExceptionUtils.getStackTrace(th));
            }
            log.error(msg, th);

            HtmlUtils.saveMessageError(request, msg);
        }

        evi.setDataFi(new Timestamp(System.currentTimeMillis()));
        this.evidenciaEjb.update(evi);

        return evi;
    }

    /**
     * 
     * @param evi
     * @return
     * @throws I18NException
     */
    protected FirmaSimpleSignatureResult internalSignDocument(EvidenciaJPA evi) throws I18NException {

        FirmaSimpleFile fileToSign;

        try {

            // TODO XYZ Attach Document XML to PDF

            Fitxer fitxer = evi.getFitxerOriginal();
            fileToSign = new FirmaSimpleFile(fitxer.getNom(), fitxer.getMime(),
                    FileSystemManager.getFileContent(fitxer.getFitxerID()));
        } catch (IOException e) {
            // TODO XYZ ZZZ
            String msg = "Error llegint el fitxer a signar: " + e.getMessage();
            log.error(msg, e);
            throw new I18NException(e, "genapp.comodi", new I18NArgumentString(msg));
        }

        final String signID = "1";
        final String name = fileToSign.getNom();
        final String reason = evi.getFirmaReason();
        final String location = evi.getLocalitzacioCiutat();

        final int signNumber = 1;

        // XYZ ZZZ
        final String languageSign = evi.getFirmaIdiomaDocument();

        // XYZ ZZZ
        final long tipusDocumentalID = evi.getFirmaTipusDocumental(); // =TD99

        FirmaSimpleFileInfoSignature fileInfoSignature = new FirmaSimpleFileInfoSignature(fileToSign, signID, name,
                reason, location, signNumber, languageSign, tipusDocumentalID);

        final String languageUI = LocaleContextHolder.getLocale().getLanguage();

        // Es la configuració del Servidor (deixam el valor per defecte)
        final String certificat = null;

        final String perfil = Configuracio.getApiFirmaEnServidorProfile();
        FirmaSimpleCommonInfo commonInfo;
        commonInfo = new FirmaSimpleCommonInfo(perfil, languageUI, certificat, evi.getPersonaNif(),
                evi.getPersonaEmail());

        FirmaSimpleSignDocumentRequest signature;
        signature = new FirmaSimpleSignDocumentRequest(commonInfo, fileInfoSignature);

        ApiFirmaEnServidorSimple api = new ApiFirmaEnServidorSimpleJersey(Configuracio.getApiFirmaEnServidorUrl(),
                Configuracio.getApiFirmaEnServidorUsername(), Configuracio.getApiFirmaEnServidorPassword());

        FirmaSimpleSignatureResult fullResults;
        try {
            fullResults = api.signDocument(signature);
        } catch (AbstractApisIBException e) {
            // TODO XYZ ZZZ
            String msg = "Error signant el fitxer: " + e.getMessage() + "(" + e.getDescription() + ")";
            throw new I18NException(e, "genapp.comodi", new I18NArgumentString(msg));
        }

        FirmaSimpleStatus transactionStatus = fullResults.getStatus();

        int status = transactionStatus.getStatus();

        switch (status) {

            case FirmaSimpleStatus.STATUS_INITIALIZING: // = 0;
            {
                // TODO XYZ ZZZ
                String msg = "L'estat del procés de firma ha tornat el control però encara està en estat INICIALITZANT";
                throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
            }

            case FirmaSimpleStatus.STATUS_IN_PROGRESS: // = 1;
            {
                // TODO XYZ ZZZ
                String msg = "L'estat del procés de firma ha tornat el control però encara està en estat EN PROGRESS";
                throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
            }

            case FirmaSimpleStatus.STATUS_FINAL_ERROR: // = -1;
            {
                final String msg = "Error durant la realització de les firmes: " + transactionStatus.getErrorMessage();
                String desc = transactionStatus.getErrorStackTrace();
                if (desc != null) {
                    evi.setEstatError(desc);
                }
                throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
            }

            case FirmaSimpleStatus.STATUS_CANCELLED: // = -2;
            {
                // TODO XYZ ZZZ
                String msg = "El procés de firma ha tornat el control amb estat CANCEL·LAT";
                throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
            }

            case FirmaSimpleStatus.STATUS_FINAL_OK: // = 2;
            {
                return fullResults;

            } // Final Case Firma OK
        } // Final Switch Firma

        return null;
    }

    protected void printSignatureInfo(FirmaSimpleSignatureResult fssr) {
        // TODO  XYZ ZZZ
        log.info(FirmaSimpleSignedFileInfo.toString(fssr.getSignedFileInfo()));
    }

    @Override
    public List<StringKeyValue> getReferenceListForFirmaTipusDocumental(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {

        // TODO  XYZ ZZZ DADES DE PORTAFIB

        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("1", "Document de decisió de tipus Resolució"));
        __tmp.add(new StringKeyValue("2", "Document de decisió de tipus Acord"));
        __tmp.add(new StringKeyValue("3", "Document de decisió de tipus Contracte"));
        __tmp.add(new StringKeyValue("4", "Document de decisió de tipus Conveni"));
        __tmp.add(new StringKeyValue("5", "Document de decisió de tipus Declaració"));
        __tmp.add(new StringKeyValue("6", "Document de transmissió de tipus Comunicació"));
        __tmp.add(new StringKeyValue("7", "Document de transmissió de tipus Notificació"));
        __tmp.add(new StringKeyValue("8", "Document de transmissió de tipus Publicació"));
        __tmp.add(new StringKeyValue("9", "Document de transmissió de tipus Justificant de recepció"));
        __tmp.add(new StringKeyValue("10", "Document de constància de tipus Acta"));
        __tmp.add(new StringKeyValue("11", "Document de constància de tipus Certificat"));
        __tmp.add(new StringKeyValue("12", "Document de constància de tipus Diligència"));
        __tmp.add(new StringKeyValue("13", "Document de judici de tipus Informe"));
        __tmp.add(new StringKeyValue("14", "Document de ciutadà de tipus Sol.licitud"));
        __tmp.add(new StringKeyValue("15", "Document de ciutadà de tipus Denúncia"));
        __tmp.add(new StringKeyValue("16", "Document de ciutadà de tipus Al.legació"));
        __tmp.add(new StringKeyValue("17", "Document de ciutadà de tipus Recurs"));
        __tmp.add(new StringKeyValue("18", "Document de ciutadà de tipus Comunicació al ciudadà"));
        __tmp.add(new StringKeyValue("19", "Document de ciutadà de tipus Factura"));
        __tmp.add(new StringKeyValue("20", "Document de ciutadà de tipus Altres confiscats"));
        __tmp.add(new StringKeyValue("51", "TD51 - Llei."));
        __tmp.add(new StringKeyValue("52", "TD52 - Moció"));
        __tmp.add(new StringKeyValue("53", "TD53 - Instrucció."));
        __tmp.add(new StringKeyValue("54", "TD54 - Convocatòria."));
        __tmp.add(new StringKeyValue("55", "TD55 - Ordre del dia."));
        __tmp.add(new StringKeyValue("56", "TD56 - Informe de Ponència."));
        __tmp.add(new StringKeyValue("57", "TD57 - Dictamen de Comissió."));
        __tmp.add(new StringKeyValue("58", "TD58 - Iniciativa legislativa."));
        __tmp.add(new StringKeyValue("59", "TD59 - Pregunta."));
        __tmp.add(new StringKeyValue("60", "TD60 - Interpel·lació."));
        __tmp.add(new StringKeyValue("61", "TD61 - Resposta."));
        __tmp.add(new StringKeyValue("62", "TD62 - Proposició no de llei."));
        __tmp.add(new StringKeyValue("63", "TD63 - Esmena."));
        __tmp.add(new StringKeyValue("64", "TD64 - Proposta de resolució."));
        __tmp.add(new StringKeyValue("65", "TD65 - Compareixença."));
        __tmp.add(new StringKeyValue("66", "TD66 - Sol·licitud d´informació."));
        __tmp.add(new StringKeyValue("67", "TD67 - Escrit."));
        __tmp.add(new StringKeyValue("68", "TD68 - Iniciativa legislativa."));
        __tmp.add(new StringKeyValue("69", "TD69 - Petició."));
        __tmp.add(new StringKeyValue("99", "Altres tipus de documents"));
        return __tmp;
    }

    public List<StringKeyValue> getReferenceListForFirmaIdiomaDocument(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        // TODO XYZ ZZZ   Traduir

        __tmp.add(new StringKeyValue("es", "Castellà"));
        __tmp.add(new StringKeyValue("ca", "Català"));
        __tmp.add(new StringKeyValue("ga", "Gallec"));
        __tmp.add(new StringKeyValue("eu", "Euskera"));
        return __tmp;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return true;
    }

}
