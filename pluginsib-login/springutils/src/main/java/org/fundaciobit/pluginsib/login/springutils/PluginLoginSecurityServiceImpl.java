package org.fundaciobit.pluginsib.login.springutils;

import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.login.api.IPluginLogin;
import org.fundaciobit.pluginsib.login.api.LoginInfo;

import org.springframework.stereotype.Service;

/**
 * 
 * @author anadal
 *
 */
@Service
public class PluginLoginSecurityServiceImpl implements PluginLoginSecurityService {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public String iniciarSesionAutentificacion(IPluginLogin pluginLogin, String urlCallBackLoginOk,
            String urCallBackLoginError, String language) throws Exception {

        log.info("\n\n\nUrl CALLBACK: " + urlCallBackLoginOk + "\nURL ERROR: " + urCallBackLoginError + "\n\n\n");

        return pluginLogin.startAuthentication(urlCallBackLoginOk, urCallBackLoginError, language);

    }

    @Override
    public LoginInfo validarTicketAutentificacion(IPluginLogin pluginLogin, final String ticket) throws Exception {

        LoginInfo loginInfo = pluginLogin.validateAuthenticationTicket(ticket);
        return loginInfo;

    }

    @Override
    public String iniciarSesionLogout(IPluginLogin pluginLogin, String urlCallBackLogout, String language)
            throws Exception {

        String urlLogout = pluginLogin.logout(urlCallBackLogout, language);

        log.info("Url LOGOUT: " + urlLogout);

        return urlLogout;

    }

}
