package es.caib.evidenciesib.model.dao;

import es.caib.evidenciesib.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEvidenciaManager extends org.fundaciobit.genapp.common.query.ITableManager<Evidencia, Long> {


	public Evidencia create( java.lang.String _nom_, java.lang.String _personanom_, java.lang.String _personallinatge1_, java.lang.String _personallinatge2_, java.lang.String _personanif_, java.lang.String _documenthash_, long _documentFitxerID_, long _documentmida_, java.sql.Timestamp _datainici_, java.sql.Timestamp _datafi_, java.lang.String _usuariaplicacio_, java.lang.String _usuaripersona_, int _estatcodi_, java.lang.String _estaterror_, java.lang.String _estatexcepcio_, java.lang.String _personamobil_, int _logintype_, java.lang.String _loginid_, java.sql.Timestamp _logindata_, java.lang.String _localitzacioip_, java.lang.String _localitzaciocodipostal_, java.lang.String _localitzaciocoordenades_, java.lang.String _personaemail_) throws I18NException;

	public Evidencia findByPrimaryKey(long _evidenciaID_);

	public void delete(long _evidenciaID_);

}
