package es.caib.evidenciesib.front.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.core.utils.EncrypterDecrypter;
import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginController;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginManager;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginUserDetails;
import org.springframework.context.i18n.LocaleContextHolder;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.logic.EvidenciesFrontLogicaService;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

/**
 * 
 * @author anadal
 *
 */
@Controller
public class EvidenciaLoginController {

    protected final Logger log = Logger.getLogger(this.getClass());

    @EJB(mappedName = EvidenciesFrontLogicaService.JNDI_NAME)
    protected EvidenciesFrontLogicaService evidenciaLogicaEjb;

    // XYZ ZZZ
    public static final String EVIDENCIAID = "SESSION_EVIDENCIA_ID";

    public static final String MAPPING_FRONT_LOGIN_END = "/frontloginend";

    @RequestMapping(Constants.MAPPING_FRONT_LOGIN_START + "/{evidenciaID}")
    public ModelAndView frontLoginStart(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {

        log.info("frontLoginStart =>  evidenciaID=" + evidenciaID);

        // mirar si existeix ID
        EvidenciaJPA evidencia;
        try {
            evidencia = evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);
        } catch (Throwable e) {

            String msg;
            if (e instanceof I18NException) {
                msg = I18NUtils.getMessage((I18NException) e);
            } else {
                msg = e.getMessage();
            }

            msg = "Error intentant esbrinar si existeix l'evidencia amb ID " + evidenciaID + ": " + msg;
            log.error(msg, e);
            throw new Exception(msg, e);
        }
        if (evidencia == null) {
            // XYZ 
            throw new Exception("No es troba evidenciaID amb ID ]" + evidenciaID + "[");
        }

        // XYZ ZZZ Falta Idioma

        ModelAndView mav = new ModelAndView("norepudi");
        mav.addObject("evidenciaID", evidenciaID);
        mav.addObject("action", request.getContextPath() + MAPPING_NO_REPUDI_POST + "/" + evidenciaID);
        mav.addObject("thumbnail", request.getContextPath() + THUMBNAIL_PDF_MASSIVE + "/" + evidenciaID);

        mav.addObject("download", request.getContextPath() + DOWNLOAD_PDF + "/" + EncrypterDecrypter
                .encrypt(EncrypterDecrypter.ALGORITHM_AES, Configuracio.getEncryptKey(), String.valueOf(evidenciaID)));
        return mav;

    }

    public static final String MAPPING_NO_REPUDI_POST = "/norepudi";

    @RequestMapping(path = MAPPING_NO_REPUDI_POST + "/{evidenciaID}", method = RequestMethod.POST)
    public String noRepudiPost(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {

        if (request.getParameterMap().size() == 0) {
            log.warn("noRepudiPost => NO HI HA PARAMETERS !!!!!!!!");
        } else {
            for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {

                log.info("noRepudiPost => Parameter[" + entry.getKey() + "] => |" + entry.getValue() + "|");

            }
        }

        String botoAccept = request.getParameter("submitAccept");

        if (botoAccept == null) {

            // S'ha pitjat "CANCEL"
            EvidenciaJPA evidencia;
            evidencia = evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);

            evidencia.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);

            evidencia.setEstatError(I18NUtils.tradueix("usuari.cancelat"));
            
            evidencia.setDataFi(new Timestamp(System.currentTimeMillis()));

            evidenciaLogicaEjb.update(evidencia);

            String r = "redirect:" + Configuracio.getBackUrl() + Constants.MAPPING_BACK_LOGIN_END + "/" + evidenciaID;
            log.info("Cancel usuari. Redirect => " + r);

            return r;
        }

        String urlfront = Configuracio.getFrontUrl();
        log.info("noRepudiPost =>  urlfront=" + urlfront);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(EVIDENCIAID, evidenciaID);

        httpSession.setAttribute(PluginLoginController.URL_BASE_LOGIN, urlfront);

        httpSession.setAttribute(PluginLoginController.SESSION_RETURN_URL_POST_LOGIN,
                urlfront + MAPPING_FRONT_LOGIN_END + "/" + evidenciaID);

