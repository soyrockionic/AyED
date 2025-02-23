package TP1.Ejercicio1;

public class Ejercicio1 {    
    
// Metodo a: utilizando un for
    public static void imprimirConFor(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.print(i+" ");
        }
    }

    // Metodo b: utilizando un while
    public static void imprimirConWhile(int a, int b) {
        int i = a;
        while (i <= b) {
            System.out.print(i+" ");
            i++;
        }
    }

    // Metodo c: sin utilizar estructuras iterativas (for, while, do while)
    public static void imprimirSinIteracion(int a, int b) {
        if (a > b) {
            return;
        }
        System.out.print(a+" ");
        imprimirSinIteracion(a + 1, b);
    }

    // Metodo main para probar los métodos anteriores
    public static void main(String[] args) {
        int a = 1, b = 5;
        
        System.out.println("Imprimir con for:");
        imprimirConFor(a, b);
        
        System.out.println();
        
        System.out.println("Imprimir con while:");
        imprimirConWhile(a, b);
        
        System.out.println();
        
        System.out.println("Imprimir sin iteraciones:");
        imprimirSinIteracion(a, b);
        
        System.out.println();
    }
    
}
