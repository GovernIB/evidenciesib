package es.caib.evidenciesib.logic.firmaviaapi;

import java.util.Properties;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.core.v3.IPluginIB;
import org.fundaciobit.pluginsib.core.v3.utils.AbstractPluginProperties;
import org.jboss.logging.Logger;

import es.caib.evidenciesib.logic.FitxerLogicaService;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 11:38:43
 */
public abstract class IPluginFirmaEnServidorViaApi extends AbstractPluginProperties implements IPluginIB {

    protected Logger log = Logger.getLogger(this.getClass());
    
    
    /**
     * 
     */
    public IPluginFirmaEnServidorViaApi() {
        super();
    }

    /**
     * @param propertyKeyBase
     * @param properties
     */
    public IPluginFirmaEnServidorViaApi(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
    }

    /**
     * @param propertyKeyBase
     */
    public IPluginFirmaEnServidorViaApi(String propertyKeyBase) {
        super(propertyKeyBase);
    }
    
    /**
     * 
     * @throws I18NException
     */
    public abstract void valide() throws I18NException;
    
    
    
    public abstract void firmaEnServidor(FitxerLogicaService fitxerLogicaEjb, EvidenciaJPA evi, String idiomaUI,
            final String signID, final String name, final String reason, final String location, final int signNumber,
            final String languageSign, final long tipusDocumentalID, final String nif) throws I18NException;
    
    
    
    String getPropertyR(String propertyKey) throws I18NException {
        try {

            return getPropertyRequired(propertyKey);

        } catch (Throwable e) {

            if (e instanceof I18NException) {
                throw (I18NException) e;
            } else {
                String msg = "Error obtenint la propietat de configuració " + propertyKey + ": " + e.getMessage();
                log.error(msg, e);
                throw new I18NException(e, "genapp.comodi", msg);
            }

        }
    }
    
}
