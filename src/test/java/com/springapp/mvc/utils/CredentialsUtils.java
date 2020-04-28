package com.springapp.mvc.utils;

import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;


import java.util.Optional;

public class CredentialsUtils {

    public static Credentials createCredentialsForUserRole() {
        return Credentials.builder()
                .id(123456L)
                .password("test123")
                .login("denis")
                .role(RoleType.ROLE_USER)
                .build();
    }


    public static Credentials createCredentialsForAdminRole() {
        return Credentials.builder()
                .id(1111111L)
                .password("admin123")
                .login("admin")
                .role(RoleType.ROLE_ADMIN)
                .build();
    }

    public static Optional<Credentials> getByUsername() {
        return Optional.of(createCredentialsForUserRole());
    }
}
