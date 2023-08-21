package es.caib.evidenciesib.api.externa.secure.evidencies;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * XYZ ZZZ Falta Documentar
 * @author anadal
 *
 */
public class EvidenciaStartResponse {

    @Schema(required = true)
    protected long evidenciaID;
    
    @Schema(required = true,
            format="uri")
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
