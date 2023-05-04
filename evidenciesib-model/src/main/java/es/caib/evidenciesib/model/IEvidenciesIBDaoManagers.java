package es.caib.evidenciesib.model;

import es.caib.evidenciesib.model.dao.*;

public interface IEvidenciesIBDaoManagers {
	public IEvidenciaManager getEvidenciaManager();
	public IFitxerManager getFitxerManager();
	public IIdiomaManager getIdiomaManager();
	public IPluginManager getPluginManager();
	public ITraduccioManager getTraduccioManager();

}