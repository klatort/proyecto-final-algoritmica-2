
package Modelo;

import java.util.Vector;

public class Curso {
    private Profesor[] profesDictan;
    private String codigo;
    private String nombreCurso;
    private int horasCurso;
    private int cicloLleva;

    public Curso(String codigo, String nombreCurso, int horasCurso, int cicloLleva) {
        this.profesDictan = new Profesor[0];
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.horasCurso = horasCurso;
        this.cicloLleva = cicloLleva;
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
}
