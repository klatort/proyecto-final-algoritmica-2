
package Modelo;

import java.util.Vector;

public class Profesor{
    private String nombre;
    private String codigoInterno;
    private String tipoDocente;
    private String[] cursosPreferencia;
    private int horasFaltantes;
    private Horario[] disponibilidad;
    
    public Profesor(String tipoDocente, String codigoInterno, String nombre, String[] cursosPreferencia) {
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.disponibilidad = new Horario[0];
        this.cursosPreferencia = cursosPreferencia;
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
