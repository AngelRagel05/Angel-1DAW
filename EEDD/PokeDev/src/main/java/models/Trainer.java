package models;

import models.abstracts.Person;
import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.SubType;
import models.enumerations.Type;
import models.interfaces.iTrainer;

import java.util.*;

public class Trainer extends Person implements iTrainer  {

    private static Scanner sc = new Scanner(System.in);

    private static final String CHOOSE_NATURE = "Elige una naturaleza del pokémon.";
    private static final String CHOOSE_NUMBER_NATURE = "Elige el número correspondiente a la naturaleza.";

    private static final String CHOOSE_TYPE = "Elige un tipo del pokémon.";
    private static final String CHOOSE_NUMBER_TYPE = "Elige el número correspondiente al tipo.";

    private static final String INVALID_OPTION = "Opción inválida. Introduce un número entre 1 y ";
    private static final String INVALID_ENTRY = "Entrada no válida. Ingresa un número.";
    private static final String NEGATIVE_ENTRY = "Este campo no puede ser negativo.";
    private static final String INCORRECT_ITEM = "El item elegido no sirve para capturar pokémon.";

    private static final String POKEMON_ID = "Cuál es el número de la pokedex de su pokémon.";
    private static final String POKEMON_NAME = "Que nombre tendrá el pokémon.";
    private static final String POKEMON_DESCRIPTION = "Que descripción tendrá en pokémon.";
    private static final String POKEMON_HEALTH = "Que vida máxima tendrá el pokémon.";
    private static final String POKEMON_SHINNY = "El pokémon es shinny, introduce false si es falso o true si es verdadero.";

//    Atributos
    protected Double recompensa;
    protected ArrayList<Pokemon> pokemons;
    protected ArrayList<Medal> medallas;
    protected ArrayList<Item> items;

//    Constructor
    public Trainer(String nombre, Double recompensa, ArrayList<Pokemon> pokemonsT, ArrayList<Medal> medallas, ArrayList<Item> items) {
        super(nombre);
        this.recompensa = recompensa;
        this.pokemons = pokemonsT;
        this.medallas = medallas;
        this.items = items;
    }

    public Trainer (String nombre, Double recompensa) {
        super(nombre);
        this.recompensa = recompensa;
    }

//    Metodos
    public void addPokemon() {
        if (pokemons == null) {
            pokemons = new ArrayList<>();
        }
        pokemons.add(new Pokemon(pokemonID(), pokemonName(), pokemonDescription(), pokemonMaxHealth(), pokemonLevel(), pokemonShinny(), pokemonNature(), pokemonType()));
    }

