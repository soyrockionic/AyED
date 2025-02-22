package TP5.Ejercicio2;

import TP5.Ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import TP5.Ejercicio1.Vertice;
import TP5.Ejercicio3.Mapa;

public class Main {
    
    public static void main(String[] args) throws IllegalAccessException {
        
        // Crear un grafo con capacidad para 8 vertices
        //AdyacenciaMatrizGrafo<String> grafo = new AdyacenciaMatrizGrafo<>(8);
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo<>();
        
        // Crear vertices
        Vertice<String> v1 = grafo.crearVertice("Buenos Aires");
        Vertice<String> v2 = grafo.crearVertice("Santiago");
        Vertice<String> v3 = grafo.crearVertice("Asuncion");
        Vertice<String> v4 = grafo.crearVertice("Caracas");
        Vertice<String> v5 = grafo.crearVertice("Madrid");
        Vertice<String> v6 = grafo.crearVertice("Roma");       
        Vertice<String> v7 = grafo.crearVertice("Paris");
        Vertice<String> v8 = grafo.crearVertice("Tokio");
        
        grafo.conectar(v1, v4, 28);        
        grafo.conectar(v1, v2, 18);
        grafo.conectar(v4, v5, 32);
        grafo.conectar(v4, v6, 36);
        grafo.conectar(v4, v8, 42);
        grafo.conectar(v2, v3, 22);
        grafo.conectar(v5, v6, 10);
        grafo.conectar(v8, v7, 34);
        grafo.conectar(v3, v8, 38);
        grafo.conectar(v6, v7, 29);
        
        /*Recorridos r = new Recorridos();
        System.out.println(r.bfs(grafo));*/
        
        Mapa mapa = new Mapa(grafo);
        System.out.println("Ciudades que atravezamos hasta destino:");
        System.out.println(mapa.devolverCamino(v1.obtenerDato(), v7.obtenerDato()));
        System.out.println("Camino mas corto hasta destino:");
        System.out.println(mapa.caminoMasCortoDFS(v1.obtenerDato(), v7.obtenerDato()));
        System.out.println("Camino sin cargar combusstible:");
        System.out.println(mapa.caminoSinCargarCombustible(v1.obtenerDato(), v7.obtenerDato(), 100));
        System.out.println("Camino con menor carga de combustible:");
        System.out.println(mapa.caminoConMenorCargaDeCombustible(v1.obtenerDato(), v6.obtenerDato(), 50));
        
    }
    
}
