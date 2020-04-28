package com.springapp.mvc.utils;



import com.springapp.mvc.model.User;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
public class UserUtils {

        public static User createUser() {
            return User.builder()
                    .userId(3L)
                    .firstName("Denis")
                    .lastName("Gurduza")
                    .credentialsId(123456L)
                    .build();

        }

    @Override
    public String toString() {
        return "UserUtils{}";
    }

    public static List<User> createUserList() {
            long id = 0L;
            final List<User> listOfUsers = new ArrayList<>();
            listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L));
            listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L));
            listOfUsers.add(new User(id++, "Filip", "Rosca", 2L));
            listOfUsers.add(new User(id++, "Denis", "Gurduza", 123456L));
            return listOfUsers;
        }


    }
