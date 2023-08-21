/*
 * API REST EXTERNA de EvidenciesIB
 * Conjunt de Serveis REST de EvidenciesIB per ser accedits des de l'exterior
 *
 * OpenAPI spec version: 1.0.0
 * Contact: governdigital@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.evidenciesib.apiexterna.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * EvidenciaStartResponse
 */


public class EvidenciaStartResponse {
  @JsonProperty("evidenciaID")
  private Long evidenciaID = null;

  @JsonProperty("evidenciaUrlRedirect")
  private String evidenciaUrlRedirect = null;

  public EvidenciaStartResponse evidenciaID(Long evidenciaID) {
    this.evidenciaID = evidenciaID;
    return this;
  }

   /**
   * Get evidenciaID
   * @return evidenciaID
  **/
  @Schema(required = true, description = "")
  public Long getEvidenciaID() {
    return evidenciaID;
  }

  public void setEvidenciaID(Long evidenciaID) {
    this.evidenciaID = evidenciaID;
  }

  public EvidenciaStartResponse evidenciaUrlRedirect(String evidenciaUrlRedirect) {
    this.evidenciaUrlRedirect = evidenciaUrlRedirect;
    return this;
  }

   /**
   * Get evidenciaUrlRedirect
   * @return evidenciaUrlRedirect
  **/
  @Schema(required = true, description = "")
  public String getEvidenciaUrlRedirect() {
    return evidenciaUrlRedirect;
  }

  public void setEvidenciaUrlRedirect(String evidenciaUrlRedirect) {
    this.evidenciaUrlRedirect = evidenciaUrlRedirect;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvidenciaStartResponse evidenciaStartResponse = (EvidenciaStartResponse) o;
    return Objects.equals(this.evidenciaID, evidenciaStartResponse.evidenciaID) &&
        Objects.equals(this.evidenciaUrlRedirect, evidenciaStartResponse.evidenciaUrlRedirect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evidenciaID, evidenciaUrlRedirect);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvidenciaStartResponse {\n");
    
    sb.append("    evidenciaID: ").append(toIndentedString(evidenciaID)).append("\n");
    sb.append("    evidenciaUrlRedirect: ").append(toIndentedString(evidenciaUrlRedirect)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
