CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO PRODUCTS VALUES (uuid_generate_v4 (), 'petprojectstorage', 'description about the product', 'serbia/1.jpg', 'This is the title' );