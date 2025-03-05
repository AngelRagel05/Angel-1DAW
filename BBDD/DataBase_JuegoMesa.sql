DROP DATABASE IF EXISTS club_juegos_de_mesa;
CREATE DATABASE IF NOT EXISTS club_juegos_de_mesa;

USE club_juegos_de_mesa;

CREATE TABLE IF NOT EXISTS mesa (
id_mesa INT AUTO_INCREMENT PRIMARY KEY,
capacidad INT NOT NULL,
tipo_juego VARCHAR(30),
ocupada BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente (
id_cliente INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellidos VARCHAR(50),
fecha_nacimiento DATE NOT NULL,
juego_alquilado BOOLEAN,
id_mesa INT,
FOREIGN KEY (id_mesa) REFERENCES mesa (id_mesa)
);

CREATE TABLE IF NOT EXISTS ocasional (
id_ocasional INT AUTO_INCREMENT PRIMARY KEY,
fecha_ultima_visita DATE NOT NULL,
acompanado_socio BOOLEAN NOT NULL,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE IF NOT EXISTS juegoSueleAlquilar (
id_juego_suele_alquilar INT AUTO_INCREMENT PRIMARY KEY,
juego VARCHAR(30) NOT NULL,
id_ocasional INT,
FOREIGN KEY (id_ocasional) REFERENCES ocasional (id_ocasional)
);

CREATE TABLE IF NOT EXISTS juegoFavorito (
id_juego_favorito INT AUTO_INCREMENT PRIMARY KEY,
juego VARCHAR(30),
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);


CREATE TABLE IF NOT EXISTS juego (
id_juego INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
edad_recomendada INT,
n_jugadores INT,
t_estimado DECIMAL(10, 2),
editorial VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS mesa_juego (
id_mesa INT,
id_juego INT,
PRIMARY KEY (id_mesa, id_juego),
FOREIGN KEY (id_mesa) REFERENCES mesa (id_mesa),
FOREIGN KEY (id_juego) REFERENCES juego (id_juego)
);


CREATE TABLE IF NOT EXISTS juegoAlquiler (
id_juego_alquiler INT AUTO_INCREMENT PRIMARY KEY,
alquilado BOOLEAN NOT NULL,
fecha_primer_alquiler DATE,
antiguedad INT,
id_juego INT,
FOREIGN KEY (id_juego) REFERENCES juego (id_juego)
);

CREATE TABLE IF NOT EXISTS cliente_juegoAlquier (
id_cliente INT,
id_juego_alquiler INT,
PRIMARY KEY (id_cliente, id_juego_alquiler),
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
FOREIGN KEY (id_juego_alquiler) REFERENCES juegoAlquiler (id_juego_alquiler)
);

CREATE TABLE IF NOT EXISTS juegoVenta (
id_juego_venta INT AUTO_INCREMENT PRIMARY KEY,
precio DECIMAL(10, 2),
stock BOOLEAN NOT NULL,
id_juego INT,
FOREIGN KEY (id_juego) REFERENCES juego (id_juego)
);

CREATE TABLE IF NOT EXISTS socio (
n_socio INT AUTO_INCREMENT PRIMARY KEY,
fecha_inicio DATE NOT NULL,
antiguedad INT,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE IF NOT EXISTS compra (
id_compra INT AUTO_INCREMENT PRIMARY KEY,
fecha DATE NOT NULL,
total FLOAT NOT NULL,
forma_de_pago VARCHAR(30),
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE IF NOT EXISTS facturaDireccion (
id_factura INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
apellidos VARCHAR(30),
nif VARCHAR(9) NOT NULL,
nombre_empresa VARCHAR(30) NOT NULL,
cp INT NOT NULL,
calle VARCHAR(50) NOT NULL,
poblacion VARCHAR(50) NOT NULL,
ciudad VARCHAR(50) NOT NULL,
id_compra INT,
FOREIGN KEY (id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE IF NOT EXISTS ticket (
n_ticket INT AUTO_INCREMENT PRIMARY KEY,
dependiente VARCHAR(50) NOT NULL,
id_compra INT,
FOREIGN KEY (id_compra) REFERENCES compra (id_compra)
);

CREATE TABLE IF NOT EXISTS lineaCompra (
    id_linea_compra INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio FLOAT NOT NULL,
    id_compra INT,
    id_juego_venta INT,
    FOREIGN KEY (id_compra) REFERENCES compra (id_compra),
    FOREIGN KEY (id_juego_venta) REFERENCES juegoVenta (id_juego_venta)
);

-- Insertar datos en la tabla 'mesa'
INSERT INTO mesa (capacidad, tipo_juego, ocupada)
VALUES
(4, 'Cartas', FALSE),
(6, 'Rol', TRUE),
(8, 'Tablero', FALSE);

-- Insertar datos en la tabla 'cliente'
INSERT INTO cliente (nombre, apellidos, fecha_nacimiento, juego_alquilado, id_mesa)
VALUES
('Juan', 'Pérez', '1990-05-10', TRUE, 1),
('Ana', 'García', '1985-08-22', FALSE, 2),
('Carlos', 'López', '2000-12-01', TRUE, NULL);

-- Insertar datos en la tabla 'ocasional'
INSERT INTO ocasional (fecha_ultima_visita, acompanado_socio, id_cliente)
VALUES
('2025-01-01', TRUE, 1),
('2025-01-15', FALSE, 2);

-- Insertar datos en la tabla 'juegoSueleAlquilar'
INSERT INTO juegoSueleAlquilar (juego, id_ocasional)
VALUES
('Catan', 1),
('Carcassonne', 2);

-- Insertar datos en la tabla 'juegoFavorito'
INSERT INTO juegoFavorito (juego, id_cliente)
VALUES
('Catan', 1),
('Risk', 2),
('Aventureros al Tren', 3);

-- Insertar datos en la tabla 'juego'
INSERT INTO juego (nombre, edad_recomendada, n_jugadores, t_estimado, editorial)
VALUES
('Catan', 10, 4, 60.0, 'Kosmos'),
('Carcassonne', 8, 5, 45.0, 'Hans im Glück'),
('Risk', 12, 6, 120.0, 'Hasbro');

-- Insertar datos en la tabla 'mesa_juego'
INSERT INTO mesa_juego (id_mesa, id_juego)
VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertar datos en la tabla 'juegoAlquiler'
INSERT INTO juegoAlquiler (alquilado, fecha_primer_alquiler, antiguedad, id_juego)
VALUES
(TRUE, '2024-12-20', 2, 1),
(FALSE, '2024-12-25', 1, 2);

-- Insertar datos en la tabla 'cliente_juegoAlquier'
INSERT INTO cliente_juegoAlquier (id_cliente, id_juego_alquiler)
VALUES
(1, 1),
(3, 2);

-- Insertar datos en la tabla 'juegoVenta'
INSERT INTO juegoVenta (precio, stock, id_juego)
VALUES
(29.99, TRUE, 1),
(24.99, TRUE, 2),
(34.99, FALSE, 3);

-- Insertar datos en la tabla 'socio'
INSERT INTO socio (fecha_inicio, antiguedad, id_cliente)
VALUES
('2022-01-01', 3, 1),
('2023-06-15', 1, 2);

-- Insertar datos en la tabla 'compra'
INSERT INTO compra (fecha, total, forma_de_pago, id_cliente)
VALUES
('2025-01-10', 54.98, 'Tarjeta', 1),
('2025-01-15', 24.99, 'Efectivo', 2);

-- Insertar datos en la tabla 'facturaDireccion'
INSERT INTO facturaDireccion (nombre, apellidos, nif, nombre_empresa, cp, calle, poblacion, ciudad, id_compra)
VALUES
('Juan', 'Pérez', '12345678A', 'Juegos y Más', 28001, 'Calle Mayor 10', 'Madrid', 'Madrid', 1);

-- Insertar datos en la tabla 'ticket'
INSERT INTO ticket (dependiente, id_compra)
VALUES
('Laura', 1),
('Miguel', 2);

-- Insertar datos en la tabla 'lineaCompra'
INSERT INTO lineaCompra (cantidad, precio, id_compra, id_juego_venta)
VALUES
(1, 29.99, 1, 1),
(1, 24.99, 1, 2),
(1, 24.99, 2, 2);


