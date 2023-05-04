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
import es.caib.evidenciesib.apiinterna.client.model.SendMessageResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * SendMessageResult
 */


public class SendMessageResult {
  @JsonProperty("code")
  private SendMessageResultCode code = null;

  @JsonProperty("message")
  private String message = null;

  public SendMessageResult code(SendMessageResultCode code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @Schema(description = "")
  public SendMessageResultCode getCode() {
    return code;
  }

  public void setCode(SendMessageResultCode code) {
    this.code = code;
  }

  public SendMessageResult message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Missatge si hi ha error
   * @return message
  **/
  @Schema(description = "Missatge si hi ha error")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMessageResult sendMessageResult = (SendMessageResult) o;
    return Objects.equals(this.code, sendMessageResult.code) &&
        Objects.equals(this.message, sendMessageResult.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMessageResult {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
