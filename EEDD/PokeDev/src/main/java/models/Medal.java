package models;

public class Medal {

//    Atributos
    protected String nombre;
    protected String descripcionMedalla;

//    Constructor
    public Medal(String nombre, String descripcionMedalla) {
        this.nombre = nombre;
        this.descripcionMedalla = descripcionMedalla;
    }

//    Metodos
    public String getNombre() {
        return nombre;
    }
}