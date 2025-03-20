package models;

import models.interfaces.iRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Region implements iRegion {

    private static Scanner sc = new Scanner(System.in);

    private static final String ADDED = " añadido correctamente a la lista.";

    private static final String POKEMON_NAME = "Que nombre tendrá el pokémon.";
    private static final String POKEMON_DESCRIPTION = "Que descripción tendrá en pokémon.";
    private static final String POKEMON_HEALTH = "Que vida máxima tendrá el pokémon.";
    private static final String POKEMON_SHINNY = "El pokémon es shinny, introduce false si es falso o true si es verdadero.";
    private static final String NEGATIVE_ENTRY = "Este campo no puede ser negativo.";
    private static final String INVALID_ENTRY = "Entrada no válida. Ingresa un número.";
    private static final String CHOOSE_TYPE = "Elige un tipo del pokémon.";
    private static final String CHOOSE_NUMBER_TYPE = "Elige el número correspondiente al tipo.";
    private static final String CHOOSE_NATURE = "Elige una naturaleza del pokémon.";
    private static final String CHOOSE_NUMBER_NATURE = "Elige el número correspondiente a la naturaleza.";
    private static final String INVALID_OPTION = "Opción inválida. Introduce un número entre 1 y ";

//    Atributos
    protected String nombre;
    protected String descripcionRegion;
    protected List<Medal> medallas;
    protected List<Pokemon> pokemons;
    protected List<Gym> gimnasios;
    protected ArrayList<Trainer> entrenadores;

//    Constructor
    public Region(String nombre, String descripcionRegion, List<Medal> medallas, List<Pokemon> pokemons, List<Gym> gimnasios, ArrayList<Trainer> entrenadores) {
        this.nombre = nombre;
        this.descripcionRegion = descripcionRegion;
        this.medallas = medallas;
        this.pokemons = pokemons;
        this.gimnasios = gimnasios;
        this.entrenadores = entrenadores;
    }

    public Region (String nombre, String descripcionRegion) {
        this.nombre = nombre;
        this.descripcionRegion = descripcionRegion;
    }

//    Metodos
    public List<Medal> showMedals() {
        return new ArrayList<>(medallas);
    }

    public List<Pokemon> showPokemons() {
        return new ArrayList<>(pokemons);
    }

    public List<Gym> showGym() {
        return new ArrayList<>(gimnasios);
    }

    public ArrayList<Trainer> showTrainers() {
        return new ArrayList<>(entrenadores);
    }

    public void addTrainer(Trainer trainer) {
        entrenadores.add(trainer);
        print(trainer.getNombre() + ADDED);
    }

//    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }
}