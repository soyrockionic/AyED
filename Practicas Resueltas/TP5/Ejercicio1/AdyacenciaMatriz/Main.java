package TP5.Ejercicio1.AdyacenciaMatriz;

import TP5.Ejercicio1.Vertice;
import TP5.Ejercicio2.Recorridos;

public class Main {
    
    public static void main(String[] args) {
        // Crear un grafo con capacidad para 5 vertices
        AdyacenciaMatrizGrafo<String> grafo = new AdyacenciaMatrizGrafo<>(5);

        // Crear vertices
        Vertice<String> v1 = grafo.crearVertice("A");
        Vertice<String> v2 = grafo.crearVertice("B");
        Vertice<String> v3 = grafo.crearVertice("C");

        System.out.println("Vertices creados:");
        System.out.println("Vertice 1: " + v1.obtenerDato() + " en posicion " + v1.obtenerPosicion());
        System.out.println("Vertice 2: " + v2.obtenerDato() + " en posicion " + v2.obtenerPosicion());
        System.out.println("Vertice 3: " + v3.obtenerDato() + " en posicion " + v3.obtenerPosicion());

        // Conectar vértices
        grafo.conectar(v1, v2, 10);
        grafo.conectar(v1, v3, 5);

        System.out.println("\nAristas despues de conectar:");
        if (grafo.existeArista(v1, v2)) {
            System.out.println("Existe una arista entre " + v1.obtenerDato() + " y " + v2.obtenerDato() + " con peso: " + grafo.peso(v1, v2));
        }
        if (grafo.existeArista(v1, v3)) {
            System.out.println("Existe una arista entre " + v1.obtenerDato() + " y " + v3.obtenerDato() + " con peso: " + grafo.peso(v1, v3));
        }

        // Desconectar vertices
        grafo.desconectar(v1, v2);
        System.out.println("\nAristas despues de desconectar:");
        if (!grafo.existeArista(v2, v1)) {
            System.out.println("No existe una arista entre " + v1.obtenerDato() + " y " + v2.obtenerDato());
        }
        
        // Buscar un vertice
        Vertice<String> verticeBuscado = grafo.buscar("B");
        if (verticeBuscado != null) {
            System.out.println("\nVertice encontrado: " + verticeBuscado.obtenerDato());
        } else {
            System.out.println("\nVertice no encontrado");
        }

        // Eliminar un vertice
        grafo.eliminarVertice(v1);
        System.out.println("\nVertices despues de eliminar el vertice A:");
        for (Vertice<String> vertice : grafo.obtenerVertices()) {
            System.out.println("Vertice: " + vertice.obtenerDato());
        }

        // Verificar si el grafo esta vacio
        System.out.println("\nEl grafo esta vacio: " + grafo.estaVacio());

        // Obtener lista de vertices
        System.out.println("\nLista de vertices actuales en el grafo:");
        for (Vertice<String> vertex : grafo.obtenerVertices()) {
            System.out.println("Vertice: " + vertex.obtenerDato());
        }
        
    }
    
}
