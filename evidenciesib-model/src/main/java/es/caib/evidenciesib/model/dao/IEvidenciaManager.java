package es.caib.evidenciesib.model.dao;

import es.caib.evidenciesib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEvidenciaManager extends org.fundaciobit.genapp.common.query.ITableManager<Evidencia, Long> {


	public Evidencia create( java.lang.String _nom_, java.lang.String _personaNom_, java.lang.String _personaLlinatge1_, java.lang.String _personaLlinatge2_, java.lang.String _personaNif_, java.lang.String _personaEmail_, java.lang.String _personaMobil_, java.lang.String _documentHash_, long _documentFitxerID_, long _documentMida_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.String _usuariAplicacio_, java.lang.String _usuariPersona_, int _estatCodi_, java.lang.String _estatError_, java.lang.String _estatExcepcio_, int _loginType_, java.lang.String _loginId_, java.sql.Timestamp _loginData_, java.lang.String _localitzacioIp_, java.lang.String _localitzacioCodiPostal_, java.lang.String _localitzacioLongitud_, java.lang.String _localitzacioLatitud_, java.lang.String _localitzacioCiutat_, java.lang.String _localitzacioRegio_, java.lang.String _localitzacioPais_) throws I18NException;

	public Evidencia findByPrimaryKey(long _evidenciaID_);

	public void delete(long _evidenciaID_);

}
