package com.infnet.fitcoach_saas.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_INSTRUCTOR,
    ROLE_TRAINEE;

    @Override
    public String getAuthority() {
        return name();
    }
}
