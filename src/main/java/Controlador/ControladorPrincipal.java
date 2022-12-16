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
        
        
        //DATA TEMPORAL SE BORRARÁ CUANDO HAYA UNA BD//
        Horario horario1 = new Horario(18, 21, "Viernes");
        Horario horario2 = new Horario(14, 16, "Sábado");
        
        Horario[] horarioProfesor = new Horario[2];
        horarioProfesor[0] = horario1;
        horarioProfesor[1] = horario2;
        
        Profesor profesor1 = new Profesor("Auxiliar", "uncódigo", "Chumacero Calle", horarioProfesor);
        Profesor profesor2 = new Profesor("Principal", "uncódigo", "Suiberto Laguna", horarioProfesor);

                
        Curso algoritmicaII = new Curso("202W0401", "Algorítmica II", 3, 4);
        Curso procesosSoftware = new Curso("202W0406", "Procesos de software", 4, 4);
        
        algoritmicaII.addProfe(profesor1);
        algoritmicaII.addProfe(profesor2);
        procesosSoftware.addProfe(profesor1);
        procesosSoftware.addProfe(profesor2);
        
        PlanCurricular plan2017 = new PlanCurricular("2017");
        plan2017.addCurso(algoritmicaII);
        plan2017.addCurso(procesosSoftware);
        
        
        EscuelaProfesional escuelaSoftware = new EscuelaProfesional("Ingeniería de Software");
        escuelaSoftware.addMalla(plan2017);

        //PlanteoHorarioCurso horarioCurso = new PlanteoHorarioCurso();
        
        
        
        //CONFIGURANDO PUNTOS QUE SOLO ES POSIBLE POR CÓDIGO//
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        vista.tableHorario.setDefaultRenderer(String.class, centerRenderer);
        
        vista.panelCarreraPlan.show(false);
        vista.tableHorario.getColumnModel().getColumn(0).setPreferredWidth(50);
        vista.tableHorario.getColumnModel().getColumn(0).setMaxWidth(50);
        
        for(int i = 0; i < 15; i++){
            vista.tableHorario.getModel().setValueAt(Integer.toString(i + 8) + ":00", i, 0);
        }
        
        vista.btnRegresar.addActionListener((ActionEvent ev) -> {
            vista.panelMostrarHorario.show(false);
        });
        
        ////////////////////////////////////////////
        
        PlanteoHorarioCurso test = new PlanteoHorarioCurso();
        test.plantearHorarios(plan2017.getCursos());
        vista.lblCurso.setText(test.getHorariosCursos().getHorarioCurso(0).getCurso().toString());
        for(var it : test.getHorariosCursos().getHorarioCurso(0).getGrupos()){
            int aux;
            switch(it.horario.getDiaSemana()){
                case "Lunes" -> aux = 1;
                case "Martes" -> aux = 2;
                case "Miércoles" -> aux = 3;
                case "Jueves" -> aux = 4;
                case "Viernes" -> aux = 5;
                case "Sábado" -> aux = 6;
                case "Domingo" -> aux = 7;
                default -> aux = 0;
            }
            for(int i = it.horario.getInicio() - 8; i < it.horario.getFin() - 7; i++){
                var result = vista.tableHorario.getModel().getValueAt(i, aux);
                if(result == null){
                    vista.tableHorario.setValueAt(it.profesor, i, aux);                    
                }else{
                    vista.tableHorario.setValueAt(result + " - " + it.profesor, i, aux);                     
                }
            }
        }
        this.vista = vista;
    }
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}

