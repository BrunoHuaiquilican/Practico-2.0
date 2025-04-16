package segundoo.punto;

import java.time.LocalDate;

public class GenerarRegistroTxTFake implements GenerarRegistro{

    private String lineaGenerada;
    @Override
    public void generarRegistro(Mesa mesa, LocalDate fecha) {
        lineaGenerada = mesa.estraerTotaldeLaCuenta()+ "," +
                fecha;
    }
    public String getLineaGenerada() {
        return lineaGenerada;
    }

    public boolean fueRegistrado() {
        return lineaGenerada != null;
    }
}
