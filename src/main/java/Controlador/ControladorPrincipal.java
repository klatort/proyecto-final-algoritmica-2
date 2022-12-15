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
        horarioProfesor[0]=horario1;
        horarioProfesor[1]=horario2;
        
        Profesor profesor1 = new Profesor("Auxiliar", "uncódigo", "Chumacero Calle", horarioProfesor);
        Profesor profesor2 = new Profesor("Principal", "uncódigo", "Suiberto Laguna", horarioProfesor);
        Profesor[] profesoresA = new Profesor[2];
        profesoresA[0] = profesor1;
        profesoresA[1] = profesor2;
        
        Profesor[] profesoresB = new Profesor[1];
        profesoresB[0] = profesor2;
        
        Profesor[] profesoresGeneral = new Profesor[2];
                
        Curso algoritmicaII = new Curso("202W0401", "Algorítmica II", 6, 4, profesoresA);
        Curso procesosSoftware = new Curso("202W0406", "Procesos de software", 4, 4, profesoresB);
        
        algoritmicaII.addProfe(profesor1);
        algoritmicaII.addProfe(profesor2);
        procesosSoftware.addProfe(profesor1);
        
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
        //var aux = test.getHorariosCursos().get(test.getHorariosCursos().keySet().iterator().next());
//        vista.lblCurso.setText(test.getHorariosCursos().keySet().iterator().next().getNombreCurso());
        
        this.vista = vista;
    }
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}

