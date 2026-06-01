package es.caib.evidenciesib.logic;



import es.caib.evidenciesib.logic.firmaviaapi.IPluginFirmaEnServidorViaApi;

/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 12:29:33
 */
public interface PluginFirmaEnServidorViaApiLogicaService extends AbstractPluginLogicaService<IPluginFirmaEnServidorViaApi> {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/PluginFirmaEnServidorViaApiLogicaEJB!es.caib.evidenciesib.logic.PluginFirmaEnServidorViaApiLogicaService";

}
