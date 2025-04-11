"use strict"

// 004mapToName.js/.html: Tienes un array de objetos bands, cada uno tiene band.name. Escribe el código que lo convierta en un array de nombres.

// Definición de los objetos que representan a las bandas
let acdc = { name: " ACDC", age: 25 };  // Banda ACDC con su nombre y edad.
let metallica = { name: " Metallica", age: 30 };  // Banda Metallica con su nombre y edad.
let guns = { name: " Guns and Roses", age: 28 };  // Banda Guns and Roses con su nombre y edad.

// Array de bandas que contiene los objetos definidos anteriormente
let bands = [ acdc, metallica, guns ];  // Array que almacena los objetos de las bandas.

// Forma manual de extraer los nombres de las bandas
let names = [ acdc.name, metallica.name, guns.name ];  // Crea un array con los nombres de las bandas extraídos de cada objeto.
alert(names);  // Muestra el array de nombres con un alert.

