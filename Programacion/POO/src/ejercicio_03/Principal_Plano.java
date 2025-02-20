//Desarrollar una clase que represente un punto en el plano y tenga los siguientes métodos:
//cargar los valores de x e y, imprimir en que cuadrante se encuentra dicho punto.

package ejercicio_03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal_Plano {

    private static final String MOSTRAR_X = "El valor de X es: ";
    private static final String MOSTRAR_Y = "El valor de Y es: ";
    private static final String PUNTO_FINAL = ".";

    private static final String GUARDAR_NÚMERO = "Introduzca los valores de X e Y.";
    private static final String GUARDAR_X = "Introduzca el valor de X.";
    private static final String GUARDAR_Y = "Introduzca el valor de Y.";
    private static final String PRESENTAR_PROGRAMA = "Bienvenido al programa que te ayuda a decir que valores tienen la \"X\" y la \"Y\" y a decirnos en que cuadrante se encuentra.";

    private static final String ERROR_TRYCATCH = "Error: Debe introducir un número.";

    public static void main(String[] args) {
        plano();
    }

    public static void plano () {
        Plano pla = new Plano ();
        Scanner sc = new Scanner (System.in);
        boolean checkX = false;
        boolean checkY = false;

        imprimir(PRESENTAR_PROGRAMA);
        imprimir(GUARDAR_NÚMERO);

        while (!checkX) {
            try{
                imprimir(GUARDAR_X);
                pla.setX(sc.nextDouble());
                checkX = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }

        while (!checkY) {
            try{
                imprimir(GUARDAR_Y);
                pla.setY(sc.nextDouble());
                sc.close();
                checkY = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        pla.mostrarEjes();
        pla.cuadrante();
    }

    public static void imprimir (String frase) {
        System.out.println(frase);
    }

    public static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
