package es.caib.evidenciesib.model.entity;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public interface Fitxer extends org.fundaciobit.genapp.common.filesystem.IFile {

    public long getFitxerID();

    public void setFitxerID(long _fitxerID_);

    public java.lang.String getNom();

    public void setNom(java.lang.String _nom_);

    public java.lang.String getMime();

    public void setMime(java.lang.String _mime_);

    public long getTamany();

    public void setTamany(long _tamany_);

    public java.lang.String getDescripcio();

    public void setDescripcio(java.lang.String _descripcio_);

    // DataHandler (ho ocultam per Swagger)
    @Schema(hidden = true)
    @XmlElement(nillable = true)
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    javax.activation.DataHandler getData();

    // Encrypted FileID
    public String getEncryptedFileID();

    public void setEncryptedFileID(String encryptedFileID);

    // ======================================

}
