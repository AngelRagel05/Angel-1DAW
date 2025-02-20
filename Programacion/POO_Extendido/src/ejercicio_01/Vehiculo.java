package ejercicio_01;

public class Vehiculo {

//    Atributos
    private String marca;
    private String modelo;
    private int capacidad;

//    Constructores
    public Vehiculo() {
    }

    public Vehiculo (String marca, String modelo, int capacidad) {
        setMarca(marca);
        setModelo(modelo);
        setCapacidad(capacidad);
    }

//    Get and Set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

//    ToString
    @Override
    public String toString() {
        return "Vehiculo: \n" +
                "Marca: " + getMarca() + ". \n"+
                "Modelo: " + getModelo() + ". \n"+
                "Capacidad: " + getCapacidad() + ". \n";
    }
}