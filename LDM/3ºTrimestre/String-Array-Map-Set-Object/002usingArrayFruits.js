"use strict" 

// 002usingArrayFruits.js/.html: Ejecuta sobre el siguiente array las operaciones pedidas:

let fruits = ["Banana", "Manzana", "Fresa"];

//Añadimos cereza al principio
fruits.unshift("Cereza");
console.log("Array después de añadir 'Cereza' al principio:", fruits);

//Añadimos melocotón al final
fruits.push("Melocotón");
console.log("Array después de añadir 'Melocotón' al final:", fruits);

//Mostrar el array elemento a elemento con forEach
console.log("Array mostrado con forEach:");
fruits.forEach(function(fruit) {
    console.log(fruit);
});

//Eliminamos el primer elemento.
fruits.shift();
console.log("Array después de eliminar el primer elemento:", fruits);

//Eliminamos el último elemento.
fruits.pop();
console.log("Array después de eliminar el último elemento:", fruits);

//Mostrar cada elemento con for of o for in, lo que considere más adecuado.
console.log("Array mostrado con for of:"); 
for (let fruit of fruits) {                     //* YO USARIA EL FOR OF */
    console.log(fruit);
}

console.log("Array mostrado con for in:");
for (let i in fruits) {
    console.log(fruits[i]);
}