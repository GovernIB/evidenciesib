
package es.caib.evidenciesib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EvidenciaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "evi_evidencia";


  public static final String _TABLE_MODEL = "evidencia";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EVIDENCIAID = new LongField(_TABLE_MODEL, "evidenciaID", "evidenciaid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField PERSONANOM = new StringField(_TABLE_MODEL, "personaNom", "personanom");
	 public static final StringField PERSONALLINATGE1 = new StringField(_TABLE_MODEL, "personaLlinatge1", "personallinatge1");
	 public static final StringField PERSONALLINATGE2 = new StringField(_TABLE_MODEL, "personaLlinatge2", "personallinatge2");
	 public static final StringField PERSONANIF = new StringField(_TABLE_MODEL, "personaNif", "personanif");
	 public static final StringField PERSONAEMAIL = new StringField(_TABLE_MODEL, "personaEmail", "personaemail");
	 public static final StringField PERSONAMOBIL = new StringField(_TABLE_MODEL, "personaMobil", "personamobil");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "dataInici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "dataFi", "datafi");
	 public static final StringField USUARIAPLICACIO = new StringField(_TABLE_MODEL, "usuariAplicacio", "usuariaplicacio");
	 public static final StringField USUARIPERSONA = new StringField(_TABLE_MODEL, "usuariPersona", "usuaripersona");
	 public static final IntegerField ESTATCODI = new IntegerField(_TABLE_MODEL, "estatCodi", "estatcodi");
	 public static final StringField ESTATERROR = new StringField(_TABLE_MODEL, "estatError", "estaterror");
	 public static final StringField ESTATEXCEPCIO = new StringField(_TABLE_MODEL, "estatExcepcio", "estatexcepcio");
	 public static final IntegerField LOGINTYPE = new IntegerField(_TABLE_MODEL, "loginType", "logintype");
	 public static final StringField LOGINID = new StringField(_TABLE_MODEL, "loginId", "loginid");
	 public static final TimestampField LOGINDATA = new TimestampField(_TABLE_MODEL, "loginData", "logindata");
	 public static final StringField LOCALITZACIOIP = new StringField(_TABLE_MODEL, "localitzacioIp", "localitzacioip");
	 public static final StringField LOCALITZACIOCODIPOSTAL = new StringField(_TABLE_MODEL, "localitzacioCodiPostal", "localitzaciocodipostal");
	 public static final StringField LOCALITZACIOLONGITUD = new StringField(_TABLE_MODEL, "localitzacioLongitud", "localitzaciolongitud");
	 public static final StringField LOCALITZACIOCIUTAT = new StringField(_TABLE_MODEL, "localitzacioCiutat", "localitzaciociutat");
	 public static final StringField LOCALITZACIOLATITUD = new StringField(_TABLE_MODEL, "localitzacioLatitud", "localitzaciolatitud");
	 public static final StringField LOCALITZACIOREGIO = new StringField(_TABLE_MODEL, "localitzacioRegio", "localitzacioregio");
	 public static final StringField LOCALITZACIOPAIS = new StringField(_TABLE_MODEL, "localitzacioPais", "localitzaciopais");
	 public static final StringField FIRMAREASON = new StringField(_TABLE_MODEL, "firmaReason", "firmareason");
	 public static final IntegerField FIRMATIPUSDOCUMENTAL = new IntegerField(_TABLE_MODEL, "firmaTipusDocumental", "firmatipusdocumental");
	 public static final StringField FIRMAIDIOMADOCUMENT = new StringField(_TABLE_MODEL, "firmaIdiomaDocument", "firmaidiomadocument");
	 public static final LongField FITXERORIGINALID = new LongField(_TABLE_MODEL, "fitxerOriginalID", "fitxeroriginalid");
	 public static final LongField FITXERADAPTATID = new LongField(_TABLE_MODEL, "fitxerAdaptatID", "fitxeradaptatid");
	 public static final LongField FITXERSIGNATID = new LongField(_TABLE_MODEL, "fitxerSignatID", "fitxersignatid");


  public static final Field<?>[] ALL_EVIDENCIA_FIELDS = {
    EVIDENCIAID,
    NOM,
    PERSONANOM,
    PERSONALLINATGE1,
    PERSONALLINATGE2,
    PERSONANIF,
    PERSONAEMAIL,
    PERSONAMOBIL,
    DATAINICI,
    DATAFI,
    USUARIAPLICACIO,
    USUARIPERSONA,
    ESTATCODI,
    ESTATERROR,
    ESTATEXCEPCIO,
    LOGINTYPE,
    LOGINID,
    LOGINDATA,
    LOCALITZACIOIP,
    LOCALITZACIOCODIPOSTAL,
    LOCALITZACIOLONGITUD,
    LOCALITZACIOCIUTAT,
    LOCALITZACIOLATITUD,
    LOCALITZACIOREGIO,
    LOCALITZACIOPAIS,
    FIRMAREASON,
    FIRMATIPUSDOCUMENTAL,
    FIRMAIDIOMADOCUMENT,
    FITXERORIGINALID,
    FITXERADAPTATID,
    FITXERSIGNATID
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EVIDENCIAID
  };
}
