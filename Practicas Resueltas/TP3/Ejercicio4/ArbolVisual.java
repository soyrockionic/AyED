package TP3.Ejercicio4;

import TP3.Ejercicio1.GeneralTree;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class ArbolVisual {
    private GeneralTree arbol;

    public ArbolVisual(GeneralTree arbol) {
        this.arbol = arbol;
    }

    public void mostrarArbol() {
        System.setProperty("org.graphstream.ui", "swing");
        Graph tree = new SingleGraph("Árbol");

        // Agregar nodos (representando los nodos del arbol)
        agregarNodos(tree, arbol, null);  // Metodo recursivo para agregar nodos y aristas

        // Opciones de estilo
        tree.setAttribute("ui.stylesheet", 
                                  "node { fill-color: green; size: 36px; text-size: 20px; } " +
                                  "edge { fill-color: gray; size: 4px; }" +
                                  "graph { fill-color: #e0e0e0; }" );
        tree.display();
    }

    // Metodo recursivo para agregar nodos y aristas
    private void agregarNodos(Graph tree, GeneralTree nodo, GeneralTree padre) {
        String idNodo = nodo.obtenerDato().toString();
        tree.addNode(idNodo).setAttribute("ui.label", idNodo);
        
        if (padre != null) {
            String idPadre = padre.obtenerDato().toString();
            tree.addEdge(idPadre + "-" + idNodo, idPadre, idNodo, true);
        }

        // Recurre por los hijos
        for (Object child : nodo.getChildren()) {
            agregarNodos(tree, (GeneralTree) child, nodo);
        }
    }
}
