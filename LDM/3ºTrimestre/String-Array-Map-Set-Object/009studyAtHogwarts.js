"use strict"

// Crea una función-objeto llamada hogwartsStudent que sea capaz de gestionar la siguiente información:

//   nombre: "Hermione Granger",
//   casa: "Gryffindor",
//   mascota: "Crookshanks",
//   asignaturas: ["Pociones", "Transformaciones", "Encantamientos"],
//   año: 3,
//   sangre: "mestiza",
//   prefecto: true



// Reutiliza la función-objeto y muestra:

// Ginny Weasley es una estudiante de Gryffindor en su cuarto año. Tiene una mascota llamada Arnold y su patronus es un Caballo. Sus asignaturas 
// son: Encantamientos, Vuelo, Pociones, Defensa Contra las Artes Oscuras.

let hermione = {
    nombre: "Hermione Granger",
    casa: "Gryffindor",
    mascota: "Crookshanks",
    asignaturas: ["Pociones", "Transformaciones", "Encantamientos"],
    año: 3,
    sangre: "mestiza",
    prefecto: true
};

let ginny = {
    nombre: "Ginny Weasley",
    casa: "Gryffindor",
    mascota: "Arnold",
    asignaturas: ["Encantamientos", "Vuelo", "Pociones", "Defensa Contra las Artes Oscuras"],
    año: 4,
    sangre: "mestiza",
    prefecto: true
};

function hogwartsStudent(student) {
    // 1. Muestra por consola el nombre completo del estudiante, la casa a la que pertenece y su mascota.
    console.log(student.nombre);
    console.log(student.casa);
    console.log(student.mascota);

    // 2. Añade una nueva propiedad al objeto llamada patronus y asígnale el valor "Nutria".
    student.patronus = "Nutria";

    // 3. Agrega una nueva asignatura al array asignaturas, llamada "Defensa Contra las Artes Oscuras".
    student.asignaturas.push("Defensa Contra las Artes Oscuras")

    // 4. Cambia el valor de la propiedad año a 4.
    student.año = 4;

    // 5. Elimina la propiedad sangre del objeto.
    delete student.sangre;

    // 6. Crea una función printHogwartsStudent que reciba el objeto hogwartsStudent y muestre por consola un resumen como este:
    // Hermione Granger es una estudiante de Gryffindor en su cuarto año. Tiene una mascota llamada Crookshanks y su patronus es una Nutria. Sus
    // asignaturas son: Pociones, Transformaciones, Encantamientos, Defensa Contra las Artes Oscuras. Invoca la función printHogwartsStudent() 
    // con el objeto modificado. 
    printHogwartsStudent(student);
}

function printHogwartsStudent(student) {
    console.log(`${student.nombre} es una estudiante de ${student.casa} en su ${student.año}º año. \n` + 
        `Tiene una mascota llamada ${student.mascota} y su patronus es una ${student.patronus}. \n` + 
        `Sus asignaturas son: ${student.asignaturas.join(', ')}.`);
}

hogwartsStudent(hermione);
hogwartsStudent(ginny);