package org.fundaciobit.pluginsib.login.springutils;

import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.login.api.ConstantsLogin;
import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.fundaciobit.pluginsib.login.api.LoginInfoRepresentative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anadal
 *
 */
@Controller
public class PluginLoginController {

    public static final String URL_BASE_LOGIN = "URL_BASE_LOGIN";

    public static final String SESSION_RETURN_URL_POST_LOGIN = "SESSION_RETURN_URL_POST_LOGIN";

    public static final String MAPPING_PRELOGIN = "/prelogin";

    public static final String MAPPING_LOGIN = "/login";

    public static final String MAPPING_OK_LOGIN = "/okLogin";

    public static final String MAPPING_ERROR_LOGIN = "/errorLogin";

    public static final String MAPPING_LOGOUT = "/logout";

    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private PluginLoginSecurityService securityService;

    @Autowired
    private PluginLoginRequestCache loginRequestCache; // Cache peticiones

    @RequestMapping(value = MAPPING_PRELOGIN)
    public void prelogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // String urluser = protocol + "//" + host + request.getContextPath();

        String urlbase = request.getParameter("urlbase");

        if (urlbase == null) {

            String html = "<html><head></head>\r\n" + "<body>\n" + "<script >\n"
                    + " var url = new URL(window.location.href);\n" + " var urlbase = url.protocol + '//' + url.host;\n"
                    + " var newUrl = urlbase + \"" + request.getContextPath() + MAPPING_PRELOGIN
                    + "?urlbase=\" + urlbase;\n" + " alert('Nova url => ' + newUrl);\n"
                    + " window.location.href = newUrl;" + "</script>\n" + "</body></html>";

            response.setContentType("text/html");
            response.getWriter().write(html);

        } else {

            log.info(" XXX XYZ PRELOGIN urlbase  => ]" + urlbase + "[");
            urlbase = urlbase + request.getContextPath();
            request.getSession().setAttribute(URL_BASE_LOGIN, urlbase);

            response.sendRedirect(request.getContextPath() + MAPPING_LOGIN);

        }

    }

    @RequestMapping(value = MAPPING_LOGIN)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //long temps = System.currentTimeMillis();

        // Error login
        if ("true".equals(request.getParameter("error"))) {

            // Log no autenticat/error
            // Cream les dades bàsiques de la petició per els logs
            StringBuilder peticio = new StringBuilder();
            peticio.append("Usuari: no definit").append("\n");
            peticio.append("classe: ").append(getClass().getName()).append("\n");

            log.info("Error de login");

            throw new Exception("Error de login: " + peticio.toString());

        }

        final SavedRequest savedRequest = loginRequestCache.getRequest(request, response);

        if (savedRequest != null && existeTicket(savedRequest)) {

            return autenticarTicket(request, savedRequest);

        } else {

            if (savedRequest != null) {

                log.info("Punto de entrada: " + savedRequest.getRedirectUrl());

                log.info("iniciarSesionAutentificacion: " + savedRequest.getRedirectUrl());
            }

            String urlbase = (String) request.getSession().getAttribute(URL_BASE_LOGIN);
            if (urlbase == null) {

                log.warn(
                        "Abans de cridar LOGIN s'ha de cridar a PRELOGIN o definir dins la sessió l'atribut URL_BASE_LOGIN");

                return new ModelAndView(new RedirectView(MAPPING_PRELOGIN, true));
            }

            String url_callback_login = urlbase + MAPPING_OK_LOGIN;
            String url_callback_error = urlbase + MAPPING_ERROR_LOGIN;
            String language = LocaleContextHolder.getLocale().getLanguage();

            String url;
            try {
                log.info("\n\nPluginLoginController::login() => PluginLoginManager.getPluginLogin() = "
                        + PluginLoginManager.getPluginLogin() + "\n\n");
                url = securityService.iniciarSesionAutentificacion(PluginLoginManager.getPluginLogin(),
                        url_callback_login, url_callback_error, language);
            } catch (Exception e) {
                String msg = "Error Iniciant la sessió de seguretat amb Plugin de Login: " + e.getMessage();
                log.error(msg, e);
                url = urlbase;
                return new ModelAndView("redirect:" + url);
            }

            log.info("Url autentificacion: " + url);

            return new ModelAndView("redirect:" + url);

        }

    }

    @RequestMapping(value = MAPPING_OK_LOGIN)
    public String okLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info("\nDentro de okLogin: ...\n");

        printLoginInfo();

        String fullUrlRedirect = (String) request.getSession().getAttribute(ConstantsLogin.SESSION_INITIAL_URL);

        log.info("\nDentro de okLogin: fullUrlRedirect => ]" + fullUrlRedirect + "[\n");

        if (fullUrlRedirect == null) {
            fullUrlRedirect = "/";
        } else {
            request.getSession().removeAttribute(ConstantsLogin.SESSION_INITIAL_URL);
        }

        log.info("\n " + MAPPING_OK_LOGIN + " => " + fullUrlRedirect + "\n");

        return "redirect:" + fullUrlRedirect;

    }

    @RequestMapping(value = { MAPPING_ERROR_LOGIN }, method = RequestMethod.GET)
    public ModelAndView error(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {

        ModelAndView mav = new ModelAndView("error");

        try {

            Map<String, String[]> map = request.getParameterMap();

            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                String key = entry.getKey();
                String[] val = entry.getValue();
                log.error("KEY => ]" + key + "[ : {" + Arrays.toString(val) + "}");
            }

            mav.addObject("error", e.getMessage());

        } catch (Throwable e1) {
            log.error("Error: " + e1.getMessage(), e1);
        }

        return mav;

    }

    protected void printLoginInfo() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {

            log.error("printLoginInfo::authentication == null !!!!!!!!!!!!!!!!!!!! ");

        } else {

            Object principal = authentication.getPrincipal();

            if (principal == null) {
                log.error("printLoginInfo::principal == null !!!!!!!!!!!!!!!!!!!! ");
            } else if (!(principal instanceof PluginLoginUserDetails)) {
                log.error("printLoginInfo::principal no es de la classe UsuarioAutenticado ... ");
                log.error("     - principal Class =>  " + principal.getClass().getName());
                log.error("     - principal Value =>  ]" + principal.toString() + "[");
            } else {

                PluginLoginUserDetails usuarioAutenticado = (PluginLoginUserDetails) principal;
                LoginInfo uc = usuarioAutenticado.getUsuario();

                StringBuffer str = new StringBuffer(
                        "\n======================== INFO USER PLUGIN LOGIN ======================");

                str.append("\nNom: ").append(uc.getName()).append("\nLlinatge1: ").append(uc.getSurname1());
                str.append("\nLlinatge2: ").append(uc.getSurname2()).append("\nNIF: ").append(uc.getAdministrationID());
                str.append("\nMethod: ").append(uc.getAuthenticationMethod());
                str.append("\nQaa: ").append(uc.getQaa()).append("\nEmpresa:").append(uc.isBusiness());

                LoginInfoRepresentative ucr = uc.getRepresentative();
                if (ucr == null) {
                    str.append("\nRepresentant: NO");
                } else {
                    str.append("\nRepresentant:");
                    str.append("\n    - Nom: ").append(ucr.getName());
                    str.append("\n    - Llinatge1: ").append(ucr.getSurname1());
                    str.append("\n    - Llinatge2: ").append(ucr.getSurname1());
                    str.append("\n    - Nif: ").append(ucr.getAdministrationID());
                }

                str.append("\n\n-----------------------------------------------------");

                log.info(str);

            }
        }

    }

    @RequestMapping(value = MAPPING_LOGOUT)
    public String logout(HttpServletRequest request) throws Exception {

        log.info("Dentro de salir");

        String baseURL = (String) request.getSession().getAttribute(URL_BASE_LOGIN);

        log.info("BASE URL LOGOUT => " + baseURL);

        String url_callback_logout = baseURL;
        final String idioma = LocaleContextHolder.getLocale().getLanguage();

        securityService.iniciarSesionLogout(PluginLoginManager.getPluginLogin(), url_callback_logout, idioma);
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";

    }

    /**
     * Autentica via ticket.
     *
     * @param request        Request
     * @param ticketUserName Usuario asociado al tipo de ticket
     * @return Vista que realiza el login automáticamente
     */
    private ModelAndView autenticarTicket(HttpServletRequest request, SavedRequest savedRequest) throws Exception {

        log.info("\n\n");

        Object _csrf = request.getAttribute("_csrf");

        CsrfToken csrfToken = (CsrfToken) _csrf;

        log.info(" _csrf 2 => " + _csrf);

        if (_csrf != null) {
            log.info(" _csrf => " + _csrf.getClass().getName());
        }
        log.info("\n\n");

        // Obtenemos ticket de la peticion
        final String[] tickets = savedRequest.getParameterMap().get(ConstantsLogin.TICKET_PARAM);

        log.info("Check ticket => " + tickets);
        if (tickets != null) {
            log.info("Check #ticket => " + tickets.length);
        }

        if (tickets == null || tickets.length != 1) {
            throw new Exception("No existe ticket");
        }
        final String ticketValue = tickets[0];

        log.info("Autenticando el ticket: " + tickets[0]);


        final String ticketName = "ticket-user-clave";

        StringBuilder str = new StringBuilder();

        str.append("<!DOCTYPE html>\n");
        str.append("<html>\n");
        str.append("<head>\n");
        str.append("<title>LOGIN TICKET</title>\n");
        str.append("<meta charset=\"utf-8\" />\n");
        str.append("<meta http-equiv=\"Expires\" content=\"0\">\n");
        str.append("<meta http-equiv=\"Last-Modified\" content=\"0\">\n");
        str.append("<meta http-equiv=\"Cache-Control\" content=\"no-cache, mustrevalidate\">\n");
        str.append("<meta http-equiv=\"Pragma\" content=\"no-cache\">\n");
        str.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
        str.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
        str.append("\n");
        str.append("<script type=\"text/javascript\">\n");
        str.append("    function loginTicket() {\n");
        str.append("        document.getElementById(\"formLogin\").submit();\n");
        str.append("    }\n");
        str.append("</script>\n");
        str.append("\n");
        str.append("</head>\n");
        str.append("<body onload=\"loginTicket()\">\n");
        str.append("\n");
        str.append("\n");
        str.append("    Autenticando...\n");
        str.append("\n");
        str.append("    <form name=\"formLogin\" id=\"formLogin\" method=\"post\" action=\"login\">\n");
        str.append("    <input type=\"hidden\" name=\"username\" id=\"username\" value=\"" + ticketName + "\" />\n");
        str.append("    <input type=\"hidden\" name=\"password\" id=\"password\" value=\"" + ticketValue + "\" />\n");
        str.append("    <input type=\"hidden\" name=\"" + csrfToken.getParameterName() + "\" value=\""
                + csrfToken.getToken() + "\" />\n");
        str.append("    </form>\n");
        str.append("\n");
        str.append("</body>\n");
        str.append("</html>\n");

        ModelAndView mav = new ModelAndView(new HtmlView(str.toString()));

        return mav;

    }

    /**
    */
    public static class HtmlView implements View {

        final String html;

        public HtmlView(String html) {
            this.html = html;
        }

        @Override
        public String getContentType() {

            return "text/html";
        }

        @Override
        public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
                throws Exception {

            // ;charset=UTF-8
            response.setContentLength(html.length());
            response.setContentType(this.getContentType());
            response.getWriter().print(html);
            response.getWriter().flush();

        }

    }

    /**
     * Comprueba si existe ticket en request.
     *
     * @param request Request
     * @return boolean
     */
    private boolean existeTicket(SavedRequest request) {

        final String[] tickets = request.getParameterMap().get(ConstantsLogin.TICKET_PARAM);
        if (tickets == null || tickets.length != 1) {
            return false;
        }
        log.info("Existe un ticket de autentificacion: " + tickets.length);

        return true;
    }

}
