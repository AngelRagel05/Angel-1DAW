package ejercicio_02;

public class Temporal extends Empleado{

//    Atributos
    private int duracionContrato;

//    Constructores
    public Temporal() {
    }

    public Temporal(String nombre, int edad, int salarioBase, int duracionContrato) {
        super(nombre, edad, salarioBase);
        setDuracionContrato(duracionContrato);
    }

//    Get and Set
    public int getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(int duracionCOntrato) {
        this.duracionContrato = duracionCOntrato;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Duración del contrato: " + getDuracionContrato() + ". \n";
    }
}