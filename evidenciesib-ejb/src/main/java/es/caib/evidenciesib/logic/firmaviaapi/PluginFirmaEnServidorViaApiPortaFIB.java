package es.caib.evidenciesib.logic.firmaviaapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.fundaciobit.apisib.apifirmasimple.v1.ApiFirmaEnServidorSimple;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleCommonInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFile;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleFileInfoSignature;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignDocumentRequest;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignatureResult;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleSignedFileInfo;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleStatus;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleUpgradeRequest;
import org.fundaciobit.apisib.apifirmasimple.v1.beans.FirmaSimpleUpgradeResponse;
import org.fundaciobit.apisib.apifirmasimple.v1.jersey.ApiFirmaEnServidorSimpleJersey;
import org.fundaciobit.apisib.core.exceptions.AbstractApisIBException;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NException;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.FitxerLogicaService;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 11:43:29
 */
public class PluginFirmaEnServidorViaApiPortaFIB extends IPluginFirmaEnServidorViaApi {

    protected static final String PLUGIN_FIRMAVIAAPI_BASE = "apifirmaenservidor.";

    public PluginFirmaEnServidorViaApiPortaFIB() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PluginFirmaEnServidorViaApiPortaFIB(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
        // TODO Auto-generated constructor stub
    }

    public PluginFirmaEnServidorViaApiPortaFIB(String propertyKeyBase) {
        super(propertyKeyBase);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void valide() throws I18NException {
        // TODO Auto-generated method stub

    }

    @Override
    public void firmaEnServidor(FitxerLogicaService fitxerLogicaEjb, EvidenciaJPA evi, String idiomaUI,
            final String signID, final String name, final String reason, final String location, final int signNumber,
            final String languageSign, final long tipusDocumentalID, final String nif) throws I18NException {

        FirmaSimpleFile fileToSign;
        try {

            Fitxer fitxerOriginal = fitxerLogicaEjb.findByPrimaryKey(evi.getFitxerOriginalID());

            Fitxer fitxerAdaptat = fitxerLogicaEjb.findByPrimaryKey(evi.getFitxerAdaptatID());

            fileToSign = new FirmaSimpleFile(fitxerOriginal.getNom(), fitxerAdaptat.getMime(),
                    FileSystemManager.getFileContent(fitxerAdaptat.getFitxerID()));

        } catch (IOException e) {
            // 
            String msg = "Error llegint el fitxer a signar (fitxer original): " + e.getMessage();
            log.error(msg, e);
            throw new I18NException(e, "genapp.comodi", new I18NArgumentString(msg));
        }

        // Es la configuració del Servidor (deixam el valor per defecte)
        final String certificat = getPortafibApiFirmaEnServidorDefaultAliasCertificate();

        final String perfil = getPortafibApiFirmaEnServidorProfile();

        FirmaSimpleCommonInfo commonInfo;
        commonInfo = new FirmaSimpleCommonInfo(perfil, idiomaUI, certificat, nif, evi.getPersonaEmail());

        FirmaSimpleFileInfoSignature fileInfoSignature = new FirmaSimpleFileInfoSignature(fileToSign, signID, name,
                reason, location, signNumber, languageSign, tipusDocumentalID);

        FirmaSimpleSignDocumentRequest signature;
        signature = new FirmaSimpleSignDocumentRequest(commonInfo, fileInfoSignature);

        ApiFirmaEnServidorSimple api = new ApiFirmaEnServidorSimpleJersey(getPortafibApiFirmaEnServidorUrl(),
                getPortafibApiFirmaEnServidorUsername(), getPortafibApiFirmaEnServidorPassword());

        FirmaSimpleSignatureResult fullResults;
        try {
            fullResults = api.signDocument(signature);
        } catch (AbstractApisIBException e) {
            log.error("Error signant el fitxer: " + e.getMessage() + "(" + e.getDescription() + ")", e);
            // error.signant=Error signant el fitxer: {0}
            throw new I18NException("error.signant", e.getMessage() + " ( " + e.getDescription() + ")");
        }

        FirmaSimpleStatus transactionStatus = fullResults.getStatus();

        int status = transactionStatus.getStatus();

        switch (status) {

            case FirmaSimpleStatus.STATUS_INITIALIZING: // = 0;
            {
                log.error("L'estat del procés de firma ha tornat el control però encara està en estat INICIALITZANT");
                throw new I18NException("error.encarainicialitzant");
            }

            case FirmaSimpleStatus.STATUS_IN_PROGRESS: // = 1;
            {
                log.error("L'estat del procés de firma ha tornat el control però encara està en estat EN PROGRESS");
                throw new I18NException("error.encaraenproces");
            }

            case FirmaSimpleStatus.STATUS_FINAL_ERROR: // = -1;
            {
                log.error("Error durant la realització de les firmes: " + transactionStatus.getErrorMessage());
                String stack = transactionStatus.getErrorStackTrace();
                if (stack != null) {
                    evi.setEstatExcepcio(stack);
                    log.error(stack);
                }
                throw new I18NException("error.estatfinalerror", transactionStatus.getErrorMessage());
            }

            case FirmaSimpleStatus.STATUS_CANCELLED: // = -2;
            {
                log.warn("El procés de firma ha tornat el control amb estat CANCEL·LAT");
                throw new I18NException("error.procescancelat");
            }

            case FirmaSimpleStatus.STATUS_FINAL_OK: // = 2;
            {
                // Firma document
                FirmaSimpleFile signedFile = fullResults.getSignedFile();

                FirmaSimpleSignedFileInfo signedFileInfo = fullResults.getSignedFileInfo();
                log.info(FirmaSimpleSignedFileInfo.toString(signedFileInfo));

                String mime;
                byte[] data;

                // La normativa de Signatura no criptogràfica obliga a que el 
                // document signat  inclogui un Segell de Temps.
                // NOTA: El plugin de @firma a dia 30/01/2025 no permetia fer firmes PADES-T
                //       cosa que implicava que no duia segell de temps per això s'ha de fer l'upgrade.
                if (fullResults.getSignedFileInfo().isTimeStampIncluded()) {
                    data = signedFile.getData();
                    mime = signedFile.getMime();
                } else {
                    // Com que no duu segell de temps llavors hem 
                    // d'afegir Segell de Temps emprant l'upgrade de firma
                    FirmaSimpleFile fsf;
                    try {
                        final FirmaSimpleFile fileToUpgrade = signedFile;
                        final FirmaSimpleFile documentDetached = null;
                        FirmaSimpleUpgradeResponse upgradeResponse = api.upgradeSignature(
                                new FirmaSimpleUpgradeRequest(perfil, fileToUpgrade, documentDetached, null, idiomaUI));
                        FirmaSimpleFile upgraded = upgradeResponse.getUpgradedFile();
                        fsf = upgraded;
                    } catch (AbstractApisIBException e) {
                        String msg = "[ApiFirmaSimplePortaFIB] S'ha produït un error durant l'upgrade de la firma "
                                + "per afegir segell de temps: " + e.getMessage() + "(" + e.getDescription() + ")";
                        log.error(msg, e);
                        throw new I18NException(e, "genapp.comodi", msg);
                    }

                    if (fsf.getMime() == null) {
                        mime = signedFile.getMime();
                    } else {
                        mime = fsf.getMime();
                    }

                    data = fsf.getData();
                }

                String newname;
                newname = evi.getFitxerOriginal().getNom();
                newname = FilenameUtils.getBaseName(newname) + "_signed." + FilenameUtils.getExtension(newname);

                Fitxer fitxer = fitxerLogicaEjb.create(newname, mime, data.length, "");
                FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

                evi.setFitxerSignatID(fitxer.getFitxerID());

                evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT);

            } // Final Case Firma OK
            break;

            default: {
                log.error("L'estat del procés de firma ha tornat un estat desconegut amb valor " + status);
                throw new I18NException("error.estatfinaldesconeguti", String.valueOf(status));
            }
        } // Final Switch Firma
    }

    // ===========================================================
    // ===========================================================
    // ======   API FIRMA EN SERVIDOR - PORTAFIB  ================
    // ===========================================================
    // ===========================================================

    protected String getPortafibApiFirmaEnServidorUrl() throws I18NException {
        return getPropertyR(PLUGIN_FIRMAVIAAPI_BASE + "url");
    }

    protected String getPortafibApiFirmaEnServidorUsername() throws I18NException {
        return getPropertyR(PLUGIN_FIRMAVIAAPI_BASE + "username");
    }

    protected String getPortafibApiFirmaEnServidorPassword() throws I18NException {
        return getPropertyR(PLUGIN_FIRMAVIAAPI_BASE + "password");
    }

    protected String getPortafibApiFirmaEnServidorProfile() throws I18NException {
        return getPropertyR(PLUGIN_FIRMAVIAAPI_BASE + "profile");
    }

    protected String getPortafibApiFirmaEnServidorDefaultAliasCertificate() throws I18NException {
        return getPropertyR(PLUGIN_FIRMAVIAAPI_BASE + "defaultaliascertificate");
    }

}
