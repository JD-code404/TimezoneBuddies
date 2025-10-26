package com.project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.project.model.Invite;
import com.project.util.DatabaseConnection;

public class InviteDao {

    public void sendInvite(String sender, String receiver, int meetingId) {
        String sql = "INSERT INTO invites (sender, receiver, meeting_id, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, sender);
            ps.setString(2, receiver);
            ps.setInt(3, meetingId);
            ps.setString(4, "Pending");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Invite> getInvitesForUser(String username) {
        List<Invite> invites = new ArrayList<>();
        String sql = "SELECT * FROM invites WHERE receiver = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Invite invite = new Invite(
                    rs.getInt("id"),
                    rs.getString("sender"),
                    rs.getString("receiver"),
                    rs.getInt("meeting_id"),
                    rs.getString("status")
                );
                invites.add(invite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invites;
    }

    public void updateInviteStatus(int inviteId, String newStatus) {
        String sql = "UPDATE invites SET status = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setInt(2, inviteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInvite(int inviteId) {
        String sql = "DELETE FROM invites WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, inviteId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}