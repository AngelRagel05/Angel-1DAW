package ejercicio_04;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Cuenta {
    private static Scanner sc = new Scanner(System.in);

    private static final String INICIAR_PROGRAMA = "🚀 ¡¡¡BIENVENIDO!!! 🌟 Este programa sirve para ver el saldo de su cliente y realizar operaciones.";
    private static final String INTRODUCCION = "📝 Introduzca los datos que se le pide.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. Espero que le haya servido, vuelve pronto. 😊";

    private static final String ELIGE_OPC = "👉 Elige la opción que desea realizar.";
    private static final String OPC_1 = "1️⃣ Esta opción podrás actualizar el saldo de la cuenta, aplicandole el interés diario.";
    private static final String OPC_2 = "2️⃣ Esta opción podrás ingresar dinero a su cuenta.";
    private static final String OPC_3 = "3️⃣ Esta opción podrás retirar dinero de su cuenta.";
    private static final String OPC_4 = "4️⃣ Esta opción podrás ver la información de su cuenta.";
    private static final String OPC_5 = "5️⃣ En esta opción podrás salir del menú. 🚪";
    private static final String DEFAULT = "⚠️ Error: introduzca una opción correcta.";

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo.";

    private static final String GUARDAR_CUENTA_BANCARIA = "🏦 Introduzca el número de su cuenta bancaria.";
    private static final String ERROR_LONGITUD = "❌ Error: Debe introducir 20 números.";
    private static final String ERROR_NUMERICO = "❌ Error: Debe introducir solo números.";

    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String GUARDAR_DNI = "🔢 Introduzca el DNI de su cliente.";
    private static final String ERROR_LONGITUD_DNI = "❌ Error: El DNI debe tener 9 caracteres, vuelve a introducir su DNI.";
    private static final String ERROR_PRIMEROS_NUM = "❌ Error: Los primeros 8 caracteres deben ser números.";
    private static final String ERROR_LETRA_DNI = "❌ Error: La letra no es correcta. Debe ser: ";

    private static final String GUARDAR_SALDO_ACTUAL = "💰 Introduzca su saldo actual.";

    private static final String GUARDAR_INTERES = "📊 Introduzca el interés anual 💹.";

    //    Funciones
    protected static void menu () {
        Cuenta cue = new Cuenta();
        boolean check = false;
        int op = 0;
        recogerDatos(cue);
        mostrarInfoMenu();
        while (!check) {
            switch (guardarOpcion(op)) {
                case 1:
                    cue.actualizarSaldo();
                    break;
                case 2:
                    cue.ingresar();
                    break;
                case 3:
                    cue.retirar();
                    break;
                case 4:
                    cue.mostrarInfo();
                    break;
                case 5:
                    imprimir(FINALIZAR_PROGRAMA);
                    check = true;
                    break;
                default:
                    imprimir(DEFAULT);
            }
        }
    }

    private static void recogerDatos(Cuenta cue) {
        imprimir(INICIAR_PROGRAMA);
        imprimir(INTRODUCCION);
        guardarCuentaBancaria(cue);
        guardarDNI(cue);
        guardarSaldoAtual(cue);
        guardarInteresAnual(cue);
    }

    private static void guardarCuentaBancaria (Cuenta cue) {
        imprimir(GUARDAR_CUENTA_BANCARIA);
        String cuentaBancaria = sc.nextLine().replaceAll(" ", "");
        boolean check = false;
        while (!check) {
            if (cuentaBancaria.length() != 20) {
                imprimirError(ERROR_LONGITUD);
                cuentaBancaria = sc.nextLine().replaceAll(" ", "");
                continue;
            }
            if (!cuentaBancaria.matches("\\d{20}")) {
                imprimirError(ERROR_NUMERICO);
                cuentaBancaria = sc.nextLine().replaceAll(" ", "");
                continue;
            }
            cue.setCuentaBancaria(new BigInteger(cuentaBancaria));
            check = true;
        }
    }

    private static void guardarDNI (Cuenta cue) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        String dni = "";
        int numero = 0;

        while (!check) {
            imprimir(GUARDAR_DNI);
            dni = sc.nextLine().toUpperCase().replaceAll(" ", "");

            if (dni.length() != 9) {
                imprimirError(ERROR_LONGITUD_DNI);
                continue;
            }

            String num = dni.substring(0, 8);
            char letra = dni.charAt(8);

            if (!num.matches("\\d{8}")) {
                imprimirError(ERROR_PRIMEROS_NUM);
                continue;
            }

            numero = Integer.parseInt(num);
            char letraCorrecta = LETRAS_DNI.charAt(numero % 23);

            if (letra != letraCorrecta) {
                imprimirError(ERROR_LETRA_DNI + letraCorrecta);
                continue;
            }
            check = true;
        }
        cue.setDni(dni);
    }

    private static void guardarSaldoAtual (Cuenta cue) {
        boolean check = false;
        double saldo = 0;
        imprimir(GUARDAR_SALDO_ACTUAL);
        while (!check) {
            try {
                saldo = sc.nextDouble();
                while (saldo < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    saldo = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        cue.setSaldoActual(saldo);
    }

    private static void guardarInteresAnual (Cuenta cue) {
        boolean check = false;
        double interes = 0;
        imprimir(GUARDAR_INTERES);
        while (!check) {
            try {
                interes = sc.nextDouble();
                while (interes < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    interes = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        cue.setInteresAnual(interes);
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

    private static void mostrarInfoMenu() {
        imprimir(OPC_1);
        imprimir(OPC_2);
        imprimir(OPC_3);
        imprimir(OPC_4);
        imprimir(OPC_5);
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
