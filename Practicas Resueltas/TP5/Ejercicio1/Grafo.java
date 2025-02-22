package TP5.Ejercicio1;

import java.util.List;

public interface Grafo<T> {

    // Crea un vertice con el dato recibido y lo retorna.
    Vertice<T> crearVertice(T dato);

    // Elimina el vertice del grafo, junto con todas las relaciones asociadas.
    void eliminarVertice(Vertice<T> vertice);

    // Busca y retorna el primer vertice cuyo dato es igual al parametro recibido. Retorna null si no existe tal vertice.
    Vertice<T> buscar(T dato);

    // Conecta el vertice origen con el vertice destino.
    void conectar(Vertice<T> origen, Vertice<T> destino);

    // Conecta el vertice origen con el vertice destino con un peso especifico.
    void conectar(Vertice<T> origen, Vertice<T> destino, int peso);

    // Desconecta el vertice origen del vértice destino. Si existe una conexion destino-->origen, esta permanece sin cambios.
    void desconectar(Vertice<T> origen, Vertice<T> destino);

    // Retorna true si existe una arista entre el vertice origen y el destino.
    boolean existeArista(Vertice<T> origen, Vertice<T> destino);

    // Retorna true si el grafo no contiene vertices.
    boolean estaVacio();

    // Retorna la lista de todos los vertices en el grafo.
    List<Vertice<T>> obtenerVertices();

    // Retorna el peso de la arista entre los vertices origen y destino. Retorna 0 si no existe la arista.
    int peso(Vertice<T> origen, Vertice<T> destino);

    // Retorna la lista de aristas (adyacentes) del vertice recibido.
    List<Arista<T>> obtenerAristas(Vertice<T> vertice);

    // Obtiene el vertice en la posicion recibida (indice).
    Vertice<T> obtenerVertice(int posicion);

    // Retorna la cantidad de vertices en el grafo.
    int obtenerTamaño();
}
