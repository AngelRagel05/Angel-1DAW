package tienda;

import java.util.ArrayList;
import java.util.List;

public class Tienda {

    private boolean lleno = false;
    private static List<Computador> inventario = new ArrayList<>();

    private static final String COMPUTADOR_ADD = "Computador añadido al inventario.";

//    Atributos
    private String nombre;
    private String propietario;
    private int identificadorTributario;
    private static int numeroComputadores = 0;

//    Constructor
    public Tienda (String nombre, String propietario, int identificadorTributario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.identificadorTributario = identificadorTributario;
    }

//    Metodos
    public boolean tiendaLlena() {
        if (numeroComputadores > 0) {
            lleno = true;
        }
        return lleno;
    }

    public boolean tiendaVacia() {
        if (numeroComputadores == 0) {
            lleno = false;
        }
        return lleno;
    }

    public void aniadirComputador(Computador computador) {
        inventario.add(computador);
        imprimir(COMPUTADOR_ADD);
    }

    //    El removeIf recorre la Lista y va comparando la marca del computador con la marca introducida por el usuario
    public boolean eliminarComputador(String marcaComputador) {
        return inventario.removeIf(computador -> computador.getMarca().equalsIgnoreCase(marcaComputador));
    }

    public int buscar(String marcaComputador) {
        for (int i = 0; i < inventario.size();  i++) {
            if (inventario.get(i).getMarca().equalsIgnoreCase(marcaComputador)) {
                return i;
            }
        }
        return -1;
    }

    public List<Computador> getInventario() {
        return inventario;
    }

    public static void setNumeroComputadores(int numeroComputadores) {
        Tienda.numeroComputadores = inventario.size();
    }

    public void setInventario(List<Computador> inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", propietario='" + propietario + '\'' +
                ", identificadorTributario=" + identificadorTributario +
                ", numeroComputadores=" + numeroComputadores +
                '}';
    }

    private static void imprimir (String frase) {
        System.out.println(frase);
    }
}