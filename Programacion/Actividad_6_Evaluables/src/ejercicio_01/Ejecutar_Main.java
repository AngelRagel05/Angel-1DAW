package ejercicio_01;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejecutar_Main {

    private static final Scanner sc = new Scanner(System.in);
    private static boolean check = false;
    private static int op = 0;

    private static final String ASK_NAME = "📝 Introduzca el nombre del usuario.";
    private static final String ASK_DATE = "📅 Introduzca la fecha de nacimiento del usuario en formato <dd-mm-aaaa>.";
    private static final String ASK_DNI = "🆔 Introduzca el DNI del usuario en formato <12345678X> o <12345678-X>.";
    private static final String AUTHORIZED_ACCESS = "✅ Acceso autorizado a la aplicación. Tu edad es: ";
    private static final String MENU_INFORMATION = "📋 Elija una de las siguientes opciones:";
    private static final String OPTION_1 = "1️⃣ ➕ Esta opción añadirá un gasto a la cuenta.";
    private static final String OPTION_2 = "2️⃣ 💰 Esta opción añadirá un ingreso a la cuenta.";
    private static final String OPTION_3 = "3️⃣ 📉 Esta opción muestra los gastos en la cuenta.";
    private static final String OPTION_4 = "4️⃣ 📈 Esta opción muestra los ingresos en la cuenta.";
    private static final String OPTION_5 = "5️⃣ 💳 Esta opción muestra el saldo de la cuenta.";
    private static final String OPTION_6 = "6️⃣ 🚪 En esta opción podrás salir del menú.";
    private static final String CHOOSE_OPTION = "👉 Elige la opción que desea realizar.";
    private static final String END_PROGRAM = "🔚 Has finalizado el programa. Espero que le haya servido, vuelve pronto. 😊";
    private static final String ASK_DESCRIPTION_SPENT = "📝 Introduzca una breve descripción del gasto.";
    private static final String ASK_SPENT = "💸 Introduzca la cantidad del gasto.";
    private static final String ASK_DESCRIPTION_INCOME = "📝 Introduzca una breve descripción del ingreso.";
    private static final String ASK_INCOME = "💵 Introduzca la cantidad del ingreso.";
    private static final String SHOW_EXPENSES = "📜 A continuación se mostrará la lista de gastos.";
    private static final String SHOW_INCOME = "📜 A continuación se mostrará la lista de ingresos.";
    private static final String SHOW_BALANCE = "💰 El saldo de su cuenta es: ";
    private static final String COIN = "€";

    private static final String DNI_FAULT = "❌ Formato de DNI inválido. Inténtalo de nuevo.";
    private static final String DATE_FAULT = "❌ Formato de fecha inválido. Inténtalo de nuevo.";
    private static final String TRYCATCH_FAULT = "⚠️ Error: Debe introducir un número, inténtelo de nuevo.";
    private static final String NEGATIVE_FAULT = "⚠️ Error: Debe introducir un número positivo, inténtelo de nuevo.";
    private static final String DEFAULT = "⚠️ Error: Introduzca una opción correcta.";

    public static void main(String[] args) {
        Usuario usu1 = new Usuario(collectName(), collectDate(), collectDNI());
        print("\n" + AUTHORIZED_ACCESS + usu1.calcularEdad() + "\n");

        Cuenta cuen1 = new Cuenta(usu1);
        print(usu1.saludar() + "\n");

        check = false;
        while (!check) {
        mostrarInfoMenu();
            switch (saveOption(op)) {
                case 1:
                    cuen1.addGastos(collectDescriptionSpent(), collectSpent());
                    break;
                case 2:
                    cuen1.addIngresos(collectDescriptionIncome(), collectIncome());
                    break;
                case 3:
                    print(SHOW_EXPENSES + cuen1.getGastos());
                    break;
                case 4:
                    print(SHOW_INCOME + cuen1.getIngresos());
                    cuen1.getIngresos();
                    break;
                case 5:
                    print(SHOW_BALANCE + cuen1.getSaldo() + COIN);
                    break;
                case 6:
                    print(END_PROGRAM);
                    check = true;
                    break;
                default:
                    printError(DEFAULT);
            }
        }
    }

//    Funciones
    private static String collectName() {
        print(ASK_NAME);
        String nombre = sc.nextLine();
        return nombre;
    }

    private static String collectDate() {
        String regex = "^\\d{2}-\\d{2}-\\d{4}$"; // Regex pedido al chato
        String fecha = "";

        print(ASK_DATE);
        while (!check) {
            fecha = sc.next().trim();
            if (!fecha.matches(regex)) {
                printError(DATE_FAULT);
                continue;
            }
            if (!isValidDate(fecha)) {
                printError(DATE_FAULT);
                continue;
            }
            check = true;
        }
        return fecha;
    }

    private static boolean isValidDate(String fecha) {
//        Este Regex se lo pedí a ChatGPT, extraé el día, mes y año por separado
        Pattern pattern = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        Matcher matcher = pattern.matcher(fecha);

        if (matcher.matches()) {
            int dia = Integer.parseInt(matcher.group(1));
            int mes = Integer.parseInt(matcher.group(2));
            int anio = Integer.parseInt(matcher.group(3));
            if (mes < 1 || mes > 12) {
                return false;
            }
            switch (mes) {
                case 4: case 6: case 9: case 11:
                    if (dia > 30) {
                        return false;
                    }
                    break;
                case 2:
                    if (dia > (esBisiesto(anio) ? 29 : 28)) {
                        return false;
                    }
                    break;
                default:
                    if (dia > 31) {
                        return false;
                    }
                    break;
            }
            return true;
        }
        return false;
    }

    private static boolean esBisiesto(int anio) {
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            return true;
        }
        return false;
    }

    private static String collectDNI() {
        String regex = "^\\d{8}-?[A-Z]$"; // Regex pedido al chato
        String dni = "";

        print(ASK_DNI);
        while (!dni.matches(regex)) {
            dni = sc.next().toUpperCase().trim();
            if (!dni.matches(regex)) {
                printError(DNI_FAULT);
            }
        }
        return dni;
    }

    private static void mostrarInfoMenu () {
        print(MENU_INFORMATION);
        print(OPTION_1);
        print(OPTION_2);
        print(OPTION_3);
        print(OPTION_4);
        print(OPTION_5);
        print(OPTION_6);
    }

    private static int saveOption(int op) {
        while (!check) {
            try {
                print(CHOOSE_OPTION);
                op = sc.nextInt();
                while (op < 0) {
                    printError(NEGATIVE_FAULT);
                    op = sc.nextInt();
                }
                check = true;
            } catch (InputMismatchException e) {
                printError(TRYCATCH_FAULT);
                sc.next();
            }
        }
        check = false;
        return op;
    }

    private static String collectDescriptionSpent() {
        sc.nextLine();
        print(ASK_DESCRIPTION_SPENT);
        String descripcion = sc.nextLine();
        return descripcion;
    }

    private static int collectSpent() {
        int gasto = 0;
        while (!check) {
            try {
                print(ASK_SPENT);
                gasto = sc.nextInt();

                while (gasto < 0) {
                    printError(NEGATIVE_FAULT);
                    gasto = sc.nextInt();
                }

                check = true;

            } catch (InputMismatchException e) {
                printError(TRYCATCH_FAULT);
                sc.next();
            }
        }
        check = false;
        sc.nextLine();
        return gasto;
    }

    private static String collectDescriptionIncome() {
        sc.nextLine();
        print(ASK_DESCRIPTION_INCOME);
        String descripcion = sc.nextLine();
        return descripcion;
    }

    private static int collectIncome() {
        int ingreso = 0;
        while (!check) {
            try {
                print(ASK_INCOME);
                ingreso = sc.nextInt();

                while (ingreso < 0) {
                    printError(NEGATIVE_FAULT);
                    ingreso = sc.nextInt();
                }

                check = true;

            } catch (InputMismatchException e) {
                printError(TRYCATCH_FAULT);
                sc.next();
            }
        }
        check = false;
        sc.nextLine();
        return ingreso;
    }

    private static void print(String frase) {
        System.out.println(frase);
    }

    private static void printError(String frase) {
        System.err.println(frase);
    }
}