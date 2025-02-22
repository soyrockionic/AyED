package TP5.Ejercicio1;

public interface Vertice<T> {

    // Retorna el dato almacenado en el vertice.
    public T obtenerDato();

    // Establece el dato del vertice.
    public void establecerDato(T dato);

    // Retorna la posición del vertice en el grafo.
    public int obtenerPosicion();
}
