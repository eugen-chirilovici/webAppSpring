package com.springapp.mvc.model;

import java.util.Objects;

public class User {
    private String name;
    private String password;
    private Genders genders;

    public User(){}

    public User(String name, String password, Genders genders) {
        this.name = name;
        this.password = password;
        this.genders = genders;
    }

    public Genders getGenders() {
        return genders;
    }

    public void setGenders(Genders genders) {
        this.genders = genders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                genders == user.genders;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, genders);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", genders=" + genders +
                '}';
    }
}
