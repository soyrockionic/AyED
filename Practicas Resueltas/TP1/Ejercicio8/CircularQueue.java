package TP1.Ejercicio8;

public class CircularQueue<T> extends Queue{
    
    public T shift() throws IllegalAccessException {
        T data =  (T) dequeue();
        enqueue(data);
        return data;
    }
    
}
