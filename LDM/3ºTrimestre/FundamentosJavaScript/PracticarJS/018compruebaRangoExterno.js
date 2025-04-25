"use strict"

// 018compruebaRangoExterno.js/.html: Escribe una condición if para comprobar que age NO está entre 18 y 99 inclusive. Crea dos variantes: la primera usando NOT, y la segunda sin usarlo.

let age = prompt("Introduce su edad.");

age <= 18 && age >= 99 ? alert("Su edad no está entre el rango establecido") : alert("Su edad si está entre el rango asigando");

!(age >= 18 && age <= 99) ? alert("Su edad no está entre el rango establecido") : alert("Su edad si está entre el rango asigando");