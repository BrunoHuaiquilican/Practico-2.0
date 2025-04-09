package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private int idConcurso;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaCierre;
    private List<Participante> inscritos;
    private ServicioNotificacion servicioNotificacion;

    public Concurso(String nombre, LocalDate fechaInicio, LocalDate fechaCierre,
                    ServicioNotificacion notificacion) {
        if(nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del concurso no puede estar vacío");
        }
        if(fechaInicio == null || fechaCierre == null){
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        if(fechaInicio.isAfter(fechaCierre)){
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de cierre");
        }
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaCierre = fechaCierre;
        this.inscritos = new ArrayList<>();
        this.servicioNotificacion = notificacion;

    }

    public boolean validarIncripcion(LocalDate fecha, Participante participante) throws Exception {
        if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaCierre)) {
            inscritos.add(participante);
            servicioNotificacion.enviarEmail(participante.getEmail(), "Inscripción exitosa",
                    "Te has inscrito exitosamente al concurso " + nombre);

            return true;
        }
        return false;
    }
    public String getNombre() {
        return nombre;
    }
    public int getIdConcurso() {
        return idConcurso;
    }
    public boolean participanteInscripto(Participante participante) {
        return inscritos.contains(participante);
    }
}

