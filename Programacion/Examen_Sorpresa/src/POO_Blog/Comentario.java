package POO_Blog;

public class Comentario {




    // Atributos

    protected  int idcomentario;
    protected String email;
    protected String nombre;
    protected String texto;

    // Constructor

    public Comentario(int idcomentario, String email, String nombre, String texto) {
        setIdcomentario(idcomentario);
        setEmail(email);
        setNombre(nombre);
        setTexto(texto);
    }

    public Comentario() {
        setIdcomentario(0);
        setEmail("");
        setNombre("");
        setTexto("");
    }

    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getEmail(boolean b) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    // Metodos

    public boolean validarEmail() {

        String finemail = "^@gmail.com";
        String finemail2 = "^@hotmail.com";
        String email= "";

        if(email.matches(finemail)){
            return true;
        } else if (email.matches(finemail2)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        System.out.println("ID Comentario: " +  getIdcomentario());
        System.out.println("Email: " +  getEmail(validarEmail()));
        System.out.println("Nombre: " +  getNombre());
        System.out.println("Texto: " + getTexto());
        return super.toString();
    }


}