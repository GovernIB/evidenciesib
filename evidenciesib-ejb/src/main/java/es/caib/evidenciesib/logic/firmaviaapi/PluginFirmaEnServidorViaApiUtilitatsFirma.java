package es.caib.evidenciesib.logic.firmaviaapi;

import java.io.File;
import java.sql.Timestamp;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.FitxerLogicaService;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.api.UtilitatsFirmaV2Api;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.CommonInfo;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.FileInfoSignature;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.MultipartNameAndMime;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.ProcessStatus;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.RestExceptionInfo;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignDocumentRequest;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignedDocumentInformation;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignedDocumentResponseMultipart;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.SignedFileInfo;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.StatusConstants;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.model.UpgradeResponseMultipart;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.services.ApiException;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.services.Configuration;
import es.caib.utilitatsfirma.api.interna.client.utilitatsfirma.v2.servicesforutilitatsfirma.ApiClientWithJsonSupport;

/**
 * 
 * @author anadal (u80067)
 * 27 may 2026 12:05:32
 */
public class PluginFirmaEnServidorViaApiUtilitatsFirma extends IPluginFirmaEnServidorViaApi {

    protected static final String PLUGIN_UTILITATSFIRMA_BASE = "utilitatsfirma.";

    public PluginFirmaEnServidorViaApiUtilitatsFirma() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PluginFirmaEnServidorViaApiUtilitatsFirma(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
        // TODO Auto-generated constructor stub
    }

