package es.caib.evidenciesib.model.entity;

public interface Evidencia extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getEvidenciaID();
	public void setEvidenciaID(long _evidenciaID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getPersonanom();
	public void setPersonanom(java.lang.String _personanom_);

	public java.lang.String getPersonallinatge1();
	public void setPersonallinatge1(java.lang.String _personallinatge1_);

	public java.lang.String getPersonallinatge2();
	public void setPersonallinatge2(java.lang.String _personallinatge2_);

	public java.lang.String getPersonanif();
	public void setPersonanif(java.lang.String _personanif_);

	public java.lang.String getDocumenthash();
	public void setDocumenthash(java.lang.String _documenthash_);

	public long getDocumentFitxerID();
	public void setDocumentFitxerID(long _documentFitxerID_);

	public long getDocumentmida();
	public void setDocumentmida(long _documentmida_);

	public java.sql.Timestamp getDatainici();
	public void setDatainici(java.sql.Timestamp _datainici_);

	public java.sql.Timestamp getDatafi();
	public void setDatafi(java.sql.Timestamp _datafi_);

	public java.lang.String getUsuariaplicacio();
	public void setUsuariaplicacio(java.lang.String _usuariaplicacio_);

	public java.lang.String getUsuaripersona();
	public void setUsuaripersona(java.lang.String _usuaripersona_);

	public int getEstatcodi();
	public void setEstatcodi(int _estatcodi_);

	public java.lang.String getEstaterror();
	public void setEstaterror(java.lang.String _estaterror_);

	public java.lang.String getEstatexcepcio();
	public void setEstatexcepcio(java.lang.String _estatexcepcio_);

	public java.lang.String getPersonamobil();
	public void setPersonamobil(java.lang.String _personamobil_);

	public int getLogintype();
	public void setLogintype(int _logintype_);

	public java.lang.String getLoginid();
	public void setLoginid(java.lang.String _loginid_);

	public java.sql.Timestamp getLogindata();
	public void setLogindata(java.sql.Timestamp _logindata_);

	public java.lang.String getLocalitzacioip();
	public void setLocalitzacioip(java.lang.String _localitzacioip_);

	public java.lang.String getLocalitzaciocodipostal();
	public void setLocalitzaciocodipostal(java.lang.String _localitzaciocodipostal_);

	public java.lang.String getLocalitzaciocoordenades();
	public void setLocalitzaciocoordenades(java.lang.String _localitzaciocoordenades_);

	public java.lang.String getPersonaemail();
	public void setPersonaemail(java.lang.String _personaemail_);

  // Fitxer
  public <F extends Fitxer> F getDocumentFitxer();


  // ======================================

}
