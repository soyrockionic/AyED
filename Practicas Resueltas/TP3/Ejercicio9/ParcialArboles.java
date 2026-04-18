package TP3.Ejercicio9;

import java.util.List;
import TP1.Ejercicio8.Queue;
import TP3.Ejercicio1.GeneralTree;

public class ParcialArboles {

     public static boolean esDeSeleccion(GeneralTree<Integer> arbol) throws IllegalAccessException {
        if (arbol == null) return true;

        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> nodoActual = cola.dequeue();
            int valorNodo = nodoActual.getData();
            List<GeneralTree<Integer>> hijos = nodoActual.getChildren();

            for (GeneralTree<Integer> hijo : hijos) {
                if (hijo.getData()< valorNodo) {
                    return false;
                }
                cola.enqueue(hijo); 
            }
        }
        return true;
    }
    
}
