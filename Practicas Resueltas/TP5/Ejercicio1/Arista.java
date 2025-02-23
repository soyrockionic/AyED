package TP5.Ejercicio1;

public interface Arista<T> {

    // Retorna el vertice destino de la arista.
    public Vertice<T> obtenerDestino();

    // Retorna el peso de la arista.
    public int obtenerPeso();
}

