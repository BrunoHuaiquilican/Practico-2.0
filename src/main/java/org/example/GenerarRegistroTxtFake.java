package org.example;

import java.time.LocalDate;

public class GenerarRegistroTxtFake implements GenerarRegistro{
    private String lineaGenerada;

    @Override
    public void registrarInscripcionArchivo(Concurso concurso, Participante participante, LocalDate fechaInscripcion) {
        lineaGenerada = concurso.getNombre() + "," +
                concurso.getIdConcurso() + "," +
                participante.getIdParticipante() + "," +
                participante.getNombre() + "," +
                fechaInscripcion;
    }

    public String getLineaGenerada() {
        return lineaGenerada;
    }

    public boolean fueRegistrado() {
        return lineaGenerada != null;
    }
}
