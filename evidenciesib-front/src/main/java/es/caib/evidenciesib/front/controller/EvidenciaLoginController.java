package es.caib.evidenciesib.front.controller;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginController;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String frontLoginStart(HttpServletRequest request, HttpServletResponse response,
            @PathVariable("evidenciaID") Long evidenciaID) throws Exception {

        String urlfront = Configuracio.getFrontUrl();
        log.info("frontLoginStart =>  evidenciaID=" + evidenciaID);
        log.info("frontLoginStart =>  urlfront=" + urlfront);

        // mirar si existeix ID
        Long number;
        try {
            number = evidenciaLogicaEjb.count(EvidenciaFields.EVIDENCIAID.equal(evidenciaID));
        } catch (I18NException e) {
            String msg = "Error intentant esbrinar si existeix l'evidencia amb ID " + evidenciaID + ": "
                    + I18NUtils.getMessage(e);
            log.error(msg, e);
            throw new Exception(msg, e);
        }
        if (number == 0) {
            // XYZ 
            throw new Exception("No es troba evidenciaID amb ID ]" + evidenciaID + "[");
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(EVIDENCIAID, evidenciaID);

        httpSession.setAttribute(PluginLoginController.URL_BASE_LOGIN, urlfront);

        httpSession.setAttribute(PluginLoginController.SESSION_RETURN_URL_POST_LOGIN,
                urlfront + MAPPING_FRONT_LOGIN_END + "/" + evidenciaID);

        return "redirect:" + PluginLoginController.MAPPING_LOGIN;

    }

    @RequestMapping(MAPPING_FRONT_LOGIN_END + "/{evidenciaID}")
    public String frontLoginEnd(HttpServletRequest request, HttpServletResponse response,
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
                // String lang = LocaleContextHolder.getLocale().getLanguage();
                // evi.setLoginSubtype(PluginLoginManager.getPluginLogin().getName(lang));

                // XYZ ZZZ
                LoginInfo li = plud.getUsuario();
                evi.setLoginId(li.getLoginID());

                evi.setPersonaEmail(null);
                evi.setPersonaLlinatge1(li.getSurname1());
                evi.setPersonaLlinatge2(li.getSurname2());
                evi.setPersonaMobil(null);
                evi.setPersonaNif(li.getAdministrationID());
                evi.setPersonaNom(li.getName());

                // XYZ ZZZ
                // evi.setLoginQaa(li.getQaa());
                // evi.setLoginAuthenticationMethod(li.getAuthenticationMethod())

                evidenciaLogicaEjb.update(evi);

            }
        }

        String r = "redirect:" + Configuracio.getBackUrl() + Constants.MAPPING_BACK_LOGIN_END + "/" + evidenciaID;
        log.info("Login Correcte. Redirect => " + r);

        return r;
    }

}
