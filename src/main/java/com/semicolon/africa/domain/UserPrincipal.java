package com.semicolon.africa.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

        private Technician technician;

    public UserPrincipal(Technician technician){
        this.technician = technician;
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("Technician"));
    }

    @Override
    public String getPassword() {
        return technician.getPassword();
    }

    @Override
    public String getUsername() {
        return technician.getEmail();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
