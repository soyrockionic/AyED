package tp3.ejercicio1;

/*
Implemente en la clase Parcial el metodo sumaImparesPostOrdenMayorA que recibe
un arbol binario de enteros positivos y un numero entero. Este metodo suma todos
los numeros impares del arbol que son mayores al parametro recibido realizando un
recorrido postOrden.
*/

import tp2.ejercicio1.BinaryTree;

public class ParcialDeArboles {
    
    public Integer sumaImparesPostOrdenMayorA (BinaryTree<Integer> arbol, int n) {
        return calcularSumaImpares(arbol,n);
    }
    
    private Integer calcularSumaImpares (BinaryTree<Integer> nodo, int n) {
        if (nodo == null || nodo.isEmpty()) return 0;
        
        Integer izqSuma = 0;
        Integer derSuma = 0;
        
        if (nodo.hasLeftChild()) {
            izqSuma = calcularSumaImpares(nodo.getLeftChild(), n);
        }
        
        if (nodo.hasRightChild()) {
            derSuma = calcularSumaImpares(nodo.getRightChild(), n);
        }
        
        Integer suma = 0;
        if (nodo != null && nodo.getData() % 2 != 0 && nodo.getData() > n) {
            suma = suma + nodo.getData();
        }
        
        return izqSuma + derSuma + suma;
    }
    
    public static void main(String[] args) {
        
        BinaryTree<Integer> ab = new BinaryTree<>(7);
        
        BinaryTree<Integer> ab1 = new BinaryTree<>(56);
        BinaryTree<Integer> ab2 = new BinaryTree<>(25);
        
        ab.addLeftChild(ab1);
        ab.addRightChild(ab2);
        
        BinaryTree<Integer> ab1_1 = new BinaryTree<>(38);
        BinaryTree<Integer> ab1_2 = new BinaryTree<>(31);
        
        ab1.addLeftChild(ab1_1);
        ab1.addRightChild(ab1_2);
        
        BinaryTree<Integer> ab2_1 = new BinaryTree<>(5);
        BinaryTree<Integer> ab2_2 = new BinaryTree<>(6);
        
        ab2.addLeftChild(ab2_1);
        ab2.addRightChild(ab2_2);
        
        BinaryTree<Integer> ab1_1_1 = new BinaryTree<>(87);
        BinaryTree<Integer> ab1_1_2 = new BinaryTree<>(77);
        
        ab1_1.addLeftChild(ab1_1_1);
        ab1_1.addRightChild(ab1_1_2);
        
        BinaryTree<Integer> ab1_2_1 = new BinaryTree<>(94);
        
        ab1_2.addRightChild(ab1_2_1);
        
        BinaryTree<Integer> ab1_1_2_1 = new BinaryTree<>(16);
        
        ab1_1_2.addLeftChild(ab1_1_2_1);
        
        BinaryTree<Integer> ab1_2_1_2 = new BinaryTree<>(2);
        
        ab1_2_1.addLeftChild(ab1_2_1_2);
        
        BinaryTree<Integer> ab1_1_2_1_2 = new BinaryTree<>(43);
        
        ab1_1_2_1.addRightChild(ab1_1_2_1_2);
        
        BinaryTree<Integer> ab1_2_1_2_1 = new BinaryTree<>(1);
        
        ab1_2_1_2.addLeftChild(ab1_2_1_2_1);
        
        BinaryTree<Integer> ab1_1_2_1_2_1 = new BinaryTree<>(9);
        BinaryTree<Integer> ab1_1_2_1_2_2 = new BinaryTree<>(10);
        
        ab1_1_2_1_2.addLeftChild(ab1_1_2_1_2_1);
        ab1_1_2_1_2.addRightChild(ab1_1_2_1_2_2);
        
        ParcialDeArboles pa = new ParcialDeArboles();
        System.out.println(pa.sumaImparesPostOrdenMayorA(ab, 30));
        
    }
    
}
