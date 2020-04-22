package com.springapp.mvc.dto;


public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String hobby;
    private String musicPreferences;
    int age;

    public UserDTO(Long id, String firstName, String lastName, String hobby, String musicPreferences, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.musicPreferences = musicPreferences;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMusicPreferences() {
        return musicPreferences;
    }

    public void setMusicPreferences(String musicPreferences) {
        this.musicPreferences = musicPreferences;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
