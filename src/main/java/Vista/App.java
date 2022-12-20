
package Vista;

import Modelo.*;
import Libraries.Persistencia;
import Controlador.ControladorFacultades;
import java.io.FileNotFoundException;
import java.io.IOException;/*
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;*/

public class App {
    /*
    public static Horario generarHorario(){
        int inicio = (int) (Math.random() * 12 + 8);
        int fin = inicio + (int) (Math.random() * 4 + 3);
        String diaSemana;
        int r = (int) (Math.random() * 7);
        switch(r){
            case 0 -> diaSemana = "Lunes";
            case 1 -> diaSemana = "Martes";
            case 2 -> diaSemana = "Miércoles";
            case 3 -> diaSemana = "Jueves";
            case 4 -> diaSemana = "Viernes";
            case 5 -> diaSemana = "Sábado";
            case 6 -> diaSemana = "Domingo";
            default -> diaSemana = "Lunes";
        }
        return new Horario(inicio, fin, diaSemana);
    }
    
    public static boolean verificarProfes(Profesor[] profes, Profesor profe){
        for(int i = 0; i < profes.length; i++){
            if(profes[i] == profe){
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarChoque(Horario[] horarios, int index){
        for(int i = 0; i < 5; i++){
            if(horarios[i] != null && i != index){
                if(horarios[i].chocaHorario(horarios[index])){
                    return true;
                }
            }
        }
        return false;
    }*/
    
    public static void main(String[] args) throws FileNotFoundException, IOException{

        /*
        //DATA TEMPORAL SE BORRARÁ CUANDO HAYA UNA BD//
        
        File file1 = new File("Profesores.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        String st1;
        Vector<Profesor> vec = new Vector<Profesor>();
        while ((st1 = br1.readLine()) != null){
            String[] result = st1.split(", ");
            Horario[] horarios = new Horario[5];
            for(int i = 0; i < 5; i++){
                do{
                    horarios[i] = generarHorario();
                }while(verificarChoque(horarios, i));
            }
            vec.add(new Profesor(result[0], result[1], result[2], result[3], horarios));
        }
        
        PlanCurricular plan2018 = new PlanCurricular("2018");
        EscuelaProfesional escuelaSoftware = new EscuelaProfesional("Ingeniería de Software");
        escuelaSoftware.addMalla(plan2018);
        Facultad FISI = new Facultad("FISI");
        FISI.addCarrera(escuelaSoftware);
        
        File file = new File("Cursos.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        for(var pro : vec){
            System.out.println(pro);
        }
        while ((st = br.readLine()) != null){
            String[] result = st.split(", ");
            Curso aux = new Curso(result[0], result[1], Integer.parseInt(result[2]), Integer.parseInt(result[3]));
            int r = (int) (Math.random() * 6 + 1);
            for(int i = 0; i < r; i++){
                Profesor p = null;
                do{
                    p = vec.elementAt((int) (Math.random() * vec.size()));                    
                }while(verificarProfes(aux.getProfesDictan(), p));
                aux.addProfe(p);
            }
            plan2018.addCurso(aux);
            
        }
        
        
        Facultad[] UNMSM = new Facultad[1];
        UNMSM[0] = FISI;
        Persistencia.serialize(UNMSM, "datos");*/

        Facultad[] UNMSM = (Facultad[])Persistencia.deserialize("datos");
        ControladorFacultades vista = new ControladorFacultades(new frmFacultades(), UNMSM);
        vista.iniciar();
    }
}