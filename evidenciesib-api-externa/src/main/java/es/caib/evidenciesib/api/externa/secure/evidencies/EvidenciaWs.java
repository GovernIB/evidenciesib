package es.caib.evidenciesib.api.externa.secure.evidencies;



import java.util.Date;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.model.entity.Evidencia;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author anadal
 *
 */
@Schema(description = "Estructura que inclou tota la informació de l'evidència.")
public class EvidenciaWs {

    @Schema(description = "Identificador únic de l'evidència.")
    long evidenciaID;// PK

    @Schema(description = "Nom descriptiu de l'evidència.")
    java.lang.String nom;

    @Schema(required = true, description = "Nom de la persona")
    protected java.lang.String personaNom;

    @Schema(required = true, description = "Primer llinatge de la persona")
    protected java.lang.String personaLlinatge1;

    @Schema(required = true, description = "Segon llintge de la persona")
    protected java.lang.String personaLlinatge2;

    @Schema(required = true, description = "Nif de la persona")
    protected java.lang.String personaNif;

    @Schema(required = false, description = "Email de la persona")
    java.lang.String personaEmail;

    @Schema(required = false, description = "Mòbil de la persona")
    java.lang.String personaMobil;

    @Schema(required = true, description = "Data de creació de l'evidència",  type="string",format="date-time", pattern = "yyyy-MM-dd'T'HH:mm:ss")
    java.sql.Timestamp dataInici;

    @Schema(required = false, description = "Data final de l'evidència",  type="string", format="date-time", pattern = "yyyy-MM-dd'T'HH:mm:ss")
    java.sql.Timestamp dataFi;

    @Schema(
            description = "Estat en que ha finalitzat l'evidència. Posibles estats:\r\n"
                    + "    public static final int EVIDENCIA_ESTAT_CODI_ERROR = -1;\r\n"
                    + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO = 1;\r\n"
                    + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN = 2;\r\n"
                    + "    public static final int EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA = 3;\r\n"
                    + "    public static final int EVIDENCIA_ESTAT_CODI_SIGNAT = 10;")
    int estatCodi;

    @Schema(description = "Descripció del camp estatCodi")
    String estatCodiDescripcio;

    @Schema(required = false, description = "Missatge de l'error")
    java.lang.String estatError;
    @Schema(required = false, description = "Stacktrace de l'excepció si n'hi hagues")
    java.lang.String estatExcepcio;

    @Schema(required = true, description = "Codi del Tipus de Login")
    int loginType;

    @Schema(required = true, description = "Descripció del tipus de login")
    String loginTypeDescription;

    @Schema(required = true, description = "Subtipus de login")
    java.lang.String loginSubtype;

    @Schema(required = true, description = "Nivell des eguretat de login")
    java.lang.String loginQaa;

    @Schema(required = true, description = "Data de realització del login", type="string", format="date-time", pattern = "yyyy-MM-dd'T'HH:mm:ss")
    java.sql.Timestamp loginData;

    @Schema(required = true, description = "Identificador del login realitzat.")
    java.lang.String loginId;
    java.lang.String loginAuthMethod;
    java.lang.String loginAdditionalProperties;

    @Schema(required = false, description = "IP des d'on està connectat el ciutadà")
    java.lang.String localitzacioIp;
    @Schema(required = false, description = "Codi postal des d'on està connectat el ciutadà.")
    java.lang.String localitzacioCodiPostal;
    @Schema(required = false, description = "Latitud des d'on està connectat el ciutadà.")
    java.lang.String localitzacioLatitud;
    @Schema(required = false, description = "Longitud des d'on està connectat el ciutadà.")
    java.lang.String localitzacioLongitud;
    @Schema(required = false, description = "Localitat des d'on està connectat el ciutadà.")
    java.lang.String localitzacioCiutat;
    @Schema(
            required = false,
            description = "Regió (Si és Espanya Comunitat Autonoma) des d'on està connectat el ciutadà.")
    java.lang.String localitzacioRegio;
    @Schema(required = false, description = "Pais des d'on està connectat el ciutadà.")
    java.lang.String localitzacioPais;

    @Schema(required = true, description = "Raó de firma.")
    java.lang.String firmaReason;

