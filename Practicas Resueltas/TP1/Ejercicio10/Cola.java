package TP1.Ejercicio10;

import java.util.LinkedList;

public class Cola<T> {
    
    private LinkedList<Ticket> tickets;
    private int n;
    
    public Cola(){
        tickets = new LinkedList<>();
        this.n = 1;
    }
    
    public void agregarTicket(int dni, int edad){
        Ticket t = new Ticket(n++,dni,edad);
        if(t.getEdad() < 70)
            this.tickets.add((Ticket) t);
        else
           agregarEnOrden((LinkedList<Ticket>) tickets, t);
    }
    
    private void agregarEnOrden(LinkedList<Ticket> lista, Ticket ticket) {
            int pos = 0;
            // Buscar la posicion adecuada para insertar segun el criterio
            while (pos < lista.size() && lista.get(pos).getEdad() >= 70) {
                pos++;
            }
            lista.add(pos, ticket); // Insertar en la posicion encontrada
    }
        
    public LinkedList<Ticket> obtenerTickets(){
        return this.tickets;
    }
    
    /*public int getSize(){
        return tickets.size();
    }*/
    
}
