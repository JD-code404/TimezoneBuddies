package com.project.model;

public class Invite {
    private int id;
    private String sender;
    private String receiver;
    private int meetingId;
    private String status;

    public Invite() {}

    public Invite(int id, String sender, String receiver, int meetingId, String status) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.meetingId = meetingId;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }
    public int getMeetingId() { return meetingId; }
    public void setMeetingId(int meetingId) { this.meetingId = meetingId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}