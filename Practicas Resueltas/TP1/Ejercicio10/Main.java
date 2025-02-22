package TP1.Ejercicio10;

public class Main {
    
    public static void main(String[] args) {
        
        Cola c = new Cola();
        c.agregarTicket(28604,45);
        c.agregarTicket(10376,77);
        c.agregarTicket(44285,42);
        c.agregarTicket(10407,74);
        
        c.obtenerTickets().stream().forEach(System.out::println);
        
        /*for(int i=0; i<c.getSize();i++){
            System.out.println(c.obtenerTickets().get(i));
        }*/
        
    }
    
}
