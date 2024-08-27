package co.edu.uniquindio.gimnasio.modelo;

import co.edu.uniquindio.gimnasio.modelo.enums.TipoEntrenamiento;

import java.time.LocalDateTime;

public class Entrenamiento {

    private String numeroSesion;
    private TipoEntrenamiento tipoEjercicio;
    private int duracion;
    private int caloriasQuemadas;
    private LocalDateTime fecha;

    public Entrenamiento(String numeroSesion, TipoEntrenamiento tipoEjercicio, int duracion, int caloriasQuemadas, LocalDateTime fecha) {
        this.numeroSesion = numeroSesion;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.caloriasQuemadas = caloriasQuemadas;
        this.fecha = fecha;
    }

    public String getNumeroSesion() {
        return numeroSesion;
    }

    public void setNumeroSesion(String numeroSesion) {
        this.numeroSesion = numeroSesion;
    }

    public TipoEntrenamiento getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(TipoEntrenamiento tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(int caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "numeroSesion='" + numeroSesion + '\'' +
                ", tipoEjercicio=" + tipoEjercicio +
                ", duracion=" + duracion +
                ", caloriasQuemadas=" + caloriasQuemadas +
                ", fecha=" + fecha +
                '}';
    }
}
