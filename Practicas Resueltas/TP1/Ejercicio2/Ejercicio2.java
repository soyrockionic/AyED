package TP1.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    
    // Metodo que devuelve un arreglo con los n primeros multiplos de n
    public static int[] obtenerMultiplos(int n) {
        int[] multiplos = new int[n];
        for (int i = 0; i < n; i++) {
            multiplos[i] = n * (i + 1);
        }
        return multiplos;
    }

    // Metodo main para probar el metodo anterior con valores ingresados por teclado
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero (n): ");
        int n = scanner.nextInt();

        int[] multiplos = obtenerMultiplos(n);

        System.out.println("Los primeros " + n + " múltiplos de " + n + " son:");
        for (int i=0; i<n; i++) {
            System.out.print(multiplos[i] + " ");
        }
        
        System.out.println();
    }
    
}