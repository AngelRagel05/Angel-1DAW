"use strict"

// 001modifyThor.js/.html: Contesta los siguientes comentarios con respecto a la cadena que contiene la variable thor:

let thor = "Thor es el hijo de Odín";  // Variable que contiene la cadena "Thor es el hijo de Odín".

// Largo de la cadena
console.log(thor.length);  // Muestra la longitud de la cadena "thor", que es el número de caracteres.

// Encontrar la letra o
console.log(thor.indexOf("o"));  // Encuentra la primera aparición de la letra 'o' en la cadena y devuelve su índice (posición).

// Encontrar el carácter que ocupa la posición 3
console.log(thor[3]);  // Muestra el carácter en la posición 3 de la cadena (índice basado en 0).

// ¿Qué carácter ocupa la posición 1?
console.log(thor.charAt(1));  // Muestra el carácter en la posición 1 de la cadena, utilizando el método charAt.

// Trocea la cadena usando los espacios en blanco
console.log(thor.split(" "));  // Divide la cadena en un array, usando los espacios como delimitadores.

// Reemplaza Thor por Loki
console.log(thor.replace("Thor", "Loki"));  // Reemplaza la palabra "Thor" por "Loki" en la cadena.

 // Recorta la cadena para que devuelva la palabra Odín
console.log(thor.substring(thor.length - 4));  // Extrae los últimos 4 caracteres de la cadena (en este caso, "Odín") usando substring.

// ¿Puedes encontrar la letra a? Demuéstralo
console.log(thor.includes("a"));  // Verifica si la letra 'a' está presente en la cadena y devuelve true o false.

// Pon la mitad de la cadena en minúsculas (Sin usar las posiciones de 0 a 11)
let mitad = Math.floor(thor.length / 2);  // Calcula la mitad de la longitud de la cadena.
let primera = thor.slice(0, mitad).toLocaleUpperCase();  // Convierte la primera mitad de la cadena a mayúsculas.
let segunda = thor.slice(mitad).toLocaleLowerCase();  // Convierte la segunda mitad de la cadena a minúsculas.
console.log(primera + segunda);  // Muestra la cadena con la primera mitad en mayúsculas y la segunda en minúsculas.
