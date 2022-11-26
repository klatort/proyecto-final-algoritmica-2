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
import java.util.Vector;
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
        
        Vector<Horario> horarioProfesor = new Vector();
        horarioProfesor.add(horario1);
        horarioProfesor.add(horario2);
                
        Profesor profesor1 = new Profesor("Auxiliar", "uncódigo", "Chumacero Calle", horarioProfesor);
        Profesor profesor2 = new Profesor("Principal", "uncódigo", "Suiberto Laguna", horarioProfesor);
        Vector<Profesor> profesoresA = new Vector();
        profesoresA.add(profesor1);
        profesoresA.add(profesor2);
        
        Vector<Profesor> profesoresB = new Vector();
        profesoresB.add(profesor2);
                
        Curso algoritmicaII = new Curso("202W0401", "Algorítmica II", 6, 4, profesoresA);
        Curso procesosSoftware = new Curso("202W0406", "Procesos de software", 4, 4, profesoresB);
        
        Vector<Curso> cursos = new Vector();
        cursos.add(algoritmicaII);
        cursos.add(procesosSoftware);
        
        PlanCurricular plan2017 = new PlanCurricular("2017", cursos);
        Vector<PlanCurricular> curriculaSoftware = new Vector();
        curriculaSoftware.add(plan2017);
        
        EscuelaProfesional EscuelaSoftware = new EscuelaProfesional("Ingeniería de Software", curriculaSoftware);

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
        test.plantearHorarios(cursos);
        var aux = test.getHorariosCursos().get(test.getHorariosCursos().keySet().iterator().next());
        System.out.println();
        vista.lblCurso.setText(test.getHorariosCursos().keySet().iterator().next().getNombreCurso());
        
        this.vista = vista;
    }
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}

