
package es.caib.evidenciesib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.evidenciesib.persistence.TraduccioJPA;
import es.caib.evidenciesib.persistence.TraduccioIJPAManager;
import es.caib.evidenciesib.model.dao.ITraduccioManager;

import es.caib.evidenciesib.model.entity.Traduccio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface TraduccioService extends TraduccioIJPAManager,ITraduccioManager {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/TraduccioEJB!es.caib.evidenciesib.ejb.TraduccioService";

    public TraduccioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Traduccio instance, FitxerService fitxerEjb) throws I18NException;
}
