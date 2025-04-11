"use strict"

// Replicar el juego de "Simón dice". El programa debe mostrar una secuencia de colores, agregando por cada ronda que pase otro color más. 
// El usuario debe ingresar los colores de la secuencia uno por uno. Si erra la secuencia (es decir, si ingresa algún color mal), el programa 
// debe terminar. Los colores posibles son: rojo🔴, azul🔵, verde 🟢y amarillo🟡. Hay dos variantes posibles: o el juego continúa indefinidamente 
// hasta que se erra la secuencia, y muestra cuántas rondas se sobrevivió, o el programa permite elegir al principio cuántas rondas se desea hacer, 
// y mostrar un mensaje de victoria si se llega a esa cantidad de rondas sin errarle a la secuencia.

const COLORS = ["🔴", "🔵", "🟢", "🟡"];  // Definimos los colores disponibles en el juego
let sequence = [];  // Esta variable almacenará la secuencia de colores generada por el programa
let number = 1;  // Variable para llevar la cuenta de las rondas
let successes = 1;  // Variable para contar cuántas rondas el usuario ha acertado consecutivamente

// Pedimos al usuario el número de rondas que desea jugar. Si no ingresa nada o elige un valor no válido, se le asigna un valor infinito (rondas infinitas).
let round = +prompt("Introduzca el número de rondas que desea realizar, sino se le asignará rondas infinitas.", Number.POSITIVE_INFINITY);

while (round !== 0) {  // Mientras el número de rondas no sea 0, el juego sigue
    // Elegimos un color aleatorio de la lista de colores y lo agregamos a la secuencia
    let randomColor = COLORS[Math.floor(Math.random() * COLORS.length)];
    sequence.push(randomColor);

    // Mostramos la secuencia completa para que el jugador la memorice
    alert(`Ronda ${number}:`);
    alert(sequence.join(" - "));

    // Creamos la secuencia en formato texto para comparar con la respuesta del jugador
    let result = sequence.join(" - ");

    // Pedimos al jugador que ingrese la secuencia de colores en el mismo formato
    let inserted =  prompt("Introduce la secuencia de colores con los emogis. Ejemplo 🟢 - 🟡 - 🔴 - 🔵");

    // Comparamos la secuencia ingresada por el jugador con la secuencia generada por el programa
    if (result == inserted) {
        console.log("Has acertado. ✅");  // Si la secuencia es correcta, mostramos un mensaje de éxito
        console.log(`Llevas ${successes} acertadas.`);  // Mostramos cuántas rondas ha acertado el jugador hasta el momento
        successes++;  // Aumentamos el contador de aciertos consecutivos
        round--;  // Restamos una ronda
    } else {
        console.log("Has fallado. ❌");  // Si la secuencia es incorrecta, mostramos un mensaje de fallo
        round = 0;  // Si se comete un error, terminamos el juego
    }
    number++;  // Incrementamos el número de ronda para la siguiente vuelta
}
