package ua.ishop.klunniy.factory;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.controller.UserLoginServlet;
import ua.ishop.klunniy.service.UserService;
import ua.ishop.klunniy.service.imp.UserServiceImpl;

/**
 * @author Serhii Klunniy
 */
public class UserServiceFactory {
    private static final Logger logger = Logger.getLogger(UserServiceFactory.class);
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
