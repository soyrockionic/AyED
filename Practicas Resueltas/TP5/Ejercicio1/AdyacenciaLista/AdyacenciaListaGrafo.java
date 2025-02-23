package TP5.Ejercicio1.AdyacenciaLista;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.ArrayList;
import java.util.List;

public class AdyacenciaListaGrafo<T> implements Grafo<T> {
    private List<Vertice<T>> vertices;

    public AdyacenciaListaGrafo() {
        this.vertices = new ArrayList<>();
    }

    @Override
    public Vertice<T> crearVertice(T dato) {
        Vertice<T> vertice = new ListaVerticeImpl<>(dato, vertices.size());
        vertices.add(vertice);
        return vertice;
    }

    @Override
    public void eliminarVertice(Vertice<T> vertice) {
        vertices.remove(vertice);
        for (Vertice<T> v : vertices) {
            ((ListaVerticeImpl<T>) v).eliminarAdyacente(new ListaAristaImpl<>(vertice, 0));
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
        conectar(origen, destino, 1);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        ((ListaVerticeImpl<T>) origen).agregarAdyacente(new ListaAristaImpl<>(destino, peso));
    }

    @Override
    public void desconectar(Vertice<T> origen, Vertice<T> destino) {
        List<Arista<T>> adyacentes = ((ListaVerticeImpl<T>) origen).obtenerAdyacentes();
        for (Arista<T> arista : adyacentes) {
            if (arista.obtenerDestino().equals(destino)) {
                adyacentes.remove(arista);
                break;
            }
        }
    }

    @Override
    public boolean existeArista(Vertice<T> origen, Vertice<T> destino) {
        List<Arista<T>> adyacentes = ((ListaVerticeImpl<T>) origen).obtenerAdyacentes();
        for (Arista<T> arista : adyacentes) {
            if (arista.obtenerDestino().equals(destino)) {
                return true;
            }
        }
        return false;
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
        List<Arista<T>> adyacentes = ((ListaVerticeImpl<T>) origen).obtenerAdyacentes();
        for (Arista<T> arista : adyacentes) {
            if (arista.obtenerDestino().equals(destino)) {
                return arista.obtenerPeso();
            }
        }
        return 0;
    }

    @Override
    public List<Arista<T>> obtenerAristas(Vertice<T> vertice) {
        return ((ListaVerticeImpl<T>) vertice).obtenerAdyacentes();
    }

    @Override
    public Vertice<T> obtenerVertice(int posicion) {
        return vertices.get(posicion);
    }

    @Override
    public int obtenerTamaño() {
        return this.vertices.size();
    }
    
}