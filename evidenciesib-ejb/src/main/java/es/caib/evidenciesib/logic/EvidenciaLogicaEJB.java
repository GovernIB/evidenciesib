package es.caib.evidenciesib.logic;

import javax.annotation.security.PermitAll;

import javax.ejb.Stateless;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class EvidenciaLogicaEJB extends EvidenciaEJB implements EvidenciaLogicaService {

    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(Long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public Evidencia update(Evidencia instance) throws I18NException {
        return super.update(instance);
    }

}
