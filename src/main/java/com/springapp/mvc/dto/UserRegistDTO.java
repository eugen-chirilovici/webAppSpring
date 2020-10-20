package com.springapp.mvc.dto;

public class UserRegistDTO {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int age;
    private String zodiacSign;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getZodiacSign() { return zodiacSign; }

    public void setZodiacSign(String zodiacSign) { this.zodiacSign = zodiacSign; }
}
