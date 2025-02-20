package ejercicio_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Empleado {

    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static final String GUARDAR_DNI = "🔢 Introduzca el DNI de su trabajador.";
    private static final String ERROR_LONGITUD_DNI = "❌ Error: El DNI debe tener 9 caracteres, vuelve a introducir su DNI.";
    private static final String ERROR_PRIMEROS_NUM = "❌ Error: Los primeros 8 caracteres deben ser números.";
    private static final String ERROR_LETRA_DNI = "❌ Error: La letra no es correcta. Debe ser: ";

    private static final String SUELDO = "💰 Introduzca el sueldo base por mes del trabajador.";

    private static final String PAGO_HORA_EXTRA = "⏳ Introduzca el precio por hora de las horas extras.";

    private static final String HORAS_EXTRAS = "⏰ Introduzca cuántas horas extras ha realizado el trabajador este mes.";

    private static final String CASADO = "💍 Introduzca un 0 si está casado o un 1 si está soltero.";
    private static final String ERROR_CASADO = "❌ Error: Debe introducir un 0 o 1.";

    private static final String NUM_HIJOS = "👶 Introduzca el número de hijos que tenga.";

    private static final String INICIAR_PROGRAMA = "🚀 ¡¡¡BIENVENIDO!!! 🌟 Este programa sirve para saber la información básica de su trabajador.";
    private static final String FINALIZAR_PROGRAMA = "🔚 Has finalizado el programa. Espero que le haya servido, vuelve pronto. 😊";

    private static final String INFO_MENU = "📋 Elija una de las siguientes opciones:";
    private static final String OPC_1 = "1️⃣ Esta opción devuelve el dinero extra que cobra el trabajador.";
    private static final String OPC_2 = "2️⃣ Esta opción devuelve el sueldo bruto del trabajador.";
    private static final String OPC_3 = "3️⃣ Esta opción devuelve el descuento al sueldo del trabajador.";
    private static final String OPC_4 = "4️⃣ Esta opción muestra la información básica del trabajador.";
    private static final String OPC_5 = "5️⃣ Esta opción muestra la información avanzada del trabajador.";
    private static final String OPC_6 = "6️⃣ En esta opción podrás salir del menú. 🚪";
    private static final String ELIGE_OPC = "👉 Elige la opción que desea realizar.";
    private static final String DEFAULT = "⚠️ Error: introduzca una opción correcta.";

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo.";

    private static final String DINERO_EXTRA = "💵 El dinero extra que cobra el trabajador es: ";
    private static final String SUELDO_BRUTO = "💰 El sueldo bruto del trabajador es: ";
    private static final String DESCUENTO_SUELDO = "📉 Lo que se le descuenta al trabajador es: ";

//    Funciones
//    Función ejecutar
    public static void menu () {
        Empleado emp = new Empleado();
        boolean check = false;
        int op = 0;

        recogidaDatos(emp);
        mostrarInfoMenu();

        while (!check) {
            switch (guardarOpcion(op)) {
                case 1:
                    imprimir(DINERO_EXTRA + emp.dineroExtra());
                    break;
                case 2:
                    imprimir(SUELDO_BRUTO + emp.sueldoBruto());
                    break;
                case 3:
                    imprimir(DESCUENTO_SUELDO + emp.descuentoSueldo());
                    break;
                case 4:
                    emp.infoBasica();
                    break;
                case 5:
                    emp.infoAvanzada();
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

    //    Funcion para agrupar todas las recogidas de datos
    private static void recogidaDatos (Empleado emp) {
        imprimir(INICIAR_PROGRAMA);
        emp.setNif(guardarDNI());
        emp.setSueldo(guardarSueldo());
        emp.setHorasExtras(guardarHorasExtras());
        emp.setPagoExtra(guardarPagoHoraExtra());
        emp.setIrpf(emp.irpf());
        emp.setCasado(guardarCasado());
        emp.setNumHijos(guardarHijos());
    }

    //    Guardo el DNI
    private static String guardarDNI() {
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
        return dni;
    }

    //    Guardo el Sueldo
    private static double guardarSueldo() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        double sueldo = 0;

        imprimir(SUELDO);
        while (!check) {
            try {
                sueldo = sc.nextDouble();

                while (sueldo < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    sueldo = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return sueldo;
    }

    //    Guardar horas extras
    private static double guardarHorasExtras() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        double horaExtra = 0;

        imprimir(HORAS_EXTRAS);
        while (!check) {
            try {
                horaExtra = sc.nextDouble();
                while (horaExtra < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    horaExtra = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return horaExtra;
    }

    //    Guardar pago por hora extra
    private static double guardarPagoHoraExtra() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        double pagoHoraExtra = 0;

        imprimir(PAGO_HORA_EXTRA);
        while (!check) {
            try {
                pagoHoraExtra = sc.nextDouble();
                while (pagoHoraExtra < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    pagoHoraExtra = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return pagoHoraExtra;
    }

    //    Guardar estado civil
    private static boolean guardarCasado() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        int cas = 0;
        boolean infeliz = false;

        imprimir(CASADO);
        while (!check) {
            try {
                cas = sc.nextInt();
                if (cas == 0) {
                    infeliz = true;
                    check = true;
                } else if (cas == 1) {
                    infeliz = false;
                    check = true;
                } else {
                    imprimirError(ERROR_CASADO);
                }
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return infeliz;
    }

    //    Guardar números hijos
    private static int guardarHijos() {
        Scanner sc = new Scanner(System.in);
        int numHijos = 0;
        boolean check = false;

        imprimir(NUM_HIJOS);
        while (!check) {
            try {
                numHijos = sc.nextInt();
                while (numHijos < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    numHijos = sc.nextInt();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return numHijos;
    }

    //    Muestro info del programa
    private static void mostrarInfoMenu () {
        imprimir(INFO_MENU);
        imprimir(OPC_1);
        imprimir(OPC_2);
        imprimir(OPC_3);
        imprimir(OPC_4);
        imprimir(OPC_5);
        imprimir(OPC_6);
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

    private static void imprimirDouble (double decimal) {
        System.out.println(decimal);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }
}