
package Modelo;

import java.io.Serializable;

public class Profesor implements Serializable {
    private String nombre;
    private String codigoInterno;
    private String tipoDocente;
    private String tiempoTrabajo;
    private String[] cursosPreferencia;
    private int horasFaltantes;
    private Horario[] disponibilidad;
    
    public Profesor(String tipoDocente, String codigoInterno, String nombre, String tiempoTrabajo, Horario[] disponibilidad) {
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.cursosPreferencia = new String[0];
        this.tipoDocente = tipoDocente;
        this.horasFaltantes = this.setHorasFaltantes();
        this.tiempoTrabajo = tiempoTrabajo;
    }
    
    private int setHorasFaltantes(){
        int horas = 0;
        for(var it : this.disponibilidad){
            horas += it.getFin() - it.getInicio() + 1;
        }
        return horas;
    }
    
    public boolean addCurso(String e){
       var aux = new String[this.cursosPreferencia.length + 1];
       System.arraycopy(this.cursosPreferencia, 0, aux, 0, this.cursosPreferencia.length);
       aux[this.cursosPreferencia.length] = e;
       this.cursosPreferencia = aux;
       return true;
    }
    
    public boolean removeDisponibilidad(int index){
        var aux = new Horario[this.disponibilidad.length - 1];
        for (int i = 0, k = 0; i < this.disponibilidad.length; i++) {
            if (i == index) {
                continue;
            }
            aux[k++] = this.disponibilidad[i];
        }
        this.disponibilidad = aux;        
        return true;
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
