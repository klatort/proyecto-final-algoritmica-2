/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Vector;
/**
 *
 * @author Usuario
 */
public class EscuelaProfesional {
    
    private Vector<PlanCurricular> mallas;
    private String nombre;

    public EscuelaProfesional(String nombre, Vector<PlanCurricular> mallas) {
        this.mallas = mallas;
        this.nombre = nombre;
    }

    public boolean agregar(){
        return false;
         
    }
    public boolean eliminar(){
        return false;
         
    }
    
}
