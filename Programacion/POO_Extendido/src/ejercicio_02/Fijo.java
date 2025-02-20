package ejercicio_02;

public class Fijo extends Empleado{

//    Atributos
    private int antiguedad;

//    Constructores
    public Fijo() {
    }

    public Fijo(String nombre, int edad, int salarioBase, int antiguedad) {
        super(nombre, edad, salarioBase);
        setAntiguedad(antiguedad);
    }

//    Metodos
    @Override
    protected int calcularSalario(){
        return getSalarioBase() + (getAntiguedad() * 50);
    }

//    Get and Set
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}