    public boolean combatTrainer(Trainer local, Trainer visitante) {
        boolean ganador = false;

        // Obtener los primeros 5 Pokémon de cada Trainer
        List<Pokemon> pokemonsLider = local.getPokemons().subList(0, 5);
        List<Pokemon> pokemonsVisitante = visitante.getPokemons().subList(0, 5);

        // Función para comparar el tipo de los Pokémon
        int combatesGanadosLider = 0;
        int combatesGanadosVisitante = 0;

        for (int i = 0; i < 5; i++) {
            Pokemon pokemonLocal = pokemonsLider.get(i);
            Pokemon pokemonVisitante = pokemonsVisitante.get(i);

            Type tipoLocal = pokemonLocal.getTipo();
            Type tipoVisitante = pokemonVisitante.getTipo();

            // Subtipos combinados
            SubType[] subtiposLocal = tipoLocal.getSubtipos();
            SubType[] subtiposVisitante = tipoVisitante.getSubtipos();

            // Comprobamos las relaciones de tipo (condiciones explícitas)
            boolean localGana = false;
            boolean visitanteGana = false;

            // Primero, comprobamos los subtipos
            for (SubType subLocal : subtiposLocal) {
                for (SubType subVisitante : subtiposVisitante) {
                    if (advantageSubtypes(subLocal, subVisitante)) {
                        visitanteGana = true;
                    } else if (advantageSubtypes(subVisitante, subLocal)) {
                        localGana = true;
                    }
                }
            }

            // Si no hay ganador por subtipos, verificamos los tipos principales
            if (!localGana && !visitanteGana) {
                if (advantage(tipoVisitante, tipoLocal)) {
                    visitanteGana = true;
                } else if (advantage(tipoLocal, tipoVisitante)) {
                    localGana = true;
                }
            }

            // Si no hay un ganador por tipo, usamos el nivel del Pokémon para decidir el combate
            if (!localGana && !visitanteGana) {
                if (pokemonVisitante.getNivel() > pokemonLocal.getNivel()) {
                    combatesGanadosVisitante++;
                } else if (pokemonLocal.getNivel() > pokemonVisitante.getNivel()) {
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

    public boolean capture(Item item) {
        boolean capturar = false;
        Random random = new Random();
        if (item == Item.POKEBALL) {
            int probabilidad = random.nextInt(100);
            if (probabilidad < 19) {
                capturar = true;
            }
        } else {
            printError(INCORRECT_ITEM);
        }
        return capturar;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

//    Funciones
    private Integer pokemonID() {
        print(POKEMON_ID);
        Integer id = 0;
        try {
            id = sc.nextInt();

            while (id < 0) {
                printError(NEGATIVE_ENTRY);
                id = sc.nextInt();
            }
        } catch (InputMismatchException e) {
            printError(INVALID_ENTRY);
        }
        sc.next();
        return id;
    }

    private String pokemonName() {
        print(POKEMON_NAME);
        String name = sc.nextLine();
        return name;
    }

    private String pokemonDescription() {
        print(POKEMON_DESCRIPTION);
        String description = sc.nextLine();
        return description;
    }

    private Double pokemonMaxHealth() {
        Double salud = 0.0;
        print(POKEMON_HEALTH);
        try {
            salud = sc.nextDouble();
            while (salud < 0) {
                printError(NEGATIVE_ENTRY);
                salud = sc.nextDouble();
            }
        } catch (InputMismatchException e) {
            printError(INVALID_ENTRY);
        }
        sc.next();
        return salud;
    }

    private Integer pokemonLevel() {
        print(POKEMON_HEALTH);
        Integer nivel = 0;
        try {
            nivel = sc.nextInt();

            while (nivel < 0) {
                printError(NEGATIVE_ENTRY);
                nivel = sc.nextInt();
            }
        } catch (InputMismatchException e) {
            printError(INVALID_ENTRY);
        }
        sc.next();
        return nivel;
    }

    private boolean pokemonShinny() {
        boolean shinny = false;
        print(POKEMON_SHINNY);
        String respuesta = sc.nextLine();
        if (respuesta == "true") {
            shinny = true;
        }
        sc.next();
        return shinny;
    }

    private static Nature pokemonNature() {
        Nature naturaleza = null;
        print(CHOOSE_NATURE);
        Nature[] naturalezas = Nature.values();

        for (int i = 0; i < naturalezas.length; i++) {
            print((i + 1) + ". " + naturalezas[i]);
        }

        while (naturaleza == null) {
            print(CHOOSE_NUMBER_NATURE);
            try {
                int opc = Integer.parseInt(sc.nextLine());

                if (opc >= 1 && opc <= naturalezas.length) {
                    naturaleza = naturalezas[opc -1];
                } else {
                    printError(INVALID_OPTION + naturalezas.length);
                }
            } catch (NumberFormatException e) {
                printError(INVALID_ENTRY);
            }
        }
        return naturaleza;
    }

    private static Type pokemonType() {
        Type tipo = null;
        print(CHOOSE_TYPE);
        Type[] tipos = Type.values();

        for (int i = 0; i < tipos.length; i++) {
            print((i + 1) + ". " + tipos[i]);
        }

        while (tipo == null) {
            print(CHOOSE_NUMBER_TYPE);
            try {
                int opc = Integer.parseInt(sc.nextLine());

                if (opc >= 1 && opc <= tipos.length) {
                    tipo = tipos[opc -1];
                } else {
                    printError(INVALID_OPTION + tipos.length);
                }
            } catch (NumberFormatException e) {
                printError(INVALID_ENTRY);
            }
        }
        return tipo;
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

    private static void print(String frase) {
        System.out.println(frase);
    }

    private static void printError(String frase) {
        System.err.println(frase);
    }
}