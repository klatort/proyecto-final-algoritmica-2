/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Curso;
import Modelo.PlanteoHorarioCurso;
import Modelo.Profesor;
import Vista.frmReportes;
import javax.swing.DefaultListModel;

/**
 *
 * @author Fabo
 */
public class ControladorReporte {
        
    private frmReportes vista;
    
    public ControladorReporte(frmReportes vista, PlanteoHorarioCurso model){       
            
        //CONFIGURANDO PUNTOS QUE SOLO ES POSIBLE POR CÓDIGO//
        this.vista = vista;
        
        var cursos = model.getCursosSinProfesor();
        var profes = model.getCursosProfesorSinCargaCompleta();
        
        var a = new DefaultListModel();
        for (Curso curso : cursos) {
            a.addElement(curso);
        }
        this.vista.listCursos.setModel(a);
        var b = new DefaultListModel();
        for (Profesor profe : profes) {
            b.addElement(profe.getNombre() + " (Horas faltantes: " + profe.getHorasFaltantes() + ")");
        }
        this.vista.listProfes.setModel(b);
    }
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
}
