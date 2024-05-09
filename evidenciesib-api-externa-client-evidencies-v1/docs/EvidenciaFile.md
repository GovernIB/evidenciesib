

# EvidenciaFile

Objecte per enviar i rebre fitxers així com la informació associada a aquest.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Nom del fitxer |  [optional] |
|**mime** | **String** | Tipus MIME del Fitxer |  [optional] |
|**size** | **Long** | Mida en bytes del document |  [optional] |
|**description** | **String** | Descripció del Fitxer |  [optional] |
|**encryptedFileID** | **String** | Identificar del fitxer per poder-ho recuperar en una segona fase. Només apareix en llistats per no incloure el contingut del fitxer. |  [optional] |
|**document** | **byte[]** | Contingut del fitxer. En llistats aquest camp vendrà buit. |  [optional] |



