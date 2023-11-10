package es.caib.evidenciesib.model.entity;

public interface Evidencia extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEvidenciaID();
	public void setEvidenciaID(long _evidenciaID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getPersonaNif();
	public void setPersonaNif(java.lang.String _personaNif_);

	public java.lang.String getPersonaUsername();
	public void setPersonaUsername(java.lang.String _personaUsername_);

	public java.lang.String getPersonaNom();
	public void setPersonaNom(java.lang.String _personaNom_);

	public java.lang.String getPersonaLlinatge1();
	public void setPersonaLlinatge1(java.lang.String _personaLlinatge1_);

	public java.lang.String getPersonaLlinatge2();
	public void setPersonaLlinatge2(java.lang.String _personaLlinatge2_);

	public java.lang.String getPersonaEmail();
	public void setPersonaEmail(java.lang.String _personaEmail_);

	public java.lang.String getPersonaMobil();
	public void setPersonaMobil(java.lang.String _personaMobil_);

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

	public java.lang.String getLoginSubtype();
	public void setLoginSubtype(java.lang.String _loginSubtype_);

	public java.lang.String getLoginQaa();
	public void setLoginQaa(java.lang.String _loginQaa_);

	public java.sql.Timestamp getLoginData();
	public void setLoginData(java.sql.Timestamp _loginData_);

	public java.lang.String getLoginId();
	public void setLoginId(java.lang.String _loginId_);

	public java.lang.String getLoginAuthMethod();
	public void setLoginAuthMethod(java.lang.String _loginAuthMethod_);

	public java.lang.String getLoginAdditionalProperties();
	public void setLoginAdditionalProperties(java.lang.String _loginAdditionalProperties_);

	public java.lang.String getLocalitzacioIp();
	public void setLocalitzacioIp(java.lang.String _localitzacioIp_);

	public java.lang.String getLocalitzacioCodiPostal();
	public void setLocalitzacioCodiPostal(java.lang.String _localitzacioCodiPostal_);

	public java.lang.String getLocalitzacioLatitud();
	public void setLocalitzacioLatitud(java.lang.String _localitzacioLatitud_);

	public java.lang.String getLocalitzacioLongitud();
	public void setLocalitzacioLongitud(java.lang.String _localitzacioLongitud_);

	public java.lang.String getLocalitzacioRegio();
	public void setLocalitzacioRegio(java.lang.String _localitzacioRegio_);

	public java.lang.String getLocalitzacioCiutat();
	public void setLocalitzacioCiutat(java.lang.String _localitzacioCiutat_);

	public java.lang.String getLocalitzacioPais();
	public void setLocalitzacioPais(java.lang.String _localitzacioPais_);

	public java.lang.String getDeviceProperties();
	public void setDeviceProperties(java.lang.String _deviceProperties_);

	public java.lang.String getClickProperties();
	public void setClickProperties(java.lang.String _clickProperties_);

	public java.lang.String getFirmaReason();
	public void setFirmaReason(java.lang.String _firmaReason_);

	public java.lang.String getFirmaIdiomaDocument();
	public void setFirmaIdiomaDocument(java.lang.String _firmaIdiomaDocument_);

	public int getFirmaTipusDocumental();
	public void setFirmaTipusDocumental(int _firmaTipusDocumental_);

	public long getFitxerOriginalID();
	public void setFitxerOriginalID(long _fitxerOriginalID_);

	public java.lang.Long getFitxerAdaptatID();
	public void setFitxerAdaptatID(java.lang.Long _fitxerAdaptatID_);

	public java.lang.Long getFitxerSignatID();
	public void setFitxerSignatID(java.lang.Long _fitxerSignatID_);

	public java.lang.String getCallBackUrl();
	public void setCallBackUrl(java.lang.String _callBackUrl_);

  // Fitxer
  public <F extends Fitxer> F getFitxerOriginal();
  // Fitxer
  public <F extends Fitxer> F getFitxerAdaptat();
  // Fitxer
  public <F extends Fitxer> F getFitxerSignat();


  // ======================================

}
