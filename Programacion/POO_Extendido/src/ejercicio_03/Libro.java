package ejercicio_03;

public class Libro extends Publicacion{

//    Atributo
    int numPaginas;

//    Constructor
    public Libro() {
    }

    public Libro(String titulo, String autor, int anoPublicacion, int numPaginas) {
        super(titulo, autor, anoPublicacion);
        setNumPaginas(numPaginas);
    }

//    Get and Set
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "Número de páginas: " + getNumPaginas() + ". \n";
    }
}