package ru.alexeyrand.whoistobuytelegram.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
    private String message;
    @NotBlank(message = "Имя пользователя обязателен")
    private String username;
    @NotBlank(message = "Телефон пользователя обязателен")
    private String phoneNumber;
}
