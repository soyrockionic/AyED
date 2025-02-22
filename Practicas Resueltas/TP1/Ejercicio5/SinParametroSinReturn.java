package TP1.Ejercicio5;

public class SinParametroSinReturn {
    
    static int max;
    static int min;
    static int promedio;

    public static void calcularValores(int[] arreglo) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
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

        promedio = sum / arreglo.length;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9};
        calcularValores(arreglo);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        System.out.println("Promedio: " + promedio);
    }
    
}
