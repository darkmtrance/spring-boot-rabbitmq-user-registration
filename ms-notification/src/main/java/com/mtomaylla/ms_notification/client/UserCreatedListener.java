package com.mtomaylla.ms_notification.client;

import com.mtomaylla.ms_notification.config.RabbitConfig;
import com.mtomaylla.ms_notification.dto.UserCreatedEvent;
import com.mtomaylla.ms_notification.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@lombok.extern.slf4j.Slf4j
public class UserCreatedListener {

    private EmailService emailService;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void onUserCreated(UserCreatedEvent event) throws MessagingException {
        log.info("ingresa a generar email");
        emailService.sendWelcomeEmail(event.getEmail(), event.getUsername());
    }
}
