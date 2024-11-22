package org.faeriefit.microusers.dto;


import lombok.Setter;
import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microentity.entity.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
    The CustomUserDetails class is created to implement a secure user and
    user representation so as not to change the entity itself
*/
public class CustomUserDetails extends User implements UserDetails {
    private final String password;
    private final String username;
    @Setter
    Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(User user){
        this.password = user.getPassword();
        this.username = user.getUsername();
        List<GrantedAuthority> auth = new ArrayList<>();

        for(Role role : user.getRoles()){
            auth.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        this.authorities = auth;
    }

    public CustomUserDetails(String password, String username) {
        this.password = password;
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
