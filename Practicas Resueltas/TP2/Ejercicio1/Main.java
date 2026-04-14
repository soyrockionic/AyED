package tp2.ejercicio1;

public class Main {
    
    public static <T> void printPreOrder(BinaryTree<T> tree) {
        if (!tree.isEmpty()) {
            System.out.println(tree);
            if (tree.hasLeftChild()) {
                printPreOrder(tree.getLeftChild());
            }
            if (tree.hasRightChild()) {
                printPreOrder(tree.getRightChild());
            }
        }
            
    }
    
    public static void main(String[] args) throws IllegalAccessException {
        
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        
        BinaryTree<Integer> leftChild = new BinaryTree<>(5);
        BinaryTree<Integer> rightChild = new BinaryTree<>(20);
        
        arbol.addLeftChild(leftChild);
        arbol.addRightChild(rightChild);
        
        leftChild.addLeftChild(new BinaryTree<>(2));
        leftChild.addRightChild(new BinaryTree<>(7));
        
        rightChild.addLeftChild(new BinaryTree<>(15));
        
        System.out.println(arbol.contarHojas());
        
        printPreOrder(leftChild);
        
        printPreOrder(rightChild.espejo());
        
        arbol.entreNiveles(0,2);
        
    }
    
}
