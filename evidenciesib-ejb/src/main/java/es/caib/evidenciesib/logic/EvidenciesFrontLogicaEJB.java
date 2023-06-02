package es.caib.evidenciesib.logic;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class EvidenciesFrontLogicaEJB extends EvidenciaEJB implements EvidenciesFrontLogicaService {

    @PermitAll
    @Override
    public EvidenciaJPA findByPrimaryKey(Long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

    @PermitAll
    @Override
    public Evidencia findByPrimaryKey(long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

    @PermitAll
    @Override
    public Long count(Where w) throws I18NException {
        return super.count(w);
    }

    @PermitAll
    @Override
    public Evidencia update(Evidencia evi) throws I18NException {
        return super.update(evi);
    }
}
