package TP3.Ejercicio11;

import java.util.LinkedList;
import TP3.Ejercicio1.GeneralTree;

public class ParcialArboles {
    
    public static boolean resolver (GeneralTree<Integer> arbol) {
        if (arbol.isEmpty()) return true;
       
        LinkedList<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(arbol);
        
        Integer valor = 0;
        
        while (!cola.isEmpty()) {
        
            Integer valorEnNivel = cola.size();
            
            if (valorEnNivel != valor+1) return false;
            
            for (int i=0; i<valorEnNivel; i++) {
                GeneralTree<Integer> hijo = cola.poll();
                cola.addAll(hijo.getChildren());
            }
            valor++;
        }
        
        return true;
    }    
     
}
