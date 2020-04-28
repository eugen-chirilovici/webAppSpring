package app.mvc.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String hobby;
    private String musicPreferences;
    int age;
}
