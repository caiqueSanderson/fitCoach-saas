package com.infnet.main_service.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_INSTRUCTOR,
    ROLE_TRAINEE;

    @Override
    public String getAuthority() {
        return name();
    }
}
