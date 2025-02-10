```mermaid
    classDiagram

        class Persona {
            # nombre: String
            # edad: int
        }

        class Profesor {
            # sueldoBruto: double
            + toString() : void
        }

        class Alumno {
            - int: numeroTlf
            + toString() : void
        }

        class Tutor {
            - String: grupo
        }

        Persona <|-- Profesor
        Persona <|-- Alumno
        Profesor <|-- Tutor
```

```mermaid
    classDiagram

    enum Genero {
        DRAMA
        COMEDIA
        ACCION
        TERROR
        ROMANCE
        AVENTURA
        SCIFI
    }

    class Pelicula {
        # String: titulo
        # String: Sinopsis
        # int: anio
        # genero: Genero 
    }

    class Persona {
        - 
    }