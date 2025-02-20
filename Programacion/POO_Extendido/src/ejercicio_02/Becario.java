package ejercicio_02;

public class Becario extends Empleado{

//    Atributos
    private String universidad;

//    Constructores
    public Becario() {
    }

    public Becario(String nombre, int edad, int salarioBase, String universidad) {
        super(nombre, edad, salarioBase);
        setUniversidad(universidad);
    }

//    Metodos
    protected int calcularSalario() {
        return getSalarioBase()/2;
    }

//    Get and Set
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}