package es.caib.evidenciesib.back.controller;

import es.caib.evidenciesib.persistence.FitxerJPA;
import es.caib.evidenciesib.model.entity.Fitxer;

import org.fundaciobit.genapp.common.filesystem.IFileManager;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;


/**
 * Gestiona Multiples Fitxers d'un Form
 * 
 * @author anadal
 * 
 */
public class EvidenciesIBFilesFormManager extends FilesFormManager<Fitxer> {

  public EvidenciesIBFilesFormManager(IFileManager<Fitxer> fitxerEjb) {
    super(fitxerEjb);
  }

  @Override
  public FitxerJPA createEmptyFile() {    
    return new FitxerJPA();
  }

}
