package es.caib.evidenciesib.back.controller.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.i18n.I18NTranslation;
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

import es.caib.evidenciesib.back.controller.webdb.EvidenciaController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.back.security.LoginInfo;
import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.logic.EvidenciaLogicaService;
import es.caib.evidenciesib.model.entity.Evidencia;
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

            hidden.remove(EVIDENCIAID);
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
                        "evidencia.crear", getContextWeb() + "/new", "btn-success"));
            }

            evidenciaFilterForm.addLabel(ESTATCODI, "estatcodi.label");

        }

        return evidenciaFilterForm;
    }

    @Override
    public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EvidenciaForm evidenciaForm = super.getEvidenciaForm(_jpa, __isView, request, mav);

        if (evidenciaForm.isNou()) {

            EvidenciaJPA evi = evidenciaForm.getEvidencia();

            // Valors Comuns
            UserInfo user = LoginInfo.getInstance().getUserInfo();

            evi.setPersonaNif(user.getAdministrationID());
            evi.setPersonaUsername(user.getUsername());

            evi.setPersonaNom(user.getName());
            evi.setPersonaLlinatge1(user.getSurname1());
            evi.setPersonaLlinatge2(user.getSurname2());
            evi.setNom(I18NUtils.tradueix("evidencia.evidencia") + "_" + System.currentTimeMillis());

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

            EvidenciaJPA evi = evidenciaForm.getEvidencia();

            if (evi.getEstatCodi() == Constants.EVIDENCIA_ESTAT_CODI_ERROR) {
                evidenciaForm.addHiddenField(FITXERSIGNATID);

                if (evi.getLoginType() == null) {
                    evidenciaForm.addHiddenField(LOGINTYPE);
                }
                if (evi.getLoginSubtype() == null) {
                    evidenciaForm.addHiddenField(LOGINSUBTYPE);
                }
                if (evi.getLoginAuthMethod() == null) {
                    evidenciaForm.addHiddenField(LOGINAUTHMETHOD);
                }
                if (evi.getLoginQaa() == null) {
                    evidenciaForm.addHiddenField(LOGINQAA);
                }
                if (evi.getLoginId() == null) {
                    evidenciaForm.addHiddenField(LOGINID);
                }
                if (evi.getLoginData() == null) {
                    evidenciaForm.addHiddenField(LOGINDATA);
                }
                if (evi.getLoginAdditionalProperties() == null) {
                    evidenciaForm.addHiddenField(LOGINADDITIONALPROPERTIES);
                }
                if (evi.getLocalitzacioIp() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOIP);
                }
                if (evi.getLocalitzacioCodiPostal() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOCODIPOSTAL);
                }
                if (evi.getLocalitzacioLatitud() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOLATITUD);
                }
                if (evi.getLocalitzacioLongitud() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOLONGITUD);
                }
                if (evi.getLocalitzacioRegio() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOREGIO);
                }
                if (evi.getLocalitzacioCiutat() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOCIUTAT);
                }
                if (evi.getLocalitzacioPais() == null) {
                    evidenciaForm.addHiddenField(LOCALITZACIOPAIS);
                }
                if (evi.getDeviceProperties() == null) {
                    evidenciaForm.addHiddenField(DEVICEPROPERTIES);
                }
                if (evi.getClickProperties() == null) {
                    evidenciaForm.addHiddenField(CLICKPROPERTIES);
                }
                if (evi.getFirmaReason() == null) {
                    evidenciaForm.addHiddenField(FIRMAREASON);
                }
                if (evi.getFirmaIdiomaDocument() == null) {
                    evidenciaForm.addHiddenField(FIRMAIDIOMADOCUMENT);
                }

                if (evi.getFitxerAdaptatID() == null) {
                    evidenciaForm.addHiddenField(FITXERADAPTATID);
                }
                if (evi.getFitxerSignatID() == null) {
                    evidenciaForm.addHiddenField(FITXERSIGNATID);
                }

            } else {
                evidenciaForm.addHiddenField(ESTATERROR);
                evidenciaForm.addHiddenField(ESTATEXCEPCIO);

            }

            if (evi.getPersonaMobil() == null) {
                evidenciaForm.addHiddenField(PERSONAMOBIL);
            }

            if (isAdmin()) {
                evidenciaForm.addHiddenField(USUARIPERSONA);
            } else {
                evidenciaForm.addHiddenField(USUARIAPLICACIO);
                evidenciaForm.addHiddenField(CALLBACKURL);
            }

        }

        return evidenciaForm;
    }

    public static void main(String[] args) {

        for (Field<?> field : ALL_EVIDENCIA_FIELDS) {
            System.out.println(" if (evi.get" + Character.toUpperCase(field.getJavaName().charAt(0))
                    + field.getJavaName().substring(1) + "() == null) {\r\n" + "   evidenciaForm.addHiddenField("
                    + field.getJavaName().toUpperCase() + ");\r\n" + "}");
        }

    }

    @Override
    public List<StringKeyValue> getReferenceListForEstatCodi(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_ERROR),
                I18NUtils.tradueix("EVIDENCIA_ESTAT_CODI_ERROR")));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO),
                I18NUtils.tradueix("EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO")));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN),
                I18NUtils.tradueix("EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN")));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA),
                I18NUtils.tradueix("EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA")));
        __tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT),
                I18NUtils.tradueix("EVIDENCIA_ESTAT_CODI_SIGNAT")));

        return __tmp;
    }

    @Override
    public String getRedirectWhenCreated(HttpServletRequest request, EvidenciaForm evidenciaForm) {

        EvidenciaJPA evi = evidenciaForm.getEvidencia();

        /*
        if (evidenciaForm.getEvidencia().getLoginType() == Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK) {
            
            
            // ja podem anara a signar
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA);
            try {
                evidenciaEjb.update(evi);
            } catch (I18NException e) {
                
                String msg = "Error actualitzant l'evidència despres de signar el document: " + I18NUtils.getMessage(e);
                log.error(msg, e);
                HtmlUtils.saveMessageError(request, msg);
            }
        
            
            String url =  Configuracio.getBackUrl() + "/public/evidencia/"  + HibernateFileUtil.encryptFileID(evi.getEvidenciaID());
            
            final String languageUI = LocaleContextHolder.getLocale().getLanguage();
        
            evi = this.evidenciaLogicaEjb.createAdaptedFileAndSignDocument(evi, languageUI, url);
        
            messagesInternalSignDocument(request, evi);
        
            return "redirect:" + getContextWeb() + "/list";
            
        
        } else  */
        {
            // Hem d'anar a FRONT per autenticació Cl@ve o Mock            
            final String urlfront = Configuracio.getFrontUrl();
            return "redirect:" + urlfront + Constants.MAPPING_FRONT_LOGIN_START + "/" + evi.getEvidenciaID();
        }

    }

    protected void messagesInternalSignDocument(HttpServletRequest request, EvidenciaJPA evi) {
        if (evi.getUsuariPersona() != null) {
            String error = evi.getEstatError();
            if (error == null) {
                // generadaok=La evidencia se ha generado correctamente !!!
                HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("generadaok"));
            } else {
                HtmlUtils.deleteMessages(request);
                HtmlUtils.saveMessageError(request, error);
            }
        }
    }

    @RequestMapping(
            value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE_SIGN_OPERATION + "{evidenciaID}",
            method = RequestMethod.GET)
    public String signEvidenciaRequest(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
            HttpServletRequest request, HttpServletResponse response) throws I18NException {

        EvidenciaJPA evi = findByPrimaryKey(request, evidenciaID);

        // AQUEST IDIOMA HA DE SER EL QUE DIGUI EVIDENCIA 
        final String languageUI = LocaleContextHolder.getLocale().getLanguage();

        String url = Configuracio.getBackUrl() + Constants.MAPPING_BACK_PUBLIC_EVIDENCE
                + Constants.MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION
                + HibernateFileUtil.encryptFileID(evi.getEvidenciaID());

        evi = this.evidenciaLogicaEjb.createAdaptedFileAndSignDocument(evi, languageUI, url);

        messagesInternalSignDocument(request, evi);

        final String redirect = evi.getCallBackUrl().replace("{0}", String.valueOf(evi.getEvidenciaID()));

        log.info(" Callback[" + evi.getEvidenciaID() + "]  => " + redirect);

        return "redirect:" + redirect;

    }

    @Override
    public void postValidate(HttpServletRequest request, EvidenciaForm evidenciaForm, BindingResult result)
            throws I18NException {

        if (!result.hasFieldErrors(get(FITXERORIGINALID))) {

            try {

                byte[] pdf = FileSystemManager.getFileContent(evidenciaForm.getEvidencia().getFitxerOriginalID());

                this.evidenciaLogicaEjb.validatePdfForEvidencies(pdf);
            } catch (IOException io) {

                result.rejectValue(get(FITXERORIGINALID), "error.validate.pdf.reading",
                        new Object[] { io.getMessage() }, "Error llegint el PDF: " + io.getMessage());

            } catch (I18NException e) {

                I18NTranslation trans = e.getTraduccio();

                result.rejectValue(get(FITXERORIGINALID), trans.getCode(), trans.getArgs(), trans.getCode());
            }
        }
    }

    @Override
    public List<StringKeyValue> getReferenceListForFirmaTipusDocumental(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {

        // TODO   DADES DE PORTAFIB =>  Consultar tipus documentals a PortaFIB #44 

        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        if ("ca".equalsIgnoreCase(LocaleContextHolder.getLocale().getLanguage())) {

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

        } else {

            __tmp.add(new StringKeyValue("1", "Documento de decisión de tipo Resolución"));
            __tmp.add(new StringKeyValue("2", "Documento de decisión de tipo Acuerdo"));
            __tmp.add(new StringKeyValue("3", "Documento de decisión de tipo Contrato"));
            __tmp.add(new StringKeyValue("4", "Documento de decisión de tipo Convenio"));
            __tmp.add(new StringKeyValue("5", "Documento de decisión de tipo Declaración"));
            __tmp.add(new StringKeyValue("6", "Documento de transmisión de tipo Comunicación"));
            __tmp.add(new StringKeyValue("7", "Documento de transmisión de tipo Notificación"));
            __tmp.add(new StringKeyValue("8", "Documento de transmisión de tipo Publicación"));
            __tmp.add(new StringKeyValue("9", "Documento de transmisión de tipo Justificante de recepción"));
            __tmp.add(new StringKeyValue("10", "Documento de constancia de tipo Acta"));
            __tmp.add(new StringKeyValue("11", "Documento de constancia de tipo Certificado"));
            __tmp.add(new StringKeyValue("12", "Documento de constancia de tipo Diligencia"));
            __tmp.add(new StringKeyValue("13", "Documento de juicio de tipo Informe"));
            __tmp.add(new StringKeyValue("14", "Documento de ciudadano de tipo Solicitud"));
            __tmp.add(new StringKeyValue("15", "Documento de ciudadano de tipo Denuncia"));
            __tmp.add(new StringKeyValue("16", "Documento de ciudadano de tipo Alegación"));
            __tmp.add(new StringKeyValue("17", "Documento de ciudadano de tipo Recurso"));
            __tmp.add(new StringKeyValue("18", "Documento de ciudadano de tipo Comunicación al ciudadano"));
            __tmp.add(new StringKeyValue("19", "Documento de ciudadano de tipo Factura"));
            __tmp.add(new StringKeyValue("20", "Documento de ciudadano de tipo Otros incautados"));
            __tmp.add(new StringKeyValue("51", "TD51 - Ley."));
            __tmp.add(new StringKeyValue("52", "TD52 - Moción"));
            __tmp.add(new StringKeyValue("53", "TD53 - Instrucción."));
            __tmp.add(new StringKeyValue("54", "TD54 - Convocatoria."));
            __tmp.add(new StringKeyValue("55", "TD55 - Orden del día."));
            __tmp.add(new StringKeyValue("56", "TD56 - Informe de Ponencia."));
            __tmp.add(new StringKeyValue("57", "TD57 - Dictamen de Comisión."));
            __tmp.add(new StringKeyValue("58", "TD58 - Iniciativa legislativa."));
            __tmp.add(new StringKeyValue("59", "TD59 - Pregunta."));
            __tmp.add(new StringKeyValue("60", "TD60 - Interpelación."));
            __tmp.add(new StringKeyValue("61", "TD61 - Respuesta."));
            __tmp.add(new StringKeyValue("62", "TD62 - Proposición no de ley."));
            __tmp.add(new StringKeyValue("63", "TD63 - Enmienda."));
            __tmp.add(new StringKeyValue("64", "TD64 - Propuesta de resolución."));
            __tmp.add(new StringKeyValue("65", "TD65 - Comparecencia."));
            __tmp.add(new StringKeyValue("66", "TD66 - Solicitud de información."));
            __tmp.add(new StringKeyValue("67", "TD67 - Escrito."));
            __tmp.add(new StringKeyValue("68", "TD68 - Iniciativa legislativa."));
            __tmp.add(new StringKeyValue("69", "TD69 - Petición."));
            __tmp.add(new StringKeyValue("99", "Otros tipos de documentos"));

        }

        return __tmp;
    }

    @Override
    public List<StringKeyValue> getReferenceListForFirmaIdiomaDocument(HttpServletRequest request, ModelAndView mav,
            Where where) throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();

        if ("ca".equalsIgnoreCase(LocaleContextHolder.getLocale().getLanguage())) {
            __tmp.add(new StringKeyValue("es", "Castellà"));
            __tmp.add(new StringKeyValue("ca", "Català"));
            __tmp.add(new StringKeyValue("ga", "Gallec"));
            __tmp.add(new StringKeyValue("eu", "Euskera"));
        } else {
            __tmp.add(new StringKeyValue("es", "Castellano"));
            __tmp.add(new StringKeyValue("ca", "Catalán"));
            __tmp.add(new StringKeyValue("ga", "Gallego"));
            __tmp.add(new StringKeyValue("eu", "Euskera"));
        }
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

    @Override
    public List<StringKeyValue> getReferenceListForLoginQaa(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("1", I18NUtils.tradueix("qaa.1", "1")));
        __tmp.add(new StringKeyValue("2", I18NUtils.tradueix("qaa.2", "2")));
        __tmp.add(new StringKeyValue("3", I18NUtils.tradueix("qaa.3", "3")));
        __tmp.add(new StringKeyValue("4", I18NUtils.tradueix("qaa.4", "4")));
        return __tmp;
    }

}
