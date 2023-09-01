package ua.ishop.klunniy.dao.impl;

import org.apache.log4j.Logger;
import ua.ishop.klunniy.dao.UserDao;
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
public class UserDaoPostgresImpl implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoPostgresImpl.class);

    @Override
    public void save(User user) {
        Connection connection = DbConnector.getConnection();
        String sql = "INSERT INTO Users(email, password, password_not_encoded, update_date) values (?, ?, ?, ?::timestamp)";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);

        try {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, "123");
            ps.setString(3, user.getPasswordNotEncoded());
            ps.setString(4, formatDateTime);

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
                        rs.getString("password"),
                        rs.getString("password_not_encoded"),
                        LocalDateTime.ofInstant(rs.getTimestamp("create_date").toInstant(), ZoneId.systemDefault()),
                        LocalDateTime.ofInstant(rs.getTimestamp("update_date").toInstant(), ZoneId.systemDefault()));
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
        String sql = "SELECT * FROM users where email = ?";

        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setUserId(rs.getLong("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password_not_encoded"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getUserById(long userId) {
        Connection connection = DbConnector.getConnection();
        String sql = "SELECT * FROM users where user_id = ?";

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
        String sql = "UPDATE Users SET email = ?, password_not_encoded = ? WHERE user_id = ?";
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
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try {
            Connection connection = DbConnector.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {

        }
    }
}
