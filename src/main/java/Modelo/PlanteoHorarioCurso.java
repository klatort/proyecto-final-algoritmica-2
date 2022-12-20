/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Libraries.Persistencia;
import java.io.File;

/**
 *
 * @author Usuario
 */
public class PlanteoHorarioCurso {
    
    private arregloHorariosCurso horariosCursos;
    
    public PlanteoHorarioCurso(){
        this.horariosCursos = new arregloHorariosCurso();
    }

    public arregloHorariosCurso getHorariosCursos() {
        return this.horariosCursos;
    }
    
    public boolean plantearHorarios(Curso[] cursos, String file){
        File f = new File(file + ".txt");
        if(f.exists()) {
            this.horariosCursos = (arregloHorariosCurso)Persistencia.deserialize(file);
            return true;
        }
        Curso[][] cursosCiclo = new Curso[10][10];
        for(int i = 0; i < 10; i++){
            int index = 0;
            for(var curso : cursos){
                if(curso.getCicloLleva() == i + 1){
                    cursosCiclo[i][index] = curso;
                    index++;
                }
            }
        }
        this.sort(cursos, 0, cursos.length - 1);
        
        for(var curso : cursos){
            HorariosCurso aux = new HorariosCurso(curso);
            this.horariosCursos.addHorariosCurso(aux);
            for(var profesor : curso.getProfesDictan()){
                for(int cont = 0; cont < profesor.getDisponibilidad().length; cont++){
                    HorarioGrupo planteo = plantearHorarios(profesor, curso, cont);
                    if(planteo == null) break;
                    var cursoCiclo = cursosCiclo[curso.getCicloLleva() - 1];
                    boolean cruce = false;
                    for(var c : cursoCiclo){
                        int index = this.horariosCursos.existHorariosCurso(c);
                        if(c != curso && index > -1){
                            var horarios = this.horariosCursos.getHorarioCurso(index).getGrupos();
                            for(var horario : horarios){
                                cruce = cruce || horario.horario.chocaHorario(planteo.horario);
                            }
                        }
                    }
                    if(!cruce){
                        profesor.setHorasFaltantes(profesor.getHorasFaltantes() - curso.getHorasCurso());
                        //profesor.removeDisponibilidad(cont);
                        int index = this.horariosCursos.existHorariosCurso(curso);
                        aux.addHorarioGrupo(planteo);
                        System.out.println("Curso: " + curso.getNombreCurso() + " Profesor: " + planteo.profesor + " Horario: " + planteo.horario.getDiaSemana() + " De: " +planteo.horario.getInicio() + " a " + planteo.horario.getFin() + ".");
                        break;
                    }
                }
            }
        }
        
        Persistencia.serialize(this.horariosCursos, file);
        
        return true;
    }
    
    private HorarioGrupo plantearHorarios(Profesor profesor, Curso curso, int it){
        
        //USAR CICLO COMO CRITERIO PARA DETERMINAR CRUCE DE HORARIO, ES DECIR
        //CURSO A, B Y A.CICLO == B.CICLO -> A.HORARIO != B.CICLO
        
        if(profesor.estaDisponible() && profesor.getHorasFaltantes() - curso.getHorasCurso() >= 0){
            HorarioGrupo aux = new HorarioGrupo(profesor.getDisponibilidad()[it], profesor.getNombre());
            return aux;
        }
        return null;
    }    
    
    private void merge(Curso arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        Curso L[] = new Curso[n1];
        Curso R[] = new Curso[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getProfesDictan().length <= R[j].getProfesDictan().length) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    private void sort(Curso arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
