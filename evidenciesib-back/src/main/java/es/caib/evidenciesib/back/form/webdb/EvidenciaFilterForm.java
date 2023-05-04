
package es.caib.evidenciesib.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import es.caib.evidenciesib.back.form.EvidenciesIBBaseFilterForm;

import es.caib.evidenciesib.model.fields.EvidenciaFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EvidenciaFilterForm extends EvidenciesIBBaseFilterForm implements EvidenciaFields {

  private java.lang.Long evidenciaIDDesde;

  public java.lang.Long getEvidenciaIDDesde() {
    return this.evidenciaIDDesde;
  }

  public void setEvidenciaIDDesde(java.lang.Long evidenciaIDDesde) {
    this.evidenciaIDDesde = evidenciaIDDesde;
  }


  private java.lang.Long evidenciaIDFins;

  public java.lang.Long getEvidenciaIDFins() {
    return this.evidenciaIDFins;
  }

  public void setEvidenciaIDFins(java.lang.Long evidenciaIDFins) {
    this.evidenciaIDFins = evidenciaIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String personanom;

  public java.lang.String getPersonanom() {
    return this.personanom;
  }

  public void setPersonanom(java.lang.String personanom) {
    this.personanom = personanom;
  }


  private java.lang.String personallinatge1;

  public java.lang.String getPersonallinatge1() {
    return this.personallinatge1;
  }

  public void setPersonallinatge1(java.lang.String personallinatge1) {
    this.personallinatge1 = personallinatge1;
  }


  private java.lang.String personallinatge2;

  public java.lang.String getPersonallinatge2() {
    return this.personallinatge2;
  }

  public void setPersonallinatge2(java.lang.String personallinatge2) {
    this.personallinatge2 = personallinatge2;
  }


  private java.lang.String personanif;

  public java.lang.String getPersonanif() {
    return this.personanif;
  }

  public void setPersonanif(java.lang.String personanif) {
    this.personanif = personanif;
  }


  private java.lang.String documenthash;

  public java.lang.String getDocumenthash() {
    return this.documenthash;
  }

  public void setDocumenthash(java.lang.String documenthash) {
    this.documenthash = documenthash;
  }


  private java.lang.Long documentmidaDesde;

  public java.lang.Long getDocumentmidaDesde() {
    return this.documentmidaDesde;
  }

  public void setDocumentmidaDesde(java.lang.Long documentmidaDesde) {
    this.documentmidaDesde = documentmidaDesde;
  }


  private java.lang.Long documentmidaFins;

  public java.lang.Long getDocumentmidaFins() {
    return this.documentmidaFins;
  }

  public void setDocumentmidaFins(java.lang.Long documentmidaFins) {
    this.documentmidaFins = documentmidaFins;
  }


  private java.sql.Timestamp datainiciDesde;

  public java.sql.Timestamp getDatainiciDesde() {
    return this.datainiciDesde;
  }

  public void setDatainiciDesde(java.sql.Timestamp datainiciDesde) {
    this.datainiciDesde = datainiciDesde;
  }


  private java.sql.Timestamp datainiciFins;

  public java.sql.Timestamp getDatainiciFins() {
    return this.datainiciFins;
  }

  public void setDatainiciFins(java.sql.Timestamp datainiciFins) {
    this.datainiciFins = datainiciFins;
  }


  private java.sql.Timestamp datafiDesde;

  public java.sql.Timestamp getDatafiDesde() {
    return this.datafiDesde;
  }

  public void setDatafiDesde(java.sql.Timestamp datafiDesde) {
    this.datafiDesde = datafiDesde;
  }


  private java.sql.Timestamp datafiFins;

  public java.sql.Timestamp getDatafiFins() {
    return this.datafiFins;
  }

  public void setDatafiFins(java.sql.Timestamp datafiFins) {
    this.datafiFins = datafiFins;
  }


  private java.lang.String usuariaplicacio;

  public java.lang.String getUsuariaplicacio() {
    return this.usuariaplicacio;
  }

  public void setUsuariaplicacio(java.lang.String usuariaplicacio) {
    this.usuariaplicacio = usuariaplicacio;
  }


  private java.lang.String usuaripersona;

  public java.lang.String getUsuaripersona() {
    return this.usuaripersona;
  }

  public void setUsuaripersona(java.lang.String usuaripersona) {
    this.usuaripersona = usuaripersona;
  }


  private java.lang.Integer estatcodiDesde;

  public java.lang.Integer getEstatcodiDesde() {
    return this.estatcodiDesde;
  }

  public void setEstatcodiDesde(java.lang.Integer estatcodiDesde) {
    this.estatcodiDesde = estatcodiDesde;
  }


  private java.lang.Integer estatcodiFins;

  public java.lang.Integer getEstatcodiFins() {
    return this.estatcodiFins;
  }

  public void setEstatcodiFins(java.lang.Integer estatcodiFins) {
    this.estatcodiFins = estatcodiFins;
  }


  private java.lang.String estaterror;

  public java.lang.String getEstaterror() {
    return this.estaterror;
  }

  public void setEstaterror(java.lang.String estaterror) {
    this.estaterror = estaterror;
  }


  private java.lang.String estatexcepcio;

  public java.lang.String getEstatexcepcio() {
    return this.estatexcepcio;
  }

  public void setEstatexcepcio(java.lang.String estatexcepcio) {
    this.estatexcepcio = estatexcepcio;
  }


  private java.lang.String personamobil;

  public java.lang.String getPersonamobil() {
    return this.personamobil;
  }

  public void setPersonamobil(java.lang.String personamobil) {
    this.personamobil = personamobil;
  }


  private java.lang.Integer logintypeDesde;

  public java.lang.Integer getLogintypeDesde() {
    return this.logintypeDesde;
  }

  public void setLogintypeDesde(java.lang.Integer logintypeDesde) {
    this.logintypeDesde = logintypeDesde;
  }


  private java.lang.Integer logintypeFins;

  public java.lang.Integer getLogintypeFins() {
    return this.logintypeFins;
  }

  public void setLogintypeFins(java.lang.Integer logintypeFins) {
    this.logintypeFins = logintypeFins;
  }


  private java.lang.String loginid;

  public java.lang.String getLoginid() {
    return this.loginid;
  }

  public void setLoginid(java.lang.String loginid) {
    this.loginid = loginid;
  }


  private java.sql.Timestamp logindataDesde;

  public java.sql.Timestamp getLogindataDesde() {
    return this.logindataDesde;
  }

  public void setLogindataDesde(java.sql.Timestamp logindataDesde) {
    this.logindataDesde = logindataDesde;
  }


  private java.sql.Timestamp logindataFins;

  public java.sql.Timestamp getLogindataFins() {
    return this.logindataFins;
  }

  public void setLogindataFins(java.sql.Timestamp logindataFins) {
    this.logindataFins = logindataFins;
  }


  private java.lang.String localitzacioip;

  public java.lang.String getLocalitzacioip() {
    return this.localitzacioip;
  }

  public void setLocalitzacioip(java.lang.String localitzacioip) {
    this.localitzacioip = localitzacioip;
  }


  private java.lang.String localitzaciocodipostal;

  public java.lang.String getLocalitzaciocodipostal() {
    return this.localitzaciocodipostal;
  }

  public void setLocalitzaciocodipostal(java.lang.String localitzaciocodipostal) {
    this.localitzaciocodipostal = localitzaciocodipostal;
  }


  private java.lang.String localitzaciocoordenades;

  public java.lang.String getLocalitzaciocoordenades() {
    return this.localitzaciocoordenades;
  }

  public void setLocalitzaciocoordenades(java.lang.String localitzaciocoordenades) {
    this.localitzaciocoordenades = localitzaciocoordenades;
  }


  private java.lang.String personaemail;

  public java.lang.String getPersonaemail() {
    return this.personaemail;
  }

  public void setPersonaemail(java.lang.String personaemail) {
    this.personaemail = personaemail;
  }


  public EvidenciaFilterForm() {
  }
  
  public EvidenciaFilterForm(EvidenciaFilterForm __toClone) {
    super(__toClone);
    this.evidenciaIDDesde = __toClone.evidenciaIDDesde;
    this.evidenciaIDFins = __toClone.evidenciaIDFins;
    this.nom = __toClone.nom;
    this.personanom = __toClone.personanom;
    this.personallinatge1 = __toClone.personallinatge1;
    this.personallinatge2 = __toClone.personallinatge2;
    this.personanif = __toClone.personanif;
    this.documenthash = __toClone.documenthash;
    this.documentmidaDesde = __toClone.documentmidaDesde;
    this.documentmidaFins = __toClone.documentmidaFins;
    this.datainiciDesde = __toClone.datainiciDesde;
    this.datainiciFins = __toClone.datainiciFins;
    this.datafiDesde = __toClone.datafiDesde;
    this.datafiFins = __toClone.datafiFins;
    this.usuariaplicacio = __toClone.usuariaplicacio;
    this.usuaripersona = __toClone.usuaripersona;
    this.estatcodiDesde = __toClone.estatcodiDesde;
    this.estatcodiFins = __toClone.estatcodiFins;
    this.estaterror = __toClone.estaterror;
    this.estatexcepcio = __toClone.estatexcepcio;
    this.personamobil = __toClone.personamobil;
    this.logintypeDesde = __toClone.logintypeDesde;
    this.logintypeFins = __toClone.logintypeFins;
    this.loginid = __toClone.loginid;
    this.logindataDesde = __toClone.logindataDesde;
    this.logindataFins = __toClone.logindataFins;
    this.localitzacioip = __toClone.localitzacioip;
    this.localitzaciocodipostal = __toClone.localitzaciocodipostal;
    this.localitzaciocoordenades = __toClone.localitzaciocoordenades;
    this.personaemail = __toClone.personaemail;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
