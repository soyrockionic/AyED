package TP2.Ejercicio6;

import TP2.Ejercicio1.BinaryTree;

public class Transformacion {
    
    private BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public Transformacion (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> suma() {
        if (arbol != null && !arbol.isEmpty()) {
            transformar(arbol);
        }
        return arbol;
    }

    private int transformar(BinaryTree<Integer> nodo) {
        int sum = 0;
        if(nodo.isLeaf()) {
            sum = nodo.getData();
            nodo.setData(0);
            return sum;
        }
        if (nodo.hasLeftChild()) {
            sum += transformar(nodo.getLeftChild());
        }
        if (nodo.hasRightChild()) {
            sum += transformar(nodo.getRightChild());
        }   
        int actual = nodo.getData();
        nodo.setData(sum);
        return actual + sum;
    }
    
    public static void main(String[] args) throws IllegalAccessException  {
        
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        
        BinaryTree<Integer> leftChild = new BinaryTree<>(2);
        BinaryTree<Integer> rightChild = new BinaryTree<>(3);
        
        arbol.addLeftChild(leftChild);
        arbol.addRightChild(rightChild);
        
        leftChild.addLeftChild(new BinaryTree<Integer>(5));
        leftChild.addRightChild(new BinaryTree<Integer>(4));
        
        rightChild.addLeftChild(new BinaryTree<Integer>(9));
        rightChild.addRightChild(new BinaryTree<Integer>(8));
        
        Transformacion t = new Transformacion(arbol);
        arbol.entreNiveles(0, 2);
        t.suma().entreNiveles(0, 2);
        
    }
    
}
