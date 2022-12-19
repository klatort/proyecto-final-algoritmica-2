
package Modelo;

import java.io.Serializable;

public class Curso implements Serializable {
    private Profesor[] profesDictan;
    private String codigo;
    private String nombreCurso;
    private int horasCurso;
    private int cicloLleva;

    @Override
    public String toString() {
        return this.nombreCurso;
    }

    public Curso(String codigo, String nombreCurso, int horasCurso, int cicloLleva) {
        this.profesDictan = new Profesor[0];
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.horasCurso = horasCurso;
        this.cicloLleva = cicloLleva;
    }
    
    public boolean addProfe(Profesor e){
       var aux = new Profesor[this.profesDictan.length + 1];
       System.arraycopy(this.profesDictan, 0, aux, 0, this.profesDictan.length);
       e.addCurso(this.nombreCurso);
       aux[this.profesDictan.length] = e;
       this.profesDictan = aux;
       return true;
    }
    
    public boolean exists(Profesor e)
    {
        int len = this.profesDictan.length;
        int i = 0;
        
        while (i < len) {
            if (this.profesDictan[i] == e) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }
    
    public boolean removeProfe(Profesor e)
    {
        var aux = new Profesor[this.profesDictan.length - 1];
        for (int i = 0, k = 0; i < this.profesDictan.length; i++) {
            if (this.profesDictan[i] == e) {
                continue;
            }
            aux[k++] = this.profesDictan[i];
        }
        this.profesDictan = aux;        
        return true;
    }
    
    public Profesor[] getProfesDictan() {
        return profesDictan;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public int getHorasCurso() {
        return horasCurso;
    }

    public int getCicloLleva() {
        return cicloLleva;
    }
}
