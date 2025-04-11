"use strict"

// Bucle que recorre los números del 1 al 100
for (let i = 0; i <= 100; i++) {
    // Si el número es múltiplo de 3 y 5 a la vez, mostrar "meloso" o 🧸
    if (i % 3 == 0 && i % 5 == 0) {
        console.log('🧸' + "\n"); // Muestra el emoji de osito de peluche
    } 
    // Si el número es múltiplo de 5, mostrar "oso" o 🐻
    else if (i % 5 == 0) {
        console.log('🐻' + "\n"); // Muestra el emoji de oso
    } 
    // Si el número es múltiplo de 3, mostrar "miel" o 🍯
    else if (i % 3 == 0) {
        console.log('🍯' + "\n"); // Muestra el emoji de miel
    } 
    // Si no es múltiplo de 3 ni de 5, simplemente muestra el número
    else {
        console.log(i + "\n"); // Muestra el número en la consola
    }
}
