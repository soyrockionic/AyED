package TP3.Ejercicio1;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

    public GeneralTree() {
        }
    
    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }
        
    //retorna el dato almacenado en la raiz del arbol
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //retorna la lista de hijos de la raiz del arbol.
    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }
	
    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }
	
    //agrega un hijo al final de la lista de hijos del arbol
    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }
	
    //devuelve verdadero si la lista de hijos del árbol no es null y tampoco es vacia
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }
	
    //devuelve verdadero si el dato del arbol es null y ademas no tiene hijos.
    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    //elimina del arbol el hijo pasado como parametro.
    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }
    
    @Override
    public String toString() {
        return data != null ? data.toString() : "null";
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
        return buscarNivel(dato, 0);
    }

    private int buscarNivel(T dato, int nivelActual) {
        // Verifica si el dato en la raiz es el que estamos buscando
        if (this.data != null && this.data.equals(dato)) {
            return nivelActual;
        }
        // Recorre los hijos del arbol y busca el dato en cada uno
        for (GeneralTree<T> child : children) {
            int nivelEncontrado = child.buscarNivel(dato, nivelActual + 1);
            if (nivelEncontrado != -1) {
                return nivelEncontrado;
            }
        }
        return -1; // Si no se encontro el dato, retorna -1
    }

    public int ancho() throws IllegalAccessException {
        if (this.isEmpty()) return 0;

        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        int maxAncho = 0;

        while (!cola.isEmpty()) {
            int nodosEnEsteNivel = cola.size();
            maxAncho = Math.max(maxAncho, nodosEnEsteNivel);

            // Procesar exactamente los nodos del nivel actual
            for (int i = 0; i < nodosEnEsteNivel; i++) {
                GeneralTree<T> actual = cola.dequeue();
                // Encolar hijos para el siguiente nivel
                for (GeneralTree<T> hijo : actual.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
        }
        return maxAncho;
    }
    
    
    public boolean esAncestro(T a, T b) {
        // Si el nodo actual es 'a', debemos buscar si 'b' es descendiente de 'a'
        if (this.getData().equals(a)) {
            if (this.getData().equals(b)) return false;
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
        if (this.getData().equals(b)) {
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
