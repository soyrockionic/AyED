package TP2.Ejercicio4;

import TP2.Ejercicio1.BinaryTree;

public class RedBinariaLlena {
    
    private BinaryTree<Integer> red = new BinaryTree();

    public RedBinariaLlena (BinaryTree<Integer> arbol) {
        this.red = arbol;
    }

    public int retardoReenvio() {
        return (!red.isEmpty()) ? retardoReenvio(red) : 0;
    }
    
    private int retardoReenvio(BinaryTree<Integer> red) {
        int retHI = 0;
        int retHD = 0;
        if(red.hasLeftChild())
            retHI = retardoReenvio(red.getLeftChild());
        if(red.hasRightChild())
            retHD = retardoReenvio(red.getRightChild());
        return (Math.max(retHI, retHD)+ red.getData());
    }
    
}
