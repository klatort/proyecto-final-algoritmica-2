/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class HorariosMatricula {
    private HorariosCursos [] horariosCarreras;

    public HorariosMatricula(HorariosCursos[] horariosCarreras) {
        this.horariosCarreras = horariosCarreras;
    }

    public boolean agregar(){
        return false;
         
    }
    public boolean eliminar(){
        return false;
         
    }
     
    public HorariosCursos[] getHorariosCarreras() {
        return horariosCarreras;
    }

    public void setHorariosCarreras(HorariosCursos[] horariosCarreras) {
        this.horariosCarreras = horariosCarreras;
    }

    @Override
    public String toString() {
        return "HorariosMatricula{" + "horariosCarreras=" + horariosCarreras + '}';
    }
    
}
