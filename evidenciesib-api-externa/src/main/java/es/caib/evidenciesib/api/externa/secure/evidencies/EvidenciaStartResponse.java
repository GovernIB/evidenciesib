package es.caib.evidenciesib.api.externa.secure.evidencies;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author anadal
 *
 */
public class EvidenciaStartResponse {

    @Schema(required = true, description = "Identificador del nou procés de recolecció d'evidències")
    protected long evidenciaID;

    @Schema(
            required = true,
            description = "Adreça a on redirigir el navegador del client per iniciar la recolecció d'evidències",
            format = "uri")
    protected String evidenciaUrlRedirect;

    public long getEvidenciaID() {
        return evidenciaID;
    }

    public void setEvidenciaID(long evidenciaID) {
        this.evidenciaID = evidenciaID;
    }

    public String getEvidenciaUrlRedirect() {
        return evidenciaUrlRedirect;
    }

    public void setEvidenciaUrlRedirect(String evidenciaUrlRedirect) {
        this.evidenciaUrlRedirect = evidenciaUrlRedirect;
    }

}
