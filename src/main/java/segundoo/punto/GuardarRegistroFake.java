package segundoo.punto;

import java.time.LocalDate;

public class GuardarRegistroFake implements GenerarRegistro{

    private boolean fueLlamado = false;
    private double precio;
    private LocalDate fecha;

    @Override
    public void generarRegistro(Mesa mesa, LocalDate fecha) {
            this.fueLlamado = true;
            this.precio = mesa.estraerTotaldeLaCuenta();
            this.fecha = fecha;

    }
    public boolean fueLlamado() {
        return fueLlamado;
    }

    public double getPrecio() {
        return precio;
    }
    public LocalDate getFecha() {
        return fecha;
    }
}


