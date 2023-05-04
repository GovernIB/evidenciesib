package es.caib.evidenciesib.persistence;

import es.caib.evidenciesib.model.*;
import es.caib.evidenciesib.model.dao.*;
import javax.persistence.EntityManager;

public final class EvidenciesIBJPADaoManagers implements IEvidenciesIBDaoManagers{

   private final EvidenciaJPAManager evi_evidencia;
   private final FitxerJPAManager evi_fitxer;
   private final IdiomaJPAManager evi_idioma;
   private final PluginJPAManager evi_plugin;
   private final TraduccioJPAManager evi_traduccio;

  public  EvidenciesIBJPADaoManagers(EntityManager __em) {
    this.evi_evidencia = new EvidenciaJPAManager(__em);
    this.evi_fitxer = new FitxerJPAManager(__em);
    this.evi_idioma = new IdiomaJPAManager(__em);
    this.evi_plugin = new PluginJPAManager(__em);
    this.evi_traduccio = new TraduccioJPAManager(__em);
  }

    public IEvidenciaManager getEvidenciaManager() {
        return this.evi_evidencia;
    };

    public IFitxerManager getFitxerManager() {
        return this.evi_fitxer;
    };

    public IIdiomaManager getIdiomaManager() {
        return this.evi_idioma;
    };

    public IPluginManager getPluginManager() {
        return this.evi_plugin;
    };

    public ITraduccioManager getTraduccioManager() {
        return this.evi_traduccio;
    };


}