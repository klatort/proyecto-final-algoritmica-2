/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Fabo
 */
public class Facultad {
    private EscuelaProfesional[] carreras;
    private String facultad;
    
    public Facultad(String nombre){
        this.facultad = nombre;
        this.carreras = new EscuelaProfesional[0];
    }
    
    public boolean addCarrera(EscuelaProfesional e){
       var aux = new EscuelaProfesional[this.carreras.length + 1];
       System.arraycopy(this.carreras, 0, aux, 0, this.carreras.length);
       aux[this.carreras.length] = e;
       this.carreras = aux;
       return true;
    }
    
    public boolean exists(EscuelaProfesional e)
    {
        int len = this.carreras.length;
        int i = 0;
        
        while (i < len) {
            if (this.carreras[i] == e) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }
    
    public boolean removeMalla(EscuelaProfesional e)
    {
        var aux = new EscuelaProfesional[this.carreras.length - 1];
        for (int i = 0, k = 0; i < this.carreras.length; i++) {
            if (this.carreras[i] == e) {
                continue;
            }
            aux[k++] = this.carreras[i];
        }
        this.carreras = aux;        
        return true;
    }   
}
