package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import tp1.ejercicio3.Estudiante;

public class IncisoD {
    
    public static void main (String[] args) {
        
        List<Estudiante> estudiantes = new ArrayList<>();
        
        Estudiante e1 = new Estudiante ("Analia", "Beltran", "comA", "ana@gmail.com", "72y31");
        Estudiante e2 = new Estudiante ("Julieta", "Catro", "ComB", "juli@gmail.com", "530y2");
        Estudiante e3 = new Estudiante ("Evelyn", "Garcia", "ComD", "eve@gmail.com", "47y120");
    
        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);
        
        List<Estudiante> nueva = new ArrayList<>(estudiantes);
        
        //nueva = estudiantes;
                
        nueva.add(e1);
        
        for (int i=0; i<estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i).tusDatos());
        }
        
        e2.setComision("Sin comision");
        
        System.out.println("--------------------------------------------------");
        for (int i=0; i<nueva.size(); i++) {
            System.out.println(nueva.get(i).tusDatos());
        }
        
    }
    
}
