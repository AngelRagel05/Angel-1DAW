//Confeccionar una clase que represente un empleado. Definir como atributos su nombre y su
//sueldo. Confeccionar los métodos para la carga, otro para imprimir sus datos y por último
//uno que imprima un mensaje si debe pagar impuestos (si el sueldo supera a 3000)

package ejercicio_05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal_Empleado {

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número, vuelve a introducirlo. ❌";
    private static final String EROR_NEGATIVO = "❌ Error: Debe introducir un número positivo, vuelve a introducirlo. ❌";

    private static final String PRESENTAR_PROGRAMA = "\uD83D\uDC4B ¡Bienvenido! Este programa le ayudará a mostrar el nombre y sueldo de un empleado, además de informarle si debe pagar impuestos. ¡Esperamos que le sea útil! \uD83C\uDF1F";
    private static final String FINALIZAR_PROGRAMA = "\uD83D\uDC4B ¡Gracias por usar nuestro programa! Espero que le haya sido útil. ¡Vuelva pronto! \uD83D\uDE0A";

    private static final String RECOGER_NOMBRE = "\uD83D\uDD8A\uFE0F Por favor, introduzca el nombre del empleado:";
    private static final String RECOGER_SUELDO = "\uD83D\uDCB0 Por favor, introduzca el sueldo del empleado:";

    public static void main(String[] args) {
        empleado();
    }

    public static void empleado () {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Empleado emp = new Empleado();

        boolean check = false;

        imprimir(PRESENTAR_PROGRAMA);

        while (!check) {
            try {
                imprimir(RECOGER_SUELDO);
                emp.setSueldo(sc.nextDouble());
                imprimir(RECOGER_NOMBRE);
                emp.setNombre(sc1.nextLine());

                emp.mostrarInfo();
                emp.impuestos();

                check = true;

            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
    }

    //    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }

    public static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
