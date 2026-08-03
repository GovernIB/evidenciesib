package es.caib.evidenciesib.back.controller.all;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.commons.utils.Version;
import es.caib.evidenciesib.logic.EvidenciesFrontLogicaService;

/**
 * 
 * @autor anadal
 * 
 */
@Controller
public class PublicController {

    @EJB(mappedName = EvidenciesFrontLogicaService.JNDI_NAME)
    protected EvidenciesFrontLogicaService evidenciaLogicaEjb;

    protected final Logger log = Logger.getLogger(getClass());

    @Autowired
    protected Version versio;

    @RequestMapping(value = "/public/avislegal")
    public ModelAndView avislegal(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String lang = LocaleContextHolder.getLocale().getLanguage();

        log.info("\n\n" + " LOCALE ====>   " + lang + "\n\n");

        if ("es".equals(lang)) {
            return new ModelAndView("avislegal_es");
        } else {
            return new ModelAndView("avislegal_ca");
        }
    }

    @RequestMapping(value = "/public/versio")
    public void versio(HttpServletResponse response) throws Exception {

        response.getWriter().write(versio.getVersion() + "|" + versio.getBuildTime());
        response.getWriter().flush();
        response.getWriter().close();

    }


    @RequestMapping(
            value = Constants.MAPPING_FRONT_FULL_PUBLIC_EVIDENCE_INFO + "{encriptedEvidenciaID}",
            method = RequestMethod.GET)
    public String showBasicInfo(@PathVariable("encriptedEvidenciaID")
    String encriptedEvidenciaID, HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "redirect:" + Configuracio.getFrontUrl() + Constants.MAPPING_FRONT_FULL_PUBLIC_EVIDENCE_INFO
                + encriptedEvidenciaID;

    }

}
