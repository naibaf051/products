CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);

INSERT INTO products (name, price) VALUES ('Product A', 10.0);
INSERT INTO products (name, price) VALUES ('Product B', 20.0);