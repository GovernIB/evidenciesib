package es.caib.evidenciesib.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fundaciobit.genapp.common.i18n.I18NException;


import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;



/**
 * 
 * @author anadal
 *
 */
@Stateless(name = "SampleLogicaEJB")
public class SampleLogicaEJB implements SampleLogicaService {
    
    @PersistenceContext
    protected EntityManager entityManager;
    

    @Override
    public Map<String, Long> getTableSizes() throws I18NException {

        String dialect = Configuracio.getAppProperties()
                .getProperty(Constants.EVIDENCIESIB_PROPERTY_BASE + "hibernate.dialect");

        if (dialect == null) {
            throw new I18NException("genapp.comodi",
                    "No s'ha trobat la propietat de configuració per a " + Constants.EVIDENCIESIB_PROPERTY_BASE
                            + ".hibernate.dialect, dins del fitxer de propietats de l'aplicació.");
        }

        boolean isPostgres = dialect.toLowerCase().contains("postgres");

        if (!isPostgres) {

            boolean isOracle = dialect.toLowerCase().contains("oracle");
            if (!isOracle) {

                throw new I18NException("genapp.comodi",
                        "Dialect no suportat per a la consulta de mida de taules: " + dialect);
            }

        }

        return getTableSizes(entityManager, isPostgres);
    }

    public static Map<String, Long> getTableSizes(EntityManager entityManager, boolean isPostgres) {

        Map<String, Long> tableSizes = new HashMap<String, Long>();

        if (isPostgres) {
            List<Object[]> results = entityManager
                    .createNativeQuery("SELECT " + " tablename AS table_name, "
                            + " pg_total_relation_size(schemaname || '.' || tablename)  AS total_bytes "
                            + " FROM pg_tables " + " WHERE schemaname NOT IN ('pg_catalog', 'information_schema')")
                    .getResultList();

            for (Object[] row : results) {
                tableSizes.put((String) row[0], ((Number) row[1]).longValue());
            }

        } else {
            // Oracle: user_segments agrupa por segmento (tabla, índice, lob...)
            // Filtramos solo TABLE y sumamos para consolidar particiones si las hay
            List<Object[]> results = entityManager.createNativeQuery(
                    "SELECT " + " segment_name AS table_name, SUM(bytes) AS total_bytes " + " FROM user_segments "
                            + " WHERE segment_type IN ('TABLE', 'TABLE PARTITION', 'TABLE SUBPARTITION') "
                            + " GROUP BY segment_name ")
                    .getResultList();

            for (Object[] row : results) {

                tableSizes.put((String) row[0], ((Number) row[1]).longValue());
            }
        }

        return tableSizes;
    }

//    @EJB(mappedName=es.caib.evidenciesib.ejb.FitxerService.JNDI_NAME)protected es.caib.evidenciesib.
//    ejb.FitxerService fitxerEjb;
//
//    @Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
//    protected TransactionSynchronizationRegistry transactionSynchronizationRegistry;
//
//    @Override
//    public void deleteFull(AnnexJPA annex) throws I18NException {
//        log.info("Comença deleteFull");
//
//        // Borram Annex a BD
//        delete(annex);
//
//        Long[] fitxers = new Long[] { annex.getFitxer1ID(), annex.getFitxer2ID() };
//
//        Set<Long> filesToDelete = new HashSet<Long>();
//
//        // Borram fitxers a BD
//        for (Long f : fitxers) {
//            if (f != null) {
//                fitxerEjb.delete(f);
//                filesToDelete.add(f);
//            }
//        }
//
//        tsRegistry.registerInterposedSynchronization(new PreCommitFiles(filesToDelete));
//
//        log.info("Final deleteFull");
//    }

};

//public class PreCommitFiles implements Synchronization {
//    public final Set<Long> files;
//
//    public PreCommitFiles(Set<Long> filesToDelete) {
//        this.files = filesToDelete;
//    }
//
//    @Override
//    public void beforeCompletion() {
//    }
//
//    @Override
//    public void afterCompletion(int status) {
//         if ( status == Status.STATUS_COMMITTED) {
//                  FileSystemManager.eliminarArxius(files);
//         }
//    }
//};

/**
 * @Stateless(name = "AnnexLogicaEJB") public class AnnexLogicaEJB extends
 *                 AnnexEJB implements AnnexLogicaService, AnnexFields {
 * 
 * 
 * @EJB(mappedName = FitxerService.JNDI_NAME) private FitxerService fitxerEjb;
 * 
 * @EJB(mappedName = es.caib.evidenciesib.ejb.AnnexFirmatService.JNDI_NAME) protected
 *                 es.caib.evidenciesib.ejb.AnnexFirmatServiceannexFirmatEjb;
 * 
 * 
 * @Override public AnnexJPA createFull(AnnexJPA annex) throws I18NException {
 *           // TODO Validar !!!
 * 
 *           return (AnnexJPA)create(annex); }
 * 
 * 
 * 
 * @Override public Set<Long> deleteFull(AnnexJPA annex) throws I18NException {
 * 
 *           Set<Long> files = new HashSet<Long>();
 * 
 *           if (annex == null) { return files; }
 * 
 *           // Annex delete(annex);
 * 
 *           return files; }
 * 
 *           }
 */
