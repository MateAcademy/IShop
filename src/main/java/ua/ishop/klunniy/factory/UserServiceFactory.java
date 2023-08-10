package ua.ishop.klunniy.factory;

import ua.ishop.klunniy.service.UserService;
import ua.ishop.klunniy.service.imp.UserServiceImpl;

/**
 * @author Serhii Klunniy
 */
public class UserServiceFactory {
    private static UserService instance;

    private UserServiceFactory() {
    }

    public static synchronized UserService getUserService() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
}
