package TP1.Ejercicio7;

import java.util.ArrayList;

public class InvertirArrayList {

    public void invertirArrayList(ArrayList<Integer> lista) {
        if (lista == null || lista.size() <= 1) return;
        invertirHelper(lista, 0, lista.size() - 1);
    }

    private void invertirHelper(ArrayList<Integer> lista, int izq, int der) {
        if (izq >= der) return;

        Integer temp = lista.get(izq);
        lista.set(izq, lista.get(der));
        lista.set(der, temp);

        invertirHelper(lista, izq + 1, der - 1);
    }
    
    public static void main(String[] args) {
    
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3); 
        lista.add(4);
    
        InvertirArrayList ia = new InvertirArrayList();
        ia.invertirArrayList(lista);
        
        lista.stream().forEach(System.out::println);
        
    }
    
}
