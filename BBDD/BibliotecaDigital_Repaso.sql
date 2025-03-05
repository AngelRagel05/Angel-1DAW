-- 1. Crear la base de datos
DROP DATABASE IF EXISTS BibliotecaDigital;
CREATE DATABASE IF NOT EXISTS BibliotecaDigital;
USE BibliotecaDigital;

-- 2. Crear las tablas
DROP TABLE IF EXISTS Usuario, Libro, Prestamo, Detalle_prestamo;

CREATE TABLE Usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(128),
    apellidos VARCHAR(256),
    email VARCHAR(128)
);

CREATE TABLE Libro (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(128),
    autor VARCHAR(128),
    categoria VARCHAR(64),
    disponible BOOLEAN DEFAULT 0
);

CREATE TABLE Prestamo (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    fecha_prestamo DATE,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario)
    ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Detalle_prestamo (
    id_detalle_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_libro INT,
    id_prestamo INT,
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
    ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_prestamo) REFERENCES Prestamo(id_prestamo)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- 3. Insertar datos en las tablas
INSERT INTO Usuario (nombre, apellidos, email) VALUES
('Marta', 'López Fernández', 'marta.lopez@correo.com'),
('Jorge', 'Ramírez González', 'jorge.ramirez@correo.com'),
('Sara', 'Medina Torres', 'sara.medina@correo.com');

INSERT INTO Libro (titulo, autor, categoria, disponible) VALUES
('El arte de programar', 'Donald Knuth', 'Tecnología', 1),
('1984', 'George Orwell', 'Ficción', 1),
('Cien años de soledad', 'Gabriel García Márquez', 'Clásicos', 1),
('Introducción a MySQL', 'Michael Owens', 'Tecnología', 1);

INSERT INTO Prestamo (fecha_prestamo, id_usuario) VALUES
('2023-01-10', 3),
('2023-02-15', 1),
('2023-03-20', 2);

INSERT INTO Detalle_prestamo (id_libro, id_prestamo) VALUES
(1, 1),
(3, 1),
(2, 2),
(4, 3);

-- 1. Actualizar el autor del libro "Introducción a MySQL" por "Paul DuBois".
UPDATE Libro 
SET autor = 'Paul DuBois' 
WHERE titulo = 'Introducción a MySQL';

-- 2. Actualizar el email del usuario "Jorge Ramírez" a "jorge.r@correo.com".
UPDATE Usuario 
SET email = 'jorge.r@correo.com' 
WHERE nombre = 'Jorge' AND apellidos = 'Ramírez González';

-- 3. Actualizar el id_usuario 1 por 4.
UPDATE Usuario 
SET id_usuario = 4 
WHERE id_usuario = 1;

-- 4. Eliminar el libro con título "1984".
DELETE FROM Libro 
WHERE titulo = '1984';

-- 5. Eliminar el préstamo con id_prestamo 1.
DELETE FROM Prestamo 
WHERE id_prestamo = 1;

-- 1. Obtener el número total de libros prestados.
SELECT COUNT(*) AS total_libros_prestados FROM Prestamo;

-- 2. Listar todos los usuarios y, en caso de que tengan préstamos, mostrar también los libros que tienen.
SELECT u.*, l.* FROM Usuario u
INNER JOIN Prestamo p ON u.id_usuario = p.id_usuario
INNER JOIN Detalle_prestamo d ON p.id_prestamo = d.id_prestamo
INNER JOIN Libro l ON d.id_libro = l.id_libro;

-- 3. Contar cuántos préstamos ha realizado cada usuario.
SELECT COUNT(*), u.* FROM Prestamo p
INNER JOIN Usuario u ON p.id_usuario = u.id_usuario
GROUP BY id_usuario;



