// Crear un programa que pida adivinar tu cumpleaños ingresando por separado ingresar
// día y mes, en números, y mostrar luego si un mensaje si ha adivinado o no, cada parte,
// preguntar al usuario si quiere seguir jugando, darle 10 vidas 💚 que vaya perdiendo a
// medida que haga intentos. Y un mensaje al final de: //Has ganado 🏅!! o uno de: // Has perdido 😿 !!!

"use strict"

const BIRTH_DAY = 4;
const BIRTH_MONTH = 11;

let day = +prompt("Introduce el día que cree que he nacido.", 1);
let month = +prompt("Introduce el mes que cree que he nacido.", 1);
let count = 0;

function guessBirthDay (day) {
    while (day != BIRTH_DAY || count != 9) {
        day == BIRTH_DAY ? correctDay :
        day < BIRTH_DAY ? console.log("Mi cumpleaños es en un día mayor al dicho.") : console.log("Mi cumpleaños es en un día menor al dicho.");
        day = +prompt("Vuelve a introducir el día que cree que he nacido.", 1);
        count++;
    }
    
    
    
    
}

function youWin () {
    console.log("🎉 ¡Enhorabuena, has ganado! 🎉");
}

function correctDay () {
    console.log("Día correcto.");
}

function correctMonth () {
    console.log("Mes correcto.");
}