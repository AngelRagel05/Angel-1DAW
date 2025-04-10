"use strict"

// 005practiceWithBands.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:
 let grupos = [
   {nombre: "ACDC", genero: "Rock"},
   {nombre: "Cold Play", genero: "Pop"},
   {nombre: "NCT Dream", genero: "K-Pop"},
   {nombre: "Metallica", genero: "Heavy Metal"}
];
//filtra los grupos por género obtenido aquellos que son de Heavy Metal.
for (let grupo of grupos) {
    if (grupo.genero === "Heavy Metal") {
        console.log(grupo.nombre);
    }
}

//Busca en los grupos usando “find” el grupo con Nombre “Cold Play”.
let search = grupos.find(grupo => grupo.nombre === "Cold Play");
console.log(search);

//¿En qué posición del array se encuenta “Cold Play”?
console.log("La posición es:");

for (let i = 0; i < grupos.length; i++) {
    if (grupos[i].nombre === "Cold Play") {
        console.log(i);
        i = grupos.length;
    }
}