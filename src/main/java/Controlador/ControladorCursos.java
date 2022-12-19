/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.PlanteoHorarioCurso;
import Modelo.Curso;
import Vista.frmCursos;
import Vista.frmHorarioCurso;
import controlador.ControladorHorarios;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.*;
/**
 *
 * @author Fabo
 */
public class ControladorCursos {
    private frmCursos vista;
    private PlanteoHorarioCurso modelo;
    
    public ControladorCursos(frmCursos vista, Curso[] cursos){
        this.vista = vista;
        this.modelo = new PlanteoHorarioCurso();        

        this.modelo.plantearHorarios(cursos);
        GridBagConstraints constraints = new GridBagConstraints( );
        constraints.insets = new Insets(5,5,5,5);
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        for(int i = 0; i < 10; i++){
            var aux = new JLabel();
            aux.setText("Ciclo " + (i + 1));
            aux.setFont(new Font(aux.getName(), Font.PLAIN, 20));
            constraints.gridx = 0;
            constraints.gridy = i * 10;
            this.vista.panelCursos.add(aux,  constraints);
            int x = 0, y = i * 10 + 1;
            for (Curso curso : cursos) {
                if(curso != null && curso.getCicloLleva() == i + 1){
                    constraints.gridx = x;
                    constraints.gridy = y;
                    var btnCurso = new JButton();
                    btnCurso.addActionListener((ActionEvent ev) -> {            
                        ControladorHorarios vistaCurso = new ControladorHorarios(new frmHorarioCurso(),this.modelo.getHorariosCursos().getHorarioCurso(this.modelo.getHorariosCursos().existHorariosCurso(curso)));
                        vistaCurso.iniciar();
                    });
                    btnCurso.setText(curso.getNombreCurso());
                    this.vista.panelCursos.add(btnCurso, constraints);
                    if(x == 4){
                        x = 0;
                        y += 1;
                    }else{
                        x++;
                    }        
                }
            }
        }
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
