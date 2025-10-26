package com.project.dao;

import java.sql.*;
import com.project.model.User;
import com.project.util.DatabaseConnection;

public class UserDao {

    public void registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, username, password, timezone) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getTimezone() != null ? user.getTimezone() : "UTC");
            ps.executeUpdate();
        }
    }

    public boolean validate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}