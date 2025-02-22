package TP2.Ejercicio3;

import TP2.Ejercicio1.BinaryTree;
import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
    
    private BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public ContadorArbol(BinaryTree<Integer> controlador){
        this.arbol = controlador;
    }
    
    public LinkedList<Integer> numerosPares(){
        List<Integer> pares = new LinkedList<>();
        postOrden(arbol, pares);
        return (LinkedList<Integer>) pares;
    }
    
    // Recorrido InOrden (Izquierda - Raiz - Derecha)
    private void inOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo == null) return;
        try {
            inOrden(nodo.getLeftChild(), pares);
        } catch (IllegalStateException e) {}
        if (nodo.getData() != null && nodo.getData() % 2 == 0) {
            pares.add(nodo.getData());
        }
        try {
            inOrden(nodo.getRightChild(), pares);
        } catch (IllegalStateException e) {}
    }
    
    // Recorrido PostOrden (Izquierda - Derecha - Raiz)
    private void postOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo == null) return;
        try {
            postOrden(nodo.getLeftChild(), pares);
        } catch (IllegalStateException e) {}
        try {
            postOrden(nodo.getRightChild(), pares);
        } catch (IllegalStateException e) {}
        if (nodo.getData() != null && nodo.getData() % 2 == 0) {
            pares.add(nodo.getData());
        }
    }
      
}
