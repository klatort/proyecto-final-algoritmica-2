
package Modelo;

import java.util.Vector;

public class Profesor{
    protected String codigoInterno;
    protected String nombre;
    private String tipoDocente;
    private int horasFaltantes;
    private Horario[] disponibilidad;
    
    public Profesor(String tipoDocente, String codigoInterno, String nombre) {
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.disponibilidad = new Horario[0];
        this.tipoDocente = tipoDocente;
        this.horasFaltantes = 6;
    }

    public Horario[] getDisponibilidad() {
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
    
    public void setHorasFaltantes(int horasFaltantes) {
        this.horasFaltantes = horasFaltantes;
    }
    
   public boolean estaDisponible(){
       if(this.horasFaltantes > 0){
           return true;
       }
       return false;
   }
}
