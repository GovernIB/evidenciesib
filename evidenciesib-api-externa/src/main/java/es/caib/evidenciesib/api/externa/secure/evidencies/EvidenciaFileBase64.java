package es.caib.evidenciesib.api.externa.secure.evidencies;

import es.caib.evidenciesib.model.entity.Fitxer;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
@Schema(
        description = "Objecte per enviar i rebre fitxers així com la informació associada a aquest.\n"
                + "No utilitza byte[] que falla dins del JBoss7 sinó que utilitza un String per enviar el fitxer en Base64")
public class EvidenciaFileBase64 {

    public EvidenciaFileBase64() {
        super();
    }

    public EvidenciaFileBase64(EvidenciaFile evi) {
        super();
        this.name = evi.getName();
        this.mime = evi.getMime();
        this.size = evi.getSize();
        this.description = evi.getDescription();
        this.encryptedFileID = evi.getEncryptedFileID();
    }

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

    @Schema(description = "Contingut del fitxer en Base64. En llistats aquest camp vendrà buit.", required = false)
    protected String documentBase64;

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

    public String getDocumentBase64() {
        return documentBase64;
    }

    public void setDocumentBase64(String documentBase64) {
        this.documentBase64 = documentBase64;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public static EvidenciaFileBase64 toBean(Fitxer __bean) {
        if (__bean == null) {
            return null;
        }
        EvidenciaFileBase64 __tmp = new EvidenciaFileBase64();
        __tmp.setName(__bean.getNom());
        __tmp.setMime(__bean.getMime());
        __tmp.setSize(__bean.getTamany());
        __tmp.setDescription(__bean.getDescripcio());
        // EncryptedFileID
        __tmp.setEncryptedFileID(__bean.getEncryptedFileID());
        return __tmp;
    }

}
