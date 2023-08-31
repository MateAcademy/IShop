package ua.ishop.klunniy.dao;

import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public interface UserDao {

    void save(User user);
    List<User> getUsers();

    User getUserByEmail(String email);
}
