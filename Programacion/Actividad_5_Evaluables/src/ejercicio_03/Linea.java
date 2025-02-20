package ejercicio_03;

public class Linea {

//    Atributos
    private Punto puntoA;
    private Punto puntoB;

//    Constructor
    public Linea () {
    }

    public Linea (Punto puntoA, Punto puntoB) {
        setPuntoA(puntoA);
        setPuntoB(puntoB);
    }

//    Metodos
    protected void mueveDerecha (double distancia) {
        puntoA.setEjeX(puntoA.getEjeX() + distancia);
        puntoB.setEjeX(puntoB.getEjeX() + distancia);
    }

    protected void mueveIzquierda (double distancia) {
        puntoA.setEjeX(puntoA.getEjeX() - distancia);
        puntoB.setEjeX(puntoB.getEjeX() - distancia);
    }

    protected void mueveArriba (double distancia) {
        puntoA.setEjeY(puntoA.getEjeY() + distancia);
        puntoB.setEjeY(puntoB.getEjeY() + distancia);
    }

    protected void mueveAbajo (double distancia) {
        puntoA.setEjeY(puntoA.getEjeY() - distancia);
        puntoB.setEjeY(puntoB.getEjeY() - distancia);
    }

    protected void mostrarInfo () {
        imprimir("[(" + puntoA.getEjeX() + ", " + puntoA.getEjeY() + "), (" + puntoB.getEjeX() + ", " + puntoB.getEjeY() + ")]");
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

//    Funciones
    private static void imprimir (String frase) {
        System.out.println(frase);
    }
}
