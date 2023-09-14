package ua.ishop.klunniy.dao;

import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public interface ProductDao {
    void save(Product product);
    List<Product> getProducts();

    Product findProductByName(String name);
    Product getProductById(long id);
    void updateProduct(Product product);
    void deleteProductById(long id);
}
