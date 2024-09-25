package com.mtomaylla.ms_notification.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String toEmail, String userName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(toEmail);
        helper.setSubject("Bienvenido a Nuestra Plataforma");

        String body = """
                <html>
                 <head></head>
                <body>
                <h1>¡Hola, """ + userName +
                """ 
                !</h1>
                <p>Estamos muy contentos de darte la bienvenida a nuestra plataforma.</p>
                <p>Esperamos que disfrutes de nuestros servicios y encuentres todo lo que necesitas.</p>
                <p>Si tienes alguna pregunta, no dudes en contactarnos.</p>
                <br>
                <p>Saludos cordiales,</p>
                <p>El equipo de Nuestra Plataforma</p>
                </body>
                </html>
                """;

        helper.setText(body, true);
        mailSender.send(message);
        log.info("Welcome email sent to: {}", toEmail);

    }
}