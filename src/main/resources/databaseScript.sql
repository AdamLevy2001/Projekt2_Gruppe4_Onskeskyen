DROP DATABASE IF EXISTS Onskeskyen;

CREATE DATABASE Onskeskyen;

USE Onskeskyen;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE ,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE wishlist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE wish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    price DECIMAL(10,2),
    link VARCHAR(255),
    wishlist_id INT,
    FOREIGN KEY (wishlist_id) REFERENCES wishlist(id) ON DELETE CASCADE
);

CREATE TABLE reservation (
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    wish_id INT,
    FOREIGN KEY (wish_id) REFERENCES wish(id) ON DELETE CASCADE,
    PRIMARY KEY(user_id, wish_id)
);