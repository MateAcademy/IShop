package ua.ishop.klunniy.dao.impl;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.ProductDao;
import ua.ishop.klunniy.model.Product;
import ua.ishop.klunniy.model.Role;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.util.DbConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class ProductDaoJdbcImpl implements ProductDao {
    private static final Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    @Override
    public void save(Product product) {
        Connection connection = DbConnector.getConnection();
        String sql = "INSERT INTO \"product\"(name, price, description) values (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Product> getProducts() {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM \"product\" ORDER BY product_id";

        List<Product> productList = new ArrayList<>();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Product product = new Product(
                        rs.getLong("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return productList;
    }

    @Override
    public Product findProductByName(String name) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM \"product\"  where name = ?";

        Product product = new Product();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                product.setProductId(rs.getLong("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public Product getProductById(long productId) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM \"product\" where product_id = ?";

        Product product = new Product();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getLong("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE \"product\" SET name = ?, price = ?, description = ? WHERE product_id = ?";
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setLong(4, product.getProductId());
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    @Override
    public void deleteProductById(long productId) {
        String sql = "DELETE FROM \"product\" WHERE product_id = ?";
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, productId);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
        }
    }
}
