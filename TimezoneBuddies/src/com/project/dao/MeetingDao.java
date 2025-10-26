package com.project.dao;

import java.sql.*;
import java.util.*;
import com.project.model.Meeting;
import com.project.util.DatabaseConnection;

public class MeetingDao {

    public void scheduleMeeting(String user, String participant, String date, String topic) {
        String sql = "INSERT INTO meetings (organizer, participant, date, topic) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, participant);
            ps.setString(3, date);
            ps.setString(4, topic);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Meeting> getMeetings(String username) {
        List<Meeting> list = new ArrayList<>();
        String sql = "SELECT * FROM meetings WHERE organizer=? OR participant=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Meeting m = new Meeting(
                    rs.getInt("id"),
                    rs.getString("organizer"),
                    rs.getString("participant"),
                    rs.getString("date"),
                    rs.getString("topic")
                );
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cancelMeeting(int meetingId) {
        String sql = "DELETE FROM meetings WHERE id=?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, meetingId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}