// 022numPrimos.js/.html: Un número entero mayor que 1 es llamado primo si no puede ser dividido sin un resto por ningún número excepto 1 y él mismo. 
// En otras palabras, n > 1 es un primo si no puede ser divido exactamente por ningún número excepto 1 y n.

// Por ejemplo, 5 es un primo, porque no puede ser divido exactamente por 2, 3 y 4.

// Escribe el código que muestre números primos en el intervalo de 2 a n.
// Para n = 10 el resultado será 2, 3, 5, 7.
// PD. El código debería funcionar para cualquier n, no debe estar programado para valores fijos.
// ¿Puedes hacerlo con los 3 tipos de bucle? Demuéstralo.

let size = prompt("Introduzca el valor de n.")
let cont;

for(let i = 1; i <= size; i++) {
    for(let j = i; j <= size; j++) {
        if(i % j == 0) {
            cont++;    
        }
        
    }
    if(cont == 2) {
        alert(i)
    }
}