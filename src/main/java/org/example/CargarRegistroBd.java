package org.example;

import java.sql.*;
import java.time.LocalDate;

public class CargarRegistroBd implements GenerarRegistro {

     private String URL= "jdbc:mysql://localhost:3306/tp";
    private String USUARIO = "root";
    private String PASSWORD = "";

    @Override
    public void registrarInscripcionArchivo(Concurso concurso, Participante participante, LocalDate fechaInscripcion) throws Exception {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {

            // 1. Obtener ID del concurso por nombre
            int idConcurso = -1;
            try (PreparedStatement stmtConcurso = con.prepareStatement("SELECT id FROM concursos WHERE nombre = ?")) {
                stmtConcurso.setString(1, concurso.getNombre());
                ResultSet rs = stmtConcurso.executeQuery();
                if (rs.next()) {
                    idConcurso = rs.getInt("id");
                } else {
                    throw new Exception("No se encontró el concurso con nombre: ");
                }
            }

            // 2. Obtener ID del participante por nombre
            int idParticipante = -1;
            try (PreparedStatement stmtParticipante = con.prepareStatement("SELECT id FROM participantes WHERE nombre = ?")) {
                stmtParticipante.setString(1, participante.getNombre());
                ResultSet rs = stmtParticipante.executeQuery();
                if (rs.next()) {
                    idParticipante = rs.getInt("id");
                } else {
                    throw new Exception("No se encontró el participante con nombre: ");
                }
            }

            // 3. Insertar la inscripción
            CrearIncripcion(fechaInscripcion, con, idParticipante, idConcurso);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void CrearIncripcion(LocalDate fechaInscripcion, Connection con, int idParticipante, int idConcurso) throws SQLException {
        try (PreparedStatement stmtInsert = con.prepareStatement(
                "INSERT INTO inscripciones (fecha, id_participante, id_concurso) VALUES (?, ?, ?)")) {
            stmtInsert.setDate(1, Date.valueOf(fechaInscripcion));
            stmtInsert.setInt(2, idParticipante);
            stmtInsert.setInt(3, idConcurso);
            stmtInsert.executeUpdate();
        }
    }
}
