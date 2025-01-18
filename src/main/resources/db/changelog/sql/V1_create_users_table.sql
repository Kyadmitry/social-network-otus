CREATE TABLE users (
    id UUID PRIMARY key,
    email VARCHAR(255) NOT NULL,
    password TEXT NOT null,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    gender VARCHAR(10),
    interests TEXT,
    city VARCHAR(255)
);