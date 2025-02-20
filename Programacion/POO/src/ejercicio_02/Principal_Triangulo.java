//Desarrollar un programa que cargue los lados de un triángulo e implemente los siguientes
//métodos: inicializar los atributos, imprimir el valor del lado mayor y otro método que
//muestre si es equilátero o no

package ejercicio_02;

import java.util.Scanner;

public class Principal_Triangulo {

    private static final String GUARDAR_NÚMERO = "Introduzca los tres lados del triangulo.";
    private static final String GUARDAR_1º_NÚMERO = "Introduzca el 1º lado del triangulo.";
    private static final String GUARDAR_2º_NÚMERO = "Introduzca el 2º lado del triangulo.";
    private static final String GUARDAR_3º_NÚMERO = "Introduzca el 3º lado del triangulo.";

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Triangulo tri = new Triangulo ();

        imprimir(GUARDAR_NÚMERO);
        imprimir(GUARDAR_1º_NÚMERO);
        double lado1 = sc.nextDouble();
        imprimir(GUARDAR_2º_NÚMERO);
        double lado2 = sc.nextDouble();
        imprimir(GUARDAR_3º_NÚMERO);
        double lado3 = sc.nextDouble();
        sc.close();
        tri.setLado1(lado1);
        tri.setLado2(lado2);
        tri.setLado3(lado3);

        tri.equilatero();
        tri.mostrarLadoMayor();
    }

    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}
