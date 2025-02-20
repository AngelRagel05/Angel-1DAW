package ejercicio_03;

public class Revista extends Publicacion{

//    Atributos
    private int numeroEdicion;

//    Constructor
    public Revista() {
    }

    public Revista(String titulo, String autor, int anoPublicacion, int numeroEdicion) {
        super(titulo, autor, anoPublicacion);
        setNumeroEdicion(numeroEdicion);
    }

//    Get and Set
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Número de edición: " + getNumeroEdicion() + ". \n";
    }
}