package co.edu.uniquindio.gimnasio.app;

import co.edu.uniquindio.gimnasio.modelo.Gimnasio;
import co.edu.uniquindio.gimnasio.modelo.enums.TipoClase;
import co.edu.uniquindio.gimnasio.modelo.enums.TipoEntrenamiento;

import java.time.LocalDate;
import java.util.List;

public class GimnasioApp {

    public static void main(String[] args) throws Exception{

        Gimnasio gimnasio = new Gimnasio();

        gimnasio.registrarEntrenador(
                "456789",
                "Maria Rodriguez",
                "Baile"
        );

        gimnasio.registrarEntrenador(
                "123456",
                "Juan Perez",
                "Deporte y Salud"
        );

        String idClase1 = gimnasio.crearClase(
                "Rumbaterapia adultos mayores",
                List.of("Lunes 6:00 am", "Martes 6:00 am", "Miércoles 6:00 am", "Jueves 6:00 am"),
                1,
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 15),
                TipoClase.ZUMBA,
                "456789"
        );

        String idClase2 = gimnasio.crearClase(
                "Crossfit",
                List.of("Martes 7:00 pm", "Miércoles 7:00 pm", "Jueves 7:00 pm"),
                10,
                LocalDate.of(2024, 9, 5),
                LocalDate.of(2024, 9, 20),
                TipoClase.CROSSFIT,
                "123456"
        );

        gimnasio.registrarCliente(
                "123456789",
                "Carlos Perez",
                "Calle 123",
                "1234567",
                "carlos@email.com",
                "123456"
        );

        gimnasio.crearReserva("123456789", idClase1);

        gimnasio.registrarEntrenamiento(
                "123456789",
                TipoEntrenamiento.CARDIO,
                60,
                100
        );

        System.out.println( gimnasio.obtenerHistorialEntrenamiento("1212") );

    }

}

