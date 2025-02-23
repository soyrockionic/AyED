package TP3.Ejercicio4;

/*Justificacion:
   El recorrido BFS es ideal cuando se necesita trabajar con niveles específicos en un arbol,
   ya que se enfoca en procesar todos los nodos de un nivel antes de avanzar al siguiente.
   Esto se ajusta perfectamente a la necesidad de calcular y comparar los promedios de
   cada nivel en el arbol de la empresa.*/

import TP3.Ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.Queue;

public class AnalizadorArbol {
    
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
        if (arbol == null || arbol.estaVacio()) {return 0;}

        Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<>();
        cola.add(arbol);

        double maxPromedio = -99999;

        while (!cola.isEmpty()) {
            int tamanoNivel = cola.size();
            double sumaNivel = 0;

            for (int i = 0; i < tamanoNivel; i++) {
                GeneralTree<AreaEmpresa> nodoActual = cola.poll();
                sumaNivel += nodoActual.obtenerDato().getTardanza();
                for (GeneralTree<AreaEmpresa> hijo : nodoActual.getChildren()) {
                    cola.add(hijo);
                }
            }

            double promedioNivel = sumaNivel / tamanoNivel;
            maxPromedio = Math.max(maxPromedio, promedioNivel);
        }

        return maxPromedio;
    }
    
}
