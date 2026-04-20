package TP3.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import TP3.Ejercicio1.GeneralTree;

public class Caminos {
    private GeneralTree<Integer> arbol = new GeneralTree<>();

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejana() {
        return buscarCamino(arbol);
    }

    private List<Integer> buscarCamino(GeneralTree<Integer> nodo) {
        if (nodo == null) {
            return new ArrayList<>();
        }
        List<Integer> caminoMasLargo = new ArrayList<>();
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            List<Integer> caminoActual = buscarCamino(hijo);
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo = caminoActual;
            }
        }
        // Anteponer el valor del nodo actual a la ruta
        caminoMasLargo.add(0, nodo.getData());
        return caminoMasLargo;
    }
    
}
