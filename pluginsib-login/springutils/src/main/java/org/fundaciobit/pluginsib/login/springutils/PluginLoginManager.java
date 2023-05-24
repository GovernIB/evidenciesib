package org.fundaciobit.pluginsib.login.springutils;

import org.fundaciobit.pluginsib.login.api.IPluginLogin;

/**
 * 
 * @author anadal
 *
 */
public class PluginLoginManager {

    private static IPluginLogin pluginLogin = null;

    public static IPluginLogin getPluginLogin() {
        return pluginLogin;
    }

    public static void setPluginLogin(IPluginLogin pluginLogin) {
        PluginLoginManager.pluginLogin = pluginLogin;
    }

}
