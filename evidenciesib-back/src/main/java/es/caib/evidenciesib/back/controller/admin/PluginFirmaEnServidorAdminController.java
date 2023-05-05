package es.caib.evidenciesib.back.controller.admin;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.caib.evidenciesib.back.form.webdb.PluginFilterForm;
import es.caib.evidenciesib.back.form.webdb.PluginForm;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.persistence.PluginJPA;
import es.caib.evidenciesib.logic.PluginDeFirmaEnServidorLogicaService;
import es.caib.evidenciesib.logic.PluginLogicaService;
import es.caib.evidenciesib.model.entity.Plugin;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = PluginFirmaEnServidorAdminController.CONTEXTWEB)
@SessionAttributes(types = { PluginForm.class, PluginFilterForm.class })
public class PluginFirmaEnServidorAdminController extends AbstractPluginSuperAdminController {

    public static final String CONTEXTWEB = "/admin/pluginfirmaenservidor";

    @EJB(mappedName = PluginDeFirmaEnServidorLogicaService.JNDI_NAME)
    protected PluginDeFirmaEnServidorLogicaService pluginDeFirmaEnServidorEjb;

    @EJB(mappedName = PluginLogicaService.JNDI_NAME)
    protected PluginLogicaService pluginLogicaServiceEjb;

    @Override
    public int getTipus() {
        return Constants.PLUGIN_TIPUS_FIRMA_EN_SERVIDOR;
    }

    @Override
    public List<StringKeyValue> getReferenceListForTipus(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue("1", I18NUtils.tradueix("plugin.tipus.1")));
        return __tmp;
    }

    @Override
    public PluginForm getPluginForm(PluginJPA _jpa, boolean __isView, HttpServletRequest request, ModelAndView mav)
            throws I18NException {
        PluginForm pluginForm = super.getPluginForm(_jpa, __isView, request, mav);
    
        

        return pluginForm;
    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        return Where.OR(TIPUS.equal(Constants.PLUGIN_TIPUS_FIRMA_EN_SERVIDOR));
    }

    @RequestMapping(value = "/reload/{pluginID}", method = RequestMethod.GET)
    public String reload(@PathVariable("pluginID") Long pluginID, HttpServletRequest request,
            HttpServletResponse response, PluginFilterForm filterForm) throws Exception, I18NException {

        if (!pluginDeFirmaEnServidorEjb.deleteOfCache(pluginID)) {
            // plugin.avis.cache=No s´ha pogut esborrar la instància de la cache o no n´hi
            // havia cap.
            HtmlUtils.saveMessageError(request, I18NUtils.tradueix("plugin.avis.cache"));
        }
        

        return "redirect:" + getContextWeb() + "/list";

    }

    @Override
    public PluginFilterForm getPluginFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        PluginFilterForm pluginFilterForm = super.getPluginFilterForm(pagina, mav, request);

        if (pluginFilterForm.isNou()) {
            pluginFilterForm.addAdditionalButtonForEachItem(
                    new AdditionalButton("fas fa-sync", "reload", getContextWeb() + "/reload/{0}", "btn-warning"));

            pluginFilterForm.setAttachedAdditionalJspCode(true);



            //pluginFilterForm.addHiddenField(DESCRIPCIO);

        }
        return pluginFilterForm;
    }

    @Override
    public void delete(HttpServletRequest request, Plugin plugin) throws I18NException {

        pluginLogicaServiceEjb.deleteFull(plugin.getPluginID());

    }

}
