package TP1.Ejercicio8;

public class DoubleEndedQueue<T> extends Queue {
    
    public void enqueueFirst(T dato) throws IllegalAccessException{
        enqueue(dato);
        int size = this.size() - 1;
        for (int i = 0; i < size; i++) {
            this.enqueue(this.dequeue());
        }
    }
    
}
