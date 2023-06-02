package org.fundaciobit.pluginsib.login.api;

import javax.servlet.http.HttpServletRequest;

import org.fundaciobit.pluginsib.core.IPlugin;

/**
 * 
 * @author anadal
 *
 */
public interface IPluginLogin extends IPlugin {

    public static final String PLUGIN_LOGIN_PROPERTY_BASE = IPLUGINSIB_BASE_PROPERTIES + "login.";

    /**
     * 
     * @param language
     * @return
     */
    public String getName(String language);

    /**
     * 
     * @param urlCallBackLoginOk
     * @param urCallBackLoginError
     * @param language
     * @return
     * @throws Exception
     */
    public String startAuthentication(String urlCallBackLoginOk, String urCallBackLoginError, String language)
            throws Exception;

    /**
     * 
     * @param ticket
     * @return
     * @throws Exception
     */
    public LoginInfo validateAuthenticationTicket(final String ticket) throws Exception;

    /**
     * 
     * @param urlCallBackLogout
     * @param language
     * @return
     * @throws Exception
     */
    public String logout(String urlCallBackLogout, String language) throws Exception;

    public String getError(HttpServletRequest request, String language);
}
