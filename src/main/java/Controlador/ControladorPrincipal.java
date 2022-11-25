/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Controlador.PlanteoHorarioCurso;
import Modelo.*;
import java.awt.event.*;
import Vista.frmPrincipal;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Fabo
 */
public class ControladorPrincipal {
    private frmPrincipal vista;
    
    public ControladorPrincipal(frmPrincipal vista){
                
        Horario horario1 = new Horario(18, 21, "Viernes");
        Horario horario2 = new Horario(14, 16, "Sábado");
        
        Horario[] horarioProfesor = { horario1, horario2 };
                
        Profesor profesor1 = new Profesor( horarioProfesor, 10, "uncódigo", "Chumacero Calle");
        Profesor[] profesores = { profesor1 };
                
        Curso algoritmicaII = new Curso(profesores, "202W0401", "Algorítmica II", 6, 40, 4);
        Curso procesosSoftware = new Curso(profesores,"202W0406", "Procesos de software", 4, 40, 4);
        
        Curso[] cursos = { algoritmicaII, procesosSoftware };
     
        PlanCurricular plan2017 = new PlanCurricular("2017", cursos);
        PlanCurricular[] curriculasSoftware = { plan2017 };
        
        EscuelaProfesional EscuelaSoftware = new EscuelaProfesional("Ingeniería de Software", curriculasSoftware);

        PlanteoHorarioCurso horarioCurso = new PlanteoHorarioCurso(profesor1);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        vista.tableHorario.setDefaultRenderer(String.class, centerRenderer);
        
        vista.panelCarreraPlan.show(false);
        vista.tableHorario.getColumnModel().getColumn(0).setPreferredWidth(50);
        vista.tableHorario.getColumnModel().getColumn(0).setMaxWidth(50);
        
        for(int i = 0; i < 15; i++){
            vista.tableHorario.getModel().setValueAt(Integer.toString(i + 8) + ":00", i, 0);
        }
        
        vista.btnRegresar.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                   vista.panelMostrarHorario.show(false);
            }
        });
        
        this.vista = vista;
    }
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}

