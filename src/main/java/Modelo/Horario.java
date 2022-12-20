
package Modelo;

import java.io.Serializable;

public class Horario implements Serializable{
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

    @Override
    public String toString() {
        return "Horario{" + "inicio=" + inicio + ", fin=" + fin + ", diaSemana=" + diaSemana + '}';
    }
    
}
