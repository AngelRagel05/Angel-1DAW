"use strict"

// Crear un Set vacío llamado code.
let code = new Set(["JavaScript", "Python", "Java", "JavaScript", "C++"]);

// Mostrar por consola el contenido inicial del Set y observar si se han insertado elementos duplicados.
console.log(code);  // Al ser un Set, los duplicados no se agregan, así que "JavaScript" aparece solo una vez.

// Comprobar mediante el método has() si existen los elementos "Java" y "Ruby". Mostrar los resultados en consola.
console.log(code.has("Java"));  // Comprobar si "Java" existe en el Set. Devolverá true o false.
console.log(code.has("Ruby"));  // Comprobar si "Ruby" existe en el Set. Devolverá true o false.

// Eliminar el elemento "C++" usando el método delete() y mostrar el contenido actualizado.
code.delete("C++");  // Elimina el elemento "C++" del Set.
console.log(code);  // Muestra el Set después de la eliminación de "C++".

// Iterar sobre los elementos del Set utilizando forEach() e imprimir cada elemento por consola.
code.forEach(cod => {  // Recorre cada elemento del Set y lo imprime.
    console.log(cod);
});

// Mostrar el número total de elementos actuales en el Set utilizando la propiedad size.
console.log(code.size);  // Muestra el número de elementos restantes en el Set (sin duplicados).

// Eliminar todos los elementos del Set con el método clear() y mostrar el Set vacío y su nuevo tamaño.
console.log(code.clear());  // Elimina todos los elementos del Set, dejándolo vacío.
