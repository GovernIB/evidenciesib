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
import org.springframework.web.servlet.view.RedirectView;

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
                evidenciaFilterForm
                        .addAdditionalButton(new AdditionalButton(IconUtils.ICON_PLUS_SIGN, "evidencia.crear",
                                getContextWeb() + "/new?tipusLogin=" + Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN,
                                "btn-success"));
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
            /*if (tipusLogin == Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK) {

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

            } else */ if (tipusLogin == Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN) {

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
        //__tmp.add(new StringKeyValue(String.valueOf(Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK),
        //        "Autenticació BACK"));

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
                // TODO XYZ ZZZ
                String msg = "Error actualitzant l'evidència despres de signar el document: " + I18NUtils.getMessage(e);
                log.error(msg, e);
                HtmlUtils.saveMessageError(request, msg);
            }

            
            String url =  Configuracio.getBackUrl() + "/public/evidencia/"  + HibernateFileUtil.encryptFileID(evi.getEvidenciaID());
            
            final String languageUI = LocaleContextHolder.getLocale().getLanguage();

            evi = this.evidenciaLogicaEjb.createAdaptedFileAndSignDocument(evi, languageUI, url);

            messagesInternalSignDocument(request, evi);

            return "redirect:" + getContextWeb() + "/list";
            

        } else  */ {
            // Hem d'anar a FRONT per autenticació Cl@ve o Mock            

            // XYZ ZZZ ZZZ
            final String urlfront = Configuracio.getFrontUrl();

            return "redirect:" + urlfront + Constants.MAPPING_FRONT_LOGIN_START + "/" + evi.getEvidenciaID();
        }

    }

    protected void messagesInternalSignDocument(HttpServletRequest request, EvidenciaJPA evi) {
        if (evi.getUsuariPersona() != null) {
            String error = evi.getEstatError();
            if (error == null) {            
                // TODO XYZ ZZZ
                HtmlUtils.saveMessageSuccess(request, "Generada Correctament l'evidència !!!");
            } else {
    
                HtmlUtils.deleteMessages(request);
                HtmlUtils.saveMessageError(request, error);
            }
        }
    }

    @RequestMapping(value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE_SIGN_OPERATION + "{evidenciaID}", method = RequestMethod.GET)
    public String signEvidenciaRequest(@PathVariable("evidenciaID") java.lang.Long evidenciaID,
            HttpServletRequest request, HttpServletResponse response) throws I18NException {

        EvidenciaJPA evi = findByPrimaryKey(request, evidenciaID);

        // AQUEST IDIOMA HA DE SER EL QUE DIGUI EVIDENCIA 
        final String languageUI = LocaleContextHolder.getLocale().getLanguage();
        
        String url =  Configuracio.getBackUrl() + Constants.MAPPING_BACK_PUBLIC_EVIDENCE + Constants.MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION  + HibernateFileUtil.encryptFileID(evi.getEvidenciaID());

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
