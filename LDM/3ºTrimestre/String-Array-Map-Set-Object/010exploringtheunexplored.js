"use strict"

// Crea un objeto Map vacío llamado personajesUp.
let personajesUp = new Map();

// Añade al Map los siguientes personajes y sus roles en la película:
personajesUp.set("Carl Fredricksen", "Protagonista principal");
personajesUp.set("Russell", "Explorador entusiasta");
personajesUp.set("Dug", "Perro que habla");
personajesUp.set("Kevin", "Ave tropical gigante");
personajesUp.set("Charles Muntz", "Antagonista");

// Muestra por consola el contenido inicial del Map.
console.log("Contenido inicial del Map:");
console.log(personajesUp);

// Comprueba con has() si existen los personajes "Russell" y "Alpha" (el perro alfa). Muestra el resultado.
console.log("\n¿Existen los personajes?");
console.log(personajesUp.has("Russell"));
console.log(personajesUp.has("Alpha"));

// Obtén y muestra el rol del personaje "Dug" con get().
console.log("\nRol del personaje 'Dug':");
console.log(personajesUp.get("Dug"));

// Actualiza el valor asociado a "Russell" a "Explorador leal y valiente" y muestra el nuevo valor.
personajesUp.set("Russell", "Explorador leal y valiente");
console.log("\nNuevo rol de 'Russell':");
console.log(personajesUp.get("Russell"));

// Elimina al personaje "Charles Muntz" del Map usando delete() y muestra el contenido restante.
personajesUp.delete("Charles Muntz");
console.log("\nContenido después de eliminar a 'Charles Muntz':");
console.log(personajesUp);

// Itera sobre los personajes y sus descripciones con forEach() y muestra cada par formateado así:
// "Carl Fredricksen: Protagonista principal"
console.log("\nIterando sobre el Map:");
personajesUp.forEach((value, key) => {
    console.log(`${key}: ${value}`);
});

// Muestra cuántos personajes hay actualmente en el Map utilizando size.
console.log("\nNúmero de personajes en el Map:");
console.log(personajesUp.size);

// Vacía el Map usando clear() y verifica que esté vacío mostrando su contenido y tamaño.
personajesUp.clear();
console.log("\nContenido después de vaciar el Map:");
console.log(personajesUp);
console.log("Tamaño del Map después de clear():");
console.log(personajesUp.size);
