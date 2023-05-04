
package es.caib.evidenciesib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.evidenciesib.persistence.PluginJPA;
import es.caib.evidenciesib.persistence.PluginIJPAManager;
import es.caib.evidenciesib.model.dao.IPluginManager;

import es.caib.evidenciesib.model.entity.Plugin;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PluginService extends PluginIJPAManager,IPluginManager {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/PluginEJB!es.caib.evidenciesib.ejb.PluginService";

    public PluginJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Plugin instance, FitxerService fitxerEjb) throws I18NException;
}
