package es.caib.evidenciesib.back.controller.admin;

import es.caib.evidenciesib.back.form.webdb.PluginFilterForm;
import es.caib.evidenciesib.back.form.webdb.PluginForm;
import es.caib.evidenciesib.back.utils.Tab;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.PluginLoginFrontLogicaService;

import javax.ejb.EJB;

import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;
import org.fundaciobit.pluginsib.login.api.IPluginLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal (u80067)
 * 25 may 2026 15:05:55
 */
@Controller
@RequestMapping(value = "/admin/moduldefirmaenservidor")
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
@MenuOption(
        group = Tab.MENU_ADMIN,
        labelCode = "plugin.tipus." + Constants.PLUGINSIB_TIPUS_LOGIN_FRONT + ".plural",
        order = 50,
        addSeparatorBefore = true)
public class PluginLoginAdminController extends AbstractPluginSuperAdminController<IPluginLogin> {

    @EJB(mappedName = PluginLoginFrontLogicaService.JNDI_NAME)
    PluginLoginFrontLogicaService PluginLoginFrontLogicaEjb; // extends AbstractPluginLogicaService<IPluginLogin>

    @Override
    public int getTipus() {
        return Constants.PLUGINSIB_TIPUS_LOGIN_FRONT;
    }

    @Override
    public PluginLoginFrontLogicaService getPluginLogicaEJB() {

        return PluginLoginFrontLogicaEjb;
    }

}