        return "redirect:" + PluginLoginController.MAPPING_LOGIN;

    }

    public static final String THUMBNAIL_PDF_MASSIVE = "/thumbnailpdf";

    @RequestMapping(value = THUMBNAIL_PDF_MASSIVE + "/{evidenciaID}", method = RequestMethod.GET)
    public void createThumbnailPdf(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception, I18NException {

        long fitxerID = evidenciaLogicaEjb.executeQueryOne(EvidenciaFields.FITXERORIGINALID,
                EvidenciaFields.EVIDENCIAID.equal(evidenciaID));

        PDDocument document = null;
        try {
            File file = FileSystemManager.getFile(fitxerID);

            log.info("PDF File: " + file);
            log.info("PDF File: " + file.exists());

            document = PDDocument.load(file);
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            BufferedImage bim = pdfRenderer.renderImage(0, 0.5f);

            BufferedImage scaled = scale(bim, 350);

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", -1); // Proxies.

            ImageIO.write(scaled, "PNG", response.getOutputStream());

        } catch (Throwable th) {
            log.error("Error creant THUMBNAIL: " + th.getMessage(), th);
            throw th;
        } finally {
            if (document != null) {
                document.close();
            }
        }

    }

    protected static BufferedImage scale(BufferedImage image, int max) {

        int width = image.getWidth(null);
        int height = image.getHeight(null);
        double dWidth = 0;
        double dHeight = 0;
        if (width == height) {
            dWidth = max;
            dHeight = max;
        } else if (width > height) {
            dWidth = max;
            dHeight = ((double) height / (double) width) * max;
        } else {
            dHeight = max;
            dWidth = ((double) width / (double) height) * max;
        }
        Image scaled = image.getScaledInstance((int) dWidth, (int) dHeight, Image.SCALE_SMOOTH);

        return toBufferedImage(scaled);

    }

    protected static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    @RequestMapping(MAPPING_FRONT_LOGIN_END + "/{evidenciaID}")
    public ModelAndView frontLoginEnd(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {

        log.info("frontLoginEnd =>  evidenciaID=" + evidenciaID);

        EvidenciaJPA evi = evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);

        if (evi == null) {
            // XYZ ZZZ
            String msg = "No es troba evidenciaID amb ID ]" + evidenciaID + "[ al retorn del Login";
            log.error(msg);
            throw new Exception(msg);
        } else {

            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (!(principal instanceof PluginLoginUserDetails)) {

                String msg = "Despres del Login no s'ha obtingut informació.";
                log.error(msg);
                evi.setEstatCodi(Constants.EVIDENCIA_ESTAT_CODI_ERROR);
                // XYZ ZZZ
                evi.setEstatError(msg);

                evidenciaLogicaEjb.update(evi);

            } else {

                //Guardar dades de Login dins BBDD

                log.info("Login Correcte. Posant valors a Taula Evidència per ID ]" + evidenciaID + "[");

                PluginLoginUserDetails plud = (PluginLoginUserDetails) principal;

                evi.setLoginData(new Timestamp(System.currentTimeMillis()));

                evi.setLoginType(Constants.EVIDENCIA_TIPUS_LOGIN_PLUGIN_LOGIN);
                // XYZ ZZZ

                LoginInfo li = plud.getUsuario();
                evi.setLoginId(li.getLoginID());

                evi.setPersonaEmail(null);
                evi.setPersonaLlinatge1(li.getSurname1());
                evi.setPersonaLlinatge2(li.getSurname2());
                evi.setPersonaMobil(null);
                evi.setPersonaNif(li.getAdministrationID());
                evi.setPersonaNom(li.getName());

                evi.setLoginAuthMethod(li.getAuthenticationMethod());
                String lang = LocaleContextHolder.getLocale().getLanguage();
                evi.setLoginSubtype(
                        PluginLoginManager.getPluginLogin().getName(lang) + " - " + li.getIdentityProvider());
                evi.setLoginQaa(String.valueOf(li.getQaa()));

                Map<String, String> additional = li.getAdditionalProperties();
                if (additional != null) {

                    Properties props = new Properties();

                    props.putAll(additional);

                    evi.setLoginAdditionalProperties(getPropertyAsString(props));

                }

                evidenciaLogicaEjb.update(evi);

            }
        }
        /*
        String r = "redirect:" + MAPPING_PUBLIC_SET_LOCATION_GET + "/" + evidenciaID;
        log.info("Login Correcte. Redirect a location => " + r);
        
        return r;
            }
        
            public static final String MAPPING_PUBLIC_SET_LOCATION_GET = "/public/setlocationget";
        
            @RequestMapping(name=MAPPING_PUBLIC_SET_LOCATION_GET + "{evidenciaID}", method = RequestMethod.GET)
            public ModelAndView setLocationGet(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {
        */
        ModelAndView mav = new ModelAndView("location");
        mav.addObject("evidenciaID", evidenciaID);

        return mav;
    }

    public static final String DOWNLOAD_PDF = "/downloadpdf";

    @RequestMapping(value = DOWNLOAD_PDF + "/{evidenciaID}", method = RequestMethod.GET)
    public void downloadPdf(HttpServletRequest request, HttpServletResponse response,

            String evidenciaIDEncrypted) throws Exception, I18NException {

        String evidenciaIDDecrypted = EncrypterDecrypter.decrypt(EncrypterDecrypter.ALGORITHM_AES,
                Configuracio.getEncryptKey(), evidenciaIDEncrypted);

        Long evidenciaID = Long.parseLong(evidenciaIDDecrypted);

        long fitxerID = evidenciaLogicaEjb.executeQueryOne(EvidenciaFields.FITXERORIGINALID,
                EvidenciaFields.EVIDENCIAID.equal(evidenciaID));

        try {
            File file = FileSystemManager.getFile(fitxerID);

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", -1); // Proxies.

            response.getOutputStream().write(FileSystemManager.readFileToByteArray(file));

        } catch (Throwable th) {
            log.error("Error descarregant PDF: " + th.getMessage(), th);
            throw th;
        }
    }

    /**
     * 
     * @param prop
     * @return
     */
    protected static String getPropertyAsString(Properties prop) throws Exception {
        StringWriter writer = new StringWriter();

        prop.store(writer, "");

        return writer.getBuffer().toString();
    }

    public static final String MAPPING_PUBLIC_SET_LOCATION_POST = "/public/setlocationpost";

    @RequestMapping(
            value = MAPPING_PUBLIC_SET_LOCATION_POST + "/{evidenciaID}",
            method = { RequestMethod.POST, RequestMethod.GET })
    public String setLocationPost(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {

        log.info("setLocationPost =>  evidenciaID=" + evidenciaID);

        EvidenciaJPA evi = evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);

        if (evi == null) {
            // XYZ ZZZ
            String msg = "No es troba evidenciaID amb ID ]" + evidenciaID + "[ al retorn del Login";
            log.error(msg);
            throw new Exception(msg);
        } else {

            //Guardar dades de Login dins BBDD

            log.info("setLocationPost:: Posant valors de UBICACIO a Taula Evidència per ID ]" + evidenciaID + "[");

            Enumeration<String> ubis = request.getParameterNames();

            while (ubis.hasMoreElements()) {
                String name = ubis.nextElement();
                log.info("PARAMETRE[" + name + "] => " + request.getParameter(name));

            }

            String ciutat = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOCIUTAT.javaName);
            String codipostal = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOCODIPOSTAL.javaName);
            String ip = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOIP.javaName);
            String latitud = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOLATITUD.javaName);
            String longitud = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOLONGITUD.javaName);
            String pais = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOPAIS.javaName);
            String regio = request
                    .getParameter(EvidenciaFields._TABLE_MODEL + "." + EvidenciaFields.LOCALITZACIOREGIO.javaName);

            log.info("setLocationPost:: ciutat => " + ciutat);
            log.info("setLocationPost:: pais => " + pais);
            log.info("setLocationPost:: ip => " + ip);

            evi.setLocalitzacioCiutat(ciutat);
            evi.setLocalitzacioCodiPostal(codipostal);
            evi.setLocalitzacioIp(ip);
            evi.setLocalitzacioLatitud(latitud);
            evi.setLocalitzacioLongitud(longitud);
            evi.setLocalitzacioPais(pais);
            evi.setLocalitzacioRegio(regio);

            evidenciaLogicaEjb.update(evi);

        }

        String r = "redirect:" + Configuracio.getBackUrl() + Constants.MAPPING_BACK_LOGIN_END + "/" + evidenciaID;
        log.info("Login Correcte. Redirect => " + r);

        return r;

    }

}
