"use strict"

// Crear un programa que permita ingresar una lista de 🐵(monos) y 🍌(bananas). Preguntar luego cuántas bananas come cada mono. Mostrar en un mensaje si hay suficientes bananas para cada mono. Ejemplo:
// Ingresar monos y bananas: 🐵🍌🍌🍌🐵🍌🐵🍌
// Cuántas bananas come cada mono?: en este caso 2 bananas , 2 bananas y 1 banana, es decir, no se comparten, pero todos se comen alguna.
//o en caso de que no haya suficientes:
// ¡Oh no!¡No hay suficientes bananas para los monos! 😭

let entrada = prompt("Ingresa monos 🐵 y bananas 🍌:", "🐵🍌🍌🍌🐵🍌🐵🍌");

// El /🐵/g es una expresion regular que busca directamente el emogi.
// Uso el operador OR para que me devuleva siempre una array
let monos = (entrada.match(/🐵/g || [])).length;
let bananas = (entrada.match(/🍌/g || [])).length;

if (monos === 0) {
    alert("No hay monos en la lista. No se puede alimentar a ninguno 🧐");

} else if (bananas >= monos) {
    let cantBananas = Math.floor(bananas / monos);
    alert(`Cada mono come ${cantBananas} ${cantBananas === 1 ? "banana" : "bananas"} 🍌`);

} else {
    alert ("¡Oh no! ¡No hay suficientes bananas para los monos! 😭")
}