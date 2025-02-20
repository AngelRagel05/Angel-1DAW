//Implementar la clase operaciones. Se deben cargar dos valores enteros, calcular su suma,
//resta, multiplicación y división, cada una en un método, imprimir dichos resultados

package ejercicio_06;

public class Operaciones {

    private static final String SUMA = "La suma de los dos números introducidos es: ";
    private static final String RESTA = "La resta de los dos números introducidos es: ";
    private static final String DIVISION = "La división de los dos números introducidos es: ";
    private static final String MULTIPLICACION = "La multiplicación de los dos números introducidos es: ";
    private static final String PUNTO_FINAL = ".";

//    Atributos
    public double num1;
    public double num2;

//    Constructor
    public Operaciones () {
    }

//    Metdodos
    public void suma() {
        double suma = num1 + num2;
        imprimir(SUMA + suma + PUNTO_FINAL);
    }

    public void resta() {
        double resta = getNum1() - getNum2();
        imprimir(RESTA + resta + PUNTO_FINAL);
    }

    public void multiplicacion() {
        double multiplicacion = getNum1() * getNum2();
        imprimir(MULTIPLICACION + multiplicacion + PUNTO_FINAL);
    }

    public void division() {
        double division = getNum1() / getNum2();
        imprimir(DIVISION + division + PUNTO_FINAL);
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    //    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}
