// Crear un programa que pida adivinar tu cumpleaños ingresando por separado ingresar
// día y mes, en números, y mostrar luego si un mensaje si ha adivinado o no, cada parte,
// preguntar al usuario si quiere seguir jugando, darle 10 vidas 💚 que vaya perdiendo a
// medida que haga intentos. Y un mensaje al final de: //Has ganado 🏅!! o uno de: // Has perdido 😿 !!!

"use strict"

const YOU_WIN = "🏅 ¡Has ganado! 🏅";
const YOU_LOSE = "😿 ¡Has perdido! 😿";
const CORRECT_DAY = "✅ Día correcto.";
const CORRECT_MONTH = "✅ Mes correcto.";

const UP_DAY = "📈 Mi cumpleaños es en un día mayor.";
const DOWN_DAY = "📉 Mi cumpleaños es en un día menor.";

const UP_MONTH = "📈 Mi cumpleaños es en un mes mayor.";
const DOWN_MONTH = "📉 Mi cumpleaños es en un mes menor.";

const BIRTH_DAY = 4;
const BIRTH_MONTH = 11;

let vidas = 10;

const day_check = guessBirthDay();
if (day_check && vidas > 0) {
    const month_check = guessBirthMonth();
    
    if (month_check) {
        print(YOU_WIN);
    } else {
        print(YOU_LOSE);
    }
} else {
    print(YOU_LOSE);
}

function guessBirthDay() {
    while (vidas > 0) {
        let day = +prompt("📅 Introduce el día que crees que he nacido (1-31):", 1);

        if (day === BIRTH_DAY) {
            print(CORRECT_DAY);
            return true;
        } else if (day < BIRTH_DAY) {
            print(UP_DAY);
        } else {
            print(DOWN_DAY);
        }

        vidas--;
        print(`💚 Vidas restantes: ${vidas}`);
    }
    return false;
}

function guessBirthMonth() {
    while (vidas > 0) {
        let month = +prompt("📆 Ahora introduce el mes que crees que he nacido (1-12):", 1);

        if (month === BIRTH_MONTH) {
            print(CORRECT_MONTH);
            return true;
        } else if (month < BIRTH_MONTH) {
            print(UP_MONTH);
        } else {
            print(DOWN_MONTH);
        }

        vidas--;
        print(`💚 Vidas restantes: ${vidas}`);
    }
    return false;
}

function print(msg) {
    console.log(msg);
}