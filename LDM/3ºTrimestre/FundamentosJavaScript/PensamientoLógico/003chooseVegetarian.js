"use strict"

// Preguntar al usuario qué comida desea realizar (almorzar o cenar). Si no se ingresa respuesta, por defecto se asigna "almorzar".
let food = prompt("Que comida desea realizar?") ?? "almorzar";

// Preguntar si el usuario es vegetariano (vegano) o no, la respuesta por defecto es "false".
let isVeggy = prompt("Es usted vegano? (true/false)", false);

// Comprobar si el usuario va a almorzar o cenar y recomendar un plato basado en si es vegano o no.
(food === "almorzar") ? 
    console.log((isVeggy === true) ? "Le recomiendo comer pasta con soja texturizada 🍝🍝" : "Le recomiendo comer tacos al pastor 🥙🥙") : 
(food === "cenar") ? 
    console.log((isVeggy === true) ? "Le recomiendo comer ensalada 🥗🥗" : "Le recomiendo comer sushi 🍣🍣") : 
// Si no se ha ingresado ni "almorzar" ni "cenar", mostrar un mensaje de error.
console.log("No se encuentra comida...");
