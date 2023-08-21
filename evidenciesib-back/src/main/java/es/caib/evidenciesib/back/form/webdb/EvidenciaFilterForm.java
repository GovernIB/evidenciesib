
package es.caib.evidenciesib.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


  private java.lang.String personaNom;

  public java.lang.String getPersonaNom() {
    return this.personaNom;
  }

  public void setPersonaNom(java.lang.String personaNom) {
    this.personaNom = personaNom;
  }


  private java.lang.String personaLlinatge1;

  public java.lang.String getPersonaLlinatge1() {
    return this.personaLlinatge1;
  }

  public void setPersonaLlinatge1(java.lang.String personaLlinatge1) {
    this.personaLlinatge1 = personaLlinatge1;
  }


  private java.lang.String personaLlinatge2;

  public java.lang.String getPersonaLlinatge2() {
    return this.personaLlinatge2;
  }

  public void setPersonaLlinatge2(java.lang.String personaLlinatge2) {
    this.personaLlinatge2 = personaLlinatge2;
  }


  private java.lang.String personaNif;

  public java.lang.String getPersonaNif() {
    return this.personaNif;
  }

  public void setPersonaNif(java.lang.String personaNif) {
    this.personaNif = personaNif;
  }


  private java.lang.String personaEmail;

  public java.lang.String getPersonaEmail() {
    return this.personaEmail;
  }

  public void setPersonaEmail(java.lang.String personaEmail) {
    this.personaEmail = personaEmail;
  }


  private java.lang.String personaMobil;

  public java.lang.String getPersonaMobil() {
    return this.personaMobil;
  }

  public void setPersonaMobil(java.lang.String personaMobil) {
    this.personaMobil = personaMobil;
  }


  private java.sql.Timestamp dataIniciDesde;

  public java.sql.Timestamp getDataIniciDesde() {
    return this.dataIniciDesde;
  }

  public void setDataIniciDesde(java.sql.Timestamp dataIniciDesde) {
    this.dataIniciDesde = dataIniciDesde;
  }


  private java.sql.Timestamp dataIniciFins;

  public java.sql.Timestamp getDataIniciFins() {
    return this.dataIniciFins;
  }

  public void setDataIniciFins(java.sql.Timestamp dataIniciFins) {
    this.dataIniciFins = dataIniciFins;
  }


  private java.sql.Timestamp dataFiDesde;

  public java.sql.Timestamp getDataFiDesde() {
    return this.dataFiDesde;
  }

  public void setDataFiDesde(java.sql.Timestamp dataFiDesde) {
    this.dataFiDesde = dataFiDesde;
  }


  private java.sql.Timestamp dataFiFins;

  public java.sql.Timestamp getDataFiFins() {
    return this.dataFiFins;
  }

  public void setDataFiFins(java.sql.Timestamp dataFiFins) {
    this.dataFiFins = dataFiFins;
  }


  private java.lang.String usuariAplicacio;

  public java.lang.String getUsuariAplicacio() {
    return this.usuariAplicacio;
  }

  public void setUsuariAplicacio(java.lang.String usuariAplicacio) {
    this.usuariAplicacio = usuariAplicacio;
  }


  private java.lang.String usuariPersona;

  public java.lang.String getUsuariPersona() {
    return this.usuariPersona;
  }

  public void setUsuariPersona(java.lang.String usuariPersona) {
    this.usuariPersona = usuariPersona;
  }


  private java.util.List<java.lang.Integer> estatCodiSelect;

  public java.util.List<java.lang.Integer> getEstatCodiSelect() {
    return this.estatCodiSelect;
  }

  public void setEstatCodiSelect(java.util.List<java.lang.Integer> estatCodiSelect) {
    this.estatCodiSelect = estatCodiSelect;
  }


  private java.lang.String estatError;

  public java.lang.String getEstatError() {
    return this.estatError;
  }

  public void setEstatError(java.lang.String estatError) {
    this.estatError = estatError;
  }


  private java.lang.String estatExcepcio;

  public java.lang.String getEstatExcepcio() {
    return this.estatExcepcio;
  }

  public void setEstatExcepcio(java.lang.String estatExcepcio) {
    this.estatExcepcio = estatExcepcio;
  }


  private java.util.List<java.lang.Integer> loginTypeSelect;

  public java.util.List<java.lang.Integer> getLoginTypeSelect() {
    return this.loginTypeSelect;
  }

  public void setLoginTypeSelect(java.util.List<java.lang.Integer> loginTypeSelect) {
    this.loginTypeSelect = loginTypeSelect;
  }


  private java.lang.String loginSubtype;

  public java.lang.String getLoginSubtype() {
    return this.loginSubtype;
  }

  public void setLoginSubtype(java.lang.String loginSubtype) {
    this.loginSubtype = loginSubtype;
  }


  private java.lang.String loginQaa;

  public java.lang.String getLoginQaa() {
    return this.loginQaa;
  }

  public void setLoginQaa(java.lang.String loginQaa) {
    this.loginQaa = loginQaa;
  }


  private java.sql.Timestamp loginDataDesde;

  public java.sql.Timestamp getLoginDataDesde() {
    return this.loginDataDesde;
  }

  public void setLoginDataDesde(java.sql.Timestamp loginDataDesde) {
    this.loginDataDesde = loginDataDesde;
  }


  private java.sql.Timestamp loginDataFins;

  public java.sql.Timestamp getLoginDataFins() {
    return this.loginDataFins;
  }

  public void setLoginDataFins(java.sql.Timestamp loginDataFins) {
    this.loginDataFins = loginDataFins;
  }


  private java.lang.String loginId;

  public java.lang.String getLoginId() {
    return this.loginId;
  }

  public void setLoginId(java.lang.String loginId) {
    this.loginId = loginId;
  }


  private java.lang.String loginAuthMethod;

  public java.lang.String getLoginAuthMethod() {
    return this.loginAuthMethod;
  }

  public void setLoginAuthMethod(java.lang.String loginAuthMethod) {
    this.loginAuthMethod = loginAuthMethod;
  }


  private java.lang.String loginAdditionalProperties;

  public java.lang.String getLoginAdditionalProperties() {
    return this.loginAdditionalProperties;
  }

  public void setLoginAdditionalProperties(java.lang.String loginAdditionalProperties) {
    this.loginAdditionalProperties = loginAdditionalProperties;
  }


  private java.lang.String localitzacioIp;

  public java.lang.String getLocalitzacioIp() {
    return this.localitzacioIp;
  }

  public void setLocalitzacioIp(java.lang.String localitzacioIp) {
    this.localitzacioIp = localitzacioIp;
  }


  private java.lang.String localitzacioCodiPostal;

  public java.lang.String getLocalitzacioCodiPostal() {
    return this.localitzacioCodiPostal;
  }

  public void setLocalitzacioCodiPostal(java.lang.String localitzacioCodiPostal) {
    this.localitzacioCodiPostal = localitzacioCodiPostal;
  }


  private java.lang.String localitzacioLatitud;

  public java.lang.String getLocalitzacioLatitud() {
    return this.localitzacioLatitud;
  }

  public void setLocalitzacioLatitud(java.lang.String localitzacioLatitud) {
    this.localitzacioLatitud = localitzacioLatitud;
  }


  private java.lang.String localitzacioLongitud;

  public java.lang.String getLocalitzacioLongitud() {
    return this.localitzacioLongitud;
  }

  public void setLocalitzacioLongitud(java.lang.String localitzacioLongitud) {
    this.localitzacioLongitud = localitzacioLongitud;
  }


  private java.lang.String localitzacioCiutat;

  public java.lang.String getLocalitzacioCiutat() {
    return this.localitzacioCiutat;
  }

  public void setLocalitzacioCiutat(java.lang.String localitzacioCiutat) {
    this.localitzacioCiutat = localitzacioCiutat;
  }


  private java.lang.String localitzacioRegio;

  public java.lang.String getLocalitzacioRegio() {
    return this.localitzacioRegio;
  }

  public void setLocalitzacioRegio(java.lang.String localitzacioRegio) {
    this.localitzacioRegio = localitzacioRegio;
  }


  private java.lang.String localitzacioPais;

  public java.lang.String getLocalitzacioPais() {
    return this.localitzacioPais;
  }

  public void setLocalitzacioPais(java.lang.String localitzacioPais) {
    this.localitzacioPais = localitzacioPais;
  }


  private java.lang.String firmaReason;

  public java.lang.String getFirmaReason() {
    return this.firmaReason;
  }

  public void setFirmaReason(java.lang.String firmaReason) {
    this.firmaReason = firmaReason;
  }


  private java.lang.String firmaIdiomaDocument;

  public java.lang.String getFirmaIdiomaDocument() {
    return this.firmaIdiomaDocument;
  }

  public void setFirmaIdiomaDocument(java.lang.String firmaIdiomaDocument) {
    this.firmaIdiomaDocument = firmaIdiomaDocument;
  }


  private java.util.List<java.lang.Integer> firmaTipusDocumentalSelect;

  public java.util.List<java.lang.Integer> getFirmaTipusDocumentalSelect() {
    return this.firmaTipusDocumentalSelect;
  }

  public void setFirmaTipusDocumentalSelect(java.util.List<java.lang.Integer> firmaTipusDocumentalSelect) {
    this.firmaTipusDocumentalSelect = firmaTipusDocumentalSelect;
  }


  private java.lang.String callBackUrl;

  public java.lang.String getCallBackUrl() {
    return this.callBackUrl;
  }

  public void setCallBackUrl(java.lang.String callBackUrl) {
    this.callBackUrl = callBackUrl;
  }


  public EvidenciaFilterForm() {
  }
  
  public EvidenciaFilterForm(EvidenciaFilterForm __toClone) {
    super(__toClone);
    this.evidenciaIDDesde = __toClone.evidenciaIDDesde;
    this.evidenciaIDFins = __toClone.evidenciaIDFins;
    this.nom = __toClone.nom;
    this.personaNom = __toClone.personaNom;
    this.personaLlinatge1 = __toClone.personaLlinatge1;
    this.personaLlinatge2 = __toClone.personaLlinatge2;
    this.personaNif = __toClone.personaNif;
    this.personaEmail = __toClone.personaEmail;
    this.personaMobil = __toClone.personaMobil;
    this.dataIniciDesde = __toClone.dataIniciDesde;
    this.dataIniciFins = __toClone.dataIniciFins;
    this.dataFiDesde = __toClone.dataFiDesde;
    this.dataFiFins = __toClone.dataFiFins;
    this.usuariAplicacio = __toClone.usuariAplicacio;
    this.usuariPersona = __toClone.usuariPersona;
    this.estatCodiSelect = __toClone.estatCodiSelect;
    this.estatError = __toClone.estatError;
    this.estatExcepcio = __toClone.estatExcepcio;
    this.loginTypeSelect = __toClone.loginTypeSelect;
    this.loginSubtype = __toClone.loginSubtype;
    this.loginQaa = __toClone.loginQaa;
    this.loginDataDesde = __toClone.loginDataDesde;
    this.loginDataFins = __toClone.loginDataFins;
    this.loginId = __toClone.loginId;
    this.loginAuthMethod = __toClone.loginAuthMethod;
    this.loginAdditionalProperties = __toClone.loginAdditionalProperties;
    this.localitzacioIp = __toClone.localitzacioIp;
    this.localitzacioCodiPostal = __toClone.localitzacioCodiPostal;
    this.localitzacioLatitud = __toClone.localitzacioLatitud;
    this.localitzacioLongitud = __toClone.localitzacioLongitud;
    this.localitzacioCiutat = __toClone.localitzacioCiutat;
    this.localitzacioRegio = __toClone.localitzacioRegio;
    this.localitzacioPais = __toClone.localitzacioPais;
    this.firmaReason = __toClone.firmaReason;
    this.firmaIdiomaDocument = __toClone.firmaIdiomaDocument;
    this.firmaTipusDocumentalSelect = __toClone.firmaTipusDocumentalSelect;
    this.callBackUrl = __toClone.callBackUrl;
    this.mapOfValuesForEstatCodi = __toClone.mapOfValuesForEstatCodi;
    this.mapOfValuesForLoginType = __toClone.mapOfValuesForLoginType;
    this.mapOfValuesForFirmaIdiomaDocument = __toClone.mapOfValuesForFirmaIdiomaDocument;
    this.mapOfValuesForFirmaTipusDocumental = __toClone.mapOfValuesForFirmaTipusDocumental;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { NOM ,PERSONALLINATGE1 ,PERSONANIF ,PERSONAEMAIL ,USUARIPERSONA ,ESTATCODI ,ESTATERROR ,LOCALITZACIOIP ,FIRMATIPUSDOCUMENTAL }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] { DATAINICI ,DATAFI ,USUARIAPLICACIO }));
  }


  protected OrderBy[] defaultOrderBy = new OrderBy[] {new OrderBy(DATAINICI, org.fundaciobit.genapp.common.query.OrderType.DESC )};


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
  private Map<String, String> mapOfValuesForEstatCodi;

  public Map<String, String> getMapOfValuesForEstatCodi() {
    return this.mapOfValuesForEstatCodi;
  }

  public void setMapOfValuesForEstatCodi(Map<String, String> mapOfValuesForEstatCodi) {
    this.mapOfValuesForEstatCodi = mapOfValuesForEstatCodi;
  }



  private Map<String, String> mapOfValuesForLoginType;

  public Map<String, String> getMapOfValuesForLoginType() {
    return this.mapOfValuesForLoginType;
  }

  public void setMapOfValuesForLoginType(Map<String, String> mapOfValuesForLoginType) {
    this.mapOfValuesForLoginType = mapOfValuesForLoginType;
  }



  private Map<String, String> mapOfValuesForFirmaIdiomaDocument;

  public Map<String, String> getMapOfValuesForFirmaIdiomaDocument() {
    return this.mapOfValuesForFirmaIdiomaDocument;
  }

  public void setMapOfValuesForFirmaIdiomaDocument(Map<String, String> mapOfValuesForFirmaIdiomaDocument) {
    this.mapOfValuesForFirmaIdiomaDocument = mapOfValuesForFirmaIdiomaDocument;
  }



  private Map<String, String> mapOfValuesForFirmaTipusDocumental;

  public Map<String, String> getMapOfValuesForFirmaTipusDocumental() {
    return this.mapOfValuesForFirmaTipusDocumental;
  }

  public void setMapOfValuesForFirmaTipusDocumental(Map<String, String> mapOfValuesForFirmaTipusDocumental) {
    this.mapOfValuesForFirmaTipusDocumental = mapOfValuesForFirmaTipusDocumental;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
