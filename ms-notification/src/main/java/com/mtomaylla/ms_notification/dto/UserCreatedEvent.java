package com.mtomaylla.ms_notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreatedEvent {
    private String username;
    private String email;
    private String role;
}