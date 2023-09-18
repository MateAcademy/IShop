package ua.ishop.klunniy.factory;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.service.ProductService;
import ua.ishop.klunniy.service.UserService;
import ua.ishop.klunniy.service.imp.ProductServiceImpl;
import ua.ishop.klunniy.service.imp.UserServiceImpl;

/**
 * @author Serhii Klunniy
 */
public class ProductServiceFactory {
    private static final Logger logger = Logger.getLogger(ProductServiceFactory.class);
    private static ProductService instance;

    private ProductServiceFactory() {
    }

    public static synchronized ProductService getProductService() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }
}
