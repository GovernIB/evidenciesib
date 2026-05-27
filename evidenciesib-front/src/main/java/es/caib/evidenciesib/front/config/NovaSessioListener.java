package es.caib.evidenciesib.front.config;

import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.pluginsib.login.api.IPluginLogin;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginManager;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import es.caib.evidenciesib.commons.utils.Configuracio;
import es.caib.evidenciesib.logic.PluginLoginFrontLogicaService;
import es.caib.evidenciesib.logic.utils.I18NLogicUtils;

/**
 * Quan es crea una nova sessió, s’executa sessionCreated
 * @author anadal (u80067)
 * 26 may 2026 8:52:12
 */
@Component
@WebListener
public class NovaSessioListener implements HttpSessionListener {

    protected Logger log = Logger.getLogger(getClass());

    @EJB(mappedName = PluginLoginFrontLogicaService.JNDI_NAME)
    protected PluginLoginFrontLogicaService pluginLoginFrontLogicaEjb;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Aquí pots posar la tasca que vols executar
        System.out.println("\n\nNova sessió creada: " + se.getSession().getId() + "\n\n");

        log.info("\n\nNova sessió creada: " + se.getSession().getId() + "\n\n");

        try {

            IPluginLogin loginp = pluginLoginFrontLogicaEjb.getCurrentEnabledInstance();

            if (loginp == null) {
                throw new I18NException("No hi ha cap Plugin de Login de Front habilitat");

            }

            PluginLoginManager.setPluginLogin(loginp);
        } catch (Throwable th) {

            String msg;

            if (th instanceof I18NException) {
                msg = I18NLogicUtils.getMessage((I18NException) th, new Locale(Configuracio.getDefaultLanguage()));
            } else {
                msg = th.getMessage();
            }

            msg = "Error al carregar el Plugin de Login de Front: " + msg;

            log.error(msg, th);

            throw new RuntimeException(msg, th);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Opcional: codi quan la sessió es destrueix
    }
}
