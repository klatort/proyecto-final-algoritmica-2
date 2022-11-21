/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class EscuelaProfesional {
    private String nombre;
    private PlanCurricular [] mallas;
    private ArregloAlumnos alumnos;

    public EscuelaProfesional(String nombre, PlanCurricular[] mallas, ArregloAlumnos alumnos) {
        this.nombre = nombre;
        this.mallas = mallas;
        this.alumnos = alumnos;
    }

    public PlanCurricular[] getMallas() {
        return mallas;
    }

    public void setMallas(PlanCurricular[] mallas) {
        this.mallas = mallas;
    }
    
    public boolean agregar(){
        return false;
         
    }
    public boolean eliminar(){
        return false;
         
    }

    @Override
    public String toString() {
        return "EscuelaProfesional{" + "nombre=" + nombre + ", mallas=" + mallas + ", alumnos=" + alumnos + '}';
    }
    
}
