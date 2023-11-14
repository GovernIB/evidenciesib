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
  
  
  private CommonsMultipartFile fitxerOriginalID;
  private boolean fitxerOriginalIDDelete;
  
  
  private CommonsMultipartFile fitxerAdaptatID;
  private boolean fitxerAdaptatIDDelete;
  
  
  private CommonsMultipartFile fitxerSignatID;
  private boolean fitxerSignatIDDelete;
  
  public EvidenciaForm() {
  }
  
  public EvidenciaForm(EvidenciaForm __toClone) {
    super(__toClone);
      this.evidencia = __toClone.evidencia;
    this.listOfValuesForEstatCodi = __toClone.listOfValuesForEstatCodi;
    this.listOfValuesForLoginQaa = __toClone.listOfValuesForLoginQaa;
    this.listOfValuesForFirmaIdiomaDocument = __toClone.listOfValuesForFirmaIdiomaDocument;
    this.listOfValuesForFirmaTipusDocumental = __toClone.listOfValuesForFirmaTipusDocumental;
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
  
  
  public CommonsMultipartFile getFitxerOriginalID() {
    return fitxerOriginalID;
  }
  
   public void setFitxerOriginalID(CommonsMultipartFile fitxerOriginalID) {
    this.fitxerOriginalID = fitxerOriginalID;
  }
  public boolean isFitxerOriginalIDDelete() {
    return fitxerOriginalIDDelete;
  }
  
  public void setFitxerOriginalIDDelete(boolean fitxerOriginalIDDelete) {
    this.fitxerOriginalIDDelete = fitxerOriginalIDDelete;
   }
  public CommonsMultipartFile getFitxerAdaptatID() {
    return fitxerAdaptatID;
  }
  
   public void setFitxerAdaptatID(CommonsMultipartFile fitxerAdaptatID) {
    this.fitxerAdaptatID = fitxerAdaptatID;
  }
  public boolean isFitxerAdaptatIDDelete() {
    return fitxerAdaptatIDDelete;
  }
  
  public void setFitxerAdaptatIDDelete(boolean fitxerAdaptatIDDelete) {
    this.fitxerAdaptatIDDelete = fitxerAdaptatIDDelete;
   }
  public CommonsMultipartFile getFitxerSignatID() {
    return fitxerSignatID;
  }
  
   public void setFitxerSignatID(CommonsMultipartFile fitxerSignatID) {
    this.fitxerSignatID = fitxerSignatID;
  }
  public boolean isFitxerSignatIDDelete() {
    return fitxerSignatIDDelete;
  }
  
  public void setFitxerSignatIDDelete(boolean fitxerSignatIDDelete) {
    this.fitxerSignatIDDelete = fitxerSignatIDDelete;
   }
  private List<StringKeyValue> listOfValuesForEstatCodi;

  public List<StringKeyValue> getListOfValuesForEstatCodi() {
    return this.listOfValuesForEstatCodi;
  }

  public void setListOfValuesForEstatCodi(List<StringKeyValue> listOfValuesForEstatCodi) {
    this.listOfValuesForEstatCodi = listOfValuesForEstatCodi;
  }



  private List<StringKeyValue> listOfValuesForLoginQaa;

  public List<StringKeyValue> getListOfValuesForLoginQaa() {
    return this.listOfValuesForLoginQaa;
  }

  public void setListOfValuesForLoginQaa(List<StringKeyValue> listOfValuesForLoginQaa) {
    this.listOfValuesForLoginQaa = listOfValuesForLoginQaa;
  }



  private List<StringKeyValue> listOfValuesForFirmaIdiomaDocument;

  public List<StringKeyValue> getListOfValuesForFirmaIdiomaDocument() {
    return this.listOfValuesForFirmaIdiomaDocument;
  }

  public void setListOfValuesForFirmaIdiomaDocument(List<StringKeyValue> listOfValuesForFirmaIdiomaDocument) {
    this.listOfValuesForFirmaIdiomaDocument = listOfValuesForFirmaIdiomaDocument;
  }



  private List<StringKeyValue> listOfValuesForFirmaTipusDocumental;

  public List<StringKeyValue> getListOfValuesForFirmaTipusDocumental() {
    return this.listOfValuesForFirmaTipusDocumental;
  }

  public void setListOfValuesForFirmaTipusDocumental(List<StringKeyValue> listOfValuesForFirmaTipusDocumental) {
    this.listOfValuesForFirmaTipusDocumental = listOfValuesForFirmaTipusDocumental;
  }



  
} // Final de Classe 
