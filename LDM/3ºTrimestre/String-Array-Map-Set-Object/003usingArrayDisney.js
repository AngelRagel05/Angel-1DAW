"use strict"

// 003usingArrayDisney.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:

let disney = [
    { nombre: "Hércules", pelicula: "Hércules" },
    { nombre: "Megana", pelicula: "Hércules" },
    { nombre: "Hades", pelicula: "Hércules" },
    { nombre: "Campanilla", pelicula: "Peter Pan" },
    { nombre: "Wendy", pelicula: "Peter Pan" }
];

//Meter a Peter Pan al final del array disney.
disney.push({ nombre: "Peter Pan", pelicula: "Peter Pan" });

//Pintar el array
console.log("Array después de añadir a Peter Pan al final:");
for (let disn of disney) {
    console.log(disn);
}

//Meter a El capitán Garfio al principio del array, no olvides la película
disney.unshift({ nombre: "Capitán Garfio", pelicula: "Peter Pan" });

//Meter al cocodrilo detrás del capitán, no olvides la película
disney.splice(1, 0, { nombre: "Cocodrilo", pelicula: "Peter Pan" });

//Obtener los personajes de la película de "Peter Pan"; y mostrarlos uno a uno.
console.log("\nPersonajes de Peter Pan:");
for (let disn of disney) {
    if (disn.pelicula === "Peter Pan") {
        console.log(disn.nombre);
    }
}

//Encontrar el índice de Campanilla.
console.log("\nÍndice de Campanilla:");
console.log(disney.findIndex(disn => disn.nombre === "Campanilla"));

//Buscar al cocodrilo.
console.log("\nBuscando al cocodrilo:");
console.log(disney.find(disn => disn.nombre === "Cocodrilo"));

//Escribe la función shuffle(array) que baraje (reordene de forma aleatoria) los elementos del array.
function shuffle(array) {
    let arrayCopia = array.slice();
    for (let i = arrayCopia.length - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        [arrayCopia[i], arrayCopia[j]] = [arrayCopia[j], arrayCopia[i]];
    }
    return arrayCopia;
}

console.log("\nArray antes de hacer shuffle:");
console.log(disney);

let shuffleDisney = shuffle(disney);

console.log("\nArray después de hacer shuffle:");
console.log(shuffleDisney);