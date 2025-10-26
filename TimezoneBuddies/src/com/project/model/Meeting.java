package com.project.model;

public class Meeting {
    private int id;
    private String organizer;
    private String participant;
    private String date;
    private String topic;

    public Meeting() {}

    public Meeting(int id, String organizer, String participant, String date, String topic) {
        this.id = id;
        this.organizer = organizer;
        this.participant = participant;
        this.date = date;
        this.topic = topic;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getOrganizer() { return organizer; }
    public void setOrganizer(String organizer) { this.organizer = organizer; }
    public String getParticipant() { return participant; }
    public void setParticipant(String participant) { this.participant = participant; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
}