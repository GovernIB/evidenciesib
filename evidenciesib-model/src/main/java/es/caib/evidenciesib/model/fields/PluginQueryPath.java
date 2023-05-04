
package es.caib.evidenciesib.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class PluginQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public PluginQueryPath() {
  }

  protected PluginQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PLUGINID() {
    return new LongField(getQueryPath(), PluginFields.PLUGINID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), PluginFields.NOM);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), PluginFields.DESCRIPCIO);
  }

  public StringField CLASSE() {
    return new StringField(getQueryPath(), PluginFields.CLASSE);
  }

  public IntegerField TIPUS() {
    return new IntegerField(getQueryPath(), PluginFields.TIPUS);
  }

  public StringField PROPIETATS() {
    return new StringField(getQueryPath(), PluginFields.PROPIETATS);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), PluginFields.ACTIU);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (PluginFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
