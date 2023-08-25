

# EvidenciaStartRequest

Estructura de dades a enviar al servidor per iniciar un procés d'Evidències

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**titolEvidencia** | **String** | Titol descriptiu de l&#39;evidència que es durà a terme |  |
|**personaNom** | **String** | Nom de la persona |  |
|**personaLlinatge1** | **String** | Primer llinatge de la persona |  |
|**personaLlinatge2** | **String** | Segon llintge de la persona |  |
|**personaNif** | **String** | Nif de la persona |  |
|**personaEmail** | **String** | Correu electrònic de la persona |  [optional] |
|**personaMobil** | **String** | Mòbil de la persona |  [optional] |
|**raoDeLaFirma** | **String** | Raó per la qual es requereix aquesta signatura |  |
|**languageDocument** | **String** | Idioma del document en ISO 639-1. Valors permesos &#39;ca&#39; i &#39;es&#39; |  |
|**documentASignar** | [**EvidenciaFile**](EvidenciaFile.md) |  |  |
|**callBackUrl** | **String** | URL de retorn quan el proces d&#39;evidències hagi acabat. A la URL la cadena {0} es substituirà per l&#39;identificador de l&#39;evidència (evidenciaID) |  |
|**languageUI** | **String** | Idioma del missatges d&#39;error en format ISO 639-1. Valors permesos &#39;ca&#39; i &#39;es&#39; |  |



