package es.caib.evidenciesib.back.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = EvidenciaAdminController.CONTEXT_WEB)
@SessionAttributes(types = { EvidenciaForm.class, EvidenciaFilterForm.class })
public class EvidenciaAdminController extends EvidenciaUserController {

    
    public static final String CONTEXT_WEB = "/admin/evidencia";
    
    
    @Override
    public boolean isAdmin() {
        return true;
    }
    
    @Override
    public String getTileForm() {
        return "evidenciaFormAdmin";
    }

    @Override
    public String getTileList() {
        return "evidenciaListAdmin";
    }
    
    
    
}
