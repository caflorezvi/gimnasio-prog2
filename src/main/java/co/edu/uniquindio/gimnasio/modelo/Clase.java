package co.edu.uniquindio.gimnasio.modelo;

import co.edu.uniquindio.gimnasio.modelo.enums.TipoClase;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Clase {

    private String id;
    private String nombre;
    private List<String> horario;
    private int capacidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean disponible;
    private TipoClase tipoClase;
    private Entrenador entrenador;
    private List<Reserva> inscritos;

    public Clase(String id, String nombre, List<String> horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin, TipoClase tipoClase, Entrenador entrenador, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.disponible = disponible;
        this.tipoClase = tipoClase;
        this.entrenador = entrenador;
        this.inscritos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHorario() {
        return horario;
    }

    public void setHorario(List<String> horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Reserva> getInscritos() {
        return inscritos;
    }

    public void agregarReserva(Reserva reserva){
        inscritos.add(reserva);
        actualizarDisponibilidad();
    }

    public void cancelarReserva(String numIdentificacionUsuario){
        Reserva reserva = buscarReserva(numIdentificacionUsuario);
        if(reserva != null){
            inscritos.remove(reserva);
            actualizarDisponibilidad();
        }
    }

    private Reserva buscarReserva(String numIdentificacionUsuario){
        for (Reserva reserva : inscritos) {
            if(reserva.getCliente().getNumIdentificacion().equals(numIdentificacionUsuario)){
                return reserva;
            }
        }
        return null;
    }

    private void actualizarDisponibilidad(){
        if(inscritos.size() == capacidad){
            disponible = false;
        }else{
            disponible = true;
        }
    }

    public int obtenerCuposDisponibles(){
        return capacidad - inscritos.size();
    }

}