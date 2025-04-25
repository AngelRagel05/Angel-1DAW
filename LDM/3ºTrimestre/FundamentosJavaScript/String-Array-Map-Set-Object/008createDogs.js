"use strict"

// Crear un objeto vacío llamado dog 🐶
let dog = {};  // Se crea un objeto vacío llamado dog.

// Imprime el objeto dog en la consola
console.log(dog);  // Muestra el objeto vacío en la consola.

// Añade las propiedades name, legs, color, age y bark para el objeto dog.
// La propiedad bark es un método que devuelve "woof woof"
dog.name = "Firulais";  // Asigna el valor "Firulais" a la propiedad name.
dog.legs = 4;  // Asigna el valor 4 a la propiedad legs (patas).
dog.color = "Black";  // Asigna el valor "Black" a la propiedad color.
dog.age = 12;  // Asigna el valor 12 a la propiedad age (edad).
dog.bark = function() {  // Añade el método bark al objeto dog, que devuelve "woof woof".
    return "woof woof";
}

// Obtener name, legs, color, age y el valor de bark del objeto dog
console.log(dog.name);  // Muestra el valor de la propiedad name (Firulais).
console.log(dog.legs);  // Muestra el valor de la propiedad legs (4).
console.log(dog.color);  // Muestra el valor de la propiedad color (Black).
console.log(dog.age);  // Muestra el valor de la propiedad age (12).
console.log(dog.bark());  // Llama al método bark y muestra su valor ("woof woof").

// Establecer nuevas propiedades al objeto dog: breed, getDogInfo
dog.breed = "Doberman";  // Añade la propiedad breed con el valor "Doberman".
dog.getDogInfo = function() {  // Añade el método getDogInfo que devuelve información detallada del perro.
    return `Nombre: ${this.name}, Raza: ${this.breed}, Edad: ${this.age} años, Color: ${this.color}, Patas: ${this.legs}`;
}

console.log(dog.breed);  // Muestra el valor de la propiedad breed (Doberman).
console.log(dog.getDogInfo());  // Llama al método getDogInfo y muestra la información completa del perro.