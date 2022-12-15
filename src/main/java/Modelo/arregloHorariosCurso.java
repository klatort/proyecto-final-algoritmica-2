/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Fabo
 */
public class arregloHorariosCurso {
    private HorariosCurso[] horariosCurso;

    public arregloHorariosCurso() {
        this.horariosCurso = new HorariosCurso[0];
    }
    
    public boolean addHorariosCurso(HorariosCurso e){
       var aux = new HorariosCurso[this.horariosCurso.length + 1];
       System.arraycopy(this.horariosCurso, 0, aux, 0, this.horariosCurso.length);
       aux[this.horariosCurso.length] = e;
       this.horariosCurso = aux;
       return true;
    }
    
    public int existHorariosCurso(Curso e)
    {
        int len = this.horariosCurso.length;
        int i = 0;
        
        while (i < len) {
            if (this.horariosCurso[i].getCurso() == e) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
    
    public boolean removeHorarioGrupo(HorariosCurso e)
    {
        var aux = new HorariosCurso[this.horariosCurso.length - 1];
        for (int i = 0, k = 0; i < this.horariosCurso.length; i++) {
            if (this.horariosCurso[i] == e) {
                continue;
            }
            aux[k++] = this.horariosCurso[i];
        }
        this.horariosCurso = aux;        
        return true;
    }

    public HorariosCurso getHorarioCurso(int index) {
        return horariosCurso[index];
    }
 
}
