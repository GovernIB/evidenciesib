package es.caib.evidenciesib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.evidenciesib.persistence.PluginJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginLogicaService extends es.caib.evidenciesib.ejb.PluginService {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/PluginLogicaEJB!es.caib.evidenciesib.logic.PluginLogicaService";

    public boolean deleteOfCache(Long pluginID);

    public void clearCache();

    @Override
    public PluginJPA findByPrimaryKey(Long _ID_);

    @Override
    public PluginJPA findByPrimaryKey(long _ID_);

    public boolean deleteFull(Long pluginID) throws I18NException;

}
