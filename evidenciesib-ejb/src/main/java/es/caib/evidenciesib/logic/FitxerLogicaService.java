package es.caib.evidenciesib.logic;

import javax.ejb.Local;

import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.FitxerJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface FitxerLogicaService extends es.caib.evidenciesib.ejb.FitxerService {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/FitxerLogicaEJB!es.caib.evidenciesib.logic.FitxerLogicaService";

    public FitxerJPA findByPrimaryKey(Long _ID_);

    public Fitxer findByPrimaryKey(long _ID_);

}
