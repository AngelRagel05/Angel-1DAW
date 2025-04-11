"use strict"

// Crear un Set vacío llamado code.

// Añadir al Set los siguientes elementos (respetando el orden): "JavaScript", "Python", "Java", "JavaScript" (duplicado), "C++".
let code = new Set(["JavaScript", "Python", "Java", "JavaScript", "C++"]);

// Mostrar por consola el contenido inicial del Set y observar si se han insertado elementos duplicados.
console.log(code);

// Comprobar mediante el método has() si existen los elementos "Java" y "Ruby". Mostrar los resultados en consola.
console.log(code.has("Java"));
console.log(code.has("Ruby"));

// Eliminar el elemento "C++" usando el método delete() y mostrar el contenido actualizado.
code.delete("C++");
console.log(code);

// Iterar sobre los elementos del Set utilizando forEach() e imprimir cada elemento por consola.
code.forEach(cod => {
    console.log(cod);
});

// Mostrar el número total de elementos actuales en el Set utilizando la propiedad size.
console.log(code.size);

// Eliminar todos los elementos del Set con el método clear() y mostrar el Set vacío y su nuevo tamaño.
console.log(code.clear());