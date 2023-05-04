package es.caib.evidenciesib.logic.utils;

//import java.util.Locale;

import org.apache.log4j.Logger;
//import org.fundaciobit.genapp.common.i18n.I18NException;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.StaticVersion;

/**
 * 
 * @author anadal
 *
 */
public class LogicUtils {

	protected static Logger log = Logger.getLogger(LogicUtils.class);

	public static String getVersio() {
		return StaticVersion.VERSION + (Configuracio.isCAIB() ? "-caib" : "");
	}

}
