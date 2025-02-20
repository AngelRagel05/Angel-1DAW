//Confeccionar una clase que represente un empleado. Definir como atributos su nombre y su
//sueldo. Confeccionar los métodos para la carga, otro para imprimir sus datos y por último
//uno que imprima un mensaje si debe pagar impuestos (si el sueldo supera a 3000)

package ejercicio_05;

public class Empleado {

    private final static String EMPLEADO = "El empleado ";
    private final static String SI_IMPUESTOS = " SI deberá pagar impuestos.";
    private final static String NO_IMPUESTOS = " NO deberá pagar impuestos.";

    private final static String MOSTRAR_NOMBRE = "El nombre del empleado es: ";
    private final static String MOSTRAR_SUELDO = "Y su sueldo es: ";
    private static final String PUNTO_FINAL = ".";

//    Atributos
    public String nombre;
    public double sueldo;

//    Constructor
    public Empleado () {
    }

    //    Metodos
    public void impuestos () {
        if (sueldo > 3000) {
            imprimir(EMPLEADO + getNombre() + SI_IMPUESTOS);
        } else {
            imprimir(EMPLEADO + getNombre() + NO_IMPUESTOS);
        }
    }

    public void mostrarInfo () {
        imprimir(MOSTRAR_NOMBRE + getNombre() + PUNTO_FINAL);
        imprimir(MOSTRAR_SUELDO + getSueldo() + PUNTO_FINAL);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

//    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}
