package es.caib.evidenciesib.api.externa.secure.evidencies;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
public class EvidenciaFile {

    @JsonProperty("nom")
    private String nom = null;

    @JsonProperty("mime")
    private String mime = null;

    @JsonProperty("tamany")
    private Long tamany = null;

    @JsonProperty("descripcio")
    private String descripcio = null;

    @Schema(type = "string", format = "byte")
    protected byte[] document;

    /**
    * Get nom
    * @return nom
    **/
    @Schema(description = "")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
    * Get mime
    * @return mime
    **/
    @Schema(description = "")
    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    /**
    * Get tamany
    * @return tamany
    **/
    @Schema(description = "")
    public Long getTamany() {
        return tamany;
    }

    public void setTamany(Long tamany) {
        this.tamany = tamany;
    }

    /**
    * Get descripcio
    * @return descripcio
    **/
    @Schema(description = "")
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

}
