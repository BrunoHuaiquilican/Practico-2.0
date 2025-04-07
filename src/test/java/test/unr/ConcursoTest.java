package test.unr;
import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    void testInscripcionConNotificacionFake() throws Exception {
        // Fake de notificación
        NotificarFake notificadorFake = new NotificarFake();

        // Creamos el concurso solo con la notificación fake
        Concurso concurso = new Concurso(
                "Concurso Fotografía",
                LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 31),
                notificadorFake
        );

        // Participante y fecha de inscripción válida
        Participante participante = new Participante("Juan Pérez", "Perez");
        LocalDate fecha = LocalDate.of(2024, 3, 10);

        // Ejecutamos inscripción
        boolean resultado = concurso.validarIncripcion(fecha, participante);

        // Verificamos
        assertTrue(resultado);
        assertTrue(concurso.participanteInscripto(participante));
        assertTrue(notificadorFake.fueLlamado());
    }
}
