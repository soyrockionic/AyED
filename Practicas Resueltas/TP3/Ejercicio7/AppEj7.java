package TP3.Ejercicio7;

import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppEj7 {
    
    private static void imprimirPorCaminos(GeneralTree<Integer> arbol){
        List<Integer> cA = new ArrayList<>();
        imprimirPorCaminos(arbol,cA);
    }

    private static void imprimirPorCaminos(GeneralTree<Integer> nodo, List<Integer> cA) {
        if (nodo == null) {
            return;
        }
        // Agregar el valor del nodo actual al camino
        cA.add(nodo.obtenerDato());
        // Si el nodo es una hoja, imprimimos el camino actual
        if (nodo.getChildren().isEmpty()) {
            System.out.println(cA.stream().map(String::valueOf).collect(Collectors.joining(" -> ")));
        } else {
            // Llamar recursivamente a cada hijo del nodo actual
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                imprimirPorCaminos(hijo, new ArrayList<>(cA));
            }
        }
    }

    public static void main(String[] args) {
        
        GeneralTree arbol = new GeneralTree(12);
        
        GeneralTree hijo1 = new GeneralTree(17);
        arbol.addChild(hijo1);       
        GeneralTree hijo2 = new GeneralTree(9);
        arbol.addChild(hijo2);
        GeneralTree hijo3 = new GeneralTree(15);
        arbol.addChild(hijo3);
        
        GeneralTree nieto1 = new GeneralTree(10);
        hijo1.addChild(nieto1);     
        GeneralTree nieto2 = new GeneralTree(6);
        hijo1.addChild(nieto2);
        
        GeneralTree nieto3 = new GeneralTree(8);
        hijo2.addChild(nieto3);
        
        GeneralTree nieto4 = new GeneralTree(14);
        hijo3.addChild(nieto4);
        GeneralTree nieto5 = new GeneralTree(18);
        hijo3.addChild(nieto5);
        
        GeneralTree bisNieto1 = new GeneralTree(1);
        nieto2.addChild(bisNieto1);
        
        GeneralTree bisNieto2 = new GeneralTree(16);
        nieto4.addChild(bisNieto2);
        GeneralTree bisNieto3 = new GeneralTree(7);
        nieto4.addChild(bisNieto3);
        
        System.out.println("Caminos desde la raiz hasta las hojas:");
        imprimirPorCaminos(arbol);
        
        Caminos camino = new Caminos(arbol);
        System.out.println("Primer camino mas largo: " + camino.caminoAHojaMasLejana());
              
    }
   
}
