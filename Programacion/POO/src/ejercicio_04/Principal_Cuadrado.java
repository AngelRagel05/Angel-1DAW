package ejercicio_04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal_Cuadrado {

    private static final String ERROR_TRYCATCH = "❌ Error: Debe introducir un número. ❌";
    private static final String EROR_NEGATIVO = "❌ Error: Debe introducir un número positivo. ❌";

    private static final String PRESENTAR_PROGRAMA = "¡¡¡Bienvenido al programa que introduciendo un lado de un cuadrado, se le devolverá su perímetro y su superficie!!!";
    private static final String FINALIZAR_PROGRAMA = "Has finalizado el programa, espero le haya servido, vuelva pronto.";

    private static final String RECOGER_LADO = "Introduzca el valor de lado del cuadrado o introduzca el 0 para finalizar el programa.";

    public static void main(String[] args) {
        cuadrado();
    }

    public static void cuadrado () {
        Cuadrado cua = new Cuadrado();
        Scanner sc = new Scanner(System.in);

        boolean check = false;

        imprimir(PRESENTAR_PROGRAMA);

        while (!check) {
            try {
                imprimir(RECOGER_LADO);
                cua.setLado(sc.nextDouble());

                while (cua.getLado() < 0) {
                    imprimirError(EROR_NEGATIVO);
                    cua.setLado(sc.nextDouble());
                }

                if (cua.getLado() != 0) {
                    cua.perimetro();
                    cua.superficie();
                } else {
                    imprimir(FINALIZAR_PROGRAMA);
                    check = true;
                }

            } catch (InputMismatchException e) {
                imprimirError(ERROR_TRYCATCH);
                sc.next();
            }
        }
    }

    //    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }

    public static void imprimirError (String frase) {
        System.err.println(frase);
    }
}
