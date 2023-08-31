package ua.ishop.klunniy.dao.impl;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.db.Storage;
import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserDaoImpl implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void save(User user) {
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
