DROP DATABASE IF EXISTS hym_bd;
CREATE DATABASE IF NOT EXISTS hym_bd;

USE hym_bd;

-- CREO TODAS LAS TABLAS --
CREATE TABLE IF NOT EXISTS usuario (
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (128),
apellidos VARCHAR (128),
email VARCHAR (64),
fecha_nacimiento DATE,
tipo_miembro VARCHAR (64),
puntos_acumulados INT,
fecha_registro DATE,
fecha_ultima_visita DATE
);

CREATE TABLE IF NOT EXISTS vale_descuento (
id_vale INT PRIMARY KEY AUTO_INCREMENT,
fecha_creacion DATE,
fecha_caducidad DATE,
usado BOOLEAN DEFAULT 0,
id_usuario INT,
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE IF NOT EXISTS direccion (
id_direccion INT PRIMARY KEY AUTO_INCREMENT,
calle VARCHAR (128),
ciudad VARCHAR (64),
codigo_postal INT,
poblacion VARCHAR (128),
direccion_favorita BOOLEAN DEFAULT 0,
id_usuario INT,
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE IF NOT EXISTS almacen_direccion (
id_almacen INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (128),
poblacion VARCHAR (128),
calle VARCHAR (128),
ciudad VARCHAR (64),
codigo_postal INT,
capacidad_total INT
);

CREATE TABLE IF NOT EXISTS categoria (
id_categoria INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (64),
descripcion VARCHAR (128),
imagen VARCHAR (64)
);

CREATE TABLE IF NOT EXISTS producto (
id_producto INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (16),
descripcion VARCHAR (128),
imagen VARCHAR (64),
stock INT,
PRECIO FLOAT (20, 6),
id_almacen INT ,
FOREIGN KEY (id_almacen) REFERENCES almacen_direccion (id_almacen)
);

CREATE TABLE IF NOT EXISTS producto_categoria (
id_producto INT,
id_categoria INT,
PRIMARY KEY (id_producto, id_categoria),
FOREIGN KEY (id_producto) REFERENCES producto (id_producto),
FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
);

CREATE TABLE IF NOT EXISTS compra (
id_compra INT PRIMARY KEY AUTO_INCREMENT,
forma_pago VARCHAR (64),
fecha DATE,
total_compra FLOAT (20, 6),
id_usuario INT,
id_direccion INT,
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
FOREIGN KEY (id_direccion) REFERENCES direccion (id_direccion)
);

CREATE TABLE IF NOT EXISTS linea_pedido (
id_linea INT,
precio_unidad FLOAT (20, 6),
cantidad INT,
total_linea FLOAT (20, 6),
id_compra INT,
id_producto INT,
FOREIGN KEY (id_compra) REFERENCES compra (id_compra),
FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

-- MOSTRAR TABLAS --
SELECT * FROM usuario;
SELECT * FROM vale_descuento;
SELECT * FROM direccion;
SELECT * FROM almacen_direccion;
SELECT * FROM categoria;
SELECT * FROM producto;
SELECT * FROM producto_categoria;
SELECT * FROM compra;
SELECT * FROM linea_pedido;

-- 3. Cambia el nombre de la tabla “almacen_direccion” por “almacen. --
ALTER TABLE almacen_direccion 
RENAME almacen;

-- 4. En la tabla “producto” establece que el valor de la columna “stock” sea 0 por defecto. --
ALTER TABLE producto 
MODIFY stock INT DEFAULT 0;

-- 5. En la tabla “usuario” establece que el valor de la columna “email” no puede ser nulo. --
ALTER TABLE usuario
MODIFY COLUMN email VARCHAR (64) NOT NULL;

-- 6. Establece una restricción para que el valor de “cantidad” en la tabla “linea_pedido” siempre sea un valor mayor que 0. --
ALTER TABLE linea_pedido
ADD CONSTRAINT chkCantidadMayor
CHECK (cantidad > 0);

-- 7. Cambia el nombre de la columna “direccion_favorita” por “es_favorita” de la tabla “direccion” --
ALTER TABLE direccion
CHANGE COLUMN direccion_favorita es_favorita BOOLEAN DEFAULT 0;

-- 8. En la tabla “producto” modifica el tipo de la columna “nombre” a VARCHAR de tamaño 64. --
ALTER TABLE producto
MODIFY COLUMN nombre VARCHAR (64);

-- 9. Añade la condición de clave primaria al atributo “id_linea” de la tabla “linea_pedido”. Pon además que sea auto incrementado. --
ALTER TABLE linea_pedido
MODIFY id_linea INT PRIMARY KEY AUTO_INCREMENT;

-- 10. Elimina la columna “precio_unidad” de la tabla “linea_pedido”. --
ALTER TABLE linea_pedido
DROP COLUMN precio_unidad;

-- 11. Añade una nueva columna en la tabla “categoria” de nombre “url” de tipo VARCHAR de tamaño 128. --
ALTER TABLE categoria
ADD COLUMN url VARCHAR (128);

-- INSERTO VALORES --
INSERT INTO usuario (nombre, apellidos, email, fecha_nacimiento, tipo_miembro, puntos_acumulados, fecha_registro, fecha_ultima_visita) VALUES
('Sergio', 'Guillén Lara', 'glara@gmail.com', '2001-09-12', 'miembro', 200, '2021-01-18', '2022-01-15'),
('Carmen', 'Suárez Pérez', 'sperez@gmail.com', '1995-05-05', 'miembro_plus', 12, '2018-03-20', '2021-12-30'),
('Esther', 'Martín Gutiérrez', 'mguti@gmail.com', '1965-02-20', 'miembro', 340, '2015-06-06', '2021-10-20');

INSERT INTO vale_descuento (fecha_creacion, fecha_caducidad, usado, id_usuario) VALUES 
('2022-01-14', '2022-07-14', 0, 1),
('2021-12-30', '2022-06-30', 0, 2),
('2021-05-12', '2021-11-12', 1, 1);

INSERT INTO direccion (calle, ciudad, codigo_postal, poblacion, es_favorita, id_usuario) VALUES 
('Calle Tetuán, 3', 'Sevilla', '41001', 'Alcalá de Guadaira', 1, 1),
('Calle Genil nº 2 1ºC', 'Granada', '48030', 'Motril', 0, 2),
('Avda Andalucía 4 Portal 2 3ºC', 'Zamora', '52320', 'Carrascal', 1, 2),
('Calle Cervantes, nº1', 'Soria', '16033', 'Lubia', 1, 3);

INSERT INTO almacen (nombre, poblacion, calle, ciudad, codigo_postal, capacidad_total) VALUES
('Xiun Guan S.L.', 'Carmona', 'Polígono La Isla, Calle Filosofía, 3', 'Sevilla', '41010', 45000),
('Warehouse 45', 'San Fernando', 'Calle Pinar 34', 'Cádiz', '34500', 12800),
('Tu almacén S.L.', 'San Juan del Puerto', 'Calle Aplauso nº1', 'Huelva', '28040', 90000);

INSERT INTO categoria (nombre, descripcion, imagen, url) VALUES
('Pantalones', 'Pantalones de temporada', 'imagen-categoria1.jpg', 'https://hym.web/pantalones'),
('Sudaderas', 'Las sudaderas que más abrigan del mercado', 'imagen-categoria2.jpg', 'https://hym.web/sudaderas'),
('Calzado', 'Calzado de todo tipo para todo tipo de ocasiones', 'imagen-categoria3.jpg', 'https://hym.web/calzado');

INSERT INTO producto (nombre, descripcion, imagen, stock, precio, id_almacen) VALUES
('Joggers cargo de nailon', 'Joggers cargo de nailon con cintura elástica con cordón de ajuste.', 'prod1-joggersA.jpg', 45, 15.95, 2),
('Zapatos Derby', 'Zapatos Derby con cordones abiertos. Forro y plantillas de lona. Tacón 2,5 cm.', 'prod2-derbyPrin.jpg', 12, 29.99, 1),
('Sudadera Relaxed Fit', 'Sudadera en peluche suave con bolsillo canguro y capucha con cordón de ajuste elástico.', 'prod3-sudRelax.jpg', 4, 24.99, 3);

INSERT INTO producto_categoria (id_producto, id_categoria) VALUES
(1, 1),
(2, 3),
(3, 2);

INSERT INTO compra (forma_pago, fecha, total_compra, id_usuario, id_direccion) VALUES
('Efectivo', '2021-05-12', 45.94, 2, 3),
('Tarjeta', '2020-10-09', 59.98, 2, 2),
('Tarjeta', '2021-01-29', 29.99, 1, 1);

INSERT INTO linea_pedido (cantidad, total_linea, id_compra, id_producto) VALUES 
(1, 15.95, 1, 1),
(1, 29.99, 1, 2),
(2, 59.98, 2, 2),
(1, 29.99, 3, 2);

-- 12. En la tabla “usuario”, actualiza el valor del nombre a “Cristina” para el usuario que sea “miembro” y tenga más de 300 puntos acumulados. --
UPDATE usuario
SET nombre = 'Cristina'
WHERE tipo_miembro = 'miembro' AND puntos_acumulados > 300;

-- 13. En la tabla “vale_descuento”, establece como no usados todos los vales del usuario con id_usuario igual 1. --
ALTER TABLE vale_descuento
MODIFY COLUMN usado VARCHAR (64);

UPDATE vale_descuento
SET usado = 'No usado'
WHERE id_usuario = 1;

-- 14. En la tabla “direccion”, actualiza todos los datos de la dirección con id_direccion igual a 2. Usa los siguientes datos: --
UPDATE direccion
SET calle = 'Calle Sanitarios, 33', ciudad = 'Granada', codigo_postal = 48210, poblacion = 'Almuñecar', es_favorita = 1, id_usuario = 2
WHERE id_direccion = 2;

-- 15. En la tabla “direccion”, actualiza el valor es_favorita a 0 de la dirección cuyo id_usuario es 2 y la población no es “Almuñecar” --
UPDATE direccion
SET es_favorita = 0
WHERE id_usuario = 2 AND poblacion != 'Almuñecar';

-- 16. En la tabla “almacen”, actualiza la capacidad a 250000 del almacén cuya población empiece por “San” y su ciudad no sea “Huelva”. --
UPDATE almacen
SET capacidad_total = 250000
WHERE poblacion LIKE 'San%' AND ciudad != 'Huelva';

-- 17. En la tabla “producto”, actualiza el stock sumando 11 al producto proporcionado por el almacén con ID 3. --
UPDATE producto
SET stock = stock + 11
WHERE id_producto = 3;

-- 18. En la tabla “compra”, actualiza la forma de pago a “Bizum” del pedido con id_usuario igual a 2 pero que la dirección no sea la de id 3. --
UPDATE compra
SET forma_pago = 'Bizum'
WHERE id_usuario = 2 AND id_direccion != 3;

-- 19. Actualiza el total de la línea a 31,9 y la cantidad a 2 de la línea de pedido cuyo ID sea 1. --
UPDATE linea_pedido
SET total_linea = 31.9, cantidad = 2
WHERE id_linea = 1;

-- 20. Actualiza la descripción de la categoría cuyo nombre es “Pantalones”, y ponle el texto: “Pantalones de la nueva temporada primavera-verano” --
UPDATE categoria
SET nombre = 'Pantalones de la nueva temporada primavera-verano'
WHERE nombre = 'Pantalones';

-- 21. Elimina de la tabla “producto_categoria” el registro que relaciona al producto 3 con la categoría 2. --
DELETE FROM producto_categoria
WHERE id_categoria = 2 AND id_producto = 3;

-- 22. Elimina de la tabla “linea_pedido” el registro que tenga un precio total mayor de 30€ --
DELETE FROM linea_pedido
WHERE total_linea > 30;

-- 23. Elimina de la tabla “categoria” el registro que contenga la palabra “mercado” en la descripción. --
DELETE FROM categoria
WHERE descripcion LIKE 'mercado%';

-- 24. Elimina de la tabla “vale_descuento” todos los vales que no sean del usuario con ID 1. --
DELETE FROM vale_descuento
WHERE id_usuario != 1;

-- MOSTRAR TABLAS --
SELECT * FROM usuario;
SELECT * FROM vale_descuento;
SELECT * FROM direccion;
SELECT * FROM almacen;
SELECT * FROM categoria;
SELECT * FROM producto;
SELECT * FROM producto_categoria;
SELECT * FROM compra;
SELECT * FROM linea_pedido;