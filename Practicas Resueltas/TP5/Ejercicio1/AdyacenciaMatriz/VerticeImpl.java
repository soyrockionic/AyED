package TP5.Ejercicio1.AdyacenciaMatriz;

import TP5.Ejercicio1.Vertice;

public class VerticeImpl<T> implements Vertice<T> {
    private T data;
    private int position;

    public VerticeImpl(T data, int position) {
        this.data = data;
        this.position = position;
    }

    @Override
    public T obtenerDato() {
        return data;
    }

    @Override
    public void establecerDato(T data) {
        this.data = data;
    }

    @Override
    public int obtenerPosicion() {
        return position;
    }
    
    public String toString(){
        return (String) this.data;
    }
    
}
