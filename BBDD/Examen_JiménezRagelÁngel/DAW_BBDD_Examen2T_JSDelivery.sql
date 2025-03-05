DROP DATABASE IF EXISTS examen2t_jsdelivery;
CREATE DATABASE IF NOT EXISTS examen2t_jsdelivery;
USE examen2t_jsdelivery;

/* Tabla almacen. La empresa dispone de varios almacenes de envíos con distintas localizaciones */
CREATE TABLE almacen(
	id_almacen int(11) PRIMARY KEY AUTO_INCREMENT,
    dimensiones int(11) NOT NULL,
    capacidad int(11) NOT NULL,
    calle VARCHAR(128) NOT NULL,
    poblacion VARCHAR(128) NOT NULL,
    ciudad VARCHAR(128) NOT NULL,
    cod_postal VARCHAR(128) NOT NULL,
    cod_interno int(11) NOT NULL
);

/* Tabla repartidor. Lista de repartidores de la empresa */
CREATE TABLE repartidor(
	id_repartidor int(11) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(64) NOT NULL,
    apellidos VARCHAR(128) NOT NULL,
    DNI VARCHAR(32) NOT NULL,
    email VARCHAR(128) NOT NULL,
    telefono VARCHAR(32) NOT NULL,
    calle VARCHAR(128) NOT NULL,
    poblacion VARCHAR(128) NOT NULL,
    ciudad VARCHAR(128) NOT NULL,
    cod_postal VARCHAR(32) NOT NULL,
    turno VARCHAR(32) NOT NULL
);

/* Tabla furgoneta. Se usan para hacer los repartos */
CREATE TABLE furgoneta(
	id_furgoneta int(11) PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(64) NOT NULL,
    modelo VARCHAR(64) NOT NULL,
    fecha_compra DATE,
    combustible  VARCHAR(64) NOT NULL,
    capacidad int(11) NOT NULL
);

/* Tabla repartidor_furgoneta. Relaciona los repartidores con las furgonetas que conducen.
Una misma furgoneta la pueden conducir distintos repartidores, dependiendo de los turnos */
CREATE TABLE repartidor_furgoneta(
	id_repartidor int(11),
    id_furgoneta int(11),
    PRIMARY KEY (id_repartidor, id_furgoneta),
	CONSTRAINT repartidor_FK FOREIGN KEY (id_repartidor) REFERENCES repartidor (id_repartidor),
    CONSTRAINT furgoneta_FK FOREIGN KEY (id_furgoneta) REFERENCES furgoneta (id_furgoneta)
);

/* Tabla direccion. Contiene las direcciones destino de los envíos */
CREATE TABLE direccion(
	id_direccion int(11) PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(128) NOT NULL,
    ciudad VARCHAR(64) NOT NULL,
    codigo_postal INT(11) NOT NULL,
    poblacion VARCHAR(128) NOT NULL,
    nombre VARCHAR(64) NOT NULL,
    apellidos VARCHAR(128) NOT NULL,
    telefono VARCHAR(32) NOT NULL
);

/* Tabla envio. Es la tabla más importante de la base de datos */ 
CREATE TABLE envio (
	id_envio int(11) NOT NULL PRIMARY KEY auto_increment,
	direccion_destino int(11) NOT NULL,
	fecha_entrega DATE NOT NULL,
	almacen_origen int(11) NOT NULL,
	id_repartidor int(11) NOT NULL,
    CONSTRAINT direccion_FK FOREIGN KEY (direccion_destino) REFERENCES direccion (id_direccion),
    CONSTRAINT almacen_FK FOREIGN KEY (almacen_origen) REFERENCES almacen (id_almacen),
	CONSTRAINT repartidor_envio_FK FOREIGN KEY (id_repartidor) REFERENCES repartidor (id_repartidor)	
);

