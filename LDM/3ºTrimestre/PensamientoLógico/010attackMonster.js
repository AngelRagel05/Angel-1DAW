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

const ATTACK = "1️⃣ -> ¡El jugador se prepara y lanza un ataque feroz al monstruo!";
const DRINK_POTION = "2️⃣ -> El jugador decide tomar una poción y recuperar fuerzas.";
const SEARCH_POTION = "3️⃣ -> El jugador busca valientemente pociones en los alrededores.";
const EXIT = "4️⃣ -> El jugador decide abandonar la batalla y salir del juego.";

const MAX_DAMAGE_PLAYER = 20;
const MAX_DAMAGE_MONSTER = 20;
const MAX_HEALING_POTION = 30;

let playerLife = 100;
let monsterLife = 150;
let potion = 5;
let check = false;

runGame();

function runGame() {
    showOption();
    while (playerLife > 0 && monsterLife > 0 && !check) {

        switch (chooseOption()) {
            case 1:
                playerAttack();
                attackAndLifes();
                break;

            case 2:
                drinkPotion();
                attackAndLifes();
                break;

            case 3:
                searchPotion();
                attackAndLifes();
                break;

            case 4:
                console.log("Has salido del juego, vuelva pronto.");
                check = true;
                break;

            default:
                console.log("Si entra aquí algo falla.");
                break;
        }
    }

    if (playerLife <= 0) {
        console.log("El monstruo ha ganado el juego.");
    } else if (monsterLife <= 0) {
        console.log("El jugador ha ganado el juego.");
    }
}

function showOption() {
    console.log(ATTACK);
    console.log(DRINK_POTION);
    console.log(SEARCH_POTION);
    console.log(EXIT);
}

function chooseOption() {
    let option = +prompt("Introduce la opción que desea realizar.", 4)
    while (option > 4 || option < 1) {
        option = +prompt("Opción no válida, vuelve a introducirlo. (1-4)", 4)
    }
    return option;
}

function playerAttack() {
    let damage = Math.floor(Math.random() * MAX_DAMAGE_PLAYER) + 1;
    monsterLife -= damage;
    console.log(`💥 ¡Un golpe directo! El jugador ataca y hace ${damage} puntos de daño al monstruo. ¡El monstruo está herido!`);
}

function drinkPotion() {
    if (potion > 0) {
        let healing = Math.floor(Math.random() * MAX_HEALING_POTION) + 1;
        playerLife += healing;
        potion--;
        console.log(`🩺 ¡La poción surte efecto! Has curado ${healing} puntos de vida. ¡Te sientes más fuerte!`);
    } else {
        console.log("😔 No tienes pociones disponibles. ¡Debes encontrar más!");
    }
}

function searchPotion() {
    let found = Math.floor(Math.random() * 4) + 1;
    if (found === 1) {
        potion++;
        console.log("🧪 ¡La suerte está de tu lado! Has encontrado una poción en el suelo.");
    } else {
        console.log("😕 Buscas por los alrededores, pero no encuentras ninguna poción. ¡Sigue buscando!");
    }
}


function attackAndLifes() {
    monsterAttack();
    showLifeEntities();
}

function monsterAttack() {
    let damage = Math.floor(Math.random() * MAX_DAMAGE_MONSTER) + 1;
    playerLife -= damage;
    console.log(`💥 ¡El monstruo te ataca! Hace ${damage} puntos de daño. ¡Cuidado!`);
}

function showLifeEntities() {
    console.log(`❤️ La vida del jugador es: ${playerLife}`);
    console.log(`💜 La vida del monstruo es: ${monsterLife}`);
    console.log(`🧪 Pociones restantes: ${potion}`);
}