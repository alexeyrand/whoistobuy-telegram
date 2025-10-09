package ru.alexeyrand.whoistobuytelegram.entities;

import lombok.Data;

@Data
public class TelegramUser {
    private long userId;
    private String firstName;
    private String lastName;
    private String username;
    private long chatId;
}
