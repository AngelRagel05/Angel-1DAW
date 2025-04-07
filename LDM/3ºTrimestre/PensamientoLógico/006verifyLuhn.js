"use strict"

// Algoritmo de Luhn: Se utiliza para verificar la validez de una tarjeta, pin, etc. Crear una función que devuelva si un número pasa el algoritmo de Luhn o no.
// Número de ejemplo: 4012-8888-8888-1881
// Se divide el número en dígitos.    4 0 1 2 8 8 8 8 8 8 8 8 1 8 8 1
// Se multiplica por 2 los dígitos que ocupan las posiciones pares contando de derecha a izquierda y empezando por 1, no por 0. 
//  8 0 2 2 16 8 16 8 16 8 16 8 2 8 16 1
// Los números mayor a 9 se restan por 9.  8 0 2 2 7 8 7 8 7 8 7 8 2 8 7 1
// Se suman todos los números. 90
// Si el resto de dividirlo por 10 es 0, el número es válido. ✅

let cardNumber = getCardNumber();
let suma = 0;
let arrayCardNumber = cardNumber.split("");
verifyNumber(arrayCardNumber);



function getCardNumber() {
    while (true) {
        let cardNumber = prompt("Introduce el número de su tarjeta con el siguiente formato XXXX-XXXX-XXXX-XXXX", "4012-8888-8888-1881");

        // El regex está pedido al ChatGPT quita los guiones entre los números
        const cleanCardNumber = cardNumber.replace(/\D/g, "");

        if (cleanCardNumber.length === 16) {
            return cleanCardNumber;
        } else {
            alert("Por favor, introduce un número de tarjeta válido con 16 dígitos.");
        }
    }
}

function verifyNumber (arrayCardNumber) {
    for (let i = 0; i < arrayCardNumber.length; i++) {
        if (i % 2 == 0) {
            arrayCardNumber[i] = arrayCardNumber[i] * 2;
        }
    }
    
    for (let i = 0; i < arrayCardNumber.length; i++) {
        if (arrayCardNumber[i] > 9) {
            arrayCardNumber[i] = arrayCardNumber[i] - 9;
        }
    }
    
    for (let i = 0; i < arrayCardNumber.length; i++) {
        suma = suma + Number(arrayCardNumber[i]);
    }
    
    if(suma % 10 == 0) {
        console.log("El número es válido. ✅");
    } else {
        console.log("El número no es válido. ❌");
    }
}

function print(msg) {
    console.log(msg);
}