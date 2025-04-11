"use strict"

// 005practiceWithBands.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:

// Definición del array de grupos con su nombre y género
let grupos = [
   {nombre: "ACDC", genero: "Rock"},  // Grupo de Rock ACDC
   {nombre: "Cold Play", genero: "Pop"},  // Grupo de Pop Cold Play
   {nombre: "NCT Dream", genero: "K-Pop"},  // Grupo de K-Pop NCT Dream
   {nombre: "Metallica", genero: "Heavy Metal"}  // Grupo de Heavy Metal Metallica
];

// Filtrar los grupos por género obteniendo aquellos que son de "Heavy Metal"
for (let grupo of grupos) {  // Recorre cada objeto del array "grupos"
    if (grupo.genero === "Heavy Metal") {  // Si el género del grupo es "Heavy Metal"
        console.log(grupo.nombre);  // Muestra el nombre del grupo que cumple con la condición
    }
}

// Buscar en los grupos usando “find” el grupo con Nombre “Cold Play”
let search = grupos.find(grupo => grupo.nombre === "Cold Play");  // Utiliza el método "find" para obtener el primer grupo con el nombre "Cold Play"
console.log(search);  // Muestra el objeto que contiene la información de "Cold Play"

// ¿En qué posición del array se encuentra “Cold Play”?
console.log("La posición es:");

// Recorre el array de grupos con un ciclo for para encontrar la posición de "Cold Play"
for (let i = 0; i < grupos.length; i++) {  // Itera sobre el array
    if (grupos[i].nombre === "Cold Play") {  // Si el nombre del grupo es "Cold Play"
        console.log(i);  // Muestra el índice donde se encuentra "Cold Play"
        i = grupos.length;  // Sale del ciclo para evitar seguir buscando
    }
}
