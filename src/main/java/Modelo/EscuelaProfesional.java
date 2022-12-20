
package Modelo;

import java.io.Serializable;

public class EscuelaProfesional implements Serializable{
    
    private PlanCurricular[] mallas;
    private String nombre;

    public EscuelaProfesional(String nombre) {
        this.mallas = new PlanCurricular[0];
        this.nombre = nombre;
    }

    public boolean addMalla(PlanCurricular e){
       var aux = new PlanCurricular[this.mallas.length + 1];
       System.arraycopy(this.mallas, 0, aux, 0, this.mallas.length);
       aux[this.mallas.length] = e;
       this.mallas = aux;
       return true;
    }
    
    public boolean exists(PlanCurricular e)
    {
        int len = this.mallas.length;
        int i = 0;
        
        while (i < len) {
            if (this.mallas[i] == e) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }
    
    public boolean removeMalla(PlanCurricular e)
    {
        var aux = new PlanCurricular[this.mallas.length - 1];
        for (int i = 0, k = 0; i < this.mallas.length; i++) {
            if (this.mallas[i] == e) {
                continue;
            }
            aux[k++] = this.mallas[i];
        }
        this.mallas = aux;        
        return true;
    }    

    public PlanCurricular[] getMallas() {
        return mallas;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
