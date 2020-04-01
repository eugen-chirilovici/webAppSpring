package com.springapp.mvc.dto;

public class UserRegistDTO {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String hobby;
    private String musicPreferences;
    int age;

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

    public String getHobby() { return hobby; }

    public void setHobby(String hobby) { this.hobby = hobby; }

    public String getMusicPreferences() { return musicPreferences; }

    public void setMusicPreferences(String musicPreferences) { this.musicPreferences = musicPreferences; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }
}
