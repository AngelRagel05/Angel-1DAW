package ejercicio_02;

public class Empleado {

//    Aributos
    private String nombre;
    private int edad;
    private int salarioBase;

//    Constructores
    public Empleado() {
    }

    public Empleado(String nombre, int edad, int salarioBase) {
        setNombre(nombre);
        setEdad(edad);
        setSalarioBase(salarioBase);
    }

//    Metodos
    protected int calcularSalario() {
        return getSalarioBase();
    }

//    Get and Set
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    ToString
    @Override
    public String toString() {
        return "Empleado: \n" +
                "Nombre: " + getNombre() + ". \n"+
                "Edad: " + getEdad() + ". \n"+
                "Salario Base: " + getSalarioBase() + ". \n";
    }
}