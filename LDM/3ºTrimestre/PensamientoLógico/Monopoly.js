"use strict"

// Definir los valores de los billetes y monedas disponibles
let tickets = [500, 200, 100, 50, 20, 10, 5, 2, 1];
// Array para almacenar la cantidad de billetes/monedas utilizadas de cada tipo
let usedTickets = [0, 0, 0, 0, 0, 0, 0, 0, 0];

// Monto total que se desea desglosar
let amount = 999;
// Índice para recorrer el array de billetes/monedas
let i = 0;

// Mientras el monto sea mayor que 0, seguimos desglosando en billetes/monedas
while(amount > 0) {
    // Calculamos cuántos billetes o monedas de la denominación actual podemos usar
    let quotient = parseInt(amount/tickets[i]);
    
    // Guardamos cuántos billetes/monedas de esa denominación se usarán
    usedTickets[i] = quotient;
    
    // Restamos el valor de los billetes/monedas utilizadas del monto total
    amount -= tickets[i] * (quotient);
    
    // Avanzamos al siguiente tipo de billete/moneda
    i++;
}

// Mostrar el resultado
console.log("Necesitaremos: ")
console.log("Billetes de 500€: " + usedTickets[0]);
console.log("Billetes de 200€: " + usedTickets[1]);
console.log("Billetes de 100€: " + usedTickets[2]);
console.log("Billetes de 50€: " + usedTickets[3]);
console.log("Billetes de 20€: " + usedTickets[4]);
console.log("Billetes de 10€: " + usedTickets[5]);
console.log("Billetes de 5€: " + usedTickets[6]);
console.log("Monedas de 2€: " + usedTickets[7]);
console.log("Monedas de 1€: " + usedTickets[8]);
