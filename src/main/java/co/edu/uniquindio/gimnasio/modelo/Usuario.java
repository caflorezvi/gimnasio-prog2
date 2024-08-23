package co.edu.uniquindio.gimnasio.modelo;

public class Usuario {
    private String numIdentificacion;
    private String nombre;

    private Usuario() {
    }

    public Usuario(String numIdentificacion, String nombre) {
        this.numIdentificacion = numIdentificacion;
        this.nombre = nombre;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
