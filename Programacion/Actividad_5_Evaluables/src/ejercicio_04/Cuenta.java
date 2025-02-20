package ejercicio_04;

import java.math.BigInteger;
import java.util.Scanner;

public class Cuenta {
    Scanner sc = new Scanner(System.in);

    private static final String PEDIR_DINERO = "Introduzca la cantidad de dinero que desea ingresar.";
    private static final String RETIRADA_NEGATIVA = "La cantidad que desea retirar es superior a su saldo actual, vuelve a introducir la cantidad. Su saldo es: ";

    private static final String CUENTA_BANCARIA = "Nº Cuenta Bancaria: ";
    private static final String DNI = "DNI: ";
    private static final String SALDO_ACTUAL = "Saldo actual: ";
    private static final String INTERES_ANUAL = "Interés anual: ";

    private static final String PUNTO = ".";

//    Atributos
    private BigInteger cuentaBancaria;
    private String dni;
    private double saldoActual;
    private double interesAnual;

//    Constructor
    public Cuenta(){
    }

    public Cuenta (String dni, double saldoActual, double interesAnual) {
        setDni(dni);
        setSaldoActual(saldoActual);
        setInteresAnual(interesAnual);
        setCuentaBancaria(null);
    }

//    Métodos
//    Actualizará el saldo de la cuenta aplicándole el interés diario (interés anual dividido entre 365 aplicado al saldo actual).
    protected void actualizarSaldo () {
        setSaldoActual(getSaldoActual() + (getSaldoActual() * getInteresAnual() / 365));
    }

//    Permitirá ingresar una cantidad en la cuenta.
    protected void ingresar () {
        imprimir(PEDIR_DINERO);
        double suma = sc.nextDouble();
        setSaldoActual(getSaldoActual() + suma);
    }

//    Permitirá sacar una cantidad de la cuenta (si hay saldo).
    protected void retirar () {
        imprimir(PEDIR_DINERO);
        double resta = sc.nextDouble();
        while (resta > getSaldoActual()) {
            imprimir(RETIRADA_NEGATIVA + getSaldoActual());
            resta = sc.nextDouble();
        }
        setSaldoActual(getSaldoActual() - resta);
    }

//    Metodo que nos permita mostrar todos los datos de la cuenta.
    protected void mostrarInfo () {
        imprimir(CUENTA_BANCARIA + getCuentaBancaria() + PUNTO);
        imprimir(DNI + getDni() + PUNTO);
        imprimir(SALDO_ACTUAL + getSaldoActual() + PUNTO);
        imprimir(INTERES_ANUAL + getInteresAnual() + PUNTO);
    }

    public BigInteger getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(BigInteger cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

//    Funciones
    private void imprimir (String frase) {
        System.out.println(frase);
    }
}
