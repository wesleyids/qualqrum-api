package br.com.qualqrum.api.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.qualqrum.api.service.CustomUserDetailsService;

@Component
public class CustomIdentityAuthenticationProvider
        implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // TODO:
    // In this function we need to connect with identity provider
    // and validate the user
    // we are hardcoding for a single user for demo purposes
    UserDetails isValidUser(String username, String password) {
        // if (username.equalsIgnoreCase("user")
        // && password.equals("password")) {
        // UserDetails user = User
        // .withUsername(username)
        // .password("NOT_DISCLOSED")
        // .roles("USER_ROLE")
        // .build();
        // return user;
        // }

        UserDetails user = customUserDetailsService.loadUserByUsername(username);
        if (user != null) {
            return User.withUsername(username)
                    .password("NOT_DISCLOSED")
                    .roles("USER_ROLE")
                    .build();
        }
        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = isValidUser(username, password);

        if (userDetails != null) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    userDetails.getAuthorities());
        }

        throw new BadCredentialsException("Incorrect user credentials !!");
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType
                .equals(UsernamePasswordAuthenticationToken.class);
    }
}