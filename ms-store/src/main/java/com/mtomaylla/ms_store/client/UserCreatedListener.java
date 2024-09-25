package com.mtomaylla.ms_store.client;

import com.mtomaylla.ms_store.config.RabbitConfig;
import com.mtomaylla.ms_store.dto.UserCreatedEvent;
import com.mtomaylla.ms_store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserCreatedListener {

    private StoreService storeService;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void onUserCreated(UserCreatedEvent event) {
        storeService.addCustomer(event);
    }
}
