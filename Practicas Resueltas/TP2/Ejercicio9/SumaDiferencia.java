package TP2.Ejercicio9;

public class SumaDiferencia {
    
    private Integer sum, dif;

    public SumaDiferencia(Integer sum, Integer dif) {
        this.sum = sum;
        this.dif = dif;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getDif() {
        return dif;
    }

    public void setDif(Integer dif) {
        this.dif = dif;
    }

    @Override
    public String toString() {
        return "("+ sum + "|" + dif + ")";
    }
    
}
