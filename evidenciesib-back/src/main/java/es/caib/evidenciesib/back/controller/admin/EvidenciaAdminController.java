package es.caib.evidenciesib.back.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.back.form.webdb.EvidenciaFilterForm;
import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import es.caib.evidenciesib.back.utils.Tab;

/**
 * 
 * @author anadal
 *
 */
@MenuOption(labelCode = "evidencies.aplicacio.plural", order = 1, group = Tab.MENU_ADMIN)
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

    @Override
    public String getEntityNameCode() {
        return "evidencies.aplicacio";
    }

    @Override
    public String getEntityNameCodePlural() {
        return "evidencies.aplicacio.plural";
    }

    @Override
    public EvidenciaFilterForm getEvidenciaFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        EvidenciaFilterForm evidenciaFilterForm = super.getEvidenciaFilterForm(pagina, mav, request);

        if (evidenciaFilterForm.isNou()) {
            // Afegir un boto que cridi a Tancar Peticions Obertes
            AdditionalButton additionalButton = new AdditionalButton("fas fa-broom",
                    "evidencia.netejarpeticionsobertes", getContextWeb() + "/tancarPeticionsObertes",
                    AdditionalButtonStyle.WARNING);

            evidenciaFilterForm.addAdditionalButton(additionalButton);
        }

        return evidenciaFilterForm;
    }

    @RequestMapping(value = "/tancarPeticionsObertes")
    public String tancarPeticionsObertes(HttpServletRequest request, ModelAndView mav) throws I18NException {
        // Cridar al servei per tancar les peticions obertes
        Integer dies = 1; // Valor per defecte, es podria llegir d'una propietat global
        int count = evidenciaLogicaEjb.tancarPeticionsObertes(dies);

        HtmlUtils.saveMessageSuccess(request, I18NUtils.tradueix("evidencia.netejarpeticionsobertes.ok",
                String.valueOf(count), String.valueOf(dies)));

        // Redirigir a la llista d'evidències amb un missatge d'èxit
        return "redirect:" + getContextWeb() + "/list";
    }

}
