package co.edu.uniquindio.gimnasio.modelo;

import java.time.LocalDateTime;

public class Reserva {

    private String codigo;
    private Cliente cliente;
    private LocalDateTime fechaReserva;

    public Reserva(String codigo, Cliente cliente, LocalDateTime fechaReserva) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

}
