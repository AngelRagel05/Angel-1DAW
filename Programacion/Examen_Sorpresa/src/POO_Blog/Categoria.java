package POO_Blog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categoria {
    private static Scanner sc = new Scanner(System.in);
    private int contCategoria = 0;
    private int contAutor = 0;

//    Atributos
    protected int id_categoria;
    protected String nombre;
    protected String descripcion;
    protected int id_autor;
    protected String fecha_creacion;

//    Constructor
    protected Categoria() {
    }

//    Metodos



    public void crearCategoria() {
        String categoria = "";
        Categoria array[] = new Categoria[3];
        for (int i = 0; i < 3; i++) {
            array[1] = new Categoria();
            setId_Categoria(sumarIdCategoria());
            System.out.println("Introduzca el nombre de la categoria.");
            categoria = sc.nextLine();
            while (validaNombreCategoria(categoria) == false) {
                System.out.println("Algo ha fallado, vuelve a introducir el nombre.");
                categoria = sc.nextLine();
            }
            System.out.println("Introduzca la descripción de la categoria.");
            setDescripcion(sc.nextLine());
            setId_autor(sumarIdAutor());
            System.out.println("Introduzca la fecha de creación");
            setFecha_creacion(sc.nextLine());
        }
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_Categoria(int categoria) {
        this.id_categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int sumarIdCategoria() {
        contCategoria++;
        return contCategoria;
    }

    public int sumarIdAutor() {
        contAutor++;
        return contAutor;
    }

    public static boolean validaNombreCategoria (String nombre) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        boolean validarNombre = false;

        String aux = nombre;

        int minus = 0;
        int mayus = 0;
        int digi = 0;
        while (!check) {
            if (aux.length() < 5 || aux.length() > 20) {
                System.out.println("El nombre introducido tiene que tener entre 5 o 20 carácteres, vuelve a introducirlo.");
                continue;
            }

            for (int i = 0; i <1; i++) {
                char caracter = aux.charAt(i);
                if (Character.isUpperCase(caracter) || Character.isLowerCase(caracter)) {
                    System.out.println("El primer caracter introducido tiene que ser una letra.");
                    continue;
                }
            }

            for (int i = 0; i < aux.length(); i++) {
                char caracter = aux.charAt(i);
                if (Character.isUpperCase(caracter)){
                    mayus++;
                } else if (Character.isLowerCase(caracter)) {
                    minus++;
                } else if (Character.isDigit(caracter)) {
                    digi++;
                }
                if (mayus > 0 && minus > 0 && digi > 0) {
                    System.out.println("Introduce una mayuscula, una minuscula y un digito.");
                    continue;
                }
            }

            check = true;
        }
        validarNombre = true;
        return validarNombre;
    }

    public String toString() {
        System.out.println("ID Categoria: " + getId_categoria());
        System.out.println("Descripción: " + getDescripcion());
        System.out.println("ID Autor: " + getId_autor());
        System.out.println("Fecha creación: " + getFecha_creacion());
        return super.toString();
    }
}
