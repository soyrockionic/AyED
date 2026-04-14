package TP2.Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import TP2.Ejercicio1.BinaryTree;

public class ContadorArbol {
    
    private BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public ContadorArbol (BinaryTree<Integer> controlador) {
        this.arbol = controlador;
    }
    
    public List<Integer> numerosPares() {
        List<Integer> pares = new ArrayList<>();
        PostOrden(arbol,pares);
        return pares;
    }
    
    // Recorrido InOrden (Izquierda - Raiz - Derecha)
    private void InOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo.isEmpty()) return;
        
        if (nodo.hasLeftChild()) {
            InOrden(nodo.getLeftChild(), pares);
        }
    
        Integer dato = nodo.getData();
        if (dato != null && dato % 2 == 0) {
            pares.add(dato);
        }
    
        if (nodo.hasRightChild()) {
            InOrden(nodo.getRightChild(), pares);
        }
    }
    
    // Recorrido PostOrden (Izquierda - Derecha - Raiz)
    private void PostOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
        if (nodo == null) return;
        
        if (nodo.hasLeftChild()) {
            PostOrden(nodo.getLeftChild(), pares);
        }
        
        if (nodo.hasRightChild()) {
            PostOrden(nodo.getRightChild(), pares);
        }
        
        if (nodo.getData() != null && nodo.getData() % 2 == 0) {
            pares.add(nodo.getData());
        }
    }
    
    public static void main(String[] args)  {
        
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(20);
        
        arbol.addLeftChild(leftChild);
        arbol.addRightChild(rightChild);
        
        leftChild.addLeftChild(new BinaryTree<>(2));
        leftChild.addRightChild(new BinaryTree<>(7));
        
        rightChild.addLeftChild(new BinaryTree<>(15));
        
        ContadorArbol contador = new ContadorArbol(arbol);
        
        System.out.println(contador.numerosPares());
        
    }
    
}
