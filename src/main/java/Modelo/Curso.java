
package Modelo;

public class Curso {
    private Profesor[] profesDictan;
    private String codigo;
    private String nombreCurso;
    private int horasCurso;
    private int cantidadAlumnos;
    private int cicloLleva;

    public Curso(Profesor[] profesDictan, String codigo, String nombreCurso, int horasCurso, int cantidadAlumnos, int cicloLleva) {
        this.profesDictan = profesDictan;
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
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

    public int getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(int horasCurso) {
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

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", horasCurso=" + horasCurso + ", cantidadAlumnos=" + cantidadAlumnos + ", cicloLleva=" + cicloLleva + '}';
    }
    
    
}
