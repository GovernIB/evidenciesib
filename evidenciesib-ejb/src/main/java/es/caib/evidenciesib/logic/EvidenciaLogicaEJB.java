package es.caib.evidenciesib.logic;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.core.utils.ISO8601;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfBorderArray;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfWriter;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.commons.utils.StaticVersion;
import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.logic.utils.I18NLogicUtils;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.model.entity.Fitxer;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.persistence.FitxerJPA;

/**
 *
 * @author anadal
 *
 */
@Stateless
public class EvidenciaLogicaEJB extends EvidenciaEJB implements EvidenciaLogicaService {

    @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
    protected FitxerLogicaService fitxerLogicaEjb;

    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(Long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public EvidenciaJPA findByPrimaryKey(long _ID_) {
        return (EvidenciaJPA) super.findByPrimaryKey(_ID_);
    }

    @Override
    @PermitAll
    public Evidencia update(Evidencia instance) throws I18NException {
        return super.update(instance);
    }

    private EvidenciaJPA createEvidenciaAdaptedFile(EvidenciaJPA evi, Locale langUI, String url) throws I18NException {

        File dst_pdf = null;
        try {

            PdfReader reader = null;
            FileOutputStream fos = null;
            PdfStamper stamper = null;

            try {

                File src_pdf = FileSystemManager.getFile(evi.getFitxerOriginalID());

                dst_pdf = new File(FileSystemManager.getFilesPath(),
                        "Evidencia_Adaptat_EviID-" + evi.getEvidenciaID() + ".pdf");

                reader = new PdfReader(new FileInputStream(src_pdf));

                fos = new FileOutputStream(dst_pdf);

                stamper = new PdfStamper(reader, fos, '\0', true);
                PdfWriter writer = stamper.getWriter();

                generarAnnexJsonDeLesEvidencies(evi, reader, stamper, writer);

                afegirSegellAmbInformacioEvidencia(evi, reader, stamper, writer, url);

            } finally {

                if (stamper != null) {
                    try {
                        stamper.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (fos != null) {
                    try {
                        fos.flush();
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            // Cream fitxer Adaptat a la BBDD 
            FitxerJPA fitxer = new FitxerJPA();
            fitxer.setDescripcio("Fitxer PDF amb l'estampació i fitxer adjunt amb evidències");
            fitxer.setMime("application/pdf");
            fitxer.setNom(dst_pdf.getName());
            fitxer.setTamany(dst_pdf.length());

            fitxerLogicaEjb.create(fitxer);

            // Guardar fitxer adaptat en Disc Dur amb el ID de la BBDD
            // Copia de l'original a DEST
            FileSystemManager.crearFitxer(dst_pdf, fitxer.getFitxerID());

            evi.setFitxerAdaptatID(fitxer.getFitxerID());

            return evi;

        } catch (I18NException i18ne) {

            log.error("I18N Error creant fitxer adaptat d'evidències: " + I18NLogicUtils.getMessage(i18ne, langUI));

            if (dst_pdf != null && dst_pdf.exists()) {
                dst_pdf.delete();
            }

            throw i18ne;
        } catch (Exception e) {

            log.error("Error creant fitxer adaptat d'evidències: " + e.getMessage(), e);

            throw new I18NException("stamp.errorgeneratingfile", e.getMessage());
        } finally {

            if (dst_pdf != null && dst_pdf.exists()) {
                if (!dst_pdf.delete()) {
                    dst_pdf.deleteOnExit();
                }

            }
        }

    }

    /**
     * 
     * @param evi
     * @return
     * @throws I18NException
     */
    @PermitAll
    @Override
    public EvidenciaJPA createAdaptedFileAndSignDocument(EvidenciaJPA evi, String idiomaUI, String url) {

        Locale languageUI = new Locale(idiomaUI);

        FirmaSimpleFile fileToSign;
        try { // Global

            evi = this.createEvidenciaAdaptedFile(evi, languageUI, url);

            try {

                Fitxer fitxerOriginal = fitxerLogicaEjb.findByPrimaryKey(evi.getFitxerOriginalID());

                Fitxer fitxerAdaptat = fitxerLogicaEjb.findByPrimaryKey(evi.getFitxerAdaptatID());

                fileToSign = new FirmaSimpleFile(fitxerOriginal.getNom(), fitxerAdaptat.getMime(),
                        FileSystemManager.getFileContent(fitxerAdaptat.getFitxerID()));

            } catch (IOException e) {
                // TODO XYZ ZZZ
                String msg = "Error llegint el fitxer a signar (fitxer adaptat): " + e.getMessage();
                log.error(msg, e);
                throw new I18NException(e, "genapp.comodi", new I18NArgumentString(msg));
            }

            final String signID = "1";
            final String name = fileToSign.getNom();
            final String reason = evi.getFirmaReason();
            final String location = evi.getLocalitzacioCiutat();

            final int signNumber = 1;

            // XYZ ZZZ
            final String languageSign = evi.getFirmaIdiomaDocument();

            // XYZ ZZZ
            final long tipusDocumentalID = evi.getFirmaTipusDocumental(); // =TD99

            FirmaSimpleFileInfoSignature fileInfoSignature = new FirmaSimpleFileInfoSignature(fileToSign, signID, name,
                    reason, location, signNumber, languageSign, tipusDocumentalID);

            // Es la configuració del Servidor (deixam el valor per defecte)
            final String certificat = null;

            final String perfil = Configuracio.getApiFirmaEnServidorProfile();
            FirmaSimpleCommonInfo commonInfo;
            commonInfo = new FirmaSimpleCommonInfo(perfil, idiomaUI, certificat, evi.getPersonaNif(),
                    evi.getPersonaEmail());

            FirmaSimpleSignDocumentRequest signature;
            signature = new FirmaSimpleSignDocumentRequest(commonInfo, fileInfoSignature);

            ApiFirmaEnServidorSimple api = new ApiFirmaEnServidorSimpleJersey(Configuracio.getApiFirmaEnServidorUrl(),
                    Configuracio.getApiFirmaEnServidorUsername(), Configuracio.getApiFirmaEnServidorPassword());

            FirmaSimpleSignatureResult fullResults;
            try {
                fullResults = api.signDocument(signature);
            } catch (AbstractApisIBException e) {
                // TODO XYZ ZZZ
                String msg = "Error signant el fitxer: " + e.getMessage() + "(" + e.getDescription() + ")";
                throw new I18NException(e, "genapp.comodi", new I18NArgumentString(msg));
            }

            FirmaSimpleStatus transactionStatus = fullResults.getStatus();

            int status = transactionStatus.getStatus();

            switch (status) {

                case FirmaSimpleStatus.STATUS_INITIALIZING: // = 0;
                {
                    // TODO XYZ ZZZ
                    String msg = "L'estat del procés de firma ha tornat el control però encara està en estat INICIALITZANT";
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }

                case FirmaSimpleStatus.STATUS_IN_PROGRESS: // = 1;
                {
                    // TODO XYZ ZZZ
                    String msg = "L'estat del procés de firma ha tornat el control però encara està en estat EN PROGRESS";
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }

                case FirmaSimpleStatus.STATUS_FINAL_ERROR: // = -1;
                {
                    final String msg = "Error durant la realització de les firmes: "
                            + transactionStatus.getErrorMessage();
                    String stack = transactionStatus.getErrorStackTrace();
                    if (stack != null) {
                        evi.setEstatExcepcio(stack);
                    }
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }

                case FirmaSimpleStatus.STATUS_CANCELLED: // = -2;
                {
                    // TODO XYZ ZZZ
                    String msg = "El procés de firma ha tornat el control amb estat CANCEL·LAT";
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }

                case FirmaSimpleStatus.STATUS_FINAL_OK: // = 2;
                {

                    // Firma document

                    FirmaSimpleFile signedFile = fullResults.getSignedFile();

                    FirmaSimpleSignedFileInfo signedFileInfo = fullResults.getSignedFileInfo();
                    log.info(FirmaSimpleSignedFileInfo.toString(signedFileInfo));
                    
                    String mime = signedFile.getMime();

                    // Afegir Segell de Temps emprant l'upgrade de firma
                    FirmaSimpleFile fsf;
                    {

                        FirmaSimpleFile fileToUpgrade = signedFile;
                        FirmaSimpleFile documentDetached = null;
                        FirmaSimpleUpgradeResponse upgradeResponse = api.upgradeSignature(
                                new FirmaSimpleUpgradeRequest(perfil, fileToUpgrade, documentDetached, null, idiomaUI));

                        FirmaSimpleFile upgraded = upgradeResponse.getUpgradedFile();

                        fsf = upgraded;
                    }
                    
                    if (fsf.getMime() != null) {
                        mime = fsf.getMime();                    
                    }

                    // FirmaSimpleFile fsf = fullResults.getSignedFile();

                    byte[] data = fsf.getData();

                    String newname = evi.getFitxerOriginal().getNom();
                    newname = FilenameUtils.getBaseName(newname) + "_signed." + FilenameUtils.getExtension(newname);

                    Fitxer fitxer = fitxerLogicaEjb.create(newname, mime, data.length, "");
                    FileSystemManager.crearFitxer(new ByteArrayInputStream(data), fitxer.getFitxerID());

                    evi.setFitxerSignatID(fitxer.getFitxerID());

                    evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_SIGNAT);

                } // Final Case Firma OK
                break;

                default: {
                    // TODO XYZ ZZZ
                    String msg = "L'estat del procés de firma ha tornat un estat desconegut amb valor " + status;
                    throw new I18NException("genapp.comodi", new I18NArgumentString(msg));
                }
            } // Final Switch Firma

        } catch (I18NException th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = I18NCommonUtils.getMessage(th, languageUI);
            evi.setEstatError(StringUtils.abbreviate(msg, 4000)); // XYZ ZZZ TODO 
            if (evi.getEstatExcepcio() == null) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    log.error(msg, th);
                } else {
                    log.error(msg, cause);
                    evi.setEstatExcepcio(ExceptionUtils.getStackTrace(cause));
                }
            }

        } catch (Throwable th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = "Error no controllat signant document: " + th.getMessage();
            evi.setEstatError(StringUtils.abbreviate(msg, 4000));
            if (th.getCause() != null) {
                evi.setEstatExcepcio(ExceptionUtils.getStackTrace(th));
            }
            log.error(msg, th);

        } finally {
            evi.setDataFi(new Timestamp(System.currentTimeMillis()));

            // Check Error
            evi.setEstatError(StringUtils.abbreviate(evi.getEstatError(), 254));

            try {
                this.update(evi);
            } catch (I18NException e) {
                // TODO XYZ ZZZ
                String msg = "Error actualitzant l'evidència despres de signar el document: "
                        + I18NCommonUtils.getMessage(e, languageUI);
                log.error(msg, e);

            }
        }

        return evi;

    }

    /*
    protected static void createAdaptedFile()
            throws Exception {
        //PdfReader reader;
        
    
    //        reader = new PdfReader(new FileInputStream(src_pdf));
    //
    //        //Create PdfStamp object
    //        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(dst_pdf), '\0', true);
    //        PdfWriter writer = stamp.getWriter();
    
        //Create the proper annotation
        
    
    
        
    
        // NOTA el rectangle no rota
    
        
        
    //      System.out.println(page);
    //            System.out.println("Alt: " + page.getHeight() + "    | Ample + " + page.getWidth() );
    
        
        // Llegir PDF
        File original = FileSystemManager.getFile(evi.getFitxerOriginalID());
        File fileTmp1 = File.createTempFile("evidenciesib_generarfitxeradaptat_", ".pdf");
    
        FileOutputStream output1 = null;
        FileInputStream readerInputStream = null;
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
    
            // File input3 = null;
            readerInputStream = new FileInputStream(original);
            reader = new PdfReader(readerInputStream);
    
            output1 = new FileOutputStream(fileTmp1);
    
            stamper = new PdfStamper(reader, output1);
        
            
            // Afegeix ANOTACIO 
            
            
            
            // Afegir ATTACH amb informació
            
        
    
        try {
            
            
        
    } catch (DocumentException docex) {
        // TODO XYZ ZZZ
        String msg = "Error adaptant el PDF per afegir-hi annexes: " + docex.getMessage();
        log.error(msg, docex);
        throw new I18NException(docex, "genapp.comodi", new I18NArgumentString(msg));
    }
    
        
    
        String newname = evi.getFitxerOriginal().getNom();
        newname = FilenameUtils.getBaseName(newname) + "_adaptat." + FilenameUtils.getExtension(newname);
    
        Fitxer fitxerAdaptat = fitxerEjb.create(newname, evi.getFitxerOriginal().getMime(), fileTmp1.length(), "");
        FileSystemManager.crearFitxer(fileTmp1, fitxerAdaptat.getFitxerID());
    
        
        
    } catch(Exception e) {
        
        
    
    
    } finally {
    
        // 1.3.- Guardar PDF
        if (stamper != null) {
            stamper.close();
        }
    
        if (reader != null) {
            reader.close();
        }
    
        if (readerInputStream != null) {
            readerInputStream.close();
        }
    
        if (output1 != null) {
            output1.flush();
            output1.close();
        }
    
    }
    
    */

    /**
     * 
     * @param evi
     * @param reader
     * @param stamper
     * @param writer
     * @throws IOException
     * @throws I18NException
     * @throws DocumentException
     */
    protected void generarAnnexJsonDeLesEvidencies(Evidencia evi, PdfReader reader, PdfStamper stamper,
            PdfWriter writer) throws IOException, I18NException, DocumentException {

        // TODO XYZ Attach JSON  to PDF

        // 1. Modificar Contingut del PDF

        // 1.3.- Attach Files

        File fileEviJson = null;
        Map<String, Object> map = new TreeMap<String, Object>();
        try {
            String name = "evidencies.json";

            fileEviJson = File.createTempFile("evidenciesib_evidencies_", ".json");
            fileEviJson.deleteOnExit();

            map.put("EvidenciaID", evi.getEvidenciaID());

            map.put("person.name", evi.getPersonaNom());
            map.put("person.surname1", evi.getPersonaLlinatge1());
            map.put("person.surname2", evi.getPersonaLlinatge2());
            map.put("person.administrationid", evi.getPersonaNif());

            map.put("login.type", evi.getLoginType());
            map.put("login.subtype", evi.getLoginSubtype());
            map.put("login.id", evi.getLoginId());
            map.put("login.date", ISO8601.dateToISO8601(evi.getLoginData()));
            // DigestUtils.sha256Hex(evi.getLoginAdditionalProperties());
            map.put("login.properties.sha256", evi.getLoginPropertiesSha256());
            map.put("login.qaa", evi.getLoginQaa());

            String clickProperties = evi.getClickProperties();
            if (clickProperties != null && clickProperties.trim().length() != 0) {

                Properties prop = new Properties();
                prop.load(new StringReader(clickProperties));
                String datemsStr = prop.getProperty("date.ms");
                if (datemsStr != null) {
                    try {
                        long dateMs = Long.parseLong(datemsStr);
                        map.put("sign.intention.date", ISO8601.dateToISO8601(new Date(dateMs)));
                    } catch (Exception e) {
                        log.error("No s'ha pogut parsejar la data de la voluntat de firma: " + e.getMessage(), e);
                    }

                }
            }

            /*
            map.put("Nom", evi.getNom());
            map.put("PersonaNom", evi.getPersonaNom());
            map.put("PersonaLlinatge1", evi.getPersonaLlinatge1());
            map.put("PersonaLlinatge2", evi.getPersonaLlinatge2());
            map.put("PersonaNif", evi.getPersonaNif());
            map.put("PersonaUsername", evi.getPersonaUsername());
            map.put("PersonaEmail", evi.getPersonaEmail());
            map.put("PersonaMobil", evi.getPersonaMobil());
            map.put("DataInici", evi.getDataInici());
            map.put("DataFi", evi.getDataFi());
            map.put("UsuariAplicacio", evi.getUsuariAplicacio());
            map.put("UsuariPersona", evi.getUsuariPersona());
            map.put("LoginType", evi.getLoginType());
            map.put("LoginId", evi.getLoginId());
            map.put("LoginData", evi.getLoginData());
            map.put("LocalitzacioIp", evi.getLocalitzacioIp());
            map.put("LocalitzacioCodiPostal", evi.getLocalitzacioCodiPostal());
            map.put("LocalitzacioLongitud", evi.getLocalitzacioLongitud());
            map.put("LocalitzacioCiutat", evi.getLocalitzacioCiutat());
            map.put("LocalitzacioLatitud", evi.getLocalitzacioLatitud());
            map.put("LocalitzacioRegio", evi.getLocalitzacioRegio());
            map.put("LocalitzacioPais", evi.getLocalitzacioPais());
            map.put("FirmaReason", evi.getFirmaReason());
            map.put("FirmaTipusDocumental", evi.getFirmaTipusDocumental());
            map.put("FirmaIdiomaDocument", evi.getFirmaIdiomaDocument());
            map.put("FirmaTipusDocumental", evi.getFirmaTipusDocumental());
            map.put("FirmaIdiomaDocument", evi.getFirmaIdiomaDocument());
            */
            // Esborram tots els valors null !!!!
            while (map.values().remove(null))
                ;

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            org.apache.commons.io.FileUtils.write(fileEviJson, gson.toJson(map), StandardCharsets.UTF_8);

            PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(stamper.getWriter(),
                    fileEviJson.getAbsolutePath(), name, null);

            // TODO XYZ ZZZ Traduir
            writer.addFileAttachment("Evidències", fs);
        } finally {
            if (fileEviJson != null) {
                fileEviJson.delete();
            }
        }

        // Afegir versió d'EvidènciesIB
        Map<String, String> info = reader.getInfo();
        info.put("EvidenciesIB.versio", StaticVersion.VERSION);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            info.put("EvidenciesIB." + key, String.valueOf(val));
        }

        stamper.setMoreInfo(info);

    }

    /**
     * 
     * @param evi
     * @param reader
     * @param stamp
     * @param writer
     * @throws MalformedURLException
     */
    public static void afegirSegellAmbInformacioEvidencia(Evidencia evi, PdfReader reader, PdfStamper stamp,
            PdfWriter writer, String url) throws MalformedURLException {

        Locale loc = new java.util.Locale(evi.getFirmaIdiomaDocument());

        Rectangle page = reader.getPageSize(1);

        // "Informació de la Firma"
        String title = I18NCommonUtils.tradueix(loc, "stamp.info");

        String nompersona = evi.getPersonaNom() + " " + evi.getPersonaLlinatge1();
        if (evi.getPersonaLlinatge2() != null) {
            nompersona = nompersona + " " + evi.getPersonaLlinatge2();
        }

        // "Document signat per: Antoni Nadal Bennasar (" + "12345678Z)" + "\n"  + "Data: 07/09/2023 12:45:67\n";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Direcció Text:
        // 270 Cap abaix
        // 270 + 180 Cap a dalt
        final int rotate = 270 + 180;

        final int fontSize = 9;

        String content = I18NLogicUtils.tradueix(loc, "stamp.content", nompersona, evi.getPersonaNif(),
                sdf.format(evi.getDataInici()));
        content = " " + content.replace("\n", "\n ");

        final int margin_x = 8;
        final int margin_y = 100;

        int altCaixa = 25; //30;
        int ampleCaixa = 500; //400;
        BaseFont basefont;
        try {
            basefont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);

            String basetext = content.substring(0, content.indexOf('\n'));
            ampleCaixa = 20 + (int) basefont.getWidthPoint(basetext, fontSize);
            altCaixa = margin_x + (int) (2f * basefont.getAscentPoint(basetext, fontSize)
                    - 2f * basefont.getDescentPoint(basetext, fontSize));

        } catch (Throwable e1) {
            basefont = null;
            e1.printStackTrace();
        }

        Rectangle r = new Rectangle(margin_x, page.getTop() - ampleCaixa - margin_y, margin_x + altCaixa,
                page.getTop() - margin_y);

        {

            PdfAnnotation annot = new PdfAnnotation(stamp.getWriter(), r);
            annot.put(PdfName.SUBTYPE, PdfName.FREETEXT);
            annot.put(PdfName.CONTENTS, new PdfString(content, PdfObject.TEXT_UNICODE));

            PdfAppearance pcb = PdfAppearance.createAppearance(writer, r.getWidth(), r.getHeight());

            pcb.setFontAndSize(basefont, fontSize);

            annot.setDefaultAppearanceString(pcb);

            annot.setFlags(PdfAnnotation.FLAGS_PRINT | PdfAnnotation.FLAGS_READONLY);

            annot.setBorder(new PdfBorderArray(1, 1, 1f));

            annot.setRotate(rotate);

            annot.setTitle(title);

            //Insert the annotation         
            stamp.addAnnotation(annot, 1);
        }

        PdfAction action = new PdfAction(new URL(url));
        {
            PdfAnnotation annotLink1;
            annotLink1 = new PdfAnnotation(writer, r.getLeft(), r.getBottom(), r.getRight(), r.getTop(), action);
            //annot2.put(PdfName.NAME, new PdfName(name));
            stamp.addAnnotation(annotLink1, 1);
        }
    }

    /**
     * 
     * @param pdf
     * @throws I18NException
     */
    @RolesAllowed({ Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS })
    @Override
    public void validatePdfForEvidencies(byte[] pdf) throws I18NException {
        try {
            PdfReader reader = new PdfReader(pdf);
            AcroFields fields = reader.getAcroFields();
            if (fields.getSignatureNames().size() != 0) {
                throw new I18NException("error.validate.pdf.withsignatures");
            }

        } catch (I18NException i18ne) {
            throw i18ne;
        } catch (Throwable e) {

            log.error("Error desconegut intentant obtenir numero de firmes d'un PDF: " + e.getMessage(), e);

            throw new I18NException("error.validate.pdf.unknown", e.getMessage());
        }
    }

}
