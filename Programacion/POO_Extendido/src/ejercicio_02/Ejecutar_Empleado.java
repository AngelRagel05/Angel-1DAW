package ejercicio_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutar_Empleado {
    private static Scanner sc = new Scanner(System.in);
    private static boolean check = false;

    private static final String TAMANO_ARRAY = "¿Cuantos empleados quiere introducir en la lista? Recuerda que ya hay seis empleados dentro.";

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número entero positivo.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número entero positivo.";

    private static final String SUMA_SUELDO = "💰 La suma de todos los sueldos es: ";
    private static final String MEJOR_SUELDO = "🏆 El empleado con el mejor sueldo es: ";

    protected static void ejecutar() {
        int tam = tamanoArray();
        Empleado emp[] = new Empleado[6 + tam];

        Empleado fijo1 = new Fijo("Juan Pérez", 35, 3000, 10);
        Empleado fijo2 = new Fijo("María Gómez", 40, 3500, 15);

        Empleado temporal1 = new Temporal("Carlos Ruiz", 28, 2000, 6);
        Empleado temporal2 = new Temporal("Ana López", 30, 2200, 12);

        Empleado becario1 = new Becario("Luis Fernández", 22, 1000, "Universidad Nacional");
        Empleado becario2 = new Becario("Elena Torres", 24, 1200, "Instituto Tecnológico");

        emp[0] = fijo1;
        emp[1] = fijo2;
        emp[2] = temporal1;
        emp[3] = temporal2;
        emp[4] = becario1;
        emp[5] = becario2;

        sumaSalarios(emp);
        mostrarMejorSueldo(emp);
    }

//    Funciones
    private static void mostrarMejorSueldo(Empleado emp[]) {
        Empleado mejorEmpleado = mejorSueldo(emp);
        imprimir(MEJOR_SUELDO);
        imprimirEmpleado(mejorEmpleado);
    }

    private static Empleado mejorSueldo(Empleado emp[]) {
    if (emp.length == 0) {
        return null;
    }

    Empleado mejor = emp[0];
    for (Empleado e : emp) {
        if (e != null && e.getSalarioBase() > mejor.getSalarioBase()) {
            mejor = e;
        }
    }
    return mejor;
}

    private static void sumaSalarios(Empleado emp[]) {
        int sumaSueldo = 0;
        for (Empleado e : emp) {
            sumaSueldo += e.getSalarioBase();
        }
        imprimir(SUMA_SUELDO + sumaSueldo);
    }

    private static int tamanoArray() {
        int tam = 0;
        imprimir(TAMANO_ARRAY);
        while (!check) {
            try {
                tam = sc.nextInt();
                while (tam < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    tam = sc.nextInt();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
        return tam;
    }

    private static void imprimir(String frase) {
        System.out.println(frase);
    }

    private static void imprimirEmpleado(Empleado emp) {
        System.out.println(emp);
    }

    private static void imprimirError(String frase) {
        System.err.println(frase);
    }
}