package ejercicio_07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Contrasena {
    private static Scanner sc = new Scanner(System.in);
    private static boolean check = false;

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo.";

    private static final String INICIAR_PROGRAMA = "🚀 ¡¡¡BIENVENIDO!!! 🌟 Este programa sirve para generar contraseñas con la longitud que quiera.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. Espero que le haya servido, vuelva pronto. 😊";

    private static final String GUARDAR_LONGITUD = "Introduzca la longitud de la contraseña que quiera generar.";
    private static final String GUARDAR_CONTRASENA = "Introduzca su contraseña para entrar a la aplicación.";

    private static final String GUARDAR_TAM_ARRAY = "Introduce la cantidad de contraseñas que quiera generar.";

    private static final String MOSTRAR_CONTRASENA = "Contraseña nº ";

    protected static void menu () {
        presentar();
        Contrasena pass = new Contrasena(guardarContrasena(), guardarLongitud());
        String contraseñas [] = new String [guardarTamArray()];
        llenarArrayPassword(contraseñas, pass);
        mostrarArray(contraseñas);
        imprimir(FINALIZAR_PROGRAMA);
    }

    private static void llenarArrayPassword(String contraseña[], Contrasena pass) {
        for (int i = 0; i < contraseña.length; i++) {
            contraseña[i] = pass.generarPassword();
        }
    }

    private static void mostrarArray(String contraseña[]) {
        for (int i = 0; i < contraseña.length; i++) {
            imprimir(MOSTRAR_CONTRASENA + (i+1) + " " + contraseña[i]);
        }
    }

    private static String guardarContrasena() {
        imprimir(GUARDAR_CONTRASENA);
        String pass = sc.nextLine();
        return pass;
    }

    private static int guardarLongitud() {
        int longi = 0;
        while (!check) {
            try {
                imprimir(GUARDAR_LONGITUD);
                longi = sc.nextInt();
                while (longi < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    longi = sc.nextInt();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        check = false;
        return longi;
    }

    private static void presentar () {
        imprimir(INICIAR_PROGRAMA);
    }

    private static int guardarTamArray() {
        int tam = 0;
        while (!check) {
            try {
                imprimir(GUARDAR_TAM_ARRAY);
                tam = sc.nextInt();
                while (tam < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    sc.next();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        check = false;
        return tam;
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }
}