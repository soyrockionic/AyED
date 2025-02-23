package TP5.Ejercicio1.AdyacenciaLista;

import TP5.Ejercicio1.Vertice;
import TP5.Ejercicio2.Recorridos;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {
        // Crear el grafo con listas de adyacencia
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo<>();

        // Crear vértices
        Vertice<String> a = grafo.crearVertice("A");
        Vertice<String> b = grafo.crearVertice("B");
        Vertice<String> c = grafo.crearVertice("C");
        Vertice<String> d = grafo.crearVertice("D");
        
        grafo.conectar(a, b, 10);
        grafo.conectar(a, c, 16);
        grafo.conectar(b, c, 8);
        grafo.conectar(c, d, 4);
        
        System.out.println("Vertices del grafo: " + grafo.obtenerVertices());
        grafo.desconectar(a, c);
        System.out.println("Cant de aristas del vertice " + grafo.obtenerVertice(0).obtenerDato()
                                                                         + ": " + grafo.obtenerAristas(a).size()); 
        System.out.println("Distancia entre B y C: " + grafo.peso(b, c));
        grafo.desconectar(c, d);
        System.out.println("Existe coneccion entre C y D: " + grafo.existeArista(c, d));
        
    }
    
}
