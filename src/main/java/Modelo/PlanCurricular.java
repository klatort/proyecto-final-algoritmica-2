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
public class PlanCurricular {
    private Vector<Curso> cursos;
    private String anio;

    public PlanCurricular(String anio, Vector<Curso> cursos) {
        this.anio = anio;
        this.cursos = cursos;
    }
    
    
}
