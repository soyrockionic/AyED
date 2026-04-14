package TP2.Ejercicio1;

import TP1.Ejercicio8.Queue;

public class BinaryTree <T> {
	
    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild; 

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    
    }
   
    public BinaryTree<T> getLeftChild() {
        if (!leftChild.hasLeftChild()) { 
        }
        return this.leftChild;
    }
    
    public BinaryTree<T> getRightChild() {
        if (!rightChild.hasRightChild()) {
        }          
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }
		
    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public  int contarHojas() {
        if (isLeaf()) {
            return 1;
        }
        int cantidad = 0;
        if (leftChild != null) {
            cantidad += leftChild.contarHojas();
        }
        if (rightChild != null) {
            cantidad += rightChild.contarHojas();
        }
        return cantidad;
    }	
    	 
    public BinaryTree<T> espejo() {
        // Crear un nuevo nodo con los mismos datos
        BinaryTree<T> mirrorTree = new BinaryTree<>(this.data);
        // Si tiene hijo izquierdo, espejarlo y asignarlo como hijo derecho del nuevo arbol
        if (this.leftChild != null) {
            mirrorTree.addRightChild(this.leftChild.espejo());
        }
        // Si tiene hijo derecho, espejarlo y asignarlo como hijo izquierdo del nuevo arbol
        if (this.rightChild != null) {
            mirrorTree.addLeftChild(this.rightChild.espejo());
        }
        return mirrorTree;
    }

    public void entreNiveles(int n, int m) throws IllegalAccessException {
        if (this.isEmpty() || n < 0 || m < n) {
            return;
        }

        Queue<BinaryTree<T>> queue = new Queue<>();
        queue.enqueue(this);
        int nivelActual = 0;
    
        while (!queue.isEmpty() && nivelActual <= m) {
            int nodosEnNivel = queue.size(); // Cantidad de nodos en este nivel
        
            for (int i = 0; i < nodosEnNivel; i++) {
                BinaryTree<T> current = queue.dequeue();
            
                // Imprimir si está en el rango
                if (nivelActual >= n && nivelActual <= m) {
                    System.out.print(current.getData() + " ");
                }
            
                // Encolar hijos para el siguiente nivel
                if (current.hasLeftChild()) queue.enqueue(current.getLeftChild());
                if (current.hasRightChild()) queue.enqueue(current.getRightChild());
            }
            nivelActual++; // Avanzar al siguiente nivel
        }
        System.out.println();
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
