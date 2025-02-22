package TP1.Ejercicio5;

public class ConReturn {
    
    public static int[] calcularValores(int[] arreglo) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i=0; i<arreglo.length; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
            if (arreglo[i] < min) {
                min = arreglo[i];
            }
            sum = sum + arreglo[i];
        }

        int promedio = sum / arreglo.length;
        
        return new int[]{max, min, promedio}; // Devuelve un arreglo con max, min y promedio.
    }
    
    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9};
        int[] resultado = calcularValores(arreglo);
        System.out.println("Máximo: " + resultado[0]);
        System.out.println("Mínimo: " + resultado[1]);
        System.out.println("Promedio: " + resultado[2]);
    }
    
}