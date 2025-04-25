"use strict"
// 014reescribeIfTernario.js/.html: Reescriba esta condición if usando el operador ternario:
let a = 1;
let b = 2;
let result;

// if (a + b < 4) {
//  result = 'Baja la ropa sucia';
// } else {
//  result = 'Sube los zapatos';
// }

a + b < 4 ? result = "Baja la ropa sucia" : result = "Sube los zapatos";

console.log(result);