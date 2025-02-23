package TP2.Ejercicio1;

import TP2.Ejercicio3.ContadorArbol;
import TP2.Ejercicio4.RedBinariaLlena;
import java.util.ArrayList;
import java.util.List;

public class TestBinaryTree {
    
    // Metodo para imprimir el arbol en preorden
    public static <T> void printPreOrder(BinaryTree<T> tree) {
        if (tree != null) {
            System.out.print(tree.getData() + " ");
            if (tree.hasLeftChild()) {
                printPreOrder(tree.getLeftChild());
            }
            if (tree.hasRightChild()) {
                printPreOrder(tree.getRightChild());
            }
        }
    }
    
    // Retorna los nodos del camino mas largo
    private static List<Integer> getLongPath(BinaryTree<Integer> tree) {
        List<Integer> result = new ArrayList<>();
        getLongPathRec(tree, new ArrayList<>(), result);
        return result;
    }

    private static void getLongPathRec(BinaryTree<Integer> tree, List<Integer> actual, List<Integer> result) {
        if (tree == null) return;
        actual.add(tree.getData());
        if (tree.isLeaf()) {
            if (actual.size() > result.size()) {
                result.clear();
                result.addAll(actual);
            }
        } else {
            if (tree.hasLeftChild()) {
                getLongPathRec(tree.getLeftChild(), actual, result);
            }
            if (tree.hasRightChild()) {
                getLongPathRec(tree.getRightChild(), actual, result);
            }
        }
        actual.remove(actual.size() - 1);  // Retrocede al nivel anterior
    }
    
    public static void main(String[] args) {
        // Crear el arbol binario
        BinaryTree<Integer> arbol = new BinaryTree<>(50);

        // Agregar hijos al arbol
        BinaryTree<Integer> leftChild = new BinaryTree<>(30);
        BinaryTree<Integer> rightChild = new BinaryTree<>(75);
        arbol.addLeftChild(leftChild);
        arbol.addRightChild(rightChild);

        // Agregar hijos a los nodos hijos
        leftChild.addLeftChild(new BinaryTree<>(20));
        leftChild.addRightChild(new BinaryTree<>(40));
        rightChild.addRightChild(new BinaryTree<>(80));
        rightChild.addLeftChild(new BinaryTree<>(65));

        System.out.println("Cantidad de hojas: " + arbol.countHojas());
        
        System.out.print("Arbol: ");
        printPreOrder(arbol);
        System.out.println();
        System.out.print("Arbol espejo: ");
        printPreOrder(arbol.espejo());
        System.out.println();
        System.out.println("Arbol por niveles:");
        arbol.entreNiveles(0, arbol.altura());
        
        leftChild.removeRightChild();
        System.out.println("Arbol despues de eliminar el 40:");
        arbol.entreNiveles(0, arbol.altura());
               
        // Crear la instancia de ContadorArbol con el arbol binario
        ContadorArbol contador = new ContadorArbol(arbol);
        // Obtener y mostrar los números pares usando un recorrido InOrden
        System.out.println("Numeros pares: " + contador.numerosPares());
        
        RedBinariaLlena red = new RedBinariaLlena(arbol);
        System.out.println("Distancia del camino: " + red.retardoReenvio() + " segundos");
        
        System.out.println("Camino mas largo: " + getLongPath(arbol));
        
    }
    
}
