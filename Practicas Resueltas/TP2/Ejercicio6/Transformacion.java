package TP2.Ejercicio6;

import TP2.Ejercicio1.BinaryTree;

public class Transformacion {
    
    private BinaryTree<Integer> arbol = new BinaryTree();

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma() {
        suma(arbol);
        return arbol;
    }

    private int suma(BinaryTree<Integer> nodo) {
        int sum = 0;
        if(nodo.isLeaf()) {
            sum = nodo.getData();
            nodo.setData(0);
            return sum;
        }
        if(nodo.hasLeftChild()) {
            sum+= suma(nodo.getLeftChild());
        }
        if(nodo.hasRightChild()) {
            sum+= suma(nodo.getRightChild());
        }
        int actual = nodo.getData();
            nodo.setData(sum);
        return actual + sum;
    }
    
}