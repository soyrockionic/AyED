package TP5.Ejercicio3;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.ArrayList;
import java.util.List;

public class Mapa {
    
    private Grafo<String> mapaCiudades;
    
    public Mapa(Grafo grafo){
        this.mapaCiudades = grafo;
    }
    
    /*===========================================================*/
    
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> camino = new ArrayList<>(); // Lista para almacenar el camino
        if(!mapaCiudades.estaVacio()){
            Vertice<String> origen = mapaCiudades.buscar(ciudad1);
            Vertice<String> destino = mapaCiudades.buscar(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[mapaCiudades.obtenerTamaño()]; // Array para marcar los vertices visitados               
                dfsCamino(origen, destino, marca, camino);
            }
        }    
        return camino;
    }

    private boolean dfsCamino(Vertice<String> actual, Vertice<String> destino, boolean[] marca, List<String> camino) {
        marca[actual.obtenerPosicion()] = true; // Marca el vertice como visitado
        camino.add(actual.obtenerDato()); // Añadir la ciudad al camino

        // Si llegamos al destino, retornamos true
        if (actual.equals(destino)) {
            return true;
        }

        // Recorremos las aristas adyacentes
        List<Arista<String>> adyacentes = mapaCiudades.obtenerAristas(actual);
        for (Arista<String> arista : adyacentes) {
            Vertice<String> siguiente = arista.obtenerDestino();
            if (!marca[siguiente.obtenerPosicion()]) {
                // Si encontramos el destino en la siguiente llamada recursiva, retornamos true
                if (dfsCamino(siguiente, destino, marca, camino)){
                    return true;
                }
            }
        }

        // Si no encontramos el destino desde este vertice, lo eliminamos del camino
        camino.remove(camino.size() - 1);
        return false;
    }

    /*===========================================================*/

    public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2,
                                                                      List<String> ciudades) {
        List<String> camino = new ArrayList <> ();
        if (!mapaCiudades.isEmpty()) {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean [] marca = new boolean [mapaCiudades.getSize()];
                dfsCaminoExcepto(origen, destino, marca, camino, ciudades);
            }
        }
        return camino;
    }
    
    private boolean dfsCaminoExcepto (Vertex<String> actual, Vertex<String> destino,
                                          boolean [] marca, List<String> camino, List<String> ciudades) {
        
        if (ciudades.contains(actual.getData())) {
            return false;
        }
        
        marca [actual.getPosition()] = true;
        camino.add(actual.getData());
        
        if (actual.equals(destino)) {
            return true;
        }
        
        List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
        for (Edge<String> arista : adyacentes) {
            Vertex<String> siguiente = arista.getTarget();
            if (!marca[siguiente.getPosition()]) {
                if (dfsCaminoExcepto (siguiente, destino, marca, camino, ciudades)) {
                    return true;
                }
            }
        }
        
        camino.remove(camino.size() - 1);
        return false;
    }
    
    /*===========================================================*/
    
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> caminoMasCorto = new ArrayList<>();
        if (!mapaCiudades.isEmpty()) {
            Vertex<String> origen = mapaCiudades.search(ciudad1);
            Vertex<String> destino = mapaCiudades.search(ciudad2);      
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[mapaCiudades.getSize()];
                List<String> caminoActual = new ArrayList<>();
                dfsCorto(origen, destino, marca, caminoActual, 0, caminoMasCorto, 32260);
            }
        }
        return caminoMasCorto;
    }

    private void dfsCorto(Vertex<String> actual, Vertex<String> destino, boolean[] marca, 
                                      List<String> caminoActual, int distanciaActual, 
                                      List<String> caminoMasCorto, int distanciaMinima) {
        marca[actual.getPosition()] = true;
        caminoActual.add(actual.getData());
    
        if (actual.equals(destino)) {
            if (distanciaActual < distanciaMinima) {
                distanciaMinima = distanciaActual;
                caminoMasCorto.clear();
                caminoMasCorto.addAll(caminoActual);
            }
        } else {
            List<Edge<String>> adyacentes = mapaCiudades.getEdges(actual);
            for (Edge<String> arista : adyacentes) {
                Vertex<String> siguiente = arista.getTarget();
                int pesoArista = arista.getWeight();
            
                if (!marca[siguiente.getPosition()] && (distanciaActual + pesoArista < distanciaMinima)) {
                    dfsCorto(siguiente, destino, marca, caminoActual, distanciaActual + pesoArista, caminoMasCorto, distanciaMinima);
                }
            }
        }
    
        caminoActual.remove(caminoActual.size() - 1);
        marca[actual.getPosition()] = false;
    }
    
    /*===========================================================*/
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>(); // Lista para almacenar el camino
        if (!mapaCiudades.estaVacio()) {
            Vertice<String> origen = mapaCiudades.buscar(ciudad1);
            Vertice<String> destino = mapaCiudades.buscar(ciudad2);
            if (origen != null && destino != null) {
                boolean[] marca = new boolean[mapaCiudades.obtenerTamaño()]; // Array para marcar los vértices visitados               
                dfsCaminoSinCarga(origen, destino, marca, camino, tanqueAuto, 0);
            }
        }
        return camino;
    }

    private boolean dfsCaminoSinCarga(Vertice<String> actual, Vertice<String> destino, boolean[] marca, List<String> camino, 
                                                                                   int tanqueAuto, int distanciaRecorrida) {
        marca[actual.obtenerPosicion()] = true; // Marca el vertice como visitado
        camino.add(actual.obtenerDato()); // Añadir la ciudad al camino

        // Si llegamos al destino y la distancia recorrida es menor o igual al tanque, retornamos true
        if (actual.equals(destino) && distanciaRecorrida <= tanqueAuto) {
            return true;
        }

        // Recorremos las aristas adyacentes
        List<Arista<String>> adyacentes = mapaCiudades.obtenerAristas(actual);
        for (Arista<String> arista : adyacentes) {
            Vertice<String> siguiente = arista.obtenerDestino();
            int pesoArista = arista.obtenerPeso(); // Supongo que hay un metodo para obtener el peso de la arista
            if (!marca[siguiente.obtenerPosicion()] && distanciaRecorrida + pesoArista <= tanqueAuto) {
                // Si encontramos el destino en la siguiente llamada recursiva, retornamos true
                if (dfsCaminoSinCarga(siguiente, destino, marca, camino, tanqueAuto, distanciaRecorrida + pesoArista)) {
                    return true;
                }
            }
        }

        // Si no encontramos el camino, removemos la ciudad actual del camino y retornamos false
        camino.remove(camino.size() - 1);
        return false;
    }
    
    /*===========================================================*/
    
    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> mejorCamino = new ArrayList<>();
        if (!mapaCiudades.estaVacio()) {
            Vertice<String> origen = mapaCiudades.buscar(ciudad1);
            Vertice<String> destino = mapaCiudades.buscar(ciudad2);
            if (origen != null && destino != null) {
                dfsMenorCarga(origen, destino, tanqueAuto, tanqueAuto, 0, new ArrayList<>(), mejorCamino, 32240);
            }
        }
        return mejorCamino;
    }

    private void dfsMenorCarga(Vertice<String> actual, Vertice<String> destino,
                                         int tanqueAuto, int combustibleRestante, int cargasActuales,
                                         List<String> caminoActual, List<String> mejorCamino, int minCargas) {
        caminoActual.add(actual.obtenerDato());
    
        if (actual.equals(destino)) {
            if (cargasActuales < minCargas) {
                minCargas = cargasActuales;
                mejorCamino.clear();
                mejorCamino.addAll(new ArrayList<>(caminoActual));
            }
        } else {
            for (Arista<String> arista : mapaCiudades.obtenerAristas(actual)) {
                Vertice<String> siguiente = arista.obtenerDestino();
                int distancia = arista.obtenerPeso();
            
                if (combustibleRestante >= distancia) {
                    dfsMenorCarga(siguiente, destino, tanqueAuto, combustibleRestante - distancia, cargasActuales, caminoActual, mejorCamino, minCargas);
                } else if (tanqueAuto >= distancia) {
                    dfsMenorCarga(siguiente, destino, tanqueAuto, tanqueAuto - distancia, cargasActuales + 1, caminoActual, mejorCamino, minCargas);
                }
           }
        }  
        caminoActual.remove(caminoActual.size() - 1);
    }

    /*===========================================================*/
}
