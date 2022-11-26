
package Modelo;

public abstract class Persona {
    
    protected String codigoInterno;
    protected String nombre;

    public Persona(String codigoInterno, String nombre) {
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre;
    }
}
