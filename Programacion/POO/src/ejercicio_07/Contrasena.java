package ejercicio_07;

import java.util.Random;
import java.util.Scanner;

public class Contrasena {
//    Atributos
    private int longitud;
    private String password;

//    Constructor
    protected Contrasena () {
    setLongitud(8);
    }

    protected Contrasena (String password, int longitud) {
        setLongitud(longitud);
        setPassword(password);
    }

//    Métodos
    protected boolean esFuerte () {
        boolean fuerte = false;
        int mayus = 0;
        int minus = 0;
        int numeros = 0;
        for (int i = 0; i < getPassword().length(); i++) {
            char caracter = getPassword().charAt(i);
            if (Character.isUpperCase(caracter)){
                mayus++;
            } else if (Character.isLowerCase(caracter)) {
                minus++;
            } else if (Character.isDigit(caracter)) {
                numeros++;
            }
        }
        if (mayus > 2 && minus > 1 && numeros > 5) {
            fuerte = true;
        }
        return fuerte;
    }

    protected String generarPassword() {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        String contraseña = "";
        for (int i = 0; i < getLongitud(); i++) {
            contraseña = contraseña + caracteres.charAt(random.nextInt(caracteres.length()));
        }
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}