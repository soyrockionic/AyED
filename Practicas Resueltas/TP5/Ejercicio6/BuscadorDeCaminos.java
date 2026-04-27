package TP5.Ejercicio6;

import TP5.Ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import TP5.Ejercicio1.Arista;
import TP5.Ejercicio1.Grafo;
import TP5.Ejercicio1.Vertice;
import java.util.LinkedList;
import java.util.List;

public class BuscadorDeCaminos {
    private Grafo bosque; // Asumiendo que Grafo es una clase que representa el grafo
    
    public BuscadorDeCaminos(Grafo<String> bosque){
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro() {
        List<List<String>> recorridos = new LinkedList<>();
        if(!this.bosque.estaVacio()) {
            Vertice Caperucita = this.bosque.buscar("Casa Caperucita");
            if(Caperucita != null)
                this.dfs(Caperucita, recorridos, new LinkedList<String>(), new boolean[this.bosque.obtenerTamaño()]);
        }
        return recorridos;
    }
    
    private void dfs(Vertice<String> origen, List<List<String>> recorridos, List<String> camAct, boolean[] marcas) {
        marcas[origen.obtenerPosicion()] = true;
        camAct.add(origen.obtenerDato());
        if(origen.obtenerDato().equals("Casa Abuelita")) 
            recorridos.add(new LinkedList<>(camAct));
        else {
            List<Arista<String>> adys = this.bosque.obtenerAristas(origen);
            for(Arista<String> a: adys) {
                Vertice<String> destino = a.obtenerDestino();
                if(!marcas[destino.obtenerPosicion()] && a.obtenerPeso() < 5) 
                    dfs(destino, recorridos, camAct, marcas);
            }
        }
        marcas[origen.obtenerPosicion()] = false;
        camAct.remove(camAct.size()-1);
    }
    
    public static void main(String[] args) throws IllegalAccessException {
        
        Grafo<String> bosque = new AdyacenciaListaGrafo<>();
        
        Vertice v1 = bosque.crearVertice("Casa Caperucita");
        Vertice v2 = bosque.crearVertice("Claro 1");
        Vertice v3 = bosque.crearVertice("Claro 2");
        Vertice v4 = bosque.crearVertice("Claro 3");
        Vertice v5 = bosque.crearVertice("Claro 4");
        Vertice v6 = bosque.crearVertice("Claro 5");
        Vertice v7 = bosque.crearVertice("Casa Abuelita");
        
        bosque.conectar(v1, v2, 3);  // Casa Caperucita - Claro 1
        bosque.conectar(v1, v3, 4);  // Casa Caperucita - Claro 2
        bosque.conectar(v1, v4, 4);  // Casa Caperucita - Claro 4       
        bosque.conectar(v2, v6, 3);  // Claro 1 - Claro 5       
        bosque.conectar(v3, v2, 4);  // Claro 2 - Claro 1     
        bosque.conectar(v3, v5, 10); // Claro 2 - Claro 4 (se ignora por frutales >= 5)
        bosque.conectar(v3, v6, 11); // Claro 2 - Claro 5       
        bosque.conectar(v4, v6, 15); // Claro 3 - Claro 5 (se ignora por frutales >= 5)
        bosque.conectar(v5, v7, 9);  // Claro 4 - Casa Abuelita (se ignora por frutales >= 5)       
        bosque.conectar(v6, v7, 4);  // Claro 5 - Casa Abuelita
        
        // Medir el tiempo de inicio
        long tiempoInicio3 = System.nanoTime();
        BuscadorDeCaminos caminos = new BuscadorDeCaminos(bosque);
        System.out.println("Caminos mas seguros con dfs:");
        //System.out.println(caminos.recorridosMasSeguro());
        for(List<String> a: caminos.recorridosMasSeguro()){
            System.out.println(a);          
        }
        // Medir el tiempo de finalización
        long tiempoFin3 = System.nanoTime();
        
        // Medir el tiempo de inicio
        long tiempoInicio2 = System.nanoTime();
        System.out.println("Camino mas corto con Dijksta:");
        BuscadorConDijkstra dijkstra = new BuscadorConDijkstra(bosque);
        System.out.println(dijkstra.recorridoMasSeguroConDijkstra());
        // Medir el tiempo de finalización
        long tiempoFin2 = System.nanoTime(); 
        
        // Medir el tiempo de inicio
        long tiempoInicio4 = System.nanoTime();
        System.out.println("Camino mas corto con Floyd-Warshall:");
        BuscadorFloydWarshall floyd = new BuscadorFloydWarshall(bosque);
        System.out.println(floyd.caminoMasCorto());
        // Medir el tiempo de finalización
        long tiempoFin4 = System.nanoTime();
        
        System.out.println("------------------------------------------------------------");
        // Calcular el tiempo transcurrido
        long tiempoTotal3 = tiempoFin3 - tiempoInicio3;
        System.out.println("Tiempo algoritmo dfs: " + tiempoTotal3 / 1_000_000_000.0 + " segundos");
    
        // Calcular el tiempo transcurrido
        long tiempoTotal2 = tiempoFin2 - tiempoInicio2;
        System.out.println("Tiempo algoritmo dijkstra: " + tiempoTotal2 / 1_000_000_000.0 + " segundos");
        
        long tiempoTotal4 = tiempoFin4 - tiempoInicio4;
        System.out.println("Tiempo algoritmo floyd-warshall: " + tiempoTotal4 / 1_000_000_000.0 + " segundos");
        System.out.println("------------------------------------------------------------");
        
        System.out.println("Grafo conexiones de los vertices:");
        imprimirGrafo(bosque);
        
    }
    
    public static void imprimirGrafo(Grafo<String> bosque) {
        for (Vertice<String> vertice : bosque.obtenerVertices()) {
            System.out.print(vertice.obtenerDato() + " -> ");
            List<Arista<String>> aristas = bosque.obtenerAristas(vertice);
            if (aristas.isEmpty()) {
                System.out.println("No hay conexiones.");
            } else {
                for (Arista<String> arista : aristas) {
                    Vertice<String> destino = arista.obtenerDestino();
                    int peso = arista.obtenerPeso();
                    System.out.print(destino.obtenerDato() + " (" + peso + "), ");
                }
                System.out.println();
            }
        }
    }

    
}

