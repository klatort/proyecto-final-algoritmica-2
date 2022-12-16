
package Vista;

import Controlador.ControladorCursos;
import Modelo.Curso;
import Modelo.EscuelaProfesional;
import Modelo.Horario;
import Modelo.PlanCurricular;
import Modelo.Profesor;

public class App {
    public static void main(String[] args){
        //DATA TEMPORAL SE BORRARÁ CUANDO HAYA UNA BD//
        Horario horario1 = new Horario(18, 21, "Viernes");
        Horario horario2 = new Horario(14, 16, "Sábado");
        
        Horario[] horarioProfesor = new Horario[2];
        horarioProfesor[0] = horario1;
        horarioProfesor[1] = horario2;
        
        Profesor profesor1 = new Profesor("Auxiliar", "uncódigo", "Chumacero Calle", horarioProfesor);
        Profesor profesor2 = new Profesor("Principal", "uncódigo", "Suiberto Laguna", horarioProfesor);
           
        Curso algoritmicaI = new Curso("202W0400", "Algorítmica I", 3, 1);
        Curso procesosSoftware0 = new Curso("202W0405", "Procesos de software 0", 4, 1);
        
        Curso algoritmicaII = new Curso("202W0401", "Algorítmica II", 3, 4);
        Curso procesosSoftware = new Curso("202W0406", "Procesos de software", 4, 4);
        
        Curso algoritmicaIII = new Curso("202W0402", "Algorítmica III", 3, 5);
        Curso procesosSoftwareII = new Curso("202W0407", "Procesos de software II", 4, 5);
        
        algoritmicaI.addProfe(profesor1);
        procesosSoftware0.addProfe(profesor2);
        
        algoritmicaII.addProfe(profesor1);
        algoritmicaII.addProfe(profesor2);
        procesosSoftware.addProfe(profesor1);
        
        algoritmicaIII.addProfe(profesor2);
        procesosSoftwareII.addProfe(profesor1);
        
        PlanCurricular plan2017 = new PlanCurricular("2017");
        plan2017.addCurso(algoritmicaI);
        plan2017.addCurso(procesosSoftware0);
        
        plan2017.addCurso(algoritmicaII);
        plan2017.addCurso(algoritmicaIII);
        
        plan2017.addCurso(procesosSoftware);
        plan2017.addCurso(procesosSoftwareII);
                
        EscuelaProfesional escuelaSoftware = new EscuelaProfesional("Ingeniería de Software");
        escuelaSoftware.addMalla(plan2017);
        
        ControladorCursos vista = new ControladorCursos(new frmCursos(), plan2017.getCursos());
        vista.iniciar();
    }
}
        
