package TP1.Ejercicio3;

public class Profesor extends Persona {
    
    private String catedra;
    private String facultad;

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
        super(nombre,apellido,email);
        this.catedra = catedra;
        this.facultad = facultad;
    }
    
    public Profesor (){
        super();
    }

    public String getCatedra() {
        return catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public String tusDatos(){
        String aux;
        aux = super.toString() + " " + getCatedra() + " " + getFacultad();
        return aux;
    }
    
}