/* Inserción de datos en la tabla almacen */
INSERT INTO almacen (dimensiones, capacidad, calle, poblacion, ciudad, cod_postal, cod_interno) VALUES
	(1500, 250000, "Calle Sanitarios, 33", "Almuñecar", "Granada", "48210", 13530),
	(2750, 32055, "Polígono La Isla, Calle Filosofía 3", "Sevilla", "Sevilla", "41010", 70987),
	(550, 2670, "Calle Pinar 34", "San Fernando", "Cádiz", "34500", 46557),
	(15010, 1052800, "Calle Aplauso nº1", "San Juan del Puerto", "Huelva", "28040", 27465);

/* Inserción de datos en la tabla repartidor */
INSERT INTO repartidor (nombre, apellidos, dni, email, telefono, calle, poblacion, ciudad, cod_postal, turno) VALUES
	("Hugo", "Rodríguez", "34458844R", "hugo@deviantart.com", "8618244158", "Emmet Road", "Nordrhein-Westfalen", "New City", "47139", "primero"),
    ("Lucía", "Fernández", "90348922E", "lucia@ted.com", "4423265704", "708 5th Road", "Ilerna de la Frontera", "Atlántida", "09510", "segundo"),
    ("Daniel", "González", "67884412F", "daniel@shutterfly.com", "9175255325", "8 Kings Terrace", "Minas Morgul", "Tierra Media", "10040", "segundo"),
    ("Pablo", "López", "90758445M", "pablo@symantec.com", "3929226722", "37 Main Circle", "Gotham", "Gotham", "32090", "primero"),
    ("María", "Martínez", "31295567K", "maria@tinyurl.com", "1343217590", "258 Jay Lane", "Metrópolis", "Metrópolis", "3810", "primero"),
    ("Paula", "Guillén", "15993472D", "paula@4shared.com", "3022083905", "10489 Wayridge Point", "Rivendel", "Tierra Media", "43131", "segundo"),
    ("Álvaro", "Sánchez", "77956432N", "alvaro@yandex.ru", "5282398300", "3249 Macpherson Terrace", "Alezkar", "Alezkar", "54120", "segundo"),
    ("Lucas", "Ruiz", "32900966C", "lucas@soundcloud.com", "1281726596", "79 Rigney Way", "Elantris", "Elantris", "85423", "primero"),
    ("Alba", "Díaz", "82000023S", "alba@irs.gov", "4762154390", "675 Forest Run Way", "Coimbra", "Pangea", "3405-605", "primero"),
    ("Mateo", "Muñoz", "12990439P", "mateo@google.co.uk", "7802471002", "885 Barby Terrace", "Terris", "Terris", "02341", "primero");
    
/* Inserción de datos en la tabla furgoneta */
INSERT INTO furgoneta (marca, modelo, fecha_compra, combustible, capacidad) VALUES
	("Ford", "Tourneo", "2020-08-11", "diesel", 250),
    ("Mercedes", "Vito", "2012-02-22", "gasolina", 120),
    ("Citroën", "Jumper", "2018-04-20", "gasolina", 340),
    ("Renault", "Traffic", "2015-10-07", "diesel", 150);
    
/* Inserción de datos en la tabla repartidor_furgoneta */
INSERT INTO repartidor_furgoneta (id_repartidor, id_furgoneta) VALUES
	(1,2),
    (2,3),
    (3,1),
    (4,2),
    (5,1),
    (6,2),
    (7,3),
    (8,4),
    (9,1),
    (10,3);

/* Inserción de datos en la tabla direccion */
INSERT INTO direccion (id_direccion, calle, ciudad, codigo_postal, poblacion, nombre, apellidos, telefono) VALUES
	(54, "Calle Almadrabra, 4 3ºB", "Jaén", "32049", "Pegalajar", "Sergio", "Galleo Pérez","680749832"),
    (55, "Calle Mallén, 23", "Ciudad Real", "45119", "Miguelturra", "Esteban", "Guillén Jiménez","784148795"),
    (56, "C/ Tentudía 9 puerta B 5ºA", "Salamanca", "29412", "La Alberca", "Lorena", "Aparicio Ortega","66985213"),
    (57, "C. Río de Plata 8", "Madrid", "46903", "Pinto", "Jose Luis", "Sánchez Blanco","600479855"),
    (58, "Cl Villaverde num 5", "Oporto", "56601", "Oporto", "Marta", "Rey Rojo","750063244"),
    (59, "Calle Galileo n20", "Zaragoza", "64732", "La Muela", "Jesús", "Rivera Garrido","688471249"),
    (60, "C Arpa 89, 1ºD", "Valencia", "84320", "Benicasim", "Sandra", "Muñoz Dominguez","659784512");

