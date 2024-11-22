package org.faeriefit.microusers.service.impl;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.CustomUserDetails;
import org.faeriefit.microusers.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceDetailsImpl implements UserDetailsService {
    public final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userService.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("user is not exist");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user.get());
        List<GrantedAuthority> grantedAuthorities  = new ArrayList<>();

        for(Role role : user.get().getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole().toUpperCase()));
        }

        customUserDetails.setAuthorities(grantedAuthorities);
        return customUserDetails;
    }
}
