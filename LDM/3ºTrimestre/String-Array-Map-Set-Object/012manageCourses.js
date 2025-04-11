"use strict"

// Crear instancias de los cursos de JavaScript y Python
let cursoJavaScript = new CursoOnline("JavaScript");
let cursoPython = new CursoOnline("Python");

// Añadir estudiantes al curso de JavaScript
cursoJavaScript.addStudent("Alice");
cursoJavaScript.addStudent("Bob");
cursoJavaScript.addStudent("Charlie");

// Añadir estudiantes al curso de Python
cursoPython.addStudent("Bob");
cursoPython.addStudent("David");

// Unir los estudiantes de Python al curso de JavaScript
cursoJavaScript.joinStudent(cursoPython);

// Mostrar los estudiantes del curso JavaScript después de la unión
cursoJavaScript.showStudents();

// Obtener los estudiantes comunes entre los cursos de JavaScript y Python
let comunes = cursoJavaScript.obtainStudentCommun(cursoPython);
console.log("\nEstudiantes comunes entre JavaScript y Python:");
comunes.forEach(estudiante => console.log(estudiante));

// Comprobar si el estudiante Alice está en el curso de JavaScript
console.log("\n¿Está Alice en el curso JavaScript?");
console.log(cursoJavaScript.thisStudentInCurrent("Alice"));

// Eliminar a Charlie del curso de JavaScript
cursoJavaScript.deleteStudent("Charlie");

// Mostrar los estudiantes del curso JavaScript después de eliminar a Charlie
cursoJavaScript.showStudents();

// Vaciar el curso de JavaScript y mostrar los estudiantes (que ahora estarán vacíos)
cursoJavaScript.emptyCourse();
cursoJavaScript.showStudents();

// Clase para gestionar cursos online
class CursoOnline {
    // Constructor que toma el nombre del curso
    constructor(nombreCurso) {
        this.nombreCurso = nombreCurso; // Asignar el nombre del curso
        this.estudiantes = new Set(); // Crear un Set vacío para los estudiantes
    }

    // Método para añadir estudiantes al curso
    addStudent(estudiante) {
        // Verificar si el estudiante ya está en el curso
        if (!this.estudiantes.has(estudiante)) {
            this.estudiantes.add(estudiante); // Añadir al Set si no existe
            console.log(`${estudiante} ha sido agregado al curso ${this.nombreCurso}.`);
        } else {
            // Mostrar un mensaje si el estudiante ya está registrado
            console.log(`${estudiante} ya está registrado en el curso ${this.nombreCurso}.`);
        }
    }

    // Método para eliminar estudiantes del curso
    deleteStudent(estudiante) {
        // Verificar si el estudiante está en el curso
        if (this.estudiantes.has(estudiante)) {
            this.estudiantes.delete(estudiante); // Eliminar del Set si existe
            console.log(`${estudiante} ha sido eliminado del curso ${this.nombreCurso}.`);
        } else {
            // Mostrar un mensaje si el estudiante no está registrado
            console.log(`${estudiante} no está registrado en el curso ${this.nombreCurso}.`);
        }
    }

    // Método para unir los estudiantes de otro curso al curso actual
    joinStudent(curso) {
        // Iterar sobre los estudiantes del otro curso
        curso.estudiantes.forEach(estudiante => {
            this.addStudent(estudiante); // Usar el método addStudent para añadirlos
        });
    }

    // Método para obtener los estudiantes comunes entre dos cursos
    obtainStudentCommun(curso) {
        // Crear un nuevo Set con los estudiantes comunes entre los dos cursos
        let comunes = new Set([...this.estudiantes].filter(estudiante => curso.estudiantes.has(estudiante)));
        return comunes; // Devolver el Set de estudiantes comunes
    }

    // Método para comprobar si un estudiante está en el curso actual
    thisStudentInCurrent(estudiante) {
        return this.estudiantes.has(estudiante); // Retorna true si está en el Set, false si no
    }

    // Método para vaciar todos los estudiantes del curso
    emptyCourse() {
        this.estudiantes.clear(); // Limpiar el Set de estudiantes
        console.log(`El curso ${this.nombreCurso} ha sido vaciado.`); // Informar que el curso se ha vaciado
    }

    // Método para mostrar todos los estudiantes del curso
    showStudents() {
        console.log(`Estudiantes del curso ${this.nombreCurso}:`);
        // Iterar y mostrar cada estudiante del Set
        this.estudiantes.forEach(estudiante => {
            console.log(estudiante);
        });
    }
}
