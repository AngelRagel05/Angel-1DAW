// Crear un programa que pregunte si va el usuario va a almorzar o cenar, y si es vegetariano o no. 
// Dependiendo de las respuestas, debe recomendar un plato (es decir, debe haber cuatro platos posibles). 🍝🥗🥙🍣

"use strict"

let food = prompt("Que comida desea realizar?") ?? "almorzar";
let isVeggy = prompt("Es usted vegano? (true/false)", false);

(food === "almorzar") ? 
    console.log((isVeggy === true) ? "Le recomiendo comer pasta con soja texturizada 🍝🍝" : "Le recomiendo comer tacos al pastor 🥙🥙") : 
(food === "cenar") ? 
    console.log((isVeggy === true) ? "Le recomiendo comer ensalada 🥗🥗" : "Le recomiendo comer sushi 🍣🍣") : 
console.log("No se encuentra comida...");