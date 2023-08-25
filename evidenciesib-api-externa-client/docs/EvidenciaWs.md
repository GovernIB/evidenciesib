

# EvidenciaWs

Estructura que inclou tota la informació de l'evidència.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**evidenciaID** | **Long** | Identificador únic de l&#39;evidència. |  [optional] |
|**nom** | **String** | Nom descriptiu de l&#39;evidència. |  [optional] |
|**personaNom** | **String** | Nom de la persona |  |
|**personaLlinatge1** | **String** | Primer llinatge de la persona |  |
|**personaLlinatge2** | **String** | Segon llintge de la persona |  |
|**personaNif** | **String** | Nif de la persona |  |
|**personaEmail** | **String** | Email de la persona |  [optional] |
|**personaMobil** | **String** | Mòbil de la persona |  [optional] |
|**dataInici** | **OffsetDateTime** | Data de creació de l&#39;evidència |  |
|**dataFi** | **OffsetDateTime** | Data final de l&#39;evidència |  [optional] |
|**estatCodi** | **Integer** | Estat en que ha finalitzat l&#39;evidència. Posibles estats:      public static final int EVIDENCIA_ESTAT_CODI_ERROR &#x3D; -1;      public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO &#x3D; 1;      public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN &#x3D; 2;      public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA &#x3D; 3;      public static final int EVIDENCIA_ESTAT_CODI_SIGNAT &#x3D; 10; |  [optional] |
|**estatCodiDescripcio** | **String** | Descripció del camp estatCodi |  [optional] |
|**estatError** | **String** | Missatge de l&#39;error |  [optional] |
|**estatExcepcio** | **String** | Stacktrace de l&#39;excepció si n&#39;hi hagues |  [optional] |
|**loginType** | **Integer** | Codi del Tipus de Login |  |
|**loginTypeDescription** | **String** | Descripció del tipus de login |  |
|**loginSubtype** | **String** | Subtipus de login |  |
|**loginQaa** | **String** | Nivell des eguretat de login |  |
|**loginData** | **OffsetDateTime** | Data de realització del login |  |
|**loginId** | **String** | Identificador del login realitzat. |  |
|**loginAuthMethod** | **String** |  |  [optional] |
|**loginAdditionalProperties** | **String** |  |  [optional] |
|**localitzacioIp** | **String** | IP des d&#39;on està connectat el ciutadà |  [optional] |
|**localitzacioCodiPostal** | **String** | Codi postal des d&#39;on està connectat el ciutadà. |  [optional] |
|**localitzacioLatitud** | **String** | Latitud des d&#39;on està connectat el ciutadà. |  [optional] |
|**localitzacioLongitud** | **String** | Longitud des d&#39;on està connectat el ciutadà. |  [optional] |
|**localitzacioCiutat** | **String** | Localitat des d&#39;on està connectat el ciutadà. |  [optional] |
|**localitzacioRegio** | **String** | Regió (Si és Espanya Comunitat Autonoma) des d&#39;on està connectat el ciutadà. |  [optional] |
|**localitzacioPais** | **String** | Pais des d&#39;on està connectat el ciutadà. |  [optional] |
|**firmaReason** | **String** | Raó de firma. |  |
|**firmaIdiomaDocument** | **String** | Idioma en que està escrit el document. |  |
|**firmaTipusDocumental** | **Integer** | Tipus documental de la Firma. Veure https://administracionelectronica.gob.es/pae_Home/dam/jcr:26d90313-7af0-4f69-9d62-c853d55d7627/Esquema_Metadatos_e-EMGDE_2016.pdf |  |
|**firmaTipusDocumentalDescripcio** | **String** | DescripcioTipus documental de la Firma.Per exemple per 1 retorna &#39;Resolución(TD01)&#39; |  |
|**fitxerOriginal** | [**EvidenciaFile**](EvidenciaFile.md) |  |  |
|**fitxerAdaptat** | [**EvidenciaFile**](EvidenciaFile.md) |  |  [optional] |
|**fitxerSignat** | [**EvidenciaFile**](EvidenciaFile.md) |  |  [optional] |



