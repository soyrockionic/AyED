package TP1.Ejercicio7;

import java.util.LinkedList;

public class SumarLinkedList {

    public int sumarLinkedList(LinkedList<Integer> lista) {
        return sumarRecursivo(lista, 0);
    }

    private int sumarRecursivo(LinkedList<Integer> lista, int index) {
        if (index >= lista.size()) {
            return 0; // Caso base: cuando el índice supera el tamaño de la lista, se retorna 0
        }
        // Sumar el elemento actual al resultado de la llamada recursiva
        return lista.get(index) + sumarRecursivo(lista, index + 1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> nros = new LinkedList<>();
        nros.add(1);
        nros.add(2);
        nros.add(3);
        nros.add(5);
        nros.add(9);
        nros.add(12);

        SumarLinkedList s = new SumarLinkedList();
        System.out.println("La suma de los elementos en la lista es: " + s.sumarLinkedList(nros));
    }
    
}
