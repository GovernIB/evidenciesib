package es.caib.evidenciesib.logic.scheduler;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.UpdateItemValue;
import org.fundaciobit.genapp.common.query.Where;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.EvidenciaLogicaService;
import es.caib.evidenciesib.model.fields.EvidenciaFields;

/**
 * 
 * @author anadal (u80067)
 * 31 jul 2026 9:37:11
 */
@Singleton
@Startup
public class TancadorDePeticionsObertesScheduler extends AbstractScheduler {

    @EJB(mappedName = EvidenciaLogicaService.JNDI_NAME)
    protected EvidenciaLogicaService evidenciaLogicaEjb;

    @Override
    public String getSchedulerName() {
        return "TancadorDePeticionsObertesScheduler";
    }

    /**
     * 
     * @return Si val null significa que no s'ha d'executar
     */
    @Override
    public String getCronExpression() {
        // Valor per defecte = cada dia a les 5:00 
        // Seconds - Minutes - Hourly - Daily - Weekly - Monthly - Yearly
        String cron = null; //PropietatGlobalUtil.getTancadorDePeticionsObertesCronExpression();
        if (cron == null || cron.trim().length() == 0) {
            cron = "0 0 5 * * ? *";
        }
        return cron;
    }

    @Override
    public void executeTask(ControlOfExecution coe) {
        try {

            Integer dies = 1; //PropietatGlobalUtil.getTancadorDePeticionsObertesDies();
            if (dies != null && dies.intValue() > 0) {

                evidenciaLogicaEjb.tancarPeticionsObertes(dies);

                //
            } else {
                log.info(
                        "TancadorDePeticionsObertesScheduler: No s'ha definit el nombre de dies per netejar les peticions.");
            }

        } catch (Throwable e) {
            log.error("Error en TancadorDePeticionsObertesScheduler: " + e.getMessage(), e);
        }
    }

   
}
