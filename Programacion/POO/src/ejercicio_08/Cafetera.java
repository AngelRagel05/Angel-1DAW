package ejercicio_08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cafetera {
    private static Scanner sc = new Scanner(System.in);
    private static boolean check = false;

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número, vuelve a introducirlo. ❌";
    private static final String ERROR_NEGATIVO = "❌ Error: Debe introducir un número positivo, vuelve a introducirlo. ❌";

    private static final String LLENAR_TAZA = "Introduzca la carga de café para su taza.";
    private static final String ANADIR_CAFE = "Introduzca la cantidad de café que quiera añadir.";

    private static final String MENOR_CANTIDAD = "La capacidad actual de café es menor a la que ha pedido para su taza, se le hará café con cantidad: ";
    private static final String MAYOR_CANTIDAD = "Aquí tiene su taza de café con la cantidad pedida: ";
    private static final String CAFE_ANADIDO = "La cantidad de café que hay en la cafetera es ";

    private static final String ERROR_CAPACIDAD = "La capacidad máxima no puede ser inferior a la capacidad actual, vuelve a introducirla.";

//    Atributos
    private double capacidadMaxima;
    private double capacidadActual;

//    Constructor
    protected Cafetera () {
       setCapacidadMaxima(1000);
       setCapacidadActual(0);
    }

    protected Cafetera (double capacidadActual) {
        setCapacidadActual(capacidadActual);
        setCapacidadMaxima(capacidadActual);
    }

    protected Cafetera (double capacidadActual, double capacidadMaxima) {
        setCapacidadActual(capacidadActual);
        setCapacidadMaxima(capacidadMaxima);
    }

//    Metodos
    protected double logicaCapacidad() {
        while (getCapacidadMaxima() < getCapacidadActual()) {
            imprimirError(ERROR_CAPACIDAD);
            setCapacidadMaxima(sc.nextDouble());
        }
        return getCapacidadMaxima();
    }

    protected void llenarCafetera () {
        setCapacidadActual(getCapacidadMaxima());
    }

    protected void servirTaza () {
        double taza = capacidadTaza();
        if (getCapacidadActual() < taza) {
            imprimir(MENOR_CANTIDAD);
            imprimirDouble(getCapacidadActual());
            setCapacidadActual(0);
        } else {
            imprimir(MAYOR_CANTIDAD);
            setCapacidadActual(getCapacidadActual() - taza);
            imprimirDouble(taza);
        }
    }

    protected void vaciarCafetera () {
        setCapacidadActual(0);
    }

    protected void agregarCafe () {
        double masCafe = anadirCafe();
        setCapacidadActual(getCapacidadActual() + masCafe);
        imprimir(CAFE_ANADIDO + getCapacidadActual());
    }

    protected double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    protected void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    protected double getCapacidadActual() {
        return capacidadActual;
    }

    protected void setCapacidadActual(double capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

//    Funciones
    private static double anadirCafe () {
            double masCafe = 0;
            while (!check) {
                try {
                    imprimir(ANADIR_CAFE);
                    masCafe = sc.nextDouble();
                    while (masCafe < 0) {
                        imprimirError(ERROR_NEGATIVO);
                        masCafe = sc.nextDouble();
                    }
                    check = true;
                } catch (InputMismatchException e) {
                    imprimirError(ERROR_TRYCATCH);
                    sc.next();
                }
            }
            check = false;
            return masCafe;
        }

    private static double capacidadTaza () {
        double taza = 0;
        while (!check) {
            try {
                imprimir(LLENAR_TAZA);
                taza = sc.nextDouble();
                while (taza < 0) {
                    imprimirError(ERROR_NEGATIVO);
                    taza = sc.nextDouble();
                }
                check = true;
            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
            }
        }
        check = false;
        return taza;
    }

    private static double capacidadCafetera (double capacidadActual, double capacidadMaxima){
        if (capacidadActual > capacidadMaxima) {
            capacidadActual = capacidadMaxima;
        }
        return capacidadActual;
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }

    private static void imprimirError (String frase) {
        System.err.println(frase);
    }

    private static void imprimirDouble(double decimal) {
        System.out.println(decimal);
    }
}