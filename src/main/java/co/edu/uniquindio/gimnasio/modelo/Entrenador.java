package co.edu.uniquindio.gimnasio.modelo;

public class Entrenador extends Usuario{

    private String especialidad;

    public Entrenador(String numIdentificacion, String nombre, String especialidad) {
        super(numIdentificacion, nombre);
        this.especialidad = especialidad;
    }
}
