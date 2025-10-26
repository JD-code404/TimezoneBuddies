package com.project.model;

public class Profile {
    private String name;
    private String email;
    private String username;
    private String phone;
    private String timezone;

    public Profile() {}

    public Profile(String name, String email, String username, String phone, String timezone) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.timezone = timezone;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
}
