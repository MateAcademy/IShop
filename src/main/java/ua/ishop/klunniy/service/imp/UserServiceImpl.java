package ua.ishop.klunniy.service.imp;


import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.dao.impl.UserDaoImpl;
import ua.ishop.klunniy.dao.impl.UserDaoPostgresImpl;
import ua.ishop.klunniy.factory.UserDaoFactory;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserServiceImpl implements UserService {

    private static final UserDao userDao = UserDaoFactory.getUserDao();


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    ;
}
