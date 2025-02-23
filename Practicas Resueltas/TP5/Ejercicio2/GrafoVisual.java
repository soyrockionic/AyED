package TP5.Ejercicio2;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class GrafoVisual<T> {
    private Grafo<T> grafo;

    public GrafoVisual(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    // Metodo que convierte el grafo en una representacion visual utilizando GraphStream
    public void mostrarGrafo() {
        
        // Configurar el modo de visualización
        System.setProperty("org.graphstream.ui", "swing");
        // Creamos el grafo de GraphStream
        Graph graph = new SingleGraph("Grafo");

        // Agregar nodos al grafo
        for (Vertice<T> vertice : grafo.obtenerVertices()) {
            graph.addNode(vertice.obtenerDato().toString()).setAttribute("ui.label", vertice.obtenerDato().toString());
        }

        // Agregar aristas entre los nodos
        for (Vertice<T> vertice : grafo.obtenerVertices()) {
            for (Arista<T> adyacente : grafo.obtenerAristas(vertice)) {
                String idArista = vertice.obtenerDato() + "-" + adyacente.obtenerDestino();
                if (graph.getEdge(idArista) == null) {
                    graph.addEdge(idArista, vertice.obtenerDato().toString(), adyacente.obtenerDestino().toString(), true);
                }
                // Establecer el atributo del peso
                graph.getEdge(idArista).setAttribute("ui.label", adyacente.obtenerPeso()+"");
            }
        }

        // Opciones de estilo
        graph.setAttribute("ui.stylesheet", 
                                  "node { text-size: 20px; fill-color: blue; } " +
                                  "edge { fill-color: gray; size: 6px; text-size: 16px; }" +
                                  "graph { fill-color: #e0e0e0; }");
        graph.display(); // Muestra el grafo visualmente
        
    }
    
}

