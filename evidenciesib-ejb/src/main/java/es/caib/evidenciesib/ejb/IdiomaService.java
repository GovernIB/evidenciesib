
package es.caib.evidenciesib.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import es.caib.evidenciesib.persistence.IdiomaJPA;
import es.caib.evidenciesib.persistence.IdiomaIJPAManager;
import es.caib.evidenciesib.model.dao.IIdiomaManager;

import es.caib.evidenciesib.model.entity.Idioma;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface IdiomaService extends IdiomaIJPAManager,IIdiomaManager {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/IdiomaEJB!es.caib.evidenciesib.ejb.IdiomaService";

    public IdiomaJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Idioma instance, FitxerService fitxerEjb) throws I18NException;
}
