-- Create Admin table
CREATE TABLE IF NOT EXISTS Admin (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);

-- Create Employee table
CREATE TABLE IF NOT EXISTS Employee (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);

-- Create Book table
CREATE TABLE IF NOT EXISTS Book (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(50) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Quantity INT NOT NULL,
    Status BOOLEAN NOT NULL,
    Description VARCHAR(50) NOT NULL,
    Image VARCHAR(50) NOT NULL,
    AuthorID INT,
    PublisherID INT,
    CategoryID INT

);

-- Create Category table
CREATE TABLE IF NOT EXISTS Category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50) NOT NULL,
    CategoryDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT
);

-- Create Author table
CREATE TABLE IF NOT EXISTS Author (
    AuthorID INT AUTO_INCREMENT PRIMARY KEY,
    AuthorName VARCHAR(50) NOT NULL,
    AuthorDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT
);

-- Create Publisher table
CREATE TABLE IF NOT EXISTS Publisher (
    PublisherID INT AUTO_INCREMENT PRIMARY KEY,
    PublisherName VARCHAR(50) NOT NULL,
    PublisherDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT
);

-- Create Orders table
CREATE TABLE IF NOT EXISTS Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE NOT NULL,
    Total DECIMAL(10,2) NOT NULL,
    Status BOOLEAN NOT NULL,
    CustomerID INT
);

-- Create Customer table
CREATE TABLE IF NOT EXISTS Customer (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);




--  add foreign key constraints to the Book table
ALTER TABLE Book
ADD FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
ADD FOREIGN KEY (PublisherID) REFERENCES Publisher(PublisherID),
ADD FOREIGN KEY (CategoryID) REFERENCES
Category(CategoryID);

--  add foreign key constraints to the Category table

ALTER TABLE Category
ADD FOREIGN KEY (BookID) REFERENCES Book(BookID);

--  add foreign key constraints to the Author table

ALTER TABLE Author
ADD FOREIGN KEY (BookID) REFERENCES Book(BookID);

--  add foreign key constraints to the Publisher table

ALTER TABLE Publisher
ADD FOREIGN KEY (BookID) REFERENCES Book(BookID);

--  add foreign key constraints to the Orders table

ALTER TABLE Orders
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(UserID);



--  add data to the Admin table
INSERT INTO Admin (Username, FirstName, LastName, Status, Role)
VALUES ('admin', 'admin', 'admin', 1, 'admin'),
VALUES ('admin2', 'admin2', 'admin2', 1, 'admin');

--  add data to the Employee table

INSERT INTO Employee (Username, FirstName, LastName, Status, Role)
VALUES ('employee', 'employee', 'employee', 1, 'employee'),
('employee2', 'employee2', 'employee2', 1, 'employee'),
('employee3', 'employee3', 'employee3', 1, 'employee');

--  add data to the Book table

INSERT INTO Book (Title, Price, Quantity, Status, Description, Image, AuthorID, PublisherID, CategoryID)
VALUES ('Book1', 10.00, 100, 1, 'Description1', 'Image1', 1, 1, 1),
('Book2', 20.00, 200, 1, 'Description2', 'Image2', 2, 2, 2),
('Book3', 30.00, 300, 1, 'Description3', 'Image3', 3, 3, 3),
('Book4', 40.00, 400, 1, 'Description4', 'Image4', 4, 4, 4),
('Book5', 50.00, 500, 1, 'Description5', 'Image5', 5, 5, 5);

--  add data to the Category table

INSERT INTO Category (CategoryName, CategoryDescription, Status, BookID)
VALUES ('Category1', 'CategoryDescription1', 1, 1),
('Category2', 'CategoryDescription2', 1, 2),
('Category3', 'CategoryDescription3', 1, 3),
('Category4', 'CategoryDescription4', 1, 4),
('Category5', 'CategoryDescription5', 1, 5);

--  add data to the Author table

INSERT INTO Author (AuthorName, AuthorDescription, Status, BookID)
VALUES ('Author1', 'AuthorDescription1', 1, 1),
('Author2', 'AuthorDescription2', 1, 2),
('Author3', 'AuthorDescription3', 1, 3),
('Author4', 'AuthorDescription4', 1, 4),
('Author5', 'AuthorDescription5', 1, 5);

--  add data to the Publisher table

INSERT INTO Publisher (PublisherName, PublisherDescription, Status, BookID)

VALUES ('Publisher1', 'PublisherDescription1', 1, 1),
('Publisher2', 'PublisherDescription2', 1, 2),
('Publisher3', 'PublisherDescription3', 1, 3),
('Publisher4', 'PublisherDescription4', 1, 4),
('Publisher5', 'PublisherDescription5', 1, 5);

--  add data to the Orders table

INSERT INTO Orders (OrderDate, Total, Status, CustomerID)
VALUES ('2021-01-01', 100.00, 1, 1),
('2021-02-02', 200.00, 1, 2),
('2021-03-03', 300.00, 1, 3),
('2021-04-04', 400.00, 1, 4),
('2021-05-05', 500.00, 1, 5);

--  add data to the Customer table

INSERT INTO Customer (Username, FirstName, LastName, Status, Role)

VALUES ('customer1', 'customer1', 'customer1', 1, 'customer'),
('customer2', 'customer2', 'customer2', 1, 'customer'),
('customer3', 'customer3', 'customer3', 1, 'customer'),
('customer4', 'customer4', 'customer4', 1, 'customer'),
('customer5', 'customer5', 'customer5', 1, 'customer');

