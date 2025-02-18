package universidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {

    private Scanner sc = new Scanner(System.in);

    private static final String ENTER_STUDENT_DATA = "\n🔹 Ingrese los datos del nuevo estudiante:";
    private static final String NAME = "Nombre: ";
    private static final String LAST_NAME = "Apellidos: ";
    private static final String ID = "ID: ";
    private static final String SEMESTER_NUMBER = "Número de semestre: ";
    private static final String FINAL_NOTE = "Nota final: ";
    private static final String EXISTING_ID = "⚠️ El ID ingresado ya existe. Intente con otro.";
    private static final String STUDENT_ADDED = "✅ El estudiante ha sido añadido con éxito.";
    private static final String INVALID_ENTRY = "⚠️ Entrada inválida. Por favor, ingrese un valor válido.";
    private static final String NEGATIVE_ERROR = "⚠️ El semestre debe ser mayor que 0.";
    private static final String FINAL_NOTE_ERROR = "⚠️ La nota debe estar entre 0.0 y 10.0.";
    private static final String EMPTY_LIST_AVERAGE = "La clase está vacía, no se puede calcular el promedio.";
    private static final String EMPTY_LIST_APPROVED = "La clase está vacía, no se puede calcular cuántos alumnos han aprobado.";
    private static final String APPROVED_STUDENTS = "La cantidad de estudiantes aprobados es de: ";
    private static final String PERCENTAGE_APPROVED = "El porcentaje de aprobados es de: ";
    private static final String SEARCH_ID = "🔍 Introduce el ID del estudiante que quiere buscar:";
    private static final String STUDENT_FOUND = "✅ Estudiante encontrado:";
    private static final String STUDENT_NOT_FOUND = "⚠️ Estudiante no encontrado.";

    public static List<Estudiante> clase = new ArrayList<>();

    public void aniadirEstudiante (Estudiante estudiante) {
        imprimir(ENTER_STUDENT_DATA);
        imprimir(NAME);
        String nombre = sc.nextLine();

        imprimir(LAST_NAME);
        String apellidos = sc.nextLine();

        int id = 0;
        while (true) {
            imprimir(ID);
            try {
                id = Integer.parseInt(sc.nextLine().trim());
                if (buscarEstudiante(id) != null) {
                    imprimir(EXISTING_ID);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                imprimir(INVALID_ENTRY);
                sc.next();
            }
        }

        int numSemestre = 0;
        while (true) {
            imprimir(SEMESTER_NUMBER);
            try {
                numSemestre = Integer.parseInt(sc.nextLine().trim());
                if (numSemestre > 0) {
                    break;
                } else {
                    imprimir(NEGATIVE_ERROR);
                }
            } catch (NumberFormatException e) {
                imprimir(INVALID_ENTRY);
            }
        }

        double notaFinal = 0.0;
        while (true) {
            imprimir(FINAL_NOTE);
            try {
                notaFinal = Double.parseDouble(sc.nextLine().trim()); // Leemos la nota final
                if (notaFinal >= 0.0 && notaFinal <= 10.0) {
                    break;
                } else {
                    imprimir(FINAL_NOTE_ERROR);
                }
            } catch (NumberFormatException e) {
                imprimir(INVALID_ENTRY);
            }
        }

        Estudiante nuevoEstudiante = new Estudiante(nombre, apellidos, id, numSemestre, notaFinal);
        clase.add(nuevoEstudiante);
        imprimir(STUDENT_ADDED);
    }

    public Estudiante buscarEstudiante(int id) {
        for (Estudiante estudiante : clase) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public void buscarEstudianteTeclado(int id) {
        imprimir(SEARCH_ID);
        int idBuscado = sc.nextInt();
        sc.nextLine();

        Estudiante estudiante = buscarEstudiante(idBuscado);

        if (estudiante != null) {
            imprimir(STUDENT_FOUND);
            imprimir("Nombre: " + estudiante.getNombre());
            imprimir("Apellido: " + estudiante.getApellido());
            imprimir("ID: " + estudiante.getId());
            imprimir("Semestre: " + estudiante.getNumSemestre());
            imprimir("Nota Final: " + estudiante.getNotaFinal());
        } else {
            imprimir(STUDENT_NOT_FOUND);
        }
    }

    public boolean eliminarEstudiante (int id) {
        return clase.removeIf(estudiante -> estudiante.getId() == id);
    }

    public double calcularPromedio () {
        if (clase.isEmpty()) {
            imprimir(EMPTY_LIST_AVERAGE);
            return 0.0;
        }

        double sumaNotas = 0.0;

        for (Estudiante estudiante : clase) {
            sumaNotas = sumaNotas + estudiante.getNotaFinal();
        }

        return sumaNotas / clase.size();
    }

    public void calcularAprobados() {
        int aprobado = 0;
        double porcentajeAprobados = 0.0;

        if (clase.isEmpty()) {
            imprimir(EMPTY_LIST_APPROVED);
        }

        for (Estudiante estudiante : clase) {
            if (estudiante.getNotaFinal() >= 5) {
                aprobado++;
            }
        }

        porcentajeAprobados = ((double) aprobado / clase.size() * 100);

        imprimir(APPROVED_STUDENTS + aprobado);
        imprimir(PERCENTAGE_APPROVED + porcentajeAprobados + "%");
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }
}