```mermaid
    classDiagram

    class Genero {
        DRAMA
        COMEDIA
        ACCION
        TERROR
        ROMANCE
        AVENTURA
        SCIFI
    }

    class Profesion {
        ACTOR
        DIRECTOR
        PRODUCTOR
        GUINISTA
        EDITOR
    }

    class Pelicula {
        # titulo: String
        # sinopsis: String
        # anio: int
        # genero: Genero
    }

    class Persona {
        # nombre: String
        # apellidos: String
        # fechaNacimiento: String
        # nacionalidad: String
        # profesion: Profesion
    }

    Persona "1" --> "0..*" Pelicula: Actua en
    Pelicula "1" --> "1..*" Persona: Director
    Pelicula "1" --> "1..*" Persona: Guionista
    Pelicula "1" --> "0..*" Trailer: Tiene
    Trailer "0..*" --> "1..*" Persona: Editado por

```