package es.caib.evidenciesib.api.externa.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author anadal
 *
 */
@WebFilter(urlPatterns = { "/*" })
public class RedirectToIndexFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        final String uri = httpRequest.getRequestURI();

        /*
        
         log.info("============================================");
        
        log.info("getRequestURL: " + httpRequest.getRequestURL()); 
        
        log.info("getRequestURI: " + uri);
        */

        final String cp = httpRequest.getContextPath();
        //log.info("getContextPath: " + cp);

        String path = uri.substring(cp.length());
        //log.info("getPathInfo: " + path);

        if (path.startsWith("/public/") || path.startsWith("/secure/")) {
            chain.doFilter(request, response);
        } else if ("".equals(path) || "/".equals(path)) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.html");
        } else  {
            httpRequest.getServletContext().getNamedDispatcher("default").forward(request, response);
        }

    }

    @Override
    public void destroy() {
    }
}