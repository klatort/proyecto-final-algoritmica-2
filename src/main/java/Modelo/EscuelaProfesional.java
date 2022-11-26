
package Modelo;

import java.util.Vector;

public class EscuelaProfesional {
    
    private Vector<PlanCurricular> mallas;
    private String nombre;

    public EscuelaProfesional(String nombre, Vector<PlanCurricular> mallas) {
        this.mallas = mallas;
        this.nombre = nombre;
    }

    public boolean agregar(){
        return false;
         
    }
    public boolean eliminar(){
        return false;
         
    }
    
}
