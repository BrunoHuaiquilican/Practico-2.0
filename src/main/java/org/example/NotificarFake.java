package org.example;

public class NotificarFake implements Notificacion{
    private boolean fueEnviado = false;
    private String destinatario;
    private String asunto;
    private String cuerpo;

    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        this.fueEnviado = true;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public boolean fueLlamado() {
        return fueEnviado;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public String getAsunto() {
        return asunto;
    }
    public String getCuerpo() {
        return cuerpo;
    }
}
