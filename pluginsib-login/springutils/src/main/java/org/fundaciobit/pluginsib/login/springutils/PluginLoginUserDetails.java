package org.fundaciobit.pluginsib.login.springutils;

import org.fundaciobit.pluginsib.login.api.LoginInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 
 * @author anadal
 *
 */
public class PluginLoginUserDetails implements UserDetails {

    private LoginInfo usuario;
    private Collection<GrantedAuthority> authorities;

    public LoginInfo getUsuario() {
        return usuario;
    }

    public void setUsuario(LoginInfo usuario) {
        this.usuario = usuario;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
