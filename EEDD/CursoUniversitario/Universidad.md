``` mermaid
    classDiagram
        class Curso {
            # List ~Estudiante~ estudiantes

            + aniadirEstudiante (Estudiante estudiante) void
            + buscarEstudiante (Integer id) Estudiante
            + eliminarEstudiante (Integer id) void
            + calcularPromedio (Estudiante estudiante) Integer
            + estudiantesAprobados (Estudiante estudiante) void
        }

        class Estudiante {
            # nombre: String
            # apellidos: String
            # id: Integer
            # numSemestre: Integer
            # notaFinal: Integer
        }
        
        Estudiante "0.." --> "1" Curso: Cursar
```