package org.fundaciobit.pluginsib.login.springutils;

import org.fundaciobit.pluginsib.login.api.IPluginLogin;
import org.fundaciobit.pluginsib.login.api.LoginInfo;

/**
 * 
 * @author anadal
 *
 */
public interface PluginLoginSecurityService {

    /**
     *
     * @return
     * @throws Exception
     */
    public String iniciarSesionAutentificacion(IPluginLogin pluginLogin, String URL_CALLBACK_LOGIN,
            String URL_CALLBACK_ERROR, String IDIOMA) throws Exception;

    /**
     *
     * @param ticket
     * @return
     * @throws Exception
     */
    LoginInfo validarTicketAutentificacion(IPluginLogin pluginLogin, String ticket) throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    public String iniciarSesionLogout(IPluginLogin pluginLogin, String URL_CALLBACK_LOGOUT, String IDIOMA)
            throws Exception;
}
