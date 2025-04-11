"use strict"

// Crear un objeto vacío llamado dog 🐶
let dog = {};

// Imprime el objeto dog en la consola
console.log(dog);

// Añade las propiedades name, legs, color, age y bark para el objeto dog. La propiedad bark es un método que devuelve woof woof
dog.name = "Firulais";
dog.legs = 4;
dog.color = "Black";
dog.age = 12;
dog.bark = function() {
    return "woof woof";
}

// Obtener name, legs, color, age y el valor de bark del objeto dog
console.log(dog.name);
console.log(dog.legs);
console.log(dog.color);
console.log(dog.age);
console.log(dog.bark());

// Establecer nuevas propiedades al objeto dog: breed, getDogInfo
dog.breed = "Doberman";
dog.getDogInfo = function() {
    return `Nombre: ${this.name}, Raza: ${this.breed}, Edad: ${this.age} años, Color: ${this.color}, Patas: ${this.legs}`;
}

console.log(dog.breed);
console.log(dog.getDogInfo());