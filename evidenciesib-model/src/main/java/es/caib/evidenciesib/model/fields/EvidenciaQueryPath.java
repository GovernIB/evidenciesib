
package es.caib.evidenciesib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EvidenciaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EvidenciaQueryPath() {
  }

  protected EvidenciaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField EVIDENCIAID() {
    return new LongField(getQueryPath(), EvidenciaFields.EVIDENCIAID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), EvidenciaFields.NOM);
  }

  public StringField PERSONANOM() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONANOM);
  }

  public StringField PERSONALLINATGE1() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONALLINATGE1);
  }

  public StringField PERSONALLINATGE2() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONALLINATGE2);
  }

  public StringField PERSONANIF() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONANIF);
  }

  public StringField PERSONAEMAIL() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONAEMAIL);
  }

  public StringField PERSONAMOBIL() {
    return new StringField(getQueryPath(), EvidenciaFields.PERSONAMOBIL);
  }

  public StringField DOCUMENTHASH() {
    return new StringField(getQueryPath(), EvidenciaFields.DOCUMENTHASH);
  }

  public LongField DOCUMENTFITXERID() {
    return new LongField(getQueryPath(), EvidenciaFields.DOCUMENTFITXERID);
  }

  public LongField DOCUMENTMIDA() {
    return new LongField(getQueryPath(), EvidenciaFields.DOCUMENTMIDA);
  }

  public TimestampField DATAINICI() {
    return new TimestampField(getQueryPath(), EvidenciaFields.DATAINICI);
  }

  public TimestampField DATAFI() {
    return new TimestampField(getQueryPath(), EvidenciaFields.DATAFI);
  }

  public StringField USUARIAPLICACIO() {
    return new StringField(getQueryPath(), EvidenciaFields.USUARIAPLICACIO);
  }

  public StringField USUARIPERSONA() {
    return new StringField(getQueryPath(), EvidenciaFields.USUARIPERSONA);
  }

  public IntegerField ESTATCODI() {
    return new IntegerField(getQueryPath(), EvidenciaFields.ESTATCODI);
  }

  public StringField ESTATERROR() {
    return new StringField(getQueryPath(), EvidenciaFields.ESTATERROR);
  }

  public StringField ESTATEXCEPCIO() {
    return new StringField(getQueryPath(), EvidenciaFields.ESTATEXCEPCIO);
  }

  public IntegerField LOGINTYPE() {
    return new IntegerField(getQueryPath(), EvidenciaFields.LOGINTYPE);
  }

  public StringField LOGINID() {
    return new StringField(getQueryPath(), EvidenciaFields.LOGINID);
  }

  public TimestampField LOGINDATA() {
    return new TimestampField(getQueryPath(), EvidenciaFields.LOGINDATA);
  }

  public StringField LOCALITZACIOIP() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOIP);
  }

  public StringField LOCALITZACIOCODIPOSTAL() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOCODIPOSTAL);
  }

  public StringField LOCALITZACIOLONGITUD() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOLONGITUD);
  }

  public StringField LOCALITZACIOLATITUD() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOLATITUD);
  }

  public StringField LOCALITZACIOCIUTAT() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOCIUTAT);
  }

  public StringField LOCALITZACIOREGIO() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOREGIO);
  }

  public StringField LOCALITZACIOPAIS() {
    return new StringField(getQueryPath(), EvidenciaFields.LOCALITZACIOPAIS);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EvidenciaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public FitxerQueryPath DOCUMENTFITXER() {
    return new FitxerQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EvidenciaQueryPath.this.getQueryPath() + "documentFitxer" + ".";
      }
    });
  }

}
