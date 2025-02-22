package TP5.Ejercicio1.AdyacenciaMatriz;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Vertice;

public class AristaImpl<T> implements Arista<T> {
    private Vertice<T> destination;
    private int weight;

    public AristaImpl(Vertice<T> origin, Vertice<T> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public Vertice<T> obtenerDestino() {
        return destination;
    }

    @Override
    public int obtenerPeso() {
        return weight;
    }
}

