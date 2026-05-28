package es.caib.evidenciesib.back.controller.admin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.genapp.common.web.form.AdditionalButton;
import org.fundaciobit.genapp.common.web.form.AdditionalButtonStyle;
import org.fundaciobit.genapp.common.web.html.IconUtils;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.webdb.PluginController;
import es.caib.evidenciesib.back.form.webdb.PluginFilterForm;
import es.caib.evidenciesib.back.form.webdb.PluginForm;
import es.caib.evidenciesib.logic.AbstractPluginLogicaService;
import es.caib.evidenciesib.persistence.PluginJPA;
import es.caib.evidenciesib.model.entity.Plugin;
import es.caib.evidenciesib.model.fields.PluginFields;

/**
 * 
 * @author anadal
 *
 */
public abstract class AbstractPluginSuperAdminController<I> extends PluginController {

    /*@EJB(mappedName = PluginLogicaService.JNDI_NAME)
    protected PluginLogicaService pluginLogicaEJB;*/

    @Override
    public List<StringKeyValue> getReferenceListForTipus(HttpServletRequest request, ModelAndView mav, Where where)
            throws I18NException {
        List<StringKeyValue> __tmp = new java.util.ArrayList<StringKeyValue>();
        __tmp.add(new StringKeyValue(String.valueOf(getTipus()), I18NUtils.tradueix("plugin.tipus." + getTipus())));
        return __tmp;
    }

    @Override
    public String getTileForm() {
        return "pluginFormAdmin";
    }

    @Override
    public String getTileList() {
        return "pluginListAdmin";
    }

    @Override
    public String getSessionAttributeFilterForm() {
        return "Plugin" + getTipus() + "Admin_FilterForm";
    }

    @Override
    public PluginForm getPluginForm(PluginJPA _jpa, boolean __isView, HttpServletRequest request, ModelAndView mav)
            throws I18NException {
        PluginForm pluginForm = super.getPluginForm(_jpa, __isView, request, mav);

        pluginForm.addHiddenField(TIPUS);

        if (pluginForm.isNou()) {
            pluginForm.getPlugin().setTipus(getTipus());
            pluginForm.getPlugin().setActiu(false);
        } else {

            if (!pluginForm.getPlugin().isActiu()) {

                pluginForm.addAdditionalButton(new AdditionalButton(IconUtils.ICON_OK_CIRCLE, "=Activar",
                        getContextWeb() + "/enable/" + pluginForm.getPlugin().getPluginID(),
                        AdditionalButtonStyle.WARNING));
            }
        }
        pluginForm.addReadOnlyField(ACTIU);

        return pluginForm;
    }

    @RequestMapping(value = "/enable/{pluginID}")
    public String enablePlugin(HttpServletRequest request, ModelAndView mav, @PathVariable("pluginID")
    Long pluginID) throws I18NException {
        getPluginLogicaEJB().enablePlugin(pluginID, getTipus());
        return "redirect:" + getContextWeb() + "/list";
    }

    /**
     * Accio per resetejar un plugin
     */
    @RequestMapping(value = "/reset/{pluginID}")
    public String resetPlugin(HttpServletRequest request, ModelAndView mav, @PathVariable("pluginID")
    Long pluginID) throws I18NException {
        getPluginLogicaEJB().deleteOfCache(pluginID);
        HtmlUtils.saveMessageSuccess(request, "Plugin resetejat correctament");

        return "redirect:" + getContextWeb() + "/list";
    }

    /**
     * Accio per verificar que el plugin s'instancia bé i es pot carregar correctament. Si no es pot carregar, es mostra un error a l'usuari
     */
    @RequestMapping(value = "/verify/{pluginID}")
    public String verifyPlugin(HttpServletRequest request, ModelAndView mav, @PathVariable("pluginID")
    Long pluginID) throws I18NException {
        try {
            AbstractPluginLogicaService<I> ejb = getPluginLogicaEJB();
            ejb.deleteOfCache(pluginID);
            I instance = ejb.getCurrentEnabledInstance();
            if (instance == null) {
                HtmlUtils.saveMessageError(request,
                        "El procés de instanciació ha retornat un valor null. Revisi logs.");
            } else {

                // XYZ ZZZ TRA
                HtmlUtils.saveMessageSuccess(request,
                        "Plugin s'ha instanciat correctament (Nota: No s'ha verificat que funcioni correctament)");
            }
        } catch (Throwable e) {

            String msg;
            if (e instanceof I18NException) {
                msg = I18NUtils.getMessage((I18NException) e);
            } else {
                msg = e.getMessage();
            }

            HtmlUtils.saveMessageError(request, "Error durant la instanciació del plugin: " + msg);
        }

        return "redirect:" + getContextWeb() + "/list";
    }

    @Override
    public PluginFilterForm getPluginFilterForm(Integer pagina, ModelAndView mav, HttpServletRequest request)
            throws I18NException {
        PluginFilterForm pluginFilterForm = super.getPluginFilterForm(pagina, mav, request);

        if (pluginFilterForm.isNou()) {
            Set<Field<?>> hiddenFields = new HashSet<Field<?>>(Arrays.asList(PluginFields.ALL_PLUGIN_FIELDS));

            hiddenFields.remove(PluginFields.NOM);
            hiddenFields.remove(PluginFields.DESCRIPCIO);
            hiddenFields.remove(PluginFields.ACTIU);

            pluginFilterForm.setHiddenFields(hiddenFields);

            pluginFilterForm.setDefaultOrderBy(new OrderBy[] { new OrderBy(NOM) });

            pluginFilterForm.setAllItemsPerPage(new int[] { -1 });
            pluginFilterForm.setItemsPerPage(-1);

            pluginFilterForm.addAdditionalButtonForEachItem(new AdditionalButton(IconUtils.ICON_RELOAD, "=Reset",
                    getContextWeb() + "/reset/{0}", AdditionalButtonStyle.WARNING));

            pluginFilterForm.addAdditionalButtonForEachItem(new AdditionalButton("fas fa-heartbeat",
                    "=Validar Instanciació", getContextWeb() + "/verify/{0}", AdditionalButtonStyle.INFO));

        }

        return pluginFilterForm;

    }

    @Override
    public void postList(HttpServletRequest request, ModelAndView mav, PluginFilterForm filterForm, List<Plugin> list)
            throws I18NException {
        // TODO Auto-generated method stub
        super.postList(request, mav, filterForm, list);

        filterForm.getAdditionalButtonsByPK().clear();

        for (Plugin plugin : list) {
            if (!plugin.isActiu()) {
                filterForm.addAdditionalButtonByPK(plugin.getPluginID(),
                        new AdditionalButton(IconUtils.ICON_CHECK, "=Fer actiu",
                                getContextWeb() + "/enable/" + plugin.getPluginID(), AdditionalButtonStyle.SUCCESS));
            }
        }

    }

    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        return TIPUS.equal(getTipus());
    }

    @Override
    public final String getEntityNameCode() {
        return "plugin.tipus." + getTipus();
    }

    @Override
    public final String getEntityNameCodePlural() {
        return "plugin.tipus." + getTipus() + ".plural";
    }

    public abstract int getTipus();

    public abstract AbstractPluginLogicaService<I> getPluginLogicaEJB();

}
