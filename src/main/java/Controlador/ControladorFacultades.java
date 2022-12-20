/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Facultad;
import Modelo.EscuelaProfesional;
import Modelo.PlanCurricular;
import Vista.frmCursos;
import Vista.frmFacultades;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Fabo
 */
public class ControladorFacultades implements ItemListener {
    
    private frmFacultades vista;
    
    public ControladorFacultades(frmFacultades vista, Facultad[] grupos){       
            
        //CONFIGURANDO PUNTOS QUE SOLO ES POSIBLE POR CÓDIGO//
        this.vista = vista;

        this.vista.boxFacultad.setModel(new DefaultComboBoxModel(grupos));
        this.vista.boxFacultad.setSelectedIndex(-1);
        this.vista.boxFacultad.addItemListener(this);
        this.vista.boxEscuela.setModel(new DefaultComboBoxModel());
        this.vista.boxPlan.setModel(new DefaultComboBoxModel());
        
        this.vista.btnIngresar.addActionListener((ActionEvent ev) -> {            
            PlanCurricular aux = (PlanCurricular)this.vista.boxPlan.getSelectedItem();
            ControladorCursos vistaCursos = new ControladorCursos(new frmCursos(), aux.getCursos(), this.vista.boxFacultad.getSelectedItem().toString() + this.vista.boxEscuela.getSelectedItem().toString() + this.vista.boxPlan.getSelectedItem().toString());
            vistaCursos.iniciar();
        });
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getSource());
        if (e.getSource()==this.vista.boxFacultad) {
            Facultad aux = (Facultad) this.vista.boxFacultad.getSelectedItem();
            this.vista.boxEscuela.removeItemListener(this);
            this.vista.boxEscuela.setModel(new DefaultComboBoxModel(aux.getCarreras()));
            this.vista.boxEscuela.setSelectedIndex(-1);
            this.vista.boxPlan.setModel(new DefaultComboBoxModel());
            this.vista.boxEscuela.addItemListener(this);
        }
        if (e.getSource()==this.vista.boxEscuela) {
            EscuelaProfesional aux = (EscuelaProfesional) this.vista.boxEscuela.getSelectedItem();
            this.vista.boxPlan.setModel(new DefaultComboBoxModel(aux.getMallas()));
            this.vista.boxPlan.setSelectedIndex(-1);
        }
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}