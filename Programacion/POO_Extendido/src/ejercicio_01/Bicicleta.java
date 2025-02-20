package ejercicio_01;

public class Bicicleta extends Vehiculo{

//    Atributos
    private String tipo;

//    Constructores
    public Bicicleta() {
    }

    public Bicicleta(String marca, String modelo, int capacidad, String tipo) {
        super(marca, modelo, capacidad);
        setTipo(tipo);
    }

//    Get and Set
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Tipo: " + getTipo() + ". \n";
    }
}