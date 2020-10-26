package com.springapp.mvc.dto;

import com.springapp.mvc.model.enums.RoleType;

public class CredentialsDTO {

    private String login;
    private String password;
    private RoleType role;

    public CredentialsDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role.toString();
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
