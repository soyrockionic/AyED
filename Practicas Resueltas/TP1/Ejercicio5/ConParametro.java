package TP1.Ejercicio5;

public class ConParametro {
    
    public static void calcularValores(int[] arreglo, Resultado resultado) {
        resultado.max = Integer.MIN_VALUE;
        resultado.min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i=0; i<arreglo.length; i++) {
            if (arreglo[i] > resultado.max) {
                resultado.max = arreglo[i];
            }
            if (arreglo[i] < resultado.min) {
                resultado.min = arreglo[i];
            }
            sum += arreglo[i];
        }

        resultado.promedio = sum / arreglo.length;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9};
        Resultado resultado = new Resultado();
        calcularValores(arreglo, resultado);
        System.out.println("Máximo: " + resultado.max);
        System.out.println("Mínimo: " + resultado.min);
        System.out.println("Promedio: " + resultado.promedio);
    }
    
}

class Resultado {
    int max;
    int min;
    int promedio;
}
    

