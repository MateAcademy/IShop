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
    public User getUserByEmail(String email) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM \"user\" left join user_role ur on \"user\".user_id = ur.user_id left join role r on r.role_id = ur.role_id  where email = ?";

        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password_not_encoded"));
                user.setOneRole(new Role(rs.getString("name")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getUserById(long userId) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM \"user\" where user_id = ?";

        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreateDate(LocalDateTime.ofInstant(rs.getTimestamp("create_date").toInstant(), ZoneId.systemDefault()));
                user.setUpdateDate(LocalDateTime.ofInstant(rs.getTimestamp("update_date").toInstant(), ZoneId.systemDefault()));
                user.setPasswordNotEncoded(rs.getString("password_not_encoded"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE \"user\" SET email = ?, password_not_encoded = ? WHERE user_id = ?";
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordNotEncoded());
            ps.setLong(3, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException sqlException) {

        }
    }

    @Override
    public void deleteUserById(long id) {
        String sql = "DELETE FROM \"user\" WHERE user_id = ?";
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
        }
    }
}
