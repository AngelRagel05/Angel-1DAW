"use strict"

// Crea un objeto Map vacío llamado personajesUp.
let personajesUp = new Map();

// Añade al Map los siguientes personajes y sus roles en la película:
personajesUp.set("Carl Fredricksen", "Protagonista principal");  // Añade Carl Fredricksen con su rol.
personajesUp.set("Russell", "Explorador entusiasta");  // Añade Russell con su rol.
personajesUp.set("Dug", "Perro que habla");  // Añade Dug con su rol.
personajesUp.set("Kevin", "Ave tropical gigante");  // Añade Kevin con su rol.
personajesUp.set("Charles Muntz", "Antagonista");  // Añade Charles Muntz con su rol.

// Muestra por consola el contenido inicial del Map.
console.log("Contenido inicial del Map:");
console.log(personajesUp);  // Muestra el Map completo con los personajes y sus roles.

// Comprueba con has() si existen los personajes "Russell" y "Alpha" (el perro alfa). Muestra el resultado.
console.log("\n¿Existen los personajes?");
console.log(personajesUp.has("Russell"));  // Comprueba si existe el personaje "Russell".
console.log(personajesUp.has("Alpha"));  // Comprueba si existe el personaje "Alpha" (debe devolver false).

// Obtén y muestra el rol del personaje "Dug" con get().
console.log("\nRol del personaje 'Dug':");
console.log(personajesUp.get("Dug"));  // Muestra el rol del personaje "Dug".

// Actualiza el valor asociado a "Russell" a "Explorador leal y valiente" y muestra el nuevo valor.
personajesUp.set("Russell", "Explorador leal y valiente");  // Actualiza el rol de Russell.
console.log("\nNuevo rol de 'Russell':");
console.log(personajesUp.get("Russell"));  // Muestra el nuevo rol actualizado de Russell.

// Elimina al personaje "Charles Muntz" del Map usando delete() y muestra el contenido restante.
personajesUp.delete("Charles Muntz");  // Elimina a Charles Muntz del Map.
console.log("\nContenido después de eliminar a 'Charles Muntz':");
console.log(personajesUp);  // Muestra el Map después de la eliminación.

// Itera sobre los personajes y sus descripciones con forEach() y muestra cada par formateado así:
// "Carl Fredricksen: Protagonista principal"
console.log("\nIterando sobre el Map:");
personajesUp.forEach((value, key) => {
    console.log(`${key}: ${value}`);  // Muestra cada personaje con su rol en el formato deseado.
});

// Muestra cuántos personajes hay actualmente en el Map utilizando size.
console.log("\nNúmero de personajes en el Map:");
console.log(personajesUp.size);  // Muestra el número de personajes actuales en el Map.

// Vacía el Map usando clear() y verifica que esté vacío mostrando su contenido y tamaño.
personajesUp.clear();  // Elimina todos los elementos del Map.
console.log("\nContenido después de vaciar el Map:");
console.log(personajesUp);  // Muestra el Map vacío.
console.log("Tamaño del Map después de clear():");
console.log(personajesUp.size);  // Muestra el tamaño del Map (debe ser 0).
