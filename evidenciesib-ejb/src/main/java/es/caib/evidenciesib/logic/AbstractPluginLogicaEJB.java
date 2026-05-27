package es.caib.evidenciesib.logic;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.persistence.PluginJPA;
import es.caib.evidenciesib.model.entity.Plugin;
import es.caib.evidenciesib.model.fields.PluginFields;

import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.core.v3.IPluginIB;
import org.fundaciobit.pluginsib.core.v3.utils.PluginsManager;
import org.fundaciobit.pluginsib.utils.templateengine.TemplateEngine;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author anadal
 *
 */
public abstract class AbstractPluginLogicaEJB<I extends IPluginIB> extends PluginLogicaEJB
        implements AbstractPluginLogicaService<I> {

    protected final Where getWhereTipusDePlugin() {
        return PluginFields.TIPUS.equal(getTipus());
    }

    public abstract int getTipus();

    public abstract String getName();

    @Override
    public List<Plugin> getAllPlugins() throws I18NException {
        return getAllPlugins(null);
    }

    @Override
    public List<Plugin> getAllPlugins(Where w) throws I18NException {
        Where where;
        if (w == null) {
            where = Where.AND(getWhereTipusDePlugin());
        } else {
            where = Where.AND(w, getWhereTipusDePlugin());
        }

        //log.info("\n\n getAllPlugins(): WHERE => " + where.toSQL());

        return select(where);
    }

    @Override
    public boolean existsInstanceForPluginID(long pluginID) throws I18NException {
        IPluginIB pluginInstance = getPluginFromCache(pluginID);

        if (pluginInstance == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Selecciona el plugin amb enable (només n'hi ha d'haver un) i retorna la seva instància. Si no n'hi ha cap llança un excepció
     * @return
     * @throws I18NException
     */
    @Override
    public I getCurrentEnabledInstance() throws I18NException {

        Long pluginID = executeQueryOne(PLUGINID, Where.AND(getWhereTipusDePlugin(), ACTIU.equal(true)));

        if (pluginID == null) {
            throw new I18NException("genapp.comodi",
                    "No existeix cap plugin actiu del tipus " + getName() + "(" + getTipus() + ")");
        }
        
        return getInstanceByPluginID(pluginID);

    }

    @Override
    public I getInstanceByPluginID(long pluginID) throws I18NException {

        IPluginIB pluginInstance = getPluginFromCache(pluginID);

        if (pluginInstance == null) {

            PluginJPA plugin = (PluginJPA) findByPrimaryKey(pluginID);

            if (plugin == null) {
                return null;
            }

            Properties prop = new Properties();

            if (plugin.getPropietats() != null && plugin.getPropietats().trim().length() != 0) {
                try {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("SP", Configuracio.getJavaAndEvidenciesIBFileProperties());

                    String plantilla = plugin.getPropietats();
                    String generat = TemplateEngine.processExpressionLanguageSquareBrackets(plantilla, map,
                            new Locale("ca"));

                    //log.error("PROPIETATS DESPRES DE generat:\n" + generat + "\n");
                    prop.load(new StringReader(generat));

                } catch (Exception e) {
                    throw new I18NException(e, "genapp.comodi", new I18NArgumentString(
                            "Error desconegut processant propietats del plugin " + pluginID + ": " + e.getMessage()));
                }
            }

            pluginInstance = (IPluginIB) PluginsManager.instancePluginByClassName(plugin.getClasse(),
                    es.caib.evidenciesib.commons.utils.Constants.EVIDENCIESIB_PROPERTY_BASE, prop);

            if (pluginInstance == null) {
                throw new I18NException("plugin.donotinstantiate", getName() + " (" + plugin.getClasse() + ")");
            }

            addPluginToCache(pluginID, pluginInstance);

        }
        return ((I) pluginInstance);

    }

    @Override
    public List<I> getPluginInstancesBy(List<Long> filterByPluginID, List<String> filterByPluginCode)
            throws I18NException {

        List<I> plugins = new ArrayList<I>();

        Where where = Where.AND(getWhereTipusDePlugin(), ACTIU.equal(true));

        if (filterByPluginID != null && filterByPluginID.size() != 0) {
            where = Where.AND(where, PLUGINID.in(filterByPluginID));
        }

        // TODO endent afegir camp codi dins plugin
        // if (filterByPluginCode != null && filterByPluginCode.size() != 0) {
        // where = Where.AND(where, CODI.in(filterByPluginID));
        // }

        List<Plugin> modulsdefirma = select(where);

        for (Plugin mf : modulsdefirma) {
            plugins.add(getInstanceByPluginID(mf.getPluginID()));
        }

        return plugins;

    }

}
