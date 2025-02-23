package TP2.Ejercicio5;

import TP2.Ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
    
    private BinaryTree<Integer> arbol = new BinaryTree();

    public ProfundidadDeArbolBinario (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p) {
        return (!arbol.isEmpty()) ? sumaElementosProfundidad(arbol, p, 0) : 0;
    }
    
    private int sumaElementosProfundidad(BinaryTree<Integer> arbol, int p, int nivelActual) {
        if (nivelActual == p) {
            return arbol.getData();
        } else {
            int sumaHI = 0;
            int sumaHD = 0;
            if(arbol.hasLeftChild())
                sumaHI = sumaElementosProfundidad(arbol.getLeftChild(), p, nivelActual + 1);
            if(arbol.hasRightChild())
                sumaHD = sumaElementosProfundidad(arbol.getRightChild(), p, nivelActual + 1);
            return sumaHI + sumaHD;
        }
    }
    
    /* //suma los nodo apartir del nodo del arbol enviado
        private int sumaElementosProfundidad(BinaryTree<Integer> arbolBinario) {
        int retHI = 0;
        int retHD = 0;
        if(arbolBinario.hasLeftChild())
            retHI = sumaElementosProfundidad(arbolBinario.getLeftChild());
        if(arbolBinario.hasRightChild())
            retHD = sumaElementosProfundidad(arbolBinario.getRightChild());
        return retHI + retHD+ arbolBinario.getData();
    }*/
    
}
