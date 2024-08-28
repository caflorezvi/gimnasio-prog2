package co.edu.uniquindio.gimnasio;

import co.edu.uniquindio.gimnasio.modelo.Gimnasio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GimnasioTest {

    @Test
    public void registroClienteTest(){

        //Se crea una instancia de la clase Gimnasio
        Gimnasio gimnasio = new Gimnasio();

        //Se verifica que no se lance ninguna excepción al registrar un cliente
        assertDoesNotThrow(() -> {
            //Se registra un cliente en el gimnasio
            gimnasio.registrarCliente(
                    "123456789",
                    "Carlos Perez",
                    "Calle 123",
                    "1234567",
                    "carlos@email.com",
                    "123456"
            );
        });

    }

    @Test
    public void registroEntrenadorTest(){

        Gimnasio gimnasio = new Gimnasio();

        assertDoesNotThrow(() -> {
            gimnasio.registrarEntrenador(
                    "113",
                    "Juan",
                    "Crossfit"
            );
        });

        assertThrows(Exception.class, () -> {
            gimnasio.registrarEntrenador(
                    "113",
                    "Juan",
                    "Crossfit"
            );
        });

    }

}
