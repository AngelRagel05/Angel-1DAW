"use strict"

// 👾 Monstruo

// Crear un juego de combate contra un monstruo. El juego debe contar con las siguientes variables:
// Vida jugador/a ❤️
// Vida monstruo 💜
// Cantidad de pociones 🧪
// Ataque máximo jugador/a ⚔️
// Ataque máximo monstruo 👾
// Curación máxima poción 🩺
// Tod@s los valores anteriores deben ser números enteros (elíjanlos ustedes)

// El juego debe tener las siguientes acciones posibles:
// ATACAR MONSTRUO: genera un número aleatorio entre 1 y Ataque máximo jugadora y lo resta a Vida monstruo
// TOMAR POCION: genera un número aleatorio entre 1 y Curación máxima poción y lo suma a Vida jugador/a y resta 1 a Cantidad de pociones
// BUSCAR POCION: genera un número entre 1 y 4, si sale 1 suma una poción, sino no encuentra nada
// SALIR: termina el programa
// En todo momento se debe mostrar un mensaje de lo que está pasando
// Luego de cada acción, el monstruo ataca a la jugadora y le resta a Vida jugadora un número aleatorio entre 1 y Ataque máximo monstruo
// Luego del ataque del monstruo, se debe mostrar la vida de ambos
// El programa termina cuando o la jugador/a o el monstruo se quedan con vida igual o menor a 0
// Mostrar un mensaje con el resultado final

const ATTACK = "1️⃣ -> ¡El jugador se prepara y lanza un ataque feroz al monstruo!"; // Opción de ataque
const DRINK_POTION = "2️⃣ -> El jugador decide tomar una poción y recuperar fuerzas."; // Opción de tomar poción
const SEARCH_POTION = "3️⃣ -> El jugador busca valientemente pociones en los alrededores."; // Opción de buscar poción
const EXIT = "4️⃣ -> El jugador decide abandonar la batalla y salir del juego."; // Opción de salir

// Definimos los valores máximos para los daños y curaciones
const MAX_DAMAGE_PLAYER = 20; // Daño máximo que el jugador puede infligir
const MAX_DAMAGE_MONSTER = 20; // Daño máximo que el monstruo puede infligir
const MAX_HEALING_POTION = 30; // Curación máxima de las pociones

// Definimos la vida inicial del jugador, el monstruo y la cantidad de pociones
let playerLife = 100;
let monsterLife = 150;
let potion = 5;
let check = false; // Variable que controla el fin del juego

// Función principal que ejecuta el juego
runGame();

function runGame() {
    showOption(); // Mostrar las opciones disponibles para el jugador
    while (playerLife > 0 && monsterLife > 0 && !check) { // Mientras ambos tengan vida, el juego continúa
        switch (chooseOption()) { // Elegir la opción que el jugador selecciona
            case 1: // Atacar al monstruo
                playerAttack();
                attackAndLifes();
                break;

            case 2: // Tomar poción
                drinkPotion();
                attackAndLifes();
                break;

            case 3: // Buscar poción
                searchPotion();
                attackAndLifes();
                break;

            case 4: // Salir del juego
                console.log("Has salido del juego, vuelva pronto.");
                check = true; // Terminar el juego
                break;

            default:
                console.log("Si entra aquí algo falla.");
                break;
        }
    }

    // Verificar el resultado del juego
    if (playerLife <= 0) {
        console.log("El monstruo ha ganado el juego.");
    } else if (monsterLife <= 0) {
        console.log("El jugador ha ganado el juego.");
    }
}

// Función para mostrar las opciones al jugador
function showOption() {
    console.log(ATTACK); // Opción de atacar
    console.log(DRINK_POTION); // Opción de tomar poción
    console.log(SEARCH_POTION); // Opción de buscar poción
    console.log(EXIT); // Opción de salir
}

// Función para elegir la opción del jugador
function chooseOption() {
    let option = +prompt("Introduce la opción que desea realizar.", 4) // Pedir al jugador la opción
    while (option > 4 || option < 1) { // Validar que la opción esté dentro del rango
        option = +prompt("Opción no válida, vuelve a introducirlo. (1-4)", 4)
    }
    return option; // Retornar la opción seleccionada
}

// Función para realizar el ataque del jugador
function playerAttack() {
    let damage = Math.floor(Math.random() * MAX_DAMAGE_PLAYER) + 1; // Generar un daño aleatorio
    monsterLife -= damage; // Restar el daño a la vida del monstruo
    console.log(`💥 ¡Un golpe directo! El jugador ataca y hace ${damage} puntos de daño al monstruo. ¡El monstruo está herido!`);
}

// Función para que el jugador tome una poción
function drinkPotion() {
    if (potion > 0) { // Si hay pociones disponibles
        let healing = Math.floor(Math.random() * MAX_HEALING_POTION) + 1; // Generar una curación aleatoria
        playerLife += healing; // Sumar la curación a la vida del jugador
        potion--; // Restar una poción
        console.log(`🩺 ¡La poción surte efecto! Has curado ${healing} puntos de vida. ¡Te sientes más fuerte!`);
    } else {
        console.log("😔 No tienes pociones disponibles. ¡Debes encontrar más!");
    }
}

// Función para que el jugador busque una poción
function searchPotion() {
    let found = Math.floor(Math.random() * 4) + 1; // Generar un número aleatorio entre 1 y 4
    if (found === 1) { // Si el número es 1, el jugador encuentra una poción
        potion++;
        console.log("🧪 ¡La suerte está de tu lado! Has encontrado una poción en el suelo.");
    } else {
        console.log("😕 Buscas por los alrededores, pero no encuentras ninguna poción. ¡Sigue buscando!");
    }
}

// Función para ejecutar el ataque del monstruo y mostrar las vidas
function attackAndLifes() {
    monsterAttack(); // El monstruo ataca
    showLifeEntities(); // Mostrar las vidas actuales de ambos
}

// Función para realizar el ataque del monstruo
function monsterAttack() {
    let damage = Math.floor(Math.random() * MAX_DAMAGE_MONSTER) + 1; // Generar daño aleatorio del monstruo
    playerLife -= damage; // Restar el daño a la vida del jugador
    console.log(`💥 ¡El monstruo te ataca! Hace ${damage} puntos de daño. ¡Cuidado!`);
}

// Función para mostrar las vidas del jugador, el monstruo y las pociones restantes
function showLifeEntities() {
    console.log(`❤️ La vida del jugador es: ${playerLife}`);
    console.log(`💜 La vida del monstruo es: ${monsterLife}`);
    console.log(`🧪 Pociones restantes: ${potion}`);
}
