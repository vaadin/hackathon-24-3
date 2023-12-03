package com.vaadin.krisshk243.services;

import com.vaadin.krisshk243.security.AuthenticatedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class AdminService {


    public void addAdminRoleToUser(AuthenticatedUser authenticatedUser) {
        UserDetails userDetails = authenticatedUser.getUserDetails();

        Set<GrantedAuthority> authorities = new HashSet<>(userDetails.getAuthorities());
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.addAll(userDetails.getAuthorities());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authentication updatedAuthentication = new Authentication() {
            @Override
            public String getName() {
                return authentication.getName();
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return authorities;
            }

            @Override
            public Object getCredentials() {
                return authentication.getCredentials();
            }

            @Override
            public Object getDetails() {
                return authentication.getDetails();
            }

            @Override
            public Object getPrincipal() {
                return authentication.getPrincipal();
            }

            @Override
            public boolean isAuthenticated() {
                return authentication.isAuthenticated();
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            }
        };
        SecurityContextHolder.getContext().setAuthentication(updatedAuthentication);
    }
}