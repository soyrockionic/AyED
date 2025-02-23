package TP3.Ejercicio7;

import TP3.Ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.List;

public class Caminos {
    private GeneralTree<Integer> arbol; // Suponemos que el árbol se inicializa en el constructor o en otro método.

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejana() {
        return caminoAHojaMasLejana(arbol);
    }

    private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> nodo) {
        if (nodo == null) {
            return new ArrayList<>();
        }
        List<Integer> caminoMasLargo = new ArrayList<>();
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            List<Integer> caminoActual = caminoAHojaMasLejana(hijo);
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo = caminoActual;
            }
        }
        caminoMasLargo.add(0, nodo.obtenerDato()); // Anteponer el valor del nodo actual a la ruta
        return caminoMasLargo;
    }
    
}
