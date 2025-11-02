package ru.alexeyrand.whoistobuytelegram.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexeyrand.whoistobuytelegram.dto.CodeRequest;
import ru.alexeyrand.whoistobuytelegram.dto.NotificationDto;

@RestController
@RequestMapping("/api/v1/auth-notification")
@RequiredArgsConstructor
public class AuthNotificationRestController {

    /**
     * Создать новое объявление по имени пользователя
     */
    @GetMapping("/")
    public String verifyCode(@RequestBody NotificationDto notificationDto) {
        String username = notificationDto.getUsername();

        return "hello, i am telegram";
    }

}