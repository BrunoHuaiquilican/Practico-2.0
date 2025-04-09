package org.example;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Notidicacion implements ServicioNotificacion {

    public void enviarEmail(String destinatario, String asunto, String cuerpo) {
        String host = "sandbox.smtp.mailtrap.io";
        int puerto = 587;
        final String usuario = "c8a6b699a18312";
        final String contrasena = "1d18b7e08077af";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contrasena);
            }
        });

        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress("hotel@ejemplo.com"));
            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            Transport.send(mensaje);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
