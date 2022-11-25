/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.awt.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class PlanteoHorarioCurso {
    private Map<String, HorarioPlanteado[]> horariosCursos;
    
    public PlanteoHorarioCurso(){
        this.horariosCursos = new HashMap<>();
    }
    public boolean plantearHorarios(Vector<Curso> cursos){
        Map<Curso, Profesor> profesores = new HashMap<>();
        Map<Integer, Vector<Curso>> cursosCiclo = new HashMap<>();
        
        for(var i : cursos){
            for(var j : i.getProfesDictan()){
                if(profesores.containsValue(j))
                    profesores.put(i, j);
            }
        }
        for(int i = 1; i <= 10; i++){
            cursosCiclo.computeIfAbsent(i, ignored -> new Vector());
        }
        for(var it : cursos){
            var aux = cursosCiclo.get(it.getCicloLleva());
            aux.add(it);
        }
        float promedioProfesores = profesores.size() / cursos.size();
        
        for(int i = 1; i <= 10; i++){
            var aux = cursosCiclo.get(i);
            
        }
        
        return true;
    }
    
    private HorarioPlanteado plantearHorarios(Profesor profesor){
        
        //USAR CICLO COMO CRITERIO PARA DETERMINAR CRUCE DE HORARIO, ES DECIR
        //CURSO A, B Y A.CICLO == B.CICLO -> A.HORARIO != B.CICLO
        return null;
    }
    
}
