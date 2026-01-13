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

        RestTemplate restTemplate = new RestTemplate();

        String urlBack = Configuracio.getBackUrl() + Constants.MAPPING_FULL_PUBLIC_EVIDENCE_INFO + encriptedEvidenciaID;

        //log.info("\nInvocant a URL BACK per obtenir informació bàsica de l'evidència: " + urlBack + "\n");

        return restTemplate.getForObject(urlBack, String.class);
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
