package es.caib.evidenciesib.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import java.util.List;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import es.caib.evidenciesib.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.caib.evidenciesib.persistence.validator.EvidenciaValidator;

import es.caib.evidenciesib.back.form.webdb.EvidenciaForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import es.caib.evidenciesib.model.entity.Evidencia;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EvidenciaWebValidator extends AbstractWebValidator<EvidenciaForm, Evidencia>
     implements Validator, EvidenciaFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EvidenciaValidator<Evidencia> validator = new EvidenciaValidator<Evidencia>();

  // EJB's
  @javax.ejb.EJB(mappedName = es.caib.evidenciesib.ejb.EvidenciaService.JNDI_NAME)
  protected es.caib.evidenciesib.ejb.EvidenciaService evidenciaEjb;



  public EvidenciaWebValidator() {
    super();    
  }
  
  @Override
  public Evidencia getBeanOfForm(EvidenciaForm form) {
    return  form.getEvidencia();
  }

  @Override
  public Class<EvidenciaForm> getClassOfForm() {
    return EvidenciaForm.class;
  }

  @Override
  public void validate(EvidenciaForm __form, Evidencia __bean, Errors errors) {

    WebValidationResult<EvidenciaForm> wvr;
    wvr = new WebValidationResult<EvidenciaForm>(errors);

    boolean isNou;
    {
        Object objNou = errors.getFieldValue("nou");
        if (objNou == null) {
            isNou = false;
        } else { 
         Boolean nou = Boolean.parseBoolean(String.valueOf(objNou));
         isNou =  nou != null && nou.booleanValue();
        }
    }

    validate(__form, __bean , errors, wvr, isNou);
  }


  public void validate(EvidenciaForm __form, Evidencia __bean, Errors errors,
    WebValidationResult<EvidenciaForm> wvr, boolean isNou) {

    BeanValidatorResult<Evidencia> __vr = new BeanValidatorResult<Evidencia>();
    validator.validate(__vr, __bean,
      isNou, evidenciaEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }

    if (isNou) { // Creacio
      // ================ CREATION
      // Fitxers 
        if (!errors.hasFieldErrors(get(DOCUMENTFITXERID))){
            CommonsMultipartFile documentFitxerID = ((EvidenciaForm)__form).getDocumentFitxerID();
            if (documentFitxerID == null || documentFitxerID.isEmpty()) {
                errors.rejectValue(get(DOCUMENTFITXERID), "genapp.validation.required",
                new String[]{ org.fundaciobit.genapp.common.web.i18n.I18NUtils.tradueix(get(DOCUMENTFITXERID)) },
                null);
            }
        }

    }

  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public EvidenciaValidator<Evidencia> getValidator() {
    return validator;
  }

  public void setValidator(EvidenciaValidator<Evidencia> validator) {
    this.validator = validator;
  }

}