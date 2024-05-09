/*
 * API REST EXTERNA de EvidenciesIB - Evidencies
 * Conjunt de Serveis REST de EvidenciesIB per ser accedits des de l'exterior
 *
 * The version of the OpenAPI document: 1.0-SNAPSHOT
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package es.caib.evidenciesib.api.externa.client.evidencies.v1.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.model.EvidenciaFile;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Estructura de dades a enviar al servidor per iniciar un procés d&#39;Evidències
 */
@JsonPropertyOrder({
  EvidenciaStartRequest.JSON_PROPERTY_TITOL_EVIDENCIA,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_NIF,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_USERNAME,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_NOM,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_LLINATGE1,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_LLINATGE2,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_EMAIL,
  EvidenciaStartRequest.JSON_PROPERTY_PERSONA_MOBIL,
  EvidenciaStartRequest.JSON_PROPERTY_RAO_DE_LA_FIRMA,
  EvidenciaStartRequest.JSON_PROPERTY_LANGUAGE_DOCUMENT,
  EvidenciaStartRequest.JSON_PROPERTY_DOCUMENT_A_SIGNAR,
  EvidenciaStartRequest.JSON_PROPERTY_CALL_BACK_URL,
  EvidenciaStartRequest.JSON_PROPERTY_LANGUAGE_U_I
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EvidenciaStartRequest {
  public static final String JSON_PROPERTY_TITOL_EVIDENCIA = "titolEvidencia";
  private String titolEvidencia;

  public static final String JSON_PROPERTY_PERSONA_NIF = "personaNif";
  private String personaNif;

  public static final String JSON_PROPERTY_PERSONA_USERNAME = "personaUsername";
  private String personaUsername;

  public static final String JSON_PROPERTY_PERSONA_NOM = "personaNom";
  private String personaNom;

  public static final String JSON_PROPERTY_PERSONA_LLINATGE1 = "personaLlinatge1";
  private String personaLlinatge1;

  public static final String JSON_PROPERTY_PERSONA_LLINATGE2 = "personaLlinatge2";
  private String personaLlinatge2;

  public static final String JSON_PROPERTY_PERSONA_EMAIL = "personaEmail";
  private String personaEmail;

  public static final String JSON_PROPERTY_PERSONA_MOBIL = "personaMobil";
  private String personaMobil;

  public static final String JSON_PROPERTY_RAO_DE_LA_FIRMA = "raoDeLaFirma";
  private String raoDeLaFirma;

  public static final String JSON_PROPERTY_LANGUAGE_DOCUMENT = "languageDocument";
  private String languageDocument = "ca";

  public static final String JSON_PROPERTY_DOCUMENT_A_SIGNAR = "documentASignar";
  private EvidenciaFile documentASignar;

  public static final String JSON_PROPERTY_CALL_BACK_URL = "callBackUrl";
  private String callBackUrl;

  public static final String JSON_PROPERTY_LANGUAGE_U_I = "languageUI";
  private String languageUI = "ca";

  public EvidenciaStartRequest() {
  }

  public EvidenciaStartRequest titolEvidencia(String titolEvidencia) {
    
    this.titolEvidencia = titolEvidencia;
    return this;
  }

   /**
   * Titol descriptiu de l&#39;evidència que es durà a terme
   * @return titolEvidencia
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TITOL_EVIDENCIA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTitolEvidencia() {
    return titolEvidencia;
  }


  @JsonProperty(JSON_PROPERTY_TITOL_EVIDENCIA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTitolEvidencia(String titolEvidencia) {
    this.titolEvidencia = titolEvidencia;
  }


  public EvidenciaStartRequest personaNif(String personaNif) {
    
    this.personaNif = personaNif;
    return this;
  }

   /**
   * Nif de la persona
   * @return personaNif
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PERSONA_NIF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getPersonaNif() {
    return personaNif;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_NIF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPersonaNif(String personaNif) {
    this.personaNif = personaNif;
  }


  public EvidenciaStartRequest personaUsername(String personaUsername) {
    
    this.personaUsername = personaUsername;
    return this;
  }

   /**
   * Username de la persona
   * @return personaUsername
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaUsername() {
    return personaUsername;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_USERNAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaUsername(String personaUsername) {
    this.personaUsername = personaUsername;
  }


  public EvidenciaStartRequest personaNom(String personaNom) {
    
    this.personaNom = personaNom;
    return this;
  }

   /**
   * Nom de la persona
   * @return personaNom
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_NOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaNom() {
    return personaNom;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_NOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaNom(String personaNom) {
    this.personaNom = personaNom;
  }


  public EvidenciaStartRequest personaLlinatge1(String personaLlinatge1) {
    
    this.personaLlinatge1 = personaLlinatge1;
    return this;
  }

   /**
   * Primer llinatge de la persona
   * @return personaLlinatge1
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_LLINATGE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaLlinatge1() {
    return personaLlinatge1;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_LLINATGE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaLlinatge1(String personaLlinatge1) {
    this.personaLlinatge1 = personaLlinatge1;
  }


  public EvidenciaStartRequest personaLlinatge2(String personaLlinatge2) {
    
    this.personaLlinatge2 = personaLlinatge2;
    return this;
  }

   /**
   * Segon llintge de la persona
   * @return personaLlinatge2
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_LLINATGE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaLlinatge2() {
    return personaLlinatge2;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_LLINATGE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaLlinatge2(String personaLlinatge2) {
    this.personaLlinatge2 = personaLlinatge2;
  }


  public EvidenciaStartRequest personaEmail(String personaEmail) {
    
    this.personaEmail = personaEmail;
    return this;
  }

   /**
   * Correu electrònic de la persona
   * @return personaEmail
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaEmail() {
    return personaEmail;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaEmail(String personaEmail) {
    this.personaEmail = personaEmail;
  }


  public EvidenciaStartRequest personaMobil(String personaMobil) {
    
    this.personaMobil = personaMobil;
    return this;
  }

   /**
   * Mòbil de la persona
   * @return personaMobil
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PERSONA_MOBIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPersonaMobil() {
    return personaMobil;
  }


  @JsonProperty(JSON_PROPERTY_PERSONA_MOBIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonaMobil(String personaMobil) {
    this.personaMobil = personaMobil;
  }


  public EvidenciaStartRequest raoDeLaFirma(String raoDeLaFirma) {
    
    this.raoDeLaFirma = raoDeLaFirma;
    return this;
  }

   /**
   * Raó per la qual es requereix aquesta signatura
   * @return raoDeLaFirma
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_RAO_DE_LA_FIRMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRaoDeLaFirma() {
    return raoDeLaFirma;
  }


  @JsonProperty(JSON_PROPERTY_RAO_DE_LA_FIRMA)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRaoDeLaFirma(String raoDeLaFirma) {
    this.raoDeLaFirma = raoDeLaFirma;
  }


  public EvidenciaStartRequest languageDocument(String languageDocument) {
    
    this.languageDocument = languageDocument;
    return this;
  }

   /**
   * Idioma del document en ISO 639-1. Valors permesos &#39;ca&#39; i &#39;es&#39;
   * @return languageDocument
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LANGUAGE_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLanguageDocument() {
    return languageDocument;
  }


  @JsonProperty(JSON_PROPERTY_LANGUAGE_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLanguageDocument(String languageDocument) {
    this.languageDocument = languageDocument;
  }


  public EvidenciaStartRequest documentASignar(EvidenciaFile documentASignar) {
    
    this.documentASignar = documentASignar;
    return this;
  }

   /**
   * Get documentASignar
   * @return documentASignar
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DOCUMENT_A_SIGNAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EvidenciaFile getDocumentASignar() {
    return documentASignar;
  }


  @JsonProperty(JSON_PROPERTY_DOCUMENT_A_SIGNAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDocumentASignar(EvidenciaFile documentASignar) {
    this.documentASignar = documentASignar;
  }


  public EvidenciaStartRequest callBackUrl(String callBackUrl) {
    
    this.callBackUrl = callBackUrl;
    return this;
  }

   /**
   * URL de retorn quan el proces d&#39;evidències hagi acabat. A la URL la cadena {0} es substituirà per l&#39;identificador de l&#39;evidència (evidenciaID)
   * @return callBackUrl
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CALL_BACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCallBackUrl() {
    return callBackUrl;
  }


  @JsonProperty(JSON_PROPERTY_CALL_BACK_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCallBackUrl(String callBackUrl) {
    this.callBackUrl = callBackUrl;
  }


  public EvidenciaStartRequest languageUI(String languageUI) {
    
    this.languageUI = languageUI;
    return this;
  }

   /**
   * Idioma del missatges d&#39;error en format ISO 639-1. Valors permesos &#39;ca&#39; i &#39;es&#39;
   * @return languageUI
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LANGUAGE_U_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLanguageUI() {
    return languageUI;
  }


  @JsonProperty(JSON_PROPERTY_LANGUAGE_U_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLanguageUI(String languageUI) {
    this.languageUI = languageUI;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvidenciaStartRequest evidenciaStartRequest = (EvidenciaStartRequest) o;
    return Objects.equals(this.titolEvidencia, evidenciaStartRequest.titolEvidencia) &&
        Objects.equals(this.personaNif, evidenciaStartRequest.personaNif) &&
        Objects.equals(this.personaUsername, evidenciaStartRequest.personaUsername) &&
        Objects.equals(this.personaNom, evidenciaStartRequest.personaNom) &&
        Objects.equals(this.personaLlinatge1, evidenciaStartRequest.personaLlinatge1) &&
        Objects.equals(this.personaLlinatge2, evidenciaStartRequest.personaLlinatge2) &&
        Objects.equals(this.personaEmail, evidenciaStartRequest.personaEmail) &&
        Objects.equals(this.personaMobil, evidenciaStartRequest.personaMobil) &&
        Objects.equals(this.raoDeLaFirma, evidenciaStartRequest.raoDeLaFirma) &&
        Objects.equals(this.languageDocument, evidenciaStartRequest.languageDocument) &&
        Objects.equals(this.documentASignar, evidenciaStartRequest.documentASignar) &&
        Objects.equals(this.callBackUrl, evidenciaStartRequest.callBackUrl) &&
        Objects.equals(this.languageUI, evidenciaStartRequest.languageUI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titolEvidencia, personaNif, personaUsername, personaNom, personaLlinatge1, personaLlinatge2, personaEmail, personaMobil, raoDeLaFirma, languageDocument, documentASignar, callBackUrl, languageUI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvidenciaStartRequest {\n");
    sb.append("    titolEvidencia: ").append(toIndentedString(titolEvidencia)).append("\n");
    sb.append("    personaNif: ").append(toIndentedString(personaNif)).append("\n");
    sb.append("    personaUsername: ").append(toIndentedString(personaUsername)).append("\n");
    sb.append("    personaNom: ").append(toIndentedString(personaNom)).append("\n");
    sb.append("    personaLlinatge1: ").append(toIndentedString(personaLlinatge1)).append("\n");
    sb.append("    personaLlinatge2: ").append(toIndentedString(personaLlinatge2)).append("\n");
    sb.append("    personaEmail: ").append(toIndentedString(personaEmail)).append("\n");
    sb.append("    personaMobil: ").append(toIndentedString(personaMobil)).append("\n");
    sb.append("    raoDeLaFirma: ").append(toIndentedString(raoDeLaFirma)).append("\n");
    sb.append("    languageDocument: ").append(toIndentedString(languageDocument)).append("\n");
    sb.append("    documentASignar: ").append(toIndentedString(documentASignar)).append("\n");
    sb.append("    callBackUrl: ").append(toIndentedString(callBackUrl)).append("\n");
    sb.append("    languageUI: ").append(toIndentedString(languageUI)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

