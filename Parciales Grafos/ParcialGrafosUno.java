package tp5.parciales;

/*
AyED 2024 Grafos - 16.11.2024 - Tema 2
Implemente la clase ParcialGrafos, y el metodo:

public List<List<String>> rutasMultiples(Graph<String> zona, String baseRescate,
String objetivo, int maxDuracion)

Una zona peligrosa necesita ser recorrida por un equipo de rescate para llegar a un punto
objetivo, pero respetando un tiempo maximo por tramo debido a condiciones peligrosas.
Cada nodo en el grafo representa un puesto de control o lugar de descanso (identificado
por un String), y cada arista representa un trayecto entre ellos, con una duracion en minutos.

El metodo debe devolver una lista de listas, donde cada sublista representa una ruta segura
distinta.Si no existe una ruta que cumpla con estas condiciones de seguridad, el metodo debe
devolver una lista vacia.

Supongamos la siguiente zona y que maxDuracion = 12:

Grafo no dirido:
Base de Rescate -> [(Puesto A, 8), (Puesto C, 15)]
Puesto A -> [(Puesto D, 9), (Puesto B, 10)]
Puesto B -> [(Objetivo, 5)]
Puesto C -> [(Objetivo, 7)]
Puesto D -> [(Puesto B, 11)]
Objetivo -> []

Para este caso, las rutas pueden ser:
1) {Base de Rescate, Puesto A, Puesto B, Objetivo} (total 23 minutos, cumple con la
    restriccion de maxDuracion en cada trayecto)
2) {Base de Rescate, PuestoA, Puesto D, Puesto B, Objetivo} (total 33 minutos, tambien
    cumple con la restriccion de maxDuracion en cada trayecto)

- El origen (baseRescate ) y el destino (objetivo) deben ser buscados, ya que pueden no
  existir.
- El camino no debe pasar dos veces por el mismo vertice.
- No se puede agregar variables de clase ni de instancia.
- El grafo debe recorrerse una unica vez.
*/

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Grafo;
import tp5.ejercicio1.Vertex;

public class ParcialGrafosUno <T> {
    
    public List<List<String>> rutasMultiples(Grafo<String> zona, String baseRescate, String objetivo, int maxDuracion) {
        List<List<String>> todasLasRutas = new ArrayList<>();     
        if (!zona.isEmpty()) {
            Vertex<String> origen = zona.search(baseRescate);
            Vertex<String> destino = zona.search(objetivo);
            if (origen != null && destino != null) {      
                boolean[] visitados = new boolean[zona.getSize()];
                List<String> rutaActual = new ArrayList<>();    
                dfsRutas(zona, origen, destino, maxDuracion, visitados, rutaActual, todasLasRutas);
            }
        }
        return todasLasRutas;
    }
    
    private void dfsRutas(Grafo<String> grafo, Vertex<String> actual, Vertex<String> destino,
                                 int maxDuracion, boolean[] visitados, List<String> rutaActual,
                                 List<List<String>> todasLasRutas) {
        
        visitados[actual.getPosition()] = true;
        rutaActual.add(actual.getData());
        
        if (actual.equals(destino)) {
            todasLasRutas.add(new ArrayList<>(rutaActual));
        } else {
            List<Edge<String>> adyacentes = grafo.getEdges(actual);
            for (Edge<String> arista : adyacentes) {
                Vertex<String> siguiente = arista.getTarget();
                int duracion = arista.getWeight();
                
                if (!visitados[siguiente.getPosition()] && duracion <= maxDuracion) {
                    dfsRutas(grafo, siguiente, destino, maxDuracion, visitados, rutaActual, todasLasRutas);
                }
            }
        }
        
        rutaActual.remove(rutaActual.size() - 1);
        visitados[actual.getPosition()] = false;
    }
    
    public static void main(String[] args) {
        
        AdyacenciaListaGrafo <String> grafo = new AdyacenciaListaGrafo <> ();
        
        Vertex <String> v1 = grafo.createVertex("Base de Rescate");
        Vertex <String> v2 = grafo.createVertex("Puesto A");
        Vertex <String> v3 = grafo.createVertex("Puesto B");
        Vertex <String> v4 = grafo.createVertex("Puesto C");
        Vertex <String> v5 = grafo.createVertex("Puesto D");
        Vertex <String> v6 = grafo.createVertex("Objetivo");
        
        grafo.connect(v1, v2, 8);
        grafo.connect(v1, v4, 15);
        grafo.connect(v2, v5, 9);
        grafo.connect(v2, v3, 10);
        grafo.connect(v4, v6, 7);
        grafo.connect(v5, v3, 11);
        grafo.connect(v3, v6, 5);
        
        ParcialGrafosUno pg = new ParcialGrafosUno ();
        System.out.println(pg.rutasMultiples(grafo, "Base de Rescate", "Objetivo", 12));
        
    }
    
}
