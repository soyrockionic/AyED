package TP1.Ejercicio5;

class Resultado {
    int min;
    int max;
    double prom;
}

public class Ejercicio5 {
    
    private static void Calculadora(Resultado b) {
        int [] a = {6, 8, 4};
        int suma = 0;
        min = a[0]; max = a[0]; prom = 0;
        for (int i=0; i<a.length; i++) {
            suma += a[i];
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        b.min = min;
        b.max = max;
        b.prom = (double) suma / a.length;
    }
    
    public static Resultado conReturn() {
        Resultado b = new Resultado ();
        Calculadora(b);
        return b;
    }
    
    private static int min, max;
    private static double prom;
    
    public static void  sinParametro () {
        int suma=0;
        int [] a = {6, 11, 4};
        min = a[0]; max = a[0];
        
        for (int i=0; i<a.length; i++) {
            suma += a[i];
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        
        prom = (double) suma / a.length;
        
    }
    
    public static void main (String[] args) {
        
        System.out.println(conReturn().min);
        System.out.println(conReturn().max);
        System.out.println(conReturn().prom);
        
        System.out.println();
        
        Resultado b = new Resultado ();
        Calculadora(b);
        System.out.println(b.min);
        System.out.println(b.max);
        System.out.println(b.prom);
     
        System.out.println();
        
        sinParametro();
        System.out.println(min);
        System.out.println(max);
        System.out.println(prom);
        
    }
    
}