CREATE DATABASE employees;


CREATE TABLE employees.employees(
employee_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
employee_name VARCHAR(100) NOT NULL,
employee_password VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL
);

INSERT INTO employees.employees(employee_name, employee_password, email) VALUES ("admin", 'admin', 'admin@medplus.in');