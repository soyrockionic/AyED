package TP3.Ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeneralTree<T> {
    private T dato;
    private List<GeneralTree<T>> children;
    
    public GeneralTree (){      
    }

    // Constructor que inicializa el arbol con un dato y sin hijos.
    public GeneralTree(T dato) {
        this.dato = dato;
        this.children = new ArrayList<>();
    }

    // Constructor que inicializa el arbol con un dato y una lista de hijos.
    public GeneralTree(T dato, List<GeneralTree<T>> children) {
        this.dato = dato;
        this.children = children != null ? children : new ArrayList<>();
    }

    // Metodo que retorna el dato almacenado en la raíz del arbol.
    public T obtenerDato() {
        return dato;
    }

    // Metodo que retorna la lista de hijos de la raíz del arbol.
    public List<GeneralTree<T>> getChildren() {
        return children;
    }

    // Metodo que agrega un hijo al final de la lista de hijos.
    public void addChild(GeneralTree<T> child) {
        children.add(child);
    }

    // Metodo que elimina un hijo pasado como parametro de la lista de hijos.
    public void removeChild(GeneralTree<T> child) {
        children.remove(child);
    }

    // Metodo que verifica si el arbol tiene hijos.
    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    // Metodo que verifica si el arbol esta vacio.
    public boolean estaVacio() {
        return dato == null && (children == null || children.isEmpty());
    }
    
    public int altura() {
        if (children == null || children.isEmpty()) {
            return 0; // Si no hay hijos, la altura es 0
        }
        int maxAltura = 0;
        for (GeneralTree<T> child : children) {
            maxAltura = Math.max(maxAltura, child.altura());
        }
        return maxAltura + 1; // Se suma 1 para contar el nodo actual
    }
    
    public int nivel(T dato) {
        return nivelRecursivo(dato, 0);
    }

    private int nivelRecursivo(T dato, int nivelActual) {
        // Verifica si el dato en la raiz es el que estamos buscando
        if (this.dato != null && this.dato.equals(dato)) {
            return nivelActual;
        }
        // Recorre los hijos del arbol y busca el dato en cada uno
        for (GeneralTree<T> child : children) {
            int nivelEncontrado = child.nivelRecursivo(dato, nivelActual + 1);
            if (nivelEncontrado != -1) {
                return nivelEncontrado;
            }
        }
        return -1; // Si no se encontro el dato, retorna -1
    }
    
    public int ancho() {
        if (this == null) return 0;

        // Cola para el recorrido por niveles
        Queue<GeneralTree<T>> queue = new LinkedList<>();
        queue.add(this);

        int maxAncho = 0;

        while (!queue.isEmpty()) {
            int nivelSize = queue.size(); // Número de nodos en el nivel actual
            maxAncho = Math.max(maxAncho, nivelSize);

            for (int i = 0; i < nivelSize; i++) {
                GeneralTree<T> currentNode = queue.poll();
                for (GeneralTree<T> child : currentNode.getChildren()) {
                    queue.add(child);
                }
            }
        }
        return maxAncho;
    }
    
    public boolean esAncestro(T a, T b) {
        // Si el nodo actual es 'a', debemos buscar si 'b' es descendiente de 'a'
        if (this.obtenerDato().equals(a)) {
            return contieneValor(b);
        }      
        // Si 'a' no es el nodo actual, buscar en los hijos
        for (GeneralTree<T> child : children) {
            if (child.esAncestro(a, b)) {
                return true;
            }
        }       
        return false;
    }

    private boolean contieneValor(T b) {
        // Si el valor actual es 'b', entonces 'b' es encontrado y retornamos true
        if (this.obtenerDato().equals(b)) {
            return true;
        }     
        // Si no es 'b', verificamos en los hijos si alguno tiene el valor 'b'
        for (GeneralTree<T> child : children) {
            if (child.contieneValor(b)) {
                return true;
            }
        }      
        return false;
    }
    
}