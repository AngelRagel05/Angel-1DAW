USE hym_act7;

-- 1. Realiza una consulta y muestra todos los datos de las categorías.
SELECT * FROM categoria;

-- 2. Realiza una consulta y muestra los datos de la calle, la población y la ciudad de todos los almacenes
SELECT calle, poblacion, ciudad FROM almacen;

-- 3. Obtén los datos del email y la fecha de registro de todos los usuarios.
SELECT email, fecha_registro FROM usuario;

-- 4. Obtén la fecha de caducidad y si han sido usado o no, de todos los vales de descuento ordenado por fecha de caducidad de forma descendente.
SELECT fecha_caducidad, usado FROM vale_descuento ORDER BY fecha_caducidad DESC;

-- 5. Obtén todas las direcciones mostrando los valores de id_direccion, ciudad e id_usuario ordenado por id_usuario de forma ascendente.
SELECT id_direccion, ciudad, id_usuario FROM direccion ORDER BY id_usuario ASC;

-- 6. Muestra todos los datos de los productos cuyo stock sea mayor que 14.
SELECT * FROM producto WHERE stock > 14;

-- 7. Muestra los datos de la calle, ciudad y código postal de las direcciones que no estén marcadas como favoritas.
SELECT calle, ciudad, codigo_postal FROM direccion WHERE es_favorita = FALSE;

-- 8. Obtén los productos cuyo precio sea menor de 30, ordenados primero por el id_almacen y después por el nombre de forma descendente.
SELECT * FROM producto WHERE precio < 30 ORDER BY id_almacen DESC, nombre DESC;

-- 9. Obtén los datos de nombre y descripción de las categorías cuyo nombre empiecen por la letra ‘C’ ordenadas por el id_categoria de forma ascendente
SELECT nombre, descripcion FROM categoria WHERE nombre LIKE 'C%' ORDER BY id_categoria ASC;

-- 10. Muestra todos los datos de los almacenes ordenados alfabéticamente primero por el nombre de la calle y después por la capacidad_total de forma ascendente
SELECT * FROM almacen ORDER BY calle ASC, capacidad_total ASC;

-- 11. Muestra el precio del producto más alto.
SELECT MAX(precio) AS precio_mayor FROM producto;

-- 12. Cuenta cuántos pedidos ha realizado el usuario con id_usuario 5.
SELECT COUNT(*) AS total_compra FROM compra WHERE id_usuario = 5;

-- 13. Cuenta cuántos vales descuento no han sido usados y todavía no han caducado.
SELECT COUNT(*) AS vales_disponibles FROM vale_descuento WHERE usado = FALSE AND fecha_caducidad > NOW();

-- 14. Cuenta cuántos productos contienen la palabra “Fit” en su nombre.
SELECT COUNT(*) AS productos FROM producto WHERE nombre LIKE '%Fit%';

-- 15. Muestra el producto con el precio más bajo excluyendo los del almacén 2.
SELECT nombre, precio FROM producto WHERE id_almacen != 2 ORDER BY precio ASC LIMIT 1;

-- 16. Calcula la media del precio de los productos que tengan stock mayor de 10.
SELECT AVG(precio) AS media_precio FROM producto WHERE stock > 10;

-- 17. Cuenta cuántos usuarios son miembro-plus y tienen menos de 100 puntos acumulados.alter
SELECT COUNT(*) AS total_miembrosPlus FROM usuario WHERE tipo_miembro = 'miembro_plus' AND puntos_acumulados < 100;

-- 18. Cuenta cuántos almacenes tienen valores distintos de NULL en el campo capacidad_total.
SELECT COUNT(*) AS total_almacenes_NULL FROM almacen WHERE capacidad_total IS NOT NULL;

-- 19. De la tabla productos, muestra la suma del stock por cada almacén.
SELECT id_almacen, SUM(stock) FROM producto GROUP BY id_almacen;

-- 20. Calcula la media de valor total de las compras que se han realizado en 2021
SELECT AVG(total_compra) AS media_compra FROM compra WHERE fecha LIKE '2021-01-01';