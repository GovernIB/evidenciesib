package es.caib.evidenciesib.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import es.caib.evidenciesib.back.form.EvidenciesIBBaseForm;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EvidenciaForm extends EvidenciesIBBaseForm {
  
  private EvidenciaJPA evidencia;
  
  
  private CommonsMultipartFile documentFitxerID;
  private boolean documentFitxerIDDelete;
  
  public EvidenciaForm() {
  }
  
  public EvidenciaForm(EvidenciaForm __toClone) {
    super(__toClone);
      this.evidencia = __toClone.evidencia;
    this.listOfValuesForEstatCodi = __toClone.listOfValuesForEstatCodi;
    this.listOfValuesForLoginType = __toClone.listOfValuesForLoginType;
  }
  
  public EvidenciaForm(EvidenciaJPA evidencia, boolean nou) {
    super(nou);
    this.evidencia = evidencia;
  }
  
  public EvidenciaJPA getEvidencia() {
    return evidencia;
  }
  public void setEvidencia(EvidenciaJPA evidencia) {
    this.evidencia = evidencia;
  }
  
  
  public CommonsMultipartFile getDocumentFitxerID() {
    return documentFitxerID;
  }
  
   public void setDocumentFitxerID(CommonsMultipartFile documentFitxerID) {
    this.documentFitxerID = documentFitxerID;
  }
  public boolean isDocumentFitxerIDDelete() {
    return documentFitxerIDDelete;
  }
  
  public void setDocumentFitxerIDDelete(boolean documentFitxerIDDelete) {
    this.documentFitxerIDDelete = documentFitxerIDDelete;
   }
  private List<StringKeyValue> listOfValuesForEstatCodi;

  public List<StringKeyValue> getListOfValuesForEstatCodi() {
    return this.listOfValuesForEstatCodi;
  }

  public void setListOfValuesForEstatCodi(List<StringKeyValue> listOfValuesForEstatCodi) {
    this.listOfValuesForEstatCodi = listOfValuesForEstatCodi;
  }



  private List<StringKeyValue> listOfValuesForLoginType;

  public List<StringKeyValue> getListOfValuesForLoginType() {
    return this.listOfValuesForLoginType;
  }

  public void setListOfValuesForLoginType(List<StringKeyValue> listOfValuesForLoginType) {
    this.listOfValuesForLoginType = listOfValuesForLoginType;
  }



  
} // Final de Classe 
