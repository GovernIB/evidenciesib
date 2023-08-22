package es.caib.evidenciesib.api.externa.secure.evidencies;

import es.caib.evidenciesib.model.entity.Fitxer;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
@Schema(description = "Objecte per enviar i rebre fitxers així com la informació associada a aquest.")
public class EvidenciaFile {

    @Schema(description = "Nom del fitxer")
    private String name = null;

    @Schema(description = "Tipus MIME del Fitxer")
    private String mime = null;

    @Schema(description = "Mida en bytes del document")
    private long size = -1;

    @Schema(description = "Descripció del Fitxer")
    private String description = null;

    @Schema(
            required = false,
            description = "Identificar del fitxer per poder-ho recuperar en una segona fase. Només apareix en llistats per no incloure el contingut del fitxer.")
    private String encryptedFileID;

    @Schema(
            description = "Contingut del fitxer. En llistats aquest camp vendrà buit.",
            required = false,
            type = "string",
            format = "byte")
    protected byte[] document;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEncryptedFileID() {
        return encryptedFileID;
    }

    public void setEncryptedFileID(String encryptedFileID) {
        this.encryptedFileID = encryptedFileID;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public static EvidenciaFile toBean(Fitxer __bean) {
        if (__bean == null) {
            return null;
        }
        EvidenciaFile __tmp = new EvidenciaFile();
        __tmp.setName(__bean.getNom());
        __tmp.setMime(__bean.getMime());
        __tmp.setSize(__bean.getTamany());
        __tmp.setDescription(__bean.getDescripcio());
        // EncryptedFileID
        __tmp.setEncryptedFileID(__bean.getEncryptedFileID());
        return __tmp;
    }

}