/* Inserción de datos en la tabla envio */
INSERT INTO envio (id_envio, direccion_destino, fecha_entrega, almacen_origen, id_repartidor) VALUES
	(231, 57, "2022-04-12", 2, 3),
    (232, 60, "2022-02-04", 1, 5),
    (233, 54, "2021-12-30", 4, 7),
    (234, 59, "2021-12-23", 4, 9),
    (235, 58, "2022-02-02", 2, 2),
    (236, 55, "2022-03-30", 3, 1),
    (237, 56, "2022-04-01", 1, 5);

SELECT * FROM almacen;
SELECT * FROM repartidor;
SELECT * FROM furgoneta;
SELECT * FROM repartidor_furgoneta;
SELECT * FROM direccion;
SELECT * FROM envio;

-- 1.- Muestra la media de la capacidad de los almacenes
SELECT AVG(capacidad) AS media_capacidad_almacenes FROM almacen;

-- 2.- Obtén toda la información de los repartidores, y de aquellos que trabajen en el segundo turno, muestra también la información de sus envíos. Ordénalos por turno de forma ascendente.
SELECT r.*, e.* FROM repartidor r
INNER JOIN envio e ON r.turno = 'segundo'
GROUP BY r.id_repartidor ASC;

-- 3.- Cuenta cuántos repartidores hay por cada turno. Muestra la suma y el turno.
SELECT COUNT(*) AS suma_repartidores, turno AS turno FROM repartidor GROUP BY turno;

-- 4.- Muestra la información del almacén del pedido que debe entregar el repartidor cuyo email es "alba@irs.gov".
SELECT al.* FROM almacen al
INNER JOIN envio en ON al.id_almacen = en.almacen_origen
INNER JOIN repartidor re ON en.id_repartidor = re.id_repartidor;

-- 5.- Obtén el valor de las dimensiones del almacén más pequeño, pero que sea mayor de 1000 m2.
SELECT MIN(dimensiones) AS dimension_pequeña FROM almacen WHERE dimensiones > 1000;

-- 6.- Calcula la capacidad total que tienen los almacenes de JDelivery, pero sin contar el almacén de Huelva.
SELECT SUM(capacidad) AS capacidad_total FROM almacen WHERE ciudad != 'Huelva';

-- 7.- Muestra toda la información de la dirección de destino del envío que debe realizar el repartidor de nombre "Álvaro" y apellido "Sánchez". Debes usar una subconsulta.
SELECT * FROM envio WHERE id_repartidor IN (SELECT id_repartidor FROM repartidor WHERE nombre = 'Álvaro' AND apellidos = 'Sánchez');

-- 8.- Obtén toda la información de los repartidores que el nombre de su calle termine en "Way".
SELECT * FROM repartidor WHERE calle LIKE '%Way';

-- 9.- Muestra toda la información de las direcciones de aquellos envíos que no se hayan hecho todavía. No puedes usar la fecha de hoy tal cual, esta consulta debe funcionar da igual el día que se haga, es decir, usa una función para obtener el día en el que estamos.
SELECT * FROM envio WHERE fecha_entrega < CURRENT_DATE();

-- 10.- Muestra la información de las furgonetas, pero solo de aquellas furgonetas que la conduzcan más de un conductor.
SELECT * FROM furgoneta WHERE id_furgoneta IN (SELECT id_repartidor FROM repartidor) LIMIT 3;