CREATE DATABASE IF NOT EXISTS demo;

USE demo;

CREATE TABLE customers
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255),
    address VARCHAR(255),
    salary  DECIMAL(8, 2)
);