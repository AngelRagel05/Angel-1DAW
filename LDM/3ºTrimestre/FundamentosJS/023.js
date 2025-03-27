"use strict"

// 023switchToIf.js/.html: Escribe el código utilizando if..else que corresponda al siguiente switch:

let navegador = prompt("Introduce su navegador.")

// switch (navegador) {
//     case 'Edge':
//         alert("¡Tienes Edge!");
//         break;

//     case 'Explorer':
//         alert('Vuelve a primero, no hemos conseguido enseñarte nada.');
//         break;

//     case 'Chrome':
//         alert('Eres un clásico, no te gusta arriesgar.');
//         break;

//     case 'Firefox':
//         alert('Poca gente he visto con ese navegador, ¿que tál será?');
//         break;

//     case 'Safari':
//         alert('Esto es la sabana.');
//         break;

//     case 'Opera':
//         alert('Está bien, soportamos estos navegadores también');
//         break;

//     case 'Brave':
//         alert('Mi navegador lo he añadido por orgullo. El mejor.');
//         break;

//     default:
//         alert('¡Esperamos que esta página se vea bien!');
// }

if(navegador == 'Edge') {
    alert("¡Tienes Edge!");
} else if (navegador == 'Explorer') {
    alert('Vuelve a primero, no hemos conseguido enseñarte nada.');
} else if (navegador == 'Chrome') {
    alert('Eres un clásico, no te gusta arriesgar.');
} else if (navegador == 'Firefox') {
    alert('Poca gente he visto con ese navegador, ¿que tál será?');
} else if (navegador == 'Safari') {
    alert('Esto es la sabana.');
} else if (navegador == 'Opera') {
    alert('Está bien, soportamos estos navegadores también');
} else if (navegador == 'Brave') {
    alert('Mi navegador, lo he añadido por orgullo. El mejor.');
} else {
    alert('¡Esperamos que esta página se vea bien!');
}
