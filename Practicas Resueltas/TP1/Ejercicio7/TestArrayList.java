package TP1.Ejercicio7;

import java.util.ArrayList;

public class TestArrayList {
    
    public static void main(String[] args) {
        
        if (args.length == 0) {
            args = new String[] { "10", "P0", "30", "40", "50" }; // Argumentos simulados
        }
        
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int j=0; j<args.length; j++) {
            try {
                int numero = Integer.parseInt(args[j]);
                numeros.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("El argumento \"" + args[j] + "\" no es un número válido.");
            }
        }

        System.out.println("Contenido de la lista:");
        /*for (int i=0; i<numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }*/
        
        //System.out.println(numeros);
        
        numeros.stream().forEach(System.out::println);
        
    }
    
  
}