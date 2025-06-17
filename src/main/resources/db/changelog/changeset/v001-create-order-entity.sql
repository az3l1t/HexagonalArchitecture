CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO orders (customer_name, amount) VALUES
('John Doe', 150.50),
('Jane Smith', 299.99),
('Bob Johnson', 75.25);
