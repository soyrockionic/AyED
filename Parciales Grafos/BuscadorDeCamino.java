package tp5.parciales;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Grafo;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCamino {
    
    public List<String> caminoDistanciaMaxima(Grafo<String> ciudades, String ciudad1, String ciudad2, int distanciaMaxima) {
        List<String> camino = new ArrayList<>();
        if (!ciudades.isEmpty()) {
            Vertex<String> origen = ciudades.search(ciudad1);
            Vertex<String> destino = ciudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean[] visitados = new boolean[ciudades.getSize()];
                dfs(ciudades, origen, destino, distanciaMaxima, visitados, camino);
            }
        }
        return camino;
    }
    
    private boolean dfs(Grafo<String> grafo, Vertex<String> actual, Vertex<String> destino,
                                        int distanciaMaxima, boolean[] visitados, List<String> camino) {
    
        visitados[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (actual.equals(destino)) {
            return true;
        } else {
            for (Edge<String> arista : grafo.getEdges(actual)) {
                Vertex<String> siguiente = arista.getTarget();
                int distanciaRuta = arista.getWeight();
                if (!visitados[siguiente.getPosition()] && distanciaRuta <= distanciaMaxima) {
                    if (dfs(grafo, siguiente, destino, distanciaMaxima, visitados, camino))
                        return true;                   
                }
            }
        }

        camino.remove(camino.size() - 1);
        visitados[actual.getPosition()] = false;
        
        return false;
    }
    
    public static void main(String[] args) {
        
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo <> ();
        
        Vertex<String> v1 = grafo.createVertex("Rio Cuarto");
        Vertex<String> v2 = grafo.createVertex("Villa Maria");
        Vertex<String> v3 = grafo.createVertex("Villa Gral Belgrano");
        Vertex<String> v4 = grafo.createVertex("Villa Dolores");
        Vertex<String> v5 = grafo.createVertex("Cruz del Eje");
        Vertex<String> v6 = grafo.createVertex("Jesus Maria");
        Vertex<String> v7 = grafo.createVertex("Tulumba");
        Vertex<String> v8 = grafo.createVertex("Cordoba");
        
        grafo.connect(v1, v2, 70);
        grafo.connect(v1, v3, 50);
        grafo.connect(v1, v4, 90);
        grafo.connect(v2, v5, 80);
        grafo.connect(v2, v6, 60);
        grafo.connect(v3, v5, 85);
        grafo.connect(v3, v7, 90);
        grafo.connect(v4, v6, 70);
        grafo.connect(v4, v7, 70);
        grafo.connect(v5, v8, 60);
        grafo.connect(v6, v8, 90);
        grafo.connect(v7, v8, 75);
        
        BuscadorDeCamino ruta = new BuscadorDeCamino ();
        System.out.println(ruta.caminoDistanciaMaxima(grafo, v1.getData(), v8.getData(), 80));
        
    }
    
}
