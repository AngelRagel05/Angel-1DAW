"use strict"

// 006writeSeven.js/.html :
// Escribe una función que devuelva un array de siete números aleatorios en un rango de 0-9. Todos los números deben ser únicos.

// Función que genera un array con siete números aleatorios únicos entre 0 y 9.
function numbersRandom() {
    let array = [];  // Inicializa un array vacío para almacenar los números aleatorios.

    // Bucle que continúa hasta que el array contenga 7 números únicos.
    while (array.length < 7) {  
        let number = Math.floor(Math.random() * 10);  // Genera un número aleatorio entre 0 y 9.

        // Verifica si el número generado ya está en el array. Si no está, lo agrega.
        if (!array.includes(number)) {  
            array.push(number);  // Añade el número único al array.
        }
    }

    return array;  // Devuelve el array con los 7 números aleatorios únicos.
}

console.log(numbersRandom());  // Llama a la función y muestra el resultado (el array de números aleatorios únicos).
