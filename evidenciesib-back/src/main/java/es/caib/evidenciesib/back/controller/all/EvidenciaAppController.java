package es.caib.evidenciesib.back.controller.all;

import javax.annotation.security.RunAs;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = EvidenciaAppController.CONTEXT_WEB_APP)
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
@RunAs(Constants.EVI_WS)
public class EvidenciaAppController extends EvidenciaUserController {

    public static final String CONTEXT_WEB_APP = "/public/evidenciarest";
    
    
   
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

}
