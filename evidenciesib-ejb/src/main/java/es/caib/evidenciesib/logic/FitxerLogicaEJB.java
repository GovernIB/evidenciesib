package es.caib.evidenciesib.logic;

import org.fundaciobit.genapp.common.i18n.I18NException;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

import es.caib.evidenciesib.ejb.FitxerEJB;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.FitxerJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class FitxerLogicaEJB extends FitxerEJB implements FitxerLogicaService {

    
    @Override
    @PermitAll
    public Fitxer create(Fitxer instance) throws I18NException {
        return super.create(instance);
    }

    
    @Override
    @PermitAll
    public FitxerJPA findByPrimaryKey(Long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }
    
    @Override
    @PermitAll
    public Fitxer findByPrimaryKey(long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }
}
