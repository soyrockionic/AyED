package tp3.ejercicio1;

/*
Implemente en la clase ParcialArboles un metodo que reciba un arbol general de enteros
y retorne una lista con valores mayores a un valor recibido por parametro. Para cada valor
retornar el nivel en el que se encuentra. Considere que el arbol podria estar vacio, que
ningun elemento del arbol o todos los elementos del arbol podrian cumplir condicion.
Realice un recorrido inOrden.

El metodo debe tener la siguiente firma: resolver (int valor, GeneralTree<Intege> arbol).

Ejemplo:

7
=> 5
     => 9
          => 19
=> 12
     => 23
     => 8
     => 30

Si el valor es 9, la lista deberia contener: [19 nivel 3, 23 nivel 2, 12 nivel 1, 30 nivel 2]
*/

import java.util.LinkedList;
import java.util.List;

public class ParcialArbolesFive {
    
    private class InfoNodo {
        private int valor;
        private int nivel;
        
        public InfoNodo (int valor, int nivel) {
            this.valor = valor;
            this.nivel = nivel;
        }
        
        public int getValor () {
            return this.valor;
        }
        
        public int getNivel () {
            return this.nivel;
        }
        
        public String toString () {
            return valor + " nivel " + nivel;
        }
        
    }
    
    public List<InfoNodo> resolver (int valor, GeneralTree<Integer> arbol) {
        List<InfoNodo> valores = new LinkedList<>();
        buscarValores(valor,arbol,valores, 0);
        return valores;
    }
    
    private void buscarValores (int valor, GeneralTree<Integer> nodo, List<InfoNodo> valores, int nivel) {
        if (nodo == null || nodo.isEmpty()) return;
        
        if (nodo.hasChildren()) {
             buscarValores(valor,nodo.getChildren().get(0),valores,nivel+1);
        }
        
        if (nodo.getData() > valor) {
            InfoNodo dato = new InfoNodo (nodo.getData(), nivel);
            valores.add(dato);
        }
        
        for (int i=1; i<nodo.getChildren().size(); i++) {         
            buscarValores(valor,nodo.getChildren().get(i),valores,nivel+1);         
        }
        
    }
    
    public static void main(String[] args) {
        
        GeneralTree<Integer> ab = new GeneralTree<>(7);
        
        GeneralTree<Integer> ab1 = new GeneralTree<>(5);
        GeneralTree<Integer> ab2 = new GeneralTree<>(12);
        
        ab.addChild(ab1);
        ab.addChild(ab2);
        
        GeneralTree<Integer> ab1_2 = new GeneralTree<>(9);
        
        ab1.addChild(ab1_2);
        
        GeneralTree<Integer> ab2_1 = new GeneralTree<>(23);
        GeneralTree<Integer> ab2_2 = new GeneralTree<>(8);
        GeneralTree<Integer> ab2_3 = new GeneralTree<>(30);
        
        ab2.addChild(ab2_1);
        ab2.addChild(ab2_2);
        ab2.addChild(ab2_3);
        
        GeneralTree<Integer> ab1_2_1 = new GeneralTree<>(19);
        
        ab1_2.addChild(ab1_2_1);
        
        ParcialArbolesFive p = new ParcialArbolesFive();
        System.out.println(p.resolver(9, ab));
        
    }
    
}
