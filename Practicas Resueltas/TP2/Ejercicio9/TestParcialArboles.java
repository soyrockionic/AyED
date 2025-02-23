package TP2.Ejercicio9;

import TP2.Ejercicio1.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class TestParcialArboles {
    
    public static void recorrerPorNiveles(BinaryTree<SumaDiferencia> arbol) {
        if (arbol.isEmpty()) return;
        Queue<BinaryTree<SumaDiferencia>> cola = new LinkedList<>();
        cola.add(arbol);

        while (!cola.isEmpty()) {
            int nodoNivel = cola.size();
            for (int i = 0; i < nodoNivel; i++) {
                BinaryTree<SumaDiferencia> nodo = cola.remove();
                System.out.print(nodo.getData() + " ");
                if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
            }
            System.out.println(""); // Para separar niveles (opcional)
        }
    }
    
    public static void main(String[] args) {
        
        // Creacion de un arbol binario de ejemplo
        BinaryTree<Integer> arbol = new BinaryTree<>(20);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(30));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(-5));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(10));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(50));
        arbol.getRightChild().addRightChild(new BinaryTree<>(-9));
        arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
        arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<>(6));
        
        System.out.println("Arbol Original:");
        arbol.entreNiveles(0,arbol.altura());
        System.out.println("Arbol Transformado:");
        ParcialArboles parcial = new ParcialArboles();
        //parcial.sumAndDif(arbol).entreNiveles(0, arbol.altura());  
        recorrerPorNiveles(parcial.sumAndDif(arbol));
    }
    
}

