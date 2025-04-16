package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            //Notificación
            Notidicacion notificador = new Notidicacion();

            //Generar registro en txt
            GenerarRegistro registroTxt = new GenerarRegistrorTxT("inscripciones.txt");

            //Generar registro en base de datos
            GenerarRegistro registroBd = new CargarRegistroBd();

            //Crear concurso
            Concurso concurso = new Concurso(
                    "Concurso de Fotografía",
                    LocalDate.of(2025, 4, 1),
                    LocalDate.of(2025, 4, 30),
                    notificador , registroTxt
            );

            //Crear participante
            Participante participante = new Participante("Ana Gómez", "Pérez", "juan@example.com" );

            //Fecha de inscripción
            LocalDate fechaInscripcion = LocalDate.now();


            if (concurso.validarIncripcion(fechaInscripcion, participante)) {
                //Guardar en archivo TXT
                registroTxt.registrarInscripcionArchivo(concurso, participante, fechaInscripcion);

                //Guardar en base de datos
//                registroBd.registrarInscripcionArchivo(concurso, participante, fechaInscripcion);

            }

        } catch (Exception e) {

        }
    }
}

