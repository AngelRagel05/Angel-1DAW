"use strict"

// 003usingArrayDisney.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:

let disney = [
    { nombre: "Hércules", pelicula: "Hércules" },  // Personaje de la película "Hércules".
    { nombre: "Megana", pelicula: "Hércules" },  // Personaje de la película "Hércules".
    { nombre: "Hades", pelicula: "Hércules" },  // Personaje de la película "Hércules".
    { nombre: "Campanilla", pelicula: "Peter Pan" },  // Personaje de la película "Peter Pan".
    { nombre: "Wendy", pelicula: "Peter Pan" }  // Personaje de la película "Peter Pan".
];

// Meter a Peter Pan al final del array disney.
disney.push({ nombre: "Peter Pan", pelicula: "Peter Pan" });  // Añade el personaje "Peter Pan" al final del array.
console.log("Array después de añadir a Peter Pan al final:");  
for (let disn of disney) {  // Muestra cada elemento del array "disney" después de añadir a Peter Pan.
    console.log(disn);  // Muestra el objeto con nombre y película.
}

// Meter a El capitán Garfio al principio del array, no olvides la película
disney.unshift({ nombre: "Capitán Garfio", pelicula: "Peter Pan" });  // Añade "Capitán Garfio" al principio del array.
console.log("Array después de añadir al Capitán Garfio al principio:");
console.log(disney);  // Muestra el array después de añadir "Capitán Garfio" al principio.

// Meter al cocodrilo detrás del capitán, no olvides la película
disney.splice(1, 0, { nombre: "Cocodrilo", pelicula: "Peter Pan" });  // Inserta el cocodrilo en la posición 1, detrás del Capitán Garfio.
console.log("Array después de añadir al Cocodrilo detrás del Capitán Garfio:");
console.log(disney);  // Muestra el array después de añadir "Cocodrilo" después de "Capitán Garfio".

// Obtener los personajes de la película de "Peter Pan" y mostrarlos uno a uno.
console.log("\nPersonajes de Peter Pan:");
for (let disn of disney) {  // Recorre el array "disney".
    if (disn.pelicula === "Peter Pan") {  // Filtra los personajes cuya película es "Peter Pan".
        console.log(disn.nombre);  // Muestra el nombre del personaje.
    }
}

// Encontrar el índice de Campanilla.
console.log("\nÍndice de Campanilla:");
console.log(disney.findIndex(disn => disn.nombre === "Campanilla"));  // Encuentra el índice de "Campanilla" usando findIndex.

// Buscar al cocodrilo.
console.log("\nBuscando al cocodrilo:");
console.log(disney.find(disn => disn.nombre === "Cocodrilo"));  // Encuentra el objeto con el personaje "Cocodrilo" usando find.

// Escribe la función shuffle(array) que baraje (reordene de forma aleatoria) los elementos del array.
function shuffle(array) {
    let arrayCopia = array.slice();  // Crea una copia del array original para no modificar el original.
    for (let i = arrayCopia.length - 1; i > 0; i--) {  // Recorre el array desde el final.
        let j = Math.floor(Math.random() * (i + 1));  // Genera un índice aleatorio.
        [arrayCopia[i], arrayCopia[j]] = [arrayCopia[j], arrayCopia[i]];  // Intercambia los elementos en las posiciones i y j.
    }
    return arrayCopia;  // Devuelve el array reordenado aleatoriamente.
}

console.log("\nArray antes de hacer shuffle:");  
console.log(disney);  // Muestra el array original antes de realizar el shuffle.

let shuffleDisney = shuffle(disney);  // Aplica la función shuffle al array "disney".

console.log("\nArray después de hacer shuffle:");
console.log(shuffleDisney);  // Muestra el array reordenado aleatoriamente.
