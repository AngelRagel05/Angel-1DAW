"use strict"

// Pido al usuario la base y la altura de su triángulo
let base = prompt("Ingresa la base de su triángulo.", 5);
let altura = prompt("Ingresa la altura de su triángulo.", 10);

// Calculo el área
let area = (base * altura) / 2;

// Muestro por consola el resultado
console.log("El área de su triángulo es: " + area)


// Le pido al usuario el año para averiguarlo
let year = prompt("Introduce el año que quiere saber si es o no biciesto.");

// Averiguo si es o no biciesto y lo muestro por consola

// Si el año introducido es divisible entre 100 o si ese mismo año entre 400 no es 0, 
// ese año no es biciesto. 
(year % 100 == 0 && year % 400 != 0) ? console.log("El año introducido no es biciesto.") :

// Si ha pasado el filtro anterior solo queda comprobar si es divisible entre 4
// si lo es, el año es biciesto sino no lo es
(year % 4 == 0) ? console.log("El año introducido si es bisiesto.") : 
console.log("El año introducido no es biciesto.");