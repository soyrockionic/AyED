package tp3.ejercicio1;

/*
Implemente en la clase ParcialArboles, que tiene como variable de instancia un
GeneralTree<Integer>, el metodo: List<Integer> resolver () que devuelve en la lista la suma
de los datos contenidos en los nodos de arbol que tienen un numero impar de hijos. Realice
un recorrido postOrden.

Ejemplo:

    7
    ├─ 75
    │   ├─ 5
    │   └─ 43
    │       ├─ 12
    │       └─ 11
    └─ 2
        └─ 8
            ├─ 3
            ├─ 30
            └─ 23

- La suma para el arbol de raiz 8 es 56
- La suma para el arbol de raiz 2 es 8

Entonces la lista contendra los valores: 56, 8 (Ya que se deben recorrer en post orden)

- Debe respetar la clase y el metodo indicado
- Puede definir todos los metodos y variables auxiliares que considere
- Todo aquel metodo que no este definido en la practicas debe ser implementado
*/

import java.util.ArrayList;
import java.util.List;

public class ParcialArbolesDos {
    
    private GeneralTree<Integer> arbol = new GeneralTree<>();
    
    public ParcialArbolesDos (GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> resolver () {
        List<Integer> sumas = new ArrayList<>();
        calcularSumas(arbol,sumas);
        return sumas;
    }
    
    private void calcularSumas (GeneralTree<Integer> arbol, List<Integer> sumas) {
        if (arbol == null || arbol.isEmpty()) return;
        
        for (GeneralTree<Integer> hijo : arbol.getChildren()) {
           calcularSumas(hijo, sumas);
        }
       
        if (arbol.getChildren().size() % 2 == 1) {
            Integer suma = 0;
            for (int i=0; i<arbol.getChildren().size(); i++)
                suma += arbol.getChildren().get(i).getData();
            sumas.add(suma);
        }  
        
    }
    
}