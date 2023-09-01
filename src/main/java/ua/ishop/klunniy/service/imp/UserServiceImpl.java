package ua.ishop.klunniy.service.imp;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.factory.UserDaoFactory;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.UserService;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static final UserDao userDao = UserDaoFactory.getUserDao();

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User findUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }
}
