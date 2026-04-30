package tp3.ejercicio1;

/*
Implementar en la clase ParcialArboles el metodo:

List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol)

que devuelva todos los subarboles que tienen un numero par de hijos y no
son hojas. Realice un recorrido en inOrden.

Ejemplo:

    7
    ├─ 75
    │   ├─ 5
    │   └─ 43
    │       ├─ 12
    │       └─ 11
    └─ 2
        └─ 8
            ├─ 3
            ├─ 30
            └─ 23

Para el arbol dado, se deberia retornar una lista con los subarboles cuyos datos
en la raiz son: 75, 43, 7 (resultado obtenido al recorrer el arbol pasado como 
parametro en inOrden).

- Debe respetar la clase y el metodo indicado.
- Puede definir todos los metodos y variables auxiliares que considere.
- Todo aquel metodo que no este definido en las practicas debe ser implementado.
- Respetar el recorrido solicitado.
*/

import java.util.ArrayList;
import java.util.List;

public class ParcialArbolesFour {
    
    public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol) {    
        List<GeneralTree<Integer>> arboles = new ArrayList<>();        
        buscarArboles(arbol,arboles);     
        return arboles;      
    }
    
    private void buscarArboles(GeneralTree<Integer> nodo, List<GeneralTree<Integer>> arboles) {
        if (nodo == null || nodo.isEmpty()) return;
        
        List<GeneralTree<Integer>> hijos = nodo.getChildren();
        
        if (!hijos.isEmpty()) buscarArboles(hijos.get(0),arboles);
        
        if (!nodo.isLeaf() && nodo.getChildren().size() % 2 == 0)
            arboles.add(nodo);
        
        for (int i = 1; i < hijos.size(); i++) {
            buscarArboles(hijos.get(i),arboles);
        }
        
    }
    
}