package org.fundaciobit.pluginsib.login.springutils;

import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author anadal
 *
 */
@Component
public class PluginLoginRequestCache extends HttpSessionRequestCache {

    /** Nombre con el que se almacena el saved request. */
    public static final String SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        final DefaultSavedRequest savedRequest = new DefaultSavedRequest(request, new PortResolverImpl());
        request.getSession().setAttribute(SAVED_REQUEST, savedRequest);
    }
}