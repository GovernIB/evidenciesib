package es.caib.evidenciesib.model.dao;

import es.caib.evidenciesib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPluginManager extends org.fundaciobit.genapp.common.query.ITableManager<Plugin, Long> {


	public Plugin create( java.lang.String _nom_, java.lang.String _descripcio_, java.lang.String _classe_, int _tipus_, java.lang.String _propietats_, boolean _actiu_) throws I18NException;

	public Plugin findByPrimaryKey(long _pluginID_);

	public void delete(long _pluginID_);

}
