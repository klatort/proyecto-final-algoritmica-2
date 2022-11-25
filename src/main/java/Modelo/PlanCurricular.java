
package Modelo;

import java.util.Vector;

public class PlanCurricular {
    private Vector<Curso> cursos;
    private String anio;

    public PlanCurricular(String anio, Vector<Curso> cursos) {
        this.anio = anio;
        this.cursos = cursos;
    }
    
    
}
