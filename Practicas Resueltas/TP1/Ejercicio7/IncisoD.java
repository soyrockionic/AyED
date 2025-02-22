package TP1.Ejercicio7;

import TP1.Ejercicio3.Estudiante;
import java.util.ArrayList;

public class IncisoD {
    
    public static void ejercicio7D() {
        
        // Crear una lista que contenga 3 estudiantes
        ArrayList<Estudiante> listaOriginal = new ArrayList<>();
        Estudiante e1 = new Estudiante("Juan","Perez","juan.perez@example.com","A1","Calle Falsa 123");
        listaOriginal.add(e1);
        Estudiante e2 = new Estudiante("Ana","Gomez","ana.gomez@example.com","B2","Avenida Siempre Viva 742");
        listaOriginal.add(e2);
        Estudiante e3 = new Estudiante("Pablo","Miranda","pablo.miranda@example.com","C3","Avenida 44");
        listaOriginal.add(e3);

        // Generar una nueva lista que sea una copia de la lista original
        
        /*ArrayList<Estudiante> listaCopia = new ArrayList<>(listaOriginal);*/
        
        ArrayList<Estudiante> listaCopia = new ArrayList<>();
        for(int j=0; j<listaOriginal.size(); j++){
            listaCopia.add(listaOriginal.get(j));
        }

        // Imprimir el contenido de la lista original y el contenido de la nueva lista
        System.out.println("Lista Original: ");
        for(int i=0; i<listaOriginal.size(); i++){
            System.out.println(listaOriginal.get(i).tusDatos());
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Lista Copia: ");
        for(int i=0; i<listaCopia.size(); i++){
            System.out.println(listaCopia.get(i).tusDatos());
        }
        
        // Modificar algun dato de los estudiantes en la lista original
        listaOriginal.get(0).setNombre("Pedro");
        listaCopia.get(2).setComision("A3");

        // Volver a imprimir el contenido de la lista original y el contenido de la nueva lista
        System.out.println("--------------------------------------------------");
        System.out.println("Lista Original después de la modificación: ");
        for(int i=0; i<listaOriginal.size(); i++){
            System.out.println(listaOriginal.get(i).tusDatos());
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Lista Copia después de la modificación: ");
        for(int i=0; i<listaCopia.size(); i++){
            System.out.println(listaCopia.get(i).tusDatos());
        }
        
        // Añadir un estudiante a la lista, verificando que no exista previamente
        ejercicio7E(listaOriginal);
        // Imprimir la lista despues de agregar el nuevo estudiante
        System.out.println("--------------------------------------------------");
        System.out.println("Lista Original despues de agregar el nuevo estudiante: ");
        for(Estudiante e : listaOriginal) {
            System.out.println(e.tusDatos());
        }
        
    }
    
    public static void ejercicio7E(ArrayList<Estudiante> listaOriginal){
        Estudiante e4 = new Estudiante("Laura", "Sanchez", "laura.sanchez@example.com", "D4", "Calle Verdadera 456"); 
        if (!listaOriginal.contains(e4)) {
            listaOriginal.add(e4);
        } else {
            System.out.println("El estudiante ya existe en la lista.");
        }
    }
    
    public static void main(String[] args) {
        
        ejercicio7D();
        
    }
    
}
