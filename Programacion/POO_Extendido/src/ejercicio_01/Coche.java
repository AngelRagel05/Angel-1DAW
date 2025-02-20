package ejercicio_01;

public class Coche extends Vehiculo{

//    Atributos
    private int numeroPuertas;

//    Constructores
    public Coche () {
    }

    public Coche(String marca, String modelo, int capacidad, int numeroPuertas) {
        super(marca, modelo, capacidad);
        setNumeroPuertas(numeroPuertas);
    }

//    Get and Set
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Número de puertas: " + getNumeroPuertas() + ". \n";
    }
}