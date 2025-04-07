package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GenerarRegistrorTxT implements GenerarRegistro {
    private String archivo;
    public GenerarRegistrorTxT(String archivo) {
        this.archivo = archivo;
    }


    public void registrarInscripcionArchivo(Concurso concurso, Participante participante, LocalDate fechaInscripcion) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(concurso.getNombre()  + "," + concurso.getIdConcurso() +  "," + participante.getIdParticipante()  + "," + participante.getNombre() +
                    "," + fechaInscripcion+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
