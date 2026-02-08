-- 1. Insert Category
INSERT INTO category (id, description, name)
VALUES (nextval('category_seq'), 'Devices, gadgets, and hardware', 'Electronics');

-- 2. Insert Product
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES (
           nextval('product_seq'),
           'Smartphone',
           'Latest model with high-resolution camera',
           50.0,
           699.99,
           (SELECT id FROM category WHERE name = 'Electronics' LIMIT 1)
       );