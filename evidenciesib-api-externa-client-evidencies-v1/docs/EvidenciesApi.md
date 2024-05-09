# EvidenciesApi

All URIs are relative to */evidenciesibapi/externa*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**callList**](EvidenciesApi.md#callList) | **GET** /secure/evidencies/list | Retorna un llistat de les evidencies  |
| [**get**](EvidenciesApi.md#get) | **GET** /secure/evidencies/get/{evidenciaID} | Retorna informació d&#39;una evidència a partir del seu id |
| [**getfile**](EvidenciesApi.md#getfile) | **GET** /secure/evidencies/getfile/{evidenciaID}/{encryptedFileID} | Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID |
| [**getfilebase64**](EvidenciesApi.md#getfilebase64) | **GET** /secure/evidencies/getfilebase64/{evidenciaID}/{encryptedFileID} | Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID |
| [**start**](EvidenciesApi.md#start) | **POST** /secure/evidencies/start | Primera cridada a realitzar per iniciar un procés d&#39;evidències |
| [**versio**](EvidenciesApi.md#versio) | **GET** /secure/evidencies/versio | Retorna la versió d&#39;aquest Servei |



## callList

> EvidenciaWsPaginacio callList(inici, fi, page, pagesize, language)

Retorna un llistat de les evidencies 

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        String inici = "2022-08-29"; // String | Data d'inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades
        String fi = "2023-12-31"; // String | Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades
        Integer page = 1; // Integer | Pàgina de la que es volen obtenir les dades
        Integer pagesize = 10; // Integer | Quantitat d'elements a retornar
        String language = "ca"; // String | Idioma en que s'han de retornar les dades(Només suportat 'ca' o 'es')
        try {
            EvidenciaWsPaginacio result = apiInstance.callList(inici, fi, page, pagesize, language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#callList");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **inici** | **String**| Data d&#39;inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades | [optional] |
| **fi** | **String**| Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades | [optional] |
| **page** | **Integer**| Pàgina de la que es volen obtenir les dades | [optional] |
| **pagesize** | **Integer**| Quantitat d&#39;elements a retornar | [optional] |
| **language** | **String**| Idioma en que s&#39;han de retornar les dades(Només suportat &#39;ca&#39; o &#39;es&#39;) | [optional] |

### Return type

[**EvidenciaWsPaginacio**](EvidenciaWsPaginacio.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | EFIB: Retornades dades obertes correctament |  -  |
| **400** | EFIB: Paràmetres incorrectes |  -  |
| **401** | EFIB: No Autenticat |  -  |
| **403** | EFIB: No Autoritzat |  -  |
| **500** | EFIB: Error durant la consulta de les dades obertes |  -  |


## get

> EvidenciaWs get(evidenciaID, language)

Retorna informació d&#39;una evidència a partir del seu id

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        Long evidenciaID = 56L; // Long | Identificador de l'evidència de la que volem informació
        String language = "ca"; // String | Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')
        try {
            EvidenciaWs result = apiInstance.get(evidenciaID, language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#get");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **evidenciaID** | **Long**| Identificador de l&#39;evidència de la que volem informació | |
| **language** | **String**| Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) | [optional] |

### Return type

[**EvidenciaWs**](EvidenciaWs.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retornada correctament la informació de l&#39;evidència |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getfile

> EvidenciaFile getfile(evidenciaID, encryptedFileID, language)

Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        Long evidenciaID = 56L; // Long | Identificador de l'evidència de la que volem informació
        String encryptedFileID = "encryptedFileID_example"; // String | Identificador encriptat del fitxer que volem descarregar.
        String language = "ca"; // String | Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')
        try {
            EvidenciaFile result = apiInstance.getfile(evidenciaID, encryptedFileID, language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#getfile");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **evidenciaID** | **Long**| Identificador de l&#39;evidència de la que volem informació | |
| **encryptedFileID** | **String**| Identificador encriptat del fitxer que volem descarregar. | |
| **language** | **String**| Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) | [optional] |

### Return type

[**EvidenciaFile**](EvidenciaFile.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retornada correctament la informació de l&#39;evidència |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## getfilebase64

> EvidenciaFileBase64 getfilebase64(evidenciaID, encryptedFileID, language)

Retorna informació d&#39;un fitxer d&#39;una evidència a partir del encryptedFileID

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        Long evidenciaID = 56L; // Long | Identificador de l'evidència de la que volem informació
        String encryptedFileID = "encryptedFileID_example"; // String | Identificador encriptat del fitxer que volem descarregar.
        String language = "ca"; // String | Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')
        try {
            EvidenciaFileBase64 result = apiInstance.getfilebase64(evidenciaID, encryptedFileID, language);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#getfilebase64");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **evidenciaID** | **Long**| Identificador de l&#39;evidència de la que volem informació | |
| **encryptedFileID** | **String**| Identificador encriptat del fitxer que volem descarregar. | |
| **language** | **String**| Idioma en que s&#39;han de retornar les dades i errors(Només suportat &#39;ca&#39; o &#39;es&#39;) | [optional] |

### Return type

[**EvidenciaFileBase64**](EvidenciaFileBase64.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retornada correctament la informació de l&#39;evidència |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## start

> EvidenciaStartResponse start(evidenciaStartRequest)

Primera cridada a realitzar per iniciar un procés d&#39;evidències

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        EvidenciaStartRequest evidenciaStartRequest = new EvidenciaStartRequest(); // EvidenciaStartRequest | Estructura de dades inicials per iniciar un procés d'evidències
        try {
            EvidenciaStartResponse result = apiInstance.start(evidenciaStartRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#start");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **evidenciaStartRequest** | [**EvidenciaStartRequest**](EvidenciaStartRequest.md)| Estructura de dades inicials per iniciar un procés d&#39;evidències | [optional] |

### Return type

[**EvidenciaStartResponse**](EvidenciaStartResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Procés de recolecció d&#39;evidències inciaciat correctament |  -  |
| **400** | Paràmetres incorrectes |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |


## versio

> String versio()

Retorna la versió d&#39;aquest Servei

### Example

```java
// Import classes:
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiClient;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.ApiException;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.Configuration;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.auth.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.services.models.*;
import es.caib.evidenciesib.api.externa.client.evidencies.v1.api.EvidenciesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/evidenciesibapi/externa");
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        EvidenciesApi apiInstance = new EvidenciesApi(defaultClient);
        try {
            String result = apiInstance.versio();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EvidenciesApi#versio");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retornada correctament la versió d&#39;aquest Servei |  -  |
| **401** | No Autenticat |  -  |
| **403** | No Autoritzat |  -  |
| **500** | Error no controlat |  -  |
| **510** | Només s&#39;utilitza per crear fitxer de constants... |  -  |

