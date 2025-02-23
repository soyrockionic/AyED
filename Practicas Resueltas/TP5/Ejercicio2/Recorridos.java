package TP5.Ejercicio2;

import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import TP1.Ejercicio8.Queue;

public class Recorridos<T> {

    public List<T> dfs(Grafo<T> grafo) {
        boolean[] marca = new boolean[grafo.obtenerTamaño()];
        List<T> resultado = new ArrayList<>(); // Lista para almacenar los vertices
        for (int i = 0; i < grafo.obtenerTamaño(); i++) {
            if (!marca[i]) {
                System.out.println("Inicio desde: " + grafo.obtenerVertice(i).obtenerDato());
                dfs(i, grafo, marca, resultado);
            }
        }
        return resultado;
    }

    private void dfs(int i, Grafo<T> grafo, boolean[] marca, List<T> resultado) {
        marca[i] = true;
        Vertice<T> v = grafo.obtenerVertice(i);
        resultado.add(v.obtenerDato()); // Añadir el vertice visitado a la lista
        System.out.println(v.obtenerDato());
    
        List<Arista<T>> adyacentes = grafo.obtenerAristas(v); // Obtener aristas adyacentes
        for (Arista<T> e : adyacentes) {
            int j = e.obtenerDestino().obtenerPosicion();
            if (!marca[j])
                dfs(j, grafo, marca, resultado);
        }
    }
    
   public List<T> bfs(Grafo<T> grafo) throws IllegalAccessException {
       boolean[] marca = new boolean[grafo.obtenerTamaño()]; // Para marcar los vertices visitados
       List<T> resultado = new LinkedList<>(); // Lista para almacenar los datos de los vertices
       Queue<Vertice<T>> cola = new Queue<>(); // Cola personalizada para el recorrido en amplitud

       for (int i = 0; i < grafo.obtenerTamaño(); i++) {
           if (!marca[i]) {
               cola.enqueue(grafo.obtenerVertice(i)); // Encolar el primer vertice no visitado
               marca[i] = true;

               while (!cola.isEmpty()) {
                   Vertice<T> v = cola.dequeue(); // Desencolar el vertice actual
                   resultado.add(v.obtenerDato()); // Agregar los datos del vertice a la lista
                
                   // Obtener los vertices adyacentes del vertice actual
                   List<Arista<T>> adyacentes = grafo.obtenerAristas(v);
                   for (Arista<T> e : adyacentes) {
                       int j = e.obtenerDestino().obtenerPosicion();
                       if (!marca[j]) {
                           cola.enqueue(e.obtenerDestino()); // Encolar el vertice adyacente no visitado
                           marca[j] = true;
                       }
                   }
               }
           }
       }
       return resultado;
   }
    
}
