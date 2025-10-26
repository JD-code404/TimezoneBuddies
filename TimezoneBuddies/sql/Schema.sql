CREATE DATABASE IF NOT EXISTS timezone_buddies;
USE timezone_buddies;

-- Users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    timezone VARCHAR(50) DEFAULT 'UTC',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Buddies table
CREATE TABLE buddies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user VARCHAR(50) NOT NULL,
    friend VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user) REFERENCES users(username) ON DELETE CASCADE,
    FOREIGN KEY (friend) REFERENCES users(username) ON DELETE CASCADE
);

-- Meetings table
CREATE TABLE meetings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    organizer VARCHAR(50) NOT NULL,
    participant VARCHAR(50) NOT NULL,
    date DATETIME NOT NULL,
    topic VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (organizer) REFERENCES users(username) ON DELETE CASCADE,
    FOREIGN KEY (participant) REFERENCES users(username) ON DELETE CASCADE
);

-- Invites table
CREATE TABLE invites (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender VARCHAR(50) NOT NULL,
    receiver VARCHAR(50) NOT NULL,
    meeting_id INT NOT NULL,
    status VARCHAR(20) DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender) REFERENCES users(username) ON DELETE CASCADE,
    FOREIGN KEY (receiver) REFERENCES users(username) ON DELETE CASCADE,
    FOREIGN KEY (meeting_id) REFERENCES meetings(id) ON DELETE CASCADE
);