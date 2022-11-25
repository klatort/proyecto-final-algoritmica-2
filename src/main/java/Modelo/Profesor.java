
package Modelo;

import java.util.Vector;

public class Profesor extends Persona{
    private String tipoDocente;
    private int horasFaltantes;
    private Vector<Horario> disponibilidad;
    
    public Profesor(String tipoDocente, String codigoInterno, String nombre, Vector<Horario> disponibilidad) {
        super(codigoInterno, nombre);
        this.disponibilidad = disponibilidad;
        this.tipoDocente = tipoDocente;
        this.horasFaltantes = 12;
    }

    public Vector<Horario> getDisponibilidad() {
        return disponibilidad;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public int getHorasFaltantes() {
        return horasFaltantes;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDisponibilidad(Vector<Horario> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setHorasFaltantes(int horasFaltantes) {
        this.horasFaltantes = horasFaltantes;
    }
    
   public boolean estaDisponible(){
       if(this.horasFaltantes <= 0){
           return true;
       }
       return false;
   }
}
