package TP2.Ejercicio4;

import TP2.Ejercicio1.BinaryTree;

public class RedBinariaLlena {
    
    private BinaryTree<Integer> red = new BinaryTree<>();
    
    public RedBinariaLlena (BinaryTree<Integer> red) {
        this.red = red;
    }
    
    public int retardoReenvio() {
        if (this.red == null || this.red.isEmpty()) return 0;
        return calcularRetardo(red);
    }
    
    private int calcularRetardo(BinaryTree<Integer> red) {
        int retHI = 0;
        int retHD = 0;
        if(red.hasLeftChild())
            retHI = calcularRetardo(red.getLeftChild());
        if(red.hasRightChild())
            retHD = calcularRetardo(red.getRightChild());
        return (Math.max(retHI, retHD)+ red.getData());
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
        
        RedBinariaLlena red = new RedBinariaLlena(arbol);
        
        System.out.println(red.retardoReenvio());
    }
    
}
