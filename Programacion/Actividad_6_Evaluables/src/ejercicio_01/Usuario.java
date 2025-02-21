package ejercicio_01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuario implements Persona{

    private static final String DNI_VACIO = "DNI inválido: está vacío o nulo. Intente nuevamente:";
    private static final String DNI_FORMATO_INCORRECTO = "DNI inválido: formato incorrecto. Intente nuevamente:";

//    Atributos
    private String nombre;
    private String fecha_nac;
    private String dni;

//    Constructores
    public Usuario (String nombre, String fecha_nac, String dni) {
        setNombre(nombre);
        setFecha_nac(fecha_nac);
        setDni(dni);
    }

//    Set and Get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        String regex = "^\\d{8}-?[A-Z]$";
        if (Pattern.matches(regex, dni)) {
            this.dni = dni;
            return true;
        }
        return false;
    }

//    Metodos
    public int calcularEdad() {
//        Por lo visto esta clase me permite parsear el String a Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        Cojo la fecha actual y calculo el periodo entre el introducido por el usuario y el actual
        LocalDate edad = LocalDate.parse(fecha_nac, formatter);
//        Y lo muestro en años.
        return Period.between(edad, LocalDate.now()).getYears();
    }

    public String saludar() {
        String saludo = "Bienvenido al programa de gestión de gastos personales ";
        return saludo + nombre + ".";
    }

    @Override
    public String toString() {
        return "Usuario" +
                "Nombre='" + nombre + '\'' +
                ", Fecha nacimiento='" + fecha_nac + '\'' +
                ", DNI='" + dni + '\'' +
                ", Edad='" + calcularEdad() + " años'" +
                " }";
    }

    private void imprimir(String frase) {
        System.out.println(frase);
    }

    private void imprimirError(String frase) {
        System.err.println(frase);
    }
}