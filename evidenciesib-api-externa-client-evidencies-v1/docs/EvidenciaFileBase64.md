

# EvidenciaFileBase64

Objecte per enviar i rebre fitxers així com la informació associada a aquest. No utilitza byte[] que falla dins del JBoss7 sinó que utilitza un String per enviar el fitxer en Base64

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Nom del fitxer |  [optional] |
|**mime** | **String** | Tipus MIME del Fitxer |  [optional] |
|**size** | **Long** | Mida en bytes del document |  [optional] |
|**description** | **String** | Descripció del Fitxer |  [optional] |
|**encryptedFileID** | **String** | Identificar del fitxer per poder-ho recuperar en una segona fase. Només apareix en llistats per no incloure el contingut del fitxer. |  [optional] |
|**documentBase64** | **String** | Contingut del fitxer en Base64. En llistats aquest camp vendrà buit. |  [optional] |



