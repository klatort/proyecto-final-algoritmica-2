/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.*;
import java.awt.event.*;
import Vista.frmHorarioCurso;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Fabo
 */
public class ControladorHorarios {
    
    private frmHorarioCurso vista;
    
    public ControladorHorarios(frmHorarioCurso vista, HorariosCurso grupos){       
        
        
        //CONFIGURANDO PUNTOS QUE SOLO ES POSIBLE POR CÓDIGO//
        this.vista = vista;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        this.vista.tableHorario.setDefaultRenderer(String.class, centerRenderer);
        
        this.vista.tableHorario.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.vista.tableHorario.getColumnModel().getColumn(0).setMaxWidth(50);
        
        for(int i = 0; i < 15; i++){
            this.vista.tableHorario.getModel().setValueAt(Integer.toString(i + 8) + ":00", i, 0);
        }
        
        this.vista.btnRegresar.addActionListener((ActionEvent ev) -> {
            this.vista.dispose();
        });
        
        ////////////////////////////////////////////
        
        this.vista.lblCurso.setText(grupos.getCurso().getNombreCurso());
        int cont = 1;
        for(var it : grupos.getGrupos()){
            int aux;
            switch(it.horario.getDiaSemana()){
                case "Lunes" -> aux = 1;
                case "Martes" -> aux = 2;
                case "Miércoles" -> aux = 3;
                case "Jueves" -> aux = 4;
                case "Viernes" -> aux = 5;
                case "Sábado" -> aux = 6;
                case "Domingo" -> aux = 7;
                default -> aux = 1;
            }
            for(int i = it.horario.getInicio() - 8; i < it.horario.getFin() - 7; i++){
                var result = vista.tableHorario.getModel().getValueAt(i, aux);
                if(result == null){
                    vista.tableHorario.setValueAt(it.profesor + " Grupo " + cont, i, aux);                    
                }else{
                    vista.tableHorario.setValueAt(result + " - " + it.profesor + " Grupo " + cont, i, aux);                     
                }
            }
            cont++;
        }
    }
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}

