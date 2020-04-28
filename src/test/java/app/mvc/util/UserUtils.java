package app.mvc.util;

import app.mvc.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtils {
    public static User createUser() {
        return User.builder()
                .credentialsId(123456L)
                .firstName("Ralph")
                .lastName("Peterson")
                .hobby("dancing")
                .musicPreferences("RNB")
                .age(23)
                .userId(100L)
                .build();
    }

    public static User invalidUser() {
        return User.builder()
                .credentialsId(123456L)
                .firstName("Sabrina")
                .lastName("Klein")
                .hobby("sport")
                .musicPreferences("country")
                .age(150)
                .build();
    }

    public static List<User> createUserList() {
        final User user1 = User.builder()
                .credentialsId(123456L)
                .firstName("Elmer")
                .lastName("Mcguire")
                .userId(155L)
                .hobby("procrastination")
                .musicPreferences("folk")
                .age(15)
                .build();


        final User user2 = User.builder()
                .credentialsId(987654L)
                .firstName("admin")
                .lastName("admin")
                .userId(225L)
                .hobby("f")
                .musicPreferences("polka")
                .build();

        return Arrays.asList(user1, user2);
    }

}
