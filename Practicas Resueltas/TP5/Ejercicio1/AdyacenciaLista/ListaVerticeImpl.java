package TP5.Ejercicio1.AdyacenciaLista;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Vertice;
import java.util.ArrayList;
import java.util.List;

public class ListaVerticeImpl<T> implements Vertice<T> {
    private T dato;
    private int posicion;
    private List<Arista<T>> adyacentes;

    public ListaVerticeImpl(T dato, int posicion) {
        this.dato = dato;
        this.posicion = posicion;
        this.adyacentes = new ArrayList<>();
    }

    @Override
    public T obtenerDato() {
        return dato;
    }

    @Override
    public void establecerDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int obtenerPosicion() {
        return posicion;
    }

    public List<Arista<T>> obtenerAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacente(Arista<T> arista) {
        adyacentes.add(arista);
    }
    
    public void eliminarAdyacente(Arista<T> arista) {
        adyacentes.remove(arista);
    }
    
    public String toString(){
        return (String) this.dato;
    }
    
}

