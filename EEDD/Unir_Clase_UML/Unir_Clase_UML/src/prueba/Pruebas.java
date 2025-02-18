package prueba;

import tienda.*;
import universidad.*;

import java.util.Scanner;

public class Pruebas {

    public static void main(String[] args) {
        ejer1();
        ejer2();
    }

    private static void ejer1() {
        Tienda shop = new Tienda("Tienda Cuántica", "Pepito Pérez", 123456);

        shop.aniadirComputador(new Computador("Acer", 50, "Intel iCore 7", "Windows", 18500000));
        shop.aniadirComputador(new Computador("Toshiba", 80, "Intel iCore 5", "Windows", 15500000));
        shop.aniadirComputador(new Computador("Apple", 100, "Intel iCore 7", "MacOS", 2500000));

        System.out.println("\n Lista de Computadores en la tienda");
        for (Computador c : shop.getInventario()) {
            System.out.println(c);
        }

        System.out.println("\n Lista de Computadores en la tienda");
        shop.eliminarComputador("Acer");
        for (Computador c : shop.getInventario()) {
            System.out.println(c);
        }

        System.out.println("\n La posición en la que se encuentra el computador de la marca Apple es:");
        System.out.println(shop.buscar("Apple"));

        if (shop.tiendaLlena() == true) {
            System.out.println("\n La tienda está llena.");
        }

        if (shop.tiendaVacia() == false) {
            System.out.println("La tienda está vacia.");
        }
        System.out.println("\n Siempre mostrará que está llena porque no borro todos los objetos");
    }

    private static void ejer2() {
        Scanner sc = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.println("\n Agregando estudiantes...");
        curso.aniadirEstudiante(new Estudiante("Juan", "Pérez", 1, 3, 9.0));
        curso.aniadirEstudiante(new Estudiante("María", "Gómez", 2, 5, 5.6));

        System.out.println("\n Buscando estudiante por ID...");
        System.out.println("Ingrese el ID del estudiante a buscar: ");
        int idBuscado = sc.nextInt();
        curso.buscarEstudianteTeclado(idBuscado);

        System.out.println("\n Calculando el promedio del curso...");
        double promedio = curso.calcularPromedio();
        System.out.println("El promedio del curso es: " + promedio);

        System.out.println("\n Calculando estudiantes aprobados...");
        curso.calcularAprobados();

        System.out.println("\n Eliminando un estudiante...");
        System.out.println("Ingrese el ID del estudiante a eliminar: ");
        int idEliminar = sc.nextInt();
        boolean eliminado = curso.eliminarEstudiante(idEliminar);

        if (eliminado) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró el estudiante con ese ID.");
        }

        System.out.println("\n Lista actual de estudiantes:");
        for (Estudiante estudiante : Curso.clase) {
            System.out.println(estudiante);
        }
    }
}