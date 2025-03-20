package models;

import models.abstracts.Person;
import models.enumerations.Item;
import models.enumerations.Type;
import models.interfaces.iProfessor;

import java.util.*;

public class Professor extends Person implements iProfessor {

    private static Scanner sc = new Scanner(System.in);

    private static final String EMPTY_POKEMON = "No hay Pokémon iniciales disponibles.";
    private static final String POKEMON_AVAILABLE = "Pokémon disponibles:";
    private static final String CHOOSE_POKEMON = "Elige un Pokémon (1-";
    private static final String WRONG_CHOOSE = "Selección inválida. Debe estar entre 1 y ";
    private static final String CHOSEN_POKEMON = " ha recibido a ";
    private static final String INVALID_OPTION = "Error: Debes ingresar un número válido.";

//    Atributos
    protected Type tipo;
    protected Region region;
    protected List<Pokemon> pokemonLab;
    protected ArrayList<Item> objetosIniciales;

//    Constructor
    public Professor(String nombre, Type especialidad, Region region, List<Pokemon> pokemonLab, ArrayList<Item> objetosIniciales) {
        super(nombre);
        this.tipo = especialidad;
        this.region = region;
        this.pokemonLab = pokemonLab;
        this.objetosIniciales = objetosIniciales;
    }

    public Professor(String nombre, Type especialidad, Region region) {
        super(nombre);
        this.tipo = especialidad;
        this.region = region;
    }

    //    Metdodos
    public void deliverStarterPokemon(Trainer trainer) {
        if (pokemonLab.isEmpty()) {
            print(EMPTY_POKEMON);
        }

        print(POKEMON_AVAILABLE);
        for (int i = 0; i < pokemonLab.size(); ++i) {
            print((i+1) + ". " + pokemonLab.get(i).getNombre());
        }

        int opc = -1;
        boolean check = false;

        while (!check) {
            try {
                print(CHOOSE_POKEMON + pokemonLab.size() + "): ");
                opc = sc.nextInt() - 1;

                while (opc < 0 || opc >= pokemonLab.size()) {
                    printError(WRONG_CHOOSE + pokemonLab.size());
                    opc = sc.nextInt();
                }

                Pokemon pokeSeleccionado = pokemonLab.get(opc);

                trainer.getPokemons().add(pokeSeleccionado);

                print(trainer.getNombre() + CHOSEN_POKEMON + pokeSeleccionado.getNombre());

                check = true;

            } catch (InputMismatchException e) {
                printError(INVALID_OPTION);
                sc.next();
            }
        }
    }

    public void researchPokemon(Pokemon pokemon) {
        print("El pokémon: " + pokemon.getNombre() + " está siendo investigado por el profesor: " + getNombre() + ". \n" +
                 "Estos son los resultados: \n" + pokemon.toString());
    }

//    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }

    private static void printError(String frase) {
        System.err.println(frase);
    }
}