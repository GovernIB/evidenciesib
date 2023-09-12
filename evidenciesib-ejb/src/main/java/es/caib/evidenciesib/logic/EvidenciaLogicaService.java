package es.caib.evidenciesib.logic;

import javax.ejb.Local;

import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Local
public interface EvidenciaLogicaService extends es.caib.evidenciesib.ejb.EvidenciaService {

    public static final String JNDI_NAME = "java:app/evidenciesib-ejb/EvidenciaLogicaEJB!es.caib.evidenciesib.logic.EvidenciaLogicaService";


    @Override
    public EvidenciaJPA findByPrimaryKey(Long _ID_);

    @Override
    public EvidenciaJPA findByPrimaryKey(long _ID_);

    
    @Override
    public Evidencia update(Evidencia instance) throws I18NException;
    
    /**
     * 
     * @param evi
     * @param languageUI
     * @return
     */
    public EvidenciaJPA createAdaptedFileAndSignDocument(EvidenciaJPA evi,  String languageUI, String url);
    
    
    public void validatePdfForEvidencies(byte[] pdf) throws I18NException;
    
}
