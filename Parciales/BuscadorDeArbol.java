package tp3.ejercicio1;

/*
Dada una clase denominada BuscadorDeArbol, que tiene como variable de instancia
un ArbolGeneral<Integer> denominado arbol implemente en dicha clase el metodo:
public Integer buscarMayorEnPostOrden() que debe retornar el elemento mayor.

Ejemplo en el siguiente arbol debe retornar el 22.

2
=> 7
    => 4
    => 6
=> 5
    => 9
=> 22
    => 20
    => 3

- Debe respetar la clase y el metodo indicado.
- Puede definir todos los metodos y variables auxiliares que considere.
- Todo metodo que no este definido en las practicas debe ser implementado.
- Respetar el recorrido solicitado.
*/

public class BuscadorDeArbol {
    
    private GeneralTree<Integer> arbol = new GeneralTree<>();
    
    public BuscadorDeArbol (GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public Integer buscarMayorEnPostOrden() {
        return buscarMaximo(arbol);
    }
    
    private Integer buscarMaximo (GeneralTree<Integer> nodo) {
        if (nodo == null || nodo.isEmpty()) return null;
        
        Integer max = nodo.getData();
        
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            Integer maxActual = buscarMaximo(hijo);
            if (maxActual != null && maxActual > max) {
                max = maxActual;
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        
        GeneralTree<Integer> arbol = new GeneralTree<>(2);
        
        GeneralTree<Integer> hijo1 = new GeneralTree<>(7);
        GeneralTree<Integer> hijo2 = new GeneralTree<>(5);
        GeneralTree<Integer> hijo3 = new GeneralTree<>(22);
        
        arbol.addChild(hijo1);
        arbol.addChild(hijo2);
        arbol.addChild(hijo3);
        
        GeneralTree<Integer> bisnieto1 = new GeneralTree<>(4);
        GeneralTree<Integer> bisnieto2 = new GeneralTree<>(6);
        
        hijo1.addChild(bisnieto1);
        hijo1.addChild(bisnieto2);
        
        GeneralTree<Integer> bisnieto3 = new GeneralTree<>(9);
        
        hijo2.addChild(bisnieto3);
        
        GeneralTree<Integer> bisnieto4 = new GeneralTree<>(20);
        GeneralTree<Integer> bisnieto5 = new GeneralTree<>(3);
        
        hijo3.addChild(bisnieto4);
        hijo3.addChild(bisnieto5);
        
        BuscadorDeArbol bda = new BuscadorDeArbol(arbol);
        System.out.println(bda.buscarMayorEnPostOrden());
        
    }
    
}
