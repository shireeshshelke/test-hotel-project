-- Hotel Management System Database Setup
-- Run this script in MySQL to create the required database and tables

CREATE DATABASE IF NOT EXISTS hms;
USE hms;

-- Create login table for admin authentication
CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(40) PRIMARY KEY NOT NULL,
    password VARCHAR(40) NOT NULL
);

-- Insert default admin user
INSERT INTO login (username, password) VALUES ('admin', 'admin123');

-- Create room table
CREATE TABLE IF NOT EXISTS room (
    room_number INT(11) PRIMARY KEY NOT NULL,
    status VARCHAR(30) NOT NULL,
    price INT(11) NOT NULL,
    bed_type VARCHAR(30) NOT NULL,
    rtype VARCHAR(30) NOT NULL
);

-- Insert sample room data
INSERT INTO room (room_number, status, price, bed_type, rtype) VALUES
(101, 'empty', 1500, 'Single', 'AC'),
(102, 'empty', 2000, 'Double', 'AC'),
(103, 'empty', 1200, 'Single', 'Non-AC'),
(104, 'empty', 2500, 'Double', 'AC Deluxe'),
(105, 'empty', 1800, 'Double', 'AC'),
(201, 'empty', 1500, 'Single', 'AC'),
(202, 'empty', 2000, 'Double', 'AC'),
(203, 'empty', 1300, 'Single', 'Non-AC'),
(204, 'empty', 2800, 'Double', 'AC Deluxe'),
(205, 'empty', 1900, 'Double', 'AC');

-- Create customer table
CREATE TABLE IF NOT EXISTS customer (
    id VARCHAR(30) NOT NULL,
    number VARCHAR(30) PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    room_number INT(11) NOT NULL,
    room_price INT(11) NOT NULL,
    mob1 VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    datein VARCHAR(30) NOT NULL,
    dateout VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL
);

-- Display tables
SHOW TABLES;
SELECT 'Database setup completed successfully!' as Message;