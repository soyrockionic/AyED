package TP5.Ejercicio6;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.*;

public class BuscadorConDijkstra {
    private Grafo<String> bosque;

    public BuscadorConDijkstra(Grafo<String> bosque) {
        this.bosque = bosque;
    }

    public List<String> recorridoMasSeguroConDijkstra() {
        if (bosque.estaVacio()) return Collections.emptyList();
        
        // Buscar las ubicaciones de Caperucita y Abuelita
        Vertice<String> caperucita = bosque.buscar("Casa Caperucita");
        Vertice<String> abuelita = bosque.buscar("Casa Abuelita");
        if (caperucita == null || abuelita == null) return Collections.emptyList();
        
        // Inicializar las estructuras necesarias
        Map<Vertice<String>, Integer> distancias = new HashMap<>();
        Map<Vertice<String>, Vertice<String>> anteriores = new HashMap<>();
        PriorityQueue<Vertice<String>> pq = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        // Establecer las distancias iniciales a infinito
        bosque.obtenerVertices().forEach(v -> distancias.put(v, Integer.MAX_VALUE));
        distancias.put(caperucita, 0);
        pq.add(caperucita);

        // Implementar el algoritmo de Dijkstra
        while (!pq.isEmpty()) {
            Vertice<String> actual = pq.poll(); // Extraer el nodo con la menor distancia
            if (actual.equals(abuelita)) break; // Si llegamos a "Casa Abuelita", terminamos
            
            // Para cada vecino del nodo actual
            for (Arista<String> arista : bosque.obtenerAristas(actual)) {
                if (arista.obtenerPeso() >= 5) continue; // Evitar caminos con peso >= 5

                Vertice<String> vecino = arista.obtenerDestino();
                int nuevaDistancia = distancias.get(actual) + arista.obtenerPeso(); // Calcular nueva distancia
                // Si encontramos un camino mas corto hacia el vecino
                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia); // Actualizar la distancia al vecino
                    anteriores.put(vecino, actual); // Registrar el nodo anterior
                    pq.add(vecino); // Añadir el vecino a la cola de prioridad para seguir procesando
                }
            }
        }
        // Reconstruir el camino mas corto
        List<String> camino = new LinkedList<>();
        for (Vertice<String> v = abuelita; v != null; v = anteriores.get(v))
            camino.add(0, v.obtenerDato()); // Agregar al inicio de la lista para construir el camino correctamente
        // Comprobar si el camino es valido y si empieza en la casa de Caperucita
        return camino.isEmpty() || !camino.get(0).equals("Casa Caperucita") ? Collections.emptyList() : camino;
    }

}

