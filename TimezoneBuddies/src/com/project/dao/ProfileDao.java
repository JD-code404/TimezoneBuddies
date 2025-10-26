package com.project.dao;

import java.sql.*;
import com.project.model.Profile;
import com.project.util.DatabaseConnection;

public class ProfileDao {

    public Profile getProfile(String username) {
        String sql = "SELECT * FROM users WHERE username=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Profile(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("phone"),
                    rs.getString("timezone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProfile(String username, String email, String phone, String timezone) {
        String sql = "UPDATE users SET email=?, phone=?, timezone=? WHERE username=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, timezone);
            ps.setString(4, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}