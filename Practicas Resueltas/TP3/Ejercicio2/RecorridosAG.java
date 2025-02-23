package TP3.Ejercicio2;

import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecorridosAG { 
    
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        preOrden(a, n, resultado);
        return resultado;
    }

    private void preOrden(GeneralTree<Integer> a, Integer n, List<Integer> resultado) {
        // Caso base: Si el arbol esta vacio, no hace nada.
        if (a == null || a.estaVacio()) {return;}

        // Procesa el nodo actual (raiz).
        Integer dato = a.obtenerDato();
        if (dato != null && dato % 2 != 0 && dato > n) {  // Es impar y mayor que n
            resultado.add(dato);
        }

        // Recursivamente procesa los hijos en preorden.
        for (GeneralTree<Integer> hijo : a.getChildren()) {
            preOrden(hijo, n, resultado);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        postOrden(a, n, resultado);
        return resultado;
    }
    
    private void postOrden(GeneralTree<Integer> a, Integer n, List<Integer> resultado) {
        // Caso base: Si el arbol esta vacio, no hace nada.
        if (a == null || a.estaVacio()) {return;}

        // Recursivamente procesa todos los hijos en postorden.
        for (GeneralTree<Integer> hijo : a.getChildren()) {
            postOrden(hijo, n, resultado);
        }

        // Procesa el nodo actual (raiz).
        Integer dato = a.obtenerDato();
        if (dato != null && dato % 2 != 0 && dato > n) {  // Es impar y mayor que n
            resultado.add(dato);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a == null || a.estaVacio()) {return resultado;}

        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> nodoActual = cola.poll();
            Integer dato = nodoActual.obtenerDato();

            // Verificar si el dato es impar y mayor que n
            if (dato != null && dato % 2 != 0 && dato > n) {
                resultado.add(dato);
            }

            // Agregar todos los hijos del nodo actual a la cola
            cola.addAll(nodoActual.getChildren());
        }

        return resultado;
    }
    
}
