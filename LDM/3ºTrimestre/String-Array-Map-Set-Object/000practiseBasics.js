"use strict"

// Declara un array vacío.
let arrayEmpty = [];

// Declara un array com mas de 5 elementos.
let arrayNumber = [1, 2, 3, 4, 5, 6];

// Encuentra la longitud de tu array.
console.log(arrayNumber.length);

// Obtenga el primer elemento, el elemento del medio y el último elemento de un array.
console.log(arrayNumber[0]);
console.log(arrayNumber[Math.floor(arrayNumber.length / 2)]);
console.log(arrayNumber[arrayNumber.length - 1]);

// Declara un array llamado mixedDataTypes, coloque diferentes tipos de datos en el array y encuentre la longitud del array. El tamaño del array debe ser mayor que 5.
let mixedDataTypes = [1, "hola", 49498446n, true, null, undefined];
console.log(mixedDataTypes.length);

// Declare un variable array de nombre itCompanies y asignarles valores iniciales Facebook, Google, Microsoft, Apple, IBM, Oracle y Amazon.
let itCompanies = ["Facebook", "Google", "Microsoft", "Apple", "IDM", "Oracle", "Amazon"];

// Imprima el array usando console.log().
console.log(itCompanies);

// Imprima el número de empresas en el array.
console.log(itCompanies.length);

// Imprime la primer empresa , la intermedia y la última empresa
console.log(itCompanies[0]);
console.log(itCompanies[Math.floor(itCompanies.length / 2)]);
console.log(itCompanies.length - 1);

// Imprime cada empresa.
itCompanies.forEach(company => {
    console.log(company);
});

// Cambie el nombre de cada empresa a mayúsculas uno por uno e imprímalos.
itCompanies.forEach(company => {
    company = companie.toLocaleUpperCase();
    console.log(company);
});

// Imprime el array como una oración: Facebook, Google, Microsoft, Apple, IBM, Oracle y Amazon son grandes empresas de TI.
let phrase = itCompanies.toLocaleString("es") + " son grandes empresas de IT.";
console.log(phrase);

// Compruebe si existe una determinada empresa en el array itCompanies. Si existe, retorna la empresa; de lo contrario, retorna la empresa no existe
let search = "Google";
itCompanies.includes(search) ? console.log(search) : console.log("La empresa no existe");

// Filtre las empresas que tienen más de una 'o' sin el método filter()
console.log("\nEmpresas con más de una 'o':");
for (let company of itCompanies) {
    let countO = 0;
    for (let char of company.toLowerCase()) {
        if (char === "o") countO++;
    }
    if (countO > 1) {
        console.log(company);
    }
}

// Ordene el array usando el método sort()
itCompanies.sort();
console.log("\nOrdenadas:", itCompanies);

// Invierte la array usando el método reverse()
itCompanies.reverse();
console.log("\nInvertidas:", itCompanies);

// Cortar las primeras 3 empresas del array
let first3 = itCompanies.slice(0, 3);
console.log("\nPrimeras 3:", first3);

// Cortar las últimas 3 empresas del array
let last3 = itCompanies.slice(-3);
console.log("\nÚltimas 3:", last3);

// Cortar la empresa o empresas intermedias de TI del array
let mid = Math.floor(itCompanies.length / 2);
let middle = itCompanies.length % 2 === 0
    ? itCompanies.slice(mid - 1, mid + 1)
    : itCompanies.slice(mid, mid + 1);
console.log("\nEmpresa(s) del medio:", middle);

// Eliminar la primera empresa de TI del array
itCompanies.shift();
console.log("\nDespués de eliminar la primera:", itCompanies);

// Eliminar la empresa o empresas intermedias de TI del array
mid = Math.floor(itCompanies.length / 2);
if (itCompanies.length % 2 === 0) {
    itCompanies.splice(mid - 1, 2);
} else {
    itCompanies.splice(mid, 1);
}
console.log("\nDespués de eliminar del medio:", itCompanies);

// Elimine la última empresa de TI del array
itCompanies.pop();
console.log("\nDespués de eliminar la última:", itCompanies);

// Eliminar todas las empresas de TI
itCompanies = [];
console.log("\nArray vacío:", itCompanies);