/*
 * API REST INTERNA de EvidenciesIB
 * Conjunt de Serveis REST de EvidenciesIB per ser accedits des de l'interior
 *
 * OpenAPI spec version: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package es.caib.evidenciesib.apiinterna.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * ExamplePojo
 */


public class ExamplePojo {
  @JsonProperty("versio")
  private String versio = null;

  public ExamplePojo versio(String versio) {
    this.versio = versio;
    return this;
  }

   /**
   * Get versio
   * @return versio
  **/
  @Schema(description = "")
  public String getVersio() {
    return versio;
  }

  public void setVersio(String versio) {
    this.versio = versio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExamplePojo examplePojo = (ExamplePojo) o;
    return Objects.equals(this.versio, examplePojo.versio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(versio);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExamplePojo {\n");
    
    sb.append("    versio: ").append(toIndentedString(versio)).append("\n");
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
