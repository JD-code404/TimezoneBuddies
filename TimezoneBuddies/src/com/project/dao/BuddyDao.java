package com.project.dao;

import java.sql.*;
import java.util.*;
import com.project.model.Buddy;
import com.project.util.DatabaseConnection;

public class BuddyDao {

    public List<Buddy> getBuddyList(String username) {
        List<Buddy> list = new ArrayList<>();
        String sql = "SELECT * FROM buddies WHERE user=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Buddy buddy = new Buddy(
                    rs.getInt("id"),
                    rs.getString("user"),
                    rs.getString("friend")
                );
                list.add(buddy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addBuddy(String user, String friend) {
        String sql = "INSERT INTO buddies (user, friend) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, friend);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeBuddy(String user, String friend) {
        String sql = "DELETE FROM buddies WHERE user=? AND friend=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, friend);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}