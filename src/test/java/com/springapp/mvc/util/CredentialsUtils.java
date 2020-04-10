package com.springapp.mvc.util;

import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;

public class CredentialsUtils {
    public static Credentials createCredentialsForAdminRole() {
        return new Credentials(17L, "sdanila", "test", RoleType.ROLE_ADMIN);
    }

    public static Credentials createCredentialsForUserRole() {
        return new Credentials(17L, "adoe", "test", RoleType.ROLE_USER);
    }
}
