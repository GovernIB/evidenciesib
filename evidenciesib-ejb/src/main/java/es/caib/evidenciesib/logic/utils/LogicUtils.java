package es.caib.evidenciesib.logic.utils;

import javax.crypto.IllegalBlockSizeException;

//import java.util.Locale;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
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

    public static Long decryptEvidenciaID(String evidenciaIDEncrypted) throws I18NException {
        if (evidenciaIDEncrypted == null) {
            return null;
        }
        try {

            String evidenciaIDDecrypted = EncrypterDecrypter.decrypt(EncrypterDecrypter.ALGORITHM_AES,
                    Configuracio.getEncryptKey(), evidenciaIDEncrypted);
            return Long.valueOf(evidenciaIDDecrypted);

        } catch (IllegalBlockSizeException ibse) {
            log.error("Error al desencriptar amb evidenciaIDEncrypted incorrecte: " + ibse.getMessage(), ibse);
            throw new I18NException(ibse, "error.desencriptar.blocksize");
        } catch (Throwable e) {
            log.error("Error no controlat al desencriptar evidenciaIDEncrypted: " + e.getMessage(), e);
            throw new I18NException(e, "error.desencriptar.unkonwn", e.getMessage());

        }
    }

}
