package POO_Blog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Blog {

        private Scanner sc = new Scanner(System.in);
        private int opcion;

        private static final String NUM_NEGA = "Valores negativos detectados.";
        private static final String NUM_INVA = "Valores inválidos detectados.";


        public static void main(String[] args) {


        }



        // Métodos de ejecución
        private void ejecutarMenu() {
            do {
                debug();
                menu();
            } while (opcion != 5);
        }

        // Menu
        private void menu() {
            switch (opcion) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }

        // Depuración de opción
        private void debug() {
            do {
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    imprimir(NUM_INVA);
                    clean();
                }
            } while (!filter());
        }

        private boolean filter() {
            boolean verify = (opcion > 0 && opcion < 6) ? true : detecNega();
            return verify;
        }

        private boolean detecNega() {
            imprimir(NUM_NEGA);
            return false;
        }


        private void createCategoria() {

        }


        private void validarNombreCategoria() {

        }




        // Métodos generales
        private void imprimir(String mensaje) {
            System.out.println(mensaje);
        }

        private void clean() {
            sc.nextLine();
        }


    }