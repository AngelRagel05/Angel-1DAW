"use strict"

// 017compruebaRangoInterno.js/.html: Escribe una condición “if” para comprobar que age(edad) está entre 18 y 99 inclusive. 
// “Inclusive” significa que age puede llegar a ser uno de los extremos, 18 o 99.

let age = prompt("Introduce su edad.");
(age >= 19 && age <= 99) ? console.log("Su edad está entre el rango de 18-99 ambos incluidos") : console.log("Su edad no se encuentra entre el rango de 18-99");