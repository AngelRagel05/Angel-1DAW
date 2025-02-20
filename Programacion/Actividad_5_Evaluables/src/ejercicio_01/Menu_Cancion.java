package ejercicio_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Cancion {

    private static final String INICIAR_PROGRAMA = "🎵 ¡¡¡BIENVENIDO!!! 🎶 Este programa le ayudará a introducir el autor y el título de sus canciones.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. 🎧 Espero que le haya servido, vuelve pronto. 😊";

    private static final String INFO_MENU = "📋 Elija una de las siguientes opciones:";
    private static final String OPC_1 = "1️⃣ En esta opción podrás cambiar el título de la canción.";
    private static final String OPC_2 = "2️⃣ En esta opción podrás cambiar el autor de la canción.";
    private static final String OPC_3 = "3️⃣ En esta opción podrás ver el título y el autor de la canción.";
    private static final String OPC_4 = "4️⃣ En esta opción podrás salir del menú. 🚪";
    private static final String ELIGE_OPC = "👉 Elige la opción que desea realizar.";
    private static final String DEFAULT = "⚠️ Error: introduzca una opción correcta.";

    private static final String PEDIR_AUTOR = "✍️ Introduzca el autor de la canción.";
    private static final String PEDIR_TITULO = "📝 Introduzca el título de la canción.";

    private static final String ERROR_TRYCATCH = "⛔ Error: Debe introducir un número entero.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número entero positivo.";

    //    Funciones
    public static void cancion () {
        Scanner sc = new Scanner(System.in);
        Cancion can = new Cancion();
        int op = 0;
        boolean check = false;

        mostrarInfoMenu();
        while (!check) {
            switch (guardarOpcion(op)) {
                case 1:
                    imprimir(PEDIR_TITULO);
                    can.setTitulo(sc.nextLine());
                    break;
                case 2:
                    imprimir(PEDIR_AUTOR);
                    can.ponAutor(sc.nextLine());
                    break;
                case 3:
                    can.dameTitulo();
                    can.dameAutor();
                    break;
                case 4:
                    imprimir(FINALIZAR_PROGRAMA);
                    check = true;
                    break;

                default:
                    imprimirError(DEFAULT);
            }
        }
    }

    public static void mostrarInfoMenu () {
        imprimir(INICIAR_PROGRAMA);
        imprimir(INFO_MENU);
        imprimir(OPC_1);
        imprimir(OPC_2);
        imprimir(OPC_3);
        imprimir(OPC_4);
    }

    public static int guardarOpcion (int valor) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;

        while (!check) {
            try {
                imprimir(ELIGE_OPC);
                valor = sc.nextInt();

                while (valor < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    imprimir(ELIGE_OPC);
                    valor = sc.nextInt();
                }

                check = true;

            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return valor;
    }

    public static void imprimir (String frase) {
        System.out.println(frase);
    }

    public static void imprimirError (String frase) {
        System.err.println(frase);
    }

    public static void imprimirInt (int numero) {
        System.out.println(numero);
    }
}
