package ua.ishop.klunniy.service;

import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public interface UserService {
    void addUser(User user);
    List<User> getUsers();

    User findUserByEmail(String email);
    User getUserById(long id);
    void updateUser(User user);
    void deleteUserById(long id);
}
