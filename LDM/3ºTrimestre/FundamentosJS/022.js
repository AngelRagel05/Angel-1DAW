// 022numPrimos.js/.html: Un número entero mayor que 1 es llamado primo si no puede ser dividido sin un resto por ningún número excepto 1 y él mismo. 
// En otras palabras, n > 1 es un primo si no puede ser divido exactamente por ningún número excepto 1 y n.

// Por ejemplo, 5 es un primo, porque no puede ser divido exactamente por 2, 3 y 4.

// Escribe el código que muestre números primos en el intervalo de 2 a n.
// Para n = 10 el resultado será 2, 3, 5, 7.
// PD. El código debería funcionar para cualquier n, no debe estar programado para valores fijos.
// ¿Puedes hacerlo con los 3 tipos de bucle? Demuéstralo.

"use strict";

// El uso de sqrt hace que la optimización del código sea mayor
// esa función lo que hace es la raiz cuadrada de (i) y si ese resultado por ejemplo sale 7
// solo tenemos que comprobar del 1 al 7,

let size = parseInt(prompt("Introduzca el valor de n:", "10"));

if (!isNaN(size) && size >= 2) {
    let primosFor = [];
    let primosWhile = [];
    let primosDoWhile = [];

    // Bucle FOR
    for (let i = 2; i <= size; i++) {
        let esPrimo = true;
        for (let j = 2; j <= Math.sqrt(i); j++) {
            if (i % j === 0) {
                esPrimo = false;
                break;
            }
        }
        if (esPrimo) primosFor.push(i);
    }

    // Bucle WHILE
    let i = 2;
    while (i <= size) {
        let esPrimo = true;
        let j = 2;
        while (j <= Math.sqrt(i)) {
            if (i % j === 0) {
                esPrimo = false;
                break;
            }
            j++;
        }
        if (esPrimo) primosWhile.push(i);
        i++;
    }

    // Bucle DO...WHILE
    i = 2;
    do {
        let esPrimo = true;
        let j = 2;
        do {
            if (i % j === 0 && i !== j) {
                esPrimo = false;
                break;
            }
            j++;
        } while (j <= Math.sqrt(i));
        if (esPrimo) primosDoWhile.push(i);
        i++;
    } while (i <= size);

    // Mostrar resultados
    alert("Números primos usando FOR: " + primosFor.join(", "));
    alert("Números primos usando WHILE: " + primosWhile.join(", "));
    alert("Números primos usando DO...WHILE: " + primosDoWhile.join(", "));

} else {
    alert("Número inválido. Introduce un valor mayor o igual a 2.");
}