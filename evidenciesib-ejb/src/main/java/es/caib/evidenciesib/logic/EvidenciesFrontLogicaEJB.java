package es.caib.evidenciesib.logic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NArgumentString;
import org.fundaciobit.genapp.common.i18n.I18NCommonUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.pluginsib.core.v3.utils.ISO8601;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.commons.utils.StaticVersion;
import es.caib.evidenciesib.ejb.EvidenciaEJB;
import es.caib.evidenciesib.logic.firmaviaapi.IPluginFirmaEnServidorViaApi;
import es.caib.evidenciesib.logic.utils.I18NLogicUtils;
import es.caib.evidenciesib.logic.utils.LogicUtils;
import es.caib.evidenciesib.model.entity.Evidencia;
import es.caib.evidenciesib.persistence.EvidenciaJPA;
import es.caib.evidenciesib.persistence.FitxerJPA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
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

/**
 *
 * @author anadal
 *
 */
@Stateless
public class EvidenciesFrontLogicaEJB extends EvidenciaEJB implements EvidenciesFrontLogicaService {
    
    @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
    protected FitxerLogicaService fitxerLogicaEjb;
    

    
    @EJB(mappedName = PluginFirmaEnServidorViaApiLogicaService.JNDI_NAME)
    protected PluginFirmaEnServidorViaApiLogicaService pluginFirmaEnServidorViaApiLogicaEJB;

    @PermitAll
    @Override
    public EvidenciaJPA findByPrimaryKey(Long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

    @PermitAll
    @Override
    public Evidencia findByPrimaryKey(long _ID_) {
        return super.findByPrimaryKey(_ID_);
    }

    @PermitAll
    @Override
    public Long count(Where w) throws I18NException {
        return super.count(w);
    }

    @PermitAll
    @Override
    public Evidencia update(Evidencia evi) throws I18NException {
        return super.update(evi);
    }
    
    
    

    /**
     * 
     * @param evi
     * @return
     * @throws I18NException
     */
    @PermitAll
    @Override
    public EvidenciaJPA createAdaptedFileAndSignDocument(EvidenciaJPA evi, String idiomaUI) {

        Locale languageUI = new Locale(idiomaUI);

        try { // Global

            evi = this.createEvidenciaAdaptedFile(evi, languageUI);

            final String signID = "1";
            final String name = evi.getNom();
            final String reason = evi.getFirmaReason();
            final String location = evi.getLocalitzacioCiutat();

            final int signNumber = 1;

            final String languageSign = evi.getFirmaIdiomaDocument();
            final long tipusDocumentalID = evi.getFirmaTipusDocumental(); // =TD99

            // En firmes en servidor el NIF no es de cap persona sinó de del d'entitat en que es firmi
            final String nif = null;

            
            
            IPluginFirmaEnServidorViaApi pluginFirmaServidor = pluginFirmaEnServidorViaApiLogicaEJB.getCurrentEnabledInstance();
            
            pluginFirmaServidor.firmaEnServidor(fitxerLogicaEjb, evi, idiomaUI, signID, name, reason, location,
                            signNumber, languageSign, tipusDocumentalID, nif);
            
            
            /*
            String tipusFirma = Configuracio.getTipusFirmaEnServidor();

            // TODO Falta controlar que no sigui NULLL
            switch (tipusFirma) {
                case "apifirmaenservidor":
                    this.firmaEnServidorUtilitzantApiFirmaSimplePortaFIB(evi, idiomaUI, signID, name, reason, location,
                            signNumber, languageSign, tipusDocumentalID, nif);
                break;

                case "utilitatsfirma":
                    this.firmaEnServidorUtilitzantUtilitatsFirmaApiV2(evi, idiomaUI, signID, name, reason, location,
                            signNumber, languageSign, tipusDocumentalID, nif);
                break;
                default:
                    log.error("Tipus de firma en servidor no reconegut: " + tipusFirma);
                    // XYZ ZZZ Traduir
                    throw new I18NException("genapp.comodi", tipusFirma);
            }
            */

        } catch (I18NException th) {
            evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
            final String msg = I18NCommonUtils.getMessage(th, languageUI);
            evi.setEstatError(StringUtils.abbreviate(msg, 4000));
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
            final String msg = "Error no controlat signant document dins EvidènciesIB: " + th.getMessage();
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

                String msg = "Error actualitzant l'evidència despres de signar el document: "
                        + I18NCommonUtils.getMessage(e, languageUI);
                log.error(msg, e);

            }
        }

        return evi;

    }

    

