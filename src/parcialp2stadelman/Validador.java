/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialp2stadelman;

import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author yerman
 */
class Validador {
    // Constructor privado para evitar que se instancie la clase
    private Validador() {}

    private static final Scanner SC = new Scanner(System.in);
    
    
    public static boolean esCadenaValida(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esRangoValido(int valor, int min, int max) {
        return valor >= min && valor <= max;
    }

    public static boolean esCapacidadValida(int capacidad) {
        return capacidad > 0;
    }

    public static boolean esCostoBaseValido(double costo) {
        
        return costo > 0;
    }

    
    public static boolean esTipoMotorValido(String motor) {
        if (motor == null) return false;
        String m = motor.toUpperCase().trim();
        return m.equals("NAFTA") || m.equals("DIESEL") || m.equals("ELECTRICO");
    }
    public static  boolean validarRango(int valor, int min, int max){
        return (valor >= min && valor <= max);
    }
    public static boolean validarRangoDouble(double valor, double min, double max) {
        return valor >= min && valor <= max;
    }
    public static boolean validarS_N()
        {
        while(true)
        {
            String texto =
                    SC.nextLine()
                      .trim()
                      .toUpperCase();

            if(texto.equals("S"))
            {
                return true;
            }

            if(texto.equals("N"))
            {
                return false;
            }

            System.out.println(
                    "Ingrese S o N.");
        }
    }
    public static boolean leerBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = SC.nextLine().trim().toLowerCase();
            if (entrada.equals("s") || entrada.equals("si")) return true;
            if (entrada.equals("n") || entrada.equals("no")) return false;
            System.out.println("⚠️ Responda S o N.");
        }
    }
    
    
    public static String leerStringNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = SC.nextLine().trim();
            if (Validador.esCadenaValida(entrada)) {
                return entrada;
            }
            System.out.println(" No puede estar vacío.");
        }
    }
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un entero valido.");
            }
        }
    }
    public static double leerDouble(String mensaje){
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(SC.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un entero valido.");
            }
        }
    }
    /*public static int leerEntero(String mensaje){
            //lle un entero, en caso de no serlo reintenta
             while (true) {             
                 System.out.print(mensaje);

                 if (SC.hasNextInt()){
                     int valor = SC.nextInt();
                     SC.nextLine();
                     return valor;
                 }
                 SC.nextLine();
                 mostrarError("Error debe ingresar un numero entero, intente de nuevo");
             }
         }*/
    
    
    private static void mostrarError(String mensaje) {
        System.out.print(mensaje );
    }
}
