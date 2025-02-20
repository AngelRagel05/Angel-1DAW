package ejercicio_03;

public class Publicacion {

//    Atributos
    private String titulo;
    private String autor;
    private int anoPublicacion;

//    Constructor
    public Publicacion() {
    }

    public Publicacion(String titulo, String autor, int anoPublicacion) {
        setAutor(titulo);
        setAutor(autor);
        setAnoPublicacion(anoPublicacion);
    }

//    Metodos
    public boolean esAntiguo() {
        boolean antiguo = false;
        if (getAnoPublicacion() > 50) {
            antiguo = true;
        }
        return antiguo;
    }

//    Get and Set
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int añoPublicacion) {
        this.anoPublicacion = añoPublicacion;
    }

//    ToString
    @Override
    public String toString() {
        return "Publicación: \n" +
                "Título: " + getTitulo() + ". \n"+
                "Autor: " + getAutor() + ". \n"+
                "Año Publicación: " + getAnoPublicacion() + ". \n";
    }
}