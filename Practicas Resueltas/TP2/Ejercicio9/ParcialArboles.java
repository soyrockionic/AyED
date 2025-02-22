package TP2.Ejercicio9;

import TP2.Ejercicio1.BinaryTree;

public class ParcialArboles {
    
    public BinaryTree<SumaDiferencia> sumAndDif(BinaryTree<Integer> arbol) {
        return sumAndDifAux(arbol, 0, 0);
    }

    private BinaryTree<SumaDiferencia> sumAndDifAux(BinaryTree<Integer> arbol, Integer sum, Integer dif) {
        BinaryTree<SumaDiferencia> result = new BinaryTree<>();

        if (arbol != null && !arbol.isEmpty()) {
            // Calcula la suma acumulada y la diferencia
            int newSum = sum + arbol.getData();
            int newDif = arbol.getData() - dif;

            // Asigna el nuevo valor (puedes modificar esta logica segun tu necesidad)
            SumaDiferencia aux = new SumaDiferencia(newSum,newDif);
            result.setData(aux);

            // Procesa los hijos izquierdo y derecho recursivamente
            if (arbol.hasLeftChild()) {
                result.addLeftChild(sumAndDifAux(arbol.getLeftChild(), newSum, arbol.getData()));
            }
            if (arbol.hasRightChild()) {
                result.addRightChild(sumAndDifAux(arbol.getRightChild(), newSum, arbol.getData()));
            }
        }
    
        return result;
    }
    
}

