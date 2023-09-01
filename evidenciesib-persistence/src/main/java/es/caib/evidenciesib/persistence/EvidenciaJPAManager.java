
package es.caib.evidenciesib.persistence;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import es.caib.evidenciesib.model.entity.*;
import es.caib.evidenciesib.model.fields.*;
import es.caib.evidenciesib.model.dao.*;
import org.fundaciobit.genapp.common.query.TableName;
import org.fundaciobit.genapp.common.i18n.I18NException;


public class EvidenciaJPAManager
         extends AbstractJPAManager<Evidencia, Long>
         implements EvidenciaIJPAManager, IEvidenciaManager, EvidenciaFields {



    public static final TableName<Evidencia> _TABLENAME =  new TableName<Evidencia>("EvidenciaJPA");


    @PersistenceContext
    protected EntityManager __em;

    public EvidenciaJPAManager() {
    }

    protected EvidenciaJPAManager(EntityManager __em) {
      this.__em = __em;
    }

    @Override
    public EntityManager getEntityManager() {
      return this.__em;
    }
    public Class<?> getJPAClass() {
        return EvidenciaJPA. class;
    }



    public TableName<Evidencia> getTableName() {
        return _TABLENAME;
    }


    @Override
    protected String getTableNameVariable() {
        return _TABLE_MODEL;
    }


    public Evidencia[] listToArray(List<Evidencia> list)  {
        if(list == null) { return null; };
        return list.toArray(new Evidencia[list.size()]);
    };

    public Evidencia create( java.lang.String _nom_, java.lang.String _personaNif_, java.lang.String _personaUsername_, java.lang.String _personaNom_, java.lang.String _personaLlinatge1_, java.lang.String _personaLlinatge2_, java.lang.String _personaEmail_, java.lang.String _personaMobil_, java.sql.Timestamp _dataInici_, java.sql.Timestamp _dataFi_, java.lang.String _usuariAplicacio_, java.lang.String _usuariPersona_, int _estatCodi_, java.lang.String _estatError_, java.lang.String _estatExcepcio_, int _loginType_, java.lang.String _loginSubtype_, java.lang.String _loginQaa_, java.sql.Timestamp _loginData_, java.lang.String _loginId_, java.lang.String _loginAuthMethod_, java.lang.String _loginAdditionalProperties_, java.lang.String _localitzacioIp_, java.lang.String _localitzacioCodiPostal_, java.lang.String _localitzacioLatitud_, java.lang.String _localitzacioLongitud_, java.lang.String _localitzacioRegio_, java.lang.String _localitzacioCiutat_, java.lang.String _localitzacioPais_, java.lang.String _firmaReason_, java.lang.String _firmaIdiomaDocument_, int _firmaTipusDocumental_, long _fitxerOriginalID_, java.lang.Long _fitxerAdaptatID_, java.lang.Long _fitxerSignatID_, java.lang.String _callBackUrl_) throws I18NException {
        EvidenciaJPA __bean =  new EvidenciaJPA(_nom_,_personaNif_,_personaUsername_,_personaNom_,_personaLlinatge1_,_personaLlinatge2_,_personaEmail_,_personaMobil_,_dataInici_,_dataFi_,_usuariAplicacio_,_usuariPersona_,_estatCodi_,_estatError_,_estatExcepcio_,_loginType_,_loginSubtype_,_loginQaa_,_loginData_,_loginId_,_loginAuthMethod_,_loginAdditionalProperties_,_localitzacioIp_,_localitzacioCodiPostal_,_localitzacioLatitud_,_localitzacioLongitud_,_localitzacioRegio_,_localitzacioCiutat_,_localitzacioPais_,_firmaReason_,_firmaIdiomaDocument_,_firmaTipusDocumental_,_fitxerOriginalID_,_fitxerAdaptatID_,_fitxerSignatID_,_callBackUrl_);
        return create(__bean);
    }



 public void delete(long _evidenciaID_) {
   delete(findByPrimaryKey(_evidenciaID_));
 }




    public Evidencia findByPrimaryKey(long _evidenciaID_) {
        return __em.find(EvidenciaJPA.class, _evidenciaID_);  
    }
    @Override
    protected Evidencia getJPAInstance(Evidencia __bean) {
        return convertToJPA(__bean);
    }


    public static EvidenciaJPA convertToJPA(Evidencia __bean) {
      if (__bean == null) {
        return null;
      }
      if(__bean instanceof EvidenciaJPA) {
        return (EvidenciaJPA)__bean;
      }
      
      return EvidenciaJPA.toJPA(__bean);
    }


}