package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import tp5.ejercicio1.Vertex;

public class Main {
    
    public static void main(String[] args) {
        
        AdyacenciaListaGrafo<String> grafo = new AdyacenciaListaGrafo <> ();
        
        Vertex<String> v1 = grafo.createVertex("Holmenkollen");
        Vertex<String> v2 = grafo.createVertex("Parque Vigeland");
        Vertex<String> v3 = grafo.createVertex("Galeria Nacional");
        Vertex<String> v4 = grafo.createVertex("Parque Botanico");
        Vertex<String> v5 = grafo.createVertex("Museo Munch");
        Vertex<String> v6 = grafo.createVertex("FolkMuseum");
        Vertex<String> v7 = grafo.createVertex("Palacio Real");
        Vertex<String> v8 = grafo.createVertex("Ayuntamiento");
        Vertex<String> v9 = grafo.createVertex("El Tigre");
        Vertex<String> v10 = grafo.createVertex("Akker Brigge");
        Vertex<String> v11 = grafo.createVertex("Museo Fram");
        Vertex<String> v12 = grafo.createVertex("Museo Vikingo");
        Vertex<String> v13 = grafo.createVertex("La Opera");
        Vertex<String> v14 = grafo.createVertex("Museo del Barco Polar");
        Vertex<String> v15 = grafo.createVertex("Fortaleza Akershus");
        
        grafo.connect(v1, v2, 30);
        grafo.connect(v2, v1, 30);        
        grafo.connect(v2, v3, 10);
        grafo.connect(v3, v2, 10);       
        grafo.connect(v2, v6, 20);
        grafo.connect(v6, v2, 20);       
        grafo.connect(v3, v4, 15);
        grafo.connect(v4, v3, 15);      
        grafo.connect(v4, v8, 10);
        grafo.connect(v8, v4, 10);       
        grafo.connect(v4, v5, 1);
        grafo.connect(v5, v4, 1);       
        grafo.connect(v5, v9, 15);
        grafo.connect(v9, v5, 15);     
        grafo.connect(v8, v7, 5);
        grafo.connect(v7, v8, 5);     
        grafo.connect(v8, v10, 20);
        grafo.connect(v10, v8, 20);       
        grafo.connect(v8, v9, 15);
        grafo.connect(v9, v8, 15);       
        grafo.connect(v7, v6, 5);
        grafo.connect(v6, v7, 5);      
        grafo.connect(v6, v10, 30);
        grafo.connect(v10, v6, 30);      
        grafo.connect(v6, v11, 5);
        grafo.connect(v11, v6, 5);       
        grafo.connect(v11, v14, 5);
        grafo.connect(v14, v11, 5);   
        grafo.connect(v14, v12, 5);
        grafo.connect(v12, v14, 5);       
        grafo.connect(v12, v10, 30);
        grafo.connect(v10, v12, 30);     
        grafo.connect(v9, v13, 5);
        grafo.connect(v13, v9, 5);      
        grafo.connect(v13, v15, 10);
        grafo.connect(v15, v13, 10);
        
        List<String> ciudades = new LinkedList <> ();
        ciudades.add(v10.getData());
        ciudades.add(v7.getData());
        
        VisitaOslo visita = new VisitaOslo ();
        
        System.out.println(visita.paseoEnBici(grafo, v12.getData(), 120, ciudades));
        
    }
    
}