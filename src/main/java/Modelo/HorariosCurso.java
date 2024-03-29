/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Fabo
 */
public class HorariosCurso implements Serializable {
    private Curso curso;
    private HorarioGrupo[] grupos;

    public HorariosCurso(Curso curso) {
        this.curso = curso;
        this.grupos = new HorarioGrupo[0];
    }
    
    public boolean addHorarioGrupo(HorarioGrupo e){
       var aux = new HorarioGrupo[this.grupos.length + 1];
       System.arraycopy(this.grupos, 0, aux, 0, this.grupos.length);
       aux[this.grupos.length] = e;
       this.grupos = aux;
       return true;
    }
    
    public boolean hasHorarios(){
        if(this.grupos.length <= 0){
            return false;
        }
        return true;
    }
    
    public boolean existHorarioGrupo(HorarioGrupo e)
    {
        int len = this.grupos.length;
        int i = 0;
        
        while (i < len) {
            if (this.grupos[i] == e) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }
    
    public boolean removeHorarioGrupo(HorarioGrupo e)
    {
        var aux = new HorarioGrupo[this.grupos.length - 1];
        for (int i = 0, k = 0; i < this.grupos.length; i++) {
            if (this.grupos[i] == e) {
                continue;
            }
            aux[k++] = this.grupos[i];
        }
        this.grupos = aux;        
        return true;
    }

    public Curso getCurso() {
        return curso;
    }

    public HorarioGrupo[] getGrupos() {
        return grupos;
    }
 
}
