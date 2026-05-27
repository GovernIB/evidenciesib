package es.caib.evidenciesib.logic;

import org.fundaciobit.pluginsib.login.api.IPluginLogin;

/**
 * 
 * @author anadal (u80067)
 * 25 may 2026 15:03:23
 */
public interface PluginLoginFrontLogicaService extends AbstractPluginLogicaService<IPluginLogin> {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/PluginLoginFrontLogicaEJB!es.caib.evidenciesib.logic.PluginLoginFrontLogicaService";

}
