package TP3.Ejercicio6;

import TP3.Ejercicio1.GeneralTree;

public class RedDeAguaPotable {
    
    private GeneralTree<Character> arbol =new GeneralTree<>();

    public RedDeAguaPotable(GeneralTree<Character> red) {
        this.arbol = red;
    }
    
    public double minimoCaudal(double caudalActual) {
        return calcularMinimoCaudal(arbol, caudalActual);
    }

    private double calcularMinimoCaudal(GeneralTree<Character> arbol, double caudalActual) {
        
        if (arbol.isEmpty()) return 0;
        
        if (arbol.isLeaf()) return caudalActual;
        
        double caudalPorBifurcacion = caudalActual / arbol.getChildren().size();
        
        double caudalMinimo = caudalActual;
        
        for (GeneralTree<Character> hijo : arbol.getChildren()) {
            double caudalHijo = calcularMinimoCaudal(hijo, caudalPorBifurcacion);
            caudalMinimo = Math.min(caudalHijo, caudalMinimo);
        }
        
        return caudalMinimo;
    }
    
}
