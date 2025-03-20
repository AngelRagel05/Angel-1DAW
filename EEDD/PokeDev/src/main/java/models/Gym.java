package models;

import models.enumerations.SubType;
import models.enumerations.Type;
import models.interfaces.iGym;

import java.util.List;

public class Gym implements iGym {

//    Atributos
    protected String nombre;
    protected String descripcionGym;
    protected String ciudad;
    protected Trainer lider;
    protected Type tipo;
    protected Medal medalla;
    protected Region region;

//    Constructor
    public Gym(String nombre, String descripcionGym, String ciudad, Trainer lider, Type tipo, Medal medalla, Region region) {
        this.nombre = nombre;
        this.descripcionGym = descripcionGym;
        this.ciudad = ciudad;
        this.lider = lider;
        this.tipo = tipo;
        this.medalla = medalla;
        this.region = region;
    }

    public Gym(String nombre, String descripcionGym) {
        this.nombre = nombre;
        this.descripcionGym = descripcionGym;
    }

//    Métodos
    public boolean winMedal (Trainer lider, Trainer visitante) {
        boolean medalla = false;
        if (combatLeader(lider, visitante) == true) {
            medalla = true;
        }
        return medalla;
    }

//    Funciones
//    Funcion del combate que llama a otras dos para saber quien gana en tipo
    private boolean combatLeader(Trainer lider, Trainer visitante) {
        boolean ganador = false;

        // Obtener los primeros 5 Pokémon de cada Trainer
        List<Pokemon> pokemonsLider = lider.getPokemons().subList(0, 5);
        List<Pokemon> pokemonsVisitante = visitante.getPokemons().subList(0, 5);

        // Función para comparar el tipo de los Pokémon
        int combatesGanadosLider = 0;
        int combatesGanadosVisitante = 0;

        for (int i = 0; i < 5; i++) {
            Pokemon pokemonLider = pokemonsLider.get(i);
            Pokemon pokemonVisitante = pokemonsVisitante.get(i);

            Type tipoLider = pokemonLider.getTipo();
            Type tipoVisitante = pokemonVisitante.getTipo();

            // Subtipos combinados
            SubType[] subtiposLider = tipoLider.getSubtipos();
            SubType[] subtiposVisitante = tipoVisitante.getSubtipos();

            // Comprobamos las relaciones de tipo (condiciones explícitas)
            boolean liderGana = false;
            boolean visitanteGana = false;

            // Primero, comprobamos los subtipos
            for (SubType subLider : subtiposLider) {
                for (SubType subVisitante : subtiposVisitante) {
                    if (advantageSubtypes(subLider, subVisitante)) {
                        visitanteGana = true;
                    } else if (advantageSubtypes(subVisitante, subLider)) {
                        liderGana = true;
                    }
                }
            }

            // Si no hay ganador por subtipos, verificamos los tipos principales
            if (!liderGana && !visitanteGana) {
                if (advantage(tipoVisitante, tipoLider)) {
                    visitanteGana = true;
                } else if (advantage(tipoLider, tipoVisitante)) {
                    liderGana = true;
                }
            }

            // Si no hay un ganador por tipo, usamos el nivel del Pokémon para decidir el combate
            if (!liderGana && !visitanteGana) {
                if (pokemonVisitante.getNivel() > pokemonLider.getNivel()) {
                    combatesGanadosVisitante++;
                } else if (pokemonLider.getNivel() > pokemonVisitante.getNivel()) {
                    combatesGanadosLider++;
                }
            } else {
                // Si hay un ganador por tipo o subtipo, asignamos el punto correspondiente
                if (visitanteGana) {
                    combatesGanadosVisitante++;
                } else {
                    combatesGanadosLider++;
                }
            }
        }

        // Al final, el entrenador que haya ganado más combates será el ganador
        if (combatesGanadosLider > combatesGanadosVisitante) {
            ganador = false; // El líder gana
        } else if (combatesGanadosVisitante > combatesGanadosLider) {
            ganador = true; // El visitante gana
        }

        return ganador;
    }

//    Funcion que determina si un tipo A tiene ventaja sobre un tipo B
    private boolean advantage(Type tipoA, Type tipoB) {
        // Aquí se incluyen las relaciones de ventaja entre los tipos principales
        if (tipoA == Type.AGUA) {
            return tipoB == Type.FUEGO || tipoB == Type.ROCA || tipoB == Type.TIERRA;
        } else if (tipoA == Type.FUEGO) {
            return tipoB == Type.PLANTA || tipoB == Type.HIELO || tipoB == Type.BICHO || tipoB == Type.ACERO;
        } else if (tipoA == Type.PLANTA) {
            return tipoB == Type.AGUA || tipoB == Type.ROCA || tipoB == Type.TIERRA;
        } else if (tipoA == Type.ROCA) {
            return tipoB == Type.AGUA || tipoB == Type.PLANTA || tipoB == Type.LUCHA || tipoB == Type.TIERRA || tipoB == Type.ACERO;
        } else if (tipoA == Type.TIERRA) {
            return tipoB == Type.AGUA || tipoB == Type.PLANTA || tipoB == Type.HIELO;
        } else if (tipoA == Type.ELECTRICO) {
            return tipoB == Type.AGUA;
        } else if (tipoA == Type.HIELO) {
            return tipoB == Type.AGUA || tipoB == Type.ROCA || tipoB == Type.ACERO || tipoB == Type.FUEGO;
        } else if (tipoA == Type.LUCHA) {
            return tipoB == Type.NORMAL || tipoB == Type.HIELO || tipoB == Type.ROCA || tipoB == Type.SINIESTRO || tipoB == Type.ACERO;
        } else if (tipoA == Type.BICHO) {
            return tipoB == Type.PLANTA || tipoB == Type.PSIQUICO || tipoB == Type.SINIESTRO;
        } else if (tipoA == Type.VOLADOR) {
            return tipoB == Type.PLANTA || tipoB == Type.LUCHA || tipoB == Type.BICHO;
        } else if (tipoA == Type.PSIQUICO) {
            return tipoB == Type.LUCHA || tipoB == Type.VENENO;
        } else if (tipoA == Type.SINIESTRO) {
            return tipoB == Type.PSIQUICO || tipoB == Type.FANTASMA;
        } else if (tipoA == Type.FANTASMA) {
            return tipoB == Type.PSIQUICO || tipoB == Type.FANTASMA;
        } else if (tipoA == Type.VENENO) {
            return tipoB == Type.PLANTA || tipoB == Type.HADA;
        } else if (tipoA == Type.ACERO) {
            return tipoB == Type.HIELO || tipoB == Type.ROCA || tipoB == Type.HADA;
        } else if (tipoA == Type.DRAGON) {
            return tipoB == Type.DRAGON || tipoB == Type.HADA;
        } else if (tipoA == Type.HADA) {
            return tipoB == Type.DRAGON || tipoB == Type.SINIESTRO || tipoB == Type.VENENO;
        } else if (tipoA == Type.NORMAL) {
            return tipoB == Type.ROCA || tipoB == Type.FANTASMA || tipoB == Type.PSIQUICO;
        }

        return false;
    }

//    Funcion que determina si un subtipo A tiene ventaja sobre un subtipo B
    private boolean advantageSubtypes(SubType subA, SubType subB) {
        // Aquí se añaden las relaciones entre subtipos, usando condiciones como el ejemplo anterior
        if (subA == SubType.FUEGO && subB == SubType.VOLADOR) {
            return true; // FUEGO tiene ventaja sobre VOLADOR
        }
        if (subA == SubType.AGUA && subB == SubType.TIERRA) {
            return true; // AGUA tiene ventaja sobre TIERRA
        }
        if (subA == SubType.PLANTA && subB == SubType.VENENO) {
            return true; // PLANTA tiene ventaja sobre VENENO
        }
        if (subA == SubType.ELECTRICO && subB == SubType.VOLADOR) {
            return true; // ELECTRICO tiene ventaja sobre VOLADOR
        }
        if (subA == SubType.PSIQUICO && subB == SubType.HIELO) {
            return true; // PSIQUICO tiene ventaja sobre HIELO
        }
        if (subA == SubType.ROCA && subB == SubType.TIERRA) {
            return true; // ROCA tiene ventaja sobre TIERRA
        }
        if (subA == SubType.LUCHA && subB == SubType.FANTASMA) {
            return true; // LUCHA tiene ventaja sobre FANTASMA
        }
        if (subA == SubType.DRAGON && subB == SubType.VENENO) {
            return true; // DRAGON tiene ventaja sobre VENENO
        }

        // Resto de las combinaciones de subtipos
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}