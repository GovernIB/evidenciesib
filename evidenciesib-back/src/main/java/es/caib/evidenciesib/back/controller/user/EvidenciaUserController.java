package es.caib.evidenciesib.back.controller.user;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.userinformation.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.webdb.EvidenciaController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.back.security.LoginInfo;
import es.caib.evidenciesib.commons.utils.Constants;
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
        return USUARIPERSONA.equal(request.getRemoteUser());
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
            hidden.remove(DOCUMENTFITXERID);

            evidenciaFilterForm.setHiddenFields(hidden);

            evidenciaFilterForm.setDeleteSelectedButtonVisible(false);
            evidenciaFilterForm.setVisibleMultipleSelection(false);

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

            evidenciaForm.addHiddenField(DOCUMENTHASH);
            evidenciaForm.addHiddenField(DOCUMENTMIDA);
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
}
