package es.caib.evidenciesib.front.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.logic.EvidenciaLogicaService;
import es.caib.evidenciesib.logic.FitxerLogicaService;
import es.caib.evidenciesib.model.fields.EvidenciaFields;
import es.caib.evidenciesib.persistence.FitxerJPA;

/**
 * 
 * @author anadal
 * 13 ene 2026 10:53:06
 */
@Controller
public class EvidenciaPublicController {

    protected Logger log = Logger.getLogger(getClass());

    @EJB(mappedName = FitxerLogicaService.JNDI_NAME)
    private FitxerLogicaService fitxerEjb;

    // EJB Lògica d'Evidències
    @EJB(mappedName = EvidenciaLogicaService.JNDI_NAME)
    private EvidenciaLogicaService evidenciaLogicaEjb;

    @ResponseBody
    @RequestMapping(
            value = Constants.MAPPING_FULL_PUBLIC_EVIDENCE_INFO + "{encriptedEvidenciaID}",
            method = RequestMethod.GET)
    public String showBasicInfo(@PathVariable("encriptedEvidenciaID")
    String encriptedEvidenciaID, HttpServletRequest request, HttpServletResponse response) throws Exception {

        boolean headerEnabled = Configuracio.isSignatureHeaderEnabled();

        StringBuilder html = new StringBuilder();

        String urlEvidenciesBack = Configuracio.getBackUrl() + Constants.MAPPING_FULL_PUBLIC_EVIDENCE_INFO
                + encriptedEvidenciaID;

        if (headerEnabled) {

            RestTemplate restTemplate = new RestTemplate();

            //log.info("\nInvocant a URL BACK per obtenir informació bàsica de l'evidència: " + urlBack + "\n");

            html.append(
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            html.append("<html>\n");

            html.append("<head>\n");
            html.append("<script src='" + request.getContextPath() + "/js/jquery-3.5.0.js'></script>\n");
            html.append("<script src='" + request.getContextPath() + "/js/jquery-ui.min.js'></script>\n");
            html.append("</head>\n");
            html.append("<body>\n");

            final String onlyHeader = Configuracio.getFrontUrl() + ENTITY_HEADER_CONTEXTWEB;

            final String header = restTemplate.getForObject(onlyHeader, String.class);
            html.append(header);

            html.append("<iframe id='miIframe' style='width:100%; height:1800px; border:none;' src='"
                    + urlEvidenciesBack + "'>\n");

            html.append("</iframe>");

            html.append("</body></html>");
        } else {

            RestTemplate restTemplate = new RestTemplate();

            //log.info("\nInvocant a URL BACK per obtenir informació bàsica de l'evidència: " + urlBack + "\n");

            html.append(restTemplate.getForObject(urlEvidenciesBack, String.class));

        }

        //String htmlEvidenciesIBInfo =  restTemplate.getForObject(urlBack, String.class);

        return html.toString();
    }

    public static final String ENTITY_HEADER_CONTEXTWEB = "/public/onlyheader";

    @RequestMapping(value = ENTITY_HEADER_CONTEXTWEB, method = RequestMethod.GET)
    public ModelAndView onlyHeader(HttpServletRequest request, HttpServletResponse response) {

        // /evidenciesib-front/src/main/webapp/WEB-INF/views/pages/entityheader.jsp
        ModelAndView mav = new ModelAndView("entityheader");

        EvidenciaLoginController.configurarEntityHeader(request, mav, log);

        return mav;

    }

    @RequestMapping(value = Constants.MAPPING_PUBLIC_ARXIU + "{encriptedEvidenciaID}", method = RequestMethod.GET)
    @PermitAll
    public void descaregarFitxerSignat(@PathVariable("encriptedEvidenciaID")
    String encriptedEvidenciaID, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            Long evidenciaID = HibernateFileUtil.decryptFileID(encriptedEvidenciaID);

            Long fitxerID = evidenciaLogicaEjb.executeQueryOne(EvidenciaFields.FITXERSIGNATID,
                    EvidenciaFields.EVIDENCIAID.equal(evidenciaID));

            FitxerJPA fitxer = fitxerEjb.findByPrimaryKey(fitxerID);

            fullDownload(fitxerID, fitxer.getNom(), fitxer.getMime(), response, log);

        } catch (Exception e) {
            log.error("Error desencriptando el ID del archivo: " + encriptedEvidenciaID, e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de archivo no válido: " + e.getMessage());
            return;
        }

        /*
        // Query string original (nom=...&mime=...)
        String query = request.getQueryString();
        
        // Construir URL destí sense tocar paràmetres
        StringBuilder urlBack = new StringBuilder();
        urlBack.append(Configuracio.getBackUrl());
        urlBack.append(Constants.MAPPING_PUBLIC_ARXIU);
        urlBack.append(encriptedEvidenciaID);
        
        if (query != null && !query.isEmpty()) {
            urlBack.append("?").append(query);
        }
        
        URL url = new URL(urlBack.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        
        // Reenviar headers importants
        response.setStatus(conn.getResponseCode());
        response.setContentType(conn.getContentType());
        
        String disposition = conn.getHeaderField("Content-Disposition");
        if (disposition != null) {
            response.setHeader("Content-Disposition", disposition);
        }
        
        // Streaming
        try (InputStream in = conn.getInputStream(); OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        }
        */
    }
    
    
    
    /**
     * 
     * @param arxiuId
     * @param filename
     * @param contentType
     * @param response
     */
    public static void fullDownload(long arxiuId, String filename, String contentType, 
      HttpServletResponse response, Logger log) {

      FileInputStream input = null;
      OutputStream output = null;
      

      try {
        File file = FileSystemManager.getFile(arxiuId);

        if (!file.exists()) {
          // TODO TRADUIR Fitxer no trobat
          String msg = "Fitxer amb ID=" + arxiuId + " no existeix.";
          response.setHeader("MsgEvidenciesIB", msg);
          response.sendError(HttpServletResponse.SC_NOT_FOUND);
          return;
        }
        
        if (filename == null) {
          filename = "file"; // arxiu.getNombre()
        }
        if (contentType == null) {
          MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
          contentType = mimeTypesMap.getContentType(file);
        }
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
        response.setContentLength((int) file.length());

        output = response.getOutputStream();
        input = new FileInputStream(file);
        
        FileSystemManager.copy(input, output);
       
        input.close();
        output.close();

      }  catch (Exception e) {
        String msg = "Error descarregant fitxer amb ID = " + arxiuId + "(" + e.getMessage() + ")"; 
        log.error(msg, e);
        response.setHeader("MsgEvidenciesIB", msg);
        try {
          response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException e1) {
          response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
      }
    }

}
