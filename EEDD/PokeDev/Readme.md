```mermaid
    classDiagram

        class Gym {
            # String: nombre
            # String: descripcion
            # String: ciudad
            # Region: region
            # Trainer: lider
            # Medal: medalla
            # Type: especialidad

            + CombateLider () boolean
            + ObtenerMedalla () boolean
        }

        class Region {
            # String: nombre
            # String: descripion
            # Integer: numCiudades
            # List<Pokemon>: pokemons

            + ObtencionCiudades () Integer
        }

        class Pokemon {
            # String: nombre
            # String: descripcion
            # Type: tipo
            # Nature: naturaleza
            # Boolean: shinny

            + AddPokemon (Pokemon pokemon) void
            + DeletePokemon (Pokemon pokemon) void
            + Curar () void
            + Capturar () boolean
            + SubirNivel () void
        }

        class Trainer {
            # String: nombre
            # Integer: recompensa
            # List<Pokemon>: pokemons
            # Integer: medallasObtenidas
            # List<Medal>: medallas

            + AddTrainer (Trainer trainer) void
            + DeleteTrainer (Trainer trainer) void
            + CombateTrainer (Trainer rival) boolean
            + Capturar (Pokemon pokemon) boolean
        }

        class Medal {
            # String: nombre
        }

        class Item {
            <<enumeration>>
            POKEBALL
            POTION
            REVIVE
            FULL_RESTORE
        }

        class Type {
            <<enumeration>>
            FUEGO
            AGUA
            PLANTA
            ELECTRICO
            PSIQUICO
            ROCA
            LUCHA
            FANTASMA
            DRAGON
            HIELO
            VENENO
            VOLADOR
            NORMAL
            TIERRA 
        }

        class Nature {
            <<enumeration>>
            FUERTE
            OSADO
            MIEDOSO
            ALEGRE
            MODESTO
            SERENO
            FIRME
            MANSO
            SERIO
            DOCIL
            AFABLE
            PICARA
            HURAÑA
            ALOCADA
            RARA
            AMABLE
            FLOJA
        }

    Gym --> Region
    Gym --> Trainer : "Líder"
    Gym --> Medal
    Gym --> "0..*" Trainer : "Tiene entrenadores"
    Gym --> "0..*" Pokemon : "Usa Pokémon"

    Trainer --> "1.." Pokemon : "Tiene"
    Trainer --> "0..*" Medal : "Colecciona"
    Trainer --> "0..*" Item : "Posee"

    Region --> "0..*" Pokemon : "Aparecen en"
    Region --> "0..*" Gym : "Contiene"
    Region --> "0..*" Trainer : "Incluye"

    Pokemon --> "1" Trainer : "Pertenencia"


```