//Implementar la clase operaciones. Se deben cargar dos valores enteros, calcular su suma,
//resta, multiplicación y división, cada una en un método, imprimir dichos resultados

package ejercicio_06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal_Operaciones {

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número, vuelve a introducirlo. ❌";
    private static final String EROR_NEGATIVO = "❌ Error: Debe introducir un número positivo, vuelve a introducirlo. ❌";

    private static final String GUARDAR_NUM1 = "Introduzca el valor del número 1.";
    private static final String GUARDAR_NUM2 = "Introduzca el valor del número 2.";

    private static final String PRESENTAR_PROGRAMA = "\uD83D\uDC4B ¡Bienvenido! Este programa le ayudará a mostrar la suma, resta, multiplicación y división de dos números introducidos. ¡Esperamos que le sea útil! \uD83C\uDF1F";
    private static final String FINALIZAR_PROGRAMA = "\uD83D\uDC4B ¡Gracias por usar nuestro programa! Espero que le haya sido útil. ¡Vuelva pronto! \uD83D\uDE0A";
    private static final String INFORMACIÓN = "Introduzca los valores de los números o introduzca en ambos un 0 para finalizar el programa.";

    public static void main(String[] args) {
        operaciones();
    }

    public static void operaciones () {
        Scanner sc = new Scanner(System.in);
        Operaciones op = new Operaciones();

        boolean checkNum1 = false;
        boolean checkNum2 = false;
        boolean finalizar = false;

        imprimir(PRESENTAR_PROGRAMA);
        imprimir(INFORMACIÓN);

        do {
            while (!checkNum1) {
                try{
                    imprimir(GUARDAR_NUM1);
                    op.setNum1(sc.nextDouble());
                    checkNum1 = true;
                } catch (InputMismatchException e) {
                    imprimirError(ERROR_TRYCATCH);
                    sc.next();
                }
            }

            while (!checkNum2) {
                try{
                    imprimir(GUARDAR_NUM2);
                    op.setNum2(sc.nextDouble());
                    checkNum2 = true;
                } catch (InputMismatchException e) {
                    imprimirError(ERROR_TRYCATCH);
                    sc.next();
                }
            }

            if (op.getNum1() == 0 && op.getNum2() == 0) {
                imprimir(FINALIZAR_PROGRAMA);
                finalizar = true;
            } else {
                op.suma();
                op.resta();
                op.multiplicacion();
                op.division();
                checkNum1 = false;
                checkNum2 = false;
            }
        } while (!finalizar);
    }

    //    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }

    public static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
