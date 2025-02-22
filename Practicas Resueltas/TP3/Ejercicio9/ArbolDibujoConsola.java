package TP3.Ejercicio9;

import TP3.Ejercicio1.GeneralTree;
import java.util.List;

public class ArbolDibujoConsola<T> {
    private GeneralTree<T> arbol;

    public ArbolDibujoConsola(GeneralTree<T> arbol) {
        this.arbol = arbol;
    }

    // Método que inicia el dibujo del árbol
    public void dibujarArbol() {
        if (arbol != null) {
            dibujarNodo(arbol, "", true);
        } else {
            System.out.println("El arbol está vacio.");
        }
    }

    // Método recursivo para dibujar cada nodo
    private void dibujarNodo(GeneralTree<T> nodo, String prefijo, boolean esUltimo) {
        // Imprimir el nodo con las conexiones
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.obtenerDato());

        // Construir prefijo para los hijos
        String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");

        // Dibujar los hijos del nodo
        List<GeneralTree<T>> hijos = nodo.getChildren();
        for (int i = 0; i < hijos.size(); i++) {
            dibujarNodo(hijos.get(i), nuevoPrefijo, i == hijos.size() - 1);
        }
    }

}


