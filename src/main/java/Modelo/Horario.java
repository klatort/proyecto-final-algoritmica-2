/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public class Horario {
    private int inicio;
    private int fin;
    private String diaSemana;

    public Horario(int inicio, int fin, String diaSemana) {
        this.inicio = inicio;
        this.fin = fin;
        this.diaSemana = diaSemana;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }

    public String getDiaSemana() {
        return diaSemana;
    }
    
    public boolean chocaHorario(Horario horario){
        return !(horario.getInicio() > this.fin) && horario.getFin() > this.inicio && this.diaSemana.equals(horario.diaSemana);
    }
    
}
