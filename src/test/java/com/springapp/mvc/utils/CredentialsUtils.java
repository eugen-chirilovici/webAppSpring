package com.springapp.mvc.utils;

import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;

import java.util.Arrays;
import java.util.List;

public class CredentialsUtils {

    public Credentials createCredentialsForUserRole() {
        return new Credentials(11L, "dcrudu", "password", RoleType.ROLE_USER);
    }


    public Credentials createCredentialsForAdminRole() {
        return new Credentials(10L, "admin", "admin", RoleType.ROLE_ADMIN);
    }

    public List<Credentials> credentialsList() {
        Credentials c1 = new Credentials(10L, "admin", "admin", RoleType.ROLE_ADMIN);
        Credentials c2 = new Credentials(11L, "dcrudu", "password", RoleType.ROLE_USER);
        return Arrays.asList(c1, c2);
    }
}
