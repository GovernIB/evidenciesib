package es.caib.evidenciesib.apiexterna.client.api;

import es.caib.evidenciesib.apiexterna.client.services.ApiException;
import es.caib.evidenciesib.apiexterna.client.services.ApiClient;
import es.caib.evidenciesib.apiexterna.client.services.Configuration;
import es.caib.evidenciesib.apiexterna.client.services.Pair;

import javax.ws.rs.core.GenericType;

import es.caib.evidenciesib.apiexterna.client.model.ConstantsWs;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaFile;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaFileBase64;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaStartRequest;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaStartResponse;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaWs;
import es.caib.evidenciesib.apiexterna.client.model.EvidenciaWsPaginacio;
import es.caib.evidenciesib.apiexterna.client.model.RestExceptionInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EvidenciesApi {
  private ApiClient apiClient;

  public EvidenciesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EvidenciesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Retorna un llistat de les evidencies 
   * 
   * @param inici Data d&#39;inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades (optional)
   * @param fi Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades (optional)
   * @param page Pàgina de la que es volen obtenir les dades (optional)
   * @param pagesize Quantitat d&#39;elements a retornar (optional)
   * @param language Idioma en que s&#39;han de retornar les dades(Només suportat &#39;ca&#39; o &#39;es&#39;) (optional)
   * @return a {@code EvidenciaWsPaginacio}
   * @throws ApiException if fails to make API call
   */
  public EvidenciaWsPaginacio callList(String inici, String fi, Integer page, Integer pagesize, String language) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/list".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "inici", inici));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "fi", fi));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "pagesize", pagesize));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<EvidenciaWsPaginacio> localVarReturnType = new GenericType<EvidenciaWsPaginacio>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna informació d&#39;una evidència a partir del seu id
   * 
   * @param evidenciaID Identificador de l&#39;evidència de la que volem informació (required)
   * @param language Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) (optional)
   * @return a {@code EvidenciaWs}
   * @throws ApiException if fails to make API call
   */
  public EvidenciaWs get(Long evidenciaID, String language) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'evidenciaID' is set
    if (evidenciaID == null) {
      throw new ApiException(400, "Missing the required parameter 'evidenciaID' when calling get");
    }
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/get/{evidenciaID}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "evidenciaID" + "\\}", apiClient.escapeString(evidenciaID.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<EvidenciaWs> localVarReturnType = new GenericType<EvidenciaWs>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID
   * 
   * @param evidenciaID Identificador de l&#39;evidència de la que volem informació (required)
   * @param encryptedFileID Identificador encriptat del fitxer que volem descarregar. (required)
   * @param language Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) (optional)
   * @return a {@code EvidenciaFile}
   * @throws ApiException if fails to make API call
   */
  public EvidenciaFile getfile(Long evidenciaID, String encryptedFileID, String language) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'evidenciaID' is set
    if (evidenciaID == null) {
      throw new ApiException(400, "Missing the required parameter 'evidenciaID' when calling getfile");
    }
    
    // verify the required parameter 'encryptedFileID' is set
    if (encryptedFileID == null) {
      throw new ApiException(400, "Missing the required parameter 'encryptedFileID' when calling getfile");
    }
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/getfile/{evidenciaID}/{encryptedFileID}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "evidenciaID" + "\\}", apiClient.escapeString(evidenciaID.toString()))
      .replaceAll("\\{" + "encryptedFileID" + "\\}", apiClient.escapeString(encryptedFileID.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<EvidenciaFile> localVarReturnType = new GenericType<EvidenciaFile>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID
   * 
   * @param evidenciaID Identificador de l&#39;evidència de la que volem informació (required)
   * @param encryptedFileID Identificador encriptat del fitxer que volem descarregar. (required)
   * @param language Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) (optional)
   * @return a {@code EvidenciaFileBase64}
   * @throws ApiException if fails to make API call
   */
  public EvidenciaFileBase64 getfilebase64(Long evidenciaID, String encryptedFileID, String language) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'evidenciaID' is set
    if (evidenciaID == null) {
      throw new ApiException(400, "Missing the required parameter 'evidenciaID' when calling getfilebase64");
    }
    
    // verify the required parameter 'encryptedFileID' is set
    if (encryptedFileID == null) {
      throw new ApiException(400, "Missing the required parameter 'encryptedFileID' when calling getfilebase64");
    }
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/getfilebase64/{evidenciaID}/{encryptedFileID}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "evidenciaID" + "\\}", apiClient.escapeString(evidenciaID.toString()))
      .replaceAll("\\{" + "encryptedFileID" + "\\}", apiClient.escapeString(encryptedFileID.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "language", language));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<EvidenciaFileBase64> localVarReturnType = new GenericType<EvidenciaFileBase64>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Primera cridada a realitzar per iniciar un procés d&#39;evidències
   * 
   * @param evidenciaStartRequest Estructura de dades inicials per iniciar un procés d&#39;evidències (optional)
   * @return a {@code EvidenciaStartResponse}
   * @throws ApiException if fails to make API call
   */
  public EvidenciaStartResponse start(EvidenciaStartRequest evidenciaStartRequest) throws ApiException {
    Object localVarPostBody = evidenciaStartRequest;
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/start".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<EvidenciaStartResponse> localVarReturnType = new GenericType<EvidenciaStartResponse>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Retorna la versió d&#39;aquest Servei
   * 
   * @return a {@code String}
   * @throws ApiException if fails to make API call
   */
  public String versio() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/secure/evidencies/versio".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "BasicAuth" };

    GenericType<String> localVarReturnType = new GenericType<String>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
