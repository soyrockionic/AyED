package tp3.ejercicio1;

/*
Dado un arbol genera compuesto por personajes, donde puede haber dragones,
princesas y otros, se denominan nodos asesinos a aquellos nodo tales quue a lo
largo del camino del nodo raiz del arbol hasta el nodo (ambos inclusive) no se
encuenntra ningun dragon.

Implementar un metodo que devuelva una lista con un camino desde la raiz a
una princesa sin pasar por un dragon, sin necesidad de ser el mas cercano a la raiz.
Asuma que existe al menos un camino accesible.

Animal Coyote
    |─ Animal Scooby
    |
    |─ Dragon Negro
    |   |─ Princesa Cenicienta
    |   |─ Dragon Rojo
    |   |─ Animal Pluto
    |
    |─ Animal Cid
        |─ Princesa La Bella
        |─ Animal Tweety
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncontrarALaPrincesa {
    
    private static class Personaje {
        private String tipo;
        private String nombre;
        
        public Personaje (String tipo, String nombre) {
            this.tipo = tipo;
            this.nombre = nombre;
        }
        
        public String getTipo () {
            return this.tipo;
        }
        
        public String getNombre () {
            return this.nombre;
        }
        
        public String toString () {
            return this.tipo + " " + this.nombre;
        }
        
    }
    
    private GeneralTree<Personaje> arbol = new GeneralTree<>();
    
    public EncontrarALaPrincesa (GeneralTree<Personaje> arbol) {
        this.arbol = arbol;
    }
    
    public List<Personaje> caminoPrincesaSinDragon() {
        List<Personaje> camino = new ArrayList<>();
        buscarRuta(arbol, camino);
        Collections.reverse(camino);
        return camino;
    }
    
    private boolean buscarRuta (GeneralTree<Personaje> nodo, List<Personaje> ruta) {
        if(nodo == null || nodo.isEmpty()) return false;
        
        if (nodo.getData().getTipo().equals("Dragon")) {
            return false;
        }
        
        if (nodo.getData().getTipo().equals("Princesa")) {
            ruta.add(nodo.getData());
            return true;
        }
        
        for (GeneralTree<Personaje> hijo : nodo.getChildren()) {
            if (buscarRuta(hijo,ruta)) {
                ruta.add(nodo.getData());
                return true;
            } 
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        Personaje p1 = new Personaje("Animal","Coyote");
        GeneralTree<Personaje> arbol = new GeneralTree<>(p1);
        
        Personaje p2 = new Personaje("Animal","Scooby"); 
        GeneralTree<Personaje> hijo1 = new GeneralTree<>(p2);
        
        Personaje p3 = new Personaje("Dragon","Negro");     
        GeneralTree<Personaje> hijo2 = new GeneralTree<>(p3);
        
        Personaje p4 = new Personaje("Animal","Cid");      
        GeneralTree<Personaje> hijo3 = new GeneralTree<>(p4);
        
        arbol.addChild(hijo1);
        arbol.addChild(hijo2);
        arbol.addChild(hijo3);
        
        Personaje p5 = new Personaje("Princesa","Cenicienta");
        GeneralTree<Personaje> nieto1 = new GeneralTree<>(p5);
        
        Personaje p6 = new Personaje("Dragon","Rojo");
        GeneralTree<Personaje> nieto2 = new GeneralTree<>(p6);
        
        Personaje p7 = new Personaje("Animal","Pluto");
        GeneralTree<Personaje> nieto3 = new GeneralTree<>(p7);
        
        hijo2.addChild(nieto1);
        hijo2.addChild(nieto2);
        hijo2.addChild(nieto3);
        
        Personaje p8 = new Personaje("Princesa","La Bella");
        GeneralTree<Personaje> nieto4 = new GeneralTree<>(p8);
        
        Personaje p9 = new Personaje("Animal","Tweety");
        GeneralTree<Personaje> nieto5 = new GeneralTree<>(p9);
        
        hijo3.addChild(nieto4);
        hijo3.addChild(nieto5);
        
        EncontrarALaPrincesa busca = new EncontrarALaPrincesa (arbol);
        System.out.println(busca.caminoPrincesaSinDragon());
        
    }
    
}