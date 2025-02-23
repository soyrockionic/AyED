package TP1.Ejercicio11;

import java.util.LinkedList;

public class LineaDeColectivo<T> {
    
    private LinkedList<T> paradas;
    private String nombre;
    
    public LineaDeColectivo( String nombre){
        this.paradas = new LinkedList();
        this.nombre = nombre;
    }
    
    public  void agregarParada(T t){
        this.paradas.add(t);
    }
    
    private T eliminarParada(){
        if (!paradas.isEmpty())
          return paradas.remove(0);
        return null;
    }
    
    public String obtenerLinea(){
        return this.nombre;
    }
    
    // Rotar hacia adelante
    public T shift() throws IllegalAccessException {
        T data = eliminarParada();
        agregarParada(data);
        return data;
    }
    
    // Rotar hacia atras
    public T reverseShift() throws IllegalAccessException {
        T data = this.paradas.removeLast();  // Eliminar el ultimo elemento
        this.paradas.addFirst(data);  // Añadirlo al principio
        return data;
    }
      
    public LinkedList<T> obtenerParadas(){
        return this.paradas;
    }
    
    public int size(){
        return paradas.size();
    }
    
    public static void main(String[] args) throws IllegalAccessException{
        
        LineaDeColectivo<String> oeste = new LineaDeColectivo<>("Oeste");
        
        oeste.agregarParada("7 y 48");
        oeste.agregarParada("7 y 46");
        oeste.agregarParada("4 y 41");
        oeste.agregarParada("7 y 41");
        oeste.agregarParada("9 y 41");
        
        System.out.println("Recorrido ida linea " + oeste.obtenerLinea() + ":");
        System.out.println("------------------------------");
        for(int i = 0; i < oeste.size(); i++){           
            System.out.println("Parada actual: " + oeste.obtenerParadas().get(0));
            oeste.shift();
        }
        System.out.println("------------------------------");
        System.out.println("Recorrido vuelta linea " + oeste.obtenerLinea() + ":");
        System.out.println("------------------------------");
        for(int i = 0; i < oeste.size(); i++){           
            System.out.println("Parada actual: " + oeste.reverseShift());
        }
        
    }
    
}
