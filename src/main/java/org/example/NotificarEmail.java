package org.example;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

public class NotificarEmail {

    public void enviarNotificacionAnfitrion(String destinatario) {
        // Configuración del servidor SMTP de Mailtrap
        String host = "sandbox.smtp.mailtrap.io";
        int puerto = 587; // Puedes usar también 25, 465 o 2525
        final String usuario = "c8a6b699a18312";
        final String contrasena = "1d18b7e08077af"; // Reemplaza con la contraseña real

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // STARTTLS
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
            mensaje.setSubject("Notificación para el Anfitrión");
            mensaje.setText("¡Hola Anfitrión! Tienes una nueva reserva que revisar.");

            Transport.send(mensaje);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
