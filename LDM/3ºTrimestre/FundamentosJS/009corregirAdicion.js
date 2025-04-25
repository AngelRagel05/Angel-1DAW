// 009corregirAdicion.js/.html: Aquí hay un código que le pide al usuario dos números y muestra su suma. Funciona incorrectamente.
// El resultado en el ejemplo a continuación es 12 (para valores de captura predeterminados). ¿Por qué? Arréglalo. El resultado debería ser 3.

"use strict"

let a = prompt("¿Primer número?", 1);

let b = prompt("¿Segundo número?", 2);

alert(a + b); // 12

// Porque lo que se captura de un prompt es en formato String
// entonces se están sumando los Strings '1' + '2' = '12'