    public PluginFirmaEnServidorViaApiUtilitatsFirma(String propertyKeyBase) {
        super(propertyKeyBase);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void valide() throws I18NException {
        // TODO Auto-generated method stub

    }

    @Override
    public void firmaEnServidor(FitxerLogicaService fitxerLogicaEjb, EvidenciaJPA evi, String idiomaUI, String signID,
            String name, String reason, String location, int signNumber, String languageSign, long tipusDocumentalID,
            String nif) throws I18NException {
        // TODO Auto-generated method stub

        // Es la configuració del Servidor (deixam el valor per defecte)
        final String certificat = getUtilitatsFirmaApiV2DefaultAliasCertificate();

        final String perfil = getUtilitatsFirmaApiV2Profile();

        // (perfil, idiomaUI, certificat, nif, evi.getPersonaEmail());
        CommonInfo commonInfo;
        commonInfo = new CommonInfo().signProfile(perfil).languageUI(idiomaUI).username(certificat)
                .administrationID(nif).signerEmail(evi.getPersonaEmail());

        // fileToSign, signID, name,   reason, location, signNumber, languageSign, tipusDocumentalID
        FileInfoSignature fileInfoSignature = new FileInfoSignature().signID(signID).name(name).reason(reason)
                .location(location).signNumber(signNumber).languageSign(languageSign).documentType(tipusDocumentalID);

        fileInfoSignature.setUseTimeStamp(getUseTimestamp());

        SignDocumentRequest signature;
        signature = new SignDocumentRequest().commonInfo(commonInfo).fileInfoSignature(fileInfoSignature);

        ApiClientWithJsonSupport client = new ApiClientWithJsonSupport();
        client.setBasePath(getUtilitatsFirmaApiV2Url());
        client.setUsername(getUtilitatsFirmaApiV2Username());
        client.setPassword(getUtilitatsFirmaApiV2Password());

        client.setDebugging(true);

        client.addDefaultHeader("Accept-Language", idiomaUI);

        UtilitatsFirmaV2Api api = new UtilitatsFirmaV2Api(client);

        SignedDocumentResponseMultipart fullResults;

        Fitxer fitxerAdaptat = fitxerLogicaEjb.findByPrimaryKey(evi.getFitxerAdaptatID());

        File file = FileSystemManager.getFile(fitxerAdaptat.getFitxerID());

        try {
            fullResults = api.signdocument(signature, file, null);
        } catch (ApiException e) {

            log.error("Error signant el fitxer emprant API : " + e.getMessage() + "(" + e.getCode() + ")", e);

            log.error(" ResponseBody: \n\n" + e.getResponseBody() + "\n\n");

            // error.signant=Error signant el fitxer: {0}
            throw new I18NException(e, "error.signant", processMessageErrorFromApiException(e));
        }

        SignedDocumentInformation info = fullResults.getSignedDocumentInformation();

        ProcessStatus transactionStatus = info.getStatus();

        int status = transactionStatus.getStatus();

        StatusConstants statusEnum = StatusConstants.fromValue(status);

        switch (statusEnum) {

            case STATUS_INITIALIZING: // = 0;
            {
                log.error("L'estat del procés de firma ha tornat el control però encara està en estat INICIALITZANT");
                throw new I18NException("error.encarainicialitzant");
            }

            case STATUS_IN_PROGRESS: // = 1;
            {
                log.error("L'estat del procés de firma ha tornat el control però encara està en estat EN PROGRESS");
                throw new I18NException("error.encaraenproces");
            }

            case STATUS_FINAL_ERROR: // = -1;
            {
                log.error("Error durant la realització de les firmes: " + transactionStatus.getErrorMessage());
                String stack = transactionStatus.getErrorStackTrace();
                if (stack != null) {
                    evi.setEstatExcepcio(stack);
                    log.error(stack);
                }
                throw new I18NException("error.estatfinalerror", transactionStatus.getErrorMessage());
            }

            case STATUS_CANCELLED: // = -2;
            {
                log.warn("El procés de firma ha tornat el control amb estat CANCEL·LAT");
                throw new I18NException("error.procescancelat");
            }

            case STATUS_FINAL_OK: // = 2;
            {
                // Firma document

                SignedFileInfo signedFileInfo = info.getSignedFileInfo();

                MultipartNameAndMime signedFilePartInfo = fullResults.getSignedFilePartInfo();
                String mime = signedFilePartInfo.getContentType();

                File data = fullResults.getSignedFile();

                // La normativa de Signatura no criptogràfica obliga a que el 
                // document signat  inclogui un Segell de Temps.
                // NOTA: El plugin de @firma a dia 30/01/2025 no permetia fer firmes PADES-T
                //       cosa que implicava que no duia segell de temps per això s'ha de fer l'upgrade.
                if (!Boolean.TRUE.equals(signedFileInfo.getTimeStampIncluded())) {

                    // Com que no duu segell de temps llavors hem 
                    // d'afegir Segell de Temps emprant l'upgrade de firma

                    final File signature2 = data;
                    final File detachedDocument = null;
                    final File targetCertificate = null;

                    UpgradeResponseMultipart upgradeResponse;
                    try {
                        upgradeResponse = api.upgradeSignature(idiomaUI, perfil, signature2, detachedDocument,
                                targetCertificate);
                    } catch (ApiException e) {
                        String msg = "[UtilitatsFirmaApiV2] S'ha produït un error durant l'upgrade de la firma per"
                                + " afegir segell de temps: " + processMessageErrorFromApiException(e);
                        log.error(msg, e);
                        throw new I18NException(e, "genapp.comodi", msg);
                    }
                    File upgraded = upgradeResponse.getUpgradedFile();

                    File oldData = data;

                    data = upgraded;

                    if (!oldData.delete()) {
                        oldData.deleteOnExit();
                    }
                }

                String newname;
                newname = evi.getFitxerOriginal().getNom();
                newname = FilenameUtils.getBaseName(newname) + "_signed." + FilenameUtils.getExtension(newname);

                Fitxer fitxer = fitxerLogicaEjb.create(newname, mime, data.length(), "");
                FileSystemManager.crearFitxer(data, fitxer.getFitxerID());

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
    // ======   API FIRMA EN SERVIDOR - UTILITATSFIRMA  ==========
    // ===========================================================
    // ===========================================================

    public String getUtilitatsFirmaApiV2Url() throws I18NException {
        return getPropertyR(PLUGIN_UTILITATSFIRMA_BASE + "url");
    }

    public String getUtilitatsFirmaApiV2Username() throws I18NException {
        return getPropertyR(PLUGIN_UTILITATSFIRMA_BASE + "username");
    }

    public String getUtilitatsFirmaApiV2Password() throws I18NException {
        return getPropertyR(PLUGIN_UTILITATSFIRMA_BASE + "password");
    }

    public String getUtilitatsFirmaApiV2Profile() throws I18NException {
        return getPropertyR(PLUGIN_UTILITATSFIRMA_BASE + "profile");
    }

    public String getUtilitatsFirmaApiV2DefaultAliasCertificate() throws I18NException {
        return getPropertyR(PLUGIN_UTILITATSFIRMA_BASE + "defaultaliascertificate");
    }

    public Boolean getUseTimestamp() {

        String useTimestampStr = getProperty(PLUGIN_UTILITATSFIRMA_BASE + "usetimestamp");

        if (useTimestampStr == null || useTimestampStr.trim().isEmpty()) {
            return null; // Retornam null per indicar que s'ha de fer servir el valor per defecte del plugin de firma
        } else {
            return Boolean.parseBoolean(useTimestampStr.trim());
        }

    }

    protected String processMessageErrorFromApiException(ApiException e) {
        int status = e.getCode();

        if (status == 400 || status == 401 || status == 403 || status == 500) {
            try {
                ObjectMapper objectMapper;
                objectMapper = Configuration.getDefaultApiClient().getJSON().getContext(null);
                RestExceptionInfo rei;
                rei = objectMapper.readValue(e.getMessage(), RestExceptionInfo.class);

                String error = rei.getErrorMessage();
                if (error != null && !error.trim().isEmpty()) {

                    error = rei.getErrorMessage() + " (HTTP Error Code: " + e.getCode();

                    if (rei.getErrorCode() != null) {
                        error = error + " | ErrorCode: " + rei.getErrorCode();
                    }

                    if (rei.getField() != null && !rei.getField().trim().isEmpty()) {
                        error = error + " | Field: " + rei.getField();
                    }
                    error = error + ").";

                    if (rei.getStackTrace() != null || rei.getStackTraceCause() != null) {
                        error = error + " Veure logs per obtenir més detalls de l'error ("
                                + new Timestamp(System.currentTimeMillis()) + ").";
                        log.error("    - RestExceptionInfo:" + "\n          + errorCode: " + rei.getErrorCode()
                                + "\n          + errorMessage: " + rei.getErrorMessage() + "\n          + stackTrace: "
                                + rei.getStackTrace() + "\n          + stackTraceCause: " + rei.getStackTraceCause()
                                + "\n          + field: " + rei.getField());
                    }

                    return error;
                }

            } catch (Throwable e1) {
                //e1.printStackTrace();
                // No es un objecte RestExceptionInfo
                log.error("    - Message: Error no controlat: " + e.getMessage());

                log.error("\n    ----------------- IMPORTANT ----------------\n"
                        + "    El body del missatge HTTP hauria de contenir\n"
                        + "    un objecte RestExceptionInfo representat en\n"
                        + "    format JSON però en el seu lloc conté:\n" + e.getMessage() + "\n"
                        + "    ---------------------------------------------\n");
            }
        } else {
            log.error("    - Code: " + status + " (" + StatusConstants.fromValue(e.getCode()).name() + ")");
            log.error("    - Message: Error no controlat. Error: " + e.getMessage());
        }

        return e.getMessage();
    }

}
