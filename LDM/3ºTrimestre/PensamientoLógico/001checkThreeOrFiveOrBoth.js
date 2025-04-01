"use strict"

// Escribe un script que muestre por consola los
//  números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
//  Múltiplos de 3 por la palabra "miel" o 🍯.
// Múltiplos de 5 por la palabra "oso" o 🐻.
//  Múltiplos de 3 y de 5 a la vez por la palabra "meloso" o 🧸.

for (let i = 0; i <= 100; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
        console.log('🧸' + "\n");
    } else if (i % 5 == 0) {
        console.log('🐻' + "\n");
    } else if (i % 3 == 0) {
        console.log('🍯' + "\n");
    } else {
        console.log(i + "\n");
    }
}