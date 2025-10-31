package ru.alexeyrand.whoistobuytelegram.entities;

import ru.alexeyrand.whoistobuybase.entities.BaseEntity;

public class TelegramNotification extends BaseEntity {
    String message;
    Long chatId;

}
