package TP1.Ejercicio8;

import java.util.LinkedList;

public class Queue<T>  extends Sequence{
    
    private LinkedList<T> turnos = new LinkedList<>();

    public Queue(){
    }
    
    public void enqueue(T dato){
        this.turnos.add(dato);
    }
    
    public T dequeue() throws IllegalAccessException {
        if (this.isEmpty()) {
            throw new IllegalAccessException("La cola esta vacia");
        } else
            return turnos.remove(0);
    }
    
    public T head() throws IllegalAccessException {
        if (this.isEmpty()) {
            throw new IllegalAccessException("La cola esta vacia");
        } else
        return turnos.get(0);
    }
    
    public int size(){
        return turnos.size();
    }
    
    public boolean isEmpty(){
        return turnos.isEmpty();
    }

    @Override
    public String toString(){
        return ""+turnos;
    }
    
}
