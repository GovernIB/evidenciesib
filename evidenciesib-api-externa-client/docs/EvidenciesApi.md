# EvidenciesApi

All URIs are relative to */evidenciesibapi/externa*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get**](EvidenciesApi.md#get) | **GET** /secure/evidencies/get/{evidenciaID} | Retorna informació d&#x27;una evidència a partir del seu id
[**getfile**](EvidenciesApi.md#getfile) | **GET** /secure/evidencies/getfile/{evidenciaID}/{encryptedFileID} | Retorna informació d&#x27;una evidència a partir del seu id
[**list**](EvidenciesApi.md#list) | **GET** /secure/evidencies/list | Retorna un llistat de les evidencies 
[**start**](EvidenciesApi.md#start) | **POST** /secure/evidencies/start | Primera cridada a realitzar per iniciar un procés d&#x27;evidències

<a name="get"></a>
# **get**
> Evidencia get(evidenciaID, language)

Retorna informació d&#x27;una evidència a partir del seu id

### Example
```java
// Import classes:
//import es.caib.evidenciesib.apiexterna.client.services.ApiClient;
//import es.caib.evidenciesib.apiexterna.client.services.ApiException;
//import es.caib.evidenciesib.apiexterna.client.services.Configuration;
//import es.caib.evidenciesib.apiexterna.client.services.auth.*;
//import es.caib.evidenciesib.apiexterna.client.api.EvidenciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

EvidenciesApi apiInstance = new EvidenciesApi();
Long evidenciaID = 789L; // Long | Identificador de l'evidència de la que volem informació
String language = "language_example"; // String | Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')
try {
    Evidencia result = apiInstance.get(evidenciaID, language);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EvidenciesApi#get");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **evidenciaID** | **Long**| Identificador de l&#x27;evidència de la que volem informació |
 **language** | **String**| Idioma en que s&#x27;han de retornar les dades i errors(Només suportat &#x27;ca&#x27; o &#x27;es&#x27;) | [optional]

### Return type

[**Evidencia**](Evidencia.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getfile"></a>
# **getfile**
> EvidenciaFile getfile(evidenciaID, encryptedFileID, language)

Retorna informació d&#x27;una evidència a partir del seu id

### Example
```java
// Import classes:
//import es.caib.evidenciesib.apiexterna.client.services.ApiClient;
//import es.caib.evidenciesib.apiexterna.client.services.ApiException;
//import es.caib.evidenciesib.apiexterna.client.services.Configuration;
//import es.caib.evidenciesib.apiexterna.client.services.auth.*;
//import es.caib.evidenciesib.apiexterna.client.api.EvidenciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

EvidenciesApi apiInstance = new EvidenciesApi();
Long evidenciaID = 789L; // Long | Identificador de l'evidència de la que volem informació
String encryptedFileID = "encryptedFileID_example"; // String | Identificador encriptat del fitxer que volem descarregar.
String language = "language_example"; // String | Idioma en que s'han de retornar les dades i errors(Només suportat 'ca' o 'es')
try {
    EvidenciaFile result = apiInstance.getfile(evidenciaID, encryptedFileID, language);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EvidenciesApi#getfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **evidenciaID** | **Long**| Identificador de l&#x27;evidència de la que volem informació |
 **encryptedFileID** | **String**| Identificador encriptat del fitxer que volem descarregar. |
 **language** | **String**| Idioma en que s&#x27;han de retornar les dades i errors(Només suportat &#x27;ca&#x27; o &#x27;es&#x27;) | [optional]

### Return type

[**EvidenciaFile**](EvidenciaFile.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="list"></a>
# **list**
> EvidenciesPaginacio list(inici, fi, page, pagesize, language)

Retorna un llistat de les evidencies 

### Example
```java
// Import classes:
//import es.caib.evidenciesib.apiexterna.client.services.ApiClient;
//import es.caib.evidenciesib.apiexterna.client.services.ApiException;
//import es.caib.evidenciesib.apiexterna.client.services.Configuration;
//import es.caib.evidenciesib.apiexterna.client.services.auth.*;
//import es.caib.evidenciesib.apiexterna.client.api.EvidenciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

EvidenciesApi apiInstance = new EvidenciesApi();
String inici = "inici_example"; // String | Data d'inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades
String fi = "fi_example"; // String | Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades
Integer page = 56; // Integer | Pàgina de la que es volen obtenir les dades
Integer pagesize = 56; // Integer | Quantitat d'elements a retornar
String language = "language_example"; // String | Idioma en que s'han de retornar les dades(Només suportat 'ca' o 'es')
try {
    EvidenciesPaginacio result = apiInstance.list(inici, fi, page, pagesize, language);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EvidenciesApi#list");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inici** | **String**| Data d&#x27;inici, en format yyyy-MM-dd (ISO 8601), a partir de la qual volem obtenir dades | [optional]
 **fi** | **String**| Data fi, en format yyyy-MM-dd (ISO 8601), fins la qual volem tenir dades | [optional]
 **page** | **Integer**| Pàgina de la que es volen obtenir les dades | [optional]
 **pagesize** | **Integer**| Quantitat d&#x27;elements a retornar | [optional]
 **language** | **String**| Idioma en que s&#x27;han de retornar les dades(Només suportat &#x27;ca&#x27; o &#x27;es&#x27;) | [optional]

### Return type

[**EvidenciesPaginacio**](EvidenciesPaginacio.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="start"></a>
# **start**
> EvidenciaStartResponse start(body)

Primera cridada a realitzar per iniciar un procés d&#x27;evidències

### Example
```java
// Import classes:
//import es.caib.evidenciesib.apiexterna.client.services.ApiClient;
//import es.caib.evidenciesib.apiexterna.client.services.ApiException;
//import es.caib.evidenciesib.apiexterna.client.services.Configuration;
//import es.caib.evidenciesib.apiexterna.client.services.auth.*;
//import es.caib.evidenciesib.apiexterna.client.api.EvidenciesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();
// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

EvidenciesApi apiInstance = new EvidenciesApi();
EvidenciaStartRequest body = new EvidenciaStartRequest(); // EvidenciaStartRequest | Estructura de dades inicials per iniciar un procés d'evidències
try {
    EvidenciaStartResponse result = apiInstance.start(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EvidenciesApi#start");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EvidenciaStartRequest**](EvidenciaStartRequest.md)| Estructura de dades inicials per iniciar un procés d&#x27;evidències | [optional]

### Return type

[**EvidenciaStartResponse**](EvidenciaStartResponse.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

