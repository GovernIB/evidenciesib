package es.caib.evidenciesib.front.config;

import org.fundaciobit.pluginsib.login.springutils.PluginLoginAuthProvider;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginController;
import org.fundaciobit.pluginsib.login.springutils.PluginLoginRequestCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import es.caib.evidenciesib.commons.utils.Constants;
import es.caib.evidenciesib.front.controller.EvidenciaLoginController;

/**
 * 
 * @author anadal
 *
 */
@Configuration
@EnableWebSecurity
@Profile("!https")
@ComponentScan(basePackages = { "es.caib.evidenciesib.front", "org.fundaciobit.pluginsib.login.springutils" })
public class EvidenciesIBSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PluginLoginAuthProvider pluginLoginAuthProvider;

    @Autowired
    private PluginLoginRequestCache loginRequestCache;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(pluginLoginAuthProvider);
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        DefaultHttpFirewall firewall = new DefaultHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/public/**", "/inici",
                        // Evidencies
                        EvidenciaLoginController.MAPPING_NO_REPUDI_POST+ "/**",
                        EvidenciaLoginController.THUMBNAIL_PDF_MASSIVE + "/**",
                        EvidenciaLoginController.MAPPING_FRONT_LOGIN_END  + "/**", 
                        Constants.MAPPING_FRONT_LOGIN_START + "/**",
                        "/public/setlocationpost/**",
                        // Plugin Login
                        PluginLoginController.MAPPING_PRELOGIN + "/**", PluginLoginController.MAPPING_LOGOUT, 
                        "/js/**", "/error", "/css/**", "/images/**", "/fonts/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().access("isAuthenticated()")
                .and()
                .csrf().requireCsrfProtectionMatcher(csrfMatcher())
                .and()
                .requestCache().requestCache(loginRequestCache)
                .and()
                .formLogin().loginPage(PluginLoginController.MAPPING_LOGIN).failureForwardUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl(PluginLoginController.MAPPING_LOGOUT)
                .and()
                .headers().frameOptions().sameOrigin();
        
    }

    @Bean
    AndRequestMatcher csrfMatcher() {
        AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher("/**/*.json", "POST");

        return new AndRequestMatcher(antPathRequestMatcher);
    }

}