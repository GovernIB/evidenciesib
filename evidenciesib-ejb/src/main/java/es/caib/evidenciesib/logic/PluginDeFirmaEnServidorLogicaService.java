package es.caib.evidenciesib.logic;

import javax.ejb.Local;

import org.fundaciobit.plugins.signatureserver.api.ISignatureServerPlugin;


/**
 * 
 * @author anadal
 *
 */
@Local
public interface PluginDeFirmaEnServidorLogicaService extends AbstractPluginLogicaService<ISignatureServerPlugin> {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/PluginDeFirmaEnServidorLogicaEJB!es.caib.evidenciesib.logic.PluginDeFirmaEnServidorLogicaService";

}
