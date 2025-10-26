# Timezone Buddies

A Java web application for managing buddies and scheduling meetings across different timezones using JSP, Servlets, JDBC, and MySQL.

## Features

- User Registration & Authentication
- User Profile Management with Timezone Support
- Buddy/Friend Management System
- Meeting Scheduling with Timezone Awareness
- Meeting Invitations System

## Tech Stack

- **Backend:** Java Servlets, JSP, JDBC
- **Database:** MySQL
- **Server:** Apache Tomcat
- **IDE:** VS Code

## Setup Instructions

### 1. Database Setup
```bash
mysql -u root -p < sql/schema.sql
```

### 2. Configure Database Connection
Edit `src/com/project/util/DatabaseConnection.java`:
- Update `URL`, `USER`, and `PASSWORD`

### 3. Deploy to Tomcat
- Copy project to Tomcat `webapps` folder
- Or use VS Code Tomcat extension

### 4. Access Application
```
http://localhost:8080/TimezoneBuddies/login.jsp
```

## Project Structure

```
TimezoneBuddies/
├── src/com/project/
│   ├── web/          # Servlets
│   ├── dao/          # Data Access Objects
│   ├── model/        # Entity Classes
│   └── util/         # Utilities
├── webapp/
│   ├── WEB-INF/
│   └── *.jsp         # JSP Pages
└── sql/              # Database Scripts
```

## Contributors

Your Name

## License

MIT License
```

---

## 🚀 FINAL STEP: Push to GitHub

After creating all files, run these commands in your terminal:

```bash
cd TimezoneBuddies
git init
git add .
git commit -m "Initial commit: Timezone Buddies project"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/TimezoneBuddies.git
git push -u origin main
