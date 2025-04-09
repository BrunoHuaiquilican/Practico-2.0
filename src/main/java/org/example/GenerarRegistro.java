package org.example;

import java.time.LocalDate;

public interface GenerarRegistro {

    void registrarInscripcionArchivo(Concurso concurso, Participante participante, LocalDate fechaInscripcion) throws Exception;
}
