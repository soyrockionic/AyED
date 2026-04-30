package tp3.ejercicio1;

/*
Defina una clase ParcialArboles con: una unica variable de instancia de tipo
BinaryTree<Integer>, y un metodo publico con la siguiente firma:
public BinaryTree<Integer> nuevoTree()

El metodo debe devolver un nuevo arbol, contruido de  la siguiente forma:
- Si el arbol tiene hijo izquierdo, el nuevo arbol tendrahijo  izquierdo cuyo
   valor sera la suma del valor del hijo izquierdo y el valor del padre del arbol
   dado.
- Si el arbol dado no tiene hijo izquierdo, tampoco lo tendra el nuevo.
- Los hijos derechos del nuevo arbol son iguales que los del arbol dado.
- Las hojas del arbol dado seran hojas en el nuevo.

Ejemplo:
Arbol dado:
    1
    |----2
    |      |----4
    |
    |----3
           |----5
           |      |----7
           |
           |----6

Arbol nuevo:
    1
    |----3
    |      |----6
    |
    |----3
           |----8
           |      |----12
           |
           |----6
*/

import tp2.ejercicio1.BinaryTree;

public class ParcialDeArbolesAB {
    
    private BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public ParcialDeArbolesAB (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> nuevoTree () {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setData(arbol.getData());
        crearNuevoTree(arbol,tree);
        return tree;
    }
    
    private void crearNuevoTree (BinaryTree<Integer> nodo, BinaryTree<Integer> tree) {
        if(nodo == null || nodo.isEmpty()) return;
        
        if(!nodo.isLeaf()) {
            if (nodo.hasLeftChild()) {
                Integer valor = nodo.getLeftChild().getData() + nodo.getData();
                BinaryTree<Integer> aux = new BinaryTree<>(valor);
                tree.addLeftChild(aux);
                crearNuevoTree(nodo.getLeftChild(),tree.getLeftChild());
            }
            if (nodo.hasRightChild()) {
                BinaryTree<Integer> aux = new BinaryTree<>(nodo.getRightChild().getData());
                tree.addRightChild(aux);
                crearNuevoTree(nodo.getRightChild(),tree.getRightChild());
            }
        }
        
    }
    
}