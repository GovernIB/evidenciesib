
package es.caib.evidenciesib.persistence;
import es.caib.evidenciesib.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.hibernate.annotations.Type;
import javax.persistence.Id;


@Entity(name = "EvidenciaJPA")
@Table(name = "evi_evidencia" , indexes = { 
        @Index(name="evi_evidencia_pk_i", columnList = "evidenciaid"),
        @Index(name="evi_evidencia_fitxerorig_fk_i", columnList = "fitxeroriginalid"),
        @Index(name="evi_evidencia_fitxeradap_fk_i", columnList = "fitxeradaptatid"),
        @Index(name="evi_evidencia_fitxersign_fk_i", columnList = "fitxersignatid")})
@SequenceGenerator(name="EVIDENCIA_SEQ", sequenceName="evi_evidencia_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EvidenciaJPA implements Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EVIDENCIA_SEQ")
    @Column(name="evidenciaid",nullable = false,length = 19)
    long evidenciaID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="personanif",nullable = false,length = 100)
    java.lang.String personaNif;

    @Column(name="personausername",length = 255)
    java.lang.String personaUsername;

    @Column(name="personanom",length = 255)
    java.lang.String personaNom;

    @Column(name="personallinatge1",length = 255)
    java.lang.String personaLlinatge1;

    @Column(name="personallinatge2",length = 255)
    java.lang.String personaLlinatge2;

    @Column(name="personaemail",length = 255)
    java.lang.String personaEmail;

    @Column(name="personamobil",length = 100)
    java.lang.String personaMobil;

    @Column(name="datainici",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp dataInici;

    @Column(name="datafi",length = 29,precision = 6)
    java.sql.Timestamp dataFi;

    @Column(name="usuariaplicacio",length = 255)
    java.lang.String usuariAplicacio;

    @Column(name="usuaripersona",length = 100)
    java.lang.String usuariPersona;

    @Column(name="estatcodi",nullable = false,length = 10)
    int estatCodi;

    @Column(name="estaterror",length = 4000)
    java.lang.String estatError;

    @Column(name="estatexcepcio",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String estatExcepcio;

    @Column(name="logintype",length = 255)
    java.lang.String loginType;

    @Column(name="loginsubtype",length = 255)
    java.lang.String loginSubtype;

    @Column(name="loginauthmethod",length = 255)
    java.lang.String loginAuthMethod;

    @Column(name="loginqaa",length = 255)
    java.lang.String loginQaa;

    @Column(name="loginid",length = 255)
    java.lang.String loginId;

    @Column(name="logindata",length = 29,precision = 6)
    java.sql.Timestamp loginData;

    @Column(name="loginadditionalproperties",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String loginAdditionalProperties;

    @Column(name="localitzacioip",length = 100)
    java.lang.String localitzacioIp;

    @Column(name="localitzaciocodipostal",length = 100)
    java.lang.String localitzacioCodiPostal;

    @Column(name="localitzaciolatitud",length = 100)
    java.lang.String localitzacioLatitud;

    @Column(name="localitzaciolongitud",length = 100)
    java.lang.String localitzacioLongitud;

    @Column(name="localitzacioregio",length = 100)
    java.lang.String localitzacioRegio;

    @Column(name="localitzaciociutat",length = 255)
    java.lang.String localitzacioCiutat;

    @Column(name="localitzaciopais",length = 100)
    java.lang.String localitzacioPais;

    @Column(name="deviceproperties",length = 4000)
    java.lang.String deviceProperties;

    @Column(name="clickproperties",length = 4000)
    java.lang.String clickProperties;

    @org.hibernate.annotations.ColumnDefault("'Rao de la firma'")
    @Column(name="firmareason",nullable = false,length = 255)
    java.lang.String firmaReason = "Rao de la firma";

    @Column(name="firmaidiomadocument",length = 100)
    java.lang.String firmaIdiomaDocument;

    @org.hibernate.annotations.ColumnDefault("99")
    @Column(name="firmatipusdocumental",nullable = false,length = 10)
    int firmaTipusDocumental = 99;

    @Column(name="fitxeroriginalid",nullable = false,length = 19)
    long fitxerOriginalID;

    @Column(name="fitxeradaptatid",length = 19)
    java.lang.Long fitxerAdaptatID;

    @Column(name="fitxersignatid",length = 19)
    java.lang.Long fitxerSignatID;

    @org.hibernate.annotations.ColumnDefault("'/user/evidencia/list'")
    @Column(name="callbackurl",nullable = false,length = 255)
    java.lang.String callBackUrl = "/user/evidencia/list";



  /** Constructor Buit */
  public EvidenciaJPA() {
  }

  /** Constructor amb tots els camps  */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personaNif , java.lang.String personaUsername , java.lang.String personaNom , java.lang.String personaLlinatge1 , java.lang.String personaLlinatge2 , java.lang.String personaEmail , java.lang.String personaMobil , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.String usuariAplicacio , java.lang.String usuariPersona , int estatCodi , java.lang.String estatError , java.lang.String estatExcepcio , java.lang.String loginType , java.lang.String loginSubtype , java.lang.String loginAuthMethod , java.lang.String loginQaa , java.lang.String loginId , java.sql.Timestamp loginData , java.lang.String loginAdditionalProperties , java.lang.String localitzacioIp , java.lang.String localitzacioCodiPostal , java.lang.String localitzacioLatitud , java.lang.String localitzacioLongitud , java.lang.String localitzacioRegio , java.lang.String localitzacioCiutat , java.lang.String localitzacioPais , java.lang.String deviceProperties , java.lang.String clickProperties , java.lang.String firmaReason , java.lang.String firmaIdiomaDocument , int firmaTipusDocumental , long fitxerOriginalID , java.lang.Long fitxerAdaptatID , java.lang.Long fitxerSignatID , java.lang.String callBackUrl) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personaNif=personaNif;
    this.personaUsername=personaUsername;
    this.personaNom=personaNom;
    this.personaLlinatge1=personaLlinatge1;
    this.personaLlinatge2=personaLlinatge2;
    this.personaEmail=personaEmail;
    this.personaMobil=personaMobil;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacio=usuariAplicacio;
    this.usuariPersona=usuariPersona;
    this.estatCodi=estatCodi;
    this.estatError=estatError;
    this.estatExcepcio=estatExcepcio;
    this.loginType=loginType;
    this.loginSubtype=loginSubtype;
    this.loginAuthMethod=loginAuthMethod;
    this.loginQaa=loginQaa;
    this.loginId=loginId;
    this.loginData=loginData;
    this.loginAdditionalProperties=loginAdditionalProperties;
    this.localitzacioIp=localitzacioIp;
    this.localitzacioCodiPostal=localitzacioCodiPostal;
    this.localitzacioLatitud=localitzacioLatitud;
    this.localitzacioLongitud=localitzacioLongitud;
    this.localitzacioRegio=localitzacioRegio;
    this.localitzacioCiutat=localitzacioCiutat;
    this.localitzacioPais=localitzacioPais;
    this.deviceProperties=deviceProperties;
    this.clickProperties=clickProperties;
    this.firmaReason=firmaReason;
    this.firmaIdiomaDocument=firmaIdiomaDocument;
    this.firmaTipusDocumental=firmaTipusDocumental;
    this.fitxerOriginalID=fitxerOriginalID;
    this.fitxerAdaptatID=fitxerAdaptatID;
    this.fitxerSignatID=fitxerSignatID;
    this.callBackUrl=callBackUrl;
}
  /** Constructor sense valors autoincrementals */
  public EvidenciaJPA(java.lang.String nom , java.lang.String personaNif , java.lang.String personaUsername , java.lang.String personaNom , java.lang.String personaLlinatge1 , java.lang.String personaLlinatge2 , java.lang.String personaEmail , java.lang.String personaMobil , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.String usuariAplicacio , java.lang.String usuariPersona , int estatCodi , java.lang.String estatError , java.lang.String estatExcepcio , java.lang.String loginType , java.lang.String loginSubtype , java.lang.String loginAuthMethod , java.lang.String loginQaa , java.lang.String loginId , java.sql.Timestamp loginData , java.lang.String loginAdditionalProperties , java.lang.String localitzacioIp , java.lang.String localitzacioCodiPostal , java.lang.String localitzacioLatitud , java.lang.String localitzacioLongitud , java.lang.String localitzacioRegio , java.lang.String localitzacioCiutat , java.lang.String localitzacioPais , java.lang.String deviceProperties , java.lang.String clickProperties , java.lang.String firmaReason , java.lang.String firmaIdiomaDocument , int firmaTipusDocumental , long fitxerOriginalID , java.lang.Long fitxerAdaptatID , java.lang.Long fitxerSignatID , java.lang.String callBackUrl) {
    this.nom=nom;
    this.personaNif=personaNif;
    this.personaUsername=personaUsername;
    this.personaNom=personaNom;
    this.personaLlinatge1=personaLlinatge1;
    this.personaLlinatge2=personaLlinatge2;
    this.personaEmail=personaEmail;
    this.personaMobil=personaMobil;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacio=usuariAplicacio;
    this.usuariPersona=usuariPersona;
    this.estatCodi=estatCodi;
    this.estatError=estatError;
    this.estatExcepcio=estatExcepcio;
    this.loginType=loginType;
    this.loginSubtype=loginSubtype;
    this.loginAuthMethod=loginAuthMethod;
    this.loginQaa=loginQaa;
    this.loginId=loginId;
    this.loginData=loginData;
    this.loginAdditionalProperties=loginAdditionalProperties;
    this.localitzacioIp=localitzacioIp;
    this.localitzacioCodiPostal=localitzacioCodiPostal;
    this.localitzacioLatitud=localitzacioLatitud;
    this.localitzacioLongitud=localitzacioLongitud;
    this.localitzacioRegio=localitzacioRegio;
    this.localitzacioCiutat=localitzacioCiutat;
    this.localitzacioPais=localitzacioPais;
    this.deviceProperties=deviceProperties;
    this.clickProperties=clickProperties;
    this.firmaReason=firmaReason;
    this.firmaIdiomaDocument=firmaIdiomaDocument;
    this.firmaTipusDocumental=firmaTipusDocumental;
    this.fitxerOriginalID=fitxerOriginalID;
    this.fitxerAdaptatID=fitxerAdaptatID;
    this.fitxerSignatID=fitxerSignatID;
    this.callBackUrl=callBackUrl;
}
  /** Constructor dels valors Not Null */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personaNif , java.sql.Timestamp dataInici , int estatCodi , java.lang.String firmaReason , int firmaTipusDocumental , long fitxerOriginalID , java.lang.String callBackUrl) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personaNif=personaNif;
    this.dataInici=dataInici;
    this.estatCodi=estatCodi;
    this.firmaReason=firmaReason;
    this.firmaTipusDocumental=firmaTipusDocumental;
    this.fitxerOriginalID=fitxerOriginalID;
    this.callBackUrl=callBackUrl;
}
  public EvidenciaJPA(Evidencia __bean) {
    this.setEvidenciaID(__bean.getEvidenciaID());
    this.setNom(__bean.getNom());
    this.setPersonaNif(__bean.getPersonaNif());
    this.setPersonaUsername(__bean.getPersonaUsername());
    this.setPersonaNom(__bean.getPersonaNom());
    this.setPersonaLlinatge1(__bean.getPersonaLlinatge1());
    this.setPersonaLlinatge2(__bean.getPersonaLlinatge2());
    this.setPersonaEmail(__bean.getPersonaEmail());
    this.setPersonaMobil(__bean.getPersonaMobil());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setUsuariAplicacio(__bean.getUsuariAplicacio());
    this.setUsuariPersona(__bean.getUsuariPersona());
    this.setEstatCodi(__bean.getEstatCodi());
    this.setEstatError(__bean.getEstatError());
    this.setEstatExcepcio(__bean.getEstatExcepcio());
    this.setLoginType(__bean.getLoginType());
    this.setLoginSubtype(__bean.getLoginSubtype());
    this.setLoginAuthMethod(__bean.getLoginAuthMethod());
    this.setLoginQaa(__bean.getLoginQaa());
    this.setLoginId(__bean.getLoginId());
    this.setLoginData(__bean.getLoginData());
    this.setLoginAdditionalProperties(__bean.getLoginAdditionalProperties());
    this.setLocalitzacioIp(__bean.getLocalitzacioIp());
    this.setLocalitzacioCodiPostal(__bean.getLocalitzacioCodiPostal());
    this.setLocalitzacioLatitud(__bean.getLocalitzacioLatitud());
    this.setLocalitzacioLongitud(__bean.getLocalitzacioLongitud());
    this.setLocalitzacioRegio(__bean.getLocalitzacioRegio());
    this.setLocalitzacioCiutat(__bean.getLocalitzacioCiutat());
    this.setLocalitzacioPais(__bean.getLocalitzacioPais());
    this.setDeviceProperties(__bean.getDeviceProperties());
    this.setClickProperties(__bean.getClickProperties());
    this.setFirmaReason(__bean.getFirmaReason());
    this.setFirmaIdiomaDocument(__bean.getFirmaIdiomaDocument());
    this.setFirmaTipusDocumental(__bean.getFirmaTipusDocumental());
    this.setFitxerOriginalID(__bean.getFitxerOriginalID());
    this.setFitxerAdaptatID(__bean.getFitxerAdaptatID());
    this.setFitxerSignatID(__bean.getFitxerSignatID());
    this.setCallBackUrl(__bean.getCallBackUrl());
    // Fitxer
    this.setFitxerOriginal(FitxerJPA.toJPA(__bean.getFitxerOriginal()));
    // Fitxer
    this.setFitxerAdaptat(FitxerJPA.toJPA(__bean.getFitxerAdaptat()));
    // Fitxer
    this.setFitxerSignat(FitxerJPA.toJPA(__bean.getFitxerSignat()));
	}

	public long getEvidenciaID() {
		return(evidenciaID);
	};
	public void setEvidenciaID(long _evidenciaID_) {
		this.evidenciaID = _evidenciaID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getPersonaNif() {
		return(personaNif);
	};
	public void setPersonaNif(java.lang.String _personaNif_) {
		this.personaNif = _personaNif_;
	};

	public java.lang.String getPersonaUsername() {
		return(personaUsername);
	};
	public void setPersonaUsername(java.lang.String _personaUsername_) {
		this.personaUsername = _personaUsername_;
	};

	public java.lang.String getPersonaNom() {
		return(personaNom);
	};
	public void setPersonaNom(java.lang.String _personaNom_) {
		this.personaNom = _personaNom_;
	};

	public java.lang.String getPersonaLlinatge1() {
		return(personaLlinatge1);
	};
	public void setPersonaLlinatge1(java.lang.String _personaLlinatge1_) {
		this.personaLlinatge1 = _personaLlinatge1_;
	};

	public java.lang.String getPersonaLlinatge2() {
		return(personaLlinatge2);
	};
	public void setPersonaLlinatge2(java.lang.String _personaLlinatge2_) {
		this.personaLlinatge2 = _personaLlinatge2_;
	};

	public java.lang.String getPersonaEmail() {
		return(personaEmail);
	};
	public void setPersonaEmail(java.lang.String _personaEmail_) {
		this.personaEmail = _personaEmail_;
	};

	public java.lang.String getPersonaMobil() {
		return(personaMobil);
	};
	public void setPersonaMobil(java.lang.String _personaMobil_) {
		this.personaMobil = _personaMobil_;
	};

	public java.sql.Timestamp getDataInici() {
		return(dataInici);
	};
	public void setDataInici(java.sql.Timestamp _dataInici_) {
		this.dataInici = _dataInici_;
	};

	public java.sql.Timestamp getDataFi() {
		return(dataFi);
	};
	public void setDataFi(java.sql.Timestamp _dataFi_) {
		this.dataFi = _dataFi_;
	};

	public java.lang.String getUsuariAplicacio() {
		return(usuariAplicacio);
	};
	public void setUsuariAplicacio(java.lang.String _usuariAplicacio_) {
		this.usuariAplicacio = _usuariAplicacio_;
	};

	public java.lang.String getUsuariPersona() {
		return(usuariPersona);
	};
	public void setUsuariPersona(java.lang.String _usuariPersona_) {
		this.usuariPersona = _usuariPersona_;
	};

	public int getEstatCodi() {
		return(estatCodi);
	};
	public void setEstatCodi(int _estatCodi_) {
		this.estatCodi = _estatCodi_;
	};

	public java.lang.String getEstatError() {
		return(estatError);
	};
	public void setEstatError(java.lang.String _estatError_) {
		this.estatError = _estatError_;
	};

	public java.lang.String getEstatExcepcio() {
		return(estatExcepcio);
	};
	public void setEstatExcepcio(java.lang.String _estatExcepcio_) {
		this.estatExcepcio = _estatExcepcio_;
	};

	public java.lang.String getLoginType() {
		return(loginType);
	};
	public void setLoginType(java.lang.String _loginType_) {
		this.loginType = _loginType_;
	};

	public java.lang.String getLoginSubtype() {
		return(loginSubtype);
	};
	public void setLoginSubtype(java.lang.String _loginSubtype_) {
		this.loginSubtype = _loginSubtype_;
	};

	public java.lang.String getLoginAuthMethod() {
		return(loginAuthMethod);
	};
	public void setLoginAuthMethod(java.lang.String _loginAuthMethod_) {
		this.loginAuthMethod = _loginAuthMethod_;
	};

	public java.lang.String getLoginQaa() {
		return(loginQaa);
	};
	public void setLoginQaa(java.lang.String _loginQaa_) {
		this.loginQaa = _loginQaa_;
	};

	public java.lang.String getLoginId() {
		return(loginId);
	};
	public void setLoginId(java.lang.String _loginId_) {
		this.loginId = _loginId_;
	};

	public java.sql.Timestamp getLoginData() {
		return(loginData);
	};
	public void setLoginData(java.sql.Timestamp _loginData_) {
		this.loginData = _loginData_;
	};

	public java.lang.String getLoginAdditionalProperties() {
		return(loginAdditionalProperties);
	};
	public void setLoginAdditionalProperties(java.lang.String _loginAdditionalProperties_) {
		this.loginAdditionalProperties = _loginAdditionalProperties_;
	};

	public java.lang.String getLocalitzacioIp() {
		return(localitzacioIp);
	};
	public void setLocalitzacioIp(java.lang.String _localitzacioIp_) {
		this.localitzacioIp = _localitzacioIp_;
	};

	public java.lang.String getLocalitzacioCodiPostal() {
		return(localitzacioCodiPostal);
	};
	public void setLocalitzacioCodiPostal(java.lang.String _localitzacioCodiPostal_) {
		this.localitzacioCodiPostal = _localitzacioCodiPostal_;
	};

	public java.lang.String getLocalitzacioLatitud() {
		return(localitzacioLatitud);
	};
	public void setLocalitzacioLatitud(java.lang.String _localitzacioLatitud_) {
		this.localitzacioLatitud = _localitzacioLatitud_;
	};

	public java.lang.String getLocalitzacioLongitud() {
		return(localitzacioLongitud);
	};
	public void setLocalitzacioLongitud(java.lang.String _localitzacioLongitud_) {
		this.localitzacioLongitud = _localitzacioLongitud_;
	};

	public java.lang.String getLocalitzacioRegio() {
		return(localitzacioRegio);
	};
	public void setLocalitzacioRegio(java.lang.String _localitzacioRegio_) {
		this.localitzacioRegio = _localitzacioRegio_;
	};

	public java.lang.String getLocalitzacioCiutat() {
		return(localitzacioCiutat);
	};
	public void setLocalitzacioCiutat(java.lang.String _localitzacioCiutat_) {
		this.localitzacioCiutat = _localitzacioCiutat_;
	};

	public java.lang.String getLocalitzacioPais() {
		return(localitzacioPais);
	};
	public void setLocalitzacioPais(java.lang.String _localitzacioPais_) {
		this.localitzacioPais = _localitzacioPais_;
	};

	public java.lang.String getDeviceProperties() {
		return(deviceProperties);
	};
	public void setDeviceProperties(java.lang.String _deviceProperties_) {
		this.deviceProperties = _deviceProperties_;
	};

	public java.lang.String getClickProperties() {
		return(clickProperties);
	};
	public void setClickProperties(java.lang.String _clickProperties_) {
		this.clickProperties = _clickProperties_;
	};

	public java.lang.String getFirmaReason() {
		return(firmaReason);
	};
	public void setFirmaReason(java.lang.String _firmaReason_) {
		this.firmaReason = _firmaReason_;
	};

	public java.lang.String getFirmaIdiomaDocument() {
		return(firmaIdiomaDocument);
	};
	public void setFirmaIdiomaDocument(java.lang.String _firmaIdiomaDocument_) {
		this.firmaIdiomaDocument = _firmaIdiomaDocument_;
	};

	public int getFirmaTipusDocumental() {
		return(firmaTipusDocumental);
	};
	public void setFirmaTipusDocumental(int _firmaTipusDocumental_) {
		this.firmaTipusDocumental = _firmaTipusDocumental_;
	};

	public long getFitxerOriginalID() {
		return(fitxerOriginalID);
	};
	public void setFitxerOriginalID(long _fitxerOriginalID_) {
		this.fitxerOriginalID = _fitxerOriginalID_;
	};

	public java.lang.Long getFitxerAdaptatID() {
		return(fitxerAdaptatID);
	};
	public void setFitxerAdaptatID(java.lang.Long _fitxerAdaptatID_) {
		this.fitxerAdaptatID = _fitxerAdaptatID_;
	};

	public java.lang.Long getFitxerSignatID() {
		return(fitxerSignatID);
	};
	public void setFitxerSignatID(java.lang.Long _fitxerSignatID_) {
		this.fitxerSignatID = _fitxerSignatID_;
	};

	public java.lang.String getCallBackUrl() {
		return(callBackUrl);
	};
	public void setCallBackUrl(java.lang.String _callBackUrl_) {
		this.callBackUrl = _callBackUrl_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Evidencia) {
      Evidencia __instance = (Evidencia)__obj;
      __result = true;
      __result = __result && (this.getEvidenciaID() == __instance.getEvidenciaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:fitxerid | Table: evi_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxeroriginalid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="evi_evidencia_fitxer_fitdoc_fk"))
    private FitxerJPA fitxerOriginal;

    public FitxerJPA getFitxerOriginal() {
    return this.fitxerOriginal;
  }

    public  void setFitxerOriginal(FitxerJPA fitxerOriginal) {
    this.fitxerOriginal = fitxerOriginal;
  }

// IMP Field:fitxerid | Table: evi_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxeradaptatid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="evi_evidencia_fitxer_fitada_fk"))
    private FitxerJPA fitxerAdaptat;

    public FitxerJPA getFitxerAdaptat() {
    return this.fitxerAdaptat;
  }

    public  void setFitxerAdaptat(FitxerJPA fitxerAdaptat) {
    this.fitxerAdaptat = fitxerAdaptat;
  }

// IMP Field:fitxerid | Table: evi_fitxer | Type: 1  

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fitxersignatid", referencedColumnName ="fitxerID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="evi_evidencia_fitxer_fitsig_fk"))
    private FitxerJPA fitxerSignat;

    public FitxerJPA getFitxerSignat() {
    return this.fitxerSignat;
  }

    public  void setFitxerSignat(FitxerJPA fitxerSignat) {
    this.fitxerSignat = fitxerSignat;
  }


 // ---------------  STATIC METHODS ------------------
  public static EvidenciaJPA toJPA(Evidencia __bean) {
    if (__bean == null) { return null;}
    EvidenciaJPA __tmp = new EvidenciaJPA();
    __tmp.setEvidenciaID(__bean.getEvidenciaID());
    __tmp.setNom(__bean.getNom());
    __tmp.setPersonaNif(__bean.getPersonaNif());
    __tmp.setPersonaUsername(__bean.getPersonaUsername());
    __tmp.setPersonaNom(__bean.getPersonaNom());
    __tmp.setPersonaLlinatge1(__bean.getPersonaLlinatge1());
    __tmp.setPersonaLlinatge2(__bean.getPersonaLlinatge2());
    __tmp.setPersonaEmail(__bean.getPersonaEmail());
    __tmp.setPersonaMobil(__bean.getPersonaMobil());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setUsuariAplicacio(__bean.getUsuariAplicacio());
    __tmp.setUsuariPersona(__bean.getUsuariPersona());
    __tmp.setEstatCodi(__bean.getEstatCodi());
    __tmp.setEstatError(__bean.getEstatError());
    __tmp.setEstatExcepcio(__bean.getEstatExcepcio());
    __tmp.setLoginType(__bean.getLoginType());
    __tmp.setLoginSubtype(__bean.getLoginSubtype());
    __tmp.setLoginAuthMethod(__bean.getLoginAuthMethod());
    __tmp.setLoginQaa(__bean.getLoginQaa());
    __tmp.setLoginId(__bean.getLoginId());
    __tmp.setLoginData(__bean.getLoginData());
    __tmp.setLoginAdditionalProperties(__bean.getLoginAdditionalProperties());
    __tmp.setLocalitzacioIp(__bean.getLocalitzacioIp());
    __tmp.setLocalitzacioCodiPostal(__bean.getLocalitzacioCodiPostal());
    __tmp.setLocalitzacioLatitud(__bean.getLocalitzacioLatitud());
    __tmp.setLocalitzacioLongitud(__bean.getLocalitzacioLongitud());
    __tmp.setLocalitzacioRegio(__bean.getLocalitzacioRegio());
    __tmp.setLocalitzacioCiutat(__bean.getLocalitzacioCiutat());
    __tmp.setLocalitzacioPais(__bean.getLocalitzacioPais());
    __tmp.setDeviceProperties(__bean.getDeviceProperties());
    __tmp.setClickProperties(__bean.getClickProperties());
    __tmp.setFirmaReason(__bean.getFirmaReason());
    __tmp.setFirmaIdiomaDocument(__bean.getFirmaIdiomaDocument());
    __tmp.setFirmaTipusDocumental(__bean.getFirmaTipusDocumental());
    __tmp.setFitxerOriginalID(__bean.getFitxerOriginalID());
    __tmp.setFitxerAdaptatID(__bean.getFitxerAdaptatID());
    __tmp.setFitxerSignatID(__bean.getFitxerSignatID());
    __tmp.setCallBackUrl(__bean.getCallBackUrl());
    // Fitxer
    __tmp.setFitxerOriginal(FitxerJPA.toJPA(__bean.getFitxerOriginal()));
    // Fitxer
    __tmp.setFitxerAdaptat(FitxerJPA.toJPA(__bean.getFitxerAdaptat()));
    // Fitxer
    __tmp.setFitxerSignat(FitxerJPA.toJPA(__bean.getFitxerSignat()));
		return __tmp;
	}


  public static EvidenciaJPA copyJPA(EvidenciaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EvidenciaJPA> copyJPA(java.util.Set<EvidenciaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EvidenciaJPA> __tmpSet = (java.util.Set<EvidenciaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EvidenciaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EvidenciaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EvidenciaJPA copyJPA(EvidenciaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EvidenciaJPA __tmp = (EvidenciaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
