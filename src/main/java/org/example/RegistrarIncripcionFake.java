package org.example;

import java.time.LocalDate;

public class RegistrarIncripcionFake implements GenerarRegistro {
    private boolean llamado = false;
    private Concurso concurso;
    private Participante participante;
    private LocalDate fecha;


    @Override
    public void registrarInscripcionArchivo(Concurso concurso, Participante participante, LocalDate fechaInscripcion) throws Exception {
        this.llamado = true;
        this.concurso = concurso;
        this.participante = participante;
        this.fecha = fechaInscripcion;
    }

    public boolean fueLlamado() {
        return llamado;
    }
    public String datosRegistrados() {
        return concurso.getNombre() + "," + concurso.getIdConcurso() + "," + participante.getIdParticipante() + "," + participante.getNombre() + "," + fecha;
    }
}
