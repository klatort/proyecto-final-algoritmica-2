/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.awt.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class PlanteoHorarioCurso {
    private Map<Curso, Vector<HorarioPlanteado>> horariosCursos;
    
    public PlanteoHorarioCurso(){
        this.horariosCursos = new HashMap<>();
    }

    public Map<Curso, Vector<HorarioPlanteado>> getHorariosCursos() {
        return this.horariosCursos;
    }
    
    public boolean plantearHorarios(Vector<Curso> cursos){
        Map<Profesor, Vector<Curso>> profesores = new HashMap<>();
        Map<Integer, Vector<Curso>> cursosCiclo = new HashMap<>();
        
        for(var i : cursos){
            for(var j : i.getProfesDictan()){
                profesores.computeIfAbsent(j, ignored -> new Vector());
            }
        }
        
        for(var i : cursos){
            for(var j : i.getProfesDictan()){
                var aux = profesores.get(j);
                aux.add(i);
            }
        }
        
        System.out.println(profesores);
        float promedioProfesores = profesores.size() / cursos.size();
        
        for(var curso : cursos){
            this.horariosCursos.computeIfAbsent(curso, ignored -> new Vector());
        }
        
        for(int i = 1; i <= 10; i++){
            cursosCiclo.computeIfAbsent(i, ignored -> new Vector());
        }
        for(var it : cursos){
            var aux = cursosCiclo.get(it.getCicloLleva());
            aux.add(it);
        }
        
        Collections.sort(cursos, Comparator.comparing(e -> {
            return e.getProfesDictan().size();
        }));
        
        for(var curso : cursos){
            for(var profesor : curso.getProfesDictan()){
                for(int cont = 0; cont < profesor.getDisponibilidad().size(); cont++){
                    var planteo = plantearHorarios(profesor, curso, cont);
                    if(planteo == null) break;
                    var c = cursosCiclo.get(curso.getCicloLleva());
                    boolean cruce = false;
                    for(var it : c){
                        var aux = horariosCursos.get(it);
                        if(!aux.isEmpty()){
                            for(var it2 : aux){
                                cruce = it2.horario.chocaHorario(planteo.horario);
                                if(cruce) { 
                                    break;
                                }
                            }
                        }
                    }
                    if(!cruce){
                        profesor.setHorasFaltantes(profesor.getHorasFaltantes() - curso.getHorasCurso());
                        horariosCursos.get(curso).add(planteo);
                        System.out.println("Curso: " + curso.getNombreCurso() + " Profesor: " + planteo.profesor + "Horario: " + planteo.horario.getDiaSemana() + " De: " +planteo.horario.getInicio() + " a " + planteo.horario.getFin());
                        break;
                    }
                }
            }
        }
        
        return true;
    }
    
    private HorarioPlanteado plantearHorarios(Profesor profesor, Curso curso, int it){
        
        //USAR CICLO COMO CRITERIO PARA DETERMINAR CRUCE DE HORARIO, ES DECIR
        //CURSO A, B Y A.CICLO == B.CICLO -> A.HORARIO != B.CICLO
        
        if(profesor.estaDisponible() && profesor.getHorasFaltantes() - curso.getHorasCurso() >= 0){
            HorarioPlanteado aux = new HorarioPlanteado(profesor.getDisponibilidad().get(it), profesor.getNombre());
            return aux;
        }
        return null;
    }
    
}
