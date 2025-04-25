"use strict"

// Pedir al usuario que ingrese una lista de monos 🐵 y bananas 🍌.
let entrada = prompt("Ingresa monos 🐵 y bananas 🍌:", "🐵🍌🍌🍌🐵🍌🐵🍌");

// La expresión regular /🐵/g busca todos los monos 🐵 en la cadena ingresada. Si no hay monos, devuelve un arreglo vacío.
let monos = (entrada.match(/🐵/g || [])).length;

// La expresión regular /🍌/g busca todas las bananas 🍌 en la cadena ingresada. Si no hay bananas, devuelve un arreglo vacío.
let bananas = (entrada.match(/🍌/g || [])).length;

// Verificar si no hay monos en la lista.
if (monos === 0) {
    alert("No hay monos en la lista. No se puede alimentar a ninguno 🧐");

} else if (bananas >= monos) { // Si hay suficientes bananas para cada mono.
    let cantBananas = Math.floor(bananas / monos); // Calculamos cuántas bananas le tocan a cada mono.
    alert(`Cada mono come ${cantBananas} ${cantBananas === 1 ? "banana" : "bananas"} 🍌`);

} else { // Si no hay suficientes bananas para todos los monos.
    alert("¡Oh no! ¡No hay suficientes bananas para los monos! 😭")
}
