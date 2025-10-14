package ru.alexeyrand.whoistobuytelegram.entities;

import lombok.Data;

@Data
public class TelegramUser {
    private long userId;
    private long chatId;
}
