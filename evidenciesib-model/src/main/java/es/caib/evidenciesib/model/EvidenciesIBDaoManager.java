package es.caib.evidenciesib.model;

public class EvidenciesIBDaoManager {
  
  private static IEvidenciesIBDaoManagers instance = null;
  
  public static void setDaoManagers(IEvidenciesIBDaoManagers managers) {
    instance = managers;
  }
  
  public static IEvidenciesIBDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode EvidenciesIBDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}
