package TP1.Ejercicio8;

public class Main {
    
    public static void main(String[] args) throws IllegalAccessException {
        
        DoubleEndedQueue<T>  cola = new DoubleEndedQueue<>();
        
        T  n1 = new T(10);
        cola.enqueue(n1);
        T  n2 = new T(20);
        cola.enqueue(n2);
        T  n3 = new T(30);
        cola.enqueue(n3);
        
        System.out.println("Elementos " + cola.toString());
        System.out.println("Cantidad " + cola.size());
        System.out.println("Elimino " + cola.dequeue());
        System.out.println("Elementos " + cola.toString());
        System.out.println("Cantidad " + cola.size());
        System.out.println("Primer elemento " + cola.head());
        
        T n4 = new T(40);
        cola.enqueueFirst(n4);
        T n5 = new T(50);
        cola.enqueue(n5);
    
        System.out.println("Elementos " + cola.toString());
        System.out.println("Cantidad " + cola.size());
        System.out.println("Primer elemento " + cola.head());
        
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        T n6 = new T(40);
        T n7 = new T(50);
        T n8 = new T(60);
        circularQueue.enqueue(n6);
        circularQueue.enqueue(n7);
        circularQueue.enqueue(n8);
        circularQueue.shift();
        System.out.println("Circular Queue: " + circularQueue.toString());
        System.out.println("Cantidad: " + circularQueue.size());
        System.out.println("Circular Queue: " + circularQueue.shift());
        System.out.println("Circular Queue: " + circularQueue.toString());

    }
    
}
