package TP1.BernoulliAdaStyle;

/*
  Pasos basicos para calcular los numeros de Bernoulli utilizando el 
  enfoque historico del algoritmo de Ada Lovelace
  1. Definir una tabla B para almacenar los números de Bernoulli.
  2. Inicializar la tabla B con valores conocidos (por ejemplo, B[0] = 1 y B[1] = -1/2).
  3. Para cada valor de n desde 2 hasta el maximo deseado:
     a. Inicializar el numero de Bernoulli B[n] a 0.
     b. Para cada k desde 0 hasta n:
        i. Calcular el coeficiente binomial C(n, k).
        ii. Actualizar B[n] con el valor de C(n, k) * B[k] * (-1)^(n-k).
     c. Dividir B[n] entre (n+1) para obtener el valor final de B[n].
  4. Mostrar o utilizar los numeros de Bernoulli calculados.
*/

import java.util.Arrays;

public class BernoulliAdaStyle {

    // Procedimiento para calcular los numeros de Bernoulli al estilo de Ada Lovelace
    public static void calcularNrosBernoulliAda(double[] B, int n) {
        Arrays.fill(B, 0);  // Inicializar todos los elementos a 0
        B[0] = 1;  // B0 = 1

        // Usar una tabla para almacenar los coeficientes binomiales y resultados intermedios
        double[][] tabla = new double[n + 2][n + 2];

        // Inicializar la tabla de coeficientes binomiales
        for (int i = 0; i <= n + 1; i++) {
            tabla[i][0] = 1;  // Cualquier numero sobre 0 es 1
            for (int j = 1; j <= i; j++) {
                // Calculo de coeficientes binomiales
                tabla[i][j] = tabla[i - 1][j - 1] + tabla[i - 1][j];
            }
        }

        // Calcular los numeros de Bernoulli usando la tabla de coeficientes y sumas intermedias
        for (int m = 1; m <= n; m++) {
            double suma = 0;
            for (int k = 0; k < m; k++) {
                suma += tabla[m + 1][k] * B[k];  // Sumatoria de coeficientes y valores previos
            }
            B[m] = -suma / (m + 1);  // Calcular el valor de B[m]
        }

        // Ajustar los nomeros de Bernoulli impares mayores que 1 a 0
        for (int i = 3; i <= n; i += 2) {
            B[i] = 0;
        }
    }

    public static void main(String[] args) {
        int n = 9;  // Calcular hasta B9
        double[] B = new double[n + 1];
        calcularNrosBernoulliAda(B, n);

        // Imprimir los numeros de Bernoulli
        for (int i = 0; i <= n; i++) {
            System.out.printf("B[%d] = %.5f%n", i, B[i]);
        }
    }
}
