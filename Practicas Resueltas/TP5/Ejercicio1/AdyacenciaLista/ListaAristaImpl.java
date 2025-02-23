package TP5.Ejercicio1.AdyacenciaLista;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Vertice;

public class ListaAristaImpl<T> implements Arista<T> {
    private Vertice<T> destino;
    private int peso;

    public ListaAristaImpl(Vertice<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public Vertice<T> obtenerDestino() {
        return destino;
    }

    @Override
    public int obtenerPeso() {
        return peso;
    }
    
}
