package es.caib.evidenciesib.back.controller.admin;

import es.caib.evidenciesib.back.form.webdb.PluginFilterForm;
import es.caib.evidenciesib.back.form.webdb.PluginForm;
import es.caib.evidenciesib.back.utils.Tab;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.PluginFirmaEnServidorViaApiLogicaService;
import es.caib.evidenciesib.logic.firmaviaapi.IPluginFirmaEnServidorViaApi;
import es.caib.evidenciesib.logic.firmaviaapi.PluginFirmaEnServidorViaApiPortaFIB;
import es.caib.evidenciesib.logic.firmaviaapi.PluginFirmaEnServidorViaApiUtilitatsFirma;
import es.caib.evidenciesib.persistence.PluginJPA;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 15:05:55
 */
@Controller
@RequestMapping(value = "/admin/moduldefirmaenservidor")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
@MenuOption(
        group = Tab.MENU_ADMIN,
        labelCode = "plugin.tipus." + Constants.PLUGINSIB_TIPUS_FIRMA_EN_SERVIDOR + ".plural",
        order = 60,
        addSeparatorBefore = true)
public class PluginFirmaEnServidorViaApiAdminController
        extends AbstractPluginSuperAdminController<IPluginFirmaEnServidorViaApi> {

    @EJB(mappedName = PluginFirmaEnServidorViaApiLogicaService.JNDI_NAME)
    protected PluginFirmaEnServidorViaApiLogicaService pluginFirmaEnServidorViaApiLogicaEJB; // extends AbstractPluginLogicaService<IPluginLogin>

    @Override
    public int getTipus() {
        return Constants.PLUGINSIB_TIPUS_FIRMA_EN_SERVIDOR;
    }

    @Override
    public PluginFirmaEnServidorViaApiLogicaService getPluginLogicaEJB() {

        return pluginFirmaEnServidorViaApiLogicaEJB;
    }

    @Override
    public PluginForm getPluginForm(PluginJPA _jpa, boolean __isView, HttpServletRequest request, ModelAndView mav)
            throws I18NException {
        PluginForm pluginForm = super.getPluginForm(_jpa, __isView, request, mav);

        if (pluginForm.isNou()) {

            pluginForm.setAttachedAdditionalJspCode(true);

        } else {
            pluginForm.addReadOnlyField(CLASSE);
            pluginForm.setAttachedAdditionalJspCode(false);

        }

        Map<String, String> classesDisponibles = new HashMap<String, String>();

        classesDisponibles.put(PluginFirmaEnServidorViaApiUtilitatsFirma.class.getName(),
                PluginFirmaEnServidorViaApiUtilitatsFirma.class.getName());

        classesDisponibles.put(PluginFirmaEnServidorViaApiPortaFIB.class.getName(),
                PluginFirmaEnServidorViaApiPortaFIB.class.getName());
        
        request.getSession().setAttribute("classesDisponibles", classesDisponibles);
        

        mav.addObject("classesDisponibles", classesDisponibles);

        return pluginForm;
    }

}
