drop database if exists springsec ;

create database if not exists springsec;

use springsec;

create table products (
	id bigint primary key auto_increment,
    name varchar(100),
    price double
)  ;


INSERT INTO product (name, price) VALUES
                                       ('Apple iPhone 13', 799.99),
                                       ('Samsung Galaxy S21', 699.99),
                                       ('Dell XPS 13', 999.99),
                                       ('Apple MacBook Air', 999.99),
                                       ('Sony WH-idname1000XM4 Headphones', 349.99),
                                       ('Logitech MX Master 3 Mouse', 99.99),
                                       ('Kindle Paperwhite', 129.99),
                                       ('GoPro HERO9 Black', 399.99),
                                       ('Nikon D3500 DSLR Camera', 496.95),
                                       ('Samsung Galaxy Tab S7', 649.99),
                                       ('Apple iPad Air', 599.99),
                                       ('Microsoft Surface Pro 7', 749.99),
                                       ('Bose QuietComfort 35 II', 299.99),
                                       ('Asus ROG Zephyrus G14', 1049.99),
                                       ('HP Envy x360 13', 849.99),
                                       ('Canon EOS Rebel T7', 449.99),
                                       ('Apple Watch Series 6', 399.99),
                                       ('Fitbit Charge 4', 149.99),
                                       ('Nest Learning Thermostat', 249.99),
                                       ('Dyson V11 Torque Drive', 599.99),
                                       ('Instant Pot DUO60', 89.99),
                                       ('KitchenAid Artisan Series Mixer', 429.99),
                                       ('Samsonite Winfield 2 Luggage', 229.99),
                                       ('Philips Hue White and Color Ambiance', 199.99),
                                       ('iRobot Roomba 960', 499.99),
                                       ('Sony PlayStation 5', 499.99),
                                       ('Microsoft Xbox Series X', 499.99),
                                       ('Nintendo Switch', 299.99),
                                       ('Anker PowerCore 10000 Portable Charger', 24.99),
                                       ('JBL Flip 5 Bluetooth Speaker', 119.99);
                                       
select * from products;             




CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);                



INSERT INTO users (username, password, enabled) VALUES ('thomas', '{noop}password', TRUE);
INSERT INTO authorities (username, authority) VALUES ('thomas', 'ROLE_USER');       


select * from user;
select * from product;

   