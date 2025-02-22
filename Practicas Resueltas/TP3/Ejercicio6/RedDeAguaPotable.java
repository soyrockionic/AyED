package TP3.Ejercicio6;

import TP3.Ejercicio1.GeneralTree;

public class RedDeAguaPotable {
    
    private GeneralTree<Character> red;

    public RedDeAguaPotable(GeneralTree<Character> red) {
        this.red = red;
    }
    
    public double minimoCaudal(double caudalActual) {
        return calcularMinimoCaudal(red, caudalActual);
    }

    private double calcularMinimoCaudal(GeneralTree<Character> arbol, double caudalActual) {
        if (arbol.getChildren().isEmpty()) {
            return caudalActual; // Si es una hoja, el caudal actual es el caudal que recibe la casa.
        }
        
        double caudalPorBifurcacion = caudalActual / arbol.getChildren().size();
        double caudalMinimo = caudalActual;
        
        for (GeneralTree<Character> hijo : arbol.getChildren()) {
            double caudalHijo = calcularMinimoCaudal(hijo, caudalPorBifurcacion);
            caudalMinimo = Math.min(caudalHijo, caudalMinimo);
        }
        
        return caudalMinimo;
    }
    
    
}
