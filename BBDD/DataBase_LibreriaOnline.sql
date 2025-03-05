drop database if exists LibreriaOnline;
create database if not exists LibreriaOnline;

use LibreriaOnline;

-- CREATE --
create table if not exists Libros (
id_libro INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(100) NOT NULL,
autor VARCHAR(100) NOT NULL,
precio DECIMAL(10, 2) NOT NULL,
formato ENUM('Papel', 'Ebook') NOT NULL
);

create table if not exists Clientes (
id_cliente INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
telefono VARCHAR(15)
);

create table if not exists Pedidos (
id_pedido INT PRIMARY KEY AUTO_INCREMENT,
id_cliente INT NOT NULL,
fecha_pedido DATE NOT NULL,
total DECIMAL(10, 2) NOT NULL,
FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- MODIFY --
ALTER TABLE Libros
ADD COLUMN stock int;

ALTER TABLE Clientes
MODIFY COLUMN telefono VARCHAR (20);

-- DROP/DELETE --
DROP TABLE PEDIDOS;

-- INSERT --
INSERT INTO Libros (titulo, autor, precio, formato, stock) VALUES
('Cien años de soledad', 'Gabriel García Márquez', 19.99, 'Papel', 0),
('1984', 'George Orwell', 9.99, 'Ebook', 0),
('El principito', 'Antoine de Saint-Exupéry', 14.99, 'Papel', 0);

-- MUESTRO TABLAS POR PANTALLA --
SELECT * FROM Libros;

INSERT INTO Clientes (nombre, email, telefono) VALUES
('Ana Pérez', 'ana.perez@mail.com', 123456789),
('Luis López', 'luis.lopez@mail.com', 987654321);

-- MUESTRO TABLAS POR PANTALLA --
SELECT * FROM Clientes;

-- UPDATE --
UPDATE Libros
SET precio = 11.99
WHERE titulo = '1984';

UPDATE Libros
SET stock = stock + 10
WHERE formato = 'Papel';

UPDATE Clientes
SET telefono = 555123456
WHERE nombre = 'Ana Pérez';

-- MUESTRO TABLAS POR PANTALLA --
SELECT * FROM Libros;
SELECT * FROM Clientes;

-- DROP/DELETE --
DELETE FROM Libros
WHERE precio > 20;

DELETE FROM Clientes
WHERE email = 'luis.lopez@mail.com';

-- MUESTRO TABLAS POR PANTALLA --
SELECT * FROM Libros;
SELECT * FROM Clientes;