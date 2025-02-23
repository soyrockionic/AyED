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
            if (origen != null || destino != null) {
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
    
    public List<String> caminoMasCortoDFS(String ciudad1, String ciudad2) {
        List<String> caminoActual = new ArrayList<>();
        List<String> caminoMasCorto = new ArrayList<>();

        Vertice<String> origen = mapaCiudades.buscar(ciudad1);
        Vertice<String> destino = mapaCiudades.buscar(ciudad2);

        if (origen != null && destino != null) {
            boolean[] visitados = new boolean[mapaCiudades.obtenerTamaño()];
            dfsCaminoCorto(origen, destino, visitados, caminoActual, caminoMasCorto);
        }

        return caminoMasCorto;
    }

    // Método DFS modificado sin Set, usando boolean[] visitados
    private void dfsCaminoCorto(Vertice<String> actual, Vertice<String> destino, boolean[] visitados, 
                                           List<String> caminoActual, List<String> caminoMasCorto) {
        // Marcar el nodo como visitado
        visitados[actual.obtenerPosicion()] = true;
        caminoActual.add(actual.obtenerDato());

        // Si llegamos al destino, verificar si el camino es más corto
        if (actual.equals(destino)) {
            if (caminoMasCorto.isEmpty() || caminoActual.size() < caminoMasCorto.size()) {
                caminoMasCorto.clear();
                caminoMasCorto.addAll(new ArrayList<>(caminoActual));
            }
        } else {
            // Explorar las aristas adyacentes
            List<Arista<String>> adyacentes = mapaCiudades.obtenerAristas(actual);
            for (Arista<String> arista : adyacentes) {
                Vertice<String> siguiente = arista.obtenerDestino();
                if (!visitados[siguiente.obtenerPosicion()]) {
                    dfsCaminoCorto(siguiente, destino, visitados, caminoActual, caminoMasCorto);
                }
            }
        }

        // Backtracking: desmarcar el nodo y quitarlo del camino actual
        visitados[actual.obtenerPosicion()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    /*===========================================================*/
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>(); // Lista para almacenar el camino
        if (!mapaCiudades.estaVacio()) {
            Vertice<String> origen = mapaCiudades.buscar(ciudad1);
            Vertice<String> destino = mapaCiudades.buscar(ciudad2);
            if (origen != null && destino != null) { // Cambié la condición a "&&" porque queremos que ambos vértices existan
                boolean[] marca = new boolean[mapaCiudades.obtenerTamaño()]; // Array para marcar los vértices visitados               
                dfsCaminoSinCarga(origen, destino, marca, camino, tanqueAuto, 0);
            }
        }
        return camino;
    }

    private boolean dfsCaminoSinCarga(Vertice<String> actual, Vertice<String> destino, boolean[] marca, List<String> camino, int tanqueAuto, int distanciaRecorrida) {
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