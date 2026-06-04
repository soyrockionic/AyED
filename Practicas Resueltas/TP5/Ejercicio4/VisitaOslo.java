package tp5.ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Grafo;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

    public List<String> paseoEnBici(Grafo<String> lugares, String ciudad2, int maxTiempo, List<String> lugaresRestringidos) {
        List<String> camino = new ArrayList<>();
        if(lugares != null && !lugares.isEmpty()) {
            Vertex<String> origen = lugares.search("Ayuntamiento");
            Vertex<String> destino = lugares.search(ciudad2);
            if (origen != null && destino != null) {
                Set<String> restringidos = new HashSet<>(lugaresRestringidos);
                if (!restringidos.contains(origen.getData())) {
                    boolean[] marca = new boolean[lugares.getSize()];
                    dfs(lugares, origen, destino, maxTiempo, 0, marca, camino, restringidos);
                }
            }
        }
        return camino;
    }
    
    private boolean dfs(Grafo<String> lugares, Vertex<String> actual, Vertex<String> destino, 
                               int maxTiempo, int tiempoAcumulado, boolean[] marca, 
                               List<String> camino, Set<String> restringidos) {
        
        marca[actual.getPosition()] = true;
        camino.add(actual.getData());

        if (actual.getData().equals(destino.getData())) {
            return true;
        }

        List<Edge<String>> adyacentes = lugares.getEdges(actual);
        
        for (Edge<String> arista : adyacentes) {
            Vertex<String> siguiente = arista.getTarget();
            int tiempoArista = arista.getWeight();

            if (!restringidos.contains(siguiente.getData()) && 
                !marca[siguiente.getPosition()] && 
                (tiempoAcumulado + tiempoArista) <= maxTiempo) {
                
                if (dfs(lugares, siguiente, destino, maxTiempo, tiempoAcumulado + tiempoArista,
                                                                                 marca, camino, restringidos)) {
                    return true;
                }
            }
        }

        camino.remove(camino.size() - 1);
        marca[actual.getPosition()] = false;       
        return false;
    }
    
}