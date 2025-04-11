"use strict"

let cursoJavaScript = new CursoOnline("JavaScript");
let cursoPython = new CursoOnline("Python");

cursoJavaScript.addStudent("Alice");
cursoJavaScript.addStudent("Bob");
cursoJavaScript.addStudent("Charlie");

cursoPython.addStudent("Bob");
cursoPython.addStudent("David");

cursoJavaScript.joinStudent(cursoPython);
cursoJavaScript.showStudents();

let comunes = cursoJavaScript.obtainStudentCommun(cursoPython);
console.log("\nEstudiantes comunes entre JavaScript y Python:");
comunes.forEach(estudiante => console.log(estudiante));

console.log("\n¿Está Alice en el curso JavaScript?");
console.log(cursoJavaScript.thisStudentInCurrent("Alice"));

cursoJavaScript.deleteStudent("Charlie");
cursoJavaScript.showStudents();

cursoJavaScript.emptyCourse();
cursoJavaScript.showStudents();

// Crea una clase que gestione cursos online. Cada curso tendrá estudiantes registrados. Usa objetos Set para asegurarte de que no se repitan 
// estudiantes dentro de un curso. El ejercicio debe realizar las siguientes operaciones claramente separadas:
class CursoOnline {
    constructor(nombre) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = new Set();
    }

    // Crear una función para añadir estudiantes a un curso.
    addStudent(estudiante) {
        if (!this.estudiante.has(estudiante)) {
            this.estudiante.add(estudiante);
            console.log(`${estudiante} ha sido agregado al curso ${this.nombre}.`);
        } else {
            console.log(`${estudiante} ya está registrado en el curso ${this.nombre}.`);
        }
    }

    // Crear una función para eliminar estudiantes de un curso.
    deleteStudent(estudiante) {
        if (this.estudiantes.has(estudiante)) {
            this.estudiantes.delete(estudiante);
            console.log(`${estudiante} ha sido eliminado del curso ${this.nombre}.`);
        } else {
            console.log(`${estudiante} no está registrado en el curso ${this.nombre}.`);
        }
    }

    // Crear una función para unir estudiantes de dos cursos diferentes.
    joinStudent(curso) {
        curso.estudiantes.forEach(estudiante => {
            this.agregarEstudiante(estudiante);
        });
    }

    // Crear una función para obtener estudiantes comunes entre dos cursos.
    obtainStudentCommun(curso) {
        let comunes = new Set([...this.estudiantes].filter(estudiante => curso.estudiantes.has(estudiante)));
        return comunes;
    }

    // Crear una función que compruebe si un estudiante está en un curso específico.
    thisStudentInCurrent(estudiante) {
        return this.estudiantes.has(estudiante);
    }

    // Crear una función para vaciar completamente un curso
    emptyCourse() {
        this.estudiantes.clear();
        console.log(`El curso ${this.nombre} ha sido vaciado.`);
    }

    showStudents() {
        console.log(`Estudiantes del curso ${this.nombreCurso}:`);
        this.estudiantes.forEach(estudiante => {
            console.log(estudiante);
        });
    }
}