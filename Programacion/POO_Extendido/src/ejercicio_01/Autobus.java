package ejercicio_01;

public class Autobus extends Vehiculo{

//    Atributos
    private String ruta;

//    Constructores
    public Autobus() {
    }

    public Autobus (String marca, String modelo, int capacidad, String ruta) {
        super(marca, modelo, capacidad);
        setRuta(ruta);
    }

//    Get and Set
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Ruta: " + getRuta() + ". \n";
    }
}