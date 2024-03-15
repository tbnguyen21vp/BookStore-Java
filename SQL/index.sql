-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS Bookstore;
USE Bookstore;

-- Tạo bảng người dùng
CREATE TABLE IF NOT EXISTS Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL,
    Role ENUM('Admin', 'Employee') NOT NULL,
    IsActive BOOLEAN DEFAULT TRUE,
    LastLogin TIMESTAMP
);

-- Tạo bảng thông tin người dùng
CREATE TABLE IF NOT EXISTS UserInfo (
    UserInfoID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100),
    Address VARCHAR(255),
    PhoneNumber VARCHAR(20),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

-- Tạo bảng danh mục sách
CREATE TABLE IF NOT EXISTS BookCategories (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50),
    IsActive BOOLEAN DEFAULT TRUE
);

-- Tạo bảng nhà xuất bản
CREATE TABLE IF NOT EXISTS Publishers (
    PublisherID INT AUTO_INCREMENT PRIMARY KEY,
    PublisherName VARCHAR(100),
    IsActive BOOLEAN DEFAULT TRUE
);

-- Tạo bảng tác giả
CREATE TABLE IF NOT EXISTS Authors (
    AuthorID INT AUTO_INCREMENT PRIMARY KEY,
    AuthorName VARCHAR(100),
    IsActive BOOLEAN DEFAULT TRUE
);

-- Tạo bảng sách
CREATE TABLE IF NOT EXISTS Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(100),
    CategoryID INT,
    PublisherID INT,
    Price DECIMAL(10,2),
    IsHot BOOLEAN DEFAULT FALSE,
    IsActive BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (CategoryID) REFERENCES BookCategories(CategoryID),
    FOREIGN KEY (PublisherID) REFERENCES Publishers(PublisherID)
);

-- Tạo bảng phiếu nhập sách
CREATE TABLE IF NOT EXISTS ImportSheets (
    ImportSheetID INT AUTO_INCREMENT PRIMARY KEY,
    ImportDate DATE,
    EmployeeID INT,
    TotalCost DECIMAL(10,2),
    FOREIGN KEY (EmployeeID) REFERENCES Users(UserID)
);

-- Tạo bảng chi tiết phiếu nhập
CREATE TABLE IF NOT EXISTS ImportDetails (
    ImportDetailID INT AUTO_INCREMENT PRIMARY KEY,
    ImportSheetID INT,
    BookID INT,
    Quantity INT,
    ImportPrice DECIMAL(10,2),
    FOREIGN KEY (ImportSheetID) REFERENCES ImportSheets(ImportSheetID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

-- Tạo bảng đơn hàng
CREATE TABLE IF NOT EXISTS Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE,
    CustomerID INT,
    EmployeeID INT,
    Discount DECIMAL(5,2),
    FOREIGN KEY (EmployeeID) REFERENCES Users(UserID),
    FOREIGN KEY (CustomerID) REFERENCES UserInfo(UserInfoID)
);

-- Tạo bảng chi tiết đơn hàng
CREATE TABLE IF NOT EXISTS OrderDetails (
    OrderDetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    BookID INT,
    Quantity INT,
    SalePrice DECIMAL(10,2),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (BookID) REFERENCES Books(BookID)
);

-- Tạo bảng khách hàng (mở rộng từ UserInfo)
CREATE TABLE IF NOT EXISTS Customers (
    CustomerID INT,
    MemberSince DATE,
    FOREIGN KEY (CustomerID) REFERENCES UserInfo(UserInfoID)
);
