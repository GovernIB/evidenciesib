# EvidenciaStartRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**titolEvidencia** | **String** | Titol descriptiu de l&#x27;evidència que es durà a terme | 
**personaNom** | **String** | Nom de la persona | 
**personaLlinatge1** | **String** | Primer llinatge de la persona | 
**personaLlinatge2** | **String** | Segon llintge de la persona | 
**personaNif** | **String** | Nif de la persona | 
**personaEmail** | **String** | Correu electrònic de la persona |  [optional]
**personaMobil** | **String** | Mòbil de la persona |  [optional]
**raoDeLaFirma** | **String** | Raó per la qual es requereix aquesta signatura | 
**languageDocument** | **String** | Idioma del document en ISO 639-1. Valors permesos &#x27;ca&#x27; i &#x27;es&#x27; | 
**documentASignar** | [**EvidenciaFile**](EvidenciaFile.md) |  | 
**callBackUrl** | **String** | URL de retorn quan el proces d&#x27;evidències hagi acabat. A la URL la cadena {0} es substituirà per l&#x27;identificador de l&#x27;evidència (evidenciaID) | 
**languageUI** | **String** | Idioma del missatges d&#x27;error en format ISO 639-1. Valors permesos &#x27;ca&#x27; i &#x27;es&#x27; | 
