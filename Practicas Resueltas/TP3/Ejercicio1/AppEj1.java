package TP3.Ejercicio1;

import TP3.Ejercicio2.RecorridosAG;
import java.util.LinkedList;
import java.util.Queue;

public class AppEj1 {
    
    public static void imprimirPorNiveles(GeneralTree<?> a) {
        if (a == null || a.estaVacio()) {return;}

        Queue<GeneralTree<?>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size(); // Numero de nodos en el nivel actual
            while (nivelSize > 0) {
                GeneralTree<?> nodoActual = cola.poll();
                System.out.print(nodoActual.obtenerDato() + " ");
                // Agregar todos los hijos del nodo actual a la cola
                cola.addAll(nodoActual.getChildren());
                nivelSize--;
            }
            System.out.println(); // Salto de linea despues de cada nivel
        }
    }
    
    public static void main (String[] args) {
        
        GeneralTree<Integer> root = new GeneralTree<>(10);
        GeneralTree<Integer> leaf1 = new GeneralTree<>(7);
        GeneralTree<Integer> leaf2 = new GeneralTree<>(30);
        root.addChild(leaf1);
        root.addChild(leaf2);
        leaf1.addChild(new GeneralTree<>(18));
        GeneralTree<Integer> leaf3 = new GeneralTree<>(40); 
        root.addChild(leaf3);
        leaf3.addChild(new GeneralTree<>(45));
        GeneralTree<Integer> leaf4 = new GeneralTree<>(53);
        leaf3.addChild(leaf4);
        leaf3.addChild(new GeneralTree<>(68));
        leaf4.addChild(new GeneralTree<>(73));
    
        System.out.println("Altura del arbol: " + root.altura());       
        RecorridosAG recorridos = new RecorridosAG();
        System.out.println("Arbol General:");
        imprimirPorNiveles(root);
        System.out.println("N° impares mayores que 9:");
        System.out.println(recorridos.numerosImparesMayoresQuePreOrden(root,9));
        System.out.println("N° impares mayores que 3:");
        System.out.println(recorridos.numerosImparesMayoresQuePorNiveles(root,3));
        leaf3.removeChild(leaf4);
        System.out.println("Arbol General despues de eliminar el n° 53:");
        System.out.println("Altura del arbol: " + root.altura()); 
        imprimirPorNiveles(root);
        
        System.out.println("Nivel del 10: " + root.nivel(10));
        System.out.println("Nivel del 45: " + root.nivel(45));
        System.out.println("Nivel del 40: " + root.nivel(40));
        
        leaf3.addChild(new GeneralTree<>(57));
        System.out.println("Amplitud del arbol: " + root.ancho());
        
        System.out.println("7 es ancestro de 45: " + root.esAncestro(7, 45));
        System.out.println("7 es ancestro de 18: " + root.esAncestro(7, 18));
        
    }
    
}
