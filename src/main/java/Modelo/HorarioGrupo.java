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
public class HorarioGrupo implements Serializable {
    public Horario horario;
    public String profesor;

    public HorarioGrupo(Horario horario, String profesor) {
        this.horario = horario;
        this.profesor = profesor;
    }
}
