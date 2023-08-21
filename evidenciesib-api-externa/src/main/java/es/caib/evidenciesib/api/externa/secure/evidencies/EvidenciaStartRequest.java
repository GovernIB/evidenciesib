package es.caib.evidenciesib.api.externa.secure.evidencies;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
public class EvidenciaStartRequest {

    @Schema(required = true, description = "Titol descriptiu de l'evidencia que es durà a terme")
    protected java.lang.String titolEvidencia;

    @Schema(required = true)
    protected java.lang.String personaNom;

    @Schema(required = true)
    protected java.lang.String personaLlinatge1;

    @Schema(required = true)
    protected java.lang.String personaLlinatge2;

    @Schema(required = true)
    protected java.lang.String personaNif;

    @Schema(required = false)
    protected java.lang.String personaEmail;

    @Schema(required = true)
    protected java.lang.String raoDeLaFirma;

    @Schema(
            required = true,
            example = "ca",
            defaultValue = "ca",
            description = "Idioma del document en ISO 639-1. Valors permesos 'ca' i 'es'")
    protected java.lang.String languageDocument;

    @Schema(required = true)
    protected String documentASignarMime;

    @Schema(required = true)
    protected String documentASignarNom;

    @Schema(required = true, type = "string", format = "byte")
    protected byte[] documentASignar;

    @Schema(
            required = true,
            example = "http://host:port/myappback/mycallbackcontroller/callbackevidencies?evidenciaid={0}",
            description = "URL de retorn quan el proces d'evidències hagi acabat. A la URL la cadena {0}"
                    + " es substituirà per l'identificador de l'evidència (evidenciaID)")
    protected String callBackUrl;

    @Schema(
            required = true,
            example = "ca",
            defaultValue = "ca",
            description = "Idioma del missatges d'error en format ISO 639-1. Valors permesos 'ca' i 'es'")
    protected String languageUI;

    public java.lang.String getTitolEvidencia() {
        return titolEvidencia;
    }

    public void setTitolEvidencia(java.lang.String titolEvidencia) {
        this.titolEvidencia = titolEvidencia;
    }

    public java.lang.String getPersonaNom() {
        return personaNom;
    }

    public void setPersonaNom(java.lang.String personaNom) {
        this.personaNom = personaNom;
    }

    public java.lang.String getPersonaLlinatge1() {
        return personaLlinatge1;
    }

    public void setPersonaLlinatge1(java.lang.String personaLlinatge1) {
        this.personaLlinatge1 = personaLlinatge1;
    }

    public java.lang.String getPersonaLlinatge2() {
        return personaLlinatge2;
    }

    public void setPersonaLlinatge2(java.lang.String personaLlinatge2) {
        this.personaLlinatge2 = personaLlinatge2;
    }

    public java.lang.String getPersonaNif() {
        return personaNif;
    }

    public void setPersonaNif(java.lang.String personaNif) {
        this.personaNif = personaNif;
    }

    public java.lang.String getRaoDeLaFirma() {
        return raoDeLaFirma;
    }

    public void setRaoDeLaFirma(java.lang.String raoDeLaFirma) {
        this.raoDeLaFirma = raoDeLaFirma;
    }

    public java.lang.String getLanguageDocument() {
        return languageDocument;
    }

    public void setLanguageDocument(java.lang.String languageDocument) {
        this.languageDocument = languageDocument;
    }

    public byte[] getDocumentASignar() {
        return documentASignar;
    }

    public void setDocumentASignar(byte[] documentASignar) {
        this.documentASignar = documentASignar;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getLanguageUI() {
        return languageUI;
    }

    public void setLanguageUI(String languageUI) {
        this.languageUI = languageUI;
    }

    public String getDocumentASignarNom() {
        return documentASignarNom;
    }

    public void setDocumentASignarNom(String documentASignarNom) {
        this.documentASignarNom = documentASignarNom;
    }

    public java.lang.String getPersonaEmail() {
        return personaEmail;
    }

    public void setPersonaEmail(java.lang.String personaEmail) {
        this.personaEmail = personaEmail;
    }

    public String getDocumentASignarMime() {
        return documentASignarMime;
    }

    public void setDocumentASignarMime(String documentASignarMime) {
        this.documentASignarMime = documentASignarMime;
    }

}
