package TP5.Ejercicio1;

import TP5.Ejercicio1.AdyacenciaLista.AdyacenciaListaGrafo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class AdyListaGrafoTest {
        private AdyacenciaListaGrafo<String> grafo;
        private Vertice<String> vert1, vert2, vert3;

        @Before
        public void setUp() {
               grafo = new AdyacenciaListaGrafo<>();
               vert1 = grafo.crearVertice("A");
               vert2 = grafo.crearVertice("B");
               vert3 = grafo.crearVertice("C");
        }

        @Test
        public void testCrearVertice() {
               // Verificar que los vertices fueron creados correctamente
               assertEquals(3, grafo.obtenerTamaño());
               assertEquals("A", vert1.obtenerDato());
               assertEquals("B", vert2.obtenerDato());
               assertEquals("C", vert3.obtenerDato());
        }

        @Test
        public void testConectarYExisteArista() {
               // Conectar dos vertices y verificar si la arista existe
               grafo.conectar(vert1, vert2);
               grafo.conectar(vert2, vert3);

               assertTrue(grafo.existeArista(vert1, vert2));
               assertTrue(grafo.existeArista(vert2, vert3));
               assertFalse(grafo.existeArista(vert1, vert3));
        }

        @Test
        public void testEliminarVertice() {
               // Eliminar un vertice y comprobar si fue removido correctamente
               grafo.eliminarVertice(vert2);
               assertEquals(2, grafo.obtenerTamaño());
               assertNull(grafo.buscar("B")); // Buscar el vertice eliminado
        }

        @Test
        public void testObtenerAristas() {
               // Conectar vertices y verificar las aristas
               grafo.conectar(vert1, vert2, 5);
               grafo.conectar(vert1, vert3, 10);

               List<Arista<String>> adyacentes = grafo.obtenerAristas(vert1);
               assertEquals(2, adyacentes.size());
               assertTrue(vert2.equals(adyacentes.get(0).obtenerDestino()) 
                               || vert3.equals(adyacentes.get(0).obtenerDestino()));
               assertTrue(vert2.equals(adyacentes.get(1).obtenerDestino()) 
                               || vert3.equals(adyacentes.get(1).obtenerDestino()));
               }

        @Test
        public void testPeso() {
               // Conectar vertices con pesos y verificar el peso de la arista
               grafo.conectar(vert1, vert2, 7);
               grafo.conectar(vert1, vert3, 12);

               assertEquals(7, grafo.peso(vert1, vert2));
               assertEquals(12, grafo.peso(vert1, vert3));
               assertEquals(0, grafo.peso(vert2, vert3)); // No hay arista entre vert2 y vert3
        }
        
}
