package ua.ishop.klunniy.dao.impl;

import ua.ishop.klunniy.dao.CodeDao;
import ua.ishop.klunniy.model.Code;
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
public class CodeDaoImpl implements CodeDao {
    @Override
    public void add(Code code) {
        Connection connection = DbConnector.getConnection();
        String sql = "INSERT INTO \"code\"(value, user_id) values (?, ?)";

        try {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, code.getValue());
            ps.setLong(2, code.getUser().getUserId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Code getCode(User user) {
//        Connection connection = DbConnector.getConnection();
//        String sql = "SELECT * FROM \"code\" where user_id = ? order by id DESC LIMIT 1";
//
//
//        try {
//            assert connection != null;
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setLong(user.getUserId());
//
//            ResultSet rs = ps.executeQuery(sql);
//
//            while (rs.next()) {
//                Code code = new Code(
//                        rs.getLong("id"),
//                        rs.getString("value"),
//                        rs.getString("user_id"));
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//        return userList;
        return null;
    }
}
