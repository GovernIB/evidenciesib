package es.caib.evidenciesib.logic;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.core.v3.IPluginIB;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.caib.evidenciesib.ejb.PluginEJB;
import es.caib.evidenciesib.persistence.PluginJPA;
import es.caib.evidenciesib.model.entity.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class PluginLogicaEJB extends PluginEJB implements PluginLogicaService {

    private static final Map<Long, IPluginIB> pluginsCache = new HashMap<Long, IPluginIB>();

    @EJB(mappedName = es.caib.evidenciesib.ejb.TraduccioService.JNDI_NAME)
    protected es.caib.evidenciesib.ejb.TraduccioService traduccioEjb;

    @Override
    public Plugin update(Plugin instance) throws I18NException {
        if (instance != null) {
            deleteOfCache(instance.getPluginID());
        }
        return super.update(instance);
    }

    @Override
    public boolean deleteOfCache(Long pluginID) {
        synchronized (pluginsCache) {
            IPluginIB p = pluginsCache.remove(pluginID);
            return p != null;
        }
    }

    @Override
    public void delete(Plugin instance) {
        if (instance != null) {
            deleteOfCache(instance.getPluginID());

            // NOTA: Les traduccions s'esborren automàticament
            super.delete(instance);
        }
    }

    @Override
    public void clearCache() {
        synchronized (pluginsCache) {
            pluginsCache.clear();
        }
    }

    public void addPluginToCache(Long pluginID, IPluginIB pluginInstance) {
        synchronized (pluginsCache) {
            pluginsCache.put(pluginID, pluginInstance);
        }
    }

    public IPluginIB getPluginFromCache(Long pluginID) {
        synchronized (pluginsCache) {
            return pluginsCache.get(pluginID);
        }
    }

    @Override
    @PermitAll
    public PluginJPA findByPrimaryKey(Long _ID_) {
        return (PluginJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public PluginJPA findByPrimaryKey(long _ID_) {
        return (PluginJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public boolean deleteFull(Long pluginID) throws I18NException {

        delete(pluginID);

        return true;

    }

}
