package TP2.Ejercicio6;

import TP2.Ejercicio1.BinaryTree;

public class TestTransformacion {
    
    public static void main(String[] args) {
        
        // Creacion de un arbol binario de ejemplo
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(20));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(7));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(16));
        arbol.getRightChild().addRightChild(new BinaryTree<>(25));
        
        arbol.entreNiveles(0, arbol.altura());
        Transformacion t = new Transformacion(arbol);
        t.suma().entreNiveles(0, arbol.altura());

    }
    
}
