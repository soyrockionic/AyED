package TP3.Ejercicio4;

import TP3.Ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    
    public static void imprimirPorNiveles(GeneralTree<AreaEmpresa> a) {
        if (a == null || a.estaVacio()) {return;}

        Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size(); // Numero de nodos en el nivel actual
            while (nivelSize > 0) {
                GeneralTree<AreaEmpresa> nodoActual = cola.poll();
                System.out.print(nodoActual.obtenerDato() + " ");
                // Agregar todos los hijos del nodo actual a la cola
                cola.addAll(nodoActual.getChildren());
                nivelSize--;
            }
            System.out.println(); // Salto de linea despues de cada nivel
        }
    }
    
    public static void main(String[] args) {
        // Crear instancias de AreaEmpresa
        AreaEmpresa a = new AreaEmpresa("CEO", 14);
        AreaEmpresa b = new AreaEmpresa("CTO", 15);
        AreaEmpresa c = new AreaEmpresa("CFO", 23);
        AreaEmpresa d = new AreaEmpresa("COO", 10);
        AreaEmpresa e = new AreaEmpresa("Dev Team", 4);
        AreaEmpresa f = new AreaEmpresa("Finance Team", 7);
        AreaEmpresa h = new AreaEmpresa("RRHH",6);
        AreaEmpresa k = new AreaEmpresa("Lab",10);
        AreaEmpresa q = new AreaEmpresa("ADP",9);
        AreaEmpresa r = new AreaEmpresa("ADR",12);

        // Crear el arbol general
        GeneralTree<AreaEmpresa> arbol = new GeneralTree<>(a);
        GeneralTree<AreaEmpresa> hijo1 = new GeneralTree<>(b);
        arbol.addChild(hijo1);
        GeneralTree<AreaEmpresa> hijo2 = new GeneralTree<>(c);
        arbol.addChild(hijo2);
        GeneralTree<AreaEmpresa> hijo3 = new GeneralTree<>(d);
        arbol.addChild(hijo3);
        GeneralTree<AreaEmpresa> nieto1 = new GeneralTree<>(e);
        hijo1.addChild(nieto1);
        GeneralTree<AreaEmpresa> nieto2 = new GeneralTree<>(f);
        hijo1.addChild(nieto2);
        GeneralTree<AreaEmpresa> nieto4 = new GeneralTree<>(h);
        hijo2.addChild(nieto4);
        GeneralTree<AreaEmpresa> nieto5 = new GeneralTree<>(k);
        hijo2.addChild(nieto5);
        GeneralTree<AreaEmpresa> nieto7 = new GeneralTree<>(q);
        hijo3.addChild(nieto7);
        GeneralTree<AreaEmpresa> nieto8 = new GeneralTree<>(r);
        hijo3.addChild(nieto8);

        // Crear instancia de AnalizadorArbol y calcular el máximo promedio
        AnalizadorArbol analizador = new AnalizadorArbol();
        double maximoPromedio = analizador.devolverMaximoPromedio(arbol);
        
        System.out.println("Arbol: ");
        imprimirPorNiveles(arbol);
        System.out.println("------------------------------------------");
        // Imprimir el resultado
        System.out.println("El maximo promedio de los niveles es: " + maximoPromedio);
        System.out.println("------------------------------------------");
        
    }
    
    
}
