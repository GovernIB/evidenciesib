package es.caib.evidenciesib.back.form;

import org.fundaciobit.genapp.common.web.form.BaseForm;

/**
 * 
 * @author anadal
 *
 */
public abstract class EvidenciesIBBaseForm extends BaseForm {

  public EvidenciesIBBaseForm() {
  }
  
  public EvidenciesIBBaseForm(boolean nou) {
    super(nou);
  }
  
  public EvidenciesIBBaseForm(EvidenciesIBBaseForm __toClone) {
    super(__toClone);
  }
  
}
