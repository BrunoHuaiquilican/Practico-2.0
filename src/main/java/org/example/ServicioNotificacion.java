package org.example;

public interface ServicioNotificacion {
    void enviarEmail(String destinatario, String asunto, String cuerpo);
}
