package ru.alexeyrand.whoistobuytelegram.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexeyrand.whoistobuytelegram.dto.CodeRequest;

@RestController
@RequestMapping("/api/v1/auth-notification")
@RequiredArgsConstructor
public class AuthNotificationRestController extends NotificationRestController {

    /**
     * Создать новое объявление по имени пользователя
     * @param
     * @return
     */
    @GetMapping("/")
    public String verifyCode(@RequestBody CodeRequest codeRequest) {

        return "hello, i am telegram";
    }

}