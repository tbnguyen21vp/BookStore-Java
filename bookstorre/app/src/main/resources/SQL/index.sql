

CREATE DATABASE IF NOT EXISTS book_store;

USE book_store;

CREATE TABLE IF NOT EXISTS `account` (
  `userID` BIGINT AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(255) NOT NULL,
  `status` BOOLEAN NOT NULL,
  `role` CHAR(10) NOT NULL,
  `firstname` VARCHAR(255),
  `lastname` VARCHAR(255),
  PRIMARY KEY (`userID`),
    CHECK (`role` IN ('admin', 'employee'))

);

CREATE TABLE IF NOT EXISTS `customer` (
  `customerID` BIGINT AUTO_INCREMENT,
  `accountID` BIGINT NOT NULL,
  PRIMARY KEY (`customerID`)
);

CREATE TABLE IF NOT EXISTS `author` (
  `authorID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`authorID`)
);

CREATE TABLE IF NOT EXISTS `publisher` (
  `publisherID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`publisherID`)
);

CREATE TABLE IF NOT EXISTS `category` (
  `categoryID` BIGINT AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `status` BOOLEAN NOT NULL,
  PRIMARY KEY (`categoryID`)
);

CREATE TABLE IF NOT EXISTS `book` (
  `bookID` BIGINT AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `author` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL,
  `status` BOOLEAN NOT NULL,
  `volume` BIGINT,
  `publisherID` BIGINT,
  `categoryID` BIGINT,
  `authorID` BIGINT,
  PRIMARY KEY (`bookID`),
  FOREIGN KEY (`publisherID`) REFERENCES `publisher` (`publisherID`) ON DELETE SET NULL,
  FOREIGN KEY (`categoryID`) REFERENCES `category` (`categoryID`) ON DELETE SET NULL,
  FOREIGN KEY (`authorID`) REFERENCES `author` (`authorID`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `order` (
  `orderID` BIGINT AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `customerID` BIGINT NOT NULL,
  `employeeID` BIGINT NOT NULL,
  `totalCost` DOUBLE NOT NULL,
  `discount` BIGINT NOT NULL,
  `status` BIGINT NOT NULL,
  PRIMARY KEY (`orderID`),
  FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE,
  FOREIGN KEY (`employeeID`) REFERENCES `account` (`userID`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `order_detail` (
  `id_order_detail` BIGINT AUTO_INCREMENT,
  `orderID` BIGINT NOT NULL,
  `bookID` BIGINT NOT NULL,
  `quantity` BIGINT NOT NULL,
  PRIMARY KEY (`id_order_detail`),
  FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`) ON DELETE CASCADE,
  FOREIGN KEY (`bookID`) REFERENCES `book` (`bookID`) ON DELETE CASCADE
);
-- 


-- Insert demo data into `account`
INSERT INTO `account` (username, password, status, role, firstname, lastname) VALUES 
('johnsddoe', 'hashsdfed_password1', true, 'admin', 'John', 'Doe'),
('janeddsfdoe', 'hasdsdfhed_password2', true, 'user', 'Jane', 'Doe');

-- Insert demo data into `customer`
-- Assuming that customer is also an account, and the accountID should reference userID.
INSERT INTO `customer` (accountID) VALUES 
((SELECT userID FROM `account` WHERE username = 'johndoe')),
((SELECT userID FROM `account` WHERE username = 'janedoe'));

-- Insert demo data into `author`
INSERT INTO `author` (name, status) VALUES 
('Mark Twain', true),
('J.K. Rowling', true);

-- Insert demo data into `publisher`
INSERT INTO `publisher` (name, description, status) VALUES 
('Penguin Books', 'International publishing company.', true),
('HarperCollins', 'One of the world’s largest publishing companies.', true);

-- Insert demo data into `category`
INSERT INTO `category` (name, description, status) VALUES 
('Fiction', 'Includes novels and short stories.', true),
('Non-Fiction', 'Includes biographies and history books.', true);

-- Insert demo data into `book`
INSERT INTO `book` (title, author, price, status, volume, publisherID, categoryID, authorID) VALUES 
('The Adventures of Tom Sawyer', 'Mark Twain', 12.99, true, 1, 
(SELECT publisherID FROM `publisher` WHERE name = 'Penguin Books'),
(SELECT categoryID FROM `category` WHERE name = 'Fiction'),
(SELECT authorID FROM `author` WHERE name = 'Mark Twain'));

-- Insert demo data into `order`
-- Assuming `employeeID` references an account with a role that represents an employee.
INSERT INTO `order` (date, customerID, employeeID, totalCost, discount, status) VALUES 
(CURDATE(), (SELECT customerID FROM `customer` WHERE accountID = (SELECT userID FROM `account` WHERE username = 'johndoe')), 
(SELECT userID FROM `account` WHERE role = 'admin'), 100.00, 10, 1);

-- Insert demo data into `order_detail`
-- This assumes that `order_detail` references an `order` and a `book`.
INSERT INTO `order_detail` (orderID, bookID, quantity) VALUES 
((SELECT orderID FROM `order` WHERE customerID = (SELECT customerID FROM `customer` WHERE accountID = (SELECT userID FROM `account` WHERE username = 'johndoe'))), 
(SELECT bookID FROM `book` WHERE title = 'The Adventures of Tom Sawyer'), 2);



SELECT * FROM `account`;
SELECT * FROM `customer`;
SELECT * FROM `author`;
SELECT * FROM `publisher`;
SELECT * FROM `category`;
SELECT * FROM `book`;
SELECT * FROM `order`;
SELECT * FROM `order_detail`;


