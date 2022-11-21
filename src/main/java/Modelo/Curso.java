
package Modelo;

public class Curso {
    private String codigo;
    private float horasCurso;
    private int cantidadAlumnos;
    private int cicloLleva;

    public Curso(String codigo, float horasCurso, int cantidadAlumnos, int cicloLleva) {
        this.codigo = codigo;
        this.horasCurso = horasCurso;
        this.cantidadAlumnos = cantidadAlumnos;
        this.cicloLleva = cicloLleva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(float horasCurso) {
        this.horasCurso = horasCurso;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getCicloLleva() {
        return cicloLleva;
    }

    public void setCicloLleva(int cicloLleva) {
        this.cicloLleva = cicloLleva;
    }
    
    
}
