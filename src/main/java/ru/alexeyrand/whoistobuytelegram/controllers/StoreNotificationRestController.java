package ru.alexeyrand.whoistobuytelegram.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.alexeyrand.whoistobuytelegram.dto.NotificationDto;
import ru.alexeyrand.whoistobuytelegram.services.TelegramNotificationService;

@RestController
@RequestMapping("/api/v1/store-notification")
@RequiredArgsConstructor
public class StoreNotificationRestController {

    private TelegramNotificationService telegramNotificationService;

    /**
     * Отправить уведомление о новом объявлении по имени пользователя
     */
    @PostMapping("/")
    public String postItemNotification(@Valid @RequestBody NotificationDto notificationDto) {
        String username = notificationDto.getUsername();
        telegramNotificationService.sendNotification(username);
        return "test return";
    }

}
