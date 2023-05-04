package es.caib.evidenciesib.persistence.validator;

import es.caib.evidenciesib.persistence.EvidenciaJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class EvidenciaBeanValidator 
      extends AbstractBeanValidator<EvidenciaJPA> {


  // EJB's
  protected final es.caib.evidenciesib.model.dao.IEvidenciaManager __evidenciaManager;


  public final EvidenciaValidator<EvidenciaJPA> _validator;


  public EvidenciaBeanValidator(es.caib.evidenciesib.model.dao.IEvidenciaManager __evidenciaManager) { 
    this.__evidenciaManager = __evidenciaManager;
    _validator = new EvidenciaValidator<EvidenciaJPA>();
  }

  public EvidenciaBeanValidator(EvidenciaValidator<EvidenciaJPA> _validator,
     es.caib.evidenciesib.model.dao.IEvidenciaManager __evidenciaManager) {
    this.__evidenciaManager = __evidenciaManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EvidenciaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EvidenciaJPA> _bvr_ = new BeanValidatorResult<EvidenciaJPA>();
    _validator.validate(_bvr_, target, isNou, __evidenciaManager);
    return _bvr_.getErrors();
  }
}
