package es.caib.evidenciesib.commons.utils;

import java.util.List;
import java.util.Map;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

    public static final String EVIDENCIESIB_PROPERTY_BASE = "es.caib.evidenciesib.";

    public static final String MAIL_SERVICE = "java:/es.caib.evidenciesib.mail";

    // TRUE ROLES
    public static final String EVI_ADMIN = "EVI_ADMIN";
    public static final String EVI_USER = "EVI_USER";
    public static final String EVI_WS = "EVI_WS";

    // VIRTUAL SECURITY ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    // EJB HIGH LEVEL ROLES
    public static final String ROLE_EJB_FULL_ACCESS = EVI_ADMIN;
    public static final String ROLE_EJB_BASIC_ACCESS = EVI_USER;
    public static final String ROLE_EJB_WS_ACCESS = EVI_WS;

    // ESTAT D'UNA EVIDENCIA
    public static final int EVIDENCIA_ESTAT_CODI_ERROR = -1;
    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO = 1;
    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN = 2;
    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA = 3;
    public static final int EVIDENCIA_ESTAT_CODI_SIGNAT = 10;

    // CONSTANTS ENTRE BACK I FRONT
    public static final String MAPPING_FRONT_LOGIN_START = "/frontloginstart";
    public static final String MAPPING_BACK_LOGIN_END = "/public/backloginend";

    public static final String MAPPING_BACK_PUBLIC_EVIDENCE = "/public/evidencia";
    public static final String MAPPING_BACK_PUBLIC_EVIDENCE_SIGN_OPERATION = "/sign/";
    public static final String MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION = "/info/";

    public static final String MAPPING_FULL_PUBLIC_EVIDENCE_INFO = MAPPING_BACK_PUBLIC_EVIDENCE
            + MAPPING_BACK_PUBLIC_EVIDENCE_INFO_OPERATION;

    public static final String MAPPING_PUBLIC_ARXIU = "/public/arxiu/";

    // TIPUS DE PLUGINS
    public static final int PLUGINSIB_TIPUS_LOGIN_FRONT = 1;
    public static final int PLUGINSIB_TIPUS_FIRMA_EN_SERVIDOR = 2;
    
    
    
    // ESTADISTIQUES
    
    public static final int CATEGORIA_PETICIONS_EVIDENCIES = 1;

    public static final int ESTADISTICA_GRUP_PETICIONS_EVIDENCIESIB = 1;

    public static final Map<Integer, String> GRUP_LABELS = Map.of(

            // ----------------
            ESTADISTICA_GRUP_PETICIONS_EVIDENCIESIB, "Peticions a EvidènciesIB"


    );

    public static final Map<Integer, List<Integer>> GRUPS_PER_CATEGORIES = Map.of(

            // --------- CATEGORIA_FIRMA_EN_SERVIDOR_UPGRADE
            CATEGORIA_PETICIONS_EVIDENCIES, List.of(ESTADISTICA_GRUP_PETICIONS_EVIDENCIESIB)

    );

    public static final Map<Integer, List<Integer>> ESTADISTIQUES_BY_GRUP = Map.of(

            // --------- ESTADISTICA_GRUP_PETICIONS_EVIDENCIESIB
            ESTADISTICA_GRUP_PETICIONS_EVIDENCIESIB, List.of(Constants.EVIDENCIA_ESTAT_CODI_ERROR, // Error
                    Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO, // Create
                    Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN, // Create
                    Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA, // Create
                    Constants.EVIDENCIA_ESTAT_CODI_SIGNAT) // OK 

    );
    
    

}
