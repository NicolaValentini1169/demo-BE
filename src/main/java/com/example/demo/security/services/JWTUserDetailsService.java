package com.example.demo.security.services;

import com.example.demo.security.constants.SecurityConstants;
import com.example.demo.security.entities.User;
import com.example.demo.security.entities.JWTUserDetail;
import com.example.demo.constants.ErrorsConstants;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JWTUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException(ErrorsConstants.WRONG_USERNAME));

        List<? extends GrantedAuthority> roles = Collections.singletonList(
                new SimpleGrantedAuthority(
                        user.getRole().getValue()));

        return new JWTUserDetail.Builder()
                .setId(user.getId())
                .setSub(user.getUsername())
                .setCn(user.getUsername())
                .setPassword(user.getPassword())
                .setRoles(roles)
                .setIat(System.currentTimeMillis())
                .setExp(System.currentTimeMillis() + SecurityConstants.EXIPIRATION_TIME)
                .build();
    }

}
