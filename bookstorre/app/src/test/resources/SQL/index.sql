-- Create Admin table
CREATE TABLE IF NOT EXISTS Admin(
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);

-- Create Employee table
CREATE TABLE IF NOT EXISTS Employee(
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);

-- Continue with other CREATE TABLE statements and other SQL commands...

-- Create Book table
CREATE TABLE IF NOT EXISTS Book(
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(50) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Quantity INT NOT NULL,
    Status BOOLEAN NOT NULL,
    Description VARCHAR(50) NOT NULL,
    Image VARCHAR(50) NOT NULL,
    AuthorID INT,
    PublisherID INT,
    CategoryID INT,
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID),
    FOREIGN KEY (PublisherID) REFERENCES Publisher(PublisherID),
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- Create Category table
CREATE TABLE IF NOT EXISTS Category(
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50) NOT NULL,
    CategoryDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT,
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
);

-- Create Author table
CREATE TABLE IF NOT EXISTS Author(
    AuthorID INT AUTO_INCREMENT PRIMARY KEY,
    AuthorName VARCHAR(50) NOT NULL,
    AuthorDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT,
    FOREIGN KEY (BookID) REFERENCES Book(BookID)

);

-- Create Publisher table
CREATE TABLE IF NOT EXISTS Publisher(
    PublisherID INT AUTO_INCREMENT PRIMARY KEY,
    PublisherName VARCHAR(50) NOT NULL,
    PublisherDescription VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    BookID INT,
    FOREIGN KEY (BookID) REFERENCES Book(BookID)
);

-- Create Orders table
CREATE TABLE IF NOT EXISTS Orders(
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE NOT NULL,
    Total DECIMAL(10,2) NOT NULL,
    Status BOOLEAN NOT NULL,
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(UserID)
);

-- Create Customer table
CREATE TABLE IF NOT EXISTS Customer(
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Status BOOLEAN NOT NULL,
    Role VARCHAR(50) NOT NULL
);
