package ejercicio_08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Cafetera {
    private static Scanner sc = new Scanner(System.in);
    private static boolean check = false;
    private static int op = 0;

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo.";

    private static final String INICIAR_PROGRAMA = "🚀 ¡¡¡BIENVENIDO!!! 🌟 Este programa sirve para ver la cantidad de café de su cafetera y si quiere agregar café o servir una taza.";
    private static final String INTRODUCCION = "📝 Introduzca los datos que se le pide.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. Espero que le haya servido, vuelva pronto. 😊";

    private static final String ELIGE_OPC = "👉 Elige la opción que desea realizar.";
    private static final String OPC_1 = "1️⃣ Esta opción podrás llenar la cafetera al máximo.";
    private static final String OPC_2 = "2️⃣ Esta opción podrás servir una taza con la cantidad que quiera.";
    private static final String OPC_3 = "3️⃣ Esta opción podrás vaciar la cafetera.";
    private static final String OPC_4 = "4️⃣ Esta opción podrás agregar café a su cafetera.";
    private static final String OPC_5 = "5️⃣ En esta opción podrás ver información de la cafetera.";
    private static final String OPC_6 = "6️⃣ En esta opción podrás salir del menú. 🚪";
    private static final String DEFAULT = "⚠️ Error: introduzca una opción correcta.";

    private static final String GUARDAR_CAPACIDAD_ACTUAL = "Introduzca la cantidad de café que tiene ahora en su cafetera.";
    private static final String GUARDAR_CAPACIDAD_MAXIMA = "Introduzca la cantidad de café máxima para su cafetera.";

    private static final String CAPACIDAD_ACTUAL = "La cantidad actual es: ";
    private static final String CAPACIDAD_MAXIMA = "La cantidad máxima es: ";

//    Funciones
    protected static void menu () {
        imprimir(INICIAR_PROGRAMA);
        Cafetera caf = new Cafetera(capCafeAct(), capCafeMax());
        caf.logicaCapacidad();
        mostrarInfoMenu();
        while (!check) {
            switch (guardarOpcion(op)) {
                case 1:
                    caf.llenarCafetera();
                    break;
                case 2:
                    caf.servirTaza();
                    break;
                case 3:
                    caf.vaciarCafetera();
                    break;
                case 4:
                    caf.agregarCafe();
                    break;
                case 5:
                    mostrarInfoCafetera(caf);
                    break;
                case 6:
                    imprimir(FINALIZAR_PROGRAMA);
                    check = true;
                    break;
                default:
                    imprimirError(DEFAULT);
            }
        }
    }

    private static double capCafeAct() {
        double capAct = 0;
        while (!check) {
            try {
                imprimir(GUARDAR_CAPACIDAD_ACTUAL);
                capAct = sc.nextDouble();
                while (capAct < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    capAct = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        check = false;
        return capAct;
    }

    private static double capCafeMax() {
        double capMax = 0;
        while (!check) {
            try {
                imprimir(GUARDAR_CAPACIDAD_MAXIMA);
                capMax = sc.nextDouble();
                while (capMax < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    capMax = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        check = false;
        return capMax;
    }

    private static void mostrarInfoMenu() {
        imprimir(OPC_1);
        imprimir(OPC_2);
        imprimir(OPC_3);
        imprimir(OPC_4);
        imprimir(OPC_5);
        imprimir(OPC_6);
    }

    private static void mostrarInfoCafetera(Cafetera caf) {
        imprimir(CAPACIDAD_MAXIMA + caf.getCapacidadMaxima());
        imprimir(CAPACIDAD_ACTUAL + caf.getCapacidadActual());
    }

    private static int guardarOpcion (int valor) {
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

    private static void imprimir (String frase) {
        System.out.println(frase);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }
}