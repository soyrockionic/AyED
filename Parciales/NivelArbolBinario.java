package tp3.ejercicio1;

/*
Implemente en la clase NivelArbolBinario una variable de instancia arbol con un
BinaryTree<Integer> y un metodo minEnArbolDeAB (int n): BinaryTree<Integer>
que devuelve el subarbol hoja con menor valor en el nivel n del arbol, De haber
mas de uno devuelve el primero encontrado. Considere que n es un nivel valido
del arbol. sin embargo, puede suceder que no existan hojas en ese nivel, en ese
caso, debe devolver null. Realice un recorrido por niveles.

Para el siguiente arbol:

2
=> 7
    => 3
    => 6
        => 5
        => 11
=> 5
    =
    => 9
        => 4

- Si el nivel es 1, debe devolver null, ya que 7 y 5 no son hojas.
- Si el nivel es 2, debe devolver 3, ya que es la unica hoja.
- Si el nivel es 2, debe devolver 4, ya que es el menor entre 5, 11 y 4.
*/

import java.util.LinkedList;
import java.util.Queue;
import tp2.ejercicio1.BinaryTree;

public class NivelArbolBinario {
     
    private BinaryTree<Integer> arbol = new BinaryTree <> ();
    
    public NivelArbolBinario (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> minEnArbolDeAB (int n) {
        if (arbol == null || arbol.isEmpty()) return null;
       
        Queue <BinaryTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol);
        
        int nivel = 0;
        
        while (!cola.isEmpty()) {
        
            int nodosEnNivel = cola.size();
            
            if (nivel == n) {
                BinaryTree<Integer> minHoja = null;
                for (int i=0; i<nodosEnNivel; i++) {
                    BinaryTree<Integer> actual = cola.poll();
                    if (actual.isLeaf()) {
                        if (minHoja == null || actual.getData() < minHoja.getData()) {
                            minHoja = actual;
                        }
                    }
                }
                return minHoja;
            }
            
            for (int i=0; i<nodosEnNivel; i++) {
                BinaryTree<Integer> nodo = cola.poll();
                if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
            }
            nivel++;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        
        BinaryTree<Integer> arbol = new BinaryTree <> (2);
        
        BinaryTree<Integer> hijo1 = new BinaryTree <> (7);
        BinaryTree<Integer> hijo2 = new BinaryTree <> (5);
        
        arbol.addLeftChild(hijo1);
        arbol.addRightChild(hijo2);
        
        BinaryTree<Integer> nieto1 = new BinaryTree <> (3);
        BinaryTree<Integer> nieto2 = new BinaryTree <> (6);
        BinaryTree<Integer> nieto3 = new BinaryTree <> (9);
        
        hijo1.addLeftChild(nieto1);
        hijo1.addRightChild(nieto2);
        
        hijo2.addRightChild(nieto3);
        
        BinaryTree<Integer> bisnieto1 = new BinaryTree <> (5);
        BinaryTree<Integer> bisnieto2 = new BinaryTree <> (11);
        BinaryTree<Integer> bisnieto3 = new BinaryTree <> (4);
        
        nieto2.addLeftChild(bisnieto1);
        nieto2.addRightChild(bisnieto2);
        
        nieto3.addLeftChild(bisnieto3);
        
        NivelArbolBinario nab = new NivelArbolBinario (arbol);
        System.out.println(nab.minEnArbolDeAB(2));
        
    }
    
}
