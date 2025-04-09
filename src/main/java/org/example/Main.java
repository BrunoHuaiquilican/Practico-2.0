package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            //Notificación
            Notidicacion notificador = new Notidicacion();

            //Crear concurso
            Concurso concurso = new Concurso(
                    "Concurso de Fotografía",
                    LocalDate.of(2025, 4, 1),
                    LocalDate.of(2025, 4, 30),
                    notificador
            );

            //Crear participante
            Participante participante = new Participante("Ana Gómez", "Pérez", "juan@example.com" );

            //Fecha de inscripción
            LocalDate fechaInscripcion = LocalDate.now();


            if (concurso.validarIncripcion(fechaInscripcion, participante)) {
                //Guardar en archivo TXT
                GenerarRegistro registroTxt = new GenerarRegistrorTxT("inscripciones.txt");
                registroTxt.registrarInscripcionArchivo(concurso, participante, fechaInscripcion);

                //Guardar en base de datos
                GenerarRegistro registroBd = new CargarRegistroBd();
                registroBd.registrarInscripcionArchivo(concurso, participante, fechaInscripcion);

            }

        } catch (Exception e) {

        }
    }
}

