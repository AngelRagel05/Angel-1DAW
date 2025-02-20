package ejercicio_03;

public class Punto {

//    Atributo
    private double ejeX;
    private double ejeY;

//    Constructor
    public Punto () {
    }

    public Punto (double x, double y) {
        setEjeX(x);
        setEjeY(y);
    }

//    Métodos
    public double getEjeX() {
        return ejeX;
    }

    public void setEjeX(double x) {
        this.ejeX = x;
    }

    public double getEjeY() {
        return ejeY;
    }

    public void setEjeY(double ejeY) {
        this.ejeY = ejeY;
    }
}
