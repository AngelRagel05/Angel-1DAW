"use strict"

// Crear una función que determine si una tarjeta es válida o no

// Debe permitir ingresar una cadena de caracteres
// Debe verificar que la cadena sea un número de Luhn válido
// Debe verificar que pertenezca a algún tipo de tarjeta (American Express, Visa, MasterCard)
// Devuelve el tipo de tarjeta 💳 ✅, o "invalid" ❌ si no es una tarjeta válida

let suma = 0;  // Variable para almacenar la suma total según el algoritmo de Luhn
let check = false;  // Bandera para indicar si la tarjeta es válida
let card = "";  // Variable para almacenar el tipo de tarjeta

while (!check) {  // Mientras no se haya detectado una tarjeta válida
    let numberCard = prompt("Ingrese el número de la tarjeta:", "1111 1111 1111 1111");  // Pedir número de tarjeta
    let cleanNumberCard = numberCard.replace(/\D/g, "");  // Eliminar espacios o caracteres no numéricos
    let arrayCardNumber = cleanNumberCard.split("");  // Convertir el número en un array de caracteres

    // Verificar tipo de tarjeta: American Express, Visa o MasterCard
    card = verifyAmericanExpress(arrayCardNumber) === 1 ?
        "American Express 💳" :  // Si es American Express
        verifyVisa(arrayCardNumber) === 1 ?
            "Visa 💳" :  // Si es Visa
            verifyMasterCard(arrayCardNumber) === 1 ?
                "Master Card 💳" : "";  // Si es MasterCard

    // Si no es una tarjeta válida, mostrar mensaje de error
    if (card === "") {
        alert("❌ No es una tarjeta válida (debe ser Visa, MasterCard o American Express). Intenta de nuevo.");
    } else {
        console.log(`${card} detectada ✅`);  // Muestra el tipo de tarjeta detectada

        // Si es una tarjeta válida, verificar si pasa el algoritmo de Luhn
        if (verifyLuhn(arrayCardNumber)) {
            console.log(`${card} válida (Luhn correcto) ✅✅`);  // Si la tarjeta es válida según Luhn
            check = true;  // Finaliza el ciclo si la tarjeta es válida
        } else {
            console.log(`${card} no es válida según el algoritmo de Luhn. ❌`);  // Si no pasa el algoritmo de Luhn
            card = "";  // Reiniciar si la tarjeta no pasa Luhn
        }
    }
}

// Función para verificar si es una tarjeta American Express
function verifyAmericanExpress(arrayCardNumber) {
    // American Express comienza con 34 o 37 y tiene 15 dígitos
    return arrayCardNumber[0] == 3 && (arrayCardNumber[1] == 4 || arrayCardNumber[1] == 7) ?
        arrayCardNumber.length === 15 ? 1 : 0 : 0;
}

// Función para verificar si es una tarjeta Visa
function verifyVisa(arrayCardNumber) {
    // Visa comienza con 4 y tiene 13 o 16 dígitos
    return arrayCardNumber[0] == 4 && (arrayCardNumber.length === 13 || arrayCardNumber.length === 16) ? 1 : 0;
}

// Función para verificar si es una tarjeta MasterCard
function verifyMasterCard(arrayCardNumber) {
    let beginning = arrayCardNumber[0] + arrayCardNumber[1];  // Obtener los dos primeros dígitos

    // MasterCard debe tener 16 dígitos y empezar con 51, 52, 53, 54 o 55
    if (arrayCardNumber.length === 16) {
        switch (Number(beginning)) {
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                return 1;  // Si empieza con uno de estos valores, es MasterCard
            default:
                return 0;  // Si no, no es una tarjeta MasterCard válida
        }
    } else {
        return 0;  // Si no tiene 16 dígitos, no es MasterCard
    }
}

// Función para verificar el algoritmo de Luhn
function verifyLuhn(arrayCardNumber) {
    let suma = 0;  // Inicializar la variable para la suma

    // Iterar sobre los números de la tarjeta desde la derecha a la izquierda
    for (let i = arrayCardNumber.length - 2; i >= 0; i -= 2) {
        let digit = Number(arrayCardNumber[i]) * 2;  // Multiplicar por 2 los dígitos en las posiciones pares

        if (digit > 9) {
            digit -= 9;  // Si el resultado es mayor que 9, restamos 9
        }

        arrayCardNumber[i] = digit;  // Reemplazamos el dígito original con el nuevo valor
    }

    // Sumar todos los dígitos de la tarjeta
    for (let i = 0; i < arrayCardNumber.length; i++) {
        suma += Number(arrayCardNumber[i]);
    }

    // Si la suma es divisible por 10, la tarjeta es válida
    return suma % 10 === 0;
}
