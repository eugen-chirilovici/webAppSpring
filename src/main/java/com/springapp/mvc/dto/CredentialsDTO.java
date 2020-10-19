package com.springapp.mvc.dto;

public class CredentialsDTO {

    private String login;
    private String password;
    private String roleType;

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

    public String getRoleType(){
        return roleType;
    }
}
