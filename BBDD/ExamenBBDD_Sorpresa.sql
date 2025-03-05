DROP DATABASE IF EXISTS empresa;
CREATE DATABASE IF NOT EXISTS empresa;

USE empresa;

-- CREO LAS TABLAS --
CREATE TABLE IF NOT EXISTS departamentos (
departamento_id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
presupuesto DECIMAL(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS empleados (
id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
apellidos VARCHAR(50) NOT NULL,
salario DECIMAL(10, 2) NOT NULL,
fecha_contratacion DATE,
cargo VARCHAR(50),
departamento_id INT, 
FOREIGN KEY (departamento_id) REFERENCES departamentos(departamento_id)
);

CREATE TABLE IF NOT EXISTS proyectos (
id_proyectos INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
departamento_id INT, 
FOREIGN KEY (departamento_id) REFERENCES departamentos(departamento_id),
presupuesto_asignado DECIMAL(10, 2) NOT NULL
);

-- MODIFICO LAS TABLAS CREADAS --
-- Modifica la columna salario para que no permita valores nulos.
/* ALTER TABLE empleados
MODIFY salario DECIMAL(10, 2) NOT NULL; */

--  Agrega una nueva columna llamada cargo de tipo VARCHAR(50).
/* ALTER TABLE empleados
-- ADD cargo VARCHAR(50); */

-- Cambia el nombre de la columna fecha_contratacion a fecha_ingreso. 
ALTER TABLE empleados
CHANGE fecha_contratacion fecha_ingreso DATE;

-- Elimina la columna departamento_id. 
-- ESO NO SE PUEDE HACER PORQUE DESPUES TENGO QUE INTRODUCIR EL departamento_id
-- ALTER TABLE empleados
-- DROP COLUMN departamento_id;


-- INSERCIÓN DE DATOS --
INSERT INTO departamentos (nombre, presupuesto) VALUES
('Recursos Humanos', 120000),
('Marketing', 95000),
('Tecnología', 200000),
('Ventas', 80000),
('Finanzas', 150000);

INSERT INTO empleados (nombre, apellidos, salario, fecha_ingreso, cargo, departamento_id) VALUES
('Juan', 'Pérez', 3200.00, '2022-03-15', 'Gerente', 1),
('Ana', 'López', 2800.00, '2023-05-20', 'Analista', 2),
('Carlos', 'Martínez', 1500.00, '2021-07-10', 'Asistente', 3),
('María', 'Gómez', 4100.00, '2019-12-01', 'Gerente', 4),
('Luis', 'Fernández', 2900.00, '2020-02-25', 'Ejecutivo', 5),
('Elena', 'Ruiz', 2700.00, '2023-01-15', 'Coordinador', 1),
('Pedro', 'Sánchez', 2200.00, '2022-09-30', 'Técnico', 2),
('Laura', 'Díaz', 3500.00, '2020-11-05', 'Jefe de proyecto', 3),
('David', 'Torres', 2500.00, '2021-04-20', 'Programador', 4),
('Marta', 'Castillo', 3100.00, '2023-08-10', 'Diseñador', 5);

INSERT INTO proyectos (nombre, departamento_id, presupuesto_asignado) VALUES
('Reclutamiento Digital', 1, 75000),
('Campaña de Publicidad', 2, 110000),
('Desarrollo de Software', 3, 50000),
('Expansión de Ventas', 4, 45000),
('Análisis Financiero', 5, 120000),
('Automatización de RRHH', 1, 60000),
('Rediseño Web', 2, 30000),
('Seguridad en la Nube', 3, 40000),
('Plan de Incentivos', 4, 55000),
('Optimización de Costes', 5, 130000);

SELECT * FROM departamentos;
SELECT * FROM empleados;
SELECT * FROM proyectos;

-- MODIFICO LAS TABLAS
-- Incrementa en un 10% el salario de todos los empleados que tienen el cargo de "Gerente".
UPDATE empleados
SET salario = salario * 1.1
WHERE cargo = 'Gerente';

-- Cambia el nombre del proyecto "Desarrollo de Software" por "Desarrollo Ágil de Software".
UPDATE proyectos
SET nombre = 'Desarrollo Ágil de Software'
WHERE nombre = 'Desarrollo de Software';

-- Asigna todos los empleados que no tienen departamento (departamento_id IS NULL) al departamento de "Recursos Humanos".
UPDATE empleados
SET nombre = 'Recursos Humanos'
WHERE departamento_id IS NULL;

-- Cambia el cargo de todos los empleados cuyo salario sea menor a 2000 a "Junior".
UPDATE empleados
SET cargo = 'Junior'
WHERE salario < 2000;

-- Modifica la fecha de ingreso de "Ana López" a 1 de Junio de 2023 por un error en el registro.
UPDATE empleados
SET fecha_ingreso = 2023-06-01
WHERE nombre = 'Ana López';

SELECT * FROM departamentos;
SELECT * FROM empleados;
SELECT * FROM proyectos;

-- CONSULTA ÁNGEL
SELECT COUNT(*) AS total_trabajadores FROM empleados WHERE id IS NOT NULL;

-- CONSULTA ISMAEL
SELECT * FROM empleados WHERE fecha_ingreso > '2020-01-01';