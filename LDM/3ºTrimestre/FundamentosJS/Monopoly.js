"use strict"

let tickets = [500, 200, 100, 50, 20, 10, 5, 2, 1];
let usedTickets = [0, 0, 0, 0, 0, 0, 0, 0, 0];

let amount = 999;
let i = 0;

while(amount > 0) {
    let quotient = parseInt(amount/tickets[i]);
    (amount % tickets[i] == 0) ? usedTickets[i] = quotient : 0;
    amount -= tickets[i] * (quotient);
    i++;
}

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