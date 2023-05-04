
package es.caib.evidenciesib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.evidenciesib.persistence.FitxerJPA;
import es.caib.evidenciesib.persistence.FitxerIJPAManager;
import es.caib.evidenciesib.model.dao.IFitxerManager;

import es.caib.evidenciesib.model.entity.Fitxer;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface FitxerService extends FitxerIJPAManager,IFitxerManager {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/FitxerEJB!es.caib.evidenciesib.ejb.FitxerService";

    public FitxerJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Fitxer instance, FitxerService fitxerEjb) throws I18NException;
}
