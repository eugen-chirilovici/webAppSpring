package app.mvc.util;

import app.mvc.dto.UserRegistDTO;

public class UserRegistDTOUtils {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String hobby;
    private String musicPreferences;
    int age;
    public static UserRegistDTO registUser() {
        return UserRegistDTO.builder()
                .firstName("Leo")
                .lastName("Rios")
                .age(23)
                .hobby("swimming")
                .musicPreferences("pop")
                .password("class")
                .build();
    }

    public static UserRegistDTO createInvalidUser() {
        return UserRegistDTO.builder()
                .firstName("Raquel")
                .lastName("Chavez")
                .age(151)
                .hobby("swimming")
                .musicPreferences("pop")
                .password("class")
                .build();
    }
}
