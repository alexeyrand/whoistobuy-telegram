package ru.alexeyrand.whoistobuytelegram.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/store-notification")
@RequiredArgsConstructor
public class StoreNotificationRestController {

    /**
     * Создать новое объявление по имени пользователя
     * @param
     * @return
     */
    @GetMapping("/")
    public String addItemByUsername() {

        return "hello, i am telegram";
    }

}
