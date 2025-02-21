package ejercicio_01;

public class Gasto extends Dinero{

//    Constructores
    public Gasto(double gasto, String descripcion) {
        super(gasto, descripcion);
    }

//    ToString
    @Override
    public String toString() {
        return "\n Dinero - " +
                "Gasto = " + getDinero() + ", " +
                "Descripción = " + getDescripcion();
    }
}