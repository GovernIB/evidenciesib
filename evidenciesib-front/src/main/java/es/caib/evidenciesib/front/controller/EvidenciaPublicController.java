package es.caib.evidenciesib.front.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**
 * 
 * @author anadal
 * 13 ene 2026 10:53:06
 */
@Controller
public class EvidenciaPublicController {

    protected Logger log = Logger.getLogger(getClass());

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

            String onlyHeader = Configuracio.getFrontUrl() + ENTITY_HEADER_CONTEXTWEB;

            //log.info("\nInvocant a URL BACK per obtenir informació bàsica de l'evidència: " + urlBack + "\n");

            html.append(
                    "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
            html.append("<html>\n");

            html.append("<head>\n");
            html.append("<script src='" + request.getContextPath() + "/js/jquery-3.5.0.js'></script>\n");
            html.append("<script src='" + request.getContextPath() + "/js/jquery-ui.min.js'></script>\n");
            html.append("</head>\n");
            html.append("<body>\n");

            html.append(restTemplate.getForObject(onlyHeader, String.class));

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
    public void descargar(@PathVariable("encriptedEvidenciaID")
    String encriptedEvidenciaID, HttpServletRequest request, HttpServletResponse response) throws Exception {

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
    }

}
