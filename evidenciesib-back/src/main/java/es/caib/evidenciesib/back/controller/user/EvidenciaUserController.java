package es.caib.evidenciesib.back.controller.user;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
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
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.userinformation.UserInfo;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import es.caib.evidenciesib.back.controller.webdb.EvidenciaController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.back.security.LoginInfo;
import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.commons.utils.StaticVersion;
import es.caib.evidenciesib.logic.EvidenciaLogicaService;
import es.caib.evidenciesib.model.entity.Evidencia;
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

    @EJB(mappedName = EvidenciaLogicaService.JNDI_NAME)
    protected EvidenciaLogicaService evidenciaLogicaEjb;

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
        return this.getClass().getName() + "_FilterForm";
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        if (isAdmin()) {
            return USUARIAPLICACIO.isNotNull();
        } else {
            return Where.AND(USUARIPERSONA.equal(request.getRemoteUser()), USUARIAPLICACIO.isNull());
        }
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
            if (isAdmin()) {
                hidden.remove(USUARIAPLICACIO);
            } else {

                List<Field<?>> list = evidenciaFilterForm.getDefaultGroupByFields();
                list.remove(USUARIAPLICACIO);
                evidenciaFilterForm.setGroupByFields(list);
            }

            evidenciaFilterForm.setHiddenFields(hidden);

            evidenciaFilterForm.setDeleteSelectedButtonVisible(false);
            evidenciaFilterForm.setVisibleMultipleSelection(false);
            evidenciaFilterForm.setEditButtonVisible(false);
            evidenciaFilterForm.setViewButtonVisible(true);
            evidenciaFilterForm.setAddButtonVisible(false);

            if (!isAdmin()) {

                evidenciaFilterForm.addAdditionalButton(new AdditionalButton(IconUtils.ICON_PLUS_SIGN,
                        "Crear Evidència des de Back",
                        getContextWeb() + "/new?tipusLogin=" + Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK,
                        "btn-info"));

                evidenciaFilterForm
                        .addAdditionalButton(new AdditionalButton(IconUtils.ICON_PLUS_SIGN, "Crear Evidència amb Cl@ve",
                                getContextWeb() + "/new?tipusLogin=" + Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN,
                                "btn-success"));
            }

        }

        return evidenciaFilterForm;
    }

    @Override
    public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EvidenciaForm evidenciaForm = super.getEvidenciaForm(_jpa, __isView, request, mav);

        if (evidenciaForm.isNou()) {

            String tipusLoginStr = request.getParameter("tipusLogin");
            if (tipusLoginStr == null) {
                // XYZ ZZZ
                HtmlUtils.saveMessageError(request, "No s'ha passat el parametre 'tipusLogin'");
                mav.setView(new RedirectView(getContextWeb() + "/list"));
                return evidenciaForm;
            }

            int tipusLogin;
            try {
                tipusLogin = Integer.parseInt(tipusLoginStr);
            } catch (NumberFormatException e) {
                // XYZ ZZZ
                HtmlUtils.saveMessageError(request,
                        "El parametre 'tipusLogin' ha de ser de tipus numeric (" + tipusLoginStr + ")");
                mav.setView(new RedirectView(getContextWeb() + "/list"));
                return evidenciaForm;
            }

            EvidenciaJPA evi = evidenciaForm.getEvidencia();

            // Valors Comuns
            UserInfo user = LoginInfo.getInstance().getUserInfo();
            
            evi.setPersonaNif(user.getAdministrationID());
            evi.setPersonaUsername(user.getUsername());
            
            evi.setPersonaNom(user.getName());
            evi.setPersonaLlinatge1(user.getSurname1());
            evi.setPersonaLlinatge2(user.getSurname2());
            

            // XYZ ZZZ Falten Dades de UserInformation
            if (tipusLogin == Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK) {

                evi.setPersonaEmail(user.getEmail());

                evi.setPersonaLlinatge2(user.getSurname2());
                evi.setPersonaMobil(user.getPhoneNumber());

                evidenciaForm.addReadOnlyField(PERSONAEMAIL);
                evidenciaForm.addReadOnlyField(PERSONALLINATGE1);
                evidenciaForm.addReadOnlyField(PERSONALLINATGE2);
                evidenciaForm.addReadOnlyField(PERSONAMOBIL);
                evidenciaForm.addReadOnlyField(PERSONANIF);
                evidenciaForm.addReadOnlyField(PERSONAUSERNAME);
                evidenciaForm.addReadOnlyField(PERSONANOM);

                evi.setLoginType(Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK);
                evi.setLoginId(request.getRemoteUser());
                evi.setLoginData(new Timestamp(System.currentTimeMillis()));

            } else if (tipusLogin == Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN) {

                // TODO XYZ ZZZ
                evidenciaForm.setSubTitleCode(
                        "=Després de pitjar Guardar anirà a una pàgina per autenticar-se a través de Cl@ve.");

                evidenciaForm.addHiddenField(PERSONAEMAIL);
                //evidenciaForm.addHiddenField(PERSONALLINATGE1);
                evidenciaForm.addHiddenField(PERSONALLINATGE2);
                evidenciaForm.addHiddenField(PERSONAMOBIL);
                //evidenciaForm.addHiddenField(PERSONANIF);
                //evidenciaForm.addHiddenField(PERSONANOM);
                
                evidenciaForm.addReadOnlyField(PERSONANIF);
                evidenciaForm.addReadOnlyField(PERSONAUSERNAME);

                evi.setLoginType(Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN);

            } else {
                // XYZ ZZZ
                HtmlUtils.saveMessageError(request, "El parametre 'tipusLogin' no té un valor vàlid: " + tipusLoginStr);
                mav.setView(new RedirectView(getContextWeb() + "/list"));
                return evidenciaForm;
            }

            evi.setNom(I18NUtils.tradueix("evidencia.evidencia") + "_" + System.currentTimeMillis());

            // XYZ ZZZ TODO 
            evi.setFirmaIdiomaDocument(LocaleContextHolder.getLocale().getLanguage());

            evi.setDataInici(new Timestamp(System.currentTimeMillis()));
            evi.setUsuariPersona(request.getRemoteUser());
            evi.setUsuariAplicacio(null);
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO);
            evi.setCallBackUrl(getContextWeb() + "/list");

            Set<Field<?>> hiddenFields = new HashSet<Field<?>>();

            hiddenFields.addAll(Arrays.asList(EvidenciaFields.ALL_EVIDENCIA_FIELDS));

            hiddenFields.remove(EvidenciaFields.NOM);
            hiddenFields.remove(EvidenciaFields.PERSONANOM);
            hiddenFields.remove(EvidenciaFields.PERSONALLINATGE1);
            hiddenFields.remove(EvidenciaFields.PERSONALLINATGE2);
            hiddenFields.remove(EvidenciaFields.PERSONANIF);
            hiddenFields.remove(EvidenciaFields.PERSONAUSERNAME);

            hiddenFields.remove(EvidenciaFields.FIRMAREASON);
            hiddenFields.remove(EvidenciaFields.FIRMAIDIOMADOCUMENT);
            hiddenFields.remove(EvidenciaFields.FIRMATIPUSDOCUMENTAL);
            hiddenFields.remove(EvidenciaFields.FITXERORIGINALID);

            evidenciaForm.setHiddenFields(hiddenFields);

            /*
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
            evidenciaForm.addHiddenField(LOGINSUBTYPE);
            evidenciaForm.addHiddenField(LOGINQAA);
            evidenciaForm.addHiddenField(LOGINAUTHMETHOD);
            evidenciaForm.addHiddenField(LOGINADDITIONALPROPERTIES);
            */

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
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO),
                "EN_PROCES_DE_CREACIO"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN),
                "EN_PROCES_DE_LOGIN"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA),
                "EN_PROCES_DE_FIRMA"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT), "SIGNAT"));

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForLoginType(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        // TODO XYZ ZZZ Traduir
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN),
                "PLUGIN LOGIN (Cl@ve, Mock, ...)"));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK),
                "Autenticació BACK"));

        return __tmp;
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, EvidenciaForm evidenciaForm) {

        EvidenciaJPA evi = evidenciaForm.getEvidencia();
        if (evidenciaForm.getEvidencia().getLoginType() == Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK) {
            // ja podem anara a signar
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA);
            try {
                evidenciaEjb.update(evi);
            } catch (I18NException e) {
                // TODO XYZ ZZZ
                String msg = "Error actualitzant l'evidència despres de signar el document: " + I18NUtils.getMessage(e);
                log.error(msg, e);
                HtmlUtils.saveMessageError(request, msg);
            }

            internalSignDocument(evi, request);

            messagesInternalSignDocument(request, evi);

            return "redirect:" + getContextWeb() + "/list";

        } else {
            // Hem d'anar a FRONT per autenticació Cl@ve o Mock            

            // XYZ ZZZ ZZZ
            final String urlfront = Configuracio.getFrontUrl();

            return "redirect:" + urlfront + Constants.MAPPING_FRONT_LOGIN_START + "/" + evi.getEvidenciaID();
        }

    }

    protected void messagesInternalSignDocument(HttpServletRequest request, EvidenciaJPA evi) {
        String error = evi.getEstatError();
        if (error == null) {
            // TODO XYZ ZZZ
            HtmlUtils.saveMessageSuccess(request, "Generada Correctament l'evidència !!!");
        } else {

            HtmlUtils.deleteMessages(request);
            HtmlUtils.saveMessageError(request, error);
        }
    }

    @RequestMapping(value = "/sign/{evidenciaID}", method = RequestMethod.GET)
    public String signEvidenciaRequest(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
            HttpServletRequest request, HttpServletResponse response) throws I18NException {

        EvidenciaJPA evi = findByPrimaryKey(request, evidenciaID);

        internalSignDocument(evi, request);

        final String redirect = evi.getCallBackUrl().replace("{0}", String.valueOf(evi.getEvidenciaID()));

        log.info(" Callback[" + evi.getEvidenciaID() + "]  => " + redirect);

        return "redirect:" + redirect;

    }

    /**
     * 
     * @param evi
     * @return
     * @throws I18NException
     */
    protected FirmaSimpleSignatureResult internalSignDocument(EvidenciaJPA evi, HttpServletRequest request) {

        try { // Global 
            FirmaSimpleFile fileToSign;
            try {
                Fitxer fitxerAdaptat = generarFitxerPdfAmbAnnexDeEvidencies(evi);

                // TODO XYZ Canviar Nom per Adaptat
                fileToSign = new FirmaSimpleFile(fitxerAdaptat.getNom(), fitxerAdaptat.getMime(),
                        FileSystemManager.getFileContent(fitxerAdaptat.getFitxerID()));
            } catch (DocumentException docex) {
                // TODO XYZ ZZZ
                String msg = "Error adaptant el PDF per afegir-hi annexes: " + docex.getMessage();
                log.error(msg, docex);
                throw new I18NException(docex, "genapp.comodi", new I18NArgumentString(msg));
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
                    final String msg = "Error durant la realització de les firmes: "
                            + transactionStatus.getErrorMessage();
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

                    // TODO  XYZ ZZZ
                    log.info(FirmaSimpleSignedFileInfo.toString(fullResults.getSignedFileInfo()));

                    FirmaSimpleFile fsf = fullResults.getSignedFile();

                    byte[] data = fsf.getData();

                    String newname = evi.getFitxerOriginal().getNom();
                    newname = FilenameUtils.getBaseName(newname) + "_signed." + FilenameUtils.getExtension(newname);

                    Fitxer fitxer = fitxerEjb.create(newname, fsf.getMime(), data.length, "");
                    FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

                    evi.setFitxerSignatID(fitxer.getFitxerID());

                    evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT);

                    return fullResults;

                } // Final Case Firma OK

                default: {
                    // TODO XYZ ZZZ
                    String msg = "L'estat del procés de firma ha tornat un estat desconegut amb valor " + status;
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }
            } // Final Switch Firma

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

        } catch (Throwable th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = "Error no controllat signant document: " + th.getMessage();
            evi.setEstatError(msg);
            if (th.getCause() != null) {
                evi.setEstatExcepcio(ExceptionUtils.getStackTrace(th));
            }
            log.error(msg, th);

        } finally {
            evi.setDataFi(new Timestamp(System.currentTimeMillis()));
            try {
                this.evidenciaLogicaEjb.update(evi);
            } catch (I18NException e) {
                // TODO XYZ ZZZ
                String msg = "Error actualitzant l'evidència despres de signar el document: " + I18NUtils.getMessage(e);
                log.error(msg, e);
                HtmlUtils.saveMessageError(request, msg);
            }
        }

        return null;

    }

    protected Fitxer generarFitxerPdfAmbAnnexDeEvidencies(EvidenciaJPA evi)
            throws IOException, I18NException, DocumentException {

        // TODO XYZ Attach JSON  to PDF

        // 1. Modificar Contingut del PDF
        // Llegir PDF
        File original = FileSystemManager.getFile(evi.getFitxerOriginalID());
        File fileTmp1 = File.createTempFile("evidenciesib_generarfitxeradaptat_", ".pdf");

        FileOutputStream output1 = null;
        FileInputStream readerInputStream = null;
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {

            // File input3 = null;
            readerInputStream = new FileInputStream(original);
            reader = new PdfReader(readerInputStream);

            output1 = new FileOutputStream(fileTmp1);

            stamper = new PdfStamper(reader, output1);

            // 1.3.- Attach Files

            File fileEviJson = null;
            Map<String, Object> map = new HashMap<String, Object>();
            try {
                String name = "evidencies.json";

                fileEviJson = File.createTempFile("evidenciesib_evidencies_", ".json");
                fileEviJson.deleteOnExit();

                map.put("Nom", evi.getNom());
                map.put("PersonaNom", evi.getPersonaNom());
                map.put("PersonaLlinatge1", evi.getPersonaLlinatge1());
                map.put("PersonaLlinatge2", evi.getPersonaLlinatge2());
                map.put("PersonaNif", evi.getPersonaNif());
                map.put("PersonaUsername", evi.getPersonaUsername());
                map.put("PersonaEmail", evi.getPersonaEmail());
                map.put("PersonaMobil", evi.getPersonaMobil());
                map.put("DataInici", evi.getDataInici());
                map.put("DataFi", evi.getDataFi());
                map.put("UsuariAplicacio", evi.getUsuariAplicacio());
                map.put("UsuariPersona", evi.getUsuariPersona());
                map.put("LoginType", evi.getLoginType());
                map.put("LoginId", evi.getLoginId());
                map.put("LoginData", evi.getLoginData());
                map.put("LocalitzacioIp", evi.getLocalitzacioIp());
                map.put("LocalitzacioCodiPostal", evi.getLocalitzacioCodiPostal());
                map.put("LocalitzacioLongitud", evi.getLocalitzacioLongitud());
                map.put("LocalitzacioCiutat", evi.getLocalitzacioCiutat());
                map.put("LocalitzacioLatitud", evi.getLocalitzacioLatitud());
                map.put("LocalitzacioRegio", evi.getLocalitzacioRegio());
                map.put("LocalitzacioPais", evi.getLocalitzacioPais());
                map.put("FirmaReason", evi.getFirmaReason());
                map.put("FirmaTipusDocumental", evi.getFirmaTipusDocumental());
                map.put("FirmaIdiomaDocument", evi.getFirmaIdiomaDocument());
                map.put("FirmaTipusDocumental", evi.getFirmaTipusDocumental());
                map.put("FirmaIdiomaDocument", evi.getFirmaIdiomaDocument());

                // Esborram tots els valors null !!!!
                while (map.values().remove(null))
                    ;

                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                org.apache.commons.io.FileUtils.write(fileEviJson, gson.toJson(map), StandardCharsets.UTF_8);

                PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(),
                        fileEviJson.getAbsolutePath(), name, null);

                // TODO XYZ ZZZ Traduir
                stamper.getWriter().addFileAttachment("Evidències", fs);
            } finally {
                if (fileEviJson != null) {
                    fileEviJson.delete();
                }
            }

            // Afegir versió d'EvidènciesIB
            Map<String, String> info = reader.getInfo();
            info.put("EvidenciesIB.versio", StaticVersion.VERSION);

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object val = entry.getValue();
                info.put("EvidenciesIB." + key, String.valueOf(val));
            }

            stamper.setMoreInfo(info);

        } finally {

            // 1.3.- Guardar PDF
            if (stamper != null) {
                stamper.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (readerInputStream != null) {
                readerInputStream.close();
            }

            if (output1 != null) {
                output1.flush();
                output1.close();
            }

        }

        String newname = evi.getFitxerOriginal().getNom();
        newname = FilenameUtils.getBaseName(newname) + "_adaptat." + FilenameUtils.getExtension(newname);

        Fitxer fitxerAdaptat = fitxerEjb.create(newname, evi.getFitxerOriginal().getMime(), fileTmp1.length(), "");
        FileSystemManager.crearFitxer(fileTmp1, fitxerAdaptat.getFitxerID());

        return fitxerAdaptat;

    }

    /**
     * 
     * @param pdf
     * @return Si el fitxer no és PDF llavors retorna 0.
     */
    protected int getNumberOfSignaturesInPDF(File pdf) throws I18NException {

        InputStream is = null;
        try {
            is = new FileInputStream(pdf);
            return getNumberOfSignaturesInPDF(is);
        } catch (FileNotFoundException e) {
            log.error("No s'ha trobat el fitxer " + pdf.getAbsolutePath() + ":" + e.getMessage(), e);
            throw new I18NException("fitxer.notfound", pdf.getAbsolutePath(), e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("Error tancant InputStream del fitxer " + pdf.getAbsolutePath() + ":" + e.getMessage(),
                            e);
                }
            }
        }
    }

    /**
     * 
     * @param pdfis
     * @return Si el fitxer no és PDF llavors retorna 0.
     */
    protected int getNumberOfSignaturesInPDF(InputStream pdfis) {
        try {
            PdfReader reader = new PdfReader(pdfis);
            AcroFields fields = reader.getAcroFields();
            return fields.getSignatureNames().size();
        } catch (Throwable e) {
            log.error("Error desconegut intentant obtenir numeo de firmes d'un PDF");
            return 0;
        }
    }

    @Override
    public void postValidate(HttpServletRequest request, EvidenciaForm evidenciaForm, BindingResult result)
            throws I18NException {

        if (!result.hasFieldErrors(get(FITXERORIGINALID))) {

            try {
                final int originalNumberOfSigns = getNumberOfSignaturesInPDF(
                        evidenciaForm.getFitxerOriginalID().getInputStream());

                if (originalNumberOfSigns != 0) {
                    // TODO XYZ ZZZ
                    String msg = "El PDF d'origen no pot contenir signatures, i el PDf enviat ja té "
                            + originalNumberOfSigns + " firma/firmes.";

                    result.rejectValue(get(FITXERORIGINALID), "genapp.comodi", new Object[] { msg }, msg);
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
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

    @Override
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

    @Override
    public void delete(HttpServletRequest request, Evidencia evidencia) throws I18NException {
        evidenciaEjb.deleteIncludingFiles(evidencia, this.fitxerEjb);
    }

    /**
     * 
     * @return
     */
    public boolean isAdmin() {
        return false;
    }

}
