package TP3.Ejercicio4;

public class AreaEmpresa {
    
    private String identificacion;
    private int tardanza;
    
    public AreaEmpresa(String identificacion, int tardanza){
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }
    
    public String getIdentificacion(){
        return this.identificacion;
    }
    
    public int getTardanza(){
        return this.tardanza;
    }
    
    @Override
    public String toString() {
        return "("+ identificacion + "|" + tardanza + ")";
    }
    
}
