
package es.caib.evidenciesib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.persistence.EvidenciaIJPAManager;
import es.caib.evidenciesib.model.dao.IEvidenciaManager;

import es.caib.evidenciesib.model.entity.Evidencia;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EvidenciaService extends EvidenciaIJPAManager,IEvidenciaManager {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/EvidenciaEJB!es.caib.evidenciesib.ejb.EvidenciaService";

    public EvidenciaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Evidencia instance, FitxerService fitxerEjb) throws I18NException;
}