    private EvidenciaJPA createEvidenciaAdaptedFile(EvidenciaJPA evi, Locale langUI) throws I18NException {

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

                String urlWeb = generarAnnexJsonDeLesEvidencies(evi, reader, stamper, writer);

                afegirSegellAmbInformacioEvidencia(evi, reader, stamper, writer, urlWeb);

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
     * @param reader
     * @param stamper
     * @param writer
     * @throws IOException
     * @throws I18NException
     * @throws DocumentException
     */
    private String generarAnnexJsonDeLesEvidencies(Evidencia evi, PdfReader reader, PdfStamper stamper,
            PdfWriter writer) throws Exception {

        // Attach JSON  to PDF

        // 1. Modificar Contingut del PDF

        // 1.3.- Attach Files

        Map<String, String> map = getBasicPropertiesOfEvidence(evi);

        File fileEviJson = null;
        try {

            fileEviJson = File.createTempFile("evidenciesib_evidencies_", ".json");
            fileEviJson.deleteOnExit();
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
            
            org.apache.commons.io.FileUtils.write(fileEviJson, gson.toJson(map), StandardCharsets.UTF_8);
            final String name = "evidencies.json";
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

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            info.put("EvidenciesIB." + key, val);
        }

        stamper.setMoreInfo(info);

        return (String) map.get("url.web");

    }
    
    
    

    @PermitAll
    @Override
    public Map<String, String> getBasicPropertiesOfEvidence(String encryptedEvidenceID) throws I18NException {

        Long evidenciaID;

        try {
            evidenciaID = LogicUtils.decryptEvidenciaID(encryptedEvidenceID);
        } catch (Exception e) {
            String msg = "Error desencriptant l'ID de l'evidència(" + encryptedEvidenceID + "): " + e.getMessage();
            log.error(msg, e);
            throw new I18NException(e, "genapp.comodi", msg);
        }

        Evidencia evi = this.findByPrimaryKey(evidenciaID);

        if (evi == null) {

            // error.notfound=No s´ha trobat cap {0} amb {1} igual a {2}
            throw new I18NException("error.notfound", new I18NArgumentString("Evidència"),
                    new I18NArgumentString("'ID encriptat'"), new I18NArgumentString(encryptedEvidenceID));
        }

        Map<String, String> map;
        try {
            map = getBasicPropertiesOfEvidence(evi);
        } catch (Exception e) {
            // XYZ ZZZ TRA
            String msg = "Error obtenint les propietats bàsiques de l'evidència(" + encryptedEvidenceID + "): "
                    + e.getMessage();
            log.error(msg, e);
            throw new I18NException(e, "genapp.comodi", msg);
        }

        return map;
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
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                stamp.addAnnotation(annot, i);
            }
        }

        PdfAction action = new PdfAction(new URL(url));
        {
            PdfAnnotation annotLink1;
            annotLink1 = new PdfAnnotation(writer, r.getLeft(), r.getBottom(), r.getRight(), r.getTop(), action);
            //annot2.put(PdfName.NAME, new PdfName(name));
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                stamp.addAnnotation(annotLink1, i);
            }
        }
    }




    /**
     * 
     * @param evi
     * @return
     * @throws Exception 
     */
    protected Map<String, String> getBasicPropertiesOfEvidence(Evidencia evi) throws Exception {
        Map<String, String> map = new TreeMap<String, String>();

        map.put("EvidenciaID", String.valueOf(evi.getEvidenciaID()));
        map.put("EvidenciaID.encrypted", LogicUtils.encryptEvidenciaID(evi.getEvidenciaID()));

        final String encryptedEvidenciaIdForUrl = URLEncoder
                .encode(LogicUtils.encryptEvidenciaID(evi.getEvidenciaID()), StandardCharsets.UTF_8);

        final String urlWeb;
        urlWeb = Configuracio.getFrontUrl() + Constants.MAPPING_FRONT_FULL_PUBLIC_EVIDENCE_INFO + encryptedEvidenciaIdForUrl;
        map.put("url.web", urlWeb);

        final String urlFile = Configuracio.getFrontUrl() + Constants.MAPPING_PUBLIC_ARXIU + encryptedEvidenciaIdForUrl;
        map.put("url.downloadfile", urlFile);

        /*
        final String urlJson = Configuracio.getFrontUrl().replace("front", "api/externa")
                + "/secure/evidencies/getbyencryptedid/" + encryptedEvidenciaIdForUrl;
        map.put("url.json", urlJson);
        */

        map.put("person.name", evi.getPersonaNom());
        map.put("person.surname1", evi.getPersonaLlinatge1());
        map.put("person.surname2", evi.getPersonaLlinatge2());
        map.put("person.administrationid", evi.getPersonaNif());

        map.put("login.type", evi.getLoginType());
        map.put("login.subtype", evi.getLoginSubtype());
        map.put("login.id", evi.getLoginId());
        map.put("login.date", ISO8601.dateToISO8601(evi.getLoginData()));
        map.put("login.properties.sha256", evi.getLoginPropertiesSha256());
        map.put("login.qaa", evi.getLoginQaa());

        String clickProperties = evi.getClickProperties();
        if (clickProperties != null && clickProperties.trim().length() != 0) {

            Properties prop = new Properties();
            try {
                prop.load(new StringReader(clickProperties));
            } catch (IOException e) {
            }
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

        // Esborram tots els valors null !!!!
        while (map.values().remove(null)) {
        }

        return map;
    }

    
}
