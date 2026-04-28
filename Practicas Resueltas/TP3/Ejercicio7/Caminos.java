package TP3.Ejercicio7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

public class Caminos {
    private GeneralTree<Integer> arbol = new GeneralTree<>();

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> resultado = buscarCamino(arbol);
        Collections.reverse(resultado);
        return resultado;
    }

    private List<Integer> buscarCamino(GeneralTree<Integer> nodo) {
        if (nodo == null) {
            return new ArrayList<>();
        }
        
        List<Integer> caminoMasLargo = new ArrayList<>();
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            List<Integer> caminoActual = buscarCamino(hijo);
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo = new ArrayList<>(caminoActual);
            }
        }
        
        caminoMasLargo.add(nodo.getData());
        return caminoMasLargo;
    }
    
}
