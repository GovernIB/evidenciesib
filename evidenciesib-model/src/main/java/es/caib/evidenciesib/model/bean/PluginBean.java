
package es.caib.evidenciesib.model.bean;

import es.caib.evidenciesib.model.entity.Plugin;


public class PluginBean implements Plugin {



	long pluginID;// PK
	java.lang.String nom;
	java.lang.String descripcio;
	java.lang.String classe;
	int tipus;
	java.lang.String propietats;
	boolean actiu;


  /** Constructor Buit */
  public PluginBean() {
  }

  /** Constructor amb tots els camps  */
  public PluginBean(long pluginID , java.lang.String nom , java.lang.String descripcio , java.lang.String classe , int tipus , java.lang.String propietats , boolean actiu) {
    this.pluginID=pluginID;
    this.nom=nom;
    this.descripcio=descripcio;
    this.classe=classe;
    this.tipus=tipus;
    this.propietats=propietats;
    this.actiu=actiu;
}
  /** Constructor sense valors autoincrementals */
  public PluginBean(java.lang.String nom , java.lang.String descripcio , java.lang.String classe , int tipus , java.lang.String propietats , boolean actiu) {
    this.nom=nom;
    this.descripcio=descripcio;
    this.classe=classe;
    this.tipus=tipus;
    this.propietats=propietats;
    this.actiu=actiu;
}
  public PluginBean(Plugin __bean) {
    this.setPluginID(__bean.getPluginID());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setClasse(__bean.getClasse());
    this.setTipus(__bean.getTipus());
    this.setPropietats(__bean.getPropietats());
    this.setActiu(__bean.isActiu());
	}

	public long getPluginID() {
		return(pluginID);
	};
	public void setPluginID(long _pluginID_) {
		this.pluginID = _pluginID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.String getClasse() {
		return(classe);
	};
	public void setClasse(java.lang.String _classe_) {
		this.classe = _classe_;
	};

	public int getTipus() {
		return(tipus);
	};
	public void setTipus(int _tipus_) {
		this.tipus = _tipus_;
	};

	public java.lang.String getPropietats() {
		return(propietats);
	};
	public void setPropietats(java.lang.String _propietats_) {
		this.propietats = _propietats_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};



  // ======================================

  public static PluginBean toBean(Plugin __bean) {
    if (__bean == null) { return null;}
    PluginBean __tmp = new PluginBean();
    __tmp.setPluginID(__bean.getPluginID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setClasse(__bean.getClasse());
    __tmp.setTipus(__bean.getTipus());
    __tmp.setPropietats(__bean.getPropietats());
    __tmp.setActiu(__bean.isActiu());
		return __tmp;
	}



}
