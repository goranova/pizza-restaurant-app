CREATE SCHEMA IF NOT EXISTS pizza;
SET SCHEMA pizza;

CREATE TABLE pizza.menu_item (

    id IDENTITY PRIMARY KEY,
    name varchar(20),
    price decimal(10,2),
    type varchar(20),
    UNIQUE(name)
);

