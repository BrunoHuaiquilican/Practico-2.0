package segundoo.punto;

import java.sql.*;
import java.time.LocalDate;

public class guardarRegistroBd implements GenerarRegistro {

    private String URL = "jdbc:mysql://localhost:3306/ventasbd";
    private String USUARIO = "root";
    private String PASSWORD = "";

    @Override
    public void generarRegistro(Mesa mesa, LocalDate fecha) {

        String sql = "INSERT INTO compras (fecha, monto) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USUARIO,  PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(fecha));
            stmt.setDouble(2, mesa.estraerTotaldeLaCuenta() );

            stmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
