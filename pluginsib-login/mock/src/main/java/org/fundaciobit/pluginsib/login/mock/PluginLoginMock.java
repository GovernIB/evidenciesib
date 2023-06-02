package org.fundaciobit.pluginsib.login.mock;

import java.util.Properties;

import org.fundaciobit.pluginsib.login.api.AbstractPluginLogin;
import org.fundaciobit.pluginsib.login.api.ConstantsLogin;
import org.fundaciobit.pluginsib.login.api.LoginInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author anadal
 *
 */
public class PluginLoginMock extends AbstractPluginLogin {

    private static final String PLUGIN_MOCK_PROPERTY_BASE = PLUGIN_LOGIN_PROPERTY_BASE + "mock.";

    public PluginLoginMock() {
        super();
    }

    /**
     * @param propertyKeyBase
     */
    public PluginLoginMock(String propertyKeyBase) {
        super(propertyKeyBase);
    }

    /**cd evi   
     * @param propertyKeyBase
     * @param properties
     */
    public PluginLoginMock(String propertyKeyBase, Properties properties) {
        super(propertyKeyBase, properties);
    }

    @Override
    public String startAuthentication(String urlCallBackLoginOk, String urCallBackLoginError, String language)
            throws Exception {
        log.info("Start authentication with MOCK");
        return urlCallBackLoginOk + "?" + ConstantsLogin.TICKET_PARAM + "=" + System.currentTimeMillis();
    }

    @Override
    public LoginInfo validateAuthenticationTicket(String ticket) throws Exception {

        log.error("\n\n MOCK => class:   " + this);
        log.error("\n\n MOCK => base:   |" + this.getPropertyKeyBase() + "|");
        log.error("\n\n MOCK => propname[" + PLUGIN_MOCK_PROPERTY_BASE + "logininfo" + "]:   |" + this.getPropertyName(PLUGIN_MOCK_PROPERTY_BASE + "logininfo") + "|");

        String json = getPropertyRequired(PLUGIN_MOCK_PROPERTY_BASE + "logininfo");
        Gson gson = new GsonBuilder().create();
        try {
            LoginInfo logininfo = gson.fromJson(json, LoginInfo.class);
            
            logininfo.setLoginID("Mock_" + System.currentTimeMillis());
            
            return logininfo;
        } catch (Exception e) {
            String msg = "Error no controlat deserialitzant una estructura json de la classe LoginInfo: "
                    + e.getMessage();
            log.error(msg, e);
            throw new Exception(msg, e);
        }

    }

    @Override
    public String logout(String urlCallBackLogout, String language) throws Exception {

        return urlCallBackLogout;
    }

    @Override
    public String getError(javax.servlet.http.HttpServletRequest request, String language) {
        return null;
    }
    
    
    @Override
    public String getName(String language) {        
        return "Mock";
    }

}
