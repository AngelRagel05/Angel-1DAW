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

const ATTACK = "El jugador ataqua al monstruo.";
const DRINK_POTION = "El jugador se toma una poción.";
const SEARCH_POTION = "El jugador busca alguna poción.";
const EXIT = "Salir del juego.";

let playerLife = 100;
let monsterLife = 150;
let potion = 5;
const MAX_DAMAGE_PLAYER = 20;
const MAX_DAMAGE_MONSTER = 20;
const MAX_HEALING_POTION = 30;

let opc = 0;

runGame();

function runGame() {
    while (playerLife > 0 || monsterLife > 0) {
        showOption();
        switch (opc) {
            case 1:
    
                monsterAttack(MAX_DAMAGE_MONSTER, playerLife);
                showLifeEntities(playerLife, monsterLife);
                break;
    
            case 2:
    
                monsterAttack(MAX_DAMAGE_MONSTER, playerLife);
                showLifeEntities(playerLife, monsterLife);
                break;
    
            case 3:
    
                monsterAttack(MAX_DAMAGE_MONSTER, playerLife);
                showLifeEntities(playerLife, monsterLife);
                break;
    
            case 4:
    
                monsterAttack(MAX_DAMAGE_MONSTER, playerLife);
                showLifeEntities(playerLife, monsterLife);
                break;
    
            default:
    
                break;
        }
    }
}

function showOption() {
    console.log(ATTACK);
    console.log(DRINK_POTION);
    console.log(SEARCH_POTION);
    console.log(EXIT);
}

function monsterAttack(MAX_DAMAGE_MONSTER, playerLife) {
    let damage = Math.floor(Math.random() * MAX_DAMAGE_MONSTER) + 1;
    playerLife -= damage;
    console.log(`💥 El monstruo ataca y hace ${damage} de daño.`);
}

function showLifeEntities(playerLife, monsterLife) {
    console.log("La vida del jugador es: " + playerLife);
    console.log("La vida del monstruo es: " + monsterLife);
}