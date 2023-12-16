CREATE TABLE IF NOT EXISTS menu_item (

    id SERIAL PRIMARY KEY,
    name varchar(20),
    price decimal(10,2),
    type varchar(20),
    UNIQUE(name)
);
