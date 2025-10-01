package es.caib.evidenciesib.logic.utils;

//import java.util.Locale;

import org.apache.log4j.Logger;
//import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.core.v3.utils.EncrypterDecrypter;

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

    public static String encryptEvidenciaID(long evidenciaID) throws Exception {
        String evidenciaIDString = Long.toString(evidenciaID);
        return EncrypterDecrypter.encrypt(EncrypterDecrypter.ALGORITHM_AES, Configuracio.getEncryptKey(),
                evidenciaIDString);
    }

    public static Long decryptEvidenciaID(String evidenciaIDEncrypted) throws Exception {
        if (evidenciaIDEncrypted == null) {
            return null;
        }
        String evidenciaIDDecrypted = EncrypterDecrypter.decrypt(EncrypterDecrypter.ALGORITHM_AES,
                Configuracio.getEncryptKey(), evidenciaIDEncrypted);
        return Long.valueOf(evidenciaIDDecrypted);
    }

}
