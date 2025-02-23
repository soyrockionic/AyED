package TP3.Ejercicio6;

import TP3.Ejercicio1.GeneralTree;

public class App {
    
    public static void main(String[] args) {
        // Crear la estructura del árbol (red de agua potable)
        GeneralTree<Character> arbol = new GeneralTree<>('M'); // Nodo raíz, representando el caño maestro

        // Crear nodos hijos del caño maestro (niveles de bifurcación)
        GeneralTree<Character> hijoA = new GeneralTree<>('A');
        GeneralTree<Character> hijoB = new GeneralTree<>('B');
        GeneralTree<Character> hijoC = new GeneralTree<>('C');
        GeneralTree<Character> hijoD = new GeneralTree<>('D');

        // Agregar nodos hijos al caño maestro
        arbol.addChild(hijoA);
        arbol.addChild(hijoB);
        arbol.addChild(hijoC);
        arbol.addChild(hijoD);
        
        GeneralTree<Character> nieto1 = new GeneralTree<>('F');
        hijoB.addChild(nieto1);
        GeneralTree<Character> nieto2 = new GeneralTree<>('G');
        hijoB.addChild(nieto2);
        GeneralTree<Character> nieto3 = new GeneralTree<>('H');
        hijoC.addChild(nieto3);
        GeneralTree<Character> nieto4 = new GeneralTree<>('I');
        hijoC.addChild(nieto4);
        GeneralTree<Character> nieto5 = new GeneralTree<>('J');
        hijoC.addChild(nieto5);
        GeneralTree<Character> nieto6 = new GeneralTree<>('K');
        hijoC.addChild(nieto6);
        GeneralTree<Character> nieto7 = new GeneralTree<>('P');
        hijoC.addChild(nieto7);
        GeneralTree<Character> bisNieto1 = new GeneralTree<>('L');
        nieto2.addChild(bisNieto1);
        GeneralTree<Character> bisNieto2 = new GeneralTree<>('Q');
        nieto5.addChild(bisNieto2);
        GeneralTree<Character> bisNieto3 = new GeneralTree<>('N');
        nieto5.addChild(bisNieto3);
        
        RedDeAguaPotable red = new RedDeAguaPotable(arbol);
        System.out.println("Caudal minimo que recibe una casa: " + red.minimoCaudal(1000));
    
    }
    
}
