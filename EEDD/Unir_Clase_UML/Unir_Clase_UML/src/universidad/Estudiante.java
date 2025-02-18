package universidad;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int id;
    private int numSemestre;
    private double notaFinal;

    public Estudiante(String nombre, String apellido, int id, int numSemestre, double notaFinal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.numSemestre = numSemestre;
        this.notaFinal = notaFinal;
    }

    public int getId() {
        return id;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumSemestre() {
        return numSemestre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id=" + id +
                ", numSemestre=" + numSemestre +
                ", notaFinal=" + notaFinal +
                '}';
    }
}