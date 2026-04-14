package TP2.Ejercicio5;

import TP2.Ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    
    BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public ProfundidadDeArbolBinario (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public int sumaElementosProfundidad(int p) {
        if (p < 0 || arbol.isEmpty()) {
            return 0;
        }
        return sumarEnNivel(arbol, p, 0);
    }
    
    private int sumarEnNivel(BinaryTree<Integer> arbol, int p, int nivelActual) {
        if (nivelActual == p) {
            return arbol.getData();
        }
        int sumaHI = 0;
        int sumaHD = 0;
        if(arbol.hasLeftChild())
            sumaHI = sumarEnNivel(arbol.getLeftChild(), p, nivelActual + 1);
        if(arbol.hasRightChild())
            sumaHD = sumarEnNivel(arbol.getRightChild(), p, nivelActual + 1);
        return sumaHI + sumaHD;
    }
    
    public static void main(String[] args)  {
        
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        
        BinaryTree<Integer> leftChild = new BinaryTree<>(2);
        BinaryTree<Integer> rightChild = new BinaryTree<>(3);
        
        arbol.addLeftChild(leftChild);
        arbol.addRightChild(rightChild);
        
        leftChild.addLeftChild(new BinaryTree<Integer>(5));
        leftChild.addRightChild(new BinaryTree<Integer>(4));
        
        rightChild.addLeftChild(new BinaryTree<Integer>(9));
        rightChild.addRightChild(new BinaryTree<Integer>(8));
        
        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(arbol);
        
        System.out.println(prof.sumaElementosProfundidad(0));
        System.out.println(prof.sumaElementosProfundidad(1));
        System.out.println(prof.sumaElementosProfundidad(2));
        
    }
    
}
