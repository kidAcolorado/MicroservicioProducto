create database productosbdd;
use productosbdd;

CREATE TABLE productos (
    codigo INT PRIMARY KEY NOT NULL,
    producto VARCHAR(255),
    precio_unidad DOUBLE,
    stock INT
);



INSERT INTO productos (codigo, producto, precio_unidad, stock) VALUES
(1001, 'Camiseta de algodón', 15.99, 50),
(1002, 'Zapatos deportivos', 79.99, 30),
(1003, 'Pantalones vaqueros', 29.95, 40),
(1004, 'Teléfono inteligente', 399.99, 25),
(1005, 'Portátil HP', 899.99, 15),
(1006, 'Televisor LED 55"', 699.99, 10),
(1007, 'Mouse inalámbrico', 19.99, 75),
(1008, 'Teclado mecánico', 59.95, 35),
(1009, 'Auriculares Bluetooth', 49.99, 60),
(1010, 'Cámara digital', 299.99, 20),
(1011, 'Tablet Android', 199.99, 30),
(1012, 'Altavoces Bluetooth', 79.95, 45),
(1013, 'Impresora láser', 129.99, 15),
(1014, 'Silla de oficina', 149.95, 25),
(1015, 'Mesa de comedor', 299.99, 10),
(1016, 'Refrigerador de acero inoxidable', 799.99, 5),
(1017, 'Licuadora de alta velocidad', 69.99, 20),
(1018, 'Set de utensilios de cocina', 49.95, 30),
(1019, 'Lavadora de carga frontal', 549.99, 8),
(1020, 'Secadora eléctrica', 399.99, 12);