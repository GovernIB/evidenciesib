package es.caib.evidenciesib.api.externa.secure.evidencies.v1;

import es.caib.evidenciesib.commons.utils.Constants;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enum que representa els diferents estats d'una evidència.
 * 
 * @author anadal
 *
 */
@Schema(
        name = "EvidenciaStatus",
        description = "Possibles estats d'una evidència",
        format = "int",
        enumAsRef = true,
        extensions = {
                @Extension(properties = {
                    @ExtensionProperty(
                        name = "enum-varnames",
                        parseValue = true,
                        value = "[\"EVIDENCIA_ESTAT_CODI_ERROR\","
                              + "\"EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO\","
                              + "\"EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN\","
                              + "\"EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA\","
                              + "\"EVIDENCIA_ESTAT_CODI_SIGNAT\"]"),
                    @ExtensionProperty(
                            name = "enum-descriptions",
                            parseValue = true,
                            value = "[\"Codi d'estat d'una evidència que indica un error\","
                                  + "\"Codi d'estat d'una evidència que indica que esta en procés de creació\","
                                  + "\"Codi d'estat d'una evidència que indica que esta realitzant el login\","
                                  + "\"Codi d'estat d'una evidència que indica que esta realitzant la firma del document\","
                                  + "\"Codi d'estat d'una evidència que indica que ha finalitzat correctament\"]")
                })
            })
public enum EvidenciaStatus {

    EVIDENCIA_ESTAT_CODI_ERROR(Constants.EVIDENCIA_ESTAT_CODI_ERROR), //  -1;
    EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO), // = 1;
    EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN), // =2
    EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA(Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA), // =3
    EVIDENCIA_ESTAT_CODI_SIGNAT(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT); // =10

    public final int value;
    


    EvidenciaStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static EvidenciaStatus fromValue(int value) {
        for (EvidenciaStatus b : EvidenciaStatus.values()) {
            if (b.value == value) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "' for EvidenciaStatus.");
    }
}
