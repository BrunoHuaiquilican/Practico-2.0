package test.unr;
import org.example.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void testValidarInscripcionConNotificacionExitosa() throws Exception {

        NotificarFake notificacionFake = new NotificarFake();
        LocalDate fechaInicio = LocalDate.of(2025, 4, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 4, 30);
        Concurso concurso = new Concurso("Concurso de Ciencia", fechaInicio, fechaCierre, notificacionFake);
        Participante participante = new Participante("Juan", "Pérez", "juan@example.com");
        LocalDate fechaInscripcion = LocalDate.of(2025, 4, 5);


        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);


        assertTrue(resultado);
        assertTrue(notificacionFake.fueLlamado());
        assertEquals("juan@example.com", notificacionFake.getDestinatario());
        assertEquals("Inscripción exitosa", notificacionFake.getAsunto());
        assertTrue(notificacionFake.getCuerpo().contains("Concurso de Ciencia"));
    }
    @Test
    public void testRegistroDeInscripcionConFake() throws Exception {
        // Arrange
        NotificarFake notificacionFake = new NotificarFake();
        RegistrarIncripcionFake registroFake = new RegistrarIncripcionFake();

        LocalDate fechaInicio = LocalDate.of(2025, 4, 1);
        LocalDate fechaCierre = LocalDate.of(2025, 4, 30);
        Concurso concurso = new Concurso("Concurso de Matemáticas", fechaInicio, fechaCierre, notificacionFake);
        Participante participante = new Participante("Ana", "Gómez", "ana@example.com");
        LocalDate fechaInscripcion = LocalDate.of(2025, 4, 10);


        boolean resultado = concurso.validarIncripcion(fechaInscripcion, participante);
        registroFake.registrarInscripcionArchivo(concurso, participante, fechaInscripcion);


        assertTrue(resultado);
        assertTrue(notificacionFake.fueLlamado());
        assertTrue(registroFake.fueLlamado());


        String datosEsperados = "Concurso de Matemáticas,0," + participante.getIdParticipante() + ",Ana,2025-04-10";
        assertEquals(datosEsperados, registroFake.datosRegistrados());
    }
    @Test
    public void testGenerarRegistroTxtFake() throws Exception {

        GenerarRegistroTxtFake registroTxtFake = new GenerarRegistroTxtFake();
        NotificarFake notificacionFake = new NotificarFake();

        Concurso concurso = new Concurso("Fotografía", LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 4, 20), notificacionFake);
        Participante participante = new Participante("Lucas", "Ruiz", "lucas@correo.com");
        LocalDate fecha = LocalDate.of(2025, 4, 5);


        boolean inscripto = concurso.validarIncripcion(fecha, participante);
        registroTxtFake.registrarInscripcionArchivo(concurso, participante, fecha);


        assertTrue(inscripto);
        assertTrue(registroTxtFake.fueRegistrado());

        String esperado = "Fotografía,0," + participante.getIdParticipante() + ",Lucas,2025-04-05";
        assertEquals(esperado, registroTxtFake.getLineaGenerada());
    }
}

