package models;

import models.enumerations.Item;
import models.enumerations.Nature;
import models.enumerations.Type;
import models.interfaces.iPokemon;

public class Pokemon implements iPokemon {

    private final static String INCORRECT_ITEM = "No ha elegido el item correcto.";

//    Atributos
    protected Integer numPokedex;
    protected String nombre;
    protected String descripcionPokemon;
    protected Double salud;
    protected Double maxSalud;
    protected Integer nivel;
    protected Boolean shinny;
    protected Nature naturaleza;
    protected Type tipo;

//    Constructor
    public Pokemon(Integer numPokedex, String nombre, String descripcionPokemon, Double maxSalud, Integer nivel, Boolean shinny, Nature naturaleza, Type tipo) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.descripcionPokemon = descripcionPokemon;
        this.salud = maxSalud;
        this.maxSalud = maxSalud;
        this.nivel = nivel;
        this.shinny = shinny;
        this.naturaleza = naturaleza;
        this.tipo = tipo;
    }

    public Pokemon(Integer numPokedex, String nombre, String descripcionPokemon) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.descripcionPokemon = descripcionPokemon;
    }

//    Metodos
    public void cure(Item item) {
        if (item.equals("POTION")) {
            salud = salud + 100;
        } else if (item.equals("FULL_RESTORE")) {
            salud = maxSalud;
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public void levelUp(Item item) {
        if (item.equals("RARE_CANDY")) {
            nivel = nivel + 1;
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public void revive(Item item) {
        if (item.equals("REVIVE")) {
            salud = maxSalud;
        } else {
            print(INCORRECT_ITEM);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    //    Funciones
    private static void print(String frase) {
        System.out.println(frase);
    }

    @Override
    public String toString() {
        return "===========================\n" +
                "        POKÉMON\n" +
                "===========================\n" +
                "Nombre       : " + nombre + "\n" +
                "Descripción  : " + descripcionPokemon + "\n" +
                "Shiny        : " + (shinny ? "Sí" : "No") + "\n" +
                "Nivel        : " + nivel + "\n" +
                "===========================";
    }



}