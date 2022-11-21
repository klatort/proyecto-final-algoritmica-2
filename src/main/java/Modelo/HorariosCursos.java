/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class HorariosCursos {
    private EscuelaProfesional carrera;
    private PlanteoHorarioCurso [] horarios;

    public HorariosCursos(EscuelaProfesional carrera, PlanteoHorarioCurso[] horarios) {
        this.carrera = carrera;
        this.horarios = horarios;
    }
    
    public void generar_horarios(){
        
    }

    public PlanteoHorarioCurso[] getHorarios() {
        return horarios;
    }

    public void setHorarios(PlanteoHorarioCurso[] horarios) {
        this.horarios = horarios;
    }
    
    public boolean agregar(){
        return false;
         
    }
    public boolean eliminar(){
        return false;
    }

    @Override
    public String toString() {
        return "HorariosCurso{" + "carrera=" + carrera + ", horarios=" + horarios + '}';
    }
    
}
