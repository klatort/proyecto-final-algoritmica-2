
package Modelo;

import java.util.Vector;

public class Curso {
    private Vector<Profesor> profesDictan;
    private String codigo;
    private String nombreCurso;
    private int horasCurso;
    private int cicloLleva;

    public Curso(String codigo, String nombreCurso, int horasCurso, int cicloLleva, Vector<Profesor> profesDictan) {
        this.profesDictan = profesDictan;
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.horasCurso = horasCurso;
        this.cicloLleva = cicloLleva;
    }
    
    public Vector<Profesor> getProfesDictan() {
        return profesDictan;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHorasCurso() {
        return horasCurso;
    }

    public int getCicloLleva() {
        return cicloLleva;
    }
}
