//Desarrollar una clase que represente un Cuadrado y tenga los siguientes métodos:
//cargar el valor de su lado, imprimir su perímetro y su superficie

package ejercicio_04;

public class Cuadrado {

    private static final String SUPERFICIE_CUADRADO = "La superficie del cuadrado dado el lado es: ";
    private static final String PERIMETRO_CUADRADO = "El perimetro del cuadrado dado el lado es: ";

    private static final String PUNTO_FINAL = ".";

//    Atributos
    public double lado;

//    Constructor
    public Cuadrado () {
    }

//    Metodos
    public void superficie () {
        double superficie = lado * lado;
        imprimir(SUPERFICIE_CUADRADO + superficie + PUNTO_FINAL);
    }

    public void perimetro () {
        double perimetro = lado * 4;
        imprimir(PERIMETRO_CUADRADO + perimetro + PUNTO_FINAL);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

//    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}
