package ua.ishop.klunniy.service.imp;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.ProductDao;
import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.factory.ProductDaoFactory;
import ua.ishop.klunniy.factory.UserDaoFactory;
import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.service.ProductService;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);
    private static final ProductDao productDao = ProductDaoFactory.getProductDao();

    @Override
    public void save(Product product) {
         productDao.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public User getProductById(long id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(long id) {

    }
}
