package co.edu.uniquindio.gimnasio.modelo;

import co.edu.uniquindio.gimnasio.modelo.enums.TipoClase;
import co.edu.uniquindio.gimnasio.modelo.enums.TipoEntrenamiento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Gimnasio {

    private final List<Clase> clases;
    private final List<Cliente> clientes;
    private final List<Entrenador> entrenadores;

    public Gimnasio() {
        this.clases = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
    }

    public void registrarCliente(String numIdentificacion, String nombre, String direccion, String telefono, String correo, String password) throws Exception{

        if (buscarCliente(numIdentificacion) != null) {
            throw new Exception("El cliente ya se encuentra registrado");
        }

        Cliente cliente = new Cliente(
                numIdentificacion,
                nombre,
                direccion,
                telefono,
                correo,
                password
        );

        clientes.add(cliente);
    }

    public Cliente buscarCliente(String numIdentificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumIdentificacion().equals(numIdentificacion)) {
                return cliente;
            }
        }
        return null;
    }

    public void actualizarCliente(String numIdentificacion, String nombre, String direccion, String telefono, String correo, String password) throws Exception{
        Cliente cliente = buscarCliente(numIdentificacion);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }
        cliente.setNombre(nombre);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);
        cliente.setPassword(password);
    }

    public void eliminarCliente(String numIdentificacion) throws Exception{
        Cliente cliente = buscarCliente(numIdentificacion);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }
        clientes.remove(cliente);
    }

    public void registrarEntrenador(String numIdentificacion, String nombre, String especialidad) throws Exception{

        if (buscarEntrenador(numIdentificacion) != null) {
            throw new Exception("El entrenador ya se encuentra registrado");
        }

        Entrenador entrenador = new Entrenador(numIdentificacion, nombre, especialidad);
        entrenadores.add(entrenador);
    }

    public Entrenador buscarEntrenador(String numIdentificacion) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getNumIdentificacion().equals(numIdentificacion)) {
                return entrenador;
            }
        }
        return null;
    }

    public String crearClase(String nombre, List<String> horario, int capacidad, LocalDate fechaInicio, LocalDate fechaFin, TipoClase tipoClase, String numIdentificacionEntrenador) throws Exception{

        if(capacidad <= 0){
            throw new Exception("La capacidad de la clase debe ser mayor a 0");
        }

        if(fechaInicio.isAfter(fechaFin)){
            throw new Exception("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        Entrenador entrenador = buscarEntrenador(numIdentificacionEntrenador);
        if (entrenador == null) {
            throw new Exception("El entrenador no se encuentra registrado");
        }

        Clase clase = new Clase(
                UUID.randomUUID().toString(),
                nombre,
                horario,
                capacidad,
                fechaInicio,
                fechaFin,
                tipoClase,
                entrenador,
                true
        );

        clases.add(clase);
        return clase.getId();
    }

    public Clase buscarClase(String idClase) {
        for (Clase clase : clases) {
            if (clase.getId().equals(idClase)) {
                return clase;
            }
        }
        return null;
    }

    public String registrarEntrenamiento(String numIdentificacionUsuario, TipoEntrenamiento tipoEjercicio, int duracion, int caloriasQuemadas) throws Exception{

        Cliente cliente = buscarCliente(numIdentificacionUsuario);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }

        Entrenamiento entrenamiento = new Entrenamiento(
                UUID.randomUUID().toString(),
                tipoEjercicio,
                duracion,
                caloriasQuemadas,
                LocalDateTime.now()
        );

        cliente.agregarEntrenamiento(entrenamiento);
        return entrenamiento.getNumeroSesion();
    }

    public String crearReserva(String numIdentificacionUsuario, String idClase) throws Exception{

        Cliente cliente = buscarCliente(numIdentificacionUsuario);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }

        Clase clase = buscarClase(idClase);
        if (clase == null) {
            throw new Exception("La clase no se encuentra registrada");
        }

        if(!clase.isDisponible()){
            throw new Exception("La clase no tiene cupos disponibles");
        }

        Reserva reserva = new Reserva(
                UUID.randomUUID().toString(),
                cliente,
                LocalDateTime.now()
        );

        clase.agregarReserva(reserva);
        return reserva.getCodigo();
    }

    public void cancelarReserva(String numIdentificacionUsuario, String idClase) throws Exception{
        Clase clase = buscarClase(idClase);
        if (clase == null) {
            throw new Exception("La clase no se encuentra registrada");
        }
        Cliente cliente = buscarCliente(numIdentificacionUsuario);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }
        clase.cancelarReserva(numIdentificacionUsuario);
    }

    public int obtenerCuposDisponibles(String idClase) throws Exception{
        Clase clase = buscarClase(idClase);
        if (clase == null) {
            throw new Exception("La clase no se encuentra registrada");
        }
        return clase.obtenerCuposDisponibles();
    }

    public List<Entrenamiento> obtenerHistorialEntrenamiento(String numIdentificacionUsuario) throws Exception{
        Cliente cliente = buscarCliente(numIdentificacionUsuario);
        if (cliente == null) {
            throw new Exception("El cliente no se encuentra registrado");
        }
        return cliente.getEntrenamientos();
    }

    public Clase obtenerClaseMasPopular(){

        Clase claseMasPopular = null;
        int maxReservas = 0;

        for (Clase clase : clases) {
            if(clase.getInscritos().size() > maxReservas){
                claseMasPopular = clase;
                maxReservas = clase.getInscritos().size();
            }
        }

        return claseMasPopular;
    }

    public List<Cliente> obtenerTop3Usuarios(){

        List<Cliente> top3Usuarios = new ArrayList<>();
        List<Cliente> clientesOrdenados = new ArrayList<>(clientes);

        clientesOrdenados.sort((c1, c2) -> c2.sumarCalorias() - c1.sumarCalorias());

        for (int i = 0; i < 3; i++) {
            if(i < clientesOrdenados.size()){
                top3Usuarios.add(clientesOrdenados.get(i));
            }
        }

        return top3Usuarios;

    }

    public TipoEntrenamiento obtenerTipoEntrenamientoMasRealizado(){

        int[] contador = sumarMinutosPorTipoEntrenamiento();
        int max = 0;
        TipoEntrenamiento tipoEntrenamiento = null;

        for (int i = 0; i < contador.length; i++) {
            if(contador[i] > max){
                max = contador[i];
                tipoEntrenamiento = TipoEntrenamiento.values()[i];
            }
        }

        return tipoEntrenamiento;
    }

    private int[] sumarMinutosPorTipoEntrenamiento(){
        int[] contador = new int[TipoEntrenamiento.values().length];

        for (Cliente cliente : clientes) {
            for (Entrenamiento entrenamiento : cliente.getEntrenamientos()) {
                contador[entrenamiento.getTipoEjercicio().ordinal()] += entrenamiento.getDuracion();
            }
        }

        return contador;
    }


}
