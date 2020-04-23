package com.springapp.mvc.model;

import com.springapp.mvc.model.enums.RoleType;
import lombok.*;

import java.util.Objects;

@Builder
public class Credentials {

    private long id;
    private String login;
    private String password;
    private RoleType role;

    public Credentials() {
    }

    public Credentials(long id, String login, String password, RoleType role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
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

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, role);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
