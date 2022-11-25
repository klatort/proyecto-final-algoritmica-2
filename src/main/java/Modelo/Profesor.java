
package Modelo;

public class Profesor extends Persona{
    private Horario [] disponibilidad;
    private int horasElectivas;

    public Profesor(Horario[] disponibilidad, int horasElectivas, String codigoInterno, String nombre) {
        super(codigoInterno, nombre);
        this.disponibilidad = disponibilidad;
        this.horasElectivas = horasElectivas;
    }

    public Horario[] getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Horario[] disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getHorasElectivas() {
        return horasElectivas;
    }

    public void setHorasElectivas(int horasElectivas) {
        this.horasElectivas = horasElectivas;
    }

    @Override
    public String toString() {
        return super.toString()+"Profesor{" + "disponibilidad=" + disponibilidad + ", horasElectivas=" + horasElectivas + '}';
    }
    
    
}
