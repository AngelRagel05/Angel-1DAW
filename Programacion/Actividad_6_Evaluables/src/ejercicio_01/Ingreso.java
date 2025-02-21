package ejercicio_01;

public class Ingreso extends Dinero{

//    Constructores
    public Ingreso(double ingreso, String descripcion) {
        super(ingreso, descripcion);
    }

//    ToString
    @Override
    public String toString() {
        return "\n Dinero - " +
                "Ingreso = " + getDinero() + ", " +
                "Descripción = " + getDescripcion();
    }
}