
package es.caib.evidenciesib.model.fields;
import org.fundaciobit.genapp.common.query.*;
public interface EvidenciaFields extends java.io.Serializable {

  public static final String _TABLE_SQL = "evi_evidencia";


  public static final String _TABLE_MODEL = "evidencia";


  public static final String _TABLE_TRANSLATION = _TABLE_MODEL + "." + _TABLE_MODEL;


	 public static final LongField EVIDENCIAID = new LongField(_TABLE_MODEL, "evidenciaID", "evidenciaid");  // PK
	 public static final StringField NOM = new StringField(_TABLE_MODEL, "nom", "nom");
	 public static final StringField PERSONANOM = new StringField(_TABLE_MODEL, "personanom", "personanom");
	 public static final StringField PERSONALLINATGE1 = new StringField(_TABLE_MODEL, "personallinatge1", "personallinatge1");
	 public static final StringField PERSONALLINATGE2 = new StringField(_TABLE_MODEL, "personallinatge2", "personallinatge2");
	 public static final StringField PERSONANIF = new StringField(_TABLE_MODEL, "personanif", "personanif");
	 public static final StringField DOCUMENTHASH = new StringField(_TABLE_MODEL, "documenthash", "documenthash");
	 public static final LongField DOCUMENTFITXERID = new LongField(_TABLE_MODEL, "documentFitxerID", "documentfitxerid");
	 public static final LongField DOCUMENTMIDA = new LongField(_TABLE_MODEL, "documentmida", "documentmida");
	 public static final TimestampField DATAINICI = new TimestampField(_TABLE_MODEL, "datainici", "datainici");
	 public static final TimestampField DATAFI = new TimestampField(_TABLE_MODEL, "datafi", "datafi");
	 public static final StringField USUARIAPLICACIO = new StringField(_TABLE_MODEL, "usuariaplicacio", "usuariaplicacio");
	 public static final StringField USUARIPERSONA = new StringField(_TABLE_MODEL, "usuaripersona", "usuaripersona");
	 public static final IntegerField ESTATCODI = new IntegerField(_TABLE_MODEL, "estatcodi", "estatcodi");
	 public static final StringField ESTATERROR = new StringField(_TABLE_MODEL, "estaterror", "estaterror");
	 public static final StringField ESTATEXCEPCIO = new StringField(_TABLE_MODEL, "estatexcepcio", "estatexcepcio");
	 public static final StringField PERSONAMOBIL = new StringField(_TABLE_MODEL, "personamobil", "personamobil");
	 public static final IntegerField LOGINTYPE = new IntegerField(_TABLE_MODEL, "logintype", "logintype");
	 public static final StringField LOGINID = new StringField(_TABLE_MODEL, "loginid", "loginid");
	 public static final TimestampField LOGINDATA = new TimestampField(_TABLE_MODEL, "logindata", "logindata");
	 public static final StringField LOCALITZACIOIP = new StringField(_TABLE_MODEL, "localitzacioip", "localitzacioip");
	 public static final StringField LOCALITZACIOCODIPOSTAL = new StringField(_TABLE_MODEL, "localitzaciocodipostal", "localitzaciocodipostal");
	 public static final StringField LOCALITZACIOCOORDENADES = new StringField(_TABLE_MODEL, "localitzaciocoordenades", "localitzaciocoordenades");
	 public static final StringField PERSONAEMAIL = new StringField(_TABLE_MODEL, "personaemail", "personaemail");


  public static final Field<?>[] ALL_EVIDENCIA_FIELDS = {
    EVIDENCIAID,
    NOM,
    PERSONANOM,
    PERSONALLINATGE1,
    PERSONALLINATGE2,
    PERSONANIF,
    DOCUMENTHASH,
    DOCUMENTFITXERID,
    DOCUMENTMIDA,
    DATAINICI,
    DATAFI,
    USUARIAPLICACIO,
    USUARIPERSONA,
    ESTATCODI,
    ESTATERROR,
    ESTATEXCEPCIO,
    PERSONAMOBIL,
    LOGINTYPE,
    LOGINID,
    LOGINDATA,
    LOCALITZACIOIP,
    LOCALITZACIOCODIPOSTAL,
    LOCALITZACIOCOORDENADES,
    PERSONAEMAIL
  };


  public static final Field<?>[] PRIMARYKEY_FIELDS = {
EVIDENCIAID
  };
}
