package ua.ishop.klunniy.factory;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.ProductDao;
import ua.ishop.klunniy.dao.impl.ProductDaoJdbcImpl;

/**
 * @author Serhii Klunniy
 */
public class ProductDaoFactory {
    private static final Logger logger = Logger.getLogger(ProductDaoFactory.class);

    private static ProductDao instance;

    private ProductDaoFactory() {
    }

    public static synchronized ProductDao getProductDao() {
        if (instance == null) {
            instance = new ProductDaoJdbcImpl();
        }
        return instance;
    }
}