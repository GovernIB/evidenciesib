package es.caib.evidenciesib.commons.utils;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

  public static final String EVIDENCIESIB_PROPERTY_BASE="es.caib.evidenciesib.";

    public static final String MAIL_SERVICE = "java:/es.caib.evidenciesib.mail";

    // TRUE ROLES
    public static final String EVI_ADMIN="EVI_ADMIN";
    public static final String EVI_USER="EVI_USER";
    public static final String EVI_WS="EVI_WS";

    // VIRTUAL SECURITY ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    // EJB HIGH LEVEL ROLES
    public static final String ROLE_EJB_FULL_ACCESS  = EVI_ADMIN;
    public static final String ROLE_EJB_BASIC_ACCESS = EVI_USER;
    public static final String ROLE_EJB_WS_ACCESS = EVI_WS;
}
