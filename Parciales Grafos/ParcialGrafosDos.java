package tp5.parciales;

/*
AyED 2024 - Grafos - Flotante XIII/07/2024
Implemente la clase ParcialGrafos, y el metodo:

public List <String> recorridoSeguroMaxFrutales (Graph<String> bosque, String caperucita,
String abuelita, int maxFrutales)

Continua la ayuda a Caperucita para llegar a la casa de su abuelita, ahora se quiere hallar
el camino con la mayor cantidad de frutales pero que ademas sea seguro, es decir que NO
pase por los senderos con cantidad de frutales > maxFrutales (pasado como parametro) ya
que hay mayor probabilidad que ahi este el lobo.

Recuerde que el bosque está representado por un grafo, donde los vertices representan los
claros (identificados por un String) y las aristas los senderos que los unen. Cada arista
informa la cantidad de arboles frutales que hay en el sendero.

Por ejemplo, para el siguiente bosque, si maxFrutales = 30, el camino seguro con la mayor
cantidad de frutales es {Casa de Caperucita, Claro 2, Claro 6, Casa de la Abuelita} ya que
es seguro, ninguna arista supera maxFrutales y el costo total de frutales = 60 (maximo)

Grafo no dirigido:
Casa de Caperucita -> [(Claro 4, 8), (Claro 2, 15), (Claro 3, 20), (Claro 1, 10)]
Claro 1 -> []
Claro 2 -> [(Claro 6, 30)]
Claro 3 -> [(Claro 5, 3), (Claro 1, 5)]
Claro 4 -> [(Claro 2, 38), (Claro 6, 45)]
Claro 5 -> [(Claro 6, 7), (Casa de la Abuelita, 35)]
Claro 6 -> [(Casa de la Abuelita, 15)]
Casa de la Abuelita -> []
*/

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Grafo;
import tp5.ejercicio1.Vertex;

public class ParcialGrafosDos {
    
    public List<String> recorridoSeguroMaxFrutales(Grafo<String> bosque, String caperucita, String abuelita, int maxFrutales) {
        List<String> mejorCamino = new ArrayList<>();
        if (!bosque.isEmpty()) {
            Vertex<String> origen = bosque.search(caperucita);
            Vertex<String> destino = bosque.search(abuelita);
            if (origen != null && destino != null) {
                boolean[] visitados = new boolean[bosque.getSize()];
                List<String> caminoActual = new ArrayList<>();
                int[] maximoFrutales = {-1};      
                dfsFrutales(bosque, origen, destino, maxFrutales, visitados, caminoActual, 0, mejorCamino, maximoFrutales);
            }
        }
        return mejorCamino;
    }

    private void dfsFrutales(Grafo<String> grafo, Vertex<String> actual, Vertex<String> destino,
                                     int maxFrutales, boolean[] visitados, List<String> caminoActual,
                            int frutalesAcumulados, List<String> mejorCamino, int[] maximoFrutales) {
    
        visitados[actual.getPosition()] = true;
        caminoActual.add(actual.getData());

        if (actual.equals(destino)) {
            if (frutalesAcumulados > maximoFrutales[0]) {
                maximoFrutales[0] = frutalesAcumulados;
                mejorCamino.addAll(new ArrayList<>(caminoActual));
            }
        } else {
            for (Edge<String> arista : grafo.getEdges(actual)) {
                Vertex<String> siguiente = arista.getTarget();
                int frutalesSendero = arista.getWeight();

                if (!visitados[siguiente.getPosition()] && frutalesSendero <= maxFrutales) {
                    dfsFrutales(grafo, siguiente, destino, maxFrutales, visitados,
                                    caminoActual, frutalesAcumulados + frutalesSendero,
                                    mejorCamino, maximoFrutales);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados[actual.getPosition()] = false;
    }
    
    public static void main(String[] args) {
        
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo <> ();
        
        Vertex<String> v1 = grafo.createVertex("Casa de Caperucita");
        Vertex<String> v2 = grafo.createVertex("Claro 1");
        Vertex<String> v3 = grafo.createVertex("Claro 2");
        Vertex<String> v4 = grafo.createVertex("Claro 3");        
        Vertex<String> v5 = grafo.createVertex("Claro 4");
        Vertex<String> v6 = grafo.createVertex("Claro 5");
        Vertex<String> v7 = grafo.createVertex("Claro 6");
        Vertex<String> v8 = grafo.createVertex("Casa de la Abuelita");
        
        grafo.connect(v1, v5, 8);
        grafo.connect(v1, v3, 15);
        grafo.connect(v1, v4, 20);
        grafo.connect(v1, v2, 10);
        grafo.connect(v5, v3, 38);
        grafo.connect(v5, v7, 45);
        grafo.connect(v3, v7, 30);
        grafo.connect(v4, v6, 3);
        grafo.connect(v4, v2, 5);
        grafo.connect(v6, v7, 7);
        grafo.connect(v6, v8, 35);
        grafo.connect(v7, v8, 15);
        
        ParcialGrafosDos pg = new ParcialGrafosDos ();
        System.out.println(pg.recorridoSeguroMaxFrutales(grafo,v1.getData(),v8.getData(),30));
        
    } 
    
}
