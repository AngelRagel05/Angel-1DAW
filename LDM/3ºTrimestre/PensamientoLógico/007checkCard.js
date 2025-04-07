"use strict"

// Crear una función que determine si una tarjeta es válida o no

// Debe permitir ingresar una cadena de caracteres
// Debe verificar que la cadena sea un numero de Luhn válido
// Debe verificar que pertenezca a algún tipo de tarjeta, siguiendo las siguientes reglas:
// American Express: Comienza con 34 o 37, tiene 15 dígitos.
// Visa: Comienza con 4, tiene 13 o 16 dígitos.
// MasterCard: Comienza con 51, 52, 53, 54 o 55, tiene 16 dígitos.
// Debe devolver un String con el tipo de la tarjeta 💳 ✅, o "invalid" ❌ si no es una tarjeta válida

let numberCard = prompt("Ingrese el número de la tarjeta:", "1111 1111 1111 1111");
let arrayCardNumber = numberCard.split("");



function verifyAmericanExpress(arrayCardNumber) {
    arrayCardNumber[0] === 3 && (arrayCardNumber[1] === 4 || arrayCardNumber[1] === 7) ?
        arrayCardNumber.length === 15 ? console.log("American Express. 💳✅") : console.log("Invalid. ❌") :
        console.log("Invalid. ❌");
}

function verifyVisa(arrayCardNumber) {
    arrayCardNumber[0] === 4 && (arrayCardNumber.length === 13 || arrayCardNumber.length === 16) ?
        console.log("Visa. 💳✅") : console.log("Invalid. ❌");
}

function verifyMasterCard(arrayCardNumber) {
    let beginning = arrayCardNumber[0] + arrayCardNumber[1];
    if (arrayCardNumber.length === 16) {
        switch (beginning) {
            case 51, 52, 53, 54, 55:
                console.log("Master Card. 💳✅");
                break;
            default:
                console.log("Invalid. ❌");
                break;
        }
    } else {
        console.log("Invalid. ❌");
    }
}

function verifyLuhn(arrayCardNumber) {
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

    if (suma % 10 == 0) {
        return true;
    } else {
        return false;
    }
}