package ejercicio_02;

public class Triangulo {

    private static final String PUNTO_FINAL = ".";
    private static final String LADO_MAYOR = "El lado mayor es: ";
    private static final String SI_EQUILATERO = "El triangulo introducido SI es equilatero.";
    private static final String NO_EQUILATERO = "El triangulo introducido NO es equilatero.";

    //	Atributos
    public double lado1;
    public double lado2;
    public double lado3;

    // Constructores
    public Triangulo () {
    }

    public Triangulo (double lado1, double lado2, double lado3) {
        setLado1(lado1);
        setLado2(lado2);
        setLado3(lado3);
    }

    // Métodos
    public void equilatero () {
        if (lado1 == lado2 && lado1 == lado3) {
            imprimir(SI_EQUILATERO);

        } else {
            imprimir(NO_EQUILATERO);

        }
    }

    public void mostrarLadoMayor () {
        if (lado1 > lado2) {
            if (lado1 >= lado3) {
                imprimir(LADO_MAYOR + lado1 + PUNTO_FINAL);

            } else {
                imprimir(LADO_MAYOR + lado3 + PUNTO_FINAL);
            }

        } else {
            if (lado2 >= lado3) {
                imprimir(LADO_MAYOR + lado2 + PUNTO_FINAL);

            } else {
                imprimir(LADO_MAYOR + lado3 + PUNTO_FINAL);
            }
        }
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }
}



