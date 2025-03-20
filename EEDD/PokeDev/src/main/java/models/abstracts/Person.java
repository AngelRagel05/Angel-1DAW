package models.abstracts;

public abstract  class Person {
// PREGUBTAR METODO ABSATRACTO
//    Atributos
    protected String nombre;

//    Constructor
    public Person(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}