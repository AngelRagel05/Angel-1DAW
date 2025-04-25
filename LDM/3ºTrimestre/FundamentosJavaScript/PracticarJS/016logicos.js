"use strict"

// 016logicos.js/.html: ¿Cuál será el resultado de las siguientes operaciones?

alert("1º");
alert( null || 2 || undefined ); // 2. Esa tiene sentido

alert("2º");
alert( alert(1) || 2 || alert(3) ); // 1. Muestra el 1 y después el 2 en otra alerta 🤯

alert("3º");
alert( 1 && null && 2 ); // 1. Muestra el null 🤯

alert("4º");
alert( alert(1) && alert(2) ); // 1. Muestra el 1 y despues otra alerta con undefined 🤯

alert("5º");
alert( null || 2 && 3 || 4 ); // 23. Muestra el 3 🤯