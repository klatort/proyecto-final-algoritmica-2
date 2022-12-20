
package Modelo;

import java.io.Serializable;

public class PlanCurricular implements Serializable {
    private Curso[] cursos;
    private String anio;

    public PlanCurricular(String anio) {
        this.anio = anio;
        this.cursos = new Curso[0];
    }

    public Curso[] getCursos() {
        return this.cursos;
    }
    
    public boolean addCurso(Curso e){
       var aux = new Curso[this.cursos.length + 1];
       System.arraycopy(this.cursos, 0, aux, 0, this.cursos.length);
       aux[this.cursos.length] = e;
       this.cursos = aux;
       return true;
    }
    
    public boolean existsCurso(Curso e)
    {
        int len = this.cursos.length;
        int i = 0;
        
        while (i < len) {
            if (this.cursos[i] == e) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }
    
    public boolean removeCurso(Curso e)
    {
        var aux = new Curso[this.cursos.length - 1];
        for (int i = 0, k = 0; i < this.cursos.length; i++) {
            if (this.cursos[i] == e) {
                continue;
            }
            aux[k++] = this.cursos[i];
        }
        this.cursos = aux;        
        return true;
    }

    @Override
    public String toString() {
        return "Plan " + this.anio;
    }
}
