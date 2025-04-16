package segundoo.punto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GenerarRegistroTxT implements GenerarRegistro {
    private String archivo;

    public GenerarRegistroTxT(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void generarRegistro(Mesa mesa, LocalDate fecha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(fecha + " - Monto: $" + mesa.estraerTotaldeLaCuenta() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
