package TP1.Ejercicio8;

public class Main {
    
    public static void main(String[] args) throws IllegalAccessException {
        
        CircularQueue<Integer> cola = new CircularQueue<>();
        
        cola.enqueue(10);
        cola.enqueue(15);
        cola.enqueue("Veinte");
        cola.enqueue(25);
        
        System.out.println(cola.toString());
        cola.shift();
        System.out.println(cola.toString());
        cola.shift();
        System.out.println(cola.toString());
        System.out.println(cola.head());
        
        DoubleEndedQueue fila = new DoubleEndedQueue();
        
        fila.enqueueFirst(100);
        fila.enqueue("Doscientos");
        fila.enqueueFirst("Trescientos");
        fila.enqueueFirst(400);
        System.out.println(fila.toString());
        System.out.println(fila.dequeue());
        System.out.println(fila.toString());
        
    }
    
}
