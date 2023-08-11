package ua.ishop.klunniy.dao.impl;

import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.db.Storage;
import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        if (user != null) {
            Storage.addUser(user);
        }
    }

    @Override
    public List<User> getUsers() {
        return Storage.getUsers();
    }

    public User getUserByEmail(String email) {
        return Storage.getUserByEmail(email);
    };
}
