package test.unr;

import org.junit.jupiter.api.Test;
import segundoo.punto.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MesaTest {
    @Test
    void test01() {

        ServicioNotificacion notificacion = new GenerarNotificacionFake();
        GenerarRegistro generarRegistro = new GenerarRegistroTxTFake();
        Mesa mesa = new Mesa(1 , 4 , null, notificacion, generarRegistro);
        Plato milanesa = new Plato("Milanesa", 100, false);
        Plato cerveza = new Plato("Cerveza", 50, true);
        mesa.agregarPlatos(milanesa);
        mesa.agregarPlatos(cerveza);
        mesa.confirmarPedido(true , Propina.CINCO);
    }
    @Test
    void test02(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GuardarRegistroFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.CINCO);
        Tarjeta tarjeta = new Viedma();

        //mesa.pagar(tarjeta);
        //Valor esperado que deberia devolver el metodo pagar
        double esperdo = 1250 ;
        assertEquals(esperdo ,mesa.pagar(tarjeta));
    }
    @Test
    void Test03(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GuardarRegistroFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.TRES);
        //test con tarjeta mastecard
        Tarjeta tarjeta = new Mastercar();

        double esperdo = 1230 ;
        assertEquals(esperdo , mesa.pagar(tarjeta));
    }
    @Test
    void Test04(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GuardarRegistroFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.CINCO);

        //Test con tarjeta visa
        Tarjeta tarjeta = new Visa();

        double esperdo = 1242.5 ;
        assertEquals(esperdo ,mesa.pagar(tarjeta));
    }
    @Test
    void Test05(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GuardarRegistroFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.CINCO);
        Tarjeta tarjeta = new ComarcaPlus();

        double esperado = 1187.5;
        assertEquals(esperado, mesa.pagar(tarjeta));
    }
    @Test
    void Test06(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GuardarRegistroFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.CINCO);

        notificacion.enviarEmail("bruno@gmail.com" , "varios" , "varios");

        //verifica que aya llamado el metodo de notificacion
        assertTrue(((GenerarNotificacionFake) notificacion).fueLlamado());
        //verifica que el destinatario sea el correcto
        String destinatario = "bruno@gmail.com" ;
        assertEquals(destinatario , ((GenerarNotificacionFake) notificacion).getDestinatario());
        //verifica que el asunto sea el correcto
        String asunto = "varios" ;
        assertEquals(asunto , ((GenerarNotificacionFake) notificacion).getAsunto());
        //verifica que el cuerpo sea el correcto
        assertEquals(asunto , ((GenerarNotificacionFake) notificacion).getCuerpo());
    }
    @Test
    void Test07(){
        ServicioNotificacion notificacion = new GenerarNotificacionFake() ;
        GenerarRegistro generarRegistro = new GenerarRegistroTxTFake();
        Mesa mesa = new Mesa( 2 ,3 ,null , notificacion, generarRegistro);
        Plato asado = new Plato("Asado", 1000, false);
        Plato agua = new Plato("Agua", 100 , true);
        Plato gaseosa = new Plato("Gaseosa", 150 , true);
        mesa.agregarPlatos(asado);
        mesa.agregarPlatos(agua);
        mesa.agregarPlatos(gaseosa);
        mesa.confirmarPedido(true , Propina.DOS);

        generarRegistro.generarRegistro(mesa , LocalDate.now());
        //verifica que aya llamado el metodo de notificacion
        assertTrue(((GenerarRegistroTxTFake) generarRegistro).fueRegistrado());

    }
}