    @Schema(required = true, description = "Idioma en que està escrit el document.")
    java.lang.String firmaIdiomaDocument;

    @Schema(
            required = true,
            description = "Tipus documental de la Firma. Veure https://administracionelectronica.gob.es/pae_Home/dam/jcr:26d90313-7af0-4f69-9d62-c853d55d7627/Esquema_Metadatos_e-EMGDE_2016.pdf",
            example = "Exemples: 1 -> Resolución(TD01), 2 -> Acuerdo(TD02), 3 -> Contrato(TD03), 4 -> Convenio(TD04)\n ...")
    int firmaTipusDocumental;

    @Schema(
            required = true,
            description = "DescripcioTipus documental de la Firma.Per exemple per 1 retorna 'Resolución(TD01)'",
            example = "1")
    String firmaTipusDocumentalDescripcio;

    @Schema(required = true, description = "Fitxer original. No inclou contingut")
    protected EvidenciaFile fitxerOriginal;

    @Schema(required = false, description = "Fitxer adaptat. No inclou contingut")
    protected EvidenciaFile fitxerAdaptat;

    @Schema(required = false, description = "Fitxer signat. No inclou contingut")
    protected EvidenciaFile fitxerSignat;

    /** Constructor Buit */
    public EvidenciaWs() {
    }

    public EvidenciaWs(Evidencia __bean, String language) {
        this.setEvidenciaID(__bean.getEvidenciaID());
        this.setNom(__bean.getNom());
        this.setPersonaNom(__bean.getPersonaNom());
        this.setPersonaLlinatge1(__bean.getPersonaLlinatge1());
        this.setPersonaLlinatge2(__bean.getPersonaLlinatge2());
        this.setPersonaNif(__bean.getPersonaNif());
        this.setPersonaEmail(__bean.getPersonaEmail());
        this.setPersonaMobil(__bean.getPersonaMobil());
        this.setDataInici(__bean.getDataInici());
        this.setDataFi(__bean.getDataFi());
        this.setEstatCodi(__bean.getEstatCodi());
        {
            // XYZ ZZZ Falta traduir estats a IDIOMA
            String desc;
            switch (this.getEstatCodi()) {

                case Constants.EVIDENCIA_ESTAT_CODI_ERROR:
                    desc = "Error";
                break;

                case Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_CREACIO:
                    desc = "En procés de creació";
                break;

                case Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_LOGIN:
                    desc = "Realitzant login";
                break;

                case Constants.EVIDENCIA_ESTAT_CODI_EN_PROCES_DE_FIRMA:
                    desc = "Realitzant signatura";
                break;

                case Constants.EVIDENCIA_ESTAT_CODI_SIGNAT:
                    desc = "Finalitzat correctament";
                break;

                default:
                    desc = "Codi desconegut (" + this.getEstatCodi() + ")";
                break;
            }
            this.setEstatCodiDescripcio(desc);
        }

        this.setEstatError(__bean.getEstatError());
        this.setEstatExcepcio(__bean.getEstatExcepcio());
        this.setLoginType(__bean.getLoginType());
        this.setLoginSubtype(__bean.getLoginSubtype());
        this.setLoginQaa(__bean.getLoginQaa());
        this.setLoginData(__bean.getLoginData());
        this.setLoginId(__bean.getLoginId());
        this.setLoginAuthMethod(__bean.getLoginAuthMethod());
        this.setLoginAdditionalProperties(__bean.getLoginAdditionalProperties());
        this.setLocalitzacioIp(__bean.getLocalitzacioIp());
        this.setLocalitzacioCodiPostal(__bean.getLocalitzacioCodiPostal());
        this.setLocalitzacioLatitud(__bean.getLocalitzacioLatitud());
        this.setLocalitzacioLongitud(__bean.getLocalitzacioLongitud());
        this.setLocalitzacioCiutat(__bean.getLocalitzacioCiutat());
        this.setLocalitzacioRegio(__bean.getLocalitzacioRegio());
        this.setLocalitzacioPais(__bean.getLocalitzacioPais());
        this.setFirmaReason(__bean.getFirmaReason());
        this.setFirmaIdiomaDocument(__bean.getFirmaIdiomaDocument());
        this.setFirmaTipusDocumental(__bean.getFirmaTipusDocumental());

        {
            String descrLoginType;
            switch (__bean.getLoginType()) {

                case Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN:
                    descrLoginType = "Plugin de Login";
                break;

                case Constants.EVIDENCIA_TIPUS_LOGIN_AUTENTICACIO_BACK:
                    descrLoginType = "Login de Back";
                break;

                default:
                    descrLoginType = "Tipud de Login desconegut";
            }
            this.setLoginTypeDescription(descrLoginType);
        }


        this.setFirmaTipusDocumentalDescripcio(EvidenciesRestService.MAP_TIPUS_DOCUMENTAL.get(__bean.getFirmaTipusDocumental() + "_" + language));


        // Fitxer
        this.setFitxerOriginal(EvidenciaFile.toBean(__bean.getFitxerOriginal()));
        // Fitxer
        this.setFitxerAdaptat(EvidenciaFile.toBean(__bean.getFitxerAdaptat()));
        // Fitxer
        this.setFitxerSignat(EvidenciaFile.toBean(__bean.getFitxerSignat()));

        this.getFitxerOriginal().setEncryptedFileID(HibernateFileUtil.encryptFileID(__bean.getFitxerOriginalID()));

        if (__bean.getFitxerAdaptatID() != null) {
            this.getFitxerAdaptat().setEncryptedFileID(HibernateFileUtil.encryptFileID(__bean.getFitxerAdaptatID()));
        }

        if (__bean.getFitxerSignatID() != null) {
            this.getFitxerSignat().setEncryptedFileID(HibernateFileUtil.encryptFileID(__bean.getFitxerSignatID()));
        }

    }

