CREATE TABLE payments (
    id INTEGER PRIMARY KEY,
    order_id INTEGER NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date DATETIME NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    UNIQUE (id)
);

CREATE INDEX idx_order_id ON payments(order_id);

INSERT INTO payments (id, order_id, amount, payment_date, payment_method) VALUES (1, 301, 100.00, '2024-11-20 13:00:00', 'Credit Card');
INSERT INTO payments (id, order_id, amount, payment_date, payment_method) VALUES (2, 302, 150.00, '2024-11-20 14:00:00', 'PayPal');
INSERT INTO payments (id, order_id, amount, payment_date, payment_method) VALUES (3, 303, 200.00, '2024-11-20 15:00:00', 'Bank Transfer');