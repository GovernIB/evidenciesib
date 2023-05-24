package org.fundaciobit.pluginsib.login.springutils;

import org.apache.log4j.Logger;
import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 
 * @author anadal
 *
 */
@Component
public class PluginLoginAuthProvider implements AuthenticationProvider {

    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    PluginLoginSecurityService securityService;

    @Override
    public Authentication authenticate(Authentication authentication) {

        log.info("Dentro de AuthProvider");

        // Obtiene user/pass
        final String usuario = authentication.getName();
        final String passwd = authentication.getCredentials().toString();

        if (log.isDebugEnabled()) {
            log.info("Usuario: " + usuario);
        }

        LoginInfo usuarioLogin = null;

        try {

            usuarioLogin = securityService.validarTicketAutentificacion(PluginLoginManager.getPluginLogin(), passwd);

        } catch (Exception ie) {
            log.error("S'ha produit un error : " + ie.getMessage(), ie);
        }

        PluginLoginUserDetails usuarioAutenticado = new PluginLoginUserDetails();
        usuarioAutenticado.setUsuario(usuarioLogin);

        UsernamePasswordAuthenticationToken upat;
        upat = new UsernamePasswordAuthenticationToken(usuarioAutenticado, authentication.getCredentials(),
                usuarioAutenticado.getAuthorities());

        return upat;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
