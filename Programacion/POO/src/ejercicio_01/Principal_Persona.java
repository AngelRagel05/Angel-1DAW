//Confeccionar una clase que permita carga el nombre y la edad de una persona. Mostrar los
//datos cargados. Imprimir un mensaje si es mayor de edad

package ejercicio_01;

public class Principal_Persona {

    public static void main(String[] args) {
        Persona pers1 = new Persona ("Juan", 28);
        pers1.mostrarInfo();
        pers1.mayor18();
    }
}
