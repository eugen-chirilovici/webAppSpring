package com.springapp.mvc.model.enums;

import lombok.Getter;

@Getter
public enum RoleType {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    String value;

    RoleType(String value) {
        this.value = value;
    }
}
