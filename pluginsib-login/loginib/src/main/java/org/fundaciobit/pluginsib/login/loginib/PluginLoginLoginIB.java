package org.fundaciobit.pluginsib.login.loginib;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.pluginsib.login.api.AbstractPluginLogin;
import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.fundaciobit.pluginsib.login.api.LoginInfoRepresentative;

import es.caib.loginib.rest.api.v1.RDatosAutenticacion;
import es.caib.loginib.rest.api.v1.RDatosRepresentante;
import es.caib.loginib.rest.api.v1.RLoginParams;
import es.caib.loginib.rest.api.v1.RLogoutParams;

/**
 * 
 * @author anadal
 *
 */
public class PluginLoginLoginIB extends AbstractPluginLogin {

    protected final String PLUGIN_LOGINIB_PROPERTY_BASE = PLUGIN_LOGIN_PROPERTY_BASE + "loginib.";

    public PluginLoginLoginIB() {
        super();
    }

    /**
     * @param propertyKeyBase
     */
    public PluginLoginLoginIB(String propertyKeyBase) {
        super(propertyKeyBase);
    }

    /**
     * @param propertyKeyBase
     * @param properties
     */
    public PluginLoginLoginIB(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
    }

    protected String getLoginIBMethodAuth() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "metodos_auth");
    }

    protected String getLoginIBEntidad() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "entidad");
    }

    protected String getLoginIBAplicacionCode() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "aplicacion");
    }

    protected String getLoginIBAplicacionDescription() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "aplicaciondescripcion");
    }

    protected String getLoginIBNivelQAA() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "nivel_qaa");
    }

    protected String getLoginIBUser() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "user");
    }

    protected String getLoginIBPassword() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "pass");
    }

    protected String getLoginIBUrl() throws Exception {
        return getPropertyRequired(PLUGIN_LOGINIB_PROPERTY_BASE + "url");
    }

    protected boolean isDebugEnabled() {
        return "true".equals(getProperty(PLUGIN_LOGINIB_PROPERTY_BASE + "debug"));
    }

    private static final HashSet<Character> EMPRESES = new HashSet<Character>();

    /**
     * 
     * A Sociedades anónimas. B Sociedades de responsabilidad limitada. C Sociedades
     * colectivas D Sociedades comanditarias E Comunidades de bienes y herencias
     * yacentes y demás entidades carentes de personalidad jurídica no incluidas
     * expresamente en otras claves. F Sociedades cooperativas G Asociaciones H
     * Comunidades de propietarios en régimen de propiedad horizontal J Sociedades
     * civiles P Corporaciones Locales Q Organismos públicos R Congregaciones e
     * instituciones religiosas S Órganos de la Administración del Estado y de las
     * Comunidades Autónomas U Uniones Temporales de Empresas V Otros tipos no
     * definidos en el resto de las claves
     * 
     */
    static {
        EMPRESES.add('A');
        EMPRESES.add('B');
        EMPRESES.add('C');
        EMPRESES.add('D');
        EMPRESES.add('E');
        EMPRESES.add('F');
        EMPRESES.add('G');
        EMPRESES.add('H');
        EMPRESES.add('J');
        EMPRESES.add('P');
        EMPRESES.add('Q');
        EMPRESES.add('R');
        EMPRESES.add('S');
        EMPRESES.add('U');
        EMPRESES.add('V');
    }

    public String startAuthentication(String urlCallBackLoginOk, String urCallBackLoginError, String language)
            throws Exception {

        log.info("  PluginLoginLoginIB::startAuthentication() ENTRA ... ");

        final RLoginParams param = new RLoginParams();
        param.setAplicacion(getLoginIBAplicacionCode());
        param.setEntidad(getLoginIBEntidad());
        param.setUrlCallback(urlCallBackLoginOk);
        param.setUrlCallbackError(urCallBackLoginError);
        param.setIdioma(language);
        param.setForzarAutenticacion(false);
        param.setQaa(Integer.parseInt(getLoginIBNivelQAA()));
        param.setMetodosAutenticacion(getLoginIBMethodAuth());
        param.setAplicacion(getLoginIBAplicacionCode());
        param.setInicioClaveAutomatico(true);

        /* RestTemplate Spring */
        final org.springframework.web.client.RestTemplate restTemplate = getLoginIbRestTemplate();

        final org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        final org.springframework.http.HttpEntity<RLoginParams> peticion;
        peticion = new org.springframework.http.HttpEntity<>(param, headers);
        final org.springframework.http.ResponseEntity<String> responseLoginIB = restTemplate.postForEntity(getLoginIBUrl() + "/login", peticion,
                String.class);

        if (isDebugEnabled()) {
            log.info("LoginIB: response: " + responseLoginIB.toString());
            log.info("LoginIB: URL: " + responseLoginIB.getBody());
        }

        String url = responseLoginIB.getBody();

        if (isDebugEnabled()) {
            log.info("LoginIB: URL LOGIN = " + url);
        }

        return url;

    }

    @Override
    public LoginInfo validateAuthenticationTicket(final String ticket) throws Exception {

        try {
            final org.springframework.web.client.RestTemplate restTemplate = getLoginIbRestTemplate();

            final RDatosAutenticacion datosAutenticacion = restTemplate
                    .getForObject(getLoginIBUrl() + "/ticket/" + ticket, RDatosAutenticacion.class);

            final boolean debug = isDebugEnabled();

            if (debug) {
                log.info("LoginIB:: NIF " + datosAutenticacion.getNif());
                log.info("LoginIB:: Name " + datosAutenticacion.getNombre());
                log.info("LoginIB:: Surname1 " + datosAutenticacion.getApellido1());
                log.info("LoginIB:: Surname2 " + datosAutenticacion.getApellido2());
                log.info("LoginIB:: AdministrationID" + datosAutenticacion.getNif());
                log.info("LoginIB:: AuthenticationMethod " + datosAutenticacion.getMetodoAutenticacion());
            }
            RDatosRepresentante rep = datosAutenticacion.getRepresentante();

            if (rep != null) {
                if (debug) {
                    log.info("Representant:: getNombre -> " + rep.getNombre());
                    log.info("Representant:: getApellido1-> " + rep.getApellido1());
                    log.info("Representant:: getApellido1 getApellido2 -> " + rep.getApellido2());
                    log.info("Representant:: getApellidos -> " + rep.getApellidos());
                    log.info("Representant:: getNif -> " + rep.getNif());
                }
            }

            final String username = datosAutenticacion.getNif();
            final String name = datosAutenticacion.getNombre();
            final String surname1 = datosAutenticacion.getApellido1();
            final String surname2 = datosAutenticacion.getApellido2();
            final String administrationID = datosAutenticacion.getNif();
            final String authenticationMethod = datosAutenticacion.getMetodoAutenticacion();
            int qaa;
            try {
                qaa = Integer.parseInt(datosAutenticacion.getQaa());
            } catch (Exception e) {
                log.error(" Nivell d'Autenticacio QAA desconegut ]" + datosAutenticacion.getQaa() + "[", e);
                qaa = LoginInfo.NIVELL_AUTENTICACIO_BAIX;
            }

            // S'ha mogut la petició al issue "LoginIB no retorna informació del Provider de
            // l'autenticacio #310 "
            // TODO este valor no viene informado por LoginIB, tendriamos que hablar
            // con loginIb a ver si pueden enviarnoslo.
            final String identityProvider = "Clave";

            boolean business;
            {
                char primera = administrationID.charAt(0);
                if (Character.isDigit(primera)) {
                    business = false;
                } else {

                    if (EMPRESES.contains(Character.valueOf(primera))) {
                        business = true;
                    } else {
                        business = false;
                    }
                }
            }

            LoginInfoRepresentative representative = null;
            if (rep == null) {
                representative = null;
            } else {
                representative = new LoginInfoRepresentative(rep.getNombre(), rep.getApellido1(), rep.getApellido2(),
                        rep.getNif());
            }

            final LoginInfo loginInfo = new LoginInfo(username, name, surname1, surname2, administrationID,
                    authenticationMethod, qaa, identityProvider, business, representative);
            
            // XYZ ZZZ 
            loginInfo.setLoginID("Cl@ve_" + System.currentTimeMillis());

            return loginInfo;
        } catch (Exception e) {
            log.error(" ERROR DESCONEGUT en validateAuthenticationTicket: " + e.getMessage(), e);
            throw e;
        }

    }

    public String logout(String urlCallBackLogout, String language) throws Exception {

        final org.springframework.web.client.RestTemplate restTemplate = getLoginIbRestTemplate();

        final RLogoutParams param = new RLogoutParams();
        param.setAplicacion(getLoginIBAplicacionCode());
        param.setEntidad(getLoginIBEntidad());
        param.setUrlCallback(urlCallBackLogout);
        param.setIdioma(language);
        final org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        final org.springframework.http.HttpEntity<RLogoutParams> request;
        request = new org.springframework.http.HttpEntity<>(param, headers);
        final org.springframework.http.ResponseEntity<String> responseTramite = restTemplate.postForEntity(getLoginIBUrl() + "/logout", request,
                String.class);

        String url = responseTramite.getBody();

        return url;
    }

    /**
     *
     * @return
     */
    private org.springframework.web.client.RestTemplate getLoginIbRestTemplate() throws Exception {

        final org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
        restTemplate.getInterceptors().add(new org.springframework.http.client.support.BasicAuthorizationInterceptor(getLoginIBUser(), getLoginIBPassword()));

        return restTemplate;
    }

    @Override
    public String getError(HttpServletRequest request, String language)  {
        
        StringBuffer errorStr = new StringBuffer();

        Map<String, String[]> map = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] val = entry.getValue();
            errorStr.append("KEY => ]" + key + "[ : {" + Arrays.toString(val) + "}\n");
        }
        
        if (errorStr.length() == 0) {
            return null;
        } else {
            log.error(errorStr.toString());
            return errorStr.toString();
        }
        
    }

    @Override
    public String getName(String language) {        
        return "Cl@veAutenticación";
    }

}
