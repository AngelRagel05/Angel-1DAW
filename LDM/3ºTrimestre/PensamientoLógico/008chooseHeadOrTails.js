"use strict"

// Cara o cruz

// Crear un programa que permita escoger entre cara (🪙) o cruz (✖️). El programa luego debe generar un resultado aleatorio y mostrar si se 
// acertó o no. El programa debe mostrar en cada vuelta cuántas rondas seguidas acertadas van, y si en algún momento se erra, reiniciar el 
// contador a 0. También debe llevar una cuenta de la cantidad máxima de rondas seguidas que se hizo sin errar. Cuando se ingresa la opción 
// SALIR (🚪), en vez de CARA o CRUZ, el programa debe mostrar la cantidad máxima de rondas seguidas acertadas junto a un mensaje de despedida, 
// y terminar su ejecución.

let selected = "";
let check = false;

while (!check) {
    selected = prompt("Introduce cara o cruz. Escriba SALIR para salir del programa.").toLocaleLowerCase();
    switch (selected) {
        case "cara":
        case "cruz":
            correctChoose(selected, randomChoose());
            break;
        case "salir":
            check = true;
            break;

        default:
            alert("Opción no válida.");
            break;
    }
}

function correctChoose(selected, opcion) {
    let correct = 0;
    if (selected === opcion) {
        correct++;
        console.log(correct);

    } else {
        console.log("Has fallado.");
    }
}

function randomChoose() {
    let opcion = Math.random() < 0.5 ? "cara" : "cruz";
    return opcion;
}