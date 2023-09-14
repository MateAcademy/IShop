package ua.ishop.klunniy.service;

import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.model.User;

import java.util.List;

/**
 * @author Serhii Klunniy
 */
public interface ProductService {

    void save(Product product);

    List<Product> getProducts();

    Product findProductByName(String name);
    User getProductById(long id);
    void updateProduct(Product product);
    void deleteProductById(long id);

}
