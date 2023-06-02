package es.caib.evidenciesib.logic;

import javax.annotation.security.PermitAll;
import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface EvidenciesFrontLogicaService extends es.caib.evidenciesib.ejb.EvidenciaService {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/EvidenciesFrontLogicaEJB!es.caib.evidenciesib.logic.EvidenciesFrontLogicaService";

    @PermitAll
    @Override
    public EvidenciaJPA findByPrimaryKey(Long _ID_);
    
    @PermitAll
    @Override
    public Evidencia findByPrimaryKey(long _ID_);

    @PermitAll
    @Override
    public Long count(Where w) throws I18NException;

    @PermitAll
    @Override
    Evidencia update(Evidencia entity) throws I18NException;

}
