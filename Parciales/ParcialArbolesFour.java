package tp3.ejercicio1;

/*
2da Fecha 29/6/2024 Tema 1

Defina una clase ParcialArboles con: una unica variable de instancia de tipo
BinaryTree<Integer>, y metodo publico con la siguiente firma:
Public BinaryTree<Integer> nuevoTree()
El metodo debe devolver un nuevo arbol construido de la siguiente forma:
- Si el arbol dado tiene hijo izquierdo, el nuevo arbol tendra hijo izquierdo cuyo valor
  sera la suma del valor del hijo izquierdo y el valor del padre del arbol dado.
- Si el arbol dado no tiene hijo izquierdo, tampoco lo tendra el nuevo.
- Los hijos derechos del nuevo arbol son iguales a los del arbol dado.
- Las hojas del arbol dado seran hojas del nuevo.

Ejemplo:

Arbol dado
1 => 2
       => 4
   => 3
        => 5
             => 7
        => 6

Nuevo arbol
1 => 3
       => 6
   => 3
        => 8
             => 12
        => 6

Tenga en cuenta que:
1 - El nuevo arbol debe tener la misma estructura.
2 - No puede agregar mas variables de instancia ni de clase a la clase ParcialAtboles.
3 - Debe respetar la clase y la firma del metod indicado.
4 - Puede definir todos los metodos y variables locales que considere necesarios.
5 - Todo metodo que no este definido en la sinopsis de clases debe ser implementado.
6 - Debe recorrer la estructura solo 1 vez para resolverlo.
*/

import tp2.ejercicio1.BinaryTree;

public class ParcialArbolesFour {
    
    private BinaryTree<Integer> arbol = new BinaryTree<>();
    
    public ParcialArbolesFour (BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> nuevoTree () {
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        nuevoArbol.setData(arbol.getData());
        crearArbol(arbol,nuevoArbol);
        return nuevoArbol;
    }
    
    private void crearArbol (BinaryTree<Integer> nodo, BinaryTree<Integer> nuevoArbol) {
        if (nodo == null || nodo.isEmpty()) return;
        
        if (nodo.hasLeftChild()) {
            int suma = nodo.getData() + nodo.getLeftChild().getData();
            nuevoArbol.addLeftChild(new BinaryTree<Integer> (suma));
            crearArbol(nodo.getLeftChild(), nuevoArbol.getLeftChild());
        }
        
        if (nodo.hasRightChild()) {
            nuevoArbol.addRightChild(new BinaryTree<Integer> (nodo.getRightChild().getData()));
            crearArbol(nodo.getRightChild(),nuevoArbol.getRightChild());
        }
        
    }
    
    public static void main(String[] args) {
        
        BinaryTree<Integer> ab = new BinaryTree<> (1);
        
        BinaryTree<Integer> ab1 = new BinaryTree<> (2);
        BinaryTree<Integer> ab2 = new BinaryTree<> (3);
        
        ab.addLeftChild(ab1);
        ab.addRightChild(ab2);
        
        BinaryTree<Integer> ab1_1 = new BinaryTree<> (4);
        
        ab1.addLeftChild(ab1_1);
        
        BinaryTree<Integer> ab2_1 = new BinaryTree<> (5);
        BinaryTree<Integer> ab2_2 = new BinaryTree<> (6);
        
        ab2.addLeftChild(ab2_1);
        ab2.addRightChild(ab2_2);
        
        BinaryTree<Integer> ab2_1_1 = new BinaryTree<> (7);
        
        ab2_1.addLeftChild(ab2_1_1);
        
        ParcialArbolesFour p = new ParcialArbolesFour(ab);
        System.out.println(p.nuevoTree().getData());
        System.out.println(p.nuevoTree().getLeftChild());
        System.out.println(p.nuevoTree().getLeftChild().getLeftChild());
        System.out.println(p.nuevoTree().getRightChild().getLeftChild());
        System.out.println(p.nuevoTree().getRightChild().getLeftChild().getLeftChild());
        
    }
    
}