
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
        @Index(name="evi_evidencia_docfitid_fk_i", columnList = "documentfitxerid")})
@SequenceGenerator(name="EVIDENCIA_SEQ", sequenceName="evi_evidencia_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EvidenciaJPA implements Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EVIDENCIA_SEQ")
    @Column(name="evidenciaid",nullable = false,length = 19)
    long evidenciaID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="personanom",nullable = false,length = 255)
    java.lang.String personaNom;

    @Column(name="personallinatge1",nullable = false,length = 255)
    java.lang.String personaLlinatge1;

    @Column(name="personallinatge2",length = 255)
    java.lang.String personaLlinatge2;

    @Column(name="personanif",nullable = false,length = 100)
    java.lang.String personaNif;

    @Column(name="personaemail",length = 255)
    java.lang.String personaEmail;

    @Column(name="personamobil",length = 100)
    java.lang.String personaMobil;

    @Column(name="documenthash",length = 255)
    java.lang.String documentHash;

    @Column(name="documentfitxerid",nullable = false,length = 19)
    long documentFitxerID;

    @Column(name="documentmida",nullable = false,length = 19)
    long documentMida;

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

    @Column(name="estaterror",length = 255)
    java.lang.String estatError;

    @Column(name="estatexcepcio",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String estatExcepcio;

    @org.hibernate.annotations.ColumnDefault("0")
    @Column(name="logintype",nullable = false,length = 10)
    int loginType = 0;

    @Column(name="loginid",length = 255)
    java.lang.String loginId;

    @Column(name="logindata",length = 29,precision = 6)
    java.sql.Timestamp loginData;

    @Column(name="localitzacioip",length = 100)
    java.lang.String localitzacioIp;

    @Column(name="localitzaciocodipostal",length = 100)
    java.lang.String localitzacioCodiPostal;

    @Column(name="localitzaciolongitud",length = 100)
    java.lang.String localitzacioLongitud;

    @Column(name="localitzaciolatitud",length = 100)
    java.lang.String localitzacioLatitud;

    @Column(name="localitzaciociutat",length = 255)
    java.lang.String localitzacioCiutat;

    @Column(name="localitzacioregio",length = 100)
    java.lang.String localitzacioRegio;

    @Column(name="localitzaciopais",length = 100)
    java.lang.String localitzacioPais;



  /** Constructor Buit */
  public EvidenciaJPA() {
  }

  /** Constructor amb tots els camps  */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personaNom , java.lang.String personaLlinatge1 , java.lang.String personaLlinatge2 , java.lang.String personaNif , java.lang.String personaEmail , java.lang.String personaMobil , java.lang.String documentHash , long documentFitxerID , long documentMida , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.String usuariAplicacio , java.lang.String usuariPersona , int estatCodi , java.lang.String estatError , java.lang.String estatExcepcio , int loginType , java.lang.String loginId , java.sql.Timestamp loginData , java.lang.String localitzacioIp , java.lang.String localitzacioCodiPostal , java.lang.String localitzacioLongitud , java.lang.String localitzacioLatitud , java.lang.String localitzacioCiutat , java.lang.String localitzacioRegio , java.lang.String localitzacioPais) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personaNom=personaNom;
    this.personaLlinatge1=personaLlinatge1;
    this.personaLlinatge2=personaLlinatge2;
    this.personaNif=personaNif;
    this.personaEmail=personaEmail;
    this.personaMobil=personaMobil;
    this.documentHash=documentHash;
    this.documentFitxerID=documentFitxerID;
    this.documentMida=documentMida;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacio=usuariAplicacio;
    this.usuariPersona=usuariPersona;
    this.estatCodi=estatCodi;
    this.estatError=estatError;
    this.estatExcepcio=estatExcepcio;
    this.loginType=loginType;
    this.loginId=loginId;
    this.loginData=loginData;
    this.localitzacioIp=localitzacioIp;
    this.localitzacioCodiPostal=localitzacioCodiPostal;
    this.localitzacioLongitud=localitzacioLongitud;
    this.localitzacioLatitud=localitzacioLatitud;
    this.localitzacioCiutat=localitzacioCiutat;
    this.localitzacioRegio=localitzacioRegio;
    this.localitzacioPais=localitzacioPais;
}
  /** Constructor sense valors autoincrementals */
  public EvidenciaJPA(java.lang.String nom , java.lang.String personaNom , java.lang.String personaLlinatge1 , java.lang.String personaLlinatge2 , java.lang.String personaNif , java.lang.String personaEmail , java.lang.String personaMobil , java.lang.String documentHash , long documentFitxerID , long documentMida , java.sql.Timestamp dataInici , java.sql.Timestamp dataFi , java.lang.String usuariAplicacio , java.lang.String usuariPersona , int estatCodi , java.lang.String estatError , java.lang.String estatExcepcio , int loginType , java.lang.String loginId , java.sql.Timestamp loginData , java.lang.String localitzacioIp , java.lang.String localitzacioCodiPostal , java.lang.String localitzacioLongitud , java.lang.String localitzacioLatitud , java.lang.String localitzacioCiutat , java.lang.String localitzacioRegio , java.lang.String localitzacioPais) {
    this.nom=nom;
    this.personaNom=personaNom;
    this.personaLlinatge1=personaLlinatge1;
    this.personaLlinatge2=personaLlinatge2;
    this.personaNif=personaNif;
    this.personaEmail=personaEmail;
    this.personaMobil=personaMobil;
    this.documentHash=documentHash;
    this.documentFitxerID=documentFitxerID;
    this.documentMida=documentMida;
    this.dataInici=dataInici;
    this.dataFi=dataFi;
    this.usuariAplicacio=usuariAplicacio;
    this.usuariPersona=usuariPersona;
    this.estatCodi=estatCodi;
    this.estatError=estatError;
    this.estatExcepcio=estatExcepcio;
    this.loginType=loginType;
    this.loginId=loginId;
    this.loginData=loginData;
    this.localitzacioIp=localitzacioIp;
    this.localitzacioCodiPostal=localitzacioCodiPostal;
    this.localitzacioLongitud=localitzacioLongitud;
    this.localitzacioLatitud=localitzacioLatitud;
    this.localitzacioCiutat=localitzacioCiutat;
    this.localitzacioRegio=localitzacioRegio;
    this.localitzacioPais=localitzacioPais;
}
  /** Constructor dels valors Not Null */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personaNom , java.lang.String personaLlinatge1 , java.lang.String personaNif , long documentFitxerID , long documentMida , java.sql.Timestamp dataInici , int estatCodi , int loginType) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personaNom=personaNom;
    this.personaLlinatge1=personaLlinatge1;
    this.personaNif=personaNif;
    this.documentFitxerID=documentFitxerID;
    this.documentMida=documentMida;
    this.dataInici=dataInici;
    this.estatCodi=estatCodi;
    this.loginType=loginType;
}
  public EvidenciaJPA(Evidencia __bean) {
    this.setEvidenciaID(__bean.getEvidenciaID());
    this.setNom(__bean.getNom());
    this.setPersonaNom(__bean.getPersonaNom());
    this.setPersonaLlinatge1(__bean.getPersonaLlinatge1());
    this.setPersonaLlinatge2(__bean.getPersonaLlinatge2());
    this.setPersonaNif(__bean.getPersonaNif());
    this.setPersonaEmail(__bean.getPersonaEmail());
    this.setPersonaMobil(__bean.getPersonaMobil());
    this.setDocumentHash(__bean.getDocumentHash());
    this.setDocumentFitxerID(__bean.getDocumentFitxerID());
    this.setDocumentMida(__bean.getDocumentMida());
    this.setDataInici(__bean.getDataInici());
    this.setDataFi(__bean.getDataFi());
    this.setUsuariAplicacio(__bean.getUsuariAplicacio());
    this.setUsuariPersona(__bean.getUsuariPersona());
    this.setEstatCodi(__bean.getEstatCodi());
    this.setEstatError(__bean.getEstatError());
    this.setEstatExcepcio(__bean.getEstatExcepcio());
    this.setLoginType(__bean.getLoginType());
    this.setLoginId(__bean.getLoginId());
    this.setLoginData(__bean.getLoginData());
    this.setLocalitzacioIp(__bean.getLocalitzacioIp());
    this.setLocalitzacioCodiPostal(__bean.getLocalitzacioCodiPostal());
    this.setLocalitzacioLongitud(__bean.getLocalitzacioLongitud());
    this.setLocalitzacioLatitud(__bean.getLocalitzacioLatitud());
    this.setLocalitzacioCiutat(__bean.getLocalitzacioCiutat());
    this.setLocalitzacioRegio(__bean.getLocalitzacioRegio());
    this.setLocalitzacioPais(__bean.getLocalitzacioPais());
    // Fitxer
    this.setDocumentFitxer(FitxerJPA.toJPA(__bean.getDocumentFitxer()));
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

	public java.lang.String getPersonaNif() {
		return(personaNif);
	};
	public void setPersonaNif(java.lang.String _personaNif_) {
		this.personaNif = _personaNif_;
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

	public java.lang.String getDocumentHash() {
		return(documentHash);
	};
	public void setDocumentHash(java.lang.String _documentHash_) {
		this.documentHash = _documentHash_;
	};

	public long getDocumentFitxerID() {
		return(documentFitxerID);
	};
	public void setDocumentFitxerID(long _documentFitxerID_) {
		this.documentFitxerID = _documentFitxerID_;
	};

	public long getDocumentMida() {
		return(documentMida);
	};
	public void setDocumentMida(long _documentMida_) {
		this.documentMida = _documentMida_;
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

	public int getLoginType() {
		return(loginType);
	};
	public void setLoginType(int _loginType_) {
		this.loginType = _loginType_;
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

	public java.lang.String getLocalitzacioLongitud() {
		return(localitzacioLongitud);
	};
	public void setLocalitzacioLongitud(java.lang.String _localitzacioLongitud_) {
		this.localitzacioLongitud = _localitzacioLongitud_;
	};

	public java.lang.String getLocalitzacioLatitud() {
		return(localitzacioLatitud);
	};
	public void setLocalitzacioLatitud(java.lang.String _localitzacioLatitud_) {
		this.localitzacioLatitud = _localitzacioLatitud_;
	};

	public java.lang.String getLocalitzacioCiutat() {
		return(localitzacioCiutat);
	};
	public void setLocalitzacioCiutat(java.lang.String _localitzacioCiutat_) {
		this.localitzacioCiutat = _localitzacioCiutat_;
	};

	public java.lang.String getLocalitzacioRegio() {
		return(localitzacioRegio);
	};
	public void setLocalitzacioRegio(java.lang.String _localitzacioRegio_) {
		this.localitzacioRegio = _localitzacioRegio_;
	};

	public java.lang.String getLocalitzacioPais() {
		return(localitzacioPais);
	};
	public void setLocalitzacioPais(java.lang.String _localitzacioPais_) {
		this.localitzacioPais = _localitzacioPais_;
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
    @JoinColumn(name = "documentfitxerid", referencedColumnName ="fitxerID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="evi_evidencia_fitxer_fitdoc_fk"))
    private FitxerJPA documentFitxer;

    public FitxerJPA getDocumentFitxer() {
    return this.documentFitxer;
  }

    public  void setDocumentFitxer(FitxerJPA documentFitxer) {
    this.documentFitxer = documentFitxer;
  }


 // ---------------  STATIC METHODS ------------------
  public static EvidenciaJPA toJPA(Evidencia __bean) {
    if (__bean == null) { return null;}
    EvidenciaJPA __tmp = new EvidenciaJPA();
    __tmp.setEvidenciaID(__bean.getEvidenciaID());
    __tmp.setNom(__bean.getNom());
    __tmp.setPersonaNom(__bean.getPersonaNom());
    __tmp.setPersonaLlinatge1(__bean.getPersonaLlinatge1());
    __tmp.setPersonaLlinatge2(__bean.getPersonaLlinatge2());
    __tmp.setPersonaNif(__bean.getPersonaNif());
    __tmp.setPersonaEmail(__bean.getPersonaEmail());
    __tmp.setPersonaMobil(__bean.getPersonaMobil());
    __tmp.setDocumentHash(__bean.getDocumentHash());
    __tmp.setDocumentFitxerID(__bean.getDocumentFitxerID());
    __tmp.setDocumentMida(__bean.getDocumentMida());
    __tmp.setDataInici(__bean.getDataInici());
    __tmp.setDataFi(__bean.getDataFi());
    __tmp.setUsuariAplicacio(__bean.getUsuariAplicacio());
    __tmp.setUsuariPersona(__bean.getUsuariPersona());
    __tmp.setEstatCodi(__bean.getEstatCodi());
    __tmp.setEstatError(__bean.getEstatError());
    __tmp.setEstatExcepcio(__bean.getEstatExcepcio());
    __tmp.setLoginType(__bean.getLoginType());
    __tmp.setLoginId(__bean.getLoginId());
    __tmp.setLoginData(__bean.getLoginData());
    __tmp.setLocalitzacioIp(__bean.getLocalitzacioIp());
    __tmp.setLocalitzacioCodiPostal(__bean.getLocalitzacioCodiPostal());
    __tmp.setLocalitzacioLongitud(__bean.getLocalitzacioLongitud());
    __tmp.setLocalitzacioLatitud(__bean.getLocalitzacioLatitud());
    __tmp.setLocalitzacioCiutat(__bean.getLocalitzacioCiutat());
    __tmp.setLocalitzacioRegio(__bean.getLocalitzacioRegio());
    __tmp.setLocalitzacioPais(__bean.getLocalitzacioPais());
    // Fitxer
    __tmp.setDocumentFitxer(FitxerJPA.toJPA(__bean.getDocumentFitxer()));
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
