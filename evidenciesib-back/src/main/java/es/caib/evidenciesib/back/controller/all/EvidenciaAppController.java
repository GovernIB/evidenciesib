package es.caib.evidenciesib.back.controller.all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.security.RunAs;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE)
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
@RunAs(Constants.EVI_WS)
public class EvidenciaAppController extends EvidenciaUserController {

    /**
     * Aqui entram de forma no autenticada, d'aqui que el mètode findByPrimaryKey() sigui PermitAll.
     */
    @Override
    public EvidenciaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long evidenciaID) throws I18NException {
        return (EvidenciaJPA) evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);
    }

    @Override
    public boolean isActiveList() {
        return false;
    }

    @Override
    public boolean isActiveFormNew() {
        return false;
    }

    @Override
    public boolean isActiveFormEdit() {
        return false;
    }

    @Override
    public boolean isActiveDelete() {
        return false;
    }

    @Override
    public boolean isActiveFormView() {
        return false;
    }

    @RequestMapping(value = Constants.MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION +  "{encriptedEvidenciaID}")
    public ModelAndView showBasicInfo(@PathVariable("encriptedEvidenciaID") String encriptedEvidenciaID,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        Long evidenciaID = HibernateFileUtil.decryptFileID(encriptedEvidenciaID);

        final boolean __isView = true;

        EvidenciaJPA evidencia = findByPrimaryKey(request, evidenciaID);

        if (evidencia == null) {
            createMessageWarning(request, "error.notfound", evidenciaID);
            new ModelAndView(new RedirectView(getRedirectWhenCancel(request, evidenciaID), true));
            return llistatPaginat(request, response, 1);
        } else {
            ModelAndView mav = new ModelAndView(getTileForm());
            EvidenciaForm evidenciaForm = getEvidenciaForm(evidencia, __isView, request, mav);
            evidenciaForm.setView(__isView);
            if (__isView) {
                evidenciaForm.setAllFieldsReadOnly(ALL_EVIDENCIA_FIELDS);
                evidenciaForm.setSaveButtonVisible(false);
                evidenciaForm.setDeleteButtonVisible(false);
            }
            fillReferencesForForm(evidenciaForm, request, mav);
            mav.addObject("evidenciaForm", evidenciaForm);
            return mav;
        }
    }

    @Override
    public EvidenciaForm getEvidenciaForm(EvidenciaJPA _jpa, boolean __isView, HttpServletRequest request,
            ModelAndView mav) throws I18NException {
        EvidenciaForm evidenciaForm = super.getEvidenciaForm(_jpa, __isView, request, mav);

        Set<Field<?>> hiddenFields = new HashSet<Field<?>>(Arrays.asList(EvidenciaFields.ALL_EVIDENCIA_FIELDS));

        hiddenFields.remove(EvidenciaFields.EVIDENCIAID);
        hiddenFields.remove(EvidenciaFields.NOM);
        hiddenFields.remove(EvidenciaFields.PERSONANIF);
        hiddenFields.remove(EvidenciaFields.PERSONAUSERNAME);
        hiddenFields.remove(EvidenciaFields.PERSONANOM);
        hiddenFields.remove(EvidenciaFields.PERSONALLINATGE1);
        hiddenFields.remove(EvidenciaFields.PERSONALLINATGE2);
        hiddenFields.remove(EvidenciaFields.PERSONAEMAIL);
        hiddenFields.remove(EvidenciaFields.PERSONAMOBIL);
        hiddenFields.remove(EvidenciaFields.DATAINICI);
        hiddenFields.remove(EvidenciaFields.DATAFI);
        hiddenFields.remove(EvidenciaFields.LOGINSUBTYPE);
        hiddenFields.remove(EvidenciaFields.LOGINQAA);
        hiddenFields.remove(EvidenciaFields.LOGINDATA);
        hiddenFields.remove(EvidenciaFields.LOGINID);
        hiddenFields.remove(EvidenciaFields.LOGINAUTHMETHOD);
        hiddenFields.remove(EvidenciaFields.LOGINADDITIONALPROPERTIES);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOIP);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOCODIPOSTAL);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOLATITUD);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOLONGITUD);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOREGIO);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOCIUTAT);
        hiddenFields.remove(EvidenciaFields.LOCALITZACIOPAIS);
        hiddenFields.remove(EvidenciaFields.FIRMAREASON);
        hiddenFields.remove(EvidenciaFields.FIRMAIDIOMADOCUMENT);
        hiddenFields.remove(EvidenciaFields.FIRMATIPUSDOCUMENTAL);
        hiddenFields.remove(EvidenciaFields.FITXERSIGNATID);

        evidenciaForm.setHiddenFields(hiddenFields);
        
        evidenciaForm.setCancelButtonVisible(false);

        return evidenciaForm;
    }
    
    
    @Override
    public String getTileForm() {
        return "evidenciaFormApp";
    }

}
