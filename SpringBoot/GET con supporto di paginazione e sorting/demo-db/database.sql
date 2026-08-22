CREATE DATABASE IF NOT EXISTS test1;

USE test1;

CREATE TABLE IF NOT EXISTS car (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model_name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO car (model_name, type, color, description)
VALUES
('Golf', 'HATCHBACK', 'BLACK', 'Volkswagen Golf'),
('Model Y', 'SUV', 'WHITE', 'Tesla Model Y'),
('Civic', 'SEDAN', 'BLUE', 'Honda Civic'),
('A3', 'SEDAN', 'RED', 'Audi A3'),
('Mustang', 'COUPE', 'GREEN', 'Ford Mustang'),
('Polo', 'HATCHBACK', 'WHITE', 'Volkswagen Polo'),
('Q5', 'SUV', 'BLACK', 'Audi Q5'),
('Clio', 'HATCHBACK', 'RED', 'Renault Clio'),
('Serie 3', 'SEDAN', 'BLUE', 'BMW Serie 3'),
('MX-5', 'COUPE', 'GREEN', 'Mazda MX-5');