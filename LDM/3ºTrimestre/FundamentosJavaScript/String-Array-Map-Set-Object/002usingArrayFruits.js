"use strict" 

// 002usingArrayFruits.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:

let fruits = ["Banana", "Manzana", "Fresa"];  // Array inicial con tres frutas: Banana, Manzana y Fresa.

// Añadimos cereza al principio
fruits.unshift("Cereza");  // Añade el elemento "Cereza" al principio del array.
console.log("Array después de añadir 'Cereza' al principio:", fruits);  // Muestra el array después de añadir "Cereza" al principio.

// Añadimos melocotón al final
fruits.push("Melocotón");  // Añade el elemento "Melocotón" al final del array.
console.log("Array después de añadir 'Melocotón' al final:", fruits);  // Muestra el array después de añadir "Melocotón" al final.

// Mostrar el array elemento a elemento con forEach
console.log("Array mostrado con forEach:");  
fruits.forEach(function(fruit) {  // Recorre cada elemento del array utilizando forEach.
    console.log(fruit);  // Muestra cada fruta del array.
});

// Eliminamos el primer elemento.
fruits.shift();  // Elimina el primer elemento del array (en este caso, "Cereza").
console.log("Array después de eliminar el primer elemento:", fruits);  // Muestra el array después de eliminar el primer elemento.

// Eliminamos el último elemento.
fruits.pop();  // Elimina el último elemento del array (en este caso, "Melocotón").
console.log("Array después de eliminar el último elemento:", fruits);  // Muestra el array después de eliminar el último elemento.

// Mostrar cada elemento con for of o for in, lo que considere más adecuado.
console.log("Array mostrado con for of:"); 
for (let fruit of fruits) {  // Usamos el bucle "for of" para recorrer y mostrar cada elemento del array.
    console.log(fruit);  // Muestra cada fruta.
}

console.log("Array mostrado con for in:");
for (let i in fruits) {  // Usamos el bucle "for in" para recorrer los índices del array.
    console.log(fruits[i]);  // Muestra el elemento en la posición actual del índice.
}
