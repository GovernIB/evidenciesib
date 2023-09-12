package es.caib.evidenciesib.back.controller.all;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.caib.evidenciesib.back.controller.user.EvidenciaUserController;
import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.hibernate.HibernateFileUtil;
import es.caib.evidenciesib.logic.EvidenciesFrontLogicaService;
import es.caib.evidenciesib.persistence.EvidenciaJPA;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(value = "/public/index.html")
	public ModelAndView principal(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Boolean initialized = (Boolean) session.getAttribute("inicialitzat");
		if (initialized == null) {
			HtmlUtils.saveMessageInfo(request, "MessageInfo : Benvingut a EvidenciesIB");
			session.setAttribute("inicialitzat", true);
		}
		return new ModelAndView("homepublic");
	}
	
	
	@RequestMapping(value = Constants.MAPPING_BACK_LOGIN_END + "/{evidenciaID}")
    public String postLoginFront(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {
	    // Aqui hem d'averiguar si l'origen de l'evidència és REST o BACK

	    log.info("Entra a postLoginFront[EviID:" + evidenciaID + "]");

	    EvidenciaJPA evi = evidenciaLogicaEjb.findByPrimaryKey(evidenciaID);

	    if (evi.getUsuariAplicacio() == null) {
	        // ES BACK
	        return "redirect:" + EvidenciaUserController.CONTEXT_WEB + Constants.MAPPING_BACK_PUBLIC_EVIDENCE_SIGN_OPERATION + evidenciaID;
	    } else {
	        // ES REST
	        // TOD XYZ ZZZ ZZZ FA FALTA FER
	        return "redirect:" +  Constants.MAPPING_BACK_PUBLIC_EVIDENCE + Constants.MAPPING_BACK_PUBLIC_EVIDENCE_SIGN_OPERATION + evidenciaID;
	    }
	}

	

}
