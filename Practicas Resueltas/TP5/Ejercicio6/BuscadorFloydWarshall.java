package TP5.Ejercicio6;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.LinkedList;
import java.util.List;

public class BuscadorFloydWarshall {
    private Grafo<String> bosque;
    
    public BuscadorFloydWarshall(Grafo<String> bosque) {
        this.bosque = bosque;
    }
    
    public List<String> caminoMasCorto() {
        int n = this.bosque.obtenerTamaño();
        double[][] dist = new double[n][n];
        int[][] pred = new int[n][n];

        // Inicializar matrices de distancias y predecesores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : Double.POSITIVE_INFINITY;
                pred[i][j] = -1; // -1 significa que no hay predecesor aún
            }
        }

        // Rellenar la matriz con las distancias iniciales del grafo
        for (Vertice<String> v : this.bosque.obtenerVertices()) {
            List<Arista<String>> adys = this.bosque.obtenerAristas(v);
            for (Arista<String> arista : adys) {
                int origenPos = v.obtenerPosicion();
                int destinoPos = arista.obtenerDestino().obtenerPosicion();
                dist[origenPos][destinoPos] = arista.obtenerPeso();
                pred[origenPos][destinoPos] = origenPos; // Predecesor inicial es el origen
            }
        }

        // Algoritmo de Floyd-Warshall para calcular todas las distancias mínimas
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j]; // Actualizar el predecesor
                    }
                }
            }
        }

        // Encontrar el camino mas corto entre "Casa Caperucita" y "Casa Abuelita"
        Vertice<String> Caperucita = this.bosque.buscar("Casa Caperucita");
        Vertice<String> Abuelita = this.bosque.buscar("Casa Abuelita");

        if (Caperucita == null || Abuelita == null) {
            return null; // No se encontro alguna de las casas
        }

        int origenPos = Caperucita.obtenerPosicion();
        int destinoPos = Abuelita.obtenerPosicion();

        if (dist[origenPos][destinoPos] == Double.POSITIVE_INFINITY) {
            return null; // No hay camino posible
        }

        // Reconstruir el camino desde "Casa Caperucita" hasta "Casa Abuelita"
        List<String> camino = new LinkedList<>();
        reconstruirCamino(pred, origenPos, destinoPos, camino);

        return camino;
    }

    // Metodo para reconstruir el camino usando la matriz de predecesores
    private void reconstruirCamino(int[][] pred, int origenPos, int destinoPos, List<String> camino) {
        if (origenPos == destinoPos) {
            camino.add(this.bosque.obtenerVertice(origenPos).obtenerDato());
        } else if (pred[origenPos][destinoPos] == -1) {
            return; // No hay camino
        } else {
            reconstruirCamino(pred, origenPos, pred[origenPos][destinoPos], camino);
            camino.add(this.bosque.obtenerVertice(destinoPos).obtenerDato());
        }
    } 
    
}
