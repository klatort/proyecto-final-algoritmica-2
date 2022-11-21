
package Modelo;

public class Alumno extends Persona{
    
    private int ciclo;

    public Alumno(int ciclo, String codigoInterno, String nombre) {
        super(codigoInterno, nombre);
        this.ciclo = ciclo;
    }

    public int getSueldo() {
        return ciclo;
    }

    public void setSueldo(int ciclo) {
        this.ciclo = ciclo;
    }
    
}
