package TP2.Ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    
    public BinaryTree(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public BinaryTree(){     
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    // Metodos para obtener los hijos
    public BinaryTree<T> getLeftChild() {
        if (leftChild == null) {
            throw new IllegalStateException("No existe el hijo izquierdo.");
        }
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        if (rightChild == null) {
            throw new IllegalStateException("No existe el hijo derecho.");
        }
        return rightChild;
    }
    
    // Metodos para agregar los hijos
    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }
    
    // Metodos para eliminar los hijos
    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }
    
    // Metodo para verificar si el arbol esta vacio
    public boolean isEmpty() {
        return data == null && leftChild == null && rightChild == null;
    }

    // Metodo para verificar si es una hoja (no tiene hijos)
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
    
    // Metodos para verificar si tiene un hijo izquierdo o derecho
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }
    
    public int countHojas() {
        if (isLeaf()) {
            return 1;
        }
        int leftLeaves = (leftChild != null) ? leftChild.countHojas() : 0;
        int rightLeaves = (rightChild != null) ? rightChild.countHojas() : 0;   
        return leftLeaves + rightLeaves;
    }
    
    public BinaryTree<T> espejo() {
        // Crear un nuevo nodo con los mismos datos
        BinaryTree<T> mirrorTree = new BinaryTree<>(this.data);
        // Si tiene hijo izquierdo, espejarlo y asignarlo como hijo derecho del nuevo árbol
        if (this.leftChild != null) {
            mirrorTree.addRightChild(this.leftChild.espejo());
        }
        // Si tiene hijo derecho, espejarlo y asignarlo como hijo izquierdo del nuevo árbol
        if (this.rightChild != null) {
            mirrorTree.addLeftChild(this.rightChild.espejo());
        }
        return mirrorTree;
    }

    // Implementacion del metodo entreNiveles
    public void entreNiveles(int n, int m) {
        if (this.isEmpty() || n < 0 || m < n) return; 
        Queue<BinaryTree<T>> cola = new LinkedList();
        cola.add(this);
        int nivelActual = 0;
        
        while(!cola.isEmpty()) {
            int nodoNivel = cola.size();
            if(nivelActual >=n && nivelActual <= m) {
                for(int i=0; i < nodoNivel; i++) {
                    BinaryTree<T> nodo = cola.remove();
                    System.out.print(nodo.getData() + " ");
                    if(nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
            } else {
                for(int i=0; i < nodoNivel; i++) {
                    cola.remove();
                }
            }
            nivelActual++;
            System.out.println("");
        }
    }

    // Metodo para calcular la altura del arbol
    public int altura() {
        if (this.isLeaf()) {
            return 0;
        }
        int leftHeight = (leftChild != null) ? leftChild.altura() : 0;
        int rightHeight = (rightChild != null) ? rightChild.altura() : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
}
