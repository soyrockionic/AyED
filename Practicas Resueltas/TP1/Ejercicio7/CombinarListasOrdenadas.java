package TP1.Ejercicio7;

import java.util.ArrayList;

public class CombinarListasOrdenadas {

    public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Recorrer ambas listas y combinar los elementos en orden
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de lista1 si los hay
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }
        
        // Agregar los elementos restantes de lista2 si los hay
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(3);
        /*lista1.add(5);
        lista1.add(7);*/

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(4);
        lista2.add(6);
        lista2.add(8);

        CombinarListasOrdenadas c = new CombinarListasOrdenadas();
        ArrayList<Integer> listaCombinada = c.combinarOrdenado(lista1, lista2);
        System.out.println("Lista combinada y ordenada: " + listaCombinada);
    }
    
}

