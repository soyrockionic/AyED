package TP1.Ejercicio7;

import java.util.ArrayList;

public class InvertirArrayList {

    public void invertirArrayList(ArrayList<Integer> lista) {
        invertirArrayListRecursivo(lista, 0, lista.size() - 1);
    }

    private void invertirArrayListRecursivo(ArrayList<Integer> lista, int inicio, int fin) {
        if (inicio >= fin) {
            return; // Caso base: ya se han invertido todos los elementos
        }

        // Intercambiar los elementos en las posiciones "inicio" y "fin"
        int temp = lista.get(inicio);
        lista.set(inicio, lista.get(fin));
        lista.set(fin, temp);

        // Llamada recursiva para los elementos restantes
        invertirArrayListRecursivo(lista, inicio + 1, fin - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(5);
        numeros.add(9);
        numeros.add(12);

        InvertirArrayList o = new InvertirArrayList();
        System.out.println("Lista original: " + numeros);
        o.invertirArrayList(numeros);
        System.out.println("Lista invertida: " + numeros);
    }
    
}
