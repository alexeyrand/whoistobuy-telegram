package ru.alexeyrand.whoistobuytelegram.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
    private String message;
    private String username;
    private String phoneNumber;
}
