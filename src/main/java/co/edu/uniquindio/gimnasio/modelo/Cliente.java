package co.edu.uniquindio.gimnasio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{

    private String direccion;
    private String telefono;
    private String correo;
    private String password;
    private List<Entrenamiento> entrenamientos;

    public Cliente(String numIdentificacion, String nombre, String direccion, String telefono, String correo, String password) {
        super(numIdentificacion, nombre);
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void agregarEntrenamiento(Entrenamiento entrenamiento){
        if(entrenamiento == null){
            entrenamientos = new ArrayList<>();
        }
        entrenamientos.add(entrenamiento);
    }

    public int sumarCalorias(){
        int calorias = 0;
        for (Entrenamiento entrenamiento : entrenamientos) {
            calorias += entrenamiento.getCaloriasQuemadas();
        }
        return calorias;
    }

}
