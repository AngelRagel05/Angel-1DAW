"use strict"
// 013muestraSigno.js/.html: Usando el constructor if..else, escribe un código que obtenga a través de un prompt un número y entonces muestre en un alert:
// 1, si el valor es mayor que cero,
// -1, si es menor que cero,
// 0, si es igual a cero.
// En la tarea asumimos que siempre el usuario introduce un número.

let answer = prompt("Introduce un número."); 

answer == "1" ? alert("El número elegido es: 1") : answer == "-1" ? alert("El número elegido es: -1") : answer == "0" ? alert("El número elegido es: 0") : alert("El número introducido no es uno de los elegidos");
