"use strict"

// Definir constantes para los mensajes que se mostrarán al ganar, perder, y los mensajes de pista.
const YOU_WIN = "🏅 ¡Has ganado! 🏅";
const YOU_LOSE = "😿 ¡Has perdido! 😿";
const CORRECT_DAY = "✅ Día correcto.";
const CORRECT_MONTH = "✅ Mes correcto.";

const UP_DAY = "📈 Mi cumpleaños es en un día mayor.";
const DOWN_DAY = "📉 Mi cumpleaños es en un día menor.";

const UP_MONTH = "📈 Mi cumpleaños es en un mes mayor.";
const DOWN_MONTH = "📉 Mi cumpleaños es en un mes menor.";

// Definir las constantes con el día y mes correctos de cumpleaños.
const BIRTH_DAY = 4;
const BIRTH_MONTH = 11;

// Inicializar el contador de vidas (el usuario empieza con 10 vidas).
let vidas = 10;

// Llamar a la función que adivina el día y verificar si el jugador aún tiene vidas.
const day_check = guessBirthDay();
if (day_check && vidas > 0) {
    // Si el día es correcto, preguntar por el mes.
    const month_check = guessBirthMonth();
    
    // Si ambos, el día y el mes son correctos, el jugador gana.
    if (month_check) {
        print(YOU_WIN);
    } else {
        // Si el mes no es correcto, el jugador pierde.
        print(YOU_LOSE);
    }
} else {
    // Si no se adivina el día, el jugador pierde.
    print(YOU_LOSE);
}

// Función para adivinar el día de cumpleaños.
function guessBirthDay() {
    while (vidas > 0) {
        // Solicitar al usuario que adivine el día del cumpleaños.
        let day = +prompt("📅 Introduce el día que crees que he nacido (1-31):", 1);

        if (day === BIRTH_DAY) {
            // Si el día es correcto, mostrar mensaje de éxito.
            print(CORRECT_DAY);
            return true;
        } else if (day < BIRTH_DAY) {
            // Si el día es menor que el correcto, dar pista de que el día es mayor.
            print(UP_DAY);
        } else {
            // Si el día es mayor que el correcto, dar pista de que el día es menor.
            print(DOWN_DAY);
        }

        // Restar una vida por cada intento fallido.
        vidas--;
        print(`💚 Vidas restantes: ${vidas}`);
    }
    // Si no adivina el día en 10 intentos, retornar falso.
    return false;
}

// Función para adivinar el mes de cumpleaños.
function guessBirthMonth() {
    while (vidas > 0) {
        // Solicitar al usuario que adivine el mes del cumpleaños.
        let month = +prompt("📆 Ahora introduce el mes que crees que he nacido (1-12):", 1);

        if (month === BIRTH_MONTH) {
            // Si el mes es correcto, mostrar mensaje de éxito.
            print(CORRECT_MONTH);
            return true;
        } else if (month < BIRTH_MONTH) {
            // Si el mes es menor que el correcto, dar pista de que el mes es mayor.
            print(UP_MONTH);
        } else {
            // Si el mes es mayor que el correcto, dar pista de que el mes es menor.
            print(DOWN_MONTH);
        }

        // Restar una vida por cada intento fallido.
        vidas--;
        print(`💚 Vidas restantes: ${vidas}`);
    }
    // Si no adivina el mes en 10 intentos, retornar falso.
    return false;
}

// Función para imprimir los mensajes en consola.
function print(msg) {
    console.log(msg);
}
