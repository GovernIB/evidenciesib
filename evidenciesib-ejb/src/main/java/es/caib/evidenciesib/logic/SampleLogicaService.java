package es.caib.evidenciesib.logic;

import java.util.Map;

//import java.util.Set;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

/*
import es.caib.evidenciesib.ejb.AnnexService;
import es.caib.evidenciesib.persistence.AnnexJPA;
*/

/**
 * 
 * @author anadal
 *
 */
@Local
public interface SampleLogicaService /* extends AnnexService */ {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/SampleLogicaEJB!es.caib.evidenciesib.logic.SampleLogicaService";
    
    public Map<String, Long> getTableSizes() throws I18NException;
/*
    public void deleteFull(AnnexJPA annex) throws I18NException;

    
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}
