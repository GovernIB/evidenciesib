package es.caib.evidenciesib.model.entity;

public interface Evidencia extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEvidenciaID();
	public void setEvidenciaID(long _evidenciaID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getPersonaNom();
	public void setPersonaNom(java.lang.String _personaNom_);

	public java.lang.String getPersonaLlinatge1();
	public void setPersonaLlinatge1(java.lang.String _personaLlinatge1_);

	public java.lang.String getPersonaLlinatge2();
	public void setPersonaLlinatge2(java.lang.String _personaLlinatge2_);

	public java.lang.String getPersonaNif();
	public void setPersonaNif(java.lang.String _personaNif_);

	public java.lang.String getPersonaEmail();
	public void setPersonaEmail(java.lang.String _personaEmail_);

	public java.lang.String getPersonaMobil();
	public void setPersonaMobil(java.lang.String _personaMobil_);

	public java.lang.String getDocumentHash();
	public void setDocumentHash(java.lang.String _documentHash_);

	public long getDocumentFitxerID();
	public void setDocumentFitxerID(long _documentFitxerID_);

	public long getDocumentMida();
	public void setDocumentMida(long _documentMida_);

	public java.sql.Timestamp getDataInici();
	public void setDataInici(java.sql.Timestamp _dataInici_);

	public java.sql.Timestamp getDataFi();
	public void setDataFi(java.sql.Timestamp _dataFi_);

	public java.lang.String getUsuariAplicacio();
	public void setUsuariAplicacio(java.lang.String _usuariAplicacio_);

	public java.lang.String getUsuariPersona();
	public void setUsuariPersona(java.lang.String _usuariPersona_);

	public int getEstatCodi();
	public void setEstatCodi(int _estatCodi_);

	public java.lang.String getEstatError();
	public void setEstatError(java.lang.String _estatError_);

	public java.lang.String getEstatExcepcio();
	public void setEstatExcepcio(java.lang.String _estatExcepcio_);

	public int getLoginType();
	public void setLoginType(int _loginType_);

	public java.lang.String getLoginId();
	public void setLoginId(java.lang.String _loginId_);

	public java.sql.Timestamp getLoginData();
	public void setLoginData(java.sql.Timestamp _loginData_);

	public java.lang.String getLocalitzacioIp();
	public void setLocalitzacioIp(java.lang.String _localitzacioIp_);

	public java.lang.String getLocalitzacioCodiPostal();
	public void setLocalitzacioCodiPostal(java.lang.String _localitzacioCodiPostal_);

	public java.lang.String getLocalitzacioLongitud();
	public void setLocalitzacioLongitud(java.lang.String _localitzacioLongitud_);

	public java.lang.String getLocalitzacioLatitud();
	public void setLocalitzacioLatitud(java.lang.String _localitzacioLatitud_);

	public java.lang.String getLocalitzacioCiutat();
	public void setLocalitzacioCiutat(java.lang.String _localitzacioCiutat_);

	public java.lang.String getLocalitzacioRegio();
	public void setLocalitzacioRegio(java.lang.String _localitzacioRegio_);

	public java.lang.String getLocalitzacioPais();
	public void setLocalitzacioPais(java.lang.String _localitzacioPais_);

  // Fitxer
  public <F extends Fitxer> F getDocumentFitxer();


  // ======================================

}
