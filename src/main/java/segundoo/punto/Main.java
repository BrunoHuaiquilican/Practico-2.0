package segundoo.punto;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GenerarRegistro registroTxt = new GenerarRegistroTxT("VENTAS.txt");
        //GenerarRegistro egistroBd = new guardarRegistroBd() ;
        ServicioNotificacion notificador = new GenerarNotificacion();

        Mesa mesa = new Mesa(1, 4, Propina.TRES, notificador, registroTxt);
        Plato bebida = new Plato("Coca-Cola", 10.0, true);
        Plato platoPrincipal = new Plato("Milanesa", 20.0, false);
        // Agregar platos a la mesa
        mesa.agregarPlatos(platoPrincipal);
        mesa.agregarPlatos(bebida);

        // Confirmar el pedido y calcular total
        mesa.confirmarPedido(true , Propina.TRES);  // suponiendo que hay un método así

        double total = mesa.estraerTotaldeLaCuenta(); // suponiendo que hay un método así

        // Registrar la fecha actual y el monto de la compra
        LocalDate fechaHoy = LocalDate.now();
        registroTxt.generarRegistro(mesa, fechaHoy);

    }

}
