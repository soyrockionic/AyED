package TP3.Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAG {
    
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        preOrdenRec (a, n, resultado);
        return resultado;
    }
    
    private void preOrdenRec(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        if (nodo == null) return;

        Integer valor = nodo.getData();
        if (valor != null && valor > n && valor % 2 != 0) {
            resultado.add(valor);
        }

        // Recursion sobre cada hijo
       for (GeneralTree<Integer> hijo : nodo.getChildren()) {
           preOrdenRec(hijo, n, resultado);
       }
    }
       
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        postOrdenRec (a, n, resultado);
        return resultado;
    }
    
    private void postOrdenRec(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        if (nodo == null) return;
        
        // Recursion sobre cada hijo
       for (GeneralTree<Integer> hijo : nodo.getChildren()) {
           preOrdenRec(hijo, n, resultado);
       }

        Integer valor = nodo.getData();
        if (valor != null && valor > n && valor % 2 != 0) {
            resultado.add(valor);
        }    
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a == null || a.isEmpty()) return resultado;

        LinkedList<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> nodoActual = cola.poll();
            Integer valor = nodoActual.getData();

            // Verificar si el dato es impar y mayor que n
            if (valor != null && valor % 2 != 0 && valor > n) {
                resultado.add(valor);
            }

            // Encolar hijos de izquierda a derecha
            for (GeneralTree<Integer> hijo : nodoActual.getChildren()) {
                cola.add(hijo);
            }
        }

        return resultado;
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();    
        inOrdenRec(a, n, resultado);
        return resultado;
    }

    private void inOrdenRec(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        if (nodo == null) return;
    
        List<GeneralTree<Integer>> hijos = nodo.getChildren();
    
        // 1 Primer hijo (recorrido inorden)
        if (!hijos.isEmpty()) {
            inOrdenRec(hijos.get(0), n, resultado);
        }
    
        // 2 Raiz (procesar nodo actual)
        Integer valor = nodo.getData();
        if (valor != null && valor > n && valor % 2 != 0) {
            resultado.add(valor);
        }
    
        // 3 Restantes hijos (recorrido inorden)
        for (int i = 1; i < hijos.size(); i++) {
            inOrdenRec(hijos.get(i), n, resultado);
        }
    }
    
}
