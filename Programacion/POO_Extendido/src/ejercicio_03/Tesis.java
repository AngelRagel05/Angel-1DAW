package ejercicio_03;

public class Tesis extends Publicacion{

//    Atributos
    private String universidad;
    private String tema;

//    Constructor
    public Tesis() {
    }

    public Tesis(String titulo, String autor, int anoPublicacion, String universidad, String tema) {
        super(titulo, autor, anoPublicacion);
        setUniversidad(universidad);
        setTema(tema);
    }

//    Get and Set
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}