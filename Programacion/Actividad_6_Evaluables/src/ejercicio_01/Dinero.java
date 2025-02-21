package ejercicio_01;

public abstract class Dinero {

//    Atributos
    private double dinero;
    private String descripcion;

//    Constructores
    public Dinero () {
    }

    public Dinero (double dinero, String descripcion) {
        setDinero(dinero);
        setDescripcion(descripcion);
    }

//    Get and Set
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}