"use strict"

// Replicar el juego de "Simón dice". El programa debe mostrar una secuencia de colores, agregando por cada ronda que pase otro color más. 
// El usuario debe ingresar los colores de la secuencia uno por uno. Si erra la secuencia (es decir, si ingresa algún color mal), el programa 
// debe terminar. Los colores posibles son: rojo🔴, azul🔵, verde 🟢y amarillo🟡. Hay dos variantes posibles: o el juego continúa indefinidamente 
// hasta que se erra la secuencia, y muestra cuántas rondas se sobrevivió, o el programa permite elegir al principio cuántas rondas se desea hacer, 
// y mostrar un mensaje de victoria si se llega a esa cantidad de rondas sin errarle a la secuencia.

const COLORS = ["🔴", "🔵", "🟢", "🟡"];
let sequence = [];
let number = 1;
let successes = 1;

let round = +prompt("Introduzca el número de rondas que desea realizar, sino se le asignará rondas infinitas.", Number.POSITIVE_INFINITY);

while (round !== 0) {
    let randomColor = COLORS[Math.floor(Math.random() * COLORS.length)];
    sequence.push(randomColor);

    alert(`Ronda ${number}:`);
    alert(sequence.join(" - "));
    let result = sequence.join(" - ");
    let inserted =  prompt("Introduce la secuencia de colores con los emogis. Ejemplo 🟢 - 🟡 - 🔴 - 🔵");
    if (result == inserted) {
        console.log("Has acertado. ✅");
        console.log(`Llevas ${successes} acertadas.`);
        successes++;
        round--;

    } else {
        console.log("Has fallado. ❌");
        round = 0;
    }
    number++;
}