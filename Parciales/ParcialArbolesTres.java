package tp3.ejercicio1;

/*
Defina una clase ParcialArboles con: i) una unica variable de instancia tipo ArbolGeneral
de enteros, y ii) un metodo publico con la siguiente firma: public List<Integer> camino (int num).
El metodo debe devolver un camino desde la raiz una hoja en donde cada nodo (no hoja)
tenga al menos la cantidad num de hijos. Debe retornar el primer camino que encuentre
que cumple la condicion. En caso de no encontrar ninguno debe retornar la lista vacia.
Por ejemplo con un arbol como se muestra a continuacion:

    10
    ├─ 8
    │   ├─ 5
    │   │   └─ -6
    │   └─ 22
    │       ├─ 28
    │       ├─ 55
    │       └─ 18
    ├─ 42
    └─ -5
        ├─ 19
        │   └─ 4
        └─ -9

Si num = 2 debe retornar: 10, 8, 22, 28
Si num = 3 debe retornar: 10, 42
si num = 4 debe retornar  la lista vacia

Tenga en cuenta que:
- No puede agregar mas variables de instancia ni de clase en la clase ParcialArboles.
- Debe respetar la clase y la firma del metodo indicado.
- Puede definir todos los metodos y variables locales que considere necesarios.
- Todo metodo que no este definido en la sinopsis de las clases debe sr implementado.
- Debe recorrer la estructura solo una vez para resolverlo.
- Si durante el recorrido detecta el no cumplimiento de la condicion debe cortar la
  ejecucion.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParcialArbolesTres {
    
    private GeneralTree<Integer> arbol = new GeneralTree<>();
    
    public ParcialArbolesTres (GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> camino (int num) {       
        List<Integer>  ruta = new ArrayList<>();
        buscarRuta(arbol,ruta,num);
        Collections.reverse(ruta);
        return ruta;      
    }
    
    private boolean buscarRuta (GeneralTree<Integer> nodo, List<Integer> ruta, int num) {
        if(nodo == null || nodo.isEmpty()) return false;
        
        if (nodo.isLeaf()) {
            ruta.add(nodo.getData());
            return true;
        }
        
        if (nodo.getChildren().size() < num) {
            return false;
        }
        
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            if (buscarRuta(hijo, ruta, num)) {
                ruta.add(nodo.getData());
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        
        GeneralTree<Integer> ag = new GeneralTree<>(10);
        
        GeneralTree<Integer> ag1 = new GeneralTree<>(8);
        GeneralTree<Integer> ag2 = new GeneralTree<>(42);
        GeneralTree<Integer> ag3 = new GeneralTree<>(-5);
        
        ag.addChild(ag1);
        ag.addChild(ag2);
        ag.addChild(ag3);
        
        GeneralTree<Integer> ag1_1 = new GeneralTree<>(5);
        GeneralTree<Integer> ag1_2 = new GeneralTree<>(22);
        
        ag1.addChild(ag1_1);
        ag1.addChild(ag1_2);
        
        GeneralTree<Integer> ag3_1 = new GeneralTree<>(19);
        GeneralTree<Integer> ag3_2 = new GeneralTree<>(-9);
        
        ag3.addChild(ag3_1);
        ag3.addChild(ag3_2);
        
        GeneralTree<Integer> ag1_1_1 = new GeneralTree<>(-6);
        
        ag1_1.addChild(ag1_1_1);
        
        GeneralTree<Integer> ag1_2_1 = new GeneralTree<>(28);
        GeneralTree<Integer> ag1_2_2 = new GeneralTree<>(55);
        GeneralTree<Integer> ag1_2_3 = new GeneralTree<>(18);
        
        ag1_2.addChild(ag1_2_1);
        ag1_2.addChild(ag1_2_2);
        ag1_2.addChild(ag1_2_3);
        
        GeneralTree<Integer> ag3_1_2 = new GeneralTree<>(4);
        
        ag3_1.addChild(ag3_1_2);
        
        ParcialArbolesTres p = new ParcialArbolesTres (ag);
        
        System.out.println(p.camino(2));
        
    }
    
}
