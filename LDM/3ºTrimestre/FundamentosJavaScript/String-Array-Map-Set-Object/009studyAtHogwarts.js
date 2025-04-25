"use strict"

// Crea una función-objeto llamada hogwartsStudent que sea capaz de gestionar la siguiente información:

// Objeto hermione con la información del estudiante.
let hermione = {
    nombre: "Hermione Granger",  // Nombre del estudiante.
    casa: "Gryffindor",  // Casa a la que pertenece el estudiante.
    mascota: "Crookshanks",  // Nombre de la mascota del estudiante.
    asignaturas: ["Pociones", "Transformaciones", "Encantamientos"],  // Asignaturas que cursa el estudiante.
    año: 3,  // Año en el que se encuentra el estudiante.
    sangre: "mestiza",  // Tipo de sangre del estudiante.
    prefecto: true  // Si el estudiante es prefecto.
};

// Objeto ginny con la información del estudiante.
let ginny = {
    nombre: "Ginny Weasley",  // Nombre del estudiante.
    casa: "Gryffindor",  // Casa a la que pertenece el estudiante.
    mascota: "Arnold",  // Nombre de la mascota del estudiante.
    asignaturas: ["Encantamientos", "Vuelo", "Pociones", "Defensa Contra las Artes Oscuras"],  // Asignaturas que cursa el estudiante.
    año: 4,  // Año en el que se encuentra el estudiante.
    sangre: "mestiza",  // Tipo de sangre del estudiante.
    prefecto: true  // Si el estudiante es prefecto.
};

// Función hogwartsStudent que modifica el objeto del estudiante y muestra información relevante.
function hogwartsStudent(student) {
    // 1. Muestra por consola el nombre completo del estudiante, la casa a la que pertenece y su mascota.
    console.log(student.nombre);  // Muestra el nombre del estudiante.
    console.log(student.casa);  // Muestra la casa del estudiante.
    console.log(student.mascota);  // Muestra el nombre de la mascota.

    // 2. Añade una nueva propiedad al objeto llamada patronus y asígnale el valor "Nutria".
    student.patronus = "Nutria";  // Añade la propiedad patronus con el valor "Nutria".

    // 3. Agrega una nueva asignatura al array asignaturas, llamada "Defensa Contra las Artes Oscuras".
    student.asignaturas.push("Defensa Contra las Artes Oscuras");  // Agrega la asignatura "Defensa Contra las Artes Oscuras".

    // 4. Cambia el valor de la propiedad año a 4.
    student.año = 4;  // Cambia el valor de la propiedad año a 4.

    // 5. Elimina la propiedad sangre del objeto.
    delete student.sangre;  // Elimina la propiedad sangre del objeto.

    // 6. Crea una función printHogwartsStudent que reciba el objeto hogwartsStudent y muestre por consola un resumen como este:
    // Llama a la función printHogwartsStudent para mostrar la información del estudiante.
    printHogwartsStudent(student);
}

// Función que muestra un resumen de la información del estudiante.
function printHogwartsStudent(student) {
    // Muestra un resumen de la información del estudiante.
    console.log(`${student.nombre} es una estudiante de ${student.casa} en su ${student.año}º año. \n` + 
        `Tiene una mascota llamada ${student.mascota} y su patronus es una ${student.patronus}. \n` + 
        `Sus asignaturas son: ${student.asignaturas.join(', ')}.`);  // Muestra el resumen del estudiante.
}

// Llamada a la función hogwartsStudent con el objeto hermione.
hogwartsStudent(hermione);  // Modifica el objeto hermione y muestra su información.

// Llamada a la función hogwartsStudent con el objeto ginny.
hogwartsStudent(ginny);  // Modifica el objeto ginny y muestra su información.
