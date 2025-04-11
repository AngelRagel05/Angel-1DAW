"use strict"

// Cara o cruz

// Crear un programa que permita escoger entre cara (🪙) o cruz (✖️). El programa luego debe generar un resultado aleatorio y mostrar si se 
// acertó o no. El programa debe mostrar en cada vuelta cuántas rondas seguidas acertadas van, y si en algún momento se erra, reiniciar el 
// contador a 0. También debe llevar una cuenta de la cantidad máxima de rondas seguidas que se hizo sin errar. Cuando se ingresa la opción 
// SALIR (🚪), en vez de CARA o CRUZ, el programa debe mostrar la cantidad máxima de rondas seguidas acertadas junto a un mensaje de despedida, 
// y terminar su ejecución.

let selected = "";  // Variable que guarda la opción seleccionada por el usuario (cara, cruz o salir)
let check = false;  // Bandera para controlar el bucle principal del programa
let correct = 0;  // Contador de rondas seguidas acertadas
let maxCorrect = 0;  // Máxima cantidad de rondas acertadas consecutivas

while (!check) {  // Mientras no se haya decidido salir
    // Pedir al usuario que ingrese "cara", "cruz" o "salir"
    selected = prompt("Introduce cara o cruz. Escriba SALIR para salir del programa.").toLocaleLowerCase();

    // Comprobamos si el usuario ha elegido "cara" o "cruz"
    switch (selected) {
        case "cara":
        case "cruz":
            // Compara la elección del usuario con el resultado aleatorio
            if (selected === randomChoose()) {
                correct++;  // Si acertó, aumenta el contador de aciertos consecutivos
                console.log("Has acertado. ✅");
                
                // Si la cantidad de aciertos consecutivos es mayor que el máximo anterior, actualizamos el máximo
                if (maxCorrect < correct) {
                    maxCorrect = correct;
                }

            } else {
                // Si falló, reiniciamos el contador de aciertos consecutivos
                console.log("Has fallado. ❌");
                correct = 0;
            }
            
            break;

        case "salir":
            // Si el usuario escribió "salir", mostramos el máximo de aciertos consecutivos y terminamos el programa
            console.log("El máximo de aciertos es de: " + maxCorrect + ".");
            check = true;  // Terminamos el bucle

            break;

        default:
            // Si la opción no es válida, mostramos un mensaje de error
            alert("Opción no válida.");
            break;
    }
}

// Función que genera aleatoriamente "cara" o "cruz"
function randomChoose() {
    let opcion = Math.random() < 0.5 ? "cara" : "cruz";  // Si el valor generado es menor que 0.5, es "cara", si no, es "cruz"
    return opcion;  // Devolvemos la opción aleatoria
}
