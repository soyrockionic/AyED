package tp1.ejercicio7;

import java.util.LinkedList;

public class SumarLinkedList {

    // Metodo exacto de la consigna
    public int sumarLinkedList(LinkedList<Integer> lista) {
        if (lista == null || lista.isEmpty()) return 0;
        return sumarRecursivo(lista, 0);
    }

    // Auxiliar recursivo
    private int sumarRecursivo(LinkedList<Integer> lista, int index) {
        // Caso base: llegamos al final
        if (index == lista.size()) return 0;

        // Paso recursivo: valor actual + suma del resto
        return lista.get(index) + sumarRecursivo(lista, index + 1);
    }
    
    public static void main(String[] args) {
        
        LinkedList lista = new LinkedList<>();
        
        lista.add(10);
        lista.add(5);
        lista.add(15);
        
        SumarLinkedList sl = new SumarLinkedList();
        
        System.out.println(sl.sumarLinkedList(lista));
    }
    
}
