package es.caib.evidenciesib.api.externa.secure.evidencies;

import es.caib.evidenciesib.commons.utils.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

/**
 * 
 * @author anadal
 *
 */

@Schema(name = "ConstantsWs")
public class ConstantsWs {

    @Schema(
            description = "Codi d'estat d'una evidència que indica un error",
            nullable = false,
            defaultValue = "" + Constants.EVIDENCIA_ESTAT_CODI_ERROR,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int EVIDENCIA_ESTAT_CODI_ERROR;

    @Schema(
            description = "Codi d'estat d'una evidència que indica que esta en procés de creació",
            nullable = false,
            defaultValue = "" + Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO;

    @Schema(
            description = "Codi d'estat d'una evidència que indica que esta realitzant el login",
            nullable = false,
            defaultValue = "" + Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN;

    @Schema(
            description = "Codi d'estat d'una evidència que indica que esta realitzant la firma del document",
            nullable = false,
            defaultValue = "" + Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA;

    @Schema(
            description = "Codi d'estat d'una evidència que indica que ha finalitzat correctament",
            nullable = false,
            defaultValue = "" + Constants.EVIDENCIA_ESTAT_CODI_SIGNAT,
            implementation = Integer.class,
            required = true,
            accessMode = AccessMode.READ_ONLY)
    public int EVIDENCIA_ESTAT_CODI_SIGNAT;



}