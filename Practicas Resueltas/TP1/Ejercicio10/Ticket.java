package TP1.Ejercicio10;

public class Ticket {
    
    private int n;
    private int dni;
    private int edad;
    
    public Ticket(int n, int dni, int edad){
        this.n = n;
        this.dni = dni;
        this.edad = edad;
    }

    public int getN() {
        return n;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Ticket{" + "n=" + n + ", dni=" + dni + ", edad=" + edad + '}';
    }
    
}
