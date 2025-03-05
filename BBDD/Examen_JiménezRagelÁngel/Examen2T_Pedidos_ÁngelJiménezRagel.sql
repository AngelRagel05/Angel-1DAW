-- 1. Crear la base de datos
DROP DATABASE IF EXISTS examen2T_Pedidos;
CREATE DATABASE IF NOT EXISTS examen2T_Pedidos;
USE examen2T_Pedidos;

CREATE TABLE Alumno (
id_alumno INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (128),
apellidos VARCHAR (256),
telefono INT (9)
);

CREATE TABLE Alimento (
id_alimento INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR (128),
descripcion VARCHAR (512),
tipo VARCHAR (32),
precio FLOAT (12, 2)
);

CREATE TABLE Pedido (
id_pedido INT PRIMARY KEY AUTO_INCREMENT,
fecha_pedido DATE,
total FLOAT (12, 2),
id_alumno INT,
FOREIGN KEY (id_alumno) REFERENCES Alumno(id_alumno)
ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Linea_pedido (
id_linea_pedido INT PRIMARY KEY AUTO_INCREMENT,
cantidad INT (11),
precio_total FLOAT (12),
id_alimento INT,
id_pedido INT,
FOREIGN KEY (id_alimento) REFERENCES Alimento(id_alimento)
ON DELETE SET NULL ON UPDATE CASCADE,
FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido)
ON DELETE SET NULL ON UPDATE CASCADE
);

-- Insertar datos en la tabla 'alumno'
INSERT INTO Alumno (nombre, apellidos, telefono) VALUES
('Andrés', 'Repiso Vidal de Torres', 684957745),
('Luis Fernando', 'Parra Vaquerizo', 750971223),
('Pedro Manuel', 'Martin Pérez', 697506361);

-- Insertar datos en la tabla 'alimento'
INSERT INTO Alimento (nombre, descripcion, tipo, precio) VALUES
('Sanito', 'Bocadillo vegetal con lechuga, pollo, mayonesa, tomate, huevo y atún', 'bocadillo', 2.30),
('Hambriento', 'Bocadillo de lomo con jamón, pimiento frito, mayonesa y patatas fritas dentro', 'bocadillo', 2.50),
('Zumo naranja', 'Zumo de naranja 100% natural recién exprimido', 'bebida', 1.35),
('Coca cola', 'Coca cola fría', 'bebida', 1.50);

-- Insertar datos en la tabla 'pedido'
INSERT INTO Pedido (fecha_pedido, total, id_alumno) VALUES
('2022-01-12', 3.65, 3),
('2022-02-14', 2.50, 1),
('2022-03-21', 3.00, 2);

-- Insertar datos en la tabla 'linea_pedido'
INSERT INTO Linea_pedido (id_pedido, id_alimento, precio_total, cantidad) VALUES
(1, 1, 2.30, 1),
(3, 1, 1.35, 1),
(2, 1, 2.50, 2),
(2, 2, 3.00, 3);

SELECT * FROM Alumno;
SELECT * FROM Alimento;
SELECT * FROM Pedido;
SELECT * FROM Linea_pedido;

UPDATE Alimento SET descripcion = 'Coca cola helada para refrescarte' WHERE descripcion = 'Coca cola fría';
UPDATE Pedido SET id_pedido = 5 WHERE id_pedido = 3;
UPDATE Alumno SET telefono = '666777999' WHERE telefono = 750971223;
UPDATE Alumno SET id_alumno = 4 WHERE id_alumno = 1;
DELETE FROM Alimento WHERE nombre = 'Hambriento';
DELETE FROM Pedido WHERE id_pedido = 1;

SELECT * FROM Alumno;
SELECT * FROM Alimento;
SELECT * FROM Pedido;
SELECT * FROM Linea_pedido;