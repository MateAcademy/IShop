package ua.ishop.klunniy.dao.impl;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.UserDao;
import ua.ishop.klunniy.model.User;
import ua.ishop.klunniy.util.DbConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Klunniy
 */
public class UserDaoPostgresImpl implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoPostgresImpl.class);

    @Override
    public void save(User user) {
        Connection connection = DbConnector.getConnection();
        String sql = "INSERT INTO Users(email , password_not_encoded, create_account) values (?, ?, ?)";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);

        try {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3,formatDateTime);

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<User> getUsers() {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM users";

        List<User> userList = new ArrayList<>();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                User user = new User(
                        rs.getLong("user_id"),
                        rs.getString("email"),
                        rs.getString("password_not_encoded"));

                userList.add(user);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM users where email=?";

        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password_not_encoded"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
