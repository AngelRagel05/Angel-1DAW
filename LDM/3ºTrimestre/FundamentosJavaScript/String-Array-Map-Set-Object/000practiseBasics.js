"use strict"

// Declara un array vacío.
let arrayEmpty = [];  // Array sin elementos iniciales.

// Declara un array con más de 5 elementos.
let arrayNumber = [1, 2, 3, 4, 5, 6];  // Array con números del 1 al 6.

// Encuentra la longitud de tu array.
console.log(arrayNumber.length);  // Imprime la longitud del array (número de elementos).

// Obtiene el primer elemento, el elemento del medio y el último elemento de un array.
console.log(arrayNumber[0]);  // Imprime el primer elemento del array.
console.log(arrayNumber[Math.floor(arrayNumber.length / 2)]);  // Imprime el elemento del medio.
console.log(arrayNumber[arrayNumber.length - 1]);  // Imprime el último elemento del array.

// Declara un array llamado mixedDataTypes con diferentes tipos de datos y encuentra su longitud.
let mixedDataTypes = [1, "hola", 49498446n, true, null, undefined];  // Array con tipos de datos variados.
console.log(mixedDataTypes.length);  // Imprime la longitud del array (número de elementos).

// Declara un array llamado itCompanies con nombres de empresas de tecnología.
let itCompanies = ["Facebook", "Google", "Microsoft", "Apple", "IDM", "Oracle", "Amazon"];  // Array con nombres de empresas.

// Imprime el array usando console.log().
console.log(itCompanies);  // Muestra todo el array de empresas.

// Imprime el número de empresas en el array.
console.log(itCompanies.length);  // Muestra el número total de empresas en el array.

// Imprime la primera empresa, la intermedia y la última empresa.
console.log(itCompanies[0]);  // Imprime la primera empresa del array.
console.log(itCompanies[Math.floor(itCompanies.length / 2)]);  // Imprime la empresa del medio.
console.log(itCompanies[itCompanies.length - 1]);  // Imprime la última empresa del array.

// Imprime cada empresa usando el método forEach.
itCompanies.forEach(company => {
    console.log(company);  // Imprime cada nombre de empresa.
});

// Cambia el nombre de cada empresa a mayúsculas y los imprime.
itCompanies.forEach(company => {
    company = company.toLocaleUpperCase();  // Convierte el nombre de la empresa a mayúsculas.
    console.log(company);  // Imprime la empresa en mayúsculas.
});

// Imprime el array como una oración.
let phrase = itCompanies.toLocaleString("es") + " son grandes empresas de IT.";  // Convierte el array en una cadena y la convierte en una oración.
console.log(phrase);  // Muestra la frase con las empresas.

 // Comprueba si una empresa existe en el array itCompanies y muestra un mensaje acorde.
let search = "Google";  // Definir la empresa a buscar.
itCompanies.includes(search) ? console.log(search) : console.log("La empresa no existe");  // Si la empresa existe, la imprime, de lo contrario, muestra un mensaje.

 // Filtra las empresas que tienen más de una 'o' sin usar el método filter().
console.log("\nEmpresas con más de una 'o':");
for (let company of itCompanies) {  // Recorre cada empresa del array.
    let countO = 0;  // Inicializa el contador de la letra 'o'.
    for (let char of company.toLowerCase()) {  // Recorre cada letra del nombre de la empresa.
        if (char === "o") countO++;  // Incrementa el contador si encuentra la letra 'o'.
    }
    if (countO > 1) {  // Si hay más de una 'o', imprime la empresa.
        console.log(company);
    }
}

// Ordena el array usando el método sort().
itCompanies.sort();  // Ordena el array alfabéticamente.
console.log("\nOrdenadas:", itCompanies);  // Imprime el array ordenado.

// Invierte el array usando el método reverse().
itCompanies.reverse();  // Invierte el orden del array.
console.log("\nInvertidas:", itCompanies);  // Muestra el array invertido.

// Corta las primeras 3 empresas del array.
let first3 = itCompanies.slice(0, 3);  // Extrae las primeras 3 empresas del array.
console.log("\nPrimeras 3:", first3);  // Muestra las primeras 3 empresas.

// Corta las últimas 3 empresas del array.
let last3 = itCompanies.slice(-3);  // Extrae las últimas 3 empresas del array.
console.log("\nÚltimas 3:", last3);  // Muestra las últimas 3 empresas.

// Corta la(s) empresa(s) intermedias de TI del array.
let mid = Math.floor(itCompanies.length / 2);  // Encuentra el índice de la empresa intermedia.
let middle = itCompanies.length % 2 === 0
    ? itCompanies.slice(mid - 1, mid + 1)  // Si el número de empresas es par, toma dos empresas centrales.
    : itCompanies.slice(mid, mid + 1);  // Si es impar, toma solo la empresa del medio.
console.log("\nEmpresa(s) del medio:", middle);  // Muestra la(s) empresa(s) intermedia(s).

// Elimina la primera empresa de TI del array.
itCompanies.shift();  // Elimina el primer elemento del array.
console.log("\nDespués de eliminar la primera:", itCompanies);  // Muestra el array después de eliminar la primera empresa.

// Elimina la empresa o empresas intermedias del array.
mid = Math.floor(itCompanies.length / 2);  // Encuentra el índice de la empresa intermedia nuevamente.
if (itCompanies.length % 2 === 0) {
    itCompanies.splice(mid - 1, 2);  // Si hay un número par de empresas, elimina las dos centrales.
} else {
    itCompanies.splice(mid, 1);  // Si es impar, elimina solo la empresa central.
}
console.log("\nDespués de eliminar del medio:", itCompanies);  // Muestra el array después de eliminar la(s) empresa(s) del medio.

// Elimina la última empresa de TI del array.
itCompanies.pop();  // Elimina el último elemento del array.
console.log("\nDespués de eliminar la última:", itCompanies);  // Muestra el array después de eliminar la última empresa.

// Elimina todas las empresas de TI.
itCompanies = [];  // Vacía el array de empresas.
console.log("\nArray vacío:", itCompanies);  // Muestra el array vacío.
