
package Modelo;

public class Alumno extends Persona{
    
    private int sueldo;

    public Alumno(int sueldo, String codigoInterno, String nombre) {
        super(codigoInterno, nombre);
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+"Alumno{" + "sueldo=" + sueldo + '}';
    }
    
    
}
