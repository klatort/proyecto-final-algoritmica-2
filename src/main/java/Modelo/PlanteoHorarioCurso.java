/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class PlanteoHorarioCurso {
    private Profesor profesorCurso;
    private Horario seDicta;

    public PlanteoHorarioCurso(Profesor profesorCurso, Horario seDicta) {
        this.profesorCurso = profesorCurso;
        this.seDicta = seDicta;
    }
    
    public boolean generar_horario(){
        return false;
    }

    public Profesor getProfesorCurso() {
        return profesorCurso;
    }

    public void setProfesorCurso(Profesor profesorCurso) {
        this.profesorCurso = profesorCurso;
    }

    public Horario getSeDicta() {
        return seDicta;
    }

    public void setSeDicta(Horario seDicta) {
        this.seDicta = seDicta;
    }

    @Override
    public String toString() {
        return "PlanteoHorarioCurso{" + "profesorCurso=" + profesorCurso + ", seDicta=" + seDicta + '}';
    }
    
}
