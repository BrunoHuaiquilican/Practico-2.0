package test.unr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segundoo.punto.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MesaTest {
    private Mesa mesa;
    private Plato bebida;
    private Plato platoPrincipal;

    @BeforeEach
    void platos() {
        mesa = new Mesa(1, 4, Propina.TRES);
        bebida = new Plato("Coca-Cola", 10.0, true);
        platoPrincipal = new Plato("Milanesa", 20.0, false);
    }

    @Test
    void testCalculoCostoConVisa() {
        mesa.agregarPlatos(bebida);
        mesa.agregarPlatos(platoPrincipal);
        mesa.confirmarPedido(true, Propina.TRES);

        Tarjeta visa = new Visa();
        double totalConDescuento = mesa.pagar(visa);

        double totalEsperado = 29.7 ;
        assertEquals(totalEsperado, totalConDescuento);
    }

    @Test
    void testCalculoCostoConMastercard() {
        mesa.agregarPlatos(bebida);
        mesa.agregarPlatos(platoPrincipal);
        mesa.confirmarPedido(true, Propina.TRES);

        Tarjeta mastercard = new Mastercar();
        double totalConDescuento = mesa.pagar(mastercard);

        double totalEsperado = 29.6;
        assertEquals(totalEsperado, totalConDescuento);
    }

    @Test
    void testCalculoCostoConComarcaPlus() {
        mesa.agregarPlatos(bebida);
        mesa.agregarPlatos(platoPrincipal);
        mesa.confirmarPedido(true, Propina.TRES);

        Tarjeta comarcaPlus = new ComarcaPlus();
        double totalConDescuento = mesa.pagar(comarcaPlus);

        double totalEsperado = 28.5;
        assertEquals(totalEsperado, totalConDescuento);
    }
    @Test
    void testCalculoCostoConViedma() {
        mesa.agregarPlatos(bebida);
        mesa.agregarPlatos(platoPrincipal);
        mesa.confirmarPedido(true, Propina.TRES);
        Tarjeta viedma = new Viedma() ;
        double totalConDescuento = mesa.pagar(viedma);
        double totalEsperado = 30.0;
        assertEquals(totalEsperado, totalConDescuento);
    }

}
