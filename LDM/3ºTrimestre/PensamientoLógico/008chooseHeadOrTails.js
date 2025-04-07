"use strict"

// Cara o cruz

// Crear un programa que permita escoger entre cara (🪙) o cruz (✖️). El programa luego debe generar un resultado aleatorio y mostrar si se 
// acertó o no. El programa debe mostrar en cada vuelta cuántas rondas seguidas acertadas van, y si en algún momento se erra, reiniciar el 
// contador a 0. También debe llevar una cuenta de la cantidad máxima de rondas seguidas que se hizo sin errar. Cuando se ingresa la opción 
// SALIR (🚪), en vez de CARA o CRUZ, el programa debe mostrar la cantidad máxima de rondas seguidas acertadas junto a un mensaje de despedida, 
// y terminar su ejecución.

let selected = "";
let check = false;
let correct = 0;
let maxCorrect = 0;

while (!check) {
    selected = prompt("Introduce cara o cruz. Escriba SALIR para salir del programa.").toLocaleLowerCase();
    switch (selected) {
        case "cara":
        case "cruz":
            if (selected === randomChoose()) {
                correct++;
                console.log("Has acertado. ✅");
                
                if (maxCorrect < correct) {
                    maxCorrect = correct;
                }

            } else {
                console.log("Has fallado. ❌");
                correct = 0;
            }
            
            break;
        case "salir":
            console.log("El máximo de aciertos es de: " + maxCorrect + ".");
            check = true;
            break;

        default:
            alert("Opción no válida.");
            break;
    }
}

function randomChoose() {
    let opcion = Math.random() < 0.5 ? "cara" : "cruz";
    return opcion;
}