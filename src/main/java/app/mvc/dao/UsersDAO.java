package app.mvc.dao;

import app.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L, "Something", "SomeType", 23));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L, "Dancing", "Rock", 435));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, "Some hobby", "Something",34));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getHobby(),
                user.getMusicPreferences(), user.getAge()));
        return userId;
    }

    public void deleteUsers(long l) {
        listOfUsers.remove((int)l);
    }

    public Optional<User> findUserById(Long userId) {
        return listOfUsers.stream()
                .filter(t->t.getUserId().equals(userId))
                .findAny();
    }

    public User findById(Long userId) {
        for (User user : listOfUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public Optional<User> findUserByCredentialsId(long credentialsId) {
        return listOfUsers.stream()
                .filter(t -> t.getCredentialsId().equals(credentialsId))
                .findAny();
    }

    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        UsersDAO.listOfUsers = listOfUsers;
    }

}
