"use strict"

// 006writeSeven.js/.html :
// Escribe una función que devuelva un array de siete números aleatorios en un rango de 0-9. Todos los números deben ser únicos.

function numbersRandom () {
    let array = [];

    while (array.length < 7) {
        let number = Math.floor(Math.random() * 10);
        if (!array.includes(number)) {
            array.push(number);
        }
    }
    return array;
}

console.log(numbersRandom());