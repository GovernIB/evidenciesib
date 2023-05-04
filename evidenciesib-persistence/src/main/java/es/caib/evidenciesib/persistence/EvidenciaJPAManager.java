
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

    public Evidencia create( java.lang.String _nom_, java.lang.String _personanom_, java.lang.String _personallinatge1_, java.lang.String _personallinatge2_, java.lang.String _personanif_, java.lang.String _documenthash_, long _documentFitxerID_, long _documentmida_, java.sql.Timestamp _datainici_, java.sql.Timestamp _datafi_, java.lang.String _usuariaplicacio_, java.lang.String _usuaripersona_, int _estatcodi_, java.lang.String _estaterror_, java.lang.String _estatexcepcio_, java.lang.String _personamobil_, int _logintype_, java.lang.String _loginid_, java.sql.Timestamp _logindata_, java.lang.String _localitzacioip_, java.lang.String _localitzaciocodipostal_, java.lang.String _localitzaciocoordenades_, java.lang.String _personaemail_) throws I18NException {
        EvidenciaJPA __bean =  new EvidenciaJPA(_nom_,_personanom_,_personallinatge1_,_personallinatge2_,_personanif_,_documenthash_,_documentFitxerID_,_documentmida_,_datainici_,_datafi_,_usuariaplicacio_,_usuaripersona_,_estatcodi_,_estaterror_,_estatexcepcio_,_personamobil_,_logintype_,_loginid_,_logindata_,_localitzacioip_,_localitzaciocodipostal_,_localitzaciocoordenades_,_personaemail_);
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