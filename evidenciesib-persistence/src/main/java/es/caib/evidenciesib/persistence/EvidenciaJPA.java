
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
    java.lang.String personanom;

    @Column(name="personallinatge1",nullable = false,length = 255)
    java.lang.String personallinatge1;

    @Column(name="personallinatge2",length = 255)
    java.lang.String personallinatge2;

    @Column(name="personanif",nullable = false,length = 100)
    java.lang.String personanif;

    @Column(name="documenthash",nullable = false,length = 255)
    java.lang.String documenthash;

    @Column(name="documentfitxerid",nullable = false,length = 19)
    long documentFitxerID;

    @Column(name="documentmida",nullable = false,length = 19)
    long documentmida;

    @Column(name="datainici",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp datainici;

    @Column(name="datafi",length = 29,precision = 6)
    java.sql.Timestamp datafi;

    @Column(name="usuariaplicacio",length = 255)
    java.lang.String usuariaplicacio;

    @Column(name="usuaripersona",length = 100)
    java.lang.String usuaripersona;

    @Column(name="estatcodi",nullable = false,length = 10)
    int estatcodi;

    @Column(name="estaterror",length = 255)
    java.lang.String estaterror;

    @Column(name="estatexcepcio",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String estatexcepcio;

    @Column(name="personamobil",length = 100)
    java.lang.String personamobil;

    @org.hibernate.annotations.ColumnDefault("0")
    @Column(name="logintype",nullable = false,length = 10)
    int logintype = 0;

    @Column(name="loginid",length = 255)
    java.lang.String loginid;

    @Column(name="logindata",length = 29,precision = 6)
    java.sql.Timestamp logindata;

    @Column(name="localitzacioip",length = 100)
    java.lang.String localitzacioip;

    @Column(name="localitzaciocodipostal",length = 100)
    java.lang.String localitzaciocodipostal;

    @Column(name="localitzaciocoordenades",length = 255)
    java.lang.String localitzaciocoordenades;

    @Column(name="personaemail",length = 255)
    java.lang.String personaemail;



  /** Constructor Buit */
  public EvidenciaJPA() {
  }

  /** Constructor amb tots els camps  */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personanom , java.lang.String personallinatge1 , java.lang.String personallinatge2 , java.lang.String personanif , java.lang.String documenthash , long documentFitxerID , long documentmida , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.String usuariaplicacio , java.lang.String usuaripersona , int estatcodi , java.lang.String estaterror , java.lang.String estatexcepcio , java.lang.String personamobil , int logintype , java.lang.String loginid , java.sql.Timestamp logindata , java.lang.String localitzacioip , java.lang.String localitzaciocodipostal , java.lang.String localitzaciocoordenades , java.lang.String personaemail) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personanom=personanom;
    this.personallinatge1=personallinatge1;
    this.personallinatge2=personallinatge2;
    this.personanif=personanif;
    this.documenthash=documenthash;
    this.documentFitxerID=documentFitxerID;
    this.documentmida=documentmida;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacio=usuariaplicacio;
    this.usuaripersona=usuaripersona;
    this.estatcodi=estatcodi;
    this.estaterror=estaterror;
    this.estatexcepcio=estatexcepcio;
    this.personamobil=personamobil;
    this.logintype=logintype;
    this.loginid=loginid;
    this.logindata=logindata;
    this.localitzacioip=localitzacioip;
    this.localitzaciocodipostal=localitzaciocodipostal;
    this.localitzaciocoordenades=localitzaciocoordenades;
    this.personaemail=personaemail;
}
  /** Constructor sense valors autoincrementals */
  public EvidenciaJPA(java.lang.String nom , java.lang.String personanom , java.lang.String personallinatge1 , java.lang.String personallinatge2 , java.lang.String personanif , java.lang.String documenthash , long documentFitxerID , long documentmida , java.sql.Timestamp datainici , java.sql.Timestamp datafi , java.lang.String usuariaplicacio , java.lang.String usuaripersona , int estatcodi , java.lang.String estaterror , java.lang.String estatexcepcio , java.lang.String personamobil , int logintype , java.lang.String loginid , java.sql.Timestamp logindata , java.lang.String localitzacioip , java.lang.String localitzaciocodipostal , java.lang.String localitzaciocoordenades , java.lang.String personaemail) {
    this.nom=nom;
    this.personanom=personanom;
    this.personallinatge1=personallinatge1;
    this.personallinatge2=personallinatge2;
    this.personanif=personanif;
    this.documenthash=documenthash;
    this.documentFitxerID=documentFitxerID;
    this.documentmida=documentmida;
    this.datainici=datainici;
    this.datafi=datafi;
    this.usuariaplicacio=usuariaplicacio;
    this.usuaripersona=usuaripersona;
    this.estatcodi=estatcodi;
    this.estaterror=estaterror;
    this.estatexcepcio=estatexcepcio;
    this.personamobil=personamobil;
    this.logintype=logintype;
    this.loginid=loginid;
    this.logindata=logindata;
    this.localitzacioip=localitzacioip;
    this.localitzaciocodipostal=localitzaciocodipostal;
    this.localitzaciocoordenades=localitzaciocoordenades;
    this.personaemail=personaemail;
}
  /** Constructor dels valors Not Null */
  public EvidenciaJPA(long evidenciaID , java.lang.String nom , java.lang.String personanom , java.lang.String personallinatge1 , java.lang.String personanif , java.lang.String documenthash , long documentFitxerID , long documentmida , java.sql.Timestamp datainici , int estatcodi , int logintype) {
    this.evidenciaID=evidenciaID;
    this.nom=nom;
    this.personanom=personanom;
    this.personallinatge1=personallinatge1;
    this.personanif=personanif;
    this.documenthash=documenthash;
    this.documentFitxerID=documentFitxerID;
    this.documentmida=documentmida;
    this.datainici=datainici;
    this.estatcodi=estatcodi;
    this.logintype=logintype;
}
  public EvidenciaJPA(Evidencia __bean) {
    this.setEvidenciaID(__bean.getEvidenciaID());
    this.setNom(__bean.getNom());
    this.setPersonanom(__bean.getPersonanom());
    this.setPersonallinatge1(__bean.getPersonallinatge1());
    this.setPersonallinatge2(__bean.getPersonallinatge2());
    this.setPersonanif(__bean.getPersonanif());
    this.setDocumenthash(__bean.getDocumenthash());
    this.setDocumentFitxerID(__bean.getDocumentFitxerID());
    this.setDocumentmida(__bean.getDocumentmida());
    this.setDatainici(__bean.getDatainici());
    this.setDatafi(__bean.getDatafi());
    this.setUsuariaplicacio(__bean.getUsuariaplicacio());
    this.setUsuaripersona(__bean.getUsuaripersona());
    this.setEstatcodi(__bean.getEstatcodi());
    this.setEstaterror(__bean.getEstaterror());
    this.setEstatexcepcio(__bean.getEstatexcepcio());
    this.setPersonamobil(__bean.getPersonamobil());
    this.setLogintype(__bean.getLogintype());
    this.setLoginid(__bean.getLoginid());
    this.setLogindata(__bean.getLogindata());
    this.setLocalitzacioip(__bean.getLocalitzacioip());
    this.setLocalitzaciocodipostal(__bean.getLocalitzaciocodipostal());
    this.setLocalitzaciocoordenades(__bean.getLocalitzaciocoordenades());
    this.setPersonaemail(__bean.getPersonaemail());
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

	public java.lang.String getPersonanom() {
		return(personanom);
	};
	public void setPersonanom(java.lang.String _personanom_) {
		this.personanom = _personanom_;
	};

	public java.lang.String getPersonallinatge1() {
		return(personallinatge1);
	};
	public void setPersonallinatge1(java.lang.String _personallinatge1_) {
		this.personallinatge1 = _personallinatge1_;
	};

	public java.lang.String getPersonallinatge2() {
		return(personallinatge2);
	};
	public void setPersonallinatge2(java.lang.String _personallinatge2_) {
		this.personallinatge2 = _personallinatge2_;
	};

	public java.lang.String getPersonanif() {
		return(personanif);
	};
	public void setPersonanif(java.lang.String _personanif_) {
		this.personanif = _personanif_;
	};

	public java.lang.String getDocumenthash() {
		return(documenthash);
	};
	public void setDocumenthash(java.lang.String _documenthash_) {
		this.documenthash = _documenthash_;
	};

	public long getDocumentFitxerID() {
		return(documentFitxerID);
	};
	public void setDocumentFitxerID(long _documentFitxerID_) {
		this.documentFitxerID = _documentFitxerID_;
	};

	public long getDocumentmida() {
		return(documentmida);
	};
	public void setDocumentmida(long _documentmida_) {
		this.documentmida = _documentmida_;
	};

	public java.sql.Timestamp getDatainici() {
		return(datainici);
	};
	public void setDatainici(java.sql.Timestamp _datainici_) {
		this.datainici = _datainici_;
	};

	public java.sql.Timestamp getDatafi() {
		return(datafi);
	};
	public void setDatafi(java.sql.Timestamp _datafi_) {
		this.datafi = _datafi_;
	};

	public java.lang.String getUsuariaplicacio() {
		return(usuariaplicacio);
	};
	public void setUsuariaplicacio(java.lang.String _usuariaplicacio_) {
		this.usuariaplicacio = _usuariaplicacio_;
	};

	public java.lang.String getUsuaripersona() {
		return(usuaripersona);
	};
	public void setUsuaripersona(java.lang.String _usuaripersona_) {
		this.usuaripersona = _usuaripersona_;
	};

	public int getEstatcodi() {
		return(estatcodi);
	};
	public void setEstatcodi(int _estatcodi_) {
		this.estatcodi = _estatcodi_;
	};

	public java.lang.String getEstaterror() {
		return(estaterror);
	};
	public void setEstaterror(java.lang.String _estaterror_) {
		this.estaterror = _estaterror_;
	};

	public java.lang.String getEstatexcepcio() {
		return(estatexcepcio);
	};
	public void setEstatexcepcio(java.lang.String _estatexcepcio_) {
		this.estatexcepcio = _estatexcepcio_;
	};

	public java.lang.String getPersonamobil() {
		return(personamobil);
	};
	public void setPersonamobil(java.lang.String _personamobil_) {
		this.personamobil = _personamobil_;
	};

	public int getLogintype() {
		return(logintype);
	};
	public void setLogintype(int _logintype_) {
		this.logintype = _logintype_;
	};

	public java.lang.String getLoginid() {
		return(loginid);
	};
	public void setLoginid(java.lang.String _loginid_) {
		this.loginid = _loginid_;
	};

	public java.sql.Timestamp getLogindata() {
		return(logindata);
	};
	public void setLogindata(java.sql.Timestamp _logindata_) {
		this.logindata = _logindata_;
	};

	public java.lang.String getLocalitzacioip() {
		return(localitzacioip);
	};
	public void setLocalitzacioip(java.lang.String _localitzacioip_) {
		this.localitzacioip = _localitzacioip_;
	};

	public java.lang.String getLocalitzaciocodipostal() {
		return(localitzaciocodipostal);
	};
	public void setLocalitzaciocodipostal(java.lang.String _localitzaciocodipostal_) {
		this.localitzaciocodipostal = _localitzaciocodipostal_;
	};

	public java.lang.String getLocalitzaciocoordenades() {
		return(localitzaciocoordenades);
	};
	public void setLocalitzaciocoordenades(java.lang.String _localitzaciocoordenades_) {
		this.localitzaciocoordenades = _localitzaciocoordenades_;
	};

	public java.lang.String getPersonaemail() {
		return(personaemail);
	};
	public void setPersonaemail(java.lang.String _personaemail_) {
		this.personaemail = _personaemail_;
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
    __tmp.setPersonanom(__bean.getPersonanom());
    __tmp.setPersonallinatge1(__bean.getPersonallinatge1());
    __tmp.setPersonallinatge2(__bean.getPersonallinatge2());
    __tmp.setPersonanif(__bean.getPersonanif());
    __tmp.setDocumenthash(__bean.getDocumenthash());
    __tmp.setDocumentFitxerID(__bean.getDocumentFitxerID());
    __tmp.setDocumentmida(__bean.getDocumentmida());
    __tmp.setDatainici(__bean.getDatainici());
    __tmp.setDatafi(__bean.getDatafi());
    __tmp.setUsuariaplicacio(__bean.getUsuariaplicacio());
    __tmp.setUsuaripersona(__bean.getUsuaripersona());
    __tmp.setEstatcodi(__bean.getEstatcodi());
    __tmp.setEstaterror(__bean.getEstaterror());
    __tmp.setEstatexcepcio(__bean.getEstatexcepcio());
    __tmp.setPersonamobil(__bean.getPersonamobil());
    __tmp.setLogintype(__bean.getLogintype());
    __tmp.setLoginid(__bean.getLoginid());
    __tmp.setLogindata(__bean.getLogindata());
    __tmp.setLocalitzacioip(__bean.getLocalitzacioip());
    __tmp.setLocalitzaciocodipostal(__bean.getLocalitzaciocodipostal());
    __tmp.setLocalitzaciocoordenades(__bean.getLocalitzaciocoordenades());
    __tmp.setPersonaemail(__bean.getPersonaemail());
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
