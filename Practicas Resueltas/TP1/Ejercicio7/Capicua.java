package TP1.Ejercicio7;

import java.util.ArrayList;

public class Capicua {
    
    public boolean esCapicua(ArrayList<Integer> lista) {
        int inicio = 0;
        int fin = lista.size() - 1;
    
        while (inicio < fin) {
            if (!lista.get(inicio).equals(lista.get(fin))) {
                return false; // Si algun par de elementos no coincide, no es capicúa
            }
            inicio++;
            fin--;
        }
    
        return true; // Si todos los pares coinciden, es capicúa
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> Enteros = new ArrayList<>();
        // Agregar elementos a la lista
        Enteros.add(1);
        Enteros.add(7);
        Enteros.add(3);
        Enteros.add(7);
        Enteros.add(1);
        Capicua c = new Capicua();
        System.out.println("Es capicua: " + c.esCapicua(Enteros));
              
    }
    
}
