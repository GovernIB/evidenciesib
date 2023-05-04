package es.caib.evidenciesib.model.entity;

public interface Plugin extends org.fundaciobit.genapp.common.IGenAppEntity {

	public long getPluginID();
	public void setPluginID(long _pluginID_);

	public java.lang.String getNom();
	public void setNom(java.lang.String _nom_);

	public java.lang.String getDescripcio();
	public void setDescripcio(java.lang.String _descripcio_);

	public java.lang.String getClasse();
	public void setClasse(java.lang.String _classe_);

	public int getTipus();
	public void setTipus(int _tipus_);

	public java.lang.String getPropietats();
	public void setPropietats(java.lang.String _propietats_);

	public boolean isActiu();
	public void setActiu(boolean _actiu_);



  // ======================================

}
