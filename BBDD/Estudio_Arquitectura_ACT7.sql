-- 1. Crear la base de datos
DROP DATABASE IF EXISTS EstudioArquitectura;
CREATE DATABASE IF NOT EXISTS EstudioArquitectura;
USE EstudioArquitectura;

-- 2. Crear las tablas
DROP TABLE IF EXISTS Presupuestos, Proyectos, Arquitectos, Clientes;

CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    direccion VARCHAR(100),
    ciudad VARCHAR(50),
    telefono VARCHAR(15),
    dni VARCHAR(10)
);

CREATE TABLE Arquitectos (
    id_arquitecto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellidos VARCHAR(50),
    colegiado_numero VARCHAR(15)
);

CREATE TABLE Presupuestos (
    id_presupuesto INT AUTO_INCREMENT PRIMARY KEY,
    cantidad_inicial DECIMAL(10,2),
    cantidad_final DECIMAL(10,2), 
    estado VARCHAR(20),
    id_cliente INT,
    direccion VARCHAR(100), 
    fecha DATE,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

CREATE TABLE Proyectos (
    id_proyecto INT AUTO_INCREMENT PRIMARY KEY,
    id_presupuesto INT,
    titulo VARCHAR(100),
    descripcion TEXT,
    fecha_alta DATE,
    id_arquitecto INT,
    FOREIGN KEY (id_presupuesto) REFERENCES Presupuestos(id_presupuesto),
    FOREIGN KEY (id_arquitecto) REFERENCES Arquitectos(id_arquitecto)
);

-- 3. Insertar datos en las tablas

-- Insertar clientes
INSERT INTO Clientes (nombre, apellidos, direccion, ciudad, telefono, dni)
VALUES
('Juan', 'Pérez', 'Calle Ficticia 123', 'Sevilla', '654123456', '12345678A'),
('Ana', 'García', 'Avenida Real 456', 'Madrid', '655123457', '23456789B'),
('Luis', 'Martínez', 'Plaza Mayor 789', 'Sevilla', '656123458', '34567890C');

-- Insertar arquitectos
INSERT INTO Arquitectos (nombre, apellidos, colegiado_numero)
VALUES
('Carlos', 'Gómez', 'COA12345'),
('Laura', 'Sánchez', 'COA12346');

-- Insertar presupuestos
INSERT INTO Presupuestos (cantidad_inicial, cantidad_final, estado, id_cliente, direccion, fecha)
VALUES
(95000, 90000, 'INICIAL', 1, 'Calle Ficticia 123, Sevilla', '2021-06-15'),
(150000, 145000, 'PROYECTO', 2, 'Avenida Real 456, Madrid', '2021-07-20'),
(120000, 115000, 'INICIAL', 3, 'Plaza Mayor 789, Sevilla', '2021-08-10'),
(450000, 460000, 'PROYECTO', 1, 'Calle Ficticia 123, Sevilla', '2021-05-25');

-- Insertar proyectos
INSERT INTO Proyectos (id_presupuesto, titulo, descripcion, fecha_alta, id_arquitecto)
VALUES
(2, 'Reforma Casa Madrid', 'Reforma completa de la vivienda en Madrid', '2021-07-22', 1),
(4, 'Reforma Casa Sevilla', 'Reforma de cocina en Sevilla', '2021-05-30', 2);

-- 1. Muestra toda la información de los presupuestos y, además, de aquellos que se hayan convertido en un proyecto, muestra su título y su descripción.
SELECT p.*, pr.titulo AS titulo_proyecto, pr.descripcion AS descripcion_proyecto
FROM Presupuestos p
LEFT JOIN Proyectos pr ON p.id_presupuesto = pr.id_presupuesto;

-- 2. Cuenta cuántos presupuestos tiene el estudio en cada estado.
SELECT COUNT(*) AS NumeroEstudios FROM Presupuestos;

-- 3. Obtén el presupuesto más bajo dado en su cantidad inicial, pero que esté por encima de los 100.000 €.
SELECT MIN(cantidad_inicial) FROM presupuestos WHERE cantidad_inicial < '100000';

-- 4.  Muestra el nombre y el número de colegiado de los arquitectos que están realizando un proyecto cuyos presupuestos no pasaron de 100.000€ como cantidad inicial.
SELECT a.nombre, a.colegiado_numero 
FROM Arquitectos a, Proyectos pr, Presupuestos p
WHERE pr.id_arquitecto = a.id_arquitecto 
AND p.cantidad_inicial < '100000';

-- 5. De los presupuestos dados por el estudio en 2021, muestra la información de la dirección del cliente que vive en Sevilla.
SELECT DISTINCT c.direccion FROM Clientes c
INNER JOIN Presupuestos p ON c.id_cliente = p.id_cliente
WHERE c.ciudad = 'Sevilla'AND p.fecha LIKE '2021%';

-- 6. Muestra la información de todos clientes cuyos presupuestos hayan resultado ser más baratos que la cantidad inicial presupuestada.
SELECT c.* FROM Clientes c
INNER JOIN Presupuestos p ON c.id_cliente = p.id_cliente
WHERE p.cantidad_final < p.cantidad_inicial;

-- 7. Obtén la media de la cantidad inicial de los presupuestos que estén en estado “INICIAL”.
SELECT AVG(cantidad_inicial) FROM Presupuestos WHERE estado = 'INICIAL';
 
-- 8. Muestra cuántos clientes tiene el estudio de cada ciudad, pero muestra solo aquellas donde haya más de un cliente.
SELECT c.ciudad, COUNT(c.id_cliente) AS num_cliente
FROM Clientes c GROUP BY c.ciudad
HAVING COUNT(c.id_cliente) > 1;

-- 9. Muestra el presupuesto del que debe disponer de forma inicial cada cliente que tenga un presupuesto con el estudio de arquitectura.
SELECT c.id_cliente, p.cantidad_inicial FROM Clientes c, Presupuestos p
WHERE c.id_cliente = p.id_cliente;

-- 10. De los proyectos que contengan la palabra “Reforma” en su descripción, obtén el número de registro, el nombre y apellidos del arquitecto y la fecha en la que se dio de alta el presupuesto.
SELECT pr.id_proyecto, fecha_alta, a.nombre, apellidos FROM Proyectos pr
INNER JOIN Arquitectos a ON a.id_arquitecto = pr.id_arquitecto
WHERE pr.descripcion LIKE '%Reforma%';

-- 11. Muestra el nombre y los apellidos de los clientes que tengan un presupuesto que se realizará en Almería y que estén estado en “PROYECTO”.
SELECT c.nombre, apellidos FROM Clientes c, Presupuestos pr WHERE pr.direccion LIKE '%Almería%' AND pr.estado = 'PROYECTO';

-- 12. Obtén la mayor diferencia que ha habido entre la cantidad final presupuestada respecto a la cantidad inicial que se le ofreció al cliente.
SELECT MAX(pr.cantidad_inicial - pr.cantidad_final) AS Mayor_Diferencia FROM Presupuestos pr;

-- 13.  Muestra toda la información del presupuesto que se realizará en el Cabo de Gata.
SELECT p.* FROM Presupuestos p, Proyectos pr WHERE pr.descripcion LIKE '%Cabo de Gata%';

-- 14. Muestra toda la información de los presupuestos, y de aquellos que estén en estado “INICIAL”, muestra también la información del DNI y el teléfono del cliente
SELECT p.*, c.telefono dni FROM Presupuestos p
LEFT JOIN Clientes c ON p.id_cliente = c.id_cliente
WHERE p.estado = 'INICIAL';

-- 15. Obtén todos los presupuestos cuya cantidad inicial sea menor de 130.000€ y también aquellos cuya inicial sea mayor de 400.000€
SELECT pr.* FROM Presupuestos pr WHERE pr.cantidad_inicial < 130000 OR pr.cantidad_inicial > 400000;

-- 16. Muestra el id_presupuesto, la cantidad inicial y el estado del presupuesto más antiguo.
SELECT pr.id_presupuesto, cantidad_inicial, estado FROM Presupuestos pr ORDER BY pr.fecha ASC LIMIT 1; 

-- 17. Lista de presupuestos junto con el cliente y el arquitecto asignado.
SELECT p.*, c.nombre, c.apellidos, a.nombre, a.apellidos FROM Presupuestos p
INNER JOIN Clientes c ON p.id_cliente = c.id_cliente
LEFT JOIN Proyectos pr ON p.id_presupuesto = pr.id_presupuesto
LEFT JOIN Arquitectos a ON pr.id_arquitecto = a.id_arquitecto;

-- 18. Proyectos con su presupuesto y el cliente correspondiente.
SELECT pr.id_proyecto, pr.titulo, pr.descripcion, p.id_presupuesto, p.cantidad_inicial, p.cantidad_final, c.nombre, c.apellidos
FROM Proyectos pr
INNER JOIN Presupuestos p ON pr.id_presupuesto = p.id_presupuesto
INNER JOIN Clientes c ON p.id_cliente = c.id_cliente;

-- 19. Arquitectos con sus proyectos y el presupuesto asignado.
SELECT a.*, pr.*, p.cantidad_inicial, p.cantidad_final
FROM Arquitectos a
INNER JOIN Proyectos pr ON a.id_arquitecto = pr.id_arquitecto
INNER JOIN Presupuestos p ON p.id_presupuesto = pr.id_presupuesto;

-- 20. Cantidad de proyectos por arquitecto y la suma total de sus presupuestos.
SELECT a.id_arquitecto, a.nombre, a.apellidos, COUNT(pr.id_proyecto) AS cantidad_proyectos, SUM(p.cantidad_final) AS total_presupuestos
FROM Arquitectos a
INNER JOIN Proyectos pr ON a.id_arquitecto = pr.id_arquitecto
INNER JOIN Presupuestos p ON pr.id_presupuesto = p.id_presupuesto
GROUP BY a.nombre;