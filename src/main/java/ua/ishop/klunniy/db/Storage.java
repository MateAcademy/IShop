package ua.ishop.klunniy.db;

import ua.ishop.klunniy.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class Storage {
    private static final List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public static List<User> getUsers() {
        return users;
    }

}
