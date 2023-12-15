CREATE TABLE IF NOT EXISTS drinks (

    id SERIAL  PRIMARY KEY,
    name varchar(20),
    type varchar(10),
    price decimal(10,2)

)