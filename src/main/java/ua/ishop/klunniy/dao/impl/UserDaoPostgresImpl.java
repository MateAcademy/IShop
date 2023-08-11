package ua.ishop.klunniy.dao.impl;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.controller.UserLoginServlet;
import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserDaoPostgresImpl implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoPostgresImpl.class);

    @Override
    public void addUser(User user) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
