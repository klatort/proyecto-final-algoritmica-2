
package Modelo;

public class Profesor extends Persona{
    private Horario [] disponibilidad;
    private float horasElectivas;
    private Curso[] cursosPreferencia;

    public Profesor(Horario[] disponibilidad, float horasElectivas, Curso[] cursosPreferencia, String codigoInterno, String nombre) {
        super(codigoInterno, nombre);
        this.disponibilidad = disponibilidad;
        this.horasElectivas = horasElectivas;
        this.cursosPreferencia = cursosPreferencia;
    }

    public Horario[] getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Horario[] disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getHorasElectivas() {
        return horasElectivas;
    }

    public void setHorasElectivas(float horasElectivas) {
        this.horasElectivas = horasElectivas;
    }

    public Curso[] getCursosPreferencia() {
        return cursosPreferencia;
    }

    public void setCursosPreferencia(Curso[] cursosPreferencia) {
        this.cursosPreferencia = cursosPreferencia;
    }

    @Override
    public String toString() {
        return super.toString()+"Profesor{" + "disponibilidad=" + disponibilidad + ", horasElectivas=" + horasElectivas + ", cursosPreferencia=" + cursosPreferencia + '}';
    }
    
    
}
