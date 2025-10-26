package com.project.model;

public class Buddy {
    private int id;
    private String user;
    private String friend;

    public Buddy() {}

    public Buddy(int id, String user, String friend) {
        this.id = id;
        this.user = user;
        this.friend = friend;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getFriend() { return friend; }
    public void setFriend(String friend) { this.friend = friend; }
}
