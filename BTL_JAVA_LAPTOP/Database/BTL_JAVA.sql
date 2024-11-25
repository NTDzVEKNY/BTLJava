USE master;
GO

IF EXISTS (SELECT name FROM sys.databases WHERE name = 'BTLJAVA')
BEGIN
    ALTER DATABASE BTLJAVA SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BTLJAVA;
END

CREATE DATABASE BTLJAVA;
GO

USE BTLJAVA
GO

CREATE TABLE ROLES (
  role_id int IDENTITY(1,1) PRIMARY KEY,
  name nvarchar(20) NOT NULL
) 

GO
CREATE TABLE USERS (
  id int IDENTITY(1,1) NOT NULL,
  fullname nvarchar(30) NOT NULL,
  username nvarchar(30) NOT NULL,
  password_u nvarchar(30) NOT NULL,
  role_id int NOT NULL,
  status_u bit,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES ROLES(role_id)
) 
GO

CREATE TABLE LAPTOP (
  id int IDENTITY(1,1) PRIMARY KEY,
  name nvarchar(50) NOT NULL,
  manufacturer nvarchar(50) NOT NULL,
  quantity int NOT NULL,
  price int NOT NULL
);
GO

CREATE TABLE ORDERS (
  id int IDENTITY(1,1) PRIMARY KEY,
  order_date date NOT NULL,
  total_price int NOT NULL,
  id_account int NOT NULL,
  FOREIGN KEY (id_account) REFERENCES USERS(id)
);
GO

CREATE TABLE ORDER_DETAILS (
  order_id int NOT NULL,
  laptop_id int NOT NULL,
  quantity int NOT NULL,
  PRIMARY KEY (order_id, laptop_id),
  FOREIGN KEY (order_id) REFERENCES ORDERS(id),
  FOREIGN KEY (laptop_id) REFERENCES LAPTOP(id)
);
GO

INSERT INTO ROLES ( name) VALUES
(N'Trưởng phòng'),
(N'Nhân viên');
GO

INSERT INTO USERS ( fullname, username, password_u, role_id, status_u ) VALUES
( N'Admin', 'admin', '123', 1, 1),
( N'Việt Trung', 'trung0', '123', 2, 1),
( N'Bùi Thị Hải', 'hai123', '12345678', 2, 1),
( N'Hà Thị Phượng', 'phuong123', '12345678', 2, 1),
( N'Nguyễn Thị Tú Anh', 'anh123', '12345678', 2, 1),
( N'Hoàng Thi Kim', 'kim123', '12345678', 2, 1);
GO

INSERT INTO laptop (name, manufacturer, quantity, price) VALUES 
('Laptop Asus TUF Gaming', 'Asus', 15, 20990000),
('Laptop HP 245 G10', 'HP', 18, 9900000),
('Laptop Lenovo IdeaPad 3', 'Lenovo', 9, 13850000),
('Laptop Dell Vostro V3520', 'Dell', 13, 16490000),
('Laptop Acer Aspire 3', 'Acer', 20, 11950000),
('Laptop MSI Modern 14', 'MSI', 6, 12000000);
GO

INSERT INTO ORDERS (order_date, total_price, id_account) VALUES 
('2023-05-23', 51880000, 1),  -- Total price corrected to 51880000
('2024-06-24', 29700000, 4),  -- Total price corrected to 29700000
('2024-06-25', 146500000, 3), -- Total price corrected to 146500000
('2024-06-26', 47500000, 6),  -- Total price corrected to 47500000
('2024-06-27', 72870000, 2),  -- Total price corrected to 72870000
('2024-06-28', 97810000, 5);  -- Total price corrected to 97810000
GO

INSERT INTO ORDER_DETAILS (order_id, laptop_id, quantity) VALUES 
(1, 1, 2),  -- Order 1 contains 2 units of Laptop 1
(1, 2, 1),  -- Order 1 contains 1 unit of Laptop 2
(2, 2, 3),  -- Order 2 contains 3 units of Laptop 2
(3, 1, 5),  -- Order 3 contains 5 units of Laptop 1
(3, 3, 3),  -- Order 3 contains 3 units of Laptop 3
(4, 2, 2),  -- Order 4 contains 2 units of Laptop 2
(4, 3, 2),  -- Order 4 contains 2 units of Laptop 3
(5, 1, 3),  -- Order 5 contains 3 units of Laptop 1
(5, 2, 1),  -- Order 5 contains 1 unit of Laptop 2
(6, 1, 4),  -- Order 6 contains 4 units of Laptop 1
(6, 3, 1);  -- Order 6 contains 1 unit of Laptop 3
GO

SELECT * FROM LAPTOP;
SELECT * FROM ORDERS;
SELECT * FROM ORDER_DETAILS;
GO

