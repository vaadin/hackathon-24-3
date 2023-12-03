package com.vaadin.krisshk243.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.krisshk243.data.User;
import com.vaadin.krisshk243.data.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticatedUser {

    private final UserRepository userRepository;
    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authenticationContext = authenticationContext;
    }

    @Transactional
    public Optional<User> get() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class)
                .map(userDetails -> userRepository.findByUsername(userDetails.getUsername()));
    }

    public UserDetails getUserDetails() {
        return authenticationContext.getAuthenticatedUser(UserDetails.class).orElseThrow(() ->
                new IllegalStateException("User is not authenticated"));
    }

    public void logout() {
        authenticationContext.logout();
    }

}
