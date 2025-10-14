package ru.alexeyrand.whoistobuytelegram.entities;

import lombok.Data;
import ru.alexeyrand.whoistobuybase.entities.BaseEntity;

@Data
public class TelegramUser extends BaseEntity {
    private long username;
    private long chatId;
}
