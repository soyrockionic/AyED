package TP1.Ejercicio3;

public class Test {

    public static void main(String[] args) {
        
        // Creacion de dos objetos Estudiante
        Estudiante[] estudiantes = new Estudiante[2];

        estudiantes[0] = new Estudiante();
        estudiantes[0].setNombre("Juan");
        estudiantes[0].setApellido("Pérez");
        estudiantes[0].setEmail("juan.perez@example.com");
        estudiantes[0].setComision("A1");
        estudiantes[0].setDireccion("Calle Falsa 123");

        estudiantes[1] = new Estudiante();
        estudiantes[1].setNombre("María");
        estudiantes[1].setApellido("Gómez");
        estudiantes[1].setEmail("maria.gomez@example.com");
        estudiantes[1].setComision("B2");
        estudiantes[1].setDireccion("Avenida Siempre Viva 742");

        // Creacion de tres objetos Profesor
        Profesor[] profesores = new Profesor[3];

        profesores[0] = new Profesor();
        profesores[0].setNombre("Carlos");
        profesores[0].setApellido("López");
        profesores[0].setEmail("carlos.lopez@example.com");
        profesores[0].setCatedra("Matemáticas");
        profesores[0].setFacultad("Facultad de Ciencias Exactas");

        profesores[1] = new Profesor();
        profesores[1].setNombre("Ana");
        profesores[1].setApellido("Martínez");
        profesores[1].setEmail("ana.martinez@example.com");
        profesores[1].setCatedra("Física");
        profesores[1].setFacultad("Facultad de Ciencias Exactas");

        profesores[2] = new Profesor();
        profesores[2].setNombre("Roberto");
        profesores[2].setApellido("García");
        profesores[2].setEmail("roberto.garcia@example.com");
        profesores[2].setCatedra("Química");
        profesores[2].setFacultad("Facultad de Ciencias Exactas");
        
        // Recorrido e impresion de los datos de los estudiantes
        for(int e=0; e<2; e++) {
            System.out.println(estudiantes[e].tusDatos());
        }
        System.out.println();
        // Recorrido e impresion de los datos de los profesores
        for(int profe=0; profe<3; profe++) {
            System.out.println(profesores[profe].tusDatos());
        }
        
    }
    
}
