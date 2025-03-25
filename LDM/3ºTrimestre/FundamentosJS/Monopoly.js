"use strict"

let tickets = [500, 200, 100, 50, 20, 10, 5, 2, 1];
let usedTickets = [0, 0, 0, 0, 0, 0, 0, 0, 0,];

let amount = 999;
let i=0;

while(amount > 0) {
    let quotient = amount/tickets[i];
    (amount % tickets[i] == 0) ? usedTickets[i] = quotient : usedTickets[i] = 0;
    amount -= tickets[i] * (quotient);
    i++;
}

console.log()