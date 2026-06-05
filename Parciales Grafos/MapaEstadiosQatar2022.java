package tp5.parciales;

/*
Un grupo de amigos ecuatorianos asistieron el domingo 20 al primer partido del mundial en
la ciudad de Jor, en el cual se enfrentaron Ecuador-Qatar.
Luego de disfrutar el encuentro, contrataron un auto en una agencia turistirica por una
cantidad de kilometros, con el objetivo de conocer por fuera el resto de los estadios.
La agencia les entrego un mapa que contiene 8 estadios que estan distribuidos en 5 ciudades
diferentes.
Este mapa se puede modelizar con un grafo sin direccion, donde cada vertice representa un
estadio y las aristas las rutas que lo conectan.

Se debe implementar el siguiente metodo:
List<String> estadios (Grafo<String> mapaEstadios, String estadioOrigen, int cantKm)

El cual recibe el mapa de los estadios, el nombre del estadio de la ciudad de Jor, "AI Bayt
Stadium" y la cantidad  de kilometros contratados.

El algoritmo debe retornar una lista con los nombres de los estadios que pueden recorrer como
maximo en esa cantidad de kilometros.
Tenga presente que para la cantidad de kilometros contrados pueden existir distintos caminos
posibles, por lo cual debe retornar el que visite la mayor cantidad de estadios.

Por ejemplo, si el mapa entregado a los turistas fuese el siguiente y la canKm = 100.

Grafo no dirigido:
Al Bayt Stadium -> [(Lusail Stadium,42)]
Lusail Stadium -> [(Education City Staium ,24),(Stadium 947,52)]
Education City Stadium -> [(Al Rayyan Stadium,11)]
Al Rayyan Stadium -> [(Khalifa -international Stadium,8)]
Khalifa -international Stadium -> [(Al Thumama Stadium, 12)]
Al Thumama Stadium -> [(Al Janoub Stadium, 12)]
Stadium 947 -> [(Al Janoub Stadium,19)]

La lista por retornar seria:
[AI Bayt Stadium, Lusail Stadium, Education City Stadium, Al Rayyan Stadium,
 Khalifa International Stadium, Al Thumama]
*/

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Grafo;
import tp5.ejercicio1.Vertex;

public class MapaEstadiosQatar2022 {
    
    public List<String> estadios (Grafo<String> mapaEstadios, String estadioOrigen, int cantKm) {
        List<String> recorrido = new LinkedList <> ();
        if(!mapaEstadios.isEmpty()) {
            Vertex<String> origen = mapaEstadios.search(estadioOrigen);
            boolean [] marca = new boolean [mapaEstadios.getSize()];
            List<String> recoActual = new LinkedList <> ();
            if (origen != null) {
                dfs(mapaEstadios,origen,marca,cantKm,0,recorrido,recoActual);
            }
        }       
        return recorrido;
    }
    
    private void dfs (Grafo<String> grafo, Vertex<String> actual, boolean [] marca, int cantKm,
                                          int cantKmAct, List<String> recorrido, List<String> recoActual) {
        
        marca[actual.getPosition()] = true;
        recoActual.add(actual.getData());
        
        if (recoActual.size() > recorrido.size()) {
            recorrido.clear();
            recorrido.addAll(recoActual);
        }
        
        for(Edge<String> arista : grafo.getEdges(actual)) {
            Vertex<String> sig = arista.getTarget();
            cantKmAct = cantKmAct + arista.getWeight();
            if (!marca[sig.getPosition()] && cantKmAct <= cantKm) {
                dfs(grafo,sig,marca,cantKm,cantKmAct,recorrido,recoActual);
            }
        }
        
        recoActual.remove(recoActual.size() - 1);
        marca[actual.getPosition()] = false;     
    }
    
    public static void main(String[] args) {
        
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo <> ();
        
        Vertex<String> v1 = grafo.createVertex("AI Bayt Stadium");
        Vertex<String> v2 = grafo.createVertex("Lusail Stadium");
        Vertex<String> v3 = grafo.createVertex("Education City Stadium");
        Vertex<String> v4 = grafo.createVertex("Stadium 947");
        Vertex<String> v5 = grafo.createVertex("Al Rayyan Stadium");
        Vertex<String> v6 = grafo.createVertex("Khalifa International Stadium");
        Vertex<String> v7 = grafo.createVertex("Al Thumama Stadium");
        Vertex<String> v8 = grafo.createVertex("Al Janoub Stadium");
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v2, v4, 52);
        grafo.connect(v3, v5, 11);
        grafo.connect(v5, v6, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v4, v8, 19);
        
        MapaEstadiosQatar2022 mapa = new MapaEstadiosQatar2022 ();
        System.out.print(mapa.estadios(grafo, v1.getData(), 100));
        
    }
    
}