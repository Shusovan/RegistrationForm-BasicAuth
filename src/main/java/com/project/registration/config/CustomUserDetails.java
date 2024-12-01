package com.project.registration.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.registration.model.User;

public class CustomUserDetails implements UserDetails
{
    private final User user;

    public CustomUserDetails(User user) 
    {
        super();
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return user.getRoles().stream()
                   .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                   .collect(Collectors.toList());
    }

    @Override
    public String getPassword() 
    {
        return user.getPassword();
    }

    @Override
    public String getUsername() 
    {
        return user.getUsername();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return true;
    }
}
