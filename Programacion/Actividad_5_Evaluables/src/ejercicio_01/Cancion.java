package ejercicio_01;

public class Cancion {

    private static final String MOSTRAR_TITULO = "El titulo de la canción es: ";
    private static final String MOSTRAR_AUTOR = "El autor de la canción es: ";

//    Atributos
    public String titulo;
    public String autor;

//    Constructor
    public Cancion (String titulo, String autor) {
        setAutor(autor);
        setTitulo(titulo);
    }

    public Cancion () {
        setTitulo("");
        setAutor("");
    }

//    Metodos
//    devuelve el título de la canción
    public void dameTitulo() {
        imprimir(MOSTRAR_TITULO + getTitulo());
    }

//    devuelve el autor de la canción
    public void dameAutor() {
        imprimir(MOSTRAR_AUTOR + getAutor());
    }

//    Establece el título de la canción
    public void ponTitulo (String titulo) {
        setTitulo(titulo);
    }

//     Establece el autor de la canción
    public void ponAutor (String autor) {
        setAutor(autor);
    }

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

//    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}