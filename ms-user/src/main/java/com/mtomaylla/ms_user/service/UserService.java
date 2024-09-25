package com.mtomaylla.ms_user.service;

import com.mtomaylla.ms_user.dto.UserCreatedEvent;
import com.mtomaylla.ms_user.entity.User;
import com.mtomaylla.ms_user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private RabbitTemplate rabbitTemplate;
    private UserRepository userRepository;

    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        UserCreatedEvent event = new UserCreatedEvent(savedUser.getUsername(), savedUser.getEmail(), savedUser.getRole());
        rabbitTemplate.convertAndSend("userExchange", "user.created", event);
        return savedUser;
    }
}
