package ejercicio_03;

public class Plano {

    private static final String COORDENADA_0 = "La coordenada introducida es 0 0, no está en ningún cuadrante.";
    private static final String ARRIBA_DERECHA = "La coordenada introducida pertenece al cuadrante de arriba a la derecha.";
    private static final String ARRIBA_IZQUIERDA = "La coordenada introducida pertenece al cuadrante de arriba a la izquierda.";
    private static final String ABAJO_IZQUIERDA = "La coordenada introducida pertenece al cuadrante de abajo a la izquierda.";
    private static final String ABAJO_DERECHA = "La coordenada introducida pertenece al cuadrante de abajo a la derecha.";
    private static final String EJES = "La coordenada que ha introducido correspode a los ejes de X o Y.";

    //	Atributos
    public double x = 0.0;
    public double y = 0.0;

    //	Constructor
    public Plano () {
    }

    //	Metodos
    public void cuadrante () {
        if (x == 0 && y == 0) {
            imprimirString(COORDENADA_0);
        } else if (x < 0 && y > 0) {
            imprimirString(ARRIBA_IZQUIERDA);
        } else if (x > 0 && y > 0) {
            imprimirString(ARRIBA_DERECHA);
        } else if (x < 0 && y < 0) {
            imprimirString(ABAJO_IZQUIERDA);
        } else if (x > 0 && y < 0) {
            imprimirString(ABAJO_DERECHA);
        } else {
            imprimirString(EJES);
        }
    }

    public void mostrarEjes () {
        imprimirDouble(x);
        imprimirDouble(y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    //	Funciones
    public static void imprimirString (String frase) {
        System.out.println(frase);
    }

    public static void imprimirDouble (double frase) {
        System.out.println(frase);
    }
}
