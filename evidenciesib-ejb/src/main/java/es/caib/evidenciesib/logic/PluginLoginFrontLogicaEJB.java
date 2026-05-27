package es.caib.evidenciesib.logic;

import es.caib.evidenciesib.commons.utils.Constants;

import javax.ejb.Stateless;

import org.fundaciobit.pluginsib.login.api.IPluginLogin;


/**
 * 
 * @author anadal (u80067)
 * 25 may 2026 15:04:23
 */
@Stateless
public class PluginLoginFrontLogicaEJB extends AbstractPluginLogicaEJB<IPluginLogin>
        implements PluginLoginFrontLogicaService {

    @Override
    public int getTipus() {
            return Constants.PLUGINSIB_TIPUS_LOGIN_FRONT;
    }

    @Override
    public String getName() {
        return "Plugin de Login de Front";
    };

}
