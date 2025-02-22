package TP5.Ejercicio1.AdyacenciaMatriz;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.ArrayList;
import java.util.List;

public class AdyacenciaMatrizGrafo<T> implements Grafo<T> {
    private List<Vertice<T>> vertices; // Lista de vertices
    private int[][] matrizAdyacencia; // Matriz de adyacencia
    private int tamaño; // Tamaño actual del grafo

    public AdyacenciaMatrizGrafo(int capacidad) {
        this.vertices = new ArrayList<>();
        this.matrizAdyacencia = new int[capacidad][capacidad]; // Inicializa la matriz de adyacencia
        this.tamaño = 0;
    }

    @Override
    public Vertice<T> crearVertice(T dato) {
        Vertice<T> vertice = new VerticeImpl<>(dato, tamaño);
        vertices.add(vertice);
        tamaño++;
        return vertice;
    }

    @Override
    public void eliminarVertice(Vertice<T> vertice) {
        int pos = vertice.obtenerPosicion();
        vertices.remove(vertice);
        tamaño--;

        // Elimina las conexiones asociadas en la matriz de adyacencia
        for (int i = 0; i < tamaño; i++) {
            matrizAdyacencia[i][pos] = 0;
            matrizAdyacencia[pos][i] = 0;
        }
    }

    @Override
    public Vertice<T> buscar(T dato) {
        for (Vertice<T> vertice : vertices) {
            if (vertice.obtenerDato().equals(dato)) {
                return vertice;
            }
        }
        return null;
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        conectar(origen, destino, 1); // Conexión sin peso (por defecto con peso 1)
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        int posOrigen = origen.obtenerPosicion();
        int posDestino = destino.obtenerPosicion();
        matrizAdyacencia[posOrigen][posDestino] = peso;
    }

    @Override
    public void desconectar(Vertice<T> origen, Vertice<T> destino) {
        int posOrigen = origen.obtenerPosicion();
        int posDestino = destino.obtenerPosicion();
        matrizAdyacencia[posOrigen][posDestino] = 0; // Elimina la conexion
    }

    @Override
    public boolean existeArista(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdyacencia[origen.obtenerPosicion()][destino.obtenerPosicion()] != 0;
    }

    @Override
    public boolean estaVacio() {
        return vertices.isEmpty();
    }

    @Override
    public List<Vertice<T>> obtenerVertices() {
        return vertices;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        return matrizAdyacencia[origen.obtenerPosicion()][destino.obtenerPosicion()];
    }

    @Override
    public List<Arista<T>> obtenerAristas(Vertice<T> vertice) {
        List<Arista<T>> aristas = new ArrayList<>();
        int pos = vertice.obtenerPosicion();

        for (int i = 0; i < tamaño; i++) {
            if (matrizAdyacencia[pos][i] != 0) {
                aristas.add(new AristaImpl<>(vertice, vertices.get(i), matrizAdyacencia[pos][i]));
            }
        }
        return aristas;
    }

    @Override
    public Vertice<T> obtenerVertice(int posicion) {
        return vertices.get(posicion);
    }

    @Override
    public int obtenerTamaño() {
        return tamaño;
    }
    
}
