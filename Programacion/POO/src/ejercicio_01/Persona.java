package ejercicio_01;

public class Persona {

    //	Atributos
    public String nombre;
    public int edad;

    //	Constructor
    public Persona (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //	Metodo
    public void mostrarInfo () {
        System.out.println("Nombre: " + nombre + ".");
        System.out.println("edad: " + edad + ".");
    }

    public void mayor18 () {
        if (edad >= 18) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("No es mayor de edad.");
        }
    }
}

