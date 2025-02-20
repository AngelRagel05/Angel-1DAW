package ejercicio_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecucion_Vehiculo {
    private static Scanner sc = new Scanner(System.in);
    private static boolean check = false;

    private static final String TAMANO_ARRAY = "¿Cuantos vehículo quiere introducir en la lista? Recuerda que ya hay tres vehículos dentro";

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número entero positivo.";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número entero positivo.";

    private static final String CANTIDAD_PERSONAS = "La cantidad de persona que se pueden llevar entre todos los vehículo es de: ";

    protected static void ejecutar(){
        int tam = tamanoArray();
        Vehiculo veh[] = new Vehiculo[3 + tam];
        Vehiculo coc = new Coche("Seat", "Ibiza", 4, 4);
        Vehiculo aut = new Autobus("Mercedes-Benz", "Citaro", 100, "Barcelona");
        Vehiculo bic = new Bicicleta("Trek", "Domane AL 2", 1, "carretera");
        veh[0] = coc;
        veh[1] = aut;
        veh[2] = bic;
        mostrarInfoVehiculo(veh);
        mostrarPersonas(veh);
    }

    private static void mostrarPersonas(Vehiculo veh[]) {
        imprimir(CANTIDAD_PERSONAS + calculaPersonas(veh));
    }

    private static int calculaPersonas(Vehiculo veh[]) {
        int personas = 0;
        for (Vehiculo v : veh) {
            if (v != null) {
                personas = v.getCapacidad() + personas;
            }
        }
        return personas;
    }

    private static void mostrarInfoVehiculo(Vehiculo veh[]) {
        for (Vehiculo v : veh) {
            if (v != null) {
                imprimir(v.toString());
            }
        }
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

    private static void imprimirError(String frase) {
        System.err.println(frase);
    }
}