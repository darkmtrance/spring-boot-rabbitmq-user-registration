package com.mtomaylla.ms_store.service;

import com.mtomaylla.ms_store.dto.UserCreatedEvent;
import com.mtomaylla.ms_store.entity.Customer;
import com.mtomaylla.ms_store.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreService {
    private CustomerRepository customerRepository;

    public void addCustomer(UserCreatedEvent event) {
        Customer customer = Customer.builder().email(event.getEmail()).username(event.getUsername()).build();
        customerRepository.save(customer);
    }
}
