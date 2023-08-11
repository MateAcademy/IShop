package ua.ishop.klunniy.factory;

import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.dao.impl.UserDaoImpl;
import ua.ishop.klunniy.dao.impl.UserDaoPostgresImpl;

/**
 * @author Serhii Klunniy
 */
public class UserDaoFactory {

    private static UserDao instance;

    private UserDaoFactory() {
    }

    public static synchronized UserDao getUserDao() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
}
