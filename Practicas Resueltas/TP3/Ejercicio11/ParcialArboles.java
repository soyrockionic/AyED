package TP3.Ejercicio11;

import TP3.Ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.Queue;

public class ParcialArboles {
    
    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.estaVacio()) return true;

        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol);

        int nivelActual = 0;
        while (!cola.isEmpty()) {
            int nodosEnNivel = cola.size(); // Numero de nodos en el nivel actual
            if (nodosEnNivel != nivelActual + 1)
                return false; // Verifica si el numero de nodos en el nivel es correcto
            for (int i = 0; i < nodosEnNivel; i++) {
               GeneralTree<Integer> nodoActual = cola.poll();
               cola.addAll(nodoActual.getChildren());
            }
            nivelActual++;
        }
        return true; // Si se recorrieron todos los niveles y cumplieron la condicion, es creciente
    }
    
    public static void main(String[] args) {
        
        GeneralTree<Integer> arbol = new GeneralTree<>(2);
        
        GeneralTree<Integer> hijo1 = new GeneralTree<>(1); 
        arbol.addChild(hijo1);
        GeneralTree<Integer> hijo2 = new GeneralTree<>(25);
        arbol.addChild(hijo2);
        
        GeneralTree<Integer> nieto1 = new GeneralTree<>(5);
        hijo1.addChild(nieto1);
        GeneralTree<Integer> nieto2 = new GeneralTree<>(4);
        hijo1.addChild(nieto2);
        GeneralTree<Integer> nieto3 = new GeneralTree<>(14);
        hijo2.addChild(nieto3);
        
        GeneralTree<Integer> bisNieto1 = new GeneralTree<>(18);
        nieto1.addChild(bisNieto1);
        GeneralTree<Integer> bisNieto2 = new GeneralTree<>(7);
        nieto2.addChild(bisNieto2);
        GeneralTree<Integer> bisNieto3 = new GeneralTree<>(11);
        nieto2.addChild(bisNieto3);
        GeneralTree<Integer> bisNieto4 = new GeneralTree<>(3);
        nieto2.addChild(bisNieto4);
        
        GeneralTree<Integer> tataraNieto1 = new GeneralTree<>(83);
        bisNieto1.addChild(tataraNieto1);
        GeneralTree<Integer> tataraNieto2 = new GeneralTree<>(33);
        bisNieto4.addChild(tataraNieto2);
        GeneralTree<Integer> tataraNieto3 = new GeneralTree<>(12);
        bisNieto4.addChild(tataraNieto3);
        GeneralTree<Integer> tataraNieto4 = new GeneralTree<>(17);
        bisNieto4.addChild(tataraNieto4);
        GeneralTree<Integer> tataraNieto5 = new GeneralTree<>(9);
        bisNieto4.addChild(tataraNieto5);
        
        System.out.println("Arbol:");
        imprimirPorNiveles(arbol);
        System.out.println("Es creciente: " + resolver(arbol));     
        
    }
    
    public static void imprimirPorNiveles(GeneralTree<?> a) {
        if (a == null || a.estaVacio()) {return;}

        Queue<GeneralTree<?>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size(); // Numero de nodos en el nivel actual
            while (nivelSize > 0) {
                GeneralTree<?> nodoActual = cola.poll();
                System.out.print(nodoActual.obtenerDato()+ " ");
                // Agregar todos los hijos del nodo actual a la cola
                cola.addAll(nodoActual.getChildren());
                nivelSize--;
            }
            System.out.println(); // Salto de linea despues de cada nivel
        }
    }
    
}
