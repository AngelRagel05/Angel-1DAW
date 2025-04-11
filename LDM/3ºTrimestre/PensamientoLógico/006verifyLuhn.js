"use strict"

// Algoritmo de Luhn: Función para verificar la validez de una tarjeta.
// Número de ejemplo: 4012-8888-8888-1881

let cardNumber = getCardNumber();  // Obtener el número de tarjeta
let suma = 0;  // Variable para acumular la suma
let arrayCardNumber = cardNumber.split("");  // Convertir el número de tarjeta en un array de dígitos

verifyNumber(arrayCardNumber);  // Verificar el número de tarjeta con el algoritmo de Luhn

// Función para solicitar y obtener el número de tarjeta
function getCardNumber() {
    while (true) {
        let cardNumber = prompt("Introduce el número de su tarjeta con el siguiente formato XXXX-XXXX-XXXX-XXXX", "4012-8888-8888-1881");

        // Eliminar los guiones y cualquier caracter no numérico
        const cleanCardNumber = cardNumber.replace(/\D/g, "");

        // Comprobar que el número de tarjeta tenga 16 dígitos
        if (cleanCardNumber.length === 16) {
            return cleanCardNumber;  // Devuelve el número limpio
        } else {
            alert("Por favor, introduce un número de tarjeta válido con 16 dígitos.");
        }
    }
}

// Función para verificar si el número de tarjeta es válido según el algoritmo de Luhn
function verifyNumber (arrayCardNumber) {
    // Recorrer los dígitos de la tarjeta de derecha a izquierda
    for (let i = arrayCardNumber.length - 2; i >= 0; i -= 2) {
        let digit = Number(arrayCardNumber[i]);

        // Multiplicar por 2 los dígitos en posiciones pares (empezando desde la derecha)
        digit = digit * 2;

        // Si el resultado es mayor a 9, restamos 9
        if (digit > 9) {
            digit = digit - 9;
        }

        // Asignamos el nuevo valor al array
        arrayCardNumber[i] = digit;
    }

    // Sumar todos los dígitos
    for (let i = 0; i < arrayCardNumber.length; i++) {
        suma += Number(arrayCardNumber[i]);
    }

    // Si el total es divisible entre 10, el número es válido
    if (suma % 10 === 0) {
        console.log("El número es válido. ✅");
    } else {
        console.log("El número no es válido. ❌");
    }
}
