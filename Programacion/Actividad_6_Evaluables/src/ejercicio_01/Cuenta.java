package ejercicio_01;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private static final String SALDO_INSUFICIENTE = "No hay saldo suficiente para realizar este gasto.";

//    Atributos
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

//    Constructor
    public Cuenta(Usuario usuario) {
        setUsuario(usuario);
        setSaldo(0.0);
        setGastos(new ArrayList<>());
        setIngresos(new ArrayList<>());
    }

//    Get and Set
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }

    //    Metodos
    public double addIngresos(String descripcion, double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, descripcion);
        ingresos.add(ingreso);
        saldo = saldo + cantidad;
        return saldo;
    }

    public double addGastos(String descripcion, double cantidad) {
        if (cantidad > saldo) {
            imprimir(SALDO_INSUFICIENTE);
            return saldo;
        }
        Gasto gasto = new Gasto(cantidad, descripcion);
        gastos.add(gasto);
        saldo = saldo - cantidad;
        return saldo;
    }

//    ToString
    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }

    private static void imprimir(String frase) {
        System.out.println(frase);
    }
}