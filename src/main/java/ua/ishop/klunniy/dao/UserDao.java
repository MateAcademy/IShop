package ua.ishop.klunniy.dao;

import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public interface UserDao {

    void addUser(User user);
    List<User> getUsers();
}
