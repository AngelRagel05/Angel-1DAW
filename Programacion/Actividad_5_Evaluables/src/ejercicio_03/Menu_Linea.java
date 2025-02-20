package ejercicio_03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Linea {
    private static Scanner sc = new Scanner(System.in);

    private static final String INICIAR_PROGRAMA = "🚀 ¡¡¡BIENVENIDO!!! 🌟 Este programa sirve para mover una línea en las diferentes direcciones.";
    private static final String INTRODUCCION = "📏 Introduzca las coordenadas de los dos puntos para crear la línea que quiera.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. Espero que le haya servido, vuelve pronto. 😊";

    private static final String PUNTO_1 = "📍 Introduzca las coordenadas del 1º punto.";
    private static final String PUNTO_2 = "📍 Introduzca las coordenadas del 2º punto.";
    private static final String RECOGER_X = "Introduzca la posición en el eje X.";
    private static final String RECOGER_Y = "Introduzca la posición en el eje Y.";

    private static final String INFO_MENU = "📋 Elija una de las siguientes opciones:";
    private static final String ELIGE_OPC = "👉 Elige la opción que desea realizar.";
    private static final String OPC_1 = "1️⃣ Esta opción mueve la línea a la derecha.";
    private static final String OPC_2 = "2️⃣ Esta opción mueve la línea a la izquierda.";
    private static final String OPC_3 = "3️⃣ Esta opción mueve la línea hacia abajo.";
    private static final String OPC_4 = "4️⃣ Esta opción mueve la línea hacia arriba.";
    private static final String OPC_5 = "5️⃣ Esta opción muestra la información de la línea.";
    private static final String OPC_6 = "6️⃣ En esta opción podrás salir del menú. 🚪";
    private static final String DEFAULT = "⚠️ Error: introduzca una opción correcta.";

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo.";

    private static final String RECOGER_VALOR = "🔄 Introduzca cuánto quiere mover la línea.";

    //    Funciones
    protected static void menu() {
        presentarPrograma();
        imprimir(PUNTO_1);
        Punto pun1 = new Punto(guardarX(), guardarY());
        imprimir(PUNTO_2);
        Punto pun2 = new Punto(guardarX(), guardarY());
        Linea lin = new Linea(pun1, pun2);
        boolean check = false;
        int op = 0;

        mostrarInfoMenu();
        while (!check) {
            switch (guardarOpcion(op)) {
                case 1:
                    lin.mueveDerecha(recogerValor());
                    break;
                case 2:
                    lin.mueveIzquierda(recogerValor());
                    break;
                case 3:
                    lin.mueveArriba(recogerValor());
                    break;
                case 4:
                    lin.mueveAbajo(recogerValor());
                    break;
                case 5:
                    lin.mostrarInfo();
                    break;
                case 6:
                    imprimir(FINALIZAR_PROGRAMA);
                    check = true;
                    break;
                default:
                    imprimir(DEFAULT);
            }
        }
    }

    private static double guardarX () {
        imprimir(RECOGER_X);
        double x = sc.nextDouble();
        return x;
    }

    private static double guardarY () {
        imprimir(RECOGER_Y);
        double y = sc.nextDouble();
        return y;
    }

    private static void mostrarInfoMenu () {
        imprimir(OPC_1);
        imprimir(OPC_2);
        imprimir(OPC_3);
        imprimir(OPC_4);
        imprimir(OPC_5);
        imprimir(OPC_6);
    }

    private static int guardarOpcion (int valor) {
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

    private static double recogerValor() {
        imprimir(RECOGER_VALOR);
        double distancia = sc.nextDouble();
        return distancia;
    }

    private static void presentarPrograma() {
        imprimir(INICIAR_PROGRAMA);
        imprimir(INTRODUCCION);
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
