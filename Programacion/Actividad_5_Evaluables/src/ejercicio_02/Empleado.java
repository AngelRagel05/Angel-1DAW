package ejercicio_02;

public class Empleado {

    private static final String MOSTRAR_INFO = "A continuación se le mostrará la información del trabajador:";

    private static final String NIF = "NIF (DNI): ";
    private static final String SUELDO_BASE = "Sueldo base: ";
    private static final String PAGO_HORA_EXTRA = "Pago por hora extra: ";
    private static final String EXTRAS_TRABAJADAS = "Horas extra trabajadas: ";
    private static final String IRPF = "IRPF base: ";
    private static final String CASADO = "Está casado.";
    private static final String SOLTERO = "Está solter@ (Es feliz).";
    private static final String HIJOS = "Número de hijos: ";

    private static final String HORAS_EXTRAS = "Horas extras: ";
    private static final String SUELDO_BRUTO = "Sueldo bruto: ";
    private static final String RETENCION_IRPF = "Retención IRPF: ";
    private static final String SUELDO_NETO = "Sueldo neto: ";

    private static final String PUNTO_FINAL = ".";

//    Atributos
    public String nif;
    public double sueldo;
    public double horasExtras;
    public double pagoExtra;
    public double irpf;
    public boolean casado;
    public int numHijos ;

//    Constructor
    public Empleado () {
    }

    public Empleado (String nif, double sueldo, double horaExtra, double pagoExtra, double irpf, boolean casado, int numHijos) {
        setNif(nif);
        setSueldo(sueldo);
        setHorasExtras(horaExtra);
        setPagoExtra(pagoExtra);
        setIrpf(irpf);
        setCasado(casado);
        setNumHijos(numHijos);
    }

    public Empleado (double sueldo, double horaExtra, double pagoExtra, double irpf, boolean casado, int numHijos) {
        setSueldo(sueldo);
        setHorasExtras(horaExtra);
        setPagoExtra(pagoExtra);
        setIrpf(irpf);
        setCasado(casado);
        setNumHijos(numHijos);
    }

//    Métodos
//    Cálculo y devolución del complemento correspondiente a las horas extra realizadas
    public double dineroExtra () {
        double calculoDE = getHorasExtras() * getPagoExtra();
        return calculoDE;
    }

//    Cálculo y devolución del sueldo bruto
    public double sueldoBruto () {
        double calculoSB = getSueldo() + dineroExtra();
        return calculoSB;
    }

//    Cálculo y devolución de las retenciones (IRPF) a partir del tipo, teniendo en cuenta que el porcentaje de retención que hay que aplicar es el tipo menos 2 puntos si el empleado está casado y menos 1 punto por cada hijo que tenga; el porcentaje se aplica sobre todo el sueldo bruto
    public double descuentoSueldo () {
        double calculoDesc = sueldoBruto() * (irpfAjustado() / 100);
        return calculoDesc;
    }

    public double irpfAjustado () {
        double ajustadoIRPF = 0;
        if (isCasado() == true) {
            ajustadoIRPF = (getIrpf() - 2 - (1 * getNumHijos()));
        } else {
            ajustadoIRPF = (getIrpf() - (1 * getNumHijos()));
        }
        return ajustadoIRPF;
    }

//    Visualización de la información básica del empleado
    public void infoBasica () {
        imprimir(MOSTRAR_INFO);
        imprimir(NIF + getNif() + PUNTO_FINAL);
        imprimir(SUELDO_BASE + getSueldo() + PUNTO_FINAL);
        imprimir(PAGO_HORA_EXTRA + getPagoExtra() + PUNTO_FINAL);
        imprimir(EXTRAS_TRABAJADAS + getHorasExtras() + PUNTO_FINAL);
        imprimir(IRPF + getIrpf() + PUNTO_FINAL);
        if (isCasado() == true) {
            imprimir(CASADO);
        } else {
            imprimir(SOLTERO);
        }
        imprimir(HIJOS + getNumHijos() + PUNTO_FINAL);
    }

//    visualización de toda la información del empleado. La básica más el sueldo base, el complemento por horas extra, el sueldo bruto, la retención de IRPF y el sueldo neto.
    public void infoAvanzada () {
        imprimir(MOSTRAR_INFO);
        imprimir(NIF + getNif() + PUNTO_FINAL);
        imprimir(SUELDO_BASE + getSueldo() + PUNTO_FINAL);
        imprimir(PAGO_HORA_EXTRA + getPagoExtra() + PUNTO_FINAL);
        imprimir(EXTRAS_TRABAJADAS + getHorasExtras() + PUNTO_FINAL);
        imprimir(IRPF + getIrpf() + PUNTO_FINAL);
        if (isCasado() == true) {
            imprimir(CASADO);
        } else {
            imprimir(SOLTERO);
        }
        imprimir(HIJOS + getNumHijos() + PUNTO_FINAL);
        imprimir(HORAS_EXTRAS + dineroExtra() + PUNTO_FINAL);
        imprimir(SUELDO_BRUTO + sueldoBruto() + PUNTO_FINAL);
        imprimir(RETENCION_IRPF + descuentoSueldo() + PUNTO_FINAL);
        imprimir(SUELDO_NETO + (sueldoBruto() - descuentoSueldo()) + PUNTO_FINAL);
    }

    public int irpf () {
        double sueldoAnual = sueldoBruto() * 14;
        if (sueldoAnual <= 12450) {
            return 19;
        } else if (sueldoAnual > 12450 || sueldoAnual <= 20200) {
            return 24;
        } else if (sueldoAnual > 20200 || sueldoAnual <= 35200) {
            return 30;
        } else if (sueldoAnual > 35200 || sueldoAnual <= 60000) {
            return 37;
        } else if (sueldoAnual > 60000 || sueldoAnual <= 300000) {
            return 45;
        } else {
            return 47;
        }
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getPagoExtra() {
        return pagoExtra;
    }

    public void setPagoExtra(double pagoExtra) {
        this.pagoExtra = pagoExtra;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

//    Funciones
    public static void imprimir (String frase) {
        System.out.println(frase);
    }
}