package TP3.Ejercicio9;

import TP3.Ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParcialArboles {

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol == null) return true;

        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> nodoActual = cola.poll();
            int valorNodo = nodoActual.obtenerDato();
            List<GeneralTree<Integer>> hijos = nodoActual.getChildren();

            for (GeneralTree<Integer> hijo : hijos) {
                if (hijo.obtenerDato() < valorNodo) {
                    return false;
                }
                cola.add(hijo); 
            }
        }
        return true;
    }

    
    public static void main(String[] args) {
    
        GeneralTree<Integer> arbol = new GeneralTree<>(12);
    
        GeneralTree<Integer> hijo1 = new GeneralTree<>(12);
        arbol.addChild(hijo1);
        GeneralTree<Integer> hijo2 = new GeneralTree<>(25);
        arbol.addChild(hijo2);
    
        GeneralTree<Integer> nieto1 = new GeneralTree<>(35);
        hijo1.addChild(nieto1);
        GeneralTree<Integer> nieto2 = new GeneralTree<>(12);
        hijo1.addChild(nieto2);
     
        GeneralTree<Integer> nieto3 = new GeneralTree<>(25);
        hijo2.addChild(nieto3);
    
        GeneralTree<Integer> bisNieto1 = new GeneralTree<>(35);
        nieto1.addChild(bisNieto1);
    
        GeneralTree<Integer> bisNieto2 = new GeneralTree<>(14);
        nieto2.addChild(bisNieto2);
    
        GeneralTree<Integer> bisNieto3 = new GeneralTree<>(12);
        nieto2.addChild(bisNieto3);
    
        GeneralTree<Integer> bisNieto4 = new GeneralTree<>(33);
        nieto2.addChild(bisNieto4);
    
        GeneralTree<Integer> tataraNieto1 = new GeneralTree<>(35);
        bisNieto1.addChild(tataraNieto1);
    
        GeneralTree<Integer> tataraNieto2 = new GeneralTree<>(35);
        bisNieto4.addChild(tataraNieto2);
        
        GeneralTree<Integer> tataraNieto3 = new GeneralTree<>(83);
        bisNieto4.addChild(tataraNieto3);
    
        GeneralTree<Integer> tataraNieto4 = new GeneralTree<>(90);
        bisNieto4.addChild(tataraNieto4);
    
        GeneralTree<Integer> tataraNieto5 = new GeneralTree<>(33);
        bisNieto4.addChild(tataraNieto5);
    
        System.out.println("Es de seleccion: " + esDeSeleccion(arbol));
        
        ArbolDibujoConsola dibujo = new ArbolDibujoConsola<>(arbol);
        dibujo.dibujarArbol();
     
   }
    
}