    public long getEvidenciaID() {
        return evidenciaID;
    }

    public void setEvidenciaID(long evidenciaID) {
        this.evidenciaID = evidenciaID;
    }

    public java.lang.String getNom() {
        return nom;
    }

    public void setNom(java.lang.String nom) {
        this.nom = nom;
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

    public java.lang.String getPersonaEmail() {
        return personaEmail;
    }

    public void setPersonaEmail(java.lang.String personaEmail) {
        this.personaEmail = personaEmail;
    }

    public java.lang.String getPersonaMobil() {
        return personaMobil;
    }

    public void setPersonaMobil(java.lang.String personaMobil) {
        this.personaMobil = personaMobil;
    }

    public java.sql.Timestamp getDataInici() {
        return dataInici;
    }

    public void setDataInici(java.sql.Timestamp dataInici) {
        this.dataInici = dataInici;
    }

    public java.sql.Timestamp getDataFi() {
        return dataFi;
    }

    public void setDataFi(java.sql.Timestamp dataFi) {
        this.dataFi = dataFi;
    }

    public int getEstatCodi() {
        return estatCodi;
    }

    public void setEstatCodi(int estatCodi) {
        this.estatCodi = estatCodi;
    }

    public java.lang.String getEstatError() {
        return estatError;
    }

    public void setEstatError(java.lang.String estatError) {
        this.estatError = estatError;
    }

    public java.lang.String getEstatExcepcio() {
        return estatExcepcio;
    }

    public void setEstatExcepcio(java.lang.String estatExcepcio) {
        this.estatExcepcio = estatExcepcio;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public java.lang.String getLoginSubtype() {
        return loginSubtype;
    }

    public void setLoginSubtype(java.lang.String loginSubtype) {
        this.loginSubtype = loginSubtype;
    }

    public java.lang.String getLoginQaa() {
        return loginQaa;
    }

    public void setLoginQaa(java.lang.String loginQaa) {
        this.loginQaa = loginQaa;
    }

    public java.sql.Timestamp getLoginData() {
        return loginData;
    }

    public void setLoginData(java.sql.Timestamp loginData) {
        this.loginData = loginData;
    }

    public java.lang.String getLoginId() {
        return loginId;
    }

    public void setLoginId(java.lang.String loginId) {
        this.loginId = loginId;
    }

    public java.lang.String getLoginAuthMethod() {
        return loginAuthMethod;
    }

    public void setLoginAuthMethod(java.lang.String loginAuthMethod) {
        this.loginAuthMethod = loginAuthMethod;
    }

    public java.lang.String getLoginAdditionalProperties() {
        return loginAdditionalProperties;
    }

    public void setLoginAdditionalProperties(java.lang.String loginAdditionalProperties) {
        this.loginAdditionalProperties = loginAdditionalProperties;
    }

    public java.lang.String getLocalitzacioIp() {
        return localitzacioIp;
    }

    public void setLocalitzacioIp(java.lang.String localitzacioIp) {
        this.localitzacioIp = localitzacioIp;
    }

    public java.lang.String getLocalitzacioCodiPostal() {
        return localitzacioCodiPostal;
    }

    public void setLocalitzacioCodiPostal(java.lang.String localitzacioCodiPostal) {
        this.localitzacioCodiPostal = localitzacioCodiPostal;
    }

    public java.lang.String getLocalitzacioLatitud() {
        return localitzacioLatitud;
    }

    public void setLocalitzacioLatitud(java.lang.String localitzacioLatitud) {
        this.localitzacioLatitud = localitzacioLatitud;
    }

    public java.lang.String getLocalitzacioLongitud() {
        return localitzacioLongitud;
    }

    public void setLocalitzacioLongitud(java.lang.String localitzacioLongitud) {
        this.localitzacioLongitud = localitzacioLongitud;
    }

    public java.lang.String getLocalitzacioCiutat() {
        return localitzacioCiutat;
    }

    public void setLocalitzacioCiutat(java.lang.String localitzacioCiutat) {
        this.localitzacioCiutat = localitzacioCiutat;
    }

    public java.lang.String getLocalitzacioRegio() {
        return localitzacioRegio;
    }

    public void setLocalitzacioRegio(java.lang.String localitzacioRegio) {
        this.localitzacioRegio = localitzacioRegio;
    }

    public java.lang.String getLocalitzacioPais() {
        return localitzacioPais;
    }

    public void setLocalitzacioPais(java.lang.String localitzacioPais) {
        this.localitzacioPais = localitzacioPais;
    }

    public java.lang.String getFirmaReason() {
        return firmaReason;
    }

    public void setFirmaReason(java.lang.String firmaReason) {
        this.firmaReason = firmaReason;
    }

    public java.lang.String getFirmaIdiomaDocument() {
        return firmaIdiomaDocument;
    }

    public void setFirmaIdiomaDocument(java.lang.String firmaIdiomaDocument) {
        this.firmaIdiomaDocument = firmaIdiomaDocument;
    }

    public int getFirmaTipusDocumental() {
        return firmaTipusDocumental;
    }

    public void setFirmaTipusDocumental(int firmaTipusDocumental) {
        this.firmaTipusDocumental = firmaTipusDocumental;
    }

    public EvidenciaFile getFitxerOriginal() {
        return fitxerOriginal;
    }

    public void setFitxerOriginal(EvidenciaFile fitxerOriginal) {
        this.fitxerOriginal = fitxerOriginal;
    }

    public EvidenciaFile getFitxerAdaptat() {
        return fitxerAdaptat;
    }

    public void setFitxerAdaptat(EvidenciaFile fitxerAdaptat) {
        this.fitxerAdaptat = fitxerAdaptat;
    }

    public EvidenciaFile getFitxerSignat() {
        return fitxerSignat;
    }

    public void setFitxerSignat(EvidenciaFile fitxerSignat) {
        this.fitxerSignat = fitxerSignat;
    }

    public String getEstatCodiDescripcio() {
        return estatCodiDescripcio;
    }

    public void setEstatCodiDescripcio(String estatCodiDescripcio) {
        this.estatCodiDescripcio = estatCodiDescripcio;
    }

    public String getLoginTypeDescription() {
        return loginTypeDescription;
    }

    public void setLoginTypeDescription(String loginTypeDescription) {
        this.loginTypeDescription = loginTypeDescription;
    }

    public String getFirmaTipusDocumentalDescripcio() {
        return firmaTipusDocumentalDescripcio;
    }

    public void setFirmaTipusDocumentalDescripcio(String firmaTipusDocumentalDescripcio) {
        this.firmaTipusDocumentalDescripcio = firmaTipusDocumentalDescripcio;
    }

